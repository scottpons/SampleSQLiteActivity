package scottsalvador.pons.com.mycrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eFN,eLN,eLG;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this);
        eFN = findViewById(R.id.fn);
        eLN = findViewById(R.id.ln);
        eLG = findViewById(R.id.lg);
    }

    public void addRecord(View v){
        String fn=eFN.getText().toString();
        String ln=eLN.getText().toString();
        int lg=Integer.parseInt(eLG.getText().toString());
        boolean isInserted=helper.insert(fn,ln,lg);
        if(isInserted){
            Toast.makeText(this, "Record Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Record Not Inserted", Toast.LENGTH_LONG).show();
        }
    }
}
