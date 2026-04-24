package G2;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static o a(long j8, long j9, long j10) {
        return new a(j8, j9, j10);
    }

    public static o e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
