package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.j3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0602j3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0587h4 f4694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0658q3 f4695b;

    public RunnableC0602j3(C0658q3 c0658q3, C0587h4 c0587h4) {
        this.f4694a = c0587h4;
        Objects.requireNonNull(c0658q3);
        this.f4695b = c0658q3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0658q3 c0658q3 = this.f4695b;
        C0587h4 c0587h4 = this.f4694a;
        c0658q3.p(c0587h4);
        c0658q3.v(c0587h4.f4654d);
    }
}
