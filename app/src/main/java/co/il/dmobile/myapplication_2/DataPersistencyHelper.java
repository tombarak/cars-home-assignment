package co.il.dmobile.myapplication_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars );
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json == null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.toyota,"Toyota","Autocar India", "2022", "30,000"));
            cars.add(new Car(R.drawable.honda,"Honda","MPG & Specs", "2022", "35,000"));
            cars.add(new Car(R.drawable.volvo,"Volvo","XC90", "2022", "200,000"));
            cars.add(new Car(R.drawable.volkswagen,"Volkswagen","Autocar India", "2019", "60,000"));
            cars.add(new Car(R.drawable.renault,"Renault","Magen RS", "2018", "80,000"));
            cars.add(new Car(R.drawable.mercedes,"Mercedes","AMG GT Coupe", "2022", "1,500,000"));
            cars.add(new Car(R.drawable.ferrari,"Ferrari","Portofino M", "2002", "1,650,000"));
            cars.add(new Car(R.drawable.mclaren,"Mclaren","Artura", "2002", "1,800,000"));
            return cars;
        }
    }

}
