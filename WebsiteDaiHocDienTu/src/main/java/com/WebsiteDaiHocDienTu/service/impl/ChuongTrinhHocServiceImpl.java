package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.mapper.DataMapper;
import com.WebsiteDaiHocDienTu.model.dto.ChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.AddAndUpdateChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.GetListChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.entity.ChuongTrinhHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.KhoaEntity;
import com.WebsiteDaiHocDienTu.model.entity.MonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.NganhEntity;
import com.WebsiteDaiHocDienTu.respository.*;
import com.WebsiteDaiHocDienTu.service.ChuongTrinhHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ChuongTrinhHocServiceImpl implements ChuongTrinhHocService
{
    ChuongTrinhHocRepository chuongTrinhHocRepository;
    NganhRepository nganhRepository;
    KhoaRepository khoaRepository;
    MonHocRepository monHocRepository;
    QuanLyKhoaRepository quanLyKhoaRepository;


    @Override
    public List<GetListChuongTrinhHocDTO> findAllByNganhIdBelongsKhoa(Integer nganhId) {
        if (!checkNganh(nganhId)){
           throw new AccessDeniedException("Not found");
        }
        List<ChuongTrinhHocEntity> chuongTrinhHocEntities = chuongTrinhHocRepository.findAllByNganh_IdAndState(nganhId,(byte) 1);
        return chuongTrinhHocEntities.stream().map(entity -> DataMapper.toDTO(entity, GetListChuongTrinhHocDTO.class)).toList();
    }

    @Override
    public AddAndUpdateChuongTrinhHocDTO save(Integer nganhId,AddAndUpdateChuongTrinhHocDTO chuongTrinhHocDTO) {
        try {
            NganhEntity nganh = nganhRepository.getReferenceById(nganhId);
            ChuongTrinhHocEntity chuongTrinhHocEntity = DataMapper.toEntity(chuongTrinhHocDTO,ChuongTrinhHocEntity.class);
            chuongTrinhHocEntity.setState((byte)1);
            chuongTrinhHocEntity.setNganh(nganh);
            chuongTrinhHocRepository.save(chuongTrinhHocEntity);
            return DataMapper.toDTO(chuongTrinhHocEntity,AddAndUpdateChuongTrinhHocDTO.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public AddAndUpdateChuongTrinhHocDTO findById(Integer id) {
        try {
            ChuongTrinhHocEntity chuongTrinhHocEntity = chuongTrinhHocRepository.getReferenceById(id);
            return DataMapper.toDTO(chuongTrinhHocEntity,AddAndUpdateChuongTrinhHocDTO.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddAndUpdateChuongTrinhHocDTO addMonHocs(Integer nganhId,Integer chuongTrinhHocId,List<Integer> monHocIds) {
        Integer idKhoa = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        if (!checkNganh(nganhId)){
            return null;
        }
        ChuongTrinhHocEntity chuongTrinhHocEntity = chuongTrinhHocRepository.getReferenceById(chuongTrinhHocId);
        List<MonHocEntity> monHocEntities = monHocRepository.findAllByIdInAndStateAndKhoa_Id(monHocIds,(byte) 1,idKhoa);
        chuongTrinhHocEntity.getMonHocList().addAll(monHocEntities);
        chuongTrinhHocEntity =  chuongTrinhHocRepository.save(chuongTrinhHocEntity);
        return DataMapper.toDTO(chuongTrinhHocEntity,AddAndUpdateChuongTrinhHocDTO.class);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void removeMonHoc(Integer nganhId,Integer chuongTrinhHocId, List<Integer> monHocIds) {
        Integer idKhoa = quanLyKhoaRepository.findByUserId(SecurityUtils.getPrinciple().getId())
                .orElseThrow(()-> new NullPointerException("quan ly khoa not found"))
                .getKhoa()
                .getId();
        if (!checkNganh(nganhId)){
            return;
        }
        ChuongTrinhHocEntity chuongTrinhHocEntity = chuongTrinhHocRepository.getReferenceById(chuongTrinhHocId);
        List<MonHocEntity> monHocEntities = monHocRepository.findAllByIdInAndStateAndKhoa_Id(monHocIds,(byte) 1,idKhoa);
        chuongTrinhHocEntity.getMonHocList().removeAll(monHocEntities);
        chuongTrinhHocEntity =  chuongTrinhHocRepository.save(chuongTrinhHocEntity);
    }


    private boolean checkNganh(Integer nganhId){
        Long userId = SecurityUtils.getPrinciple().getId();
        KhoaEntity khoa = khoaRepository.findByUserId(userId).orElseThrow(()-> new NullPointerException("Khoa not found"));
        Optional<NganhEntity> nganh = nganhRepository.findByIdAndStateAndKhoaId(nganhId,(byte) 1,khoa.getId());
        return nganh.isPresent();
    }
}
