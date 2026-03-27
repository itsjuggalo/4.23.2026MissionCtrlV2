package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6250a = new a();

    public final BackEvent a(float f4, float f5, float f6, int i4) {
        return new BackEvent(f4, f5, f6, i4);
    }

    public final float b(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        kotlin.jvm.internal.r.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
