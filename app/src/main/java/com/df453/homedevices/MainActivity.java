package com.df453.homedevices;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import android.util.Log;
import android.widget.EditText;
import android.text.InputType;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String ip;
    private String message;
    private boolean isError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = getString(R.string.ip);
    }

    //Method to manage Ip settings
    public void settings(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New IP Address");
        final EditText input = new EditText(this);
        input.setText(ip);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ip = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    //Get request method which does the required get request for each switch as per url given
    public void GetRequest(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response:", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        message = "Error doing get request";
                        Log.d("Error response:", error.toString());
                        isError = true;
                    }
                }
        );
        queue.add(getRequest);
        if(isError) {
            (Toast.makeText(this, this.message, Toast.LENGTH_SHORT)).show();
            isError = false;
        }
    }

    //Below are switch functions which are copy pasted
    public void switch1(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light1?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch2(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light2?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch3(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light3?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch4(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light4?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch5(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light5?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch6(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light6?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
    public void switch7(View view) {
        boolean state = ((Switch)view).isChecked();
        String url = "http://"+ip+":5000/light7?status=";
        if(state)
        {
            url = url+"on";
        }
        else {
            url = url+"off";
        }
        GetRequest(url);
    }
}