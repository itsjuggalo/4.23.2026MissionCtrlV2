package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1892p5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1932u5 f15989a;

    public RunnableC1892p5(C1932u5 c1932u5) {
        Objects.requireNonNull(c1932u5);
        this.f15989a = c1932u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1932u5 c1932u5 = this.f15989a;
        c1932u5.f16131e = c1932u5.D();
    }
}
