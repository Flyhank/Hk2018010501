package com.n9s.flyjet.hk2018010501;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int ch = -1; //-1: 沒選
    int temp = -1;
    boolean[] chks = new boolean[5]; //多重選單

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View v) {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("This is a Practice!");
        budr.setMessage("Hello!");
        //budr.show();

        budr.setPositiveButton("確定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "你按了確定...", Toast.LENGTH_SHORT).show();
            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "你按了取消...", Toast.LENGTH_SHORT).show();
            }
        });

        budr.setNeutralButton("沒意見", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "你不表示意見..", Toast.LENGTH_SHORT).show();
            }
        });
        budr.show();
    }

    public void click2(View v)

    {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("This is a Titile");
        final EditText ed = new EditText(MainActivity.this);
        final TextView tv = (TextView) findViewById(R.id.textView);
        ed.setText(tv.getText().toString());

        budr.setView(ed);
        budr.setPositiveButton("確定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //Toast.makeText(MainActivity.this, "你按了確定...", Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "你按了取消...", Toast.LENGTH_SHORT).show();
            }
        });
        budr.show();
    }

    public void click3(View v)  //外表型對話框
    {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("選擇表單");
        final String fruits[] = {"蘋果", "香蕉", "梨子"}; //點蘋果則內部值為"1",
        final TextView tv2 = (TextView) findViewById(R.id.textView2);

        budr.setItems(fruits, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                    tv2.setText(fruits[i]);     //有int i,就可直接顯示選擇的項目
            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
            }
        });
        budr.setCancelable(false);  //取消
        budr.show();
    }

    public void click4(View v)  //選項型對話框
    {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("選擇表單");
        final String fruits[] = {"蘋果", "香蕉", "梨子"};
        final TextView tv3 = (TextView) findViewById(R.id.textView3);
        temp = ch; //先清除狀態

        budr.setSingleChoiceItems(fruits, ch, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                temp = i;  //選了項目卻按取消會被記錄,以此先暫存,若再開啟才會保留等按確定再顯示
            }
        });

        budr.setPositiveButton("確定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                ch = temp; //按確定再顯示
                tv3.setText(fruits[ch]);
            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
            }
        });
        budr.show();
    }

    public void click5(View v)
    {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("選擇表單");
        final String fruits[] = {"蘋果", "香蕉", "梨子", "西瓜", "鳳梨"};
        final TextView tv4 = (TextView) findViewById(R.id.textView4);
        budr.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        budr.setPositiveButton("確定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int position)
            {
                StringBuilder sb = new StringBuilder(); //String+String, StringBuilder節省記憶位置
                for (int i=0; i<=4;i++)
                {
                    if (chks[i])  //若為true, 繼續
                    {
                        sb.append(fruits[i] + ",");     //
                    }
                }
                tv4.setText(sb.toString());
            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
            }
        });
        budr.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder budr = new AlertDialog.Builder(MainActivity.this);
        budr.setTitle("This is title");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1 = inflater.inflate(R.layout.layout1, null);

        final TextView tv = v1.findViewById(R.id.textView5);
        Button btn1 = v1.findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello Friend!");
            }
        });
        budr.setView(v1);

        budr.setPositiveButton("確定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });

        budr.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
            }
        });
        budr.show();

    }
}

