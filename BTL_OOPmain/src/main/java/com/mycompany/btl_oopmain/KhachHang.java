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
    protected List<Account> dsAC = new ArrayList<>();
    private static int dem = 1;
    private String maSoKH;
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private String CCCD;
    private Date ngaySinh;
    private double soTienGui;
    
    private String username;
    

    {
        GregorianCalendar g = new GregorianCalendar();
        maSoKH = (String.format("%02d%02d%d%04d", g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH) + 1,
                g.get(Calendar.YEAR), dem++));
    }

    public KhachHang() {
    }
    
    public KhachHang(String hoTen, String gioiTinh, String queQuan, String CCCD, Date ngaySinh, double soTienGui, String username) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.soTienGui = soTienGui;
        this.username = username;
    }

    public KhachHang(String hoTen, String gioiTinh, String queQuan, String CCCD, String ngaySinh, double soTienGui, String username) throws ParseException {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.CCCD = CCCD;
        this.ngaySinh = DungChung.f.parse(ngaySinh); //chua hieu lam
        this.soTienGui = soTienGui;
        this.username = username;
    }
    
    public void themAccount(Account... ac) {
        this.dsAC.addAll(Arrays.asList(ac));
    }
    public void xuatAccount() {
        this.dsAC.forEach(Account::hienThiTK);
    }
    
//    public void xuatDSTKCoKH(){
//        this.dsAC.forEach(taiKhoanCoKyHan -> taiKhoanCoKyHan.hienThiTK());
//    }
    
    
    public void nhapKH() throws ParseException{
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
            if(soTienGui < 50000){
                System.out.printf("Vui5 long nhap lai!: ");
                this.soTienGui = Double.parseDouble(DungChung.sc.nextLine());
            }
        } while (soTienGui < 50000);
        System.out.print("*Username: ");
        this.username = DungChung.sc.nextLine();
    }
    
    public double soTienGui() {
        double tong = 0;
        for (Account ac : this.dsAC) {
            tong += ac.getSoDu();

        }
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
//        System.out.printf("Username: %s\n", this.maSoKH);
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
    public List<Account> getDsAC() {
        return dsAC;
    }

    /**
     * @param listAcc the listAcc to set
     */
    public void setDsAC(List<Account> dsAC) {
        this.dsAC = dsAC;
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
