package com.example.david.pizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Pizza> pizzas = TiposPizza.MenuPizzas();
        ListView  lvPizzas = (ListView) findViewById(R.id.lvPizzas);
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pizzas);
       // ArrayAdapter<Pizza> adaptadorLista=new ArrayAdapter(pizzas);
        lvPizzas.setAdapter(adapter);
        findViewById(R.id.btnIngredientes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, IngredientesActivity.class);
                MainActivity.this.startActivityForResult(intent, 0);
//comitdadsadadadadsad
            }
        });

       

    }
 




   // lvPizzas.setAdapter(adaptadorLista);
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data1) {
            String resultado=data1.getStringExtra("result");
            Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();
            if (requestCode == 1) {
                if(resultCode == Activity.RESULT_OK){
                    String result=data1.getStringExtra("result");
                    Toast.makeText(this,result,Toast.LENGTH_LONG).show();
                }
                if (resultCode == Activity.RESULT_CANCELED) {
                    //Write your code if there's no result
                }
            }
        }//onActivityResult

}
