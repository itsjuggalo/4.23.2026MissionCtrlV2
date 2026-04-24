package h7;

import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: h7.a$a, reason: collision with other inner class name */
    public static final class C0316a {
        public static /* synthetic */ boolean a(a aVar, Object obj, int i8, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i8 & 1) != 0) {
                obj = null;
            }
            return aVar.b(obj);
        }

        public static /* synthetic */ void b(a aVar, Object obj, int i8, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i8 & 1) != 0) {
                obj = null;
            }
            aVar.d(obj);
        }
    }

    Object a(Object obj, InterfaceC2707e interfaceC2707e);

    boolean b(Object obj);

    boolean c();

    void d(Object obj);
}
