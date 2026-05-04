package ch;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static int a(c cVar, bh.e descriptor) {
            t.f(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, bh.e eVar, int i10, zg.a aVar, Object obj, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i11 & 8) != 0) {
                obj = null;
            }
            return cVar.h(eVar, i10, aVar, obj);
        }
    }

    boolean B(bh.e eVar, int i10);

    int C(bh.e eVar, int i10);

    gh.e a();

    void c(bh.e eVar);

    long g(bh.e eVar, int i10);

    Object h(bh.e eVar, int i10, zg.a aVar, Object obj);

    double k(bh.e eVar, int i10);

    Object n(bh.e eVar, int i10, zg.a aVar, Object obj);

    int o(bh.e eVar);

    float p(bh.e eVar, int i10);

    byte r(bh.e eVar, int i10);

    String s(bh.e eVar, int i10);

    short u(bh.e eVar, int i10);

    e v(bh.e eVar, int i10);

    int w(bh.e eVar);

    char y(bh.e eVar, int i10);

    boolean z();
}
