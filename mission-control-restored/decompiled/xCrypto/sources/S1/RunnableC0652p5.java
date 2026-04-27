package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0652p5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0691u5 f4830a;

    public RunnableC0652p5(C0691u5 c0691u5) {
        Objects.requireNonNull(c0691u5);
        this.f4830a = c0691u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0691u5 c0691u5 = this.f4830a;
        c0691u5.f4972e = c0691u5.D();
    }
}
