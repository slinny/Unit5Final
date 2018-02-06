//package nyc.muaadh_melhi_develpoer.aerisweather.database;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//
//import java.util.Date;
//import java.util.List;
//
//import static android.arch.persistence.room.OnConflictStrategy.REPLACE;
//
///**
// * Created by C4Q on 2/4/18.
// */
//
//@Dao
//public interface WeatherDao {
//
////    @Query("SELECT * FROM weather")
////    LiveData<List<WeatherModel>> getAll();
////
////    @Query("SELECT * FROM weather where download_Date > :after")
////    LiveData<List<Character>> findCharactersAfter(Date after);
//
//    @Query("SELECT * FROM weather where dateTimeISO LIKE :name")
//    Character findByName(String name);
//
//    @Query("SELECT COUNT(*) from character")
//    int countCharacters();
//
//    @Query("DELETE FROM character")
//    void deleteAll();
//
//    @Insert(onConflict = REPLACE)
//    void insertAll(Character... characters);
//
//    @Delete
//    void delete(Character character);
//}
