package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {
    EditText riddle;
    EditText answer;
    Button play;
    int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == play.getId() && !riddle.getText().toString().equals("") && !answer.getText().toString().equals("")) {
                Intent intent = new Intent(PracticalTest01Var08MainActivity.this, PracticalTest01Var02PlayActivity.class);
                intent.putExtra("riddle", riddle.getText().toString());
                intent.putExtra("answer", answer.getText().toString());

                startActivityForResult(intent,SECONDARY_ACTIVITY_REQUEST_CODE);
            }

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddle = (EditText) findViewById(R.id.riddle_edit);
        answer = (EditText) findViewById(R.id.answer_edit);
        riddle.setText("eimAndroid");
        answer.setText("Androideim");


        play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("riddle")) {
                riddle.setText(savedInstanceState.getString("riddle"));
            }
            if (savedInstanceState.containsKey("answer")) {
                riddle.setText(savedInstanceState.getString("answer"));
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("riddle", riddle.getText().toString());
        outState.putString("answer", answer.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("riddle")) {
            riddle.setText(savedInstanceState.getString("riddle"));
        }
        if (savedInstanceState.containsKey("answer")) {
            riddle.setText(savedInstanceState.getString("answer"));
        }
    }
}
