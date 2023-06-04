package ru.iteco.fmhandroid;


import android.os.Handler;

public class FakeLoadData {
    public static void fakeData() {
        EspressoIdlingResources.increment();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                EspressoIdlingResources.decrement();
            }
        }, 1000);
    }

}
