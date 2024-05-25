package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LopMonHocRepository extends JpaRepository<LopMonHocEntity, Integer> {
    List<LopMonHocEntity> findAllByKhoa_IdOrderByStateDesc(Integer khoaId);
    Optional<LopMonHocEntity> findByIdAndKhoaId(Integer monHocId, Integer khoaId);

    List<LopMonHocEntity> findAllByGiangVien_Id(String giangVienId);
    @Query("from LopMonHocEntity as lmh " +
            "where " +
            "lmh.giangVien.id= :giangVienId and " +
            "lmh.ngayBatDau <= :end")
    List<LopMonHocEntity> thoiKhoaBieuForGiangVien(String giangVienId, LocalDate end);

    @Query("from QuaTrinhHocTapEntity qtht " +
            "where " +
                "qtht.sinhVien.id = :sinhVienId and " +
                "qtht.lopMonHoc.ngayBatDau <= :end ")
    List<LopMonHocEntity> thoiKhoaBieuForSinhVien(String sinhVienId, LocalDate end);
}
