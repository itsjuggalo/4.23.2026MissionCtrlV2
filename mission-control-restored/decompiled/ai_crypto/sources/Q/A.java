package Q;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {
    public static boolean a(MotionEvent motionEvent, int i7) {
        return (motionEvent.getSource() & i7) == i7;
    }
}
