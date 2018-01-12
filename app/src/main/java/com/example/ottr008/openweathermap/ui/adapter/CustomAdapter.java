package com.example.ottr008.openweathermap.ui.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ottr008.openweathermap.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vibitha on 8/3/17.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final List<com.example.ottr008.openweathermap.model.forecastresponsemodel.List> list;
    private static final int TO_SECONDS = 1000;
    private static final int MONTH_3 = 3;
    private static final int MONTH_4 = 4;
    private static final int MONTH_5 = 5;
    private static final int MONTH_6 = 6;
    private static final int MONTH_7 = 7;
    private static final int MONTH_8 = 8;
    private static final int MONTH_9 = 9;
    private static final int MONTH_10 = 10;
    private static final int MONTH_11 = 11;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView date,lowTemp,highTemp,month;
        private ImageView weatherImage;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            lowTemp = (TextView) view.findViewById(R.id.lowtemp);
            highTemp = (TextView) view.findViewById(R.id.hightemp);
            month = (TextView) view.findViewById(R.id.month);
            weatherImage = (ImageView) view.findViewById(R.id.rowimage);
        }
    }


    @Inject
    public CustomAdapter(List<com.example.ottr008.openweathermap.model.forecastresponsemodel.List> list) {
        this.list = list;

    }

    @Override
    public final MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_rowitems, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public final void onBindViewHolder(MyViewHolder holder, int position) {

        com.example.ottr008.openweathermap.model.forecastresponsemodel.List rowPos = list.get(position);
        switch(rowPos.getWeather().get(0).getDescription())
        {
            case "light rain":
                holder.weatherImage.setImageResource(R.drawable.lightrain);
                break;

            case "moderate rain":
                holder.weatherImage.setImageResource(R.drawable.moderate_rain);
                break;

            case "heavy intensity rain":
                holder.weatherImage.setImageResource(R.drawable.heavyrain);
                break;

            case "sky is clear":
                holder.weatherImage.setImageResource(R.drawable.sunnycloud);
                break;
            default:
                holder.weatherImage.setImageResource(R.drawable.sunnycloud);
                break;

        }

        holder.lowTemp.setText(rowPos.getTemp().getMin().toString());
        holder.highTemp.setText(rowPos.getTemp().getMax().toString());
        Long dateValue = rowPos.getDt().longValue()*TO_SECONDS;
        Date date=new Date(dateValue);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String dayOfWeek = c.get(Calendar.DAY_OF_MONTH) +"";
        int month = c.get(Calendar.MONTH);

            switch (month)
            {
                case 0:
                    holder.month.setText("January");
                    break;

                case 1:
                    holder.month.setText("February");
                    break;

                case 2:
                    holder.month.setText("March");
                    break;

                case MONTH_3:
                    holder.month.setText("April");
                    break;

                case MONTH_4:
                    holder.month.setText("May");
                    break;

                case MONTH_5:
                    holder.month.setText("June");
                    break;

                case MONTH_6:
                    holder.month.setText("July");
                    break;

                case MONTH_7:
                    holder.month.setText("August");
                    break;

                case MONTH_8:
                    holder.month.setText("September");
                    break;

                case MONTH_9:
                    holder.month.setText("October");
                    break;

                case MONTH_10:
                    holder.month.setText("November");
                    break;

                case MONTH_11:
                    holder.month.setText("December");
                    break;

            }

        holder.date.setText(dayOfWeek);
    }

    @Override
    public final int getItemCount() {
        return list.size();
    }
}