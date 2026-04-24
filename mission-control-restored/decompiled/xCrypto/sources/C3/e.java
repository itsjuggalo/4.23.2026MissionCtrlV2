package C3;

import y3.F;
import y3.I;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f280a = I.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f281b = new F("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F f282c = new F("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F f283d = new F("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final F f284e = new F("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f285f = I.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final f h(long j4, f fVar) {
        return new f(j4, fVar, 0);
    }
}
