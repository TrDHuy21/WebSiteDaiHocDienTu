package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.respository.LopMonHocRepository;
import com.WebsiteDaiHocDienTu.respository.QuanLyKhoaRepository;
import com.WebsiteDaiHocDienTu.service.LopMonHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LopMonHocServiceImpl implements LopMonHocService {

    LopMonHocRepository lopMonHocRepository;
    QuanLyKhoaRepository quanLyKhoaRepository;

    @Override
    public List<LopMonHocEntity> getAllByQLK() {
        Integer khoaId = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        return lopMonHocRepository.findAllByKhoa_IdOrderByStateDesc(khoaId);
    }
}
