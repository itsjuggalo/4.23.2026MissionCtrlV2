package b6;

import H5.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 implements g.b, g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f9037a = new a1();

    @Override // H5.g.b, H5.g
    public Object fold(Object obj, Q5.o oVar) {
        return g.b.a.a(this, obj, oVar);
    }

    @Override // H5.g.b, H5.g
    public g.b get(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    @Override // H5.g.b, H5.g
    public H5.g minusKey(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // H5.g
    public H5.g plus(H5.g gVar) {
        return g.b.a.d(this, gVar);
    }

    @Override // H5.g.b
    public g.c getKey() {
        return this;
    }
}
