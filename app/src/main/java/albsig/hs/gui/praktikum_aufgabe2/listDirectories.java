package albsig.hs.gui.praktikum_aufgabe2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class listDirectories extends AppCompatActivity {

    private final String SCREENSHOT_DIR = "Screenshots";
    private final String CAMERA_DIR = "Camera";
    private final String DIRECTORY_DIR = "Other Directory";
    private String[] titles = {SCREENSHOT_DIR, CAMERA_DIR,DIRECTORY_DIR };
    //Wird spaeter gebraucht
    private String pathScreenshots = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    private String pathCamera = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();

    private ArrayAdapter<String> myList;
    private int actualPosition;

    private ListView list;
    private Button btn_auswahl;

    private String [] menu_titles = {"Beenden"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_directories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = findViewById(android.R.id.list);
        btn_auswahl = findViewById(R.id.btn_auswahl);
        //button disable
        btn_auswahl.setEnabled(false);
        //Auswahlmoeglichkeiten (hier nur 2) in ArrayAdapter ...
        myList = new ArrayAdapter<String>(this, R.layout.list_content, titles);
        //ArrayAdapter mit ListView verknuepfen
        list.setAdapter(myList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //button
                if(!btn_auswahl.isEnabled()){
                    btn_auswahl.setEnabled(true);
                }
                actualPosition = position;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_directories, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    public void startImageActivity(View view) {
        Intent startnext;
        startnext = new Intent(listDirectories.this, showImage.class);
        String path;

        // PfadInfo an SubActivity weiterleiten
        // Hier geben Sie spaeter den tatsaechlich ausgewaehlten Pfad
        // an!!
        if(list.getItemAtPosition(actualPosition)==titles[0]){
                path = pathCamera;
        }else if(list.getItemAtPosition(actualPosition)==titles[1]){
            path = pathScreenshots;
        }
        else {
            path = "NULL";
        }


        // Bundle enthaelt die zu uebergebenden Infos ...
        Bundle infos = new Bundle();
        // ... nach put...
        infos.putString("PATH_INFOS", path);
        startnext.putExtras(infos);

        // Activity starten mit Uebergabe der Infos ...
        this.startActivity(startnext);
    }
}

