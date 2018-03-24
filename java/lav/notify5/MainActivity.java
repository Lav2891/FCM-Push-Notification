package lav.notify5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b;
    MyFirebaseInstanceIdService x;
    ExpandableListView e;
    ExpandableAdapter adapter;
    ArrayList<String> list;
    HashMap<String,List<String>> listone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x=new MyFirebaseInstanceIdService();
        e=(ExpandableListView)findViewById(R.id.eview);
        preparedate();
        adapter=new ExpandableAdapter(this,list,listone);
        e.setAdapter(adapter);

        b = (Button)findViewById(R.id.b_click);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.onTokenRefresh();
            }
        });
    }

    public void preparedate(){
        list=new ArrayList<>();
        listone=new HashMap<>();

        list.add("one");
        list.add("two");

        List<String> one = new ArrayList<>();
        one.add("hey");
        one.add("you");
        one.add("me");

        List<String> two = new ArrayList<>();
        two.add("11111");
        two.add("222222222");
        two.add("33333");
        two.add("444");

        listone.put(list.get(0),one);
        listone.put(list.get(1),two);
    }
}
