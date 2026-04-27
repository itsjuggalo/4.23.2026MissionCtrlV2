package Q2;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static r a(long j7, long j8, long j9) {
        return new a(j7, j8, j9);
    }

    public static r e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
