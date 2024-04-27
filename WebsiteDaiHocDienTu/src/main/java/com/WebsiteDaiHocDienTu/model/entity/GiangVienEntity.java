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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "giang_vien")
public class GiangVienEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gv_seq")
    @GenericGenerator(
            name = "gv_seq",
            strategy = "com.WebsiteDaiHocDienTu.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "GV"),
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
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoaEntity;

    @ManyToMany
    @JoinTable (
            name="monhoc_giangvien",
            joinColumns=@JoinColumn(name="giang_vien_id"),
            inverseJoinColumns=@JoinColumn(name="mon_hoc_id")
    )
    private List<MonHocEntity> monHocEntityList;

    @OneToMany(mappedBy = "giangVienEntity")
    private List<LopMonHocEntity> lopMonHocEntityList;
}
