package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.ChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.AddAndUpdateChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.GetListChuongTrinhHocDTO;

import java.util.List;

public interface ChuongTrinhHocService {

    List<GetListChuongTrinhHocDTO> findAllByNganhIdBelongsKhoa(Integer nganhId);

    AddAndUpdateChuongTrinhHocDTO save(Integer nganhId,AddAndUpdateChuongTrinhHocDTO chuongTrinhHocDTO);

    AddAndUpdateChuongTrinhHocDTO findById(Integer id);

    AddAndUpdateChuongTrinhHocDTO addMonHocs(Integer nganhId,Integer chuongTrinhHocId, List<Integer> monHocIds);

    void  removeMonHoc(Integer nganhId,Integer chuongTrinhHocId,List<Integer> monHocIds);

}
