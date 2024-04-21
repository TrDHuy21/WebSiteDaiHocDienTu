package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles;

    @ManyToOne
    @JoinColumn(name = "quanlykhoa_id")
    private KhoaEntity quanLyKhoa;

    @ManyToOne
    @JoinColumn(name = "giangvienkhoa_id")
    private KhoaEntity giangVienKhoa;

    @ManyToMany
    @JoinTable (
            name="monhoc_giangvien",
            joinColumns=@JoinColumn(name="giangvien_id"),
            inverseJoinColumns=@JoinColumn(name="monhoc_id")
    )
    private List<MonHocEntity> monDayList ;

    @ManyToOne
    @JoinColumn(name = "lopchinhquy_id")
    private LopChinhQuyEntity lopChinhQuyEntity;

    @OneToMany(mappedBy = "giangVien")
    private List<LopMonHocEntity> lopMonHocEntityList;

    @OneToMany(mappedBy = "sinhVien")
    private List<QuaTrinhHocTap> quaTrinhHocTapList;

    @OneToMany(mappedBy = "sinhVien")
    private List<KetQuaHocTapEntity> ketQuaHocTapEntityList;
}
