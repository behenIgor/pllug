package com.igor.weatherapi.autocompletetextview_retrofit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.igor.weatherapi.autocompletetextview_retrofit.api.APIClient;
import com.igor.weatherapi.autocompletetextview_retrofit.api.GoogleMapAPI;
import com.igor.weatherapi.autocompletetextview_retrofit.entities.Prediction;
import com.igor.weatherapi.autocompletetextview_retrofit.entities.Predictions;
import com.igor.weatherapi.R;

import java.util.ArrayList;
import java.util.List;

public class PlacesAutoCompleteAdapter extends ArrayAdapter<Prediction> {

    private Context context;
    private List<Prediction> predictions;

    public PlacesAutoCompleteAdapter(Context context, List<Prediction> predictions) {
        super(context, R.layout.place_row_layout, predictions);
        this.context = context;
        this.predictions = predictions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.place_row_layout, null);
        if (predictions != null && predictions.size() > 0) {
            Prediction prediction = predictions.get(position);
            TextView textViewName = view.findViewById(R.id.textViewName);
            textViewName.setText(prediction.getDescription());
        }
        return view;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new PlacesAutoCompleteFilter(this, context);
    }

    private class PlacesAutoCompleteFilter extends Filter {

        private PlacesAutoCompleteAdapter placesAutoCompleteAdapter;
        private Context context;

        public PlacesAutoCompleteFilter(PlacesAutoCompleteAdapter placesAutoCompleteAdapter, Context context) {
            super();
            this.placesAutoCompleteAdapter = placesAutoCompleteAdapter;
            this.context = context;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            try {
                placesAutoCompleteAdapter.predictions.clear();
                FilterResults filterResults = new FilterResults();
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.values = new ArrayList<Prediction>();
                    filterResults.count = 0;
                } else {
                    GoogleMapAPI googleMapAPI = APIClient.getClient().create(GoogleMapAPI.class);
                    Predictions predictions = googleMapAPI.getPlacesAutoComplete(charSequence.toString(), "geocode", "en", context.getString(R.string.google_maps_key)).execute().body();
                    filterResults.values = predictions.getPredictions();
                    filterResults.count = predictions.getPredictions().size();
                }
                return filterResults;
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            placesAutoCompleteAdapter.predictions.clear();
            placesAutoCompleteAdapter.predictions.addAll((List<Prediction>) filterResults.values);
            placesAutoCompleteAdapter.notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            Prediction prediction = (Prediction) resultValue;
            return prediction.getDescription();
        }
    }

}
