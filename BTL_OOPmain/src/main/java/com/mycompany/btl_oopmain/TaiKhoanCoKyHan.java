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
    private String STKcoKyHan;
    private Account acc;

    {
        GregorianCalendar g = new GregorianCalendar();
        setSTKcoKyHan(String.format("%04d%02d%02d%02d", dem++, g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.MONTH) + 1,
                g.get(Calendar.YEAR)));
    }

//    public TaiKhoanCoKyHan(KyHan kyHan, double st) {
//        this.setSoDu(st);
//        this.setLoaiTK();
//        this.kyHan = kyHan;
//        this.ngayDaoHan = this.kyHan.tinhDaoHan(new GregorianCalendar());
//    }
    public TaiKhoanCoKyHan(KyHan kyHan, double st) {
        super(st, "TAI KHOAN CO KY HAN");
        this.kyHan = kyHan;
        this.ngayDaoHan = this.kyHan.tinhDaoHan(new GregorianCalendar());

    }

    @Override
    public double tinhTienLai() {
        return this.getKyHan().tinhTienLai(this.soDu);
    }

    public boolean isKTDaoHan() {
        Calendar dmy = new GregorianCalendar();
        String d1 = DungChung.f.format(dmy.getTime());
        String d2 = DungChung.f.format(this.getNgayDaoHan().getTime());
        return d1.equals(d2);
    }

    @Override
    public void hienThiTK() {
        super.hienThiTK();
        System.out.printf("Ky han = %s\n", this.getKyHan());
        System.out.printf("Ngay tao: %s\n", DungChung.f.format(this.ngayTaoTK.getTime()));
        System.out.printf("Ngay dao han: %s\n", DungChung.f.format(this.getNgayDaoHan().getTime()));
        System.out.printf("So tai khoan: %s\n", this.getSTKcoKyHan());
    }

    @Override
    public void nopTien(double st, Account a) {
        if (!isKTDaoHan()) {
            System.out.println("Chua den ngay dao han de nop tien!");
        } else {
            if ((a.getSoDu() - st) > 50000 && st >= 100000) {
                this.setSoDu(this.getSoDu() + st);
                a.setSoDu(a.getSoDu() - st);
                System.out.println("Nop thanh cong");
                System.out.printf("So tien sau khi nop: %.1f", this.getSoDu());
            } else {
                System.out.println("So du khong du");
            }

        }
//            
//        if (st <= this.getSoDu() || this.getSoDu() >= 50000) {
//            if (!isKTDaoHan()) {
//                System.out.println("Chua den ngay dao han de nop tien!");
//            } else {
//                System.out.println("Nhap so tien muon nop: ");
//                st = DungChung.sc.nextDouble();
//            }
//            
//        }
//        else{
//            System.out.println("Khong du dieu kien de nop tien!");
//        }
    }

    @Override
    public void rutTien(double st) {
        if (!isKTDaoHan()) {
            System.out.print("Chua den ngay dao han. Neu muon rut truoc han (lai mac dinh) chon y/n:");
            DungChung.sc.nextLine();
            String yn = DungChung.sc.nextLine();
            if (yn.equals("y")) {
                super.rutTien();
                System.out.println("Rut tien thanh cong!\n");
            } else {
                System.out.println("Rut tien khong thanh cong!n");
            } //
        }
    }

    @Override
    public void rutTien() {
        if (isKTDaoHan()) {
            super.rutTien();
            this.soDu = super.tongSoDu();
        }
    }

//    @Override
//    public void rutTien(double st) {
//        if (st <= this.getSoDu()) {
//            if (!isKTDaoHan()) {
//                System.out.println("Chua den han rut tien!");
//                System.out.print("    Neu muon rut tien truoc ngay dao han"
//                        + "(lai suat mac dinh) chon yes/no de thuc hien rut: ");
//                DungChung.sc.nextLine();
//                String yn = DungChung.sc.nextLine();
//                if (yn.equals("yes")) {
//                    super.rutTien(st);
//                    super.tongSoDu();
//                    
////                    st += super.tongSoDu();
////                    this.soDu =this.soDu (this.soDu * 0.002) / 12;
////                    this.soDu = super.tongSoDu();
//                    System.out.println("Rut tien thanh cong!");
//                } else {
//                    System.out.println("Rut tien khong thanh cong!");
//                }
//
//            } else {
//                super.tongSoDu();
//                rutTien(st);
//
//            }
//        } else {
//            System.out.println("So tien ban muon rut lon hon so tien co trong tai khoan");
//        }
//    }
//
//    
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
        return STKcoKyHan;
    }

    /**
     * @param STKcoKyHan the STKcoKyHan to set
     */
    public void setSTKcoKyHan(String STKcoKyHan) {
        this.STKcoKyHan = STKcoKyHan;
    }
}
