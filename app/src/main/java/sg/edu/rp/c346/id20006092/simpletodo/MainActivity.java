package sg.edu.rp.c346.id20006092.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    Button btnClear;
    ListView lvTasks;
    ArrayAdapter aaTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.buttonAddTask);
        btnClear = findViewById(R.id.buttonClearTasks);
        lvTasks = findViewById(R.id.listViewTasks);

        ArrayList<String> alTasks = new ArrayList();

        aaTasks = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, alTasks);

        lvTasks.setAdapter(aaTasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                alTasks.add(task);
                aaTasks.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTasks.clear();
                aaTasks.notifyDataSetChanged();
            }
        });

    }
}