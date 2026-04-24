package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1743C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f15033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f15034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F0 f15035c;

    public RunnableC1743C(F0 f02, String str, long j7) {
        this.f15033a = str;
        this.f15034b = j7;
        Objects.requireNonNull(f02);
        this.f15035c = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15035c.m(this.f15033a, this.f15034b);
    }
}
