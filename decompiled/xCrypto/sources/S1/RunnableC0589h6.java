package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.h6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0589h6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7 f4658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f4659b;

    public RunnableC0589h6(C0629m6 c0629m6, b7 b7Var, Runnable runnable) {
        this.f4658a = b7Var;
        this.f4659b = runnable;
        Objects.requireNonNull(c0629m6);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b7 b7Var = this.f4658a;
        b7Var.D();
        b7Var.C(this.f4659b);
        b7Var.r();
    }
}
