package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.GetListChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.entity.ChuongTrinhHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChuongTrinhHocRepository extends JpaRepository<ChuongTrinhHocEntity,Integer> {

    List<ChuongTrinhHocEntity> findAllByNganh_IdAndState(Integer nganhId, byte state);


}
