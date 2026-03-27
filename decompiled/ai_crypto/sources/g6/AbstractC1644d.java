package g6;

/* JADX INFO: renamed from: g6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1644d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f14291a = new F("CLOSED");

    public static final AbstractC1645e b(AbstractC1645e abstractC1645e) {
        while (true) {
            Object objF = abstractC1645e.f();
            if (objF == f14291a) {
                return abstractC1645e;
            }
            AbstractC1645e abstractC1645e2 = (AbstractC1645e) objF;
            if (abstractC1645e2 != null) {
                abstractC1645e = abstractC1645e2;
            } else if (abstractC1645e.j()) {
                return abstractC1645e;
            }
        }
    }

    public static final Object c(C c7, long j7, Q5.o oVar) {
        while (true) {
            if (c7.f14269c >= j7 && !c7.h()) {
                return D.a(c7);
            }
            Object objF = c7.f();
            if (objF == f14291a) {
                return D.a(f14291a);
            }
            C c8 = (C) ((AbstractC1645e) objF);
            if (c8 == null) {
                c8 = (C) oVar.invoke(Long.valueOf(c7.f14269c + 1), c7);
                if (c7.l(c8)) {
                    if (c7.h()) {
                        c7.k();
                    }
                }
            }
            c7 = c8;
        }
    }
}
