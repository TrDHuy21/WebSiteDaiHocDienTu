package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.request.monhoc.AddMonHocForChuongTrinhHoc;
import com.WebsiteDaiHocDienTu.model.entity.MonHocEntity;

import java.util.List;

public interface MonHocService {
    List<MonHocEntity> findAllByQLK();

    MonHocEntity save(MonHocEntity monHocEntity);

    MonHocEntity findByIdAndKhoaId(Integer monHocId);

    MonHocEntity getNewMonHocWithKhoa();

    void deleteById(int id);

    void addGiangVien(int monHocId, String giangVienId);

    void deleteGiangVien(int monHocId, String giangVienId);

    List<AddMonHocForChuongTrinhHoc> findAllByMonHocIdNotIn(Integer chuongTrinhHocId);
    List<AddMonHocForChuongTrinhHoc> findAllByMonHocIn(Integer chuongTrinhHocId);
}
