package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_bat_dau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @Column(name = "state")
    private Byte state;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id")
    private GiangVienEntity giangVien;

    @ManyToOne
    @JoinColumn(name = "mon_hoc_id")
    private MonHocEntity monHoc;

    @ManyToOne
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoa;

    @ManyToMany
    @JoinTable (
            name="lopmonhoc_sinhvien",
            joinColumns=@JoinColumn(name="lop_mon_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="sinh_vien_id")
    )
    private List<SinhVienEntity> sinhVienList;

    @OneToMany(mappedBy = "lopMonHoc", cascade = CascadeType.ALL)
    private List<ThoiKhoaBieuEntity> thoiKhoaBieuList;

    @OneToMany(mappedBy = "lopMonHoc")
    private List<QuaTrinhHocTapEntity> quaTrinhHocTapList;

}
