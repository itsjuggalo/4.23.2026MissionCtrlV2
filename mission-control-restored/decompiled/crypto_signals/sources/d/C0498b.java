package d;

import android.window.BackEvent;

/* JADX INFO: renamed from: d.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0498b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5881d;

    public C0498b(BackEvent backEvent) {
        float fC = AbstractC0497a.c(backEvent);
        float fD = AbstractC0497a.d(backEvent);
        float fA = AbstractC0497a.a(backEvent);
        int iB = AbstractC0497a.b(backEvent);
        this.f5878a = fC;
        this.f5879b = fD;
        this.f5880c = fA;
        this.f5881d = iB;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f5878a + ", touchY=" + this.f5879b + ", progress=" + this.f5880c + ", swipeEdge=" + this.f5881d + '}';
    }
}
