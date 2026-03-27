package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.n6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1877n6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f15940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1949w6 f15941b;

    public RunnableC1877n6(C1949w6 c1949w6, long j7) {
        this.f15940a = j7;
        Objects.requireNonNull(c1949w6);
        this.f15941b = c1949w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15941b.r(this.f15940a);
    }
}
