package a7;

import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public interface x {

    public static final class a {
        public static /* synthetic */ boolean a(x xVar, Throwable th, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i8 & 1) != 0) {
                th = null;
            }
            return xVar.h(th);
        }
    }

    void b(B5.k kVar);

    boolean h(Throwable th);

    Object m(Object obj);

    Object n(Object obj, InterfaceC2707e interfaceC2707e);

    boolean o();
}
