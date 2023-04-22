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
public class TaiKhoanCoKyHan extends Account {

    private Calendar ngayDaoHan;
    private static int dem = 1;
    private KyHan kyHan;
    private String stkCoKyHan;

    {
        GregorianCalendar g = new GregorianCalendar();
        this.stkCoKyHan = (String.format("%04d%02d%02d%02d", dem++, g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH) + 1,
                g.get(Calendar.YEAR)));
    }

    public TaiKhoanCoKyHan(KyHan kyHan, double st) {
        super(st, "TAI KHOAN CO KY HAN");
        this.kyHan = kyHan;
        this.ngayDaoHan = this.kyHan.tinhDaoHan(new GregorianCalendar());

    }

    @Override
    public double tinhTienLai() {
        return this.kyHan.tinhTienLai(this.soDu);
    }

    public boolean isKTDaoHan() {
        Calendar dmy = new GregorianCalendar();
        String d1 = DungChung.f.format(dmy.getTime());
        String d2 = DungChung.f.format(this.ngayDaoHan.getTime());
        return d1.equals(d2);
    }

    @Override
    public void hienThiTK() {
        super.hienThiTK();
        System.out.printf("Ky han = %s\n", this.kyHan);
        System.out.printf("Ngay tao: %s\n", DungChung.f.format(this.ngayTaoTK.getTime()));
        System.out.printf("Ngay dao han: %s\n", DungChung.f.format(this.ngayDaoHan.getTime()));
        System.out.printf("So tai khoan: %s\n", this.stkCoKyHan);
    }

    @Override
    public void nopTien(double st, Account a) {
        if (!isKTDaoHan()) {
            System.out.println("Chua den ngay dao han de nop tien!");
        } else {
            if ((a.getSoDu() - st) > 50000 && st >= 100000) {
                this.setSoDu(this.getSoDu() + st);
                a.setSoDu(a.getSoDu() - st);
                System.out.println("Nop tien thanh cong!");
                System.out.printf("So du sau khi nop: %.0fVND\n", this.getSoDu());
            } else {
                System.out.println("SO DU khong du!");
            }

        }
    }
    // this - co kh
    //a - khong kh

    @Override
    public void rutTien(double st) {
        if (!isKTDaoHan()) {
            System.out.print("Chua den ngay dao han! Neu muon rut se nhan (lai mac dinh) chon Yes/No:");
            DungChung.sc.nextLine();
            String yn = DungChung.sc.nextLine();
            if (yn.equals("Yes") || yn.equals("yes") || yn.equals("y") || yn.equals("Y")) {
                super.rutTien();
                System.out.println("Rut tien thanh cong!\n");
            } else {
                System.out.println("Rut tien KHONG thanh cong!\n");
            }
        } else {
            rutTien();
        }
    }

    @Override
    public void rutTien() {
        if (isKTDaoHan()) {
            super.rutTien();
            this.soDu = super.tongSoDu();
        }
    }

    
    
    
    
    
    
    //==============================================
    /**
     * @return the ngayDaoHan
     */
    public Calendar getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Calendar ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the kyHan
     */
    public KyHan getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    /**
     * @return the STKcoKyHan
     */
    public String getSTKcoKyHan() {
        return stkCoKyHan;
    }

    /**
     * @param STKcoKyHan the STKcoKyHan to set
     */
    public void setSTKcoKyHan(String STKcoKyHan) {
        this.stkCoKyHan = stkCoKyHan;

    }
}
