package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.o5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0644o5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f4818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f4819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0691u5 f4822e;

    public RunnableC0644o5(C0691u5 c0691u5, C0628m5 c0628m5, C0628m5 c0628m52, long j4, boolean z4) {
        this.f4818a = c0628m5;
        this.f4819b = c0628m52;
        this.f4820c = j4;
        this.f4821d = z4;
        Objects.requireNonNull(c0691u5);
        this.f4822e = c0691u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4822e.B(this.f4818a, this.f4819b, this.f4820c, this.f4821d, null);
    }
}
