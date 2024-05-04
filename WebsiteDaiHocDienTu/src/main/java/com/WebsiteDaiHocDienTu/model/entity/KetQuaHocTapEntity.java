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
@Table(name = "ket_qua_hoc_tap")
public class KetQuaHocTapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tx1")
    private Float tx1;

    @Column(name = "tx2")
    private Float tx2;

    @Column(name = "tx3")
    private Float tx3;

    @Column(name = "giua_ki1")
    private Float giuaKi1;

    @Column(name = "giua_ki2")
    private Float giuaKi2;

    @Column(name = "giua_ki3")
    private Float giuaKi3;

    @Column(name = "thi1")
    private Float thi1;

    @Column(name = "thi2")
    private Float thi2;

    @Column(name = "phuc_khao_1")
    private Float phucKhao1;

    @Column(name = "phuc_khao_2")
    private Float phucKhao2;

    @ManyToOne
    @JoinColumn(name =  "mon_hoc_id")
    private MonHocEntity monHoc;

    @OneToOne
    @JoinColumn(name = "qua_trinh_hoc_tap_id")
    private QuaTrinhHocTapEntity quaTrinhHocTap;
}
