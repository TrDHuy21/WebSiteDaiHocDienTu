package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.mapper.DataMapper;
import com.WebsiteDaiHocDienTu.model.dto.request.sinhvien.KetQuaHocTapRequestDTO;
import com.WebsiteDaiHocDienTu.model.entity.KetQuaHocTapEntity;
import com.WebsiteDaiHocDienTu.model.entity.SinhVienEntity;
import com.WebsiteDaiHocDienTu.respository.KetQuaHocTapRepository;
import com.WebsiteDaiHocDienTu.respository.SinhVienRepository;
import com.WebsiteDaiHocDienTu.service.KetQuaHocTapService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
@Service
public class KetQuaHocTapServiceImpl implements KetQuaHocTapService {

    KetQuaHocTapRepository ketQuaHocTapRepository;
    SinhVienRepository sinhVienRepository;
    @Override
    public List<KetQuaHocTapRequestDTO> findAllBySinhVienId(Long id) {
        SinhVienEntity sinhVien = sinhVienRepository.findByUserId(id).orElseThrow();
        List<KetQuaHocTapEntity> list = ketQuaHocTapRepository.findAllByQuaTrinhHocTapSinhVienId(sinhVien.getId());
        return list.stream().map(entity -> DataMapper.toDTO(entity, KetQuaHocTapRequestDTO.class)).toList();
    }
}
