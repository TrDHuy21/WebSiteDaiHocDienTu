package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuaTrinhHocTapService  {
    void create(LopMonHocEntity lopMonHocEntity, SinhVienEntity sinhVienEntity);
}
