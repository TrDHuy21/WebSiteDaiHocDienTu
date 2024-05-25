package com.WebsiteDaiHocDienTu.controller.sinhVienController;

import com.WebsiteDaiHocDienTu.model.dto.request.thoiKhoaBieu.KhoangThoiGianDTO;
import com.WebsiteDaiHocDienTu.service.ThoiKhoaBieuService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Controller
@AllArgsConstructor
@RequestMapping("sv/thoi-khoa-bieu")
public class ThoiKhoaBieuSinhVienController {
    private ThoiKhoaBieuService thoiKhoaBieuService;
    @GetMapping("")
    public String getThoiKhoaBieu(Model model) {

        String sinhVienId = SecurityUtils.getPrinciple().getUserName();
        KhoangThoiGianDTO ktg = new KhoangThoiGianDTO();
        ktg.setStart(LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
        ktg.setEnd(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));

        try {
            model.addAttribute("user", SecurityUtils.getPrinciple());
            model.addAttribute("khoangThoiGian", ktg);
            model.addAttribute("tkbList", thoiKhoaBieuService.getThoiKhoaBieuForSinhVien(sinhVienId, ktg.getStart(), ktg.getEnd()));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMes", e.getMessage());
        }
        return "giangvien/thoikhoabieu";
    }
    @GetMapping(value = "", params = "loc")
    public String getThoiKhoaBieuLoc(Model model,
                                     @ModelAttribute("khoangThoiGian")KhoangThoiGianDTO ktg) {
        try {
            model.addAttribute("user", SecurityUtils.getPrinciple());
            model.addAttribute("khoangThoiGian", ktg);
            String sinhVienId = SecurityUtils.getPrinciple().getUserName();
            model.addAttribute("tkbList", thoiKhoaBieuService.getThoiKhoaBieuForSinhVien(sinhVienId, ktg.getStart(), ktg.getEnd()));
        } catch (Exception e) {
            model.addAttribute("mes", e.getMessage());
        }
        return "giangvien/thoikhoabieu";
    }
}
