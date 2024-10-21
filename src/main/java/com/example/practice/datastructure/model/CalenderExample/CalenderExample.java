package com.example.practice.datastructure.model.CalenderExample;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalenderExample {

    public static void main(String[] args) throws ParseException, DatatypeConfigurationException {
        String dat = "2023-11-09 18:25:00.0";
//        getDate();
        System.out.println(usingGregorianCalendar(dat));
        usingGregorianCalendar2();

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("BST"));
//        System.out.println(cal);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSXXX", Locale.getDefault());
//        formatter.setTimeZone(TimeZone.getTimeZone("GMT+6"));
//        Date date = formatter.parse(dat);
//        cal.setTime(date);
////
//        System.out.println(cal);
//        XMLGregorianCalendar xmlCalendarDt = null;
//        XMLGregorianCalendar xmlCalendar = null;
        try {
//            xmlCalendarDt = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
//            //xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), date.getHours(),date.getMinutes(),date.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
//            System.out.println(xmlCalendarDt);
//            System.out.println(xmlCalendar);

//            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("BST"));
//// Timestamp for 2011-10-06 03:35:05 GMT
//            calendar.setTime(new Date(1317872105000L));
//            formatter.setTimeZone(TimeZone.getTimeZone("+6"));
//// Prints 2011-10-06 16:35:05 GMT+13:00
//            System.out.println(formatter.format(calendar.getTime()));
        } catch (Exception ex) {
        }
    }

    public static void getDate() throws DatatypeConfigurationException, ParseException {
        TimeZone utc = TimeZone.getTimeZone("BST");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(utc);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(utc);
        String dat = "2023-11-09 18:25:00.0";
        Date date = df.parse(dat);
        gc.setTime(date);
      //  System.out.println(" - Gregorian UTC [" + df.format(date) + "]");

        String FORMATER = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        DateFormat format = new SimpleDateFormat(FORMATER);

//        Date datee = new Date();
        XMLGregorianCalendar gDateFormatted =
                DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));
        System.out.println("gDateFormatted "+gDateFormatted);

        XMLGregorianCalendar currServTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        System.out.println("currServTime is "+currServTime);

        String FRMTER = "YY-MM-DD";
        DateFormat bson = new SimpleDateFormat(FRMTER);
        dat = dat.replaceAll("-", "");
        date = df.parse(dat);
        System.out.println(date);

    }
    static XMLGregorianCalendar usingGregorianCalendar(String dateTimeAsString) throws DatatypeConfigurationException, ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeAsString));
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
    static void usingGregorianCalendar2() throws DatatypeConfigurationException, ParseException {
        String pattern = "YYMMdd HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
//        simpleDateFormat = new SimpleDateFormat(hour);
//        date = simpleDateFormat.format(new Date());
        String[] d = date.split(" ");
        System.out.println("BSON" + d[0] + "3"+ d[1]);

    }
}
