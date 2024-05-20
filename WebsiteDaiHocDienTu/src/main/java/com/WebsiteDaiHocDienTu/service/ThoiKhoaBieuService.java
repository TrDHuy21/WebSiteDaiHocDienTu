package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;

public interface ThoiKhoaBieuService {
    void deleteById(int id);
    ThoiKhoaBieuEntity findById(int id);
}
