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
@Table(name = "lop_chinh_quy")
public class LopChinhQuyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "khoa")
    private int khoa;

    @Column(name = "state")
    private  Byte state;

    @ManyToOne
    @JoinColumn(name = "chuong_trinh_hoc_id")
    private ChuongTrinhHocEntity chuongTrinhHocEntity;

    @OneToMany(mappedBy = "lopChinhQuyEntity")
    private List<SinhVienEntity> sinhVienEntityList;
}
