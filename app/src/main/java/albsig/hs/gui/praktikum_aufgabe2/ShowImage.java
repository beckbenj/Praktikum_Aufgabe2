package albsig.hs.gui.praktikum_aufgabe2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static albsig.hs.gui.praktikum_aufgabe2.FileIO.createBitmapFromFile;
import static albsig.hs.gui.praktikum_aufgabe2.FileIO.loadImagePathNames;

public class ShowImage extends AppCompatActivity {
    private ImageView image;
    private Bitmap bm;
    private String[] pfade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        image = findViewById(R.id.image);
        String path = getIntent().getExtras().getString("PATH_INFOS");
        pfade=loadImagePathNames(path);
        bm = createBitmapFromFile(pfade[0]);
        image.setImageBitmap(bm);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_images, menu);
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
        if (id == R.id.action_back) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void links(){
       // TODO Bild vorwärts
        // TODO Wenn letztes Bild erreicht, keine weitere Aktion und beim Bild bleiben
    }

    public void rechts(){
        // TODO Bild Rückwärts
        // TODO Wenn erstes Bild erreicht, keine weitere Aktion und beim Bild bleiben
    }
}