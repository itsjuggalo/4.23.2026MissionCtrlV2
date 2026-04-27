package I3;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    public static final class a {
        public static int a(c cVar, H3.e descriptor) {
            r.f(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, H3.e eVar, int i4, F3.a aVar, Object obj, int i5, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i5 & 8) != 0) {
                obj = null;
            }
            return cVar.m(eVar, i4, aVar, obj);
        }
    }

    int B(H3.e eVar);

    byte D(H3.e eVar, int i4);

    float E(H3.e eVar, int i4);

    M3.e a();

    void c(H3.e eVar);

    int h(H3.e eVar, int i4);

    int i(H3.e eVar);

    long j(H3.e eVar, int i4);

    Object m(H3.e eVar, int i4, F3.a aVar, Object obj);

    boolean n(H3.e eVar, int i4);

    e s(H3.e eVar, int i4);

    short u(H3.e eVar, int i4);

    String v(H3.e eVar, int i4);

    boolean w();

    char x(H3.e eVar, int i4);

    Object y(H3.e eVar, int i4, F3.a aVar, Object obj);

    double z(H3.e eVar, int i4);
}
