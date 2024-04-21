package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ketquahoctap")
public class KetQuaHocTapEntity {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id")
    private UserEntity sinhVien;

    @ManyToOne
    @JoinColumn(name =  "monhoc_id")
    private MonHocEntity monHocEntity;

    @OneToMany(mappedBy = "ketQuaHocTapEntity")
    private List<DiemGiuaKiEntity> diemGiuaKiEntityList;

    @OneToMany(mappedBy = "ketQuaHocTapEntity")
    private List<DiemThuongXuyenEntity> diemThuongXuyenEntityList;

    @OneToMany(mappedBy = "ketQuaHocTapEntity")
    private List<DiemThiEntity> diemThiEntityList;
}
