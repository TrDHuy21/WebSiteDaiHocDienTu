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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "thu")
    private Integer thu;

    @Column(name = "tiet_bat_dau")
    private Integer tietBatDau;

    @Column(name = "so_tiet")
    private Integer soTiet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lop_mon_hoc_id")
    private LopMonHocEntity lopMonHoc;
}
