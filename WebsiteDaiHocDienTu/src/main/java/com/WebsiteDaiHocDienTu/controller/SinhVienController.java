package com.WebsiteDaiHocDienTu.controller;

import com.WebsiteDaiHocDienTu.model.dto.SinhVienDTO;
import com.WebsiteDaiHocDienTu.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @PostMapping("/sinhvien")
    public ResponseEntity<?> createSinhVien(@RequestBody SinhVienDTO sinhVienDTO) {
        return sinhVienService.save(sinhVienDTO);
    }
}
