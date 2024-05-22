package com.WebsiteDaiHocDienTu.controller.api.quanlykhoa;

import com.WebsiteDaiHocDienTu.service.ChuongTrinhHocService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qlk/nganh/")
public class QuanLyKhoaAPI {

    @Autowired
    ChuongTrinhHocService chuongTrinhHocService;
    @PostMapping("{nganhId}/quan-ly-chuong-trinh-hoc/{cid}/mon-hoc/them-moi")
    @ResponseBody
    public String addNewMonHoc(HttpServletRequest request, @PathVariable("nganhId") Integer nganhId, @PathVariable("cid") Integer cthId, @RequestBody List<Integer> ids){
        try {
            chuongTrinhHocService.addMonHocs(nganhId,cthId,ids);
        }catch (Exception e){
            return "thất bại";
        }
        return "OK";
    }

    @DeleteMapping("{nganhId}/quan-ly-chuong-trinh-hoc/{cid}/mon-hoc/xoa-mon-hoc")
    @ResponseBody
    public String remove(HttpServletRequest request, @PathVariable("nganhId") Integer nganhId, @PathVariable("cid") Integer cthId, @RequestBody List<Integer> ids){
        try {
            chuongTrinhHocService.removeMonHoc(nganhId,cthId,ids);
        }catch (Exception e){
            return "thất bại";
        }
        return "OK";
    }
}
