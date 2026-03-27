package t3;

/* JADX INFO: renamed from: t3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1830o extends Z2.e {

    /* JADX INFO: renamed from: t3.o$a */
    public static final class a {
        public static /* synthetic */ boolean a(InterfaceC1830o interfaceC1830o, Throwable th, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i4 & 1) != 0) {
                th = null;
            }
            return interfaceC1830o.cancel(th);
        }
    }

    boolean cancel(Throwable th);

    void g(i3.k kVar);

    void h(Object obj, i3.k kVar);

    Object i(Throwable th);

    boolean isCompleted();

    void j(I i4, Object obj);

    Object o(Object obj, Object obj2, i3.k kVar);

    void p(Object obj);
}
