package nyc.muaadh_melhi_develpoer.aerisweather;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import static nyc.muaadh_melhi_develpoer.aerisweather.R.id.activity_main_xml;

public class MainActivity extends Activity {

    View img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        img = (View)findViewById(activity_main_xml);
        img.setBackgroundResource(R.drawable.weather_animation);

        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();
    }
}
