package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;

import java.util.List;

public interface LopMonHocService {
    List<LopMonHocEntity> getAllByQLK();

    LopMonHocEntity findById(int lopMonHocId);

    void save(LopMonHocEntity monHocEntity);

    void addThoiKhoaBieu(int lopMonHocid);

    void changeGiangVien(LopMonHocEntity lopMonHocEntity, String newGiangVienId);

    void deleteById(int id);

    void addSinhVien(LopMonHocEntity lopMonHocEntity, String newSinhVienId);

//    void deleteSinhVienById(LopMonHocEntity lopMonHocEntity, String sinhVienId);

    void addMonHoc(LopMonHocEntity lopMonHocEntity, int newMonHocId);

    void create(LopMonHocEntity lopMonHoc);

    void deleteQuaTrinhHocTapById(int quaTrinhHocTapId);

    void saveKetQuaHocTap(LopMonHocEntity lopMonHoc);
}
