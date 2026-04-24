package b6;

/* JADX INFO: renamed from: b6.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1085o extends H5.d {

    /* JADX INFO: renamed from: b6.o$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC1085o interfaceC1085o, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return interfaceC1085o.cancel(th);
        }
    }

    void c(Object obj, Q5.k kVar);

    boolean cancel(Throwable th);

    Object e(Object obj, Object obj2, Q5.k kVar);

    Object f(Throwable th);

    void g(Q5.k kVar);

    void i(I i7, Object obj);

    boolean isCompleted();

    void n(Object obj);
}
