package sg.edu.rp.c346.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Holiday extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        Intent i = getIntent();
        String name = i.getStringExtra("positionName");
        TextView tvName = (TextView) findViewById(R.id.tvHolidayType);
        tvName.setText(name);

        lv = (ListView) findViewById(R.id.lvHolidays);

        ArrayList<CurrentHolidays> secularHolidays = new ArrayList<CurrentHolidays>();
        secularHolidays.add(new CurrentHolidays("New Year's Day","1 January 2020", R.drawable.new_year));
        secularHolidays.add(new CurrentHolidays("Labour Day","1 May 2020",R.drawable.labour_day));
        secularHolidays.add(new CurrentHolidays("Christmas Day", "25 December 2020",R.drawable.christmas));

        ArrayList<CurrentHolidays> EthnicAndReligionHolidays = new ArrayList<CurrentHolidays>();
        EthnicAndReligionHolidays.add(new CurrentHolidays("Chinese New Year","25 - 26 January", R.drawable.cny));
        EthnicAndReligionHolidays.add(new CurrentHolidays("Good Friday","10 April", R.drawable.goodfriday));
        EthnicAndReligionHolidays.add(new CurrentHolidays("Vesak Day","7 May 2020", R.drawable.vesak_day));
        EthnicAndReligionHolidays.add(new CurrentHolidays("Hari Raya Puasa","24 May 2020", R.drawable.hari_raya_puasa));
        EthnicAndReligionHolidays.add(new CurrentHolidays("Hari Raya Haji","31 July 2020", R.drawable.hari_raya_haji));
        EthnicAndReligionHolidays.add(new CurrentHolidays("National Day","9 August 2020",R.drawable.national_day));
        EthnicAndReligionHolidays.add(new CurrentHolidays("Deepavali","14 November 2020", R.drawable.deepavali));

        if (name.contentEquals("Secular")){
            aa = new HolidayAdapter(this, R.layout.row , secularHolidays);
            lv.setAdapter(aa);
        }
        else{
            aa = new HolidayAdapter(this, R.layout.row , EthnicAndReligionHolidays);
            lv.setAdapter(aa);
        }
    }
}
