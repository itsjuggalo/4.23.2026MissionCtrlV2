package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1799e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f15627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F0 f15628b;

    public RunnableC1799e0(F0 f02, long j7) {
        this.f15627a = j7;
        Objects.requireNonNull(f02);
        this.f15628b = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15628b.n(this.f15627a);
    }
}
