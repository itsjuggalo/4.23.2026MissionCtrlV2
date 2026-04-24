package d;

import android.window.BackEvent;

/* JADX INFO: renamed from: d.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1385a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1385a f13051a = new C1385a();

    public final BackEvent a(float f7, float f8, float f9, int i7) {
        return new BackEvent(f7, f8, f9, i7);
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
