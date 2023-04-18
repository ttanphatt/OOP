/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public enum KyHan {
    MACDINH {
        @Override
        public Calendar tinhDaoHan(Calendar dmy) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        @Override
        public double tinhTienLai(double st) {
//            return (st * 0.2) / (100);
             return st*0.002/12;
        }
    },
    MOT_TUAN {
        @Override
        public Calendar tinhDaoHan(Calendar dmy) {
            dmy.add(Calendar.DAY_OF_YEAR, 7);
            return dmy;
        }

        @Override
        public double tinhTienLai(double st) {
            Calendar dmy = new GregorianCalendar();
            int s = dmy.getActualMaximum(Calendar.DAY_OF_YEAR);
//            return (st * 0.2) / (100 * 12 * 4);
            return (st*0.02*7)/s;
            //st = st x lãi suất (%năm)                     x số ngày gửi thực tế/365
        }
    },
    MOT_THANG {
        @Override
        public Calendar tinhDaoHan(Calendar dmy) {
            dmy.add(Calendar.MONTH, 1);
            return dmy;
        }

        @Override
        public double tinhTienLai(double st) {
//            return (st * 4.5) / (100 * 12);
            return (st*0.055)/12;
        }
    },
    SAU_THANG {
        @Override
        public Calendar tinhDaoHan(Calendar dmy) {
            dmy.add(Calendar.MONTH, 6);
            return dmy;
        }

        @Override
        public double tinhTienLai(double st) {
            Calendar dmy = new GregorianCalendar();
            int s = dmy.get(Calendar.MONTH);
//            return (st * 7.5) / (100 * 6);
            return (st*0.075*6)/12 ;
            //st = st x lãi suất (%năm)/12 x số tháng gửi
        }
    },
    MUOIHAI_THANG {
        @Override
        public Calendar tinhDaoHan(Calendar dmy) {
            dmy.add(Calendar.YEAR, 1);
            return dmy;
        }

        @Override
        public double tinhTienLai(double st) {
//            return (st * 7.9) / (100);
            return st*0.079;
            //st = st x lãi suất (%năm)/12 x số tháng gửi
        }
    };
    
    public abstract Calendar tinhDaoHan(Calendar dmy);
    public abstract double tinhTienLai(double st);
}
