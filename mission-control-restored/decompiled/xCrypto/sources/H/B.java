package H;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f487a = Collections.synchronizedMap(new WeakHashMap());

    public static class a {
        public static float a(VelocityTracker velocityTracker, int i4) {
            return velocityTracker.getAxisVelocity(i4);
        }

        public static float b(VelocityTracker velocityTracker, int i4, int i5) {
            return velocityTracker.getAxisVelocity(i4, i5);
        }

        public static boolean c(VelocityTracker velocityTracker, int i4) {
            return velocityTracker.isAxisSupported(i4);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f487a.containsKey(velocityTracker)) {
                f487a.put(velocityTracker, new C());
            }
            ((C) f487a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i4) {
        c(velocityTracker, i4, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i4, float f4) {
        velocityTracker.computeCurrentVelocity(i4, f4);
        C cE = e(velocityTracker);
        if (cE != null) {
            cE.c(i4, f4);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i4);
        }
        if (i4 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i4 == 1) {
            return velocityTracker.getYVelocity();
        }
        C cE = e(velocityTracker);
        if (cE != null) {
            return cE.d(i4);
        }
        return 0.0f;
    }

    public static C e(VelocityTracker velocityTracker) {
        return (C) f487a.get(velocityTracker);
    }
}
