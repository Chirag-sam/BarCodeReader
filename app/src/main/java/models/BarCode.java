package models;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class BarCode {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="bar_code")
    public String bar_code;

    public BarCode() {
    }

    public  BarCode(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getBar_code() {
        return bar_code;
    }
}
