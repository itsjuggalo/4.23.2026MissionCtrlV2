package v3;

/* JADX INFO: loaded from: classes3.dex */
public interface u {

    public static final class a {
        public static /* synthetic */ boolean a(u uVar, Throwable th, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i4 & 1) != 0) {
                th = null;
            }
            return uVar.k(th);
        }
    }

    Object a(Object obj, Z2.e eVar);

    void b(i3.k kVar);

    boolean k(Throwable th);

    Object m(Object obj);

    boolean n();
}
