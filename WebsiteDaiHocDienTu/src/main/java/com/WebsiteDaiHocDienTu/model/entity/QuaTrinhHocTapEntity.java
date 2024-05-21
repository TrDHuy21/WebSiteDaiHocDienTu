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
    private SinhVienEntity sinhVien;

    @ManyToOne
    @JoinColumn(name = "lop_mon_hoc_id")
    private LopMonHocEntity lopMonHoc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ket_qua_hoc_tap_id")
    private KetQuaHocTapEntity ketQuaHocTap;


}
