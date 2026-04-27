package q1;

import android.os.SystemClock;

/* JADX INFO: renamed from: q1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2624g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f22527a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j8) {
        return (b() - j8) * f22527a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
