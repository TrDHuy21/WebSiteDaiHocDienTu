package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.request.sinhvien.KetQuaHocTapRequestDTO;

import java.util.List;

public interface KetQuaHocTapService {
    List<KetQuaHocTapRequestDTO> findAllBySinhVienId(Long id);
}
