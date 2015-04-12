/*
/
/参考サイト(StackOverFlow)
/http://ja.stackoverflow.com/questions/8766/android%E3%81%AEevernote%E3%81%AE%E3%83%95%E3%83%AD%E3%83%BC%E3%83%86%E3%82%A3%E3%83%B3%E3%82%B0%E3%81%AA%E3%83%9C%E3%82%BF%E3%83%B3%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6
/
 */

package com.kawakawaplanning.floattest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    LinearLayout[] ll = null;
    ImageView[] img = null;
    ImageView iv_plus = null;
    float scale = 0;
    float scaled_px1 = 0;
    float scaled_px2 = 0;
    boolean menu_opened = false;
    TextView item6Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findItemView();
        item6Tv.setText("ソースを見る。");
    }

    @Override
    public void onResume() {
        super.onResume();
        get_scale();
    }

    private void findItemView() {

        iv_plus = (ImageView) findViewById(R.id.plus_ic);
        
        ll = new LinearLayout[6];
        ll[0] = (LinearLayout)findViewById(R.id.item1);
        ll[1] = (LinearLayout)findViewById(R.id.item2);
        ll[2] = (LinearLayout)findViewById(R.id.item3);
        ll[3] = (LinearLayout)findViewById(R.id.item4);
        ll[4] = (LinearLayout)findViewById(R.id.item5);
        ll[5] = (LinearLayout)findViewById(R.id.item6);
        
        img = new ImageView[6];
        img[0] = (ImageView)findViewById(R.id.imgitem1);
        img[1] = (ImageView)findViewById(R.id.imgitem2);
        img[2] = (ImageView)findViewById(R.id.imgitem3);
        img[3] = (ImageView)findViewById(R.id.imgitem4);
        img[4] = (ImageView)findViewById(R.id.imgitem5);
        img[5] = (ImageView)findViewById(R.id.imgitem6);
        
        for(int i = 0;i < img.length;i++ ) {
            img[i].setOnClickListener(this);
        }
        iv_plus.setOnClickListener(this);

        item6Tv = (TextView)findViewById(R.id.item6Tv);
    }

    private void get_scale() {
        scale = getResources().getDisplayMetrics().density;
        scaled_px1 = -384 * scale;
        scaled_px2 = 64 * scale;
    }

    private void menu_open() {
        iv_plus.animate().setInterpolator(new OvershootInterpolator());
        iv_plus.animate().setDuration(100);
        iv_plus.animate().rotation(135).alpha(0.9f);
        for (int i = 0, j = ll.length; i < j; i++) {
            ll[i].animate().setInterpolator(new AccelerateDecelerateInterpolator());
            ll[i].animate().setDuration(100);
            ll[i].animate().x(0).y(scaled_px1 + (scaled_px2 * i)).alpha(0.9f);
        }
    }

    private void menu_close() {
        iv_plus.animate().setInterpolator(new OvershootInterpolator());
        iv_plus.animate().setDuration(100);
        iv_plus.animate().rotation(0).alpha(0.9f);
        for (int i = 0, j = ll.length; i < j; i++) {
            ll[i].animate().setInterpolator(new LinearInterpolator());
            ll[i].animate().setDuration(100);
            ll[i].animate().x(0).y(0).alpha(0f);
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imgitem1:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム1が選択されました。",Toast.LENGTH_SHORT).show();
                menu_opened = false;
                break;
            case R.id.imgitem2:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム2が選択されました。",Toast.LENGTH_SHORT).show();
                menu_opened = false;
                break;
            case R.id.imgitem3:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム3が選択されました。",Toast.LENGTH_SHORT).show();
                menu_opened = false;
                break;
            case R.id.imgitem4:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム4が選択されました。",Toast.LENGTH_SHORT).show();
                menu_opened = false;
                break;
            case R.id.imgitem5:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム5が選択されました。",Toast.LENGTH_SHORT).show();
                menu_opened = false;
                break;
            case R.id.imgitem6:
                menu_close();
                Toast.makeText(MainActivity.this,"アイテム6が選択されました。",Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("https://github.com/KawakawaRitsuki/FloatTest");
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                menu_opened = false;
                break;
            case R.id.plus_ic:
                if (!menu_opened) {
                    menu_opened = true;
                    menu_open();
                } else {
                    menu_opened = false;
                    menu_close();
                }
                break;
        }

    }
}