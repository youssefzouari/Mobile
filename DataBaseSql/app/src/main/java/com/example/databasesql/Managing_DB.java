package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Managing_DB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_db2);

        Intent int2 = new Intent(Managing_DB.this, MainActivity.class);
        startActivity(int2);
    }
}

class ManagingDB extends AppCompatActivity {
    private ListView LV;
    Database dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_db2);

        LV = findViewById(R.id.listView2);
        dataBase = new Database(this);
        viewData();

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String[] items = {"Modifier", "Supprimer"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ManagingDB.this);
                builder.setTitle("Action");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            // Implement showUpdate() method or remove the reference
                        } else if (which == 1) {
                            delete(LV, position); // Call the delete method
                        }
                    }
                });
                builder.show();
            }
        });
    }

    public void viewData() {
        Cursor c = dataBase.getAllData();
        ArrayList<String> list = new ArrayList<>();

        if (c.getCount() == 0) {
            Toast.makeText(ManagingDB.this, "La base est vide", Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {
                list.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getString(3));
            }
            ListAdapter listAdapter = new ArrayAdapter<>(ManagingDB.this,
                    android.R.layout.simple_list_item_1, list);
            LV.setAdapter(listAdapter);
        }
    }

    void showUpdate(Activity ac, ListView lv, int p) {
        Dialog dialog = new Dialog(ac);
        dialog.setContentView(R.layout.update_db);
        dialog.setTitle("Update");

        EditText name = dialog.findViewById(R.id.editTextText4);
        EditText mail = dialog.findViewById(R.id.editTextText5);
        EditText phone = dialog.findViewById(R.id.editTextText6);
        Button bt = dialog.findViewById(R.id.button);

        String[] chaine = lv.getAdapter().getItem(p).toString().split(" ");
        name.setText(chaine[1]);
        mail.setText(chaine[2]);
        phone.setText(chaine[3]);

        int width = (int) (ac.getResources().getDisplayMetrics().widthPixels * 0.9);
        int height = (int) (ac.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(chaine[0]);
                dataBase.update(name.getText().toString(), mail.getText().toString(), phone.getText().toString(), i);
                Toast.makeText(ManagingDB.this, "Mise à jour avec succès", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManagingDB.this, ManagingDB.class);
                startActivity(intent);
                viewData();
            }
        });
    }

    // Method to delete an item from the database
    private void delete(ListView lv, int p) {
        String[] chaine = lv.getAdapter().getItem(p).toString().split(" ");
        int i = Integer.parseInt(chaine[0]);
        dataBase.delete(i);
        Toast.makeText(this, "Suppression avec succès", Toast.LENGTH_SHORT).show();
        viewData();
    }
}