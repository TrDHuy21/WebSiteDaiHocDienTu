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
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "state")
    private  Byte state;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private NganhEntity nganh;

    @ManyToMany
    @JoinTable (
            name="monhoc_chuongtrinhhoc",
            joinColumns=@JoinColumn(name="chuong_trinh_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="mon_hoc_id")
    )
    private List<MonHocEntity> monHocList;

    @OneToMany(mappedBy = "chuongTrinhHoc")
    private List<LopChinhQuyEntity> lopChinhQuyList;
}
