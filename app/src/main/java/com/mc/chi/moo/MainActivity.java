package com.mc.chi.moo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSM;
    private Sensor[] mSensor = new Sensor[9];
    private boolean[] bSensor = new boolean[9];
    private String[] startingText = new String[9];
    private TextView[] textV = new TextView[9];
    private float[] maxX = new float[9];
    private float[] maxY = new float[9];
    private float[] maxZ = new float[9];
    private float[] minX = new float[9];
    private float[] minY = new float[9];
    private float[] minZ = new float[9];

    private SensorEventListener accListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 0;
            float x = data.values[0], y = data.values[1], z = data.values[2];
            setPeak(x, y, z, i);
            String s = String.format("x: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>y: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>z: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f",
                    x, maxX[i], minX[i], y, maxY[i], minY[i], z, maxZ[i], minZ[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }
    
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener linearAccListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 1;
            float x = data.values[0], y = data.values[1], z = data.values[2];
            setPeak(x, y, z, i);
            String s = String.format("x: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>y: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>z: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f",
                    x, maxX[i], minX[i], y, maxY[i], minY[i], z, maxZ[i], minZ[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener gravityListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 2;
            float x = data.values[0], y = data.values[1], z = data.values[2];
            setPeak(x, y, z, i);
            String s = String.format("x: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>y: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>z: %2.2f m/s²<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f",
                    x, maxX[i], minX[i], y, maxY[i], minY[i], z, maxZ[i], minZ[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener gyroListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 3;
            float x = data.values[0], y = data.values[1], z = data.values[2];
            setPeak(x, y, z, i);
            String s = String.format("x: %2.2f rad/s<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>y: %2.2f rad/s<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>z: %2.2f rad/s<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f",
                    x, maxX[i], minX[i], y, maxY[i], minY[i], z, maxZ[i], minZ[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener lightListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 4;
            float x = data.values[0];
            setPeak(x, 0, 0, i);
            String s = String.format("%.1f lx<pre>    </pre>Max: %.1f<pre>    </pre>Min: %.1f", x, maxX[i], minX[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener magneticListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 5;
            float x = data.values[0], y = data.values[1], z = data.values[2];
            setPeak(x, y, z, i);
            String s = String.format("x: %2.2f μT<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>y: %2.2f μT<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f" +
                            "<br>z: %2.2f μT<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f",
                    x, maxX[i], minX[i], y, maxY[i], minY[i], z, maxZ[i], minZ[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener proximityListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 6;
            float x = data.values[0];
            setPeak(x, 0, 0, i);
            String s = String.format("%1.1f cm<pre>    </pre>Max: %1.1f<pre>    </pre>Min: %1.1f", x, maxX[i], minX[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    private SensorEventListener pressureListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 7;
            float x = data.values[0];
            setPeak(x, 0, 0, i);
            String s = String.format("%2.2f hPa<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f", x, maxX[i], minX[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    private SensorEventListener temperatureListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent data) {
            int i = 8;
            float x = data.values[0];
            setPeak(x, 0, 0, i);
            String s = String.format("%2.2f °C<pre>    </pre>Max: %2.2f<pre>    </pre>Min: %2.2f", x, maxX[i], minX[i]);
            textV[i].setText(Html.fromHtml(startingText[i] + s));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniText();
        setSensor();
    }

    private void setSensor() {
        mSM = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor[0] = mSM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensor[1] = mSM.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        mSensor[2] = mSM.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSensor[3] = mSM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensor[4] = mSM.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensor[5] = mSM.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensor[6] = mSM.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensor[7] = mSM.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensor[8] = mSM.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        for (int i = 0; i < mSensor.length; i++) {
            if (mSensor[i] == null) {
                bSensor[i] = false;
                textV[i].setText(Html.fromHtml(startingText[i] + "Unavailable"));
            } else {
                bSensor[i] = true;
            }
        }
    }

    private void iniText() {
        startingText[0] = "Accelerometer";
        startingText[1] = "Linear Accelerometer";
        startingText[2] = "Gravity";
        startingText[3] = "Gyroscope";
        startingText[4] = "Ambient light";
        startingText[5] = "Ambient magnetic field";
        startingText[6] = "Proximity";
        startingText[7] = "Pressure";
        startingText[8] = "Ambient temperature";
        for (int i = 0; i < startingText.length; i++) {
            startingText[i] = "<b>" + startingText[i] + ":</b> <br>";
        }
        textV[0] = (TextView) findViewById(R.id.sen0);
        textV[1] = (TextView) findViewById(R.id.sen1);
        textV[2] = (TextView) findViewById(R.id.sen2);
        textV[3] = (TextView) findViewById(R.id.sen3);
        textV[4] = (TextView) findViewById(R.id.sen4);
        textV[5] = (TextView) findViewById(R.id.sen5);
        textV[6] = (TextView) findViewById(R.id.sen6);
        textV[7] = (TextView) findViewById(R.id.sen7);
        textV[8] = (TextView) findViewById(R.id.sen8);
        minX[4] = 10.0f;
        minX[6] = 5.0f;
    }

    private void setPeak(float x, float y, float z, int index) {
        if (x > maxX[index]) {
            maxX[index] = x;
        }
        if (y > maxY[index]) {
            maxY[index] = y;
        }
        if (z > maxZ[index]) {
            maxZ[index] = z;
        }
        if (x < minX[index]) {
            minX[index] = x;
        }
        if (y < minY[index]) {
            minY[index] = y;
        }
        if (z < minZ[index]) {
            minZ[index] = z;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bSensor[0]) {
            mSM.unregisterListener(accListener);
        }
        if (bSensor[1]) {
            mSM.unregisterListener(linearAccListener);
        }
        if (bSensor[2]) {
            mSM.unregisterListener(gravityListener);
        }
        if (bSensor[3]) {
            mSM.unregisterListener(gyroListener);
        }
        if (bSensor[4]) {
            mSM.unregisterListener(lightListener);
        }
        if (bSensor[5]) {
            mSM.unregisterListener(magneticListener);
        }
        if (bSensor[6]) {
            mSM.unregisterListener(pressureListener);
        }
        if (bSensor[7]) {
            mSM.unregisterListener(pressureListener);
        }
        if (bSensor[8]) {
            mSM.unregisterListener(temperatureListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bSensor[0]) {
            mSM.registerListener(accListener, mSensor[0], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[1]) {
            mSM.registerListener(linearAccListener, mSensor[1], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[2]) {
            mSM.registerListener(gravityListener, mSensor[2], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[3]) {
            mSM.registerListener(gyroListener, mSensor[3], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[4]) {
            mSM.registerListener(lightListener, mSensor[4], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[5]) {
            mSM.registerListener(magneticListener, mSensor[5], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[6]) {
            mSM.registerListener(proximityListener, mSensor[6], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[7]) {
            mSM.registerListener(pressureListener, mSensor[7], SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (bSensor[8]) {
            mSM.registerListener(temperatureListener, mSensor[8], SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}
