package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.SinhVienDTO;
import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.sinhvien.KetQuaHocTapRequestDTO;
import com.WebsiteDaiHocDienTu.respository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SinhVienService {

    ResponseEntity<?> save(SinhVienDTO sinhVienDTO);

}
