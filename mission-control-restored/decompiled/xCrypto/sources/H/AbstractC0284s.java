package H;

import android.view.MotionEvent;

/* JADX INFO: renamed from: H.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0284s {
    public static boolean a(MotionEvent motionEvent, int i4) {
        return (motionEvent.getSource() & i4) == i4;
    }
}
