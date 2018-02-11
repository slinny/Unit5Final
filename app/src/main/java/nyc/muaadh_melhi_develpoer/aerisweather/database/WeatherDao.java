package nyc.muaadh_melhi_develpoer.aerisweather.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by C4Q on 2/4/18.
 */

@Dao
public interface WeatherDao {

    @Insert(onConflict = REPLACE)
    void insertAll(WeatherModel... weatherModel);

    @Query("SELECT * FROM weatherModel ORDER BY dateTimeISO")
    LiveData<List<WeatherModel>> getAll();

    @Query("SELECT COUNT(*) from weatherModel")
    int countWeather();

    @Query("DELETE FROM weatherModel")
    void deleteAll();

    @Delete
    void delete(WeatherModel weatherModel);


}
