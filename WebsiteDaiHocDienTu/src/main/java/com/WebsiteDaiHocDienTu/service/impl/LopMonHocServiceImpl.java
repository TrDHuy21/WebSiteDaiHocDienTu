package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.*;
import com.WebsiteDaiHocDienTu.respository.*;
import com.WebsiteDaiHocDienTu.service.LopMonHocService;
import com.WebsiteDaiHocDienTu.service.QuaTrinhHocTapService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LopMonHocServiceImpl implements LopMonHocService {

    LopMonHocRepository lopMonHocRepository;
    QuanLyKhoaRepository quanLyKhoaRepository;
    ThoiKhoaBieuRepository thoiKhoaBieuRepository;
    GiangVienRepository giangVienRepository;
    SinhVienRepository sinhVienRepository;
    MonHocRepository monHocRepository;
    QuaTrinhHocTapRepository quaTrinhHocTapRepository;

    QuaTrinhHocTapService quaTrinhHocTapService;

    @Override
    public List<LopMonHocEntity> getAllByQLK() {
        Integer khoaId = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        return lopMonHocRepository.findAllByKhoa_IdOrderByStateDesc(khoaId);
    }

    @Override
    public LopMonHocEntity findById(int lopMonHocId) {
        LopMonHocEntity lopMonHocEntity = lopMonHocRepository.findById(lopMonHocId)
                .orElseThrow(()-> new NullPointerException("Lop mon hoc not found"));
        return lopMonHocEntity;
    }

    @Override
    public void save(LopMonHocEntity monHocEntity) {
        lopMonHocRepository.save(monHocEntity);
    }

    @Override
    public void addThoiKhoaBieu(int lopMonHocid) {
        LopMonHocEntity lopMonHocEntity =  lopMonHocRepository.findById(lopMonHocid)
                .orElseThrow(()-> new NullPointerException("Lop mon hoc not found"));
        ThoiKhoaBieuEntity thoiKhoaBieuEntity = new ThoiKhoaBieuEntity();
        thoiKhoaBieuEntity.setLopMonHoc(lopMonHocEntity);
        thoiKhoaBieuRepository.save(thoiKhoaBieuEntity);
        lopMonHocRepository.save(lopMonHocEntity);
    }

    @Override
    public void changeGiangVien(LopMonHocEntity lopMonHocEntity, String newGiangVienId) {
        GiangVienEntity giangVien = giangVienRepository.findById(newGiangVienId)
                .orElseThrow(()-> new NullPointerException("Giang vien hoc not found"));
        lopMonHocEntity.setGiangVien(giangVien);
        lopMonHocRepository.save(lopMonHocEntity);
    }

    @Override
    public void deleteById(int id) {
        lopMonHocRepository.deleteById(id);
    }

    @Override
    public void addSinhVien(LopMonHocEntity lopMonHocEntity, String newSinhVienId) {
        SinhVienEntity sinhVienEntity = sinhVienRepository.findById(newSinhVienId)
                .orElseThrow(()-> new NullPointerException("Sinh vien not found"));
        quaTrinhHocTapService.create(lopMonHocEntity, sinhVienEntity);
    }

    @Override
    public void addMonHoc(LopMonHocEntity lopMonHocEntity, int newMonHocId) {
        MonHocEntity monHoc = monHocRepository.findById(newMonHocId)
                .orElseThrow(() -> new NullPointerException("Mon hoc not found"));
        lopMonHocEntity.setMonHoc(monHoc);
        lopMonHocRepository.save(lopMonHocEntity);
    }

    @Override
    public void create(LopMonHocEntity lopMonHoc) {
        KhoaEntity khoa = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa();
        lopMonHoc.setKhoa(khoa);
        lopMonHocRepository.save(lopMonHoc);
    }

    @Override
    public void deleteQuaTrinhHocTapById(int quaTrinhHocTapId) {
        quaTrinhHocTapRepository.deleteById(quaTrinhHocTapId);
    }
}
