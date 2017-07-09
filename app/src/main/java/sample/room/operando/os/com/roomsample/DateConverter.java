package sample.room.operando.os.com.roomsample;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date fromTimeToDate(@Nullable Long time) {
        return time == null ? null : new Date(time);
    }

    @TypeConverter
    public static Long fromDateToTime(@Nullable Date date) {
        return date == null ? null : date.getTime();
    }
}