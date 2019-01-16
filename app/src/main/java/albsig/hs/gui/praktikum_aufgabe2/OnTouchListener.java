package albsig.hs.gui.praktikum_aufgabe2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Dieser Listener reagiert auf JEDES MotionEvent unseres Textfeldes.
//Er reicht..

public class OnTouchListener implements View.OnTouchListener {

    private GestureDetector gdetect;

    public OnTouchListener(GestureDetector gdetect){
        this.gdetect = gdetect;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gdetect.onTouchEvent(event);
    }
}
