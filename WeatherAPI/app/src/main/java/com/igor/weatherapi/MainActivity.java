package com.igor.weatherapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.igor.weatherapi.autocompletetextview_retrofit.adapters.PlacesAutoCompleteAdapter;
import com.igor.weatherapi.autocompletetextview_retrofit.entities.Prediction;
import com.igor.weatherapi.models.WeatherApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView responseText;

    private AutoCompleteTextView  autoCompleteTextViewPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        autoCompleteTextViewPlace = findViewById(R.id.searching_et);
        loadData();

    }


    private void loadData() {
        List<Prediction> predictions = new ArrayList<>();
        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = new PlacesAutoCompleteAdapter(getApplicationContext(), predictions);
        autoCompleteTextViewPlace.setThreshold(1);
        autoCompleteTextViewPlace.setAdapter(placesAutoCompleteAdapter);
    }


    private void init() {

        autoCompleteTextViewPlace = findViewById(R.id.searching_et);
        button = findViewById(R.id.searching_btn);
        responseText = findViewById(R.id.resulttext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherDetails();
            }
        });
    }

    private void weatherDetails() {

        Retrofit retrofit = NetworkClient.getRetrofitClient();

        WeatherAPIs weatherAPIs = retrofit.create(WeatherAPIs.class);

        Call call = weatherAPIs.getWeatherByCity(autoCompleteTextViewPlace.getText().toString(), "235bef5a99d6bc6193525182c409602c");

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.body() != null) {
                    WeatherApi wResponse = (WeatherApi) response.body();
                    responseText.setText(
                            "Temp: " + wResponse.getMain().getTemp() + "\n " +
                                    "Humidity: " + wResponse.getMain().getHumidity() + "\n" +
                                    "Pressure: " + wResponse.getMain().getPressure() + "\n" +

                                    "Wind.Speed: " + wResponse.getWind ().getSpeed() + "\n" +
                                    "Clouds: " + wResponse.getClouds().getAll() + "\n " +
                                    "Sunrise: " + wResponse.getSys().getSunrise() + "\n" +
                                    "Sunset: " + wResponse.getSys().getSunset() + "\n" +
                                    "Country: " + wResponse.getSys().getCountry() + "\n" +
                                    "Coord.Lon: " + wResponse.getCoord().getLon() + "\n" +
                                    "Coord.Lat: " + wResponse.getCoord().getLat());

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
