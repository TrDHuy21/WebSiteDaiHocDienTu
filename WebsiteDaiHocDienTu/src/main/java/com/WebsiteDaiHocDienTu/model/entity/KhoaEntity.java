package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khoa")
@ToString
public class KhoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private  String moTa;

    @Column(name = "state")
    private Byte state;

    @OneToMany(mappedBy = "khoa")
    private List<QuanLyKhoaEntity> quanLyKhoaList;

    @OneToMany(mappedBy = "khoa")
    private List<GiangVienEntity> giangVienList;

    @OneToMany(mappedBy = "khoa")
    private List<NganhEntity> nganhList;

    @OneToMany(mappedBy = "khoa")
    private List<MonHocEntity> monHocList;

    @OneToMany(mappedBy = "khoa")
    private List<LopMonHocEntity> lopMonHocList;


}
