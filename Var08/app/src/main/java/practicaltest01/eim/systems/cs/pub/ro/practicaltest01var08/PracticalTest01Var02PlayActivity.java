package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {
    EditText riddleTwo;
    EditText answerTwo;
    EditText attempt;
    Button check;
    Button back;
    ButtonClickListener buttonClickListener = new ButtonClickListener();
    int serviceStatus = 0; // oprit

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == back.getId()){
                finish();
            }

            if (view.getId() == check.getId()){
                if (!attempt.getText().toString().equals(answerTwo.getText().toString())){
                    Toast.makeText(PracticalTest01Var02PlayActivity.this, "doesn't match", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(PracticalTest01Var02PlayActivity.this, "match", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        riddleTwo = (EditText) findViewById(R.id.riddle_edit_two);
        answerTwo = (EditText)  findViewById(R.id.answer_edit_two);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("riddle")){
            riddleTwo.setText(intent.getStringExtra("riddle"));

        }
        if (intent != null && intent.getExtras().containsKey("answer")){
            answerTwo.setText(intent.getStringExtra("answer"));

        }

        attempt = (EditText)  findViewById(R.id.attempt_edit);

        check =  (Button) findViewById(R.id.check_button);
        check.setOnClickListener(buttonClickListener);

        back =  (Button) findViewById(R.id.back_button);
        back.setOnClickListener(buttonClickListener);

        if (serviceStatus == 0) {
            serviceStatus = 1;

            Intent intentService = new Intent(getApplicationContext(), MyService.class);
            intent.putExtra("answerTwo", answerTwo.getText().toString());
            // pornesti serviciul
            getApplicationContext().startService(intentService);

        }


    }
    @Override
    protected void onDestroy() {
        Intent intentser = new Intent(this, MyService.class);
        stopService(intentser);
        super.onDestroy();
    }
}
