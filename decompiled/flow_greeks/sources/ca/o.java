package ca;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3792b;

    public o(n nVar, bd.a aVar) {
        this.f3791a = nVar;
        this.f3792b = aVar;
    }

    public static o a(n nVar, bd.a aVar) {
        return new o(nVar, aVar);
    }

    public static aa.o b(n nVar, Executor executor) {
        return (aa.o) r9.d.e(nVar.a(executor));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public aa.o get() {
        return b(this.f3791a, (Executor) this.f3792b.get());
    }
}
