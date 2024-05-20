package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.AddAndUpdateChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc.GetListChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.service.ChuongTrinhHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/qlk/nganh/")
public class ChuongTrinhHocController {

    @Autowired
    private ChuongTrinhHocService chuongTrinhHocService;

    @GetMapping("{id}/quan-ly-chuong-trinh-hoc")
    public String getList(Model model, HttpServletRequest request, @PathVariable Integer id){
        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        List<GetListChuongTrinhHocDTO> chuongTrinhHoc = chuongTrinhHocService.findAllByNganhIdBelongsKhoa(id);
        model.addAttribute("chuongTrinhHocs",chuongTrinhHoc);
        model.addAttribute("uri",request.getRequestURI());
        return "/admin/chuongtrinhhoc/ListChuongTrinhHoc";
    }

    @GetMapping("{id}/quan-ly-chuong-trinh-hoc/them-chuong-trinh-hoc")
    public String getThemMoi(Model model,HttpServletRequest request){
        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        model.addAttribute("uri",request.getRequestURI());
        return "/admin/chuongtrinhhoc/CreateChuongTrinhHoc";
    }

    @PostMapping("{nganhId}/quan-ly-chuong-trinh-hoc/them-chuong-trinh-hoc")
    public String postThemMoi(Model model,@PathVariable("nganhId") Integer id, @ModelAttribute AddAndUpdateChuongTrinhHocDTO chuongTrinhHocDTO){

        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        AddAndUpdateChuongTrinhHocDTO chuongTrinhHoc = chuongTrinhHocService.save(id,chuongTrinhHocDTO);
        if (chuongTrinhHoc ==null){
            model.addAttribute("message","Lỗi hệ thống");
        }else {
            model.addAttribute("message","Thêm thành công");
        }
        model.addAttribute("user", userDTO);
        return "/admin/chuongtrinhhoc/ListChuongTrinhHoc";
    }

    @GetMapping("{nganhId}/quan-ly-chuong-trinh-hoc/{id}/sua-chuong-trinh-hoc")
    public String getUpdate(Model model, @PathVariable("id") Integer id){
        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        AddAndUpdateChuongTrinhHocDTO chuongTrinhHocDTO = chuongTrinhHocService.findById(id);
        if (chuongTrinhHocDTO == null){
            model.addAttribute("message","Chương trình học không tồn tại");
            return "/admin/chuongtrinhhoc/ListChuongTrinhHoc";
        }
        model.addAttribute("chuongTrinhHoc",chuongTrinhHocDTO);
        model.addAttribute("user", userDTO);
        return "/admin/chuongtrinhhoc/UpdateChuongTrinhHoc";
    }

    @PostMapping("{nganhId}/quan-ly-chuong-trinh-hoc/{id}/sua-chuong-trinh-hoc")
    public String update(Model model,@PathVariable("nganhId") Integer id, @ModelAttribute AddAndUpdateChuongTrinhHocDTO chuongTrinhHocDTO){
        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        AddAndUpdateChuongTrinhHocDTO chuongTrinhHoc = chuongTrinhHocService.save(id,chuongTrinhHocDTO);
        if (chuongTrinhHoc ==null){
            model.addAttribute("message","Lỗi hệ thống");
        }else {
            model.addAttribute("message","Sửa thành công");
        }
        model.addAttribute("chuongTrinhHoc",chuongTrinhHocDTO);
        model.addAttribute("user", userDTO);
        return "/admin/chuongtrinhhoc/UpdateChuongTrinhHoc";
    }

    @DeleteMapping("{nganhId}/quan-ly-chuong-trinh-hoc")
    public String delete(Model model){
        return "";
    }







}
