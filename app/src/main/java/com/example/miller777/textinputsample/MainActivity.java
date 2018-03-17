package com.example.miller777.textinputsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCorrespondent;
    private TextView tvCount;
    private int count1;
    private static final int COUNT_LIMIT = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCorrespondent = (EditText) findViewById(R.id.et_input);
        tvCount = (TextView) findViewById(R.id.tv_count);
//        count = 0;

        etCorrespondent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                int etCorrLength = etCorrespondent.getText().toString().length();
                tvCount.setText(String.valueOf(etCorrLength));
                if (etCorrLength >= COUNT_LIMIT){
                    etCorrespondent.setText(etCorrespondent.getText().toString().substring(0, COUNT_LIMIT));
//                    etCorrespondent.setEnabled(false);
                    showMessage();
                } else {
//                    etCorrespondent.setEnabled(true);
                }
            }



            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void showMessage() {
        Toast.makeText(this, "Достигнута максимальная длина строки!", Toast.LENGTH_SHORT).show();
    }
}
