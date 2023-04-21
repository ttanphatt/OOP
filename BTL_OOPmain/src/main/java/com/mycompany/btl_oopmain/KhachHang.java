/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class KhachHang {

    private List<TaiKhoanCoKyHan> dstkkh = new ArrayList<>();
    private static int dem = 1;
    private String maSoKH;
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private String CCCD;
    private Date ngaySinh;
    private double soTienGui;

    private TaiKhoan tk;

    private String username;

    {
        GregorianCalendar g = new GregorianCalendar();
        maSoKH = (String.format("%02d%02d%d%04d", g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH) + 1,
                g.get(Calendar.YEAR), dem++));
    }

    public KhachHang() {
    }

    public KhachHang(String hoTen, String gioiTinh, String queQuan, String CCCD, Date ngaySinh, double soTienGui, String username, TaiKhoan tk) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.soTienGui = soTienGui;
        this.username = username;
        this.tk = tk;
    }

    public KhachHang(String hoTen, String gioiTinh, String queQuan, String CCCD, String ngaySinh, double soTienGui, String username, TaiKhoan tk) throws ParseException {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.CCCD = CCCD;
        this.ngaySinh = DungChung.f.parse(ngaySinh); //chua hieu lam
        this.soTienGui = soTienGui;
        this.username = username;
        this.tk = tk;
    }

    public void themAccount(TaiKhoanCoKyHan... ac) {
        this.dstkkh.addAll(Arrays.asList(ac));
    }

    public void xuatAccount() {
        this.tk.hienThiTK();
        this.dstkkh.forEach(TaiKhoanCoKyHan::hienThiTK);
        
    }

//    public void xuatDSTKCoKH(){
//        this.dsAC.forEach(taiKhoanCoKyHan -> taiKhoanCoKyHan.hienThiTK());
//    }
    public void nhapKH() throws ParseException {
        DungChung.sc.nextLine();
        System.out.print("Ho & ten: ");
        this.hoTen = DungChung.sc.nextLine();
        System.out.print("Gioi tinh: ");
        this.gioiTinh = DungChung.sc.nextLine();
        System.out.print("Ngay sinh: ");
        this.ngaySinh = DungChung.f.parse(DungChung.sc.nextLine());
        System.out.print("Que quan: ");
        this.queQuan = DungChung.sc.nextLine();
        System.out.print("CCCD: ");
        this.CCCD = DungChung.sc.nextLine();
        System.out.print("So tien gui (>50000VND): ");
        this.soTienGui = Double.parseDouble(DungChung.sc.nextLine());
        do {
            if (soTienGui < 50000) {
                System.out.printf("Vui long nhap lai!: ");
                this.soTienGui = Double.parseDouble(DungChung.sc.nextLine());
            }
        } while (soTienGui < 50000);
        System.out.print("*Username: ");
        this.username = DungChung.sc.nextLine();
        this.tk = new TaiKhoan(soTienGui);
    }

    public double soTienGui() {
        double tong = 0;
        tong += tk.getSoDu();
        return tong;
    }

    public void hienThiKH() {
        System.out.printf("***STK: %s\n", this.maSoKH);
        System.out.printf("Ho & ten: %s\n", this.hoTen);
        System.out.printf("Gioi tinh: %s\n", this.gioiTinh);
        System.out.printf("Que quan: %s\n", this.queQuan);
        System.out.printf("Ngay sinh: %s\n", DungChung.f.format(this.ngaySinh));
        System.out.printf("CCCD: %S\n", this.CCCD);
        System.out.printf("username: %S\n", this.username);
        System.out.printf("So du: %s\n", this.tk.soDu);
    }

    /**
     * @return the maSTK
     */
    public String getMaSoKH() {
        return maSoKH;
    }

    /**
     * @param maSTK the maSTK to set
     */
    public void setMaSoKH(String maSoKH) {
        this.maSoKH = maSoKH;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the CCCD
     */
    public String getCCCD() {
        return CCCD;
    }

    /**
     * @param CCCD the CCCD to set
     */
    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the soTienGui
     */
    public double getSoTienGui() {
        return soTienGui;
    }

    /**
     * @param soTienGui the soTienGui to set
     */
    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the listAcc
     */
    public List<TaiKhoanCoKyHan> getDsAC() {
        return dstkkh;
    }

    /**
     * @param listAcc the listAcc to set
     */
    public void setDsAC(List<TaiKhoanCoKyHan> dstkkh) {
        this.dstkkh = dstkkh;
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the dstkkh
     */
    public List<TaiKhoanCoKyHan> getDstkkh() {
        return dstkkh;
    }

    /**
     * @param dstkkh the dstkkh to set
     */
    public void setDstkkh(List<TaiKhoanCoKyHan> dstkkh) {
        this.dstkkh = dstkkh;
    }

    /**
     * @return the tk
     */
    public TaiKhoan getTk() {
        return tk;
    }

    /**
     * @param tk the tk to set
     */
    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }
}
