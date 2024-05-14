package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.MonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.NganhEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonHocRepository extends JpaRepository<MonHocEntity, Integer> {
    List<MonHocEntity> findAllByKhoa_IdOrderByStateDesc( Integer khoaId);
    Optional<MonHocEntity> findByIdAndKhoaId(Integer monHocId, Integer khoaId);
}
