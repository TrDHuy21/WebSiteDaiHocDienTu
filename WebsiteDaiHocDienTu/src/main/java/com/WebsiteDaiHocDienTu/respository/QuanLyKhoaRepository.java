package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.KhoaEntity;
import com.WebsiteDaiHocDienTu.model.entity.QuanLyKhoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuanLyKhoaRepository extends JpaRepository<QuanLyKhoaEntity,String> {


    @Query("SELECT k.khoa.id FROM QuanLyKhoaEntity k where k.user.id = :userId")
    Optional<Integer> findKhoaIdByUserId(Integer userId);

    Optional<QuanLyKhoaEntity> findByUserId(Integer userId);
}
