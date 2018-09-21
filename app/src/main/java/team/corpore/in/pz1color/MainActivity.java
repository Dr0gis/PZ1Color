package team.corpore.in.pz1color;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SUM_FOR_INVERSE = 3 * 128;

    private TextView colorPanel;
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorPanel = findViewById(R.id.color_panel);
        seekBarRed = findViewById(R.id.seek_bar_red);
        seekBarGreen = findViewById(R.id.seek_bar_green);
        seekBarBlue = findViewById(R.id.seek_bar_blue);

        seekBarRed.setOnSeekBarChangeListener(new OnSeekBarChangeColor());
        seekBarGreen.setOnSeekBarChangeListener(new OnSeekBarChangeColor());
        seekBarBlue.setOnSeekBarChangeListener(new OnSeekBarChangeColor());

        setColor(seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress());
    }

    private void setColor(int red, int green, int blue) {
        colorPanel.setBackgroundColor(Color.rgb(red, green, blue));
        if (red + green + blue >= SUM_FOR_INVERSE) {
            colorPanel.setTextColor(getResources().getColor(R.color.black_color));
        }
        else {
            colorPanel.setTextColor(getResources().getColor(R.color.white_color));
        }
        String colors = getString(R.string.red) + ": " + red + " " +
                getString(R.string.green) + ": " + green + " " +
                getString(R.string.blue) + ": " + blue;
        colorPanel.setText(colors);
    }

    class OnSeekBarChangeColor implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setColor(seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress());
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    }
}