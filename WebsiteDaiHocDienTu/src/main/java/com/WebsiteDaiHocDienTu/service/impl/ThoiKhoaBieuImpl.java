package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.model.dto.request.thoiKhoaBieu.LichHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.thoiKhoaBieu.ThoiKhoaBieuDTO;
import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;
import com.WebsiteDaiHocDienTu.respository.ThoiKhoaBieuRepository;
import com.WebsiteDaiHocDienTu.service.ThoiKhoaBieuService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
@AllArgsConstructor
public class ThoiKhoaBieuImpl implements ThoiKhoaBieuService {

    ThoiKhoaBieuRepository thoiKhoaBieuRepository;

    @Override
    public void deleteById(int id) {
        thoiKhoaBieuRepository.deleteById(id);
    }

    @Override
    public ThoiKhoaBieuEntity findById(int id) {
        return null;
    }

    @Override
    public List<ThoiKhoaBieuDTO> getThoiKhoaBieuForGiangVien(String giangVienId, LocalDate start, LocalDate end) throws Exception {
        // triển khai :
        /*
        * 0. kiểm tra biến đầu vào
        * 1. lấy ra danh sách lớp môn học state = 1, ngayBatDau<end
        * 2. chuyển start về đầu tuần, end về cuối tuần
        * 3. tạo lịch từ start đến end
        * 4. lặp từ lớp môn học
        * */

        // 0. kiểm tra biến đầu vào
        if(start==null) {
            throw new Exception("Cần nhập ngày bắt đầu");
        }
        if (end == null) {
            throw new Exception("Cần nhập ngày kết thúc");
        }

        // 1. lấy ra danh sách lớp môn, ngayBatDau<end
        List<LopMonHocEntity> lmhList = thoiKhoaBieuRepository
                .thoiKhoaBieuForGiangVien(
                        giangVienId,
                        end
                );
        // 2.  chuyển start về đầu tuần
        LocalDate s  = start.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        //3. tạo lịch từ start đến end
        Map<LocalDate, ThoiKhoaBieuDTO> tkbMap = new  LinkedHashMap<>();
        for(LocalDate i = start; i.isBefore(end)||i.isEqual(end); i= i.plusDays(1)) {
            ThoiKhoaBieuDTO tkb = new ThoiKhoaBieuDTO();
            tkb.setDate(i);
            tkb.setThu(i.getDayOfWeek().getValue());
            tkbMap.put(i, tkb);
        }

        // 4. lặp từng lớp và trèn vào tkb
        for(LopMonHocEntity lmh:lmhList) {

            // tính số tiết còn thiếu
            int soTietThieu;
            {
                int soTietTrenTuan = 0;
                for(ThoiKhoaBieuEntity l:lmh.getThoiKhoaBieuList()) {
                    soTietTrenTuan += l.getSoTiet();
                }
                if(soTietTrenTuan==0) {
                    break;
                }
                int tongSoTiet = lmh.getMonHoc().getSoTin() * 10;
                // chuyển ngày bắt đầu về đầu tuần
                LocalDate temp = lmh.getNgayBatDau().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                int soTuanTruoc = (int) ChronoUnit.WEEKS.between(temp, s);
                soTietThieu = tongSoTiet - soTietTrenTuan*soTuanTruoc;
            }

            // trèn vào lịch học của lớp vào tkbMap
            LocalDate ngay = lmh.getNgayBatDau().isBefore(s) ? s.minusDays(1) : lmh.getNgayBatDau().minusDays(1);
            while(soTietThieu>0) {
                for(ThoiKhoaBieuEntity l:lmh.getThoiKhoaBieuList()) {
                    // nếu đã hết tiết thì dừng trèn
                    if(soTietThieu<=0) {
                        break;
                    }

                    // tính thứ tiếp theo là ngày nào
                    ngay = ngay.with(TemporalAdjusters.next(DayOfWeek.of(l.getThu()-1)));

                    // sau  thì dừng trèn
                    if(ngay.isAfter(end)){
                        soTietThieu=-1;
                        break;
                    }

                    // nếu trước [start, end] thì giảm số tiết thiếu nhưng k trèn
                    if(ngay.isBefore(start)) {
                        soTietThieu -= l.getSoTiet();
                        break;
                    }

                    // tạo 1 lịch học
                    LichHocDTO lichHocDTO = new LichHocDTO();
                    lichHocDTO.setTenGiangVien(SecurityUtils.getPrinciple().getHo() + ' ' + SecurityUtils.getPrinciple().getTen());
                    lichHocDTO.setTenLop(lmh.getTen());
                    lichHocDTO.setTenMon(lmh.getMonHoc().getTen());
                    StringBuilder tiets= new StringBuilder();
                    for(int i = 0; i<l.getSoTiet(); i++) {
                        tiets.append((i + l.getTietBatDau())).append(" ");
                        --soTietThieu;
                        if(soTietThieu<=0) {
                            break;
                        }
                    }
                    lichHocDTO.setTiets(tiets.toString());

                    //trèn vào tkbMap
                    if(tkbMap.get(ngay).getLichHocList() ==null) {
                        tkbMap.get(ngay).setLichHocList(new ArrayList<>());
                    }
                    tkbMap.get(ngay).getLichHocList().add(lichHocDTO);
                }
            }
        };
        return tkbMap.values().stream().toList();
    }
}
