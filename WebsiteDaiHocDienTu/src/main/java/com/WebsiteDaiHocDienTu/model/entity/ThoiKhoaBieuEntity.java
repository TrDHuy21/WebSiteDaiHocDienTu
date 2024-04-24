package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "thoi_khoa_bieu")
public class ThoiKhoaBieuEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "so_tiet")
    private int soTiet;

    @Column(name = "tiet_bat_dau")
    private int tietBatDau;

    @ManyToOne
    @JoinColumn(name = "lop_mon_hoc_id")
    private LopMonHocEntity lopMonHocEntity;
}
