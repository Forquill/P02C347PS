package sg.edu.rp.c346.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<CurrentHolidays> {
    private ArrayList<CurrentHolidays> currHolidays;
    private Context context;
    private TextView tvName , tvDate;
    private ImageView ivImage;

    public HolidayAdapter(Context context, int resource, ArrayList<CurrentHolidays> objects){
        super(context, resource, objects);
        currHolidays = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        ivImage = (ImageView) rowView.findViewById(R.id.ivImage);

        CurrentHolidays currHolidayList = currHolidays.get(position);

        tvName.setText(currHolidayList.getName());
        tvDate.setText(currHolidayList.getDate());
        ivImage.setImageResource(currHolidayList.getImage());

        return rowView;
    }
}
