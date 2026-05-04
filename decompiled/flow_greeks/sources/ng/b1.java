package ng;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f17075a;

    public b1(k0 k0Var) {
        this.f17075a = k0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        k0 k0Var = this.f17075a;
        gd.j jVar = gd.j.f10531a;
        if (k0Var.a0(jVar)) {
            this.f17075a.Z(jVar, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f17075a.toString();
    }
}
