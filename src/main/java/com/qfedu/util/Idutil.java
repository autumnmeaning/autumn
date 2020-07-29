package com.qfedu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Idutil {
    public static int getId(int preId) {
        int newId = 0;
        String sid = String.valueOf(preId);
        String date = sid.substring(2,4);
        int i = Integer.parseInt(sid.substring(6));
        System.out.println("date: " + date + " ; " + "id: " + i);
        Date da =  new Date();
        String newDate = new SimpleDateFormat("MM").format(da);
        String strDate = new SimpleDateFormat("yyMMdd").format(da);
        if (date.equals(newDate)) {
            String str = "000" + (i + 1);
            System.out.println(str);
            newId = Integer.parseInt(strDate + str.substring(str.length() - 4));
        } else {
            newId = Integer.parseInt(strDate + "0001");
        }
        return newId;
    }
}
