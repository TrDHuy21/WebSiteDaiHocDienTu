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
@Table(name = "chuongtrinhhoc")
public class ChuongTrinhHocEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private NganhEntity nganhEntity;

    @ManyToMany
    @JoinTable (
            name="monhoc_chuongTrinhHoc",
            joinColumns=@JoinColumn(name="chuongtrinhhoc_id"),
            inverseJoinColumns=@JoinColumn(name="monhoc_id")
    )
    private List<MonHocEntity> monHocEntityList;

    @OneToMany(mappedBy = "chuongTrinhHocEntity")
    private List<LopChinhQuyEntity> lopChinhQuyEntityList;
}
