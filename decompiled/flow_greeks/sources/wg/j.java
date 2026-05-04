package wg;

import sg.d0;
import sg.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24113a = g0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f24114b = new d0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f24115c = new d0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f24116d = new d0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d0 f24117e = new d0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24118f = g0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final k h(long j10, k kVar) {
        return new k(j10, kVar, 0);
    }
}
