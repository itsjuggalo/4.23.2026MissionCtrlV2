package T;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f7778a = Collections.synchronizedMap(new WeakHashMap());

    public static class a {
        public static float a(VelocityTracker velocityTracker, int i8) {
            return velocityTracker.getAxisVelocity(i8);
        }

        public static float b(VelocityTracker velocityTracker, int i8, int i9) {
            return velocityTracker.getAxisVelocity(i8, i9);
        }

        public static boolean c(VelocityTracker velocityTracker, int i8) {
            return velocityTracker.isAxisSupported(i8);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f7778a.containsKey(velocityTracker)) {
                f7778a.put(velocityTracker, new B());
            }
            ((B) f7778a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i8) {
        c(velocityTracker, i8, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i8, float f8) {
        velocityTracker.computeCurrentVelocity(i8, f8);
        B bE = e(velocityTracker);
        if (bE != null) {
            bE.c(i8, f8);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i8) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i8);
        }
        if (i8 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i8 == 1) {
            return velocityTracker.getYVelocity();
        }
        B bE = e(velocityTracker);
        if (bE != null) {
            return bE.d(i8);
        }
        return 0.0f;
    }

    public static B e(VelocityTracker velocityTracker) {
        return (B) f7778a.get(velocityTracker);
    }
}
