package h7;

import d7.D;
import d7.G;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f18738a = G.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f18739b = new D("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final D f18740c = new D("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final D f18741d = new D("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final D f18742e = new D("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18743f = G.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final k h(long j8, k kVar) {
        return new k(j8, kVar, 0);
    }
}
