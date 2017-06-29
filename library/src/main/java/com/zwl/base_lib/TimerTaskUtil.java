/*
 * *
 *  Copyright (c) 2015. Dingtone, inc. All rights reserved.
 * /
 */

package com.zwl.base_lib;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author velen
 * @date 2016/8/15
 */
public class TimerTaskUtil {

    public static Timer startTimerTask(final Runnable runnable, int timeInterval) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                runnable.run();
            }
        };
        timer.schedule(timerTask, 0, timeInterval);
        return timer;
    }

    public static void stopTimerTask(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
    }
}
