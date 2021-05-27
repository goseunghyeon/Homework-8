package com.example.myapplication_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

/***************************************************
 * 프로그램명:activity-main.xml
 * 작성자: 2016039086 고승현
 * 작성일: 2021.03.19
 * 프로그램설명: My_Application_1프로그램
 * 버튼1번:토스트기능
 * 버튼2번:텍스트 입력시 홈페이지이동
 * 라디오버튼1번:기본이미지 출력
 * 라이도버튼2번:다른이미지 출력
 ***************************************************/
public class MainActivity extends AppCompatActivity {
    Button button3;
    EditText editText;
    RadioGroup rg;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        button3=(Button)findViewById(R.id.button3);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        img=(ImageView)findViewById(R.id.imageView2);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
             if(i==R.id.radioButton10){
                 img.setImageResource(R.drawable.images1);
             }
             else if(i==R.id.radioButton11){
                 img.setImageResource(R.drawable.images2);
             }
             else
                 img.setImageResource(R.drawable.images1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"버튼이 눌렸어요",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClickOpenUrl(View view) {
        String url=editText.getText().toString();
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}