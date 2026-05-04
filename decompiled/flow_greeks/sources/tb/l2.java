package tb;

import tb.k2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l2 implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k2.d f21503a;

    public l2(k2.d dVar) {
        this.f21503a = dVar;
    }

    public static l2 c(k2.d dVar) {
        return new l2(dVar);
    }

    @Override // tb.p1
    public Object a() {
        return k2.d(this.f21503a);
    }

    @Override // tb.p1
    public Object b(Object obj) {
        k2.f(this.f21503a, obj);
        return null;
    }
}
