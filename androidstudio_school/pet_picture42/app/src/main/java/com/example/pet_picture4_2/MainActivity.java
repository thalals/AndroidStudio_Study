package com.example.pet_picture4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoCat1,rdoCat2,rdoCat3;
    Button btnOk;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");

        text1 = (TextView)findViewById(R.id.Text1);
        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        text2 = (TextView)findViewById(R.id.Text2);
        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdoCat1 = (RadioButton)findViewById(R.id.RdoCat1);
        rdoCat2 = (RadioButton)findViewById(R.id.RdoCat2);
        rdoCat3 = (RadioButton)findViewById(R.id.RdoCat3);

        btnOk = (Button)findViewById(R.id.BtnOk);
        imgPet = (ImageView)findViewById(R.id.ImgPet);

//       시작함 체크박스 체크 유/무
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });


        //선택완료 리스너
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoCat1:
                        imgPet.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.RdoCat2:
                        imgPet.setImageResource(R.drawable.cat2);
                        break;
                    case R.id.RdoCat3:
                        imgPet.setImageResource(R.drawable.cat3);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}