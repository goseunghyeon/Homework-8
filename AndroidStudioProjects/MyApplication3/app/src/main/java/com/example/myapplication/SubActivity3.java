package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class SubActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);
        ViewFlipper viewFlipper;
        Button btnprev,btnnext;
        Button insert=(Button)findViewById(R.id.button3);
        final EditText[] number = {(EditText) findViewById(R.id.editTextTextPersonName)};
        int[] num = {0};
        ImageView img=(ImageView)findViewById(R.id.imageView3);
        Integer[] color={R.drawable.yellow,R.drawable.red_white,R.drawable.purple,R.drawable.begie_sky,R.drawable.brown_navy,
        R.drawable.black,R.drawable.purple_red,R.drawable.black_blue,R.drawable.while_green,R.drawable.black_brown,
        R.drawable.red,R.drawable.blue_yellow,R.drawable.black_yellow,R.drawable.brown,R.drawable.purple_yellow,R.drawable.blue,R.drawable.black_green,
        R.drawable.brown_white,R.drawable.white_blue,R.drawable.green_red,R.drawable.white,R.drawable.brown_red,R.drawable.white_yellow,R.drawable.blue_red,
        R.drawable.yellow_red,R.drawable.pink,R.drawable.white_ligyellow,R.drawable.green_yellow,R.drawable.grey,R.drawable.purple_brown,R.drawable.green,R.drawable.black_purple,
        R.drawable.brown_blue,R.drawable.white_purple,R.drawable.red_black,R.drawable.gold};
        int img_number=0;
        TextView textView=(TextView)findViewById(R.id.textView5);
        String[] mind={"1.쓸쓸함%어리광\n표명상으로 명랑하고 사교적이지만 마은 한구석에는 외로움이...",
        "2.명량함&자신감뿜뿜\n명량하고 자신감이 넘치며 기쁨으로 가득 차 있습니다!","3.우울\n혹시 현재 감기에 걸리셨나요? 피로가 많이 쌓이셨네요ㅠㅠ",
        "4.소화기 불량\n어제 과식이나 과음하셨나요? 가슴이 아프고 위통으로 몸 상태가 좋지 않아요!","5.비노기불량\n화장실에 자주 가지 않나요? 알콜을 줄이세요!",
        "6.불신&의혹\n혹시 뜻하지 않게 보기 싫을 것을 보셨나요? 불안한 생각은 버리세요!","7.피\n혹시 피에 관련된 경험이 있나요? 무서운 생각은 NO!",
                "8.체념&거슬림\n하고 싶은 일을 못하게 되어 우울하신가요? 좋은 생각만 해요!","9,도움이 필요\n큰 걱정이 있으신가요? 당신은 해결 할 수 있어요!!",
        "10.금전욕&물질욕\n혹시 돈 떄문에 맘 걱정이 있으신가요? 마음을 차분하게 해야돼요!","11.자기주장욕\n매우 충실하고 활기가 넘치지만 남에게 강요는 NO!",
        "12.근심\n현재 근심이 많네요ㅠㅠ 근심 걱정은 버려요!","13.그리움\n혹시 할아버지,아버지,형제가 그리우신가요? 찾아가서 사랑을 표현해요!",
        "14.물욕&금전욕\n돈에 욕심이 많아요! 마음의 기준을 낮춰야해요!","15.건강의 적신호\n건강진단이 필요해요 병원으로 GO! GO!",
        "16.육체적 피로\n오늘은 푹 자야해요 너무나 몸이 피곤한 상태에요!","17.증오\n무언가 잊고 싶은데 잊지 못하는 상태인가요? 증오를 버려야 해요!!",
        "18.만족감&포만감\n혹시 원하는 것을 손에 넣었나요? 식사를 맛있게 하셨나요? 아주 평화로운 기분이네요!!","19.겸허한 체험\n솔직하고 순정적이지만 마은속으로는 체념해야하는 무언가가 있어요!",
        "20.이성에 대한 그리움\n꿈같은 연애를 하고 싶나요? 헤어진 연인이 그립나요? 이성에 관한 관심이 많아요!","21.봉사&헌신\n자신을 희생하면서 다른 이들을 생각하네요 그래도 자신이 제일 소중함을 잊지 말아요!!"
        ,"22.폭력성이 강함\n위험한 상태에요 마음의 평화가 긴급합니다!!","23.희망\n밝은 행복감이 넘치네요 모든 것에 우호적인 정신 상태입니다!",
        "24.초조함\n너무 초초한 상태에 있어요 짜증내지 말고 마음의 평화를 갖어야 해요!","25.만족감\n목적으로 한 것을 달성 했나요? 마응의 기분이 최고조에 올라있어요!",
        "26.밝지만 불안해요\n즐거운데 마음에 걸리는 일이 있나요? 얼른 버려요 그런 일은","27.절대자에 대한 사랑\n모든 것에 절대적인 것은 없어요 당신이 가장 소중해요!",
        "28.허기\n배고픈 가요? 혹시 극한의 다이어트중? 오늘은 많이 먹어야 해요!","29.망설임&불안\n선택 장애에 빠지 셨나요? 그냥 선택해 버려요!",
                "30.소화기 불량\n소화가 잘 안되시나요? 천천히 먹어야 해요","31.수면\n수면부족이 계속되고 밤을 꼬박 새기도 했군요 오늘은 푹 자요!",
        "32.정서불안\n이유 없는 불안에 빠져 계시나요? 어서 나와야해요!","33.결벽증\n나쁘지는 않지만 잘 해결해 보아요","34.회복\n몸과 정신이 완전히 회복 되었군요 좋아요!",
        "35.그리움\n평소 가깝게 지내던 여성이 그리우신가요? 얼른 가서 만나세요!","36.애정결핍\n사랑이 필요한 상태군요 당신도 충분히 사랑 받아야하는 존재입니다!"};
        Button button4=(Button)findViewById(R.id.button4);
        btnprev=(Button)findViewById(R.id.btnPrev);
        btnnext=(Button)findViewById(R.id.btnNext);
        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper1);

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num[0] =Integer.parseInt(number[0].getText().toString());
                img.setImageResource(color[num[0]-1]);
                textView.setText(mind[num[0]-1]);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //img.setImageResource(color[num[0]-1]);
        img.setVisibility(View.VISIBLE);

    }
}