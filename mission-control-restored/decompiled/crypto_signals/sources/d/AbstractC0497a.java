package d;

import android.window.BackEvent;

/* JADX INFO: renamed from: d.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0497a {
    public static float a(BackEvent backEvent) {
        return backEvent.getProgress();
    }

    public static int b(BackEvent backEvent) {
        return backEvent.getSwipeEdge();
    }

    public static float c(BackEvent backEvent) {
        return backEvent.getTouchX();
    }

    public static float d(BackEvent backEvent) {
        return backEvent.getTouchY();
    }
}
