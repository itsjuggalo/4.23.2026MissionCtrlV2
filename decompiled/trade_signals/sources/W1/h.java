package W1;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9257a = new h();

    public static e d() {
        return f9257a;
    }

    @Override // W1.e
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // W1.e
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // W1.e
    public final long c() {
        return System.nanoTime();
    }
}
