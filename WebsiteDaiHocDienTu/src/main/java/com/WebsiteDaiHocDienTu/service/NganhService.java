package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.request.nganh.CreateAndUpdateNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetListNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetNganhManagerChuongTrinhHocDTO;

import java.util.List;

public interface NganhService {
    List<GetListNganhDTO> findAllByQLK(Long userId);
    CreateAndUpdateNganhDTO createNganh(Long userId, CreateAndUpdateNganhDTO nganhDTO);

    CreateAndUpdateNganhDTO updateNganh(Long userId, CreateAndUpdateNganhDTO nganhDTO);
    CreateAndUpdateNganhDTO findById(Long userId, Integer nganhId);
    List<GetNganhManagerChuongTrinhHocDTO> findAllNganhByQLK(Long userId);


}
