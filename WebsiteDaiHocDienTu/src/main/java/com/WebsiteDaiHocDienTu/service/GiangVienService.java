package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;

import java.util.List;

public interface GiangVienService {
    List<LopMonHocEntity> findAllByGiangVien();
}
