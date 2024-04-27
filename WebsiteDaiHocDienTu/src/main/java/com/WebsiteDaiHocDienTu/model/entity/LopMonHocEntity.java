package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lop_mon_hoc")
public class LopMonHocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "state")
    private Byte state;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id")
    private GiangVienEntity giangVienEntity;

    @ManyToOne
    @JoinColumn(name = "mon_hoc_id")
    private MonHocEntity monHocEntity;

    @ManyToMany
    @JoinTable (
            name="lopmonhoc_sinhvien",
            joinColumns=@JoinColumn(name="lop_mon_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="sinh_vien_id")
    )
    private List<SinhVienEntity> sinhVienEntityList;

    @OneToMany(mappedBy = "lopMonHocEntity")
    private List<ThoiKhoaBieuEntity> thoiKhoaBieuEntityList;

    @OneToMany(mappedBy = "lopMonHocEntity")
    private List<QuaTrinhHocTapEntity> quaTrinhHocTapEntityList;

}
