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
@Table(name = "khoa")
public class KhoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private  String moTa;

    @OneToMany(mappedBy = "khoaEntity")
    private List<QuanLyKhoaEntity> quanLyKhoaEntityList;

    @OneToMany(mappedBy = "khoaEntity")
    private List<GiangVienEntity> giangVienEntityList;

    @OneToMany(mappedBy = "khoaEntity")
    private List<NganhEntity> nganhEntityList;

    @OneToMany(mappedBy = "khoaEntity")
    private List<MonHocEntity> monHocEntityList;


}
