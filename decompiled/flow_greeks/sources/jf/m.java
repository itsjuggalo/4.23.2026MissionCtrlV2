package jf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m extends n {
    @Override // jf.n
    public void b(fe.b first, fe.b second) {
        kotlin.jvm.internal.t.f(first, "first");
        kotlin.jvm.internal.t.f(second, "second");
        e(first, second);
    }

    @Override // jf.n
    public void c(fe.b fromSuper, fe.b fromCurrent) {
        kotlin.jvm.internal.t.f(fromSuper, "fromSuper");
        kotlin.jvm.internal.t.f(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }

    public abstract void e(fe.b bVar, fe.b bVar2);
}
