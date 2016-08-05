package ca.kgb.okhttpasync;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String urlStrg = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void DoMagic(View view) {
        OkHttpClient client = new OkHttpClient();
        Request httpRequest = new Request.Builder()
                .url(urlStrg)
                .build();

        try {
            Response response = client.newCall(httpRequest).execute();
            Log.d(TAG, "DoMagic: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return response.body().string();
    }
}

