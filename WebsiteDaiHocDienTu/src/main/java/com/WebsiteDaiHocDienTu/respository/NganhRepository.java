package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.NganhEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NganhRepository extends JpaRepository<NganhEntity,Integer> {
    List<NganhEntity> findAllByStateAndKhoa_Id(byte state,Integer khoaId);
    Optional<NganhEntity> findByIdAndStateAndKhoaId(Integer nganhId, byte state, Integer khoaId);
}
