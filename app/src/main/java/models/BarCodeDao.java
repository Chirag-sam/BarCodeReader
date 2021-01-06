package models;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BarCodeDao {

    @Query("SELECT * from BarCode")
    List<BarCode> getAllBarCodes();

    @Insert
    void insertBarCode(BarCode... barCodes);

    @Delete
    void deleteBarCode(BarCode barCode);

    @Query("DELETE from BarCode")
    void deleteAllBarCodes();
}
