/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class QuanLyKhachHang {

    private List<KhachHang> dsKH = new ArrayList<>();

    //them KH
    public void themKH(KhachHang kh) {
        this.dsKH.add(kh);
    }

    public boolean isKHDaCo(KhachHang k) {
        for (KhachHang khachhang : dsKH) {
            if (khachhang.getUsername().equals(k.getUsername())) {
                return false;
            }
        }
        return true;
    }

    //hien thi KH
    public void xuatDSKH() {
        this.dsKH.forEach(KhachHang::hienThiKH);
    }

    //tinh lai suat theo STK
    public void tinhLaiTheoSTK(String stk) {
        KhachHang kh = this.dsKH.stream().filter(h -> h.getMaSoKH().equals(stk)).findFirst().get();
        System.out.printf("So du = %.0fVND\n", kh.getTk().soDu);
        System.out.printf("Tien lai (1 Thang) = %.0fVND\n", kh.getTk().tinhTienLai());
    }

//    tim KH theo Ten
    public KhachHang timKHTheoTen(String ht) {
        for (KhachHang kh : dsKH) {
            if (kh.getHoTen().equals(ht)) {
                return kh;
            }
        }
        return null;
    }

    //tim KH theo STK
    public KhachHang timKHTheoSTK(String stk) {
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
            return -(d1 > d2 ? 1 : (d1 < d2 ? -1 : 0));
        });
    }

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
