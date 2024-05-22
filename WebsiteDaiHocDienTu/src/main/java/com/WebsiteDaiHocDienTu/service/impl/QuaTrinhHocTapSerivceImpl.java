package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.entity.KetQuaHocTapEntity;
import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.QuaTrinhHocTapEntity;
import com.WebsiteDaiHocDienTu.model.entity.SinhVienEntity;
import com.WebsiteDaiHocDienTu.respository.QuaTrinhHocTapRepository;
import com.WebsiteDaiHocDienTu.service.QuaTrinhHocTapService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuaTrinhHocTapSerivceImpl implements QuaTrinhHocTapService {

    private QuaTrinhHocTapRepository quaTrinhHocTapRepository;
    @Override
    public void create(LopMonHocEntity lopMonHocEntity, SinhVienEntity sinhVienEntity) {
        QuaTrinhHocTapEntity quaTrinhHocTap = new QuaTrinhHocTapEntity();
        quaTrinhHocTap.setSinhVien(sinhVienEntity);
        quaTrinhHocTap.setKetQuaHocTap(new KetQuaHocTapEntity());
        quaTrinhHocTap.setLopMonHoc(lopMonHocEntity);
        quaTrinhHocTapRepository.save(quaTrinhHocTap);
    }
}
