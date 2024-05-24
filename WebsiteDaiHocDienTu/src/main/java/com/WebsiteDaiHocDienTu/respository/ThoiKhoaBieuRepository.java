package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ThoiKhoaBieuRepository extends JpaRepository<ThoiKhoaBieuEntity, Integer> {
    @Query("from LopMonHocEntity as lmh " +
            "where " +
                "lmh.giangVien.id= :giangVienId and " +
                "lmh.ngayBatDau <= :end")
    List<LopMonHocEntity> thoiKhoaBieuForGiangVien(String giangVienId, LocalDate end);
}
