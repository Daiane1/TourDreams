package tourdreams.com.br;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MinhasReservas extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listHeader;
    HashMap<String, List<ItemPojo>> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_reservas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listHeader, listItems);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Showing a group as already expanded
        expListView.expandGroup(0);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on item click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int itemPosition, long id) {

                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {

        listHeader = new ArrayList<String>();
        listItems = new HashMap<String, List<ItemPojo>>();

        // A list of Headers. I've added the Headers as simple Strings.. However, you can also change them to Objects of POJO. The process which I've applied to the itemsList can also be applied here.
        listHeader.add("Proximas Reservas");
        listHeader.add("Reservas Finalizadas");
        listHeader.add("Reservas Rejeitadas");


        ArrayList<ItemPojo> itemPojoList = new ArrayList<>();

        ItemPojo itemPojo = new ItemPojo(R.drawable.resort1, "Nino Hotels" , "São Paulo, Brasil", "01/11/2017", "05/11/2017");

        itemPojoList.add(itemPojo);

        listItems.put(listHeader.get(0), itemPojoList);



        // Just a string which contains all alphabets and numbers - the random strings are generated from this string.
        /*String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            ArrayList<ItemPojo> itemPojoList = new ArrayList<>();
            for (int j = 0; j < rnd.nextInt(7) + 3; j++) {

                // Randomly Generate a String of length 3 to 10 using characters from string AB.
                int r = rnd.nextInt(7) + 3;
                StringBuilder sb = new StringBuilder(r);
                for (int k = 0; k < r; k++)
                    sb.append(AB.charAt(rnd.nextInt(AB.length())));
                // End of Random String Generation

                // Create POJO Object with random string and number.
                ItemPojo itemPojo = new ItemPojo(sb, rnd.nextInt(1000));
                ItemPojo itemPojo2 = new ItemPojo(sb, rnd.nextInt(1000));
                itemPojoList.add(itemPojo);
            }
            // Add list of above POJO's to a Map of type Map<String, ItemPojo>.
            listItems.put(listHeader.get(i), itemPojoList);
        }*/


    }

}
