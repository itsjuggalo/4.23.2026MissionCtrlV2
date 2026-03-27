package t3;

import Z2.i;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 implements i.b, i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f14979a = new a1();

    @Override // Z2.i.b, Z2.i
    public Object fold(Object obj, i3.o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // Z2.i.b, Z2.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // Z2.i.b, Z2.i
    public Z2.i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // Z2.i
    public Z2.i plus(Z2.i iVar) {
        return i.b.a.d(this, iVar);
    }

    @Override // Z2.i.b
    public i.c getKey() {
        return this;
    }
}
