package com.example.david.pizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<Pizza> adapter;
    List<Pizza> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         pizzas = TiposPizza.MenuPizzas();
        ListView  lvPizzas = (ListView) findViewById(R.id.lvPizzas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pizzas);
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

            //Toast.makeText(this,pizza.toString(),Toast.LENGTH_LONG).show();
            if (requestCode == 0) {
                if(resultCode == Activity.RESULT_OK){

                    Pizza pizza=(Pizza)data1.getSerializableExtra("pizza");
                    Log.i(pizza.getNombrePizza().toString(),"pasa por aqui");
                    Toast.makeText(this,pizza.getNombrePizza().toString(),Toast.LENGTH_LONG).show();
                    //pizza= (Pizza)data1.getStringExtra("pizza");
                    pizzas.add(pizza);
                    adapter.notifyDataSetChanged();
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    //Write your code if there's no result
                }
            }
        }//onActivityResult

}
