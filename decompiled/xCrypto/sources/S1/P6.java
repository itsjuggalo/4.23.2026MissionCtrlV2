package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class P6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c7 f4176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b7 f4177b;

    public P6(b7 b7Var, c7 c7Var) {
        this.f4176a = c7Var;
        Objects.requireNonNull(b7Var);
        this.f4177b = b7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b7 b7Var = this.f4177b;
        b7Var.t0(this.f4176a);
        b7Var.A0();
    }
}
