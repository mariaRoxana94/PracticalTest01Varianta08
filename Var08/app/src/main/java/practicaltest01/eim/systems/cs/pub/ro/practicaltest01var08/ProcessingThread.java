package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by MARY on 4/2/2018.
 */

public class ProcessingThread extends Thread {

    Context context;
    boolean isRunning = true;
    Random random = new Random();
    int answer;

    public ProcessingThread(Context context, int answerTwo) {
        this.context =  context;
        this.answer = answerTwo;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            Log.d("[sendMessage]", "something");
            sleep();
            Log.d("[sleep]", "Doarme");
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("actiune1");
        String answer2 = String.valueOf(answer);
        String text = answer2.replace("2","*");
        intent.putExtra("message", text);
        Log.d("[!!!SendMessage]", text);

        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            // la fiecare 5 sec se trm cate un msj
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stopThread() {
        isRunning = false;
    }
}
