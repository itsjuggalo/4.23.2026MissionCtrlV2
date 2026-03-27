package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.r5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0667r5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f4901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0691u5 f4903c;

    public RunnableC0667r5(C0691u5 c0691u5, C0628m5 c0628m5, long j4) {
        this.f4901a = c0628m5;
        this.f4902b = j4;
        Objects.requireNonNull(c0691u5);
        this.f4903c = c0691u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0691u5 c0691u5 = this.f4903c;
        c0691u5.C(this.f4901a, false, this.f4902b);
        c0691u5.f4972e = null;
        c0691u5.f4245a.J().u(null);
    }
}
