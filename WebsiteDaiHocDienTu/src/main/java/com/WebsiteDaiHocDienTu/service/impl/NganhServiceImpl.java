package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.mapper.DataMapper;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.CreateAndUpdateNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetListNganhDTO;
import com.WebsiteDaiHocDienTu.model.entity.KhoaEntity;
import com.WebsiteDaiHocDienTu.model.entity.NganhEntity;
import com.WebsiteDaiHocDienTu.respository.KhoaRepository;
import com.WebsiteDaiHocDienTu.respository.NganhRepository;
import com.WebsiteDaiHocDienTu.respository.QuanLyKhoaRepository;
import com.WebsiteDaiHocDienTu.service.NganhService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NganhServiceImpl implements NganhService {

    private final NganhRepository nganhRepository;
    private final QuanLyKhoaRepository quanLyKhoaRepository;
    private final KhoaRepository khoaRepository;

    @Override
    public List<GetListNganhDTO> findAllByQLK(Integer userId) {
        Integer khoaId = quanLyKhoaRepository.findKhoaIdByUserId(userId).orElseThrow(()-> new NullPointerException("quan ly khoa not found"));
        List<NganhEntity> nganhs = nganhRepository.findAllByStateAndKhoa_Id((byte) 1,khoaId);
        List<GetListNganhDTO> listNganh = nganhs.stream().map(nganh -> DataMapper.toDTO(nganh, GetListNganhDTO.class)).collect(Collectors.toList());
        return listNganh;
    }

    @Override
    public CreateAndUpdateNganhDTO createNganh(Integer userId, CreateAndUpdateNganhDTO nganhDTO) {
        Integer khoaId = quanLyKhoaRepository.findKhoaIdByUserId(userId).orElseThrow(()-> new NullPointerException("quan ly khoa not found"));
        KhoaEntity khoa = khoaRepository.getReferenceById(khoaId);
        NganhEntity nganh = DataMapper.toEntity(nganhDTO,NganhEntity.class);
        nganh.setState((byte)1);
        nganh.setKhoa(khoa);
        nganh = nganhRepository.save(nganh);
        return DataMapper.toDTO(nganh, CreateAndUpdateNganhDTO.class);
    }

    @Override
    public CreateAndUpdateNganhDTO updateNganh(Integer userId, CreateAndUpdateNganhDTO nganhDTO) {
        Integer khoaId = quanLyKhoaRepository.findKhoaIdByUserId(userId).orElseThrow(()-> new NullPointerException("quan ly khoa not found"));
        NganhEntity nganh = nganhRepository.findByIdAndStateAndKhoaId(nganhDTO.getId(),(byte) 1,khoaId).orElseThrow(()-> new NullPointerException("Ngành not found"));
        nganh.setTen(nganhDTO.getTen());
        nganh.setMoTa(nganhDTO.getMoTa());
        nganh = nganhRepository.save(nganh);
        return DataMapper.toDTO(nganh,CreateAndUpdateNganhDTO.class);
    }

    @Override
    public CreateAndUpdateNganhDTO findById(Integer userId, Integer nganhId) {
        Integer khoaId = quanLyKhoaRepository.findKhoaIdByUserId(userId).orElseThrow(()-> new NullPointerException("quan ly khoa not found"));
        NganhEntity nganh = nganhRepository.findByIdAndStateAndKhoaId(nganhId,(byte) 1,khoaId).orElseThrow(()-> new NullPointerException("Ngành not found"));
        return DataMapper.toDTO(nganh,CreateAndUpdateNganhDTO.class);
    }


}
