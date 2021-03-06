package com.example.tu4.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tu4.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplaintsSuggestionsActivity extends AppCompatActivity {

    @BindView(R.id.imgbt_complaint_type)
    ImageButton imgbtComplaintType;

    RadioGroup rgComplaintType;
    @BindView(R.id.tv_complaint_type)
    TextView tvComplaintType;
    @BindView(R.id.bt_complaint_push)
    Button btComplaintPush;

    private View popupView;
    private PopupWindow mPopupWindow;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_suggestions);
        ButterKnife.bind(this);

        tvComplaintType.setText("请选择意见类型");
        imgbtComplaintType.setImageResource(R.mipmap.ic_arrow_bottom);

        popupView = LayoutInflater.from(this).inflate(R.layout.activity_complaint_popupwindow,
                null);
        rgComplaintType = (RadioGroup) popupView.findViewById(R.id.rg_complaint_type);

        imgbtComplaintType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
                imgbtComplaintType.setImageResource(R.mipmap.ic_arrow_top);

            }
        });
        rgComplaintType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) popupView.findViewById(checkedId);
                String s = radioButton.getText().toString();
                tvComplaintType.setText(s);
                mPopupWindow.dismiss();
                imgbtComplaintType.setImageResource(R.mipmap.ic_arrow_bottom);
            }
        });

    }

    /**
     * 显示投诉建议的类型
     *
     * @param v
     */
    void showPopup(View v) {

        mPopupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar
                .LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x000000));
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAsDropDown(v, 10, 60);
    }

    @OnClick(R.id.bt_complaint_push)
    public void onClick() {
        Intent intent = new Intent(ComplaintsSuggestionsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}