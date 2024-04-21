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
@Table(name = "monhoc")
public class MonHocEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_tin")
    private int soTin;

    @ManyToOne()
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoaEntity;

    @ManyToMany
    @JoinTable (
            name="monhoc_giangvien",
            joinColumns=@JoinColumn(name="monhoc_id"),
            inverseJoinColumns=@JoinColumn(name="giangvien_id")
    )
    private List<UserEntity> giangVienList;

    @ManyToMany
    @JoinTable (
            name="monhoc_chuongTrinhHoc",
            joinColumns=@JoinColumn(name="monhoc_id"),
            inverseJoinColumns=@JoinColumn(name="chuongtrinhhoc_id")
    )
    private List<ChuongTrinhHocEntity> chuongTrinhHocEntityList;

    @OneToMany(mappedBy = "monHocEntity")
    private List<LopMonHocEntity> lopMonHocEntityList;

    @OneToMany(mappedBy = "monHocEntity")
    private List<KetQuaHocTapEntity> ketQuaHocTapEntityList;
}
