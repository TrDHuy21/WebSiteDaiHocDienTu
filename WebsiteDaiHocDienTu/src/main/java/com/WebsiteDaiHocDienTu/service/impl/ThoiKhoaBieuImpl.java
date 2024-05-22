package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;
import com.WebsiteDaiHocDienTu.respository.ThoiKhoaBieuRepository;
import com.WebsiteDaiHocDienTu.service.ThoiKhoaBieuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ThoiKhoaBieuImpl implements ThoiKhoaBieuService {

    ThoiKhoaBieuRepository thoiKhoaBieuRepository;

    @Override
    public void deleteById(int id) {
        thoiKhoaBieuRepository.deleteById(id);
    }

    @Override
    public ThoiKhoaBieuEntity findById(int id) {
        return null;
    }
}
