package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.o5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1884o5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1868m5 f15977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1868m5 f15978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f15979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f15980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C1932u5 f15981e;

    public RunnableC1884o5(C1932u5 c1932u5, C1868m5 c1868m5, C1868m5 c1868m52, long j7, boolean z7) {
        this.f15977a = c1868m5;
        this.f15978b = c1868m52;
        this.f15979c = j7;
        this.f15980d = z7;
        Objects.requireNonNull(c1932u5);
        this.f15981e = c1932u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15981e.B(this.f15977a, this.f15978b, this.f15979c, this.f15980d, null);
    }
}
