package albsig.hs.gui.praktikum_aufgabe2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class showImage extends AppCompatActivity {
    private TextView pfade;
    private ImageView image; // Von Ihnen weiter einzubinden
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pfade = findViewById(R.id.showPath);
        String[] pfadeStrings =
                getIntent().getExtras().getStringArray("PATH_INFOS");
        pfade.setText(pfadeStrings[0] + "\n" + pfadeStrings[1]);

    }

}
