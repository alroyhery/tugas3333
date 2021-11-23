package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {
    Button bsimpan;
    EditText enpm, enama, etempatlahir;
    TextView thasil;
    RadioGroup rgjk;
    Spinner skelas, sagama;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

// inisialisasi
        bsimpan = (Button) findViewById(R.id.simpan);
        enpm = (EditText) findViewById(R.id.isinpm);
        enama = (EditText) findViewById(R.id.isinama);
        thasil = (TextView) findViewById(R.id.hasil);
        rgjk = (RadioGroup) findViewById(R.id.jk);
        skelas = (Spinner) findViewById(R.id.kelas);
        sagama = (Spinner) findViewById(R.id.agama);
        etempatlahir = (EditText) findViewById(R.id.tempatlahir);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = findViewById(R.id.tv_dateresult);
        btDatePicker = findViewById(R.id.tv_dateresult);
    }
    public void doSave(View v) {
        String inputnpm = enpm.getText().toString();
        String inputnama = String.valueOf(enama.getText().toString());
        String inputtempatlahir = String.valueOf(etempatlahir.getText().toString());
        String inputotomatis = String.valueOf(tvDateResult.getText().toString());

        int gender = rgjk.getCheckedRadioButtonId();
        RadioButton jk = (RadioButton) findViewById(gender);
        String inputjk = String.valueOf(jk.getText().toString());

        thasil.setText("\n" + "NPM\t\t\t\t\t\t\t\t\t\t\t: " + inputnpm + "\n" +
                "Nama\t\t\t\t\t\t\t\t\t\t: " + inputnama + "\n" +
                "Jenis Kelamin\t\t: " + inputjk + "\n" +
                "Kelas\t\t\t\t\t\t\t\t\t\t: " + skelas.getSelectedItem().toString() + "\n" +
                "Agama\t\t\t\t\t\t\t\t\t: " + sagama.getSelectedItem().toString() + "\n" +
                "Tempat Lahir\t\t: " + inputtempatlahir + "\n" +
                "Tanggal Lahir\t\t\t: " + inputotomatis + "\n");
    }

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    public void showDate(View v) {
        showDateDialog();
    }
}
