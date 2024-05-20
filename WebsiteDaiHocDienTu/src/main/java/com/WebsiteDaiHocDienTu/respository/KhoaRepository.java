package com.WebsiteDaiHocDienTu.respository;

import com.WebsiteDaiHocDienTu.model.entity.KhoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KhoaRepository extends JpaRepository<KhoaEntity,Integer> {

    @Query("select k from KhoaEntity k " +
            "join fetch k.monHocList " +
            "where k.id = :id")
    Optional<KhoaEntity> findKhoaByIdWithmonHocList(@Param("id") Integer id);

    @Query("select k from KhoaEntity k " +
            "left join QuanLyKhoaEntity q on k.id = q.khoa.id" +
            " inner join UserEntity  u on q.user.id = u.id where u.id = :id")
    Optional<KhoaEntity> findByUserId(Long id);

}
