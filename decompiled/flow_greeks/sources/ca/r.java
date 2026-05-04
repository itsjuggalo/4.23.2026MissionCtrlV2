package ca;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3800a;

    public r(q qVar) {
        this.f3800a = qVar;
    }

    public static r a(q qVar) {
        return new r(qVar);
    }

    public static Executor c(q qVar) {
        return (Executor) r9.d.e(qVar.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return c(this.f3800a);
    }
}
