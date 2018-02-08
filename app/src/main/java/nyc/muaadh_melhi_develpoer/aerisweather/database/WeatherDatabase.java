//package nyc.muaadh_melhi_develpoer.aerisweather.database;
//
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.content.Context;
//
///**
// * Created by C4Q on 2/4/18.
// */
//
//@Database(entities = {WeatherModel.class}, version = 1)
//public abstract class WeatherDatabase extends RoomDatabase{
//
//    private static WeatherDatabase INSTANCE;
//
//    public abstract WeatherDao weatherDao();
//
//    public static WeatherDatabase getDataBase(Context context) {
//        if (INSTANCE == null) {
//            String DATABASE_NAME = "Weather_Database";
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WeatherDatabase.class, DATABASE_NAME)
//                    .fallbackToDestructiveMigration()
//                    .build();
//        }
//        return INSTANCE;
//    }
//
//    public static void destroyInstance() {
//        INSTANCE = null;
//    }
//}
