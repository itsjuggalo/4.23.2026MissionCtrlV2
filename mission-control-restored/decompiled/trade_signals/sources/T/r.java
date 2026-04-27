package T;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static boolean a(MotionEvent motionEvent, int i8) {
        return (motionEvent.getSource() & i8) == i8;
    }
}
