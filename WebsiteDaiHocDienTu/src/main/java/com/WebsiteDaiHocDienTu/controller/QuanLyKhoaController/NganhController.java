package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.request.nganh.CreateAndUpdateNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetListNganhDTO;
import com.WebsiteDaiHocDienTu.service.NganhService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "qlk")
@RequestMapping("/qlk")
public class NganhController {

    @Autowired
    private NganhService nganhService;


    @GetMapping("/quan-ly-nganh")
    public String getList(Model model){
        Integer userId = SecurityUtils.getPrinciple().getId();
        List<GetListNganhDTO> nganhs = nganhService.findAllByQLK(userId);
        model.addAttribute("nganhs",nganhs);
        return "/admin/nganh/ListNganh";
    }

    @GetMapping("/nganh/them-nganh")
    public String viewThemNganh(Model model){
        return "/admin/nganh/createNganh";
    }

    @PostMapping("/nganh/them-nganh")
    public String themNganh(Model model, @ModelAttribute CreateAndUpdateNganhDTO nganhDTO){
        Integer userId = SecurityUtils.getPrinciple().getId();
        CreateAndUpdateNganhDTO nganh = null;
        try {
            nganh = nganhService.createNganh(userId,nganhDTO);
            model.addAttribute("message","Thêm ngành thành công");
        }catch (Exception e){
            model.addAttribute("message","Thêm ngành thất bại");
        }
        return "/admin/nganh/createNganh";
    }

    @GetMapping("/quan-ly-nganh/{id}/sua-nganh")
    private String viewSuaNganh(Model model,@PathVariable Integer id){
        try {
            Integer userId = SecurityUtils.getPrinciple().getId();
            CreateAndUpdateNganhDTO nganhDTO = nganhService.findById(userId,id);
            model.addAttribute("nganh",nganhDTO);
        }catch (Exception e){

        }
        return "/admin/nganh/UpdateNganh";
    }

    @PostMapping("/quan-ly-nganh/sua-nganh")
    public String suaNganh(Model model, @ModelAttribute CreateAndUpdateNganhDTO nganhDTO){
            Integer userId = SecurityUtils.getPrinciple().getId();
        try {
            nganhDTO = nganhService.updateNganh(userId,nganhDTO);
            model.addAttribute("message","Sửa ngành thành công");
        }catch (Exception e){
            model.addAttribute("message","Sửa ngành thất bại");
        }
            model.addAttribute("nganh",nganhDTO);
        return "/admin/nganh/UpdateNganh";
    }


}
