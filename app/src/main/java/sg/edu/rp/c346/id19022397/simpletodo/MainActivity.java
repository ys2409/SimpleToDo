package sg.edu.rp.c346.id19022397.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTodo;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    Spinner spn;

    ListView lvTodo;
    ArrayList<String> alTodo;
    ArrayAdapter<String> alTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTodo = findViewById(R.id.editTextDo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTodo = findViewById(R.id.listView);
        btnDelete = findViewById(R.id.buttonDel);
        spn = findViewById(R.id.spinner);

        alTodo = new ArrayList<>();
        alTodos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alTodo);

        lvTodo.setAdapter(alTodos);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTo = etTodo.getText().toString();
                alTodo.add(newTo);
                alTodos.notifyDataSetChanged();

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                alTodos.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int post = Integer.parseInt(etTodo.getText().toString());

                if(alTodo.size()==0){
                    Toast.makeText(getApplicationContext(), "You don't have any task to remove", Toast.LENGTH_SHORT).show();

                }
                else{

                    alTodo.remove(post);
                    alTodos.notifyDataSetChanged();
                }
            }
        });

        spn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        etTodo.setHint("Add a new task");
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        break;
                    case 1:
                        etTodo.setHint("Remove a task");
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        break;
                }
            }
        });

    }
}
