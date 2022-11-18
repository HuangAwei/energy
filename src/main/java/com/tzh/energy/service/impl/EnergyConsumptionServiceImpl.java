package com.tzh.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzh.energy.entity.*;
import com.tzh.energy.mapper.*;
import com.tzh.energy.service.EnergyConsumptionService;
import com.tzh.energy.vo.Energy;
import com.tzh.energy.vo.EnergyConsumptionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EnergyConsumptionServiceImpl implements EnergyConsumptionService {

    @Resource
    public EnergyInstitutionMapper energyInstitutionMapper;
    @Resource
    public EnergyTypeMapper energyTypeMapper;
    @Resource
    public InstitutionsTypeMapper institutionsTypeMapper;
    @Resource
    public InstitutionsMapper institutionsMapper;
    @Resource
    public EnergyConsumptionMapper energyConsumptionMapper;

    @Override
    public Map<String, Double> getEnergyConsumption(EnergyConsumptionVo energyConsumptionVo) {
        Map<String,Double> result = new HashMap<>();
        Double E,Emz,Emd,Erz;
        AtomicReference<Double> Ei = new AtomicReference<>(0d);
        List<Energy> energyList = energyConsumptionVo.getEnergyList();
        if (energyList == null){
            return null;
        }
        energyList.forEach(item ->{
            EnergyType energyType = energyTypeMapper.selectById(item.getEnergyId());
            Ei.updateAndGet(v -> v + energyType.getP() * item.getValue());
        });
        E = Ei.get();
        Emz = E/energyConsumptionVo.getM();
        Emd = energyConsumptionVo.getEd()/energyConsumptionVo.getM();
        Erz = E/energyConsumptionVo.getN();
        Institutions institutions = institutionsMapper.selectById(energyConsumptionVo.getInstitutionId());
        InstitutionsType institutionsType = institutionsTypeMapper.selectById(institutions.getType());
        if (institutionsType.getQ0() == null && (energyConsumptionVo.getT() > institutionsType.getT0() || energyConsumptionVo.getM() / energyConsumptionVo.getN() > institutionsType.getS0())){
            Double T,S;
            T = energyConsumptionVo.getT() > institutionsType.getT0() ? energyConsumptionVo.getT() : institutionsType.getT0();
            S = energyConsumptionVo.getM() / energyConsumptionVo.getN() > institutionsType.getS0() ? energyConsumptionVo.getM() / energyConsumptionVo.getN() : institutionsType.getS0();
            if ("党政机关".equals(institutionsType.getName())){
                Emz = Emz*(0.3 + 0.7 * (T / institutionsType.getT0())) * (0.7 + 0.3 * (S / institutionsType.getS0()));
            }else {
                Emz = Emz*(0.3 + 0.7 * (institutionsType.getT0() / T)) * (0.7 + 0.3 * (S / institutionsType.getS0()));
            }
            Emd = Emd*(0.3 + 0.7 * (institutionsType.getT0() / T)) * (0.7 + 0.3 * (S / institutionsType.getS0()));
            Erz = Erz*(0.22 + 0.78 * (institutionsType.getT0() / T)) * (0.78 + 0.22 * (S / institutionsType.getS0()));
        }else if (institutionsType.getQ0() != null && (energyConsumptionVo.getQ() > institutionsType.getQ0() || energyConsumptionVo.getM() / energyConsumptionVo.getN() > institutionsType.getS0())) {
            Double Q,S;
            Q = energyConsumptionVo.getQ() > institutionsType.getQ0() ? energyConsumptionVo.getQ() : institutionsType.getQ0();
            S = energyConsumptionVo.getM() / energyConsumptionVo.getN() > institutionsType.getS0() ? energyConsumptionVo.getM() / energyConsumptionVo.getN() : institutionsType.getS0();
            Emz = Emz*(0.78 + 0.22 * (Q / institutionsType.getQ0())) * (0.88 + 0.12 * (S / institutionsType.getS0()));
            Emd = Emd*(0.78 + 0.22 * (Q / institutionsType.getQ0())) * (0.88 + 0.12 * (S / institutionsType.getS0()));
            Erz = Erz*(0.49 + 0.51 * (Q / institutionsType.getQ0())) * (0.82 + 0.18 * (S / institutionsType.getS0()));
        }
        result.put("E",E);
        result.put("Emz",Emz);
        result.put("Emd",Emd);
        result.put("Erz",Erz);
        save(energyConsumptionVo,result);
        return result;
    }

    @Override
    public boolean existHistory(Integer id, String year) {
        return energyInstitutionMapper.existHistory(id,year) > 0;
    }

    @Override
    public Page<Map<String,Object>> page(Map<String, Object> params) {
        int current = 1, size = 10;
        String name = null;
        if (params.containsKey("current") && params.get("current") != ""){
            current = Integer.parseInt((String) params.get("current"));
        }
        if (params.containsKey("size") && params.get("size") != ""){
            size = Integer.parseInt((String) params.get("size"));
        }
        if (params.containsKey("name") && params.get("current") != ""){
            name = "%" + params.get("name") + "%";
        }
        Page<Map<String,Object>> page = new Page<>(current, size);
        List<Map<String, Object>> history = energyConsumptionMapper.getHistory(page,name, (String) params.get("date"));
        page.setRecords(history);
        return page;
    }

    @Override
    public List<Map<String, String>> getEnergyByInstitutionId(Integer institutionId, String date) {
        List<Map<String, String>> list = energyInstitutionMapper.getEnergyByInstitutionId(institutionId,date);
        return list;
    }

    @Override
    public boolean remove(Integer institutionId, String date) {
        QueryWrapper<EnergyInstitution> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("institution_id",institutionId);
        wrapper1.eq("date",date);
        energyInstitutionMapper.delete(wrapper1);
        QueryWrapper<EnergyConsumption> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("institution_id",institutionId);
        wrapper2.eq("date",date);
        return energyConsumptionMapper.delete(wrapper2) > 0;
    }


    public void save(EnergyConsumptionVo energyConsumptionVo,Map<String,Double> map){
        EnergyConsumption energyConsumption = new EnergyConsumption();
        energyConsumption.setInstitutionId(energyConsumptionVo.getInstitutionId());
        energyConsumption.setE(map.get("E"));
        energyConsumption.setEmz(map.get("Emz"));
        energyConsumption.setEmd(map.get("Emd"));
        energyConsumption.setErz(map.get("Erz"));
        energyConsumption.setM(energyConsumptionVo.getM());
        energyConsumption.setEd(energyConsumptionVo.getEd());
        energyConsumption.setN(energyConsumptionVo.getN());
        energyConsumption.setT(energyConsumptionVo.getT());
        energyConsumption.setQ(energyConsumptionVo.getQ());
        energyConsumption.setDate(energyConsumptionVo.getDate());
        energyConsumptionMapper.insert(energyConsumption);
        List<Energy> energyList = energyConsumptionVo.getEnergyList();
        energyList.forEach(item -> {
            EnergyInstitution energyInstitution = new EnergyInstitution();
            energyInstitution.setEnergyId(item.getEnergyId());
            energyInstitution.setInstitutionId(energyConsumptionVo.getInstitutionId());
            energyInstitution.setValue(item.getValue());
            energyInstitution.setDate(energyConsumptionVo.getDate());
            energyInstitutionMapper.insert(energyInstitution);
        });
    }

}
