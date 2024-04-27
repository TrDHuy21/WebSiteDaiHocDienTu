package com.WebsiteDaiHocDienTu.model.entity;

import com.WebsiteDaiHocDienTu.config.StringPrefixedSequenceIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sv_seq")
    @GenericGenerator(
            name = "sv_seq",
            strategy = "com.WebsiteDaiHocDienTu.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SV_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
            })
    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private Byte state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "lop_chinh_quy_id")
    private LopChinhQuyEntity lopChinhQuyEntity;

    @ManyToMany
    @JoinTable (
            name="lopmonhoc_sinhvien",
            joinColumns=@JoinColumn(name="sinhvien_id"),
            inverseJoinColumns=@JoinColumn(name="lopmonhoc_id")
    )
    private List<LopMonHocEntity> lopMonHocEntityList;

    @OneToMany(mappedBy = "sinhVienEntity")
    private List<QuaTrinhHocTapEntity> quaTrinhHocTapEntityList;
}
