package com.example.tu4.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tu4.R;
import com.example.tu4.adapter.SystemInformationListviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemInformationActivity extends AppCompatActivity {
    @BindView(R.id.img_my_works_return)
    ImageView imgMyWorksReturn;
    private String[] name = {"通知标题", "通知标题", "通知标题", "通知标题",};
    private String[] text = {"内容1111111111111", "内容1111111111111", "内容1111111111111",
            "内容1111111111111",};
    private String[] time = {"2016-05-05", "2016-06-06", "2016-07-07", "2016-08-08",};

    @BindView(R.id.lvSystemInformation)
    ListView lvSystemInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_information);
        ButterKnife.bind(this);
        lvSystemInformation.setAdapter(new SystemInformationListviewAdapter(this, name, text,
                time));

    }

    @OnClick(R.id.img_my_works_return)
    public void onClick() {
        //转跳到我的留言界面
    }
}
