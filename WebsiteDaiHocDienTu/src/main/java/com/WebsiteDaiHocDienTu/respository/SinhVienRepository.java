package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SinhVienRepository extends JpaRepository<SinhVienEntity, String> {
    Optional<SinhVienEntity> findByUserId(Long userId);
}
