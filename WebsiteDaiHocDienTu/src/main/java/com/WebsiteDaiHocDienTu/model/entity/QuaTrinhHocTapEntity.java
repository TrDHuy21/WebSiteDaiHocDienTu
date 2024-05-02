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
@Table(name = "qua_trinh_hoc_tap")
public class QuaTrinhHocTapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "so_tiet_nghi")
    private int soTietNghi;

    @ManyToOne
    @JoinColumn(name = "sinh_vien_id")
    private SinhVienEntity sinhVienEntity;

    @ManyToOne
    @JoinColumn(name = "lop_mon_hoc_id")
    private LopMonHocEntity lopMonHocEntity;

    @OneToOne(mappedBy = "quaTrinhHocTapEntity")
    private KetQuaHocTapEntity ketQuaHocTapEntity;


}
