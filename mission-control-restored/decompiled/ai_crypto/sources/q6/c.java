package q6;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a {
        public static int a(c cVar, p6.e descriptor) {
            r.f(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, p6.e eVar, int i7, n6.a aVar, Object obj, int i8, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i8 & 8) != 0) {
                obj = null;
            }
            return cVar.A(eVar, i7, aVar, obj);
        }
    }

    Object A(p6.e eVar, int i7, n6.a aVar, Object obj);

    short B(p6.e eVar, int i7);

    char C(p6.e eVar, int i7);

    boolean H(p6.e eVar, int i7);

    u6.e a();

    void b(p6.e eVar);

    int e(p6.e eVar, int i7);

    float i(p6.e eVar, int i7);

    int n(p6.e eVar);

    byte p(p6.e eVar, int i7);

    int q(p6.e eVar);

    e s(p6.e eVar, int i7);

    double u(p6.e eVar, int i7);

    String v(p6.e eVar, int i7);

    boolean w();

    Object y(p6.e eVar, int i7, n6.a aVar, Object obj);

    long z(p6.e eVar, int i7);
}
