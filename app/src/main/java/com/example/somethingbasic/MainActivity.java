package com.example.somethingbasic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText month = (EditText) findViewById(R.id.Task3Month);
        TextView season = (TextView) findViewById(R.id.Task3Season);
        month.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Integer.parseInt(s.toString()) == 12 || Integer.parseInt(s.toString()) == 1 || Integer.parseInt(s.toString()) == 2)
                {
                    season.setText("Зима");
                }
                else if(Integer.parseInt(s.toString()) == 3 || Integer.parseInt(s.toString()) == 4 || Integer.parseInt(s.toString()) == 5)
                {
                    season.setText("Весна");
                }
                else if(Integer.parseInt(s.toString()) == 6 || Integer.parseInt(s.toString()) == 7 || Integer.parseInt(s.toString()) == 8)
                {
                    season.setText("Лето");
                }
                else if(Integer.parseInt(s.toString()) == 9 || Integer.parseInt(s.toString()) == 10 || Integer.parseInt(s.toString()) == 11)
                {
                    season.setText("Осень");
                }
                else
                {
                    season.setText("Неизвестный месяц");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText letter = (EditText) findViewById(R.id.Task5Letter);
        StringBuilder result = new StringBuilder("");
        TextView letters = (TextView) findViewById(R.id.Task5Letters);
        letter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int let = Integer.parseInt(String.valueOf(s.charAt(0)));
                StringBuilder temp = new StringBuilder("");
                if(String.valueOf(s.charAt(0)).equals("z"))
                {
                    temp.append("abc");
                } else if(String.valueOf(s.charAt(0)).equals("y"))
                {
                    temp.append("zab");
                } else if(String.valueOf(s.charAt(0)).equals("x"))
                {
                    temp.append("yza");
                }
                else{
                    temp.append((char)(let + 1) + (char)(let + 2) + (char)(let + 3));
                }
                letters.setText(temp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextView days = (TextView) findViewById(R.id.Task4Result);
        int a = 10;

        for(int i = 1; i <= 10; i++)
        {
            result.append("День " + i + " : " + a + "\n");
            a += a*0.1;
        }
        a = 10;
        int sum = a;
        for(int i = 0; i < 7; i++)
        {
            a += a*0.1;
            sum += a;
        }
        result.append("Суммарный путь за 7 дней  = " + sum + "\n");
        a = 10;
        int j = 0;
        while(a < 80)
        {
            j++;
            a += a*0.1;
        }
        result.append("Следует прекратить на " + j + " день");

        days.setText(result);
        result = new StringBuilder("");

        for (int i = 1000; i <= 9999; i++)
        {
            if (ifHasDThree(i))
                result.append(i + "\n");
        }

        TextView numbers = (TextView)findViewById(R.id.Task4Numbers);
        numbers.setText(result);
    }

    boolean ifHasDThree(int n) {
        while (n > 0)
        {
            if (n % 10 == 3) return true;
            n /= 10;
        }
        return false;
    }

    public void Task2(View view) {
        EditText editText = (EditText) findViewById(R.id.Task2);
        TextView textView = (TextView) findViewById(R.id.Task2Result);

        int a = Integer.parseInt(String.valueOf(editText.getText()));
        textView.setText("Square = " + (a * a)+ "\t cube = " + (a * a * a));
    }

    public void Task2Katet(View view) {
        EditText editText1 = (EditText) findViewById(R.id.Task2Katet1);
        EditText editText2 = (EditText) findViewById(R.id.Task2Katet2);
        TextView textView = (TextView) findViewById(R.id.Task2KatetResult);

        int a = Integer.parseInt(String.valueOf(editText1.getText()));
        int b = Integer.parseInt(String.valueOf(editText2.getText()));
        textView.setText("Area = " +( 0.5 * (a * b))+ "\t Gipot = " + Math.sqrt(a*a + b*b) + "\tPerim = " + (a + b + Math.sqrt(a*a + b*b)));
    }

    public void Task3Result(View view) {
        EditText first = (EditText) findViewById(R.id.Task3First);
        EditText second = (EditText) findViewById(R.id.Task3Second);
        EditText third = (EditText) findViewById(R.id.Task3Third);
        TextView thirdresult = (TextView) findViewById(R.id.Task3Result);

        int a = Integer.parseInt(String.valueOf(first.getText()));
        int b = Integer.parseInt(String.valueOf(second.getText()));
        int c = Integer.parseInt(String.valueOf(third.getText()));

        if(a > 5)
        {
            if(b >= a)
            {
                thirdresult.setText("yes");
            }
            else if(c >= a)
            {
                thirdresult.setText("yes");
            }
        }
        if(b > 5)
        {
            if(c >= b)
            {
                thirdresult.setText("yes");
            }
        }
        else
        {
            thirdresult.setText("no");
        }
    }

    public void Task4Result(View view) {
        EditText days = (EditText) findViewById(R.id.Task4Days);
        TextView result = (TextView) findViewById(R.id.Task4ResultManual);

        int a = 10;
        int sum = 10;
        int b = Integer.parseInt(String.valueOf(days.getText()));

        for(int i = 1; i <= b; i++)
        {
            a += a*0.1;
            sum += a;
        }

        result.setText("Суммарный путь за " + b + " дней тренировок = " + String.valueOf(sum));
    }

}