package t5;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f20812a = new h();

    public static e d() {
        return f20812a;
    }

    @Override // t5.e
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // t5.e
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // t5.e
    public final long c() {
        return System.nanoTime();
    }
}
