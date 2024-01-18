package com.minun.freecodecamp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;


public class SimpleListActivity extends AppCompatActivity {

    ListView simpleListView;
    String[] fruitNames = {"Apple","Banana","Litchi","Mango","Pineapple"};
    int[] fruitImages={R.drawable.apple, R.drawable.banana, R.drawable.litchi, R.drawable.mango, R.drawable.pineapple};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        simpleListView = (ListView) findViewById(R.id.simpleListView);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for(int i=0; i<fruitNames.length; i++){
            HashMap<String, String> hashMap= new HashMap<>();
            hashMap.put("name", fruitNames[i]);
            hashMap.put("image",fruitImages[i]+"");
            arrayList.add(hashMap);
        }

        String[] from = {"name", "image"};
        int[] to = {R.id.fruitTextView, R.id.fruitImageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_fruit_items, from, to);
        simpleListView.setAdapter(simpleAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), fruitNames[i],Toast.LENGTH_LONG).show();
            }
        });

    }
}
