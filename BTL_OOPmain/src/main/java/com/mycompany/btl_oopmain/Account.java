/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public abstract class Account {

    protected int matKhau;
    protected double soDu;
    protected String loaiTK;
    protected Calendar ngayTaoTK;

    {
        GregorianCalendar d = new GregorianCalendar();
        matKhau = (int) ((Math.random() * (900000)) + 100000);
        ngayTaoTK = new GregorianCalendar();

    }

    public Account(double soDu, String loaiTK) {
        this.soDu = soDu;
        this.loaiTK = loaiTK;
    }

    public void hienThiTK() {
        System.out.printf("***Loai TK: %s\n", this.loaiTK);
        System.out.printf("So du: %.0fVND\n", this.soDu);
    }

    public abstract double tinhTienLai();

    public double tongSoDu() {
        return this.soDu += this.tinhTienLai();
    }

    public int tinhNgayGui() {
        int d1 = this.ngayTaoTK.get(Calendar.DAY_OF_YEAR);
        int d2 = new GregorianCalendar().get(Calendar.DAY_OF_YEAR);
        return (d2 - d1);
    }

    public void nopTien(double st) {
        if (this.soDu >= 0) {
            this.soDu += st;
        }
    }

    public void nopTien(double st, Account a) {
        if (this.soDu >= 0) {
            this.soDu += st;
        }
    }

    public void rutTien(double st) {
        this.soDu -= st;
    }

    public void rutTien() {
        this.soDu = 0;
    }

    public void doiMatKhau(int mk) {
        this.matKhau = mk;
    }

    //=============================================
    /**
     * @return the matKhau
     */
    public int getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(int matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the soDu
     */
    public double getSoDu() {
        return soDu;
    }

    /**
     * @param soDu the soDu to set
     */
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    /**
     * @return the loaiTK
     */
    public String getLoaiTK() {
        return loaiTK;
    }

    /**
     * @param loaiTK the loaiTK to set
     */
    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    /**
     * @return the ngayTaoTK
     */
    public Calendar getNgayTaoTK() {
        return ngayTaoTK;
    }

    /**
     * @param ngayTaoTK the ngayTaoTK to set
     */
    public void setNgayTaoTK(Calendar ngayTaoTK) {
        this.ngayTaoTK = ngayTaoTK;
    }

}
