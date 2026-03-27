package N1;

import java.util.Objects;

/* JADX INFO: renamed from: N1.k1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0107k1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0104j1 f1680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0104j1 f1681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f1682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f1683d;
    public final /* synthetic */ C0113m1 e;

    public RunnableC0107k1(C0113m1 c0113m1, C0104j1 c0104j1, C0104j1 c0104j12, long j4, boolean z6) {
        this.f1680a = c0104j1;
        this.f1681b = c0104j12;
        this.f1682c = j4;
        this.f1683d = z6;
        Objects.requireNonNull(c0113m1);
        this.e = c0113m1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.z(this.f1680a, this.f1681b, this.f1682c, this.f1683d, null);
    }
}
