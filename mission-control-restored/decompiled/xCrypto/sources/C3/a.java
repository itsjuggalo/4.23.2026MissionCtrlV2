package C3;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: C3.a$a, reason: collision with other inner class name */
    public static final class C0008a {
        public static /* synthetic */ boolean a(a aVar, Object obj, int i4, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i4 & 1) != 0) {
                obj = null;
            }
            return aVar.a(obj);
        }

        public static /* synthetic */ void b(a aVar, Object obj, int i4, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i4 & 1) != 0) {
                obj = null;
            }
            aVar.c(obj);
        }
    }

    boolean a(Object obj);

    boolean b();

    void c(Object obj);

    Object d(Object obj, Z2.e eVar);
}
