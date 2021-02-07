package com.tp.exercice3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BackActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);
        Button call = (Button) findViewById(R.id.call_button);
        Intent intent_ = getIntent();
        String tel = intent_.getStringExtra("tel");
        TextView num = (TextView) findViewById(R.id.num);
        num.setText(tel);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel, null));
                startActivity(intent);
            }
        });
    }
}
