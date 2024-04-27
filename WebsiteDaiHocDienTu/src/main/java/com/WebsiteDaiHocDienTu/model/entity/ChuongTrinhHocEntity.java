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
@Table(name = "chuong_trinh_hoc")
public class ChuongTrinhHocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "state")
    private  Byte state;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private NganhEntity nganhEntity;

    @ManyToMany
    @JoinTable (
            name="monhoc_chuongtrinhhoc",
            joinColumns=@JoinColumn(name="chuong_trinh_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="mon_hoc_id")
    )
    private List<MonHocEntity> monHocEntityList;

    @OneToMany(mappedBy = "chuongTrinhHocEntity")
    private List<LopChinhQuyEntity> lopChinhQuyEntityList;
}
