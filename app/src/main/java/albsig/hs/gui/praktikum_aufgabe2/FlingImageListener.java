package albsig.hs.gui.praktikum_aufgabe2;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class FlingImageListener extends GestureDetector.SimpleOnGestureListener {
    private ShowImage activity;

    public FlingImageListener(ShowImage activity){
        this.activity = activity;
    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){

        //Schwellwert, ab dem die Geste als echte Wischgeste gelten soll
        float schwellwert = 42;
        Log.e("FLING", "VX" + velocityX);
        Log.e("FLING", "VY" + velocityY);
        Log.e("FLING", "e1 x: "+ e1.getX());
        Log.e("FLING", "e1 x: " +e2.getX());
        if (e1.getX()-e2.getX() > schwellwert){
            activity.links();
        }
        else if(e2.getX() - e1.getX() >schwellwert){
            activity.rechts();
        }
        return super.onFling(e1,e2,velocityX,velocityY);
    }



    @Override
    public boolean onDown(MotionEvent e) {
        //muss IMMER !!!! true sein.
        //wird bei Start der Geste aufgerufen
        //Falls false wir der rest der nachfolgenden Geste nicht erkannt.
        return true;
    }
}
