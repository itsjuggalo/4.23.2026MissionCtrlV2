package G1;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f458a = new g();

    public static d c() {
        return f458a;
    }

    @Override // G1.d
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // G1.d
    public final long b() {
        return System.nanoTime();
    }

    @Override // G1.d
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
