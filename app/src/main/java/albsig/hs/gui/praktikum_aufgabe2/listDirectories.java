package albsig.hs.gui.praktikum_aufgabe2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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

    private ListView list;
    private Button btn_auswahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_directories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = findViewById(android.R.id.list);
        btn_auswahl = findViewById(R.id.btn_auswahl);
        //Auswahlmoeglichkeiten (hier nur 2) in ArrayAdapter ...
        ArrayAdapter<String> myList = new ArrayAdapter<String>(this, R.layout.list_content, titles);
        //ArrayAdapter mit ListView verknuepfen
        list.setAdapter(myList);
        list.setBackgroundResource(R.drawable.list_view_shape);

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

        return super.onOptionsItemSelected(item);
    }

    public void startImageActivity(View view) {
        Intent startnext;
        startnext = new Intent(listDirectories.this, showImage.class);

        // PfadInfo an SubActivity weiterleiten
        // Hier geben Sie spaeter den tatsaechlich ausgewaehlten Pfad
        // an!!
        // Bundle enthaelt die zu uebergebenden Infos ...
        Bundle infos = new Bundle();
        // ... nach put...
        infos.putStringArray("PATH_INFOS", titles);
        startnext.putExtras(infos);

        // Activity starten mit Uebergabe der Infos ...
        this.startActivity(startnext);
    }
}

