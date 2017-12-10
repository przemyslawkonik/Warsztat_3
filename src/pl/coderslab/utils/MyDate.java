package pl.coderslab.utils;

import pl.coderslab.db.DbUtil;

import java.util.Date;

/**
 * Created by Przemysław Konik on 2017-12-10.
 */
public class MyDate {

    public static String get() {
        return DbUtil.convert(new Date());
    }
}
