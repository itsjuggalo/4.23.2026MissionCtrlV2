package n7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a {
        public static int a(c cVar, m7.e descriptor) {
            AbstractC2304t.f(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, m7.e eVar, int i8, k7.a aVar, Object obj, int i9, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i9 & 8) != 0) {
                obj = null;
            }
            return cVar.u(eVar, i8, aVar, obj);
        }
    }

    boolean A(m7.e eVar, int i8);

    char B(m7.e eVar, int i8);

    long C(m7.e eVar, int i8);

    int E(m7.e eVar);

    r7.e a();

    void d(m7.e eVar);

    double f(m7.e eVar, int i8);

    String j(m7.e eVar, int i8);

    int k(m7.e eVar);

    float n(m7.e eVar, int i8);

    e p(m7.e eVar, int i8);

    byte r(m7.e eVar, int i8);

    Object u(m7.e eVar, int i8, k7.a aVar, Object obj);

    boolean w();

    short x(m7.e eVar, int i8);

    int y(m7.e eVar, int i8);

    Object z(m7.e eVar, int i8, k7.a aVar, Object obj);
}
