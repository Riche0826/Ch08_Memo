package flag.com.tw.ch08_memo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Edit extends AppCompatActivity {
    TextView txv;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent it = getIntent();
        String s = it.getStringExtra("備忘"); // 讀出名為"備忘"的資料

        txv = (TextView) findViewById(R.id.textView);
        txv.setText(s.substring(0, 2)); // 在畫面左上角顯示編號

        edt = (EditText) findViewById(R.id.editText);
        if(s.length() > 3) edt.setText(s.substring(3)); // 將傳來的資料去除前3個字 然後填入edittext元件中

        String ds = it.getStringExtra("日期");
        if(s.length() > 3) edt.setText(s.substring(3) + "\n" + ds);
    }

    public void onCancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onSave(View v){
        Intent it2 = new Intent();
        it2.putExtra("備忘", txv.getText() + "" + edt.getText());

        setResult(RESULT_OK, it2);

        finish();
    }
}