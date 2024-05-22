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
@Table(name = "mon_hoc")
public class MonHocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_tin")
    private int soTin;

    @Column(name = "he_so_tx1")
    private Float heSoTx1;

    @Column(name = "he_so_tx2")
    private Float heSoTx2;

    @Column(name = "he_so_tx3")
    private Float heSoTx3;

    @Column(name = "he_so_giua_ki1")
    private Float heSoGiuaKi1;

    @Column(name = "he_so_giua_ki2")
    private Float heSoGiuaKi2;

    @Column(name = "he_so_giua_ki3")
    private Float heSoGiuaKi3;

    @Column(name = "he_so_thi")
    private Float heSoThi;

    @Column(name = "state")
    private  Byte state;

    @ManyToOne()
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoa;

    @ManyToMany
    @JoinTable (
            name="monhoc_giangvien",
            joinColumns=@JoinColumn(name="mon_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="giang_vien_id")
    )
    private List<GiangVienEntity> giangVienList;

    @ManyToMany
    @JoinTable (
            name="monhoc_chuongTrinhHoc",
            joinColumns=@JoinColumn(name="mon_hoc_id"),
            inverseJoinColumns=@JoinColumn(name="chuong_trinh_hoc_id")
    )
    private List<ChuongTrinhHocEntity> chuongTrinhHocList;

    @OneToMany(mappedBy = "monHoc")
    private List<LopMonHocEntity> lopMonHocList;

}
