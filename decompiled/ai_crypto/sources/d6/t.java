package d6;

/* JADX INFO: loaded from: classes2.dex */
public interface t {

    public static final class a {
        public static /* synthetic */ boolean a(t tVar, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return tVar.d(th);
        }
    }

    Object a(Object obj, H5.d dVar);

    boolean d(Throwable th);

    Object k(Object obj);

    void l(Q5.k kVar);

    boolean m();
}
