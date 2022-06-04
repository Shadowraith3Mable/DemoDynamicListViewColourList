package sg.edu.rp.c346.id21022328.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter aaColour;
    String Getvalue;
    String Getindex;
    EditText etIndexElement;
    Button ButtonRemove;
    Button ButtonUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alColours = new ArrayList<String>();
        alColours.add("red");
        alColours.add("Orange");

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.etIndexElement);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listviewcolour);
        ButtonRemove = findViewById(R.id.ButtonRemove);
        ButtonUpdate = findViewById(R.id.ButtonUpdate);

        aaColour = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Getvalue = etElement.getText().toString();
                Getindex = etIndexElement.getText().toString();
                int toInt = Integer.parseInt(Getindex);

                alColours.add(toInt, Getvalue);

                aaColour.notifyDataSetChanged();

            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,alColours.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        ButtonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Getindex = etIndexElement.getText().toString();
                int toInt = Integer.parseInt(Getindex);
                alColours.remove(toInt);
                aaColour.notifyDataSetChanged();
            }
        });

        ButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Getvalue = etElement.getText().toString();
                Getindex = etIndexElement.getText().toString();
                int toInt = Integer.parseInt(Getindex);
                alColours.set(toInt,Getvalue);


                aaColour.notifyDataSetChanged();


            }
        });




    }
}