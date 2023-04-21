/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class QuanLyKhachHang {

    private List<KhachHang> dsKH = new ArrayList<>();
    private List<TaiKhoanCoKyHan> dsTKKH = new ArrayList<>();

    
    //them KH
    public void themKH(KhachHang kh) {
        this.dsKH.add(kh);
    }

    //hien thi KH
    public void xuatDSKH() {
        this.dsKH.forEach(KhachHang::hienThiKH);
    }

    //tinh lai suat theo STK
    public void tinhLaiTheoSTK(String stk) {
        KhachHang kh = this.dsKH.stream().filter(h -> h.getMaSoKH().equals(stk)).findFirst().get();
//        for (Account ac : kh.getDsAC()) {
//            ac.hienThiTK();
        System.out.printf("Tien lai = %.0fVND\n", kh.getTk().tinhTienLai());
    }


//    tim KH theo Ten
    public KhachHang timKHTheoTen(String ht) {
//        return this.dsKH.stream().filter(t -> t.getHoTen().equalsIgnoreCase(ht)).findFirst().get();
        for (KhachHang kh : dsKH) {
            if (kh.getHoTen().equals(ht)) {
                return kh;
            }
        }
        return null;
    }

    //tim KH theo STK
    public KhachHang timKHTheoSTK(String stk) {
//        return this.dsKH.stream().filter(t -> t.getMaSoKH().equalsIgnoreCase(stk)).findFirst().get();
        for (KhachHang kh : dsKH) {
            if (kh.getMaSoKH().equals(stk)) {
                return kh;
            }
        }
        return null;
    }

    //hien thi danh sach tai khoan cua KH dang co
    public KhachHang timDSTKKH(String stk) {
//        return this.dsKH.stream().filter(t -> t.getMaSoKH().equals(stk)).findFirst().get();
        for (KhachHang kh : dsKH) {
            if (kh.getMaSoKH().equals(stk)) {
                return kh;
            }
        }
        return null;
    }

    //sap xep
    public void sapXepKH() {
        this.dsKH.sort((kh1, kh2) -> {
            double d1 = kh1.getSoTienGui();
            double d2 = kh2.getSoTienGui();
            return -(d1 > d2 ? 1 : (d1 > d2 ? -1 : 0));
        });
    }

    //login
//    public KhachHang dangNhap(String username, int password) {
//        KhachHang kh = this.dsKH.stream().filter(h -> h.getUsername().equals(username)).findFirst().get();
//        if (kh.getDsAC().get(0).matKhau == password)
//            return kh;
//        else
//            return null;
//    }
    public KhachHang dangNhap(String username, int password) {
        for (KhachHang kh : dsKH) {
            if (kh.getUsername().equals(username)) {
                if (kh.getTk().getMatKhau() == password) {
                    return kh;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    //==============================================
    /**
     * @return the dsKH
     */
    public List<KhachHang> getDsKH() {
        return dsKH;
    }

    /**
     * @param dsKH the dsKH to set
     */
    public void setDsKH(List<KhachHang> dsKH) {
        this.dsKH = dsKH;
    }

}
