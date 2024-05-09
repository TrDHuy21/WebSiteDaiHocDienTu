package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.request.nganh.CreateAndUpdateNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetListNganhDTO;

import java.util.List;

public interface NganhService {
    List<GetListNganhDTO> findAllByQLK(Integer userId);
    CreateAndUpdateNganhDTO createNganh(Integer userId, CreateAndUpdateNganhDTO nganhDTO);

    CreateAndUpdateNganhDTO updateNganh(Integer userId, CreateAndUpdateNganhDTO nganhDTO);
    CreateAndUpdateNganhDTO findById(Integer userId, Integer nganhId);


}
