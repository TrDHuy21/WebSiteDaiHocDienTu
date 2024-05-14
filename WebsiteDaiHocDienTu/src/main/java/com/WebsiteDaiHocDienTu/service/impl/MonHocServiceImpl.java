package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.KhoaEntity;
import com.WebsiteDaiHocDienTu.model.entity.MonHocEntity;
import com.WebsiteDaiHocDienTu.respository.MonHocRepository;
import com.WebsiteDaiHocDienTu.respository.QuanLyKhoaRepository;
import com.WebsiteDaiHocDienTu.service.MonHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonHocServiceImpl implements MonHocService {


    private final QuanLyKhoaRepository quanLyKhoaRepository;
    private final MonHocRepository monHocRepository;

    @Override
    public List<MonHocEntity> findAllByQLK() {
        Integer khoaId = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();

        return monHocRepository.findAllByKhoa_IdOrderByStateDesc(khoaId);
    }

    @Override
    public MonHocEntity save(MonHocEntity monHocEntity) {
        return  monHocRepository.save(monHocEntity);
    }

    @Override
    public MonHocEntity findByIdAndKhoaId(Integer monHocId) {
        Integer khoaId = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        MonHocEntity monHocEntity = monHocRepository.findByIdAndKhoaId(monHocId, khoaId)
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"));
        return monHocEntity;
    }

    @Override
    public MonHocEntity getNewMonHocWithKhoa() {
        KhoaEntity khoaEntity = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa();
        MonHocEntity monHocEntity = new MonHocEntity();
        monHocEntity.setKhoa(khoaEntity);

        return monHocEntity;
    }

    @Override
    public void deleteById(int id) {
        Integer idKhoa = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        MonHocEntity monHocEntity = monHocRepository.findByIdAndKhoaId(id, idKhoa)
                .orElseThrow(()-> new NullPointerException("Mon hoc not found"));
        monHocEntity.setState((byte)0);
        monHocRepository.save(monHocEntity);
    }
}
