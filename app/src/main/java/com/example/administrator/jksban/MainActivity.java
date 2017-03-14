package com.example.administrator.jksban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendar;
    private ImageButton calendarLeft;
    private TextView calendarCenter;
    private ImageButton calendarRight;
    private SimpleDateFormat format;
    private String[]duty={"一","二","三","四","五","六","七"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   calendar.setSelectMore(false);
        calendarCenter=(TextView) findViewById(R.id.calendarCenter);
        calendar=(CalendarView) findViewById(R.id.calendar);
        calendarLeft=(ImageButton) findViewById(R.id.calendarLeft);
        calendarRight=(ImageButton)findViewById(R.id.calendarRight);
        format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //设置日历日期
            Date date = format.parse("2015-01-01");
            calendar.setCalendarData(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //获取日历中年月 ya[0]为年，ya[1]为月（格式大家可以自行在日历控件中改）
        String[] ya = calendar.getYearAndmonth().split("-");
        calendarCenter.setText("监控室值班表"+ya[0]+"年"+ya[1]+"月");
        calendarCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你好无聊哦,不要再点我了", Toast.LENGTH_SHORT).show();
            }
        });
        calendarLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //点击上一月 同样返回年月
                String leftYearAndmonth = calendar.clickLeftMonth();
                String[] ya = leftYearAndmonth.split("-");
                calendarCenter.setText("监控室值班表"+ya[0]+"年"+ya[1]+"月");
            }
        });

        calendarRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //点击下一月
                String rightYearAndmonth = calendar.clickRightMonth();
                String[] ya = rightYearAndmonth.split("-");
                calendarCenter.setText("监控室值班表"+ya[0]+"年"+ya[1]+"月");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item1:
                Toast.makeText(this,"田海燕",Toast.LENGTH_SHORT).show();
                calendar.setCellBG("海燕");
                break;
            case R.id.add_item2:
                Toast.makeText(this,"鲍晓璐",Toast.LENGTH_SHORT).show();
                calendar.setCellBG("晓璐");
                break;
            case R.id.add_item3:
                Toast.makeText(this,"黄小菁",Toast.LENGTH_SHORT).show();
                calendar.setCellBG("小菁");
                break;
            case R.id.add_item4:
                Toast.makeText(this,"傅巧巧",Toast.LENGTH_SHORT).show();
                calendar.setCellBG("巧巧");
                break;
            case R.id.add_item5:
                Toast.makeText(this,"金开航",Toast.LENGTH_SHORT).show();
                calendar.setCellBG("开航");
                break;

            default:
        }
        return true;

    }

}
