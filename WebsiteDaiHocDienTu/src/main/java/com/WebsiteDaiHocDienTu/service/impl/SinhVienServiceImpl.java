package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.dto.SinhVienDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.sinhvien.KetQuaHocTapRequestDTO;
import com.WebsiteDaiHocDienTu.model.entity.KetQuaHocTapEntity;
import com.WebsiteDaiHocDienTu.model.entity.SinhVienEntity;
import com.WebsiteDaiHocDienTu.respository.SinhVienRepository;
import com.WebsiteDaiHocDienTu.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Override
    public ResponseEntity<?> save(SinhVienDTO sinhVienDTO) {
        SinhVienEntity sv = new SinhVienEntity();
        sv.setState(sinhVienDTO.getState());
        sinhVienRepository.save(sv);
        return ResponseEntity.ok(sv);
    }
}
