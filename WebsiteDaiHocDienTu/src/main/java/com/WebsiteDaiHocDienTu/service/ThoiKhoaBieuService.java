package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.request.thoiKhoaBieu.ThoiKhoaBieuDTO;
import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;

import java.time.LocalDate;
import java.util.List;

public interface ThoiKhoaBieuService {
    void deleteById(int id);
    ThoiKhoaBieuEntity findById(int id);

    List<ThoiKhoaBieuDTO> getThoiKhoaBieuForGiangVien(String giangVienId, LocalDate start, LocalDate end) throws Exception;
}
