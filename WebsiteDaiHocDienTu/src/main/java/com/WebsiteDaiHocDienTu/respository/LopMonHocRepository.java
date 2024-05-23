package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LopMonHocRepository extends JpaRepository<LopMonHocEntity, Integer> {
    List<LopMonHocEntity> findAllByKhoa_IdOrderByStateDesc(Integer khoaId);
    Optional<LopMonHocEntity> findByIdAndKhoaId(Integer monHocId, Integer khoaId);

    List<LopMonHocEntity> findAllByGiangVien_Id(String giangVienId);
}
