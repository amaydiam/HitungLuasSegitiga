package com.qipoy.hitungluas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Luas Segitiga");

        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);

                double luas = p * l;

                txtLuas.setText("Luas = " +luas +" Cm");

            }
        });

    
        // hadling EditText edtPanjang
        edtPanjang.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                //Event Ketika terjadi perubahan pada kolom edtPanjang 
                //Check value edtPanjang Dengan Methode checkValEditText
                checkValEditText(edtPanjang);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        // hadling EditText edtLebar
        edtLebar.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                //Event Ketika terjadi perubahan pada kolom edtLebar 
                //Check value edtLebar Dengan Methode checkValEditText
                checkValEditText(edtLebar);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        //Check value edtPanjang Dengan Methode checkValEditText saat awal Activity
        checkValEditText(edtPanjang);
        //Check value edtLebar Dengan Methode checkValEditText saat awal Activity
        checkValEditText(edtLebar);

    }

    // Method Check value Edittesxt
    private void checkValEditText(EditText edittext) {
        //get value edittetxt
        String val = edittext.getText().toString().trim();
        if (val.length() == 0) {
            //setEditText
            edittext.setText("0");
            //letak kursor di index 1
            edittext.setSelection(1);
        }

        //additional option
        // handling angka 0 di posisi paling depan string
        String val_2 = edittext.getText().toString().trim();
        if (val_2.length() > 1 && val_2.substring(0, 1).equals("0")) {
            //setEditText dengan string index 1 sampai max panjang string
            edittext.setText(val_2.substring(1,val_2.length()));
            //letak kursor di index 1
            edittext.setSelection(1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
