package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.respository.GiangVienRepository;
import com.WebsiteDaiHocDienTu.respository.LopMonHocRepository;
import com.WebsiteDaiHocDienTu.service.GiangVienService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GiangVienServiceImpl implements GiangVienService {
    private GiangVienRepository giangVienRepository;
    private LopMonHocRepository lopMonHocRepository;

    @Override
    public List<LopMonHocEntity> findAllByGiangVien() {
        String giangVienId = SecurityUtils.getPrinciple().getUserName();
        return lopMonHocRepository.findAllByGiangVien_Id(giangVienId);
    }
}
