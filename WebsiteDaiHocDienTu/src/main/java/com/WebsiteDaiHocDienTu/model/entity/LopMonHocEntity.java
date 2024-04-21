package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lopmonhoc")
public class LopMonHocEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngaybatdau")
    private Date ngayBatDau;

    @ManyToOne
    @JoinColumn(name = "giangvien_id")
    private UserEntity giangVien;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHocEntity monHocEntity;


    @OneToMany(mappedBy = "lopMonHocEntity")
    private List<ThoiKhoaBieuEntity> thoiKhoaBieuEntityList;

    @OneToMany(mappedBy = "lopMonHocEntity")
    private List<QuaTrinhHocTap> quaTrinhHocTapList;

}
