package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.o6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1885o6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f15982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1949w6 f15983b;

    public RunnableC1885o6(C1949w6 c1949w6, long j7) {
        this.f15982a = j7;
        Objects.requireNonNull(c1949w6);
        this.f15983b = c1949w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15983b.s(this.f15982a);
    }
}
