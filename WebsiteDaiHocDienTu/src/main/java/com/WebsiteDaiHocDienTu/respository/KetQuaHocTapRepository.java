package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.KetQuaHocTapEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTapEntity, Integer> {

    @EntityGraph(attributePaths = "monHoc")
    List<KetQuaHocTapEntity> findAllByQuaTrinhHocTapSinhVienId(String id);

}
