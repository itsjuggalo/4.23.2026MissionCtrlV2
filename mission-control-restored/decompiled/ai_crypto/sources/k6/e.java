package k6;

import g6.F;
import g6.I;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f18238a = I.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f18239b = new F("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F f18240c = new F("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F f18241d = new F("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final F f18242e = new F("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18243f = I.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final f h(long j7, f fVar) {
        return new f(j7, fVar, 0);
    }
}
