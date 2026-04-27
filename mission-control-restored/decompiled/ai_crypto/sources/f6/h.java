package f6;

import E5.E;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends g {
    public /* synthetic */ h(e6.d dVar, H5.g gVar, int i7, d6.a aVar, int i8, AbstractC2148j abstractC2148j) {
        this(dVar, (i8 & 2) != 0 ? H5.h.f2671a : gVar, (i8 & 4) != 0 ? -3 : i7, (i8 & 8) != 0 ? d6.a.SUSPEND : aVar);
    }

    @Override // f6.e
    public e g(H5.g gVar, int i7, d6.a aVar) {
        return new h(this.f14201d, gVar, i7, aVar);
    }

    @Override // f6.g
    public Object n(e6.e eVar, H5.d dVar) {
        Object objB = this.f14201d.b(eVar, dVar);
        return objB == I5.c.e() ? objB : E.f1657a;
    }

    public h(e6.d dVar, H5.g gVar, int i7, d6.a aVar) {
        super(dVar, gVar, i7, aVar);
    }
}
