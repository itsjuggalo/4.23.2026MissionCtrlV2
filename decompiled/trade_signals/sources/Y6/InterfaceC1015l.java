package Y6;

import s5.InterfaceC2707e;

/* JADX INFO: renamed from: Y6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1015l extends InterfaceC2707e {

    /* JADX INFO: renamed from: Y6.l$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC1015l interfaceC1015l, Throwable th, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i8 & 1) != 0) {
                th = null;
            }
            return interfaceC1015l.k(th);
        }
    }

    void g(I i8, Object obj);

    Object i(Object obj, Object obj2, B5.p pVar);

    boolean k(Throwable th);

    void p(B5.k kVar);

    void q(Object obj, B5.p pVar);

    void s(Object obj);
}
