/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class TaiKhoan extends Account {

    private List<TaiKhoanCoKyHan> dsTKKH = new ArrayList<>();

//    public TaiKhoan(double soTien){
//        this.setSoDu(soTien);
//        this.setLoaiTK("TAI KHOAN KHONG KY HAN");
//    }
    public TaiKhoan(double soTien) {
        super(soTien, "TAI KHOAN KHONG KY HAN");
    }

    public void themTKKH(TaiKhoanCoKyHan... tkkh) {
        this.getDsTKKH().addAll(Arrays.asList(tkkh));
    }

    public void xuatTKKH() {
        this.getDsTKKH().forEach(TaiKhoanCoKyHan::hienThiTK);
    }

    @Override
    public double tinhTienLai() {
//        return (this.soDu * 0.002 * this.tinhNgayGui()/365);
//        return (this.soDu * 0.002 * tinhNgayGui()) / 365;
        return (this.soDu * 0.002 * 30) / 365;
    }

    public boolean isKTDaoHan() {
        return true;
    }

    @Override
    public void nopTien(double st) {
        if (isKTDaoHan() == true) {
//            this.soDu = super.tongSoDu();
            super.nopTien(st);
        }
    }

    @Override
    public void rutTien(double st) {
        if (isKTDaoHan() == true) {
//            this.soDu = super.tongSoDu();
            super.rutTien(st);
        }
    }

    /**
     * @return the dsTKKH
     */
    public List<TaiKhoanCoKyHan> getDsTKKH() {
        return dsTKKH;
    }

    /**
     * @param dsTKKH the dsTKKH to set
     */
    public void setDsTKKH(List<TaiKhoanCoKyHan> dsTKKH) {
        this.dsTKKH = dsTKKH;
    }

}
