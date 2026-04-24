package y3;

/* JADX INFO: renamed from: y3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1950d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f15977a = new F("CLOSED");

    public static final AbstractC1951e b(AbstractC1951e abstractC1951e) {
        while (true) {
            Object objF = abstractC1951e.f();
            if (objF == f15977a) {
                return abstractC1951e;
            }
            AbstractC1951e abstractC1951e2 = (AbstractC1951e) objF;
            if (abstractC1951e2 != null) {
                abstractC1951e = abstractC1951e2;
            } else if (abstractC1951e.j()) {
                return abstractC1951e;
            }
        }
    }

    public static final Object c(C c4, long j4, i3.o oVar) {
        while (true) {
            if (c4.f15955c >= j4 && !c4.h()) {
                return D.a(c4);
            }
            Object objF = c4.f();
            if (objF == f15977a) {
                return D.a(f15977a);
            }
            C c5 = (C) ((AbstractC1951e) objF);
            if (c5 == null) {
                c5 = (C) oVar.invoke(Long.valueOf(c4.f15955c + 1), c4);
                if (c4.l(c5)) {
                    if (c4.h()) {
                        c4.k();
                    }
                }
            }
            c4 = c5;
        }
    }
}
