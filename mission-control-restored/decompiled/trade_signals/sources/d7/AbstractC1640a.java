package d7;

/* JADX INFO: renamed from: d7.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1640a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f17040a = new D("CLOSED");

    public static final AbstractC1641b b(AbstractC1641b abstractC1641b) {
        while (true) {
            Object objG = abstractC1641b.g();
            if (objG == f17040a) {
                return abstractC1641b;
            }
            AbstractC1641b abstractC1641b2 = (AbstractC1641b) objG;
            if (abstractC1641b2 != null) {
                abstractC1641b = abstractC1641b2;
            } else if (abstractC1641b.m()) {
                return abstractC1641b;
            }
        }
    }

    public static final Object c(A a8, long j8, B5.o oVar) {
        while (true) {
            if (a8.f17024c >= j8 && !a8.k()) {
                return B.a(a8);
            }
            Object objG = a8.g();
            if (objG == f17040a) {
                return B.a(f17040a);
            }
            A a9 = (A) ((AbstractC1641b) objG);
            if (a9 == null) {
                a9 = (A) oVar.invoke(Long.valueOf(a8.f17024c + 1), a8);
                if (a8.o(a9)) {
                    if (a8.k()) {
                        a8.n();
                    }
                }
            }
            a8 = a9;
        }
    }
}
