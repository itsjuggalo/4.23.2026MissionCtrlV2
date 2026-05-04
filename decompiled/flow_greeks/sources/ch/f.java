package ch;

import kotlin.jvm.internal.t;
import zg.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface f {
    void A(int i10);

    void B(k kVar, Object obj);

    void D(long j10);

    void F(String str);

    gh.e a();

    d b(bh.e eVar);

    void f();

    void j(double d10);

    void k(short s10);

    void l(byte b10);

    void m(boolean z10);

    void p(float f10);

    void t(char c10);

    void u();

    f v(bh.e eVar);

    void y(bh.e eVar, int i10);

    d z(bh.e eVar, int i10);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static d a(f fVar, bh.e descriptor, int i10) {
            t.f(descriptor, "descriptor");
            return fVar.b(descriptor);
        }

        public static void c(f fVar, k serializer, Object obj) {
            t.f(serializer, "serializer");
            if (serializer.getDescriptor().j()) {
                fVar.B(serializer, obj);
            } else if (obj == null) {
                fVar.f();
            } else {
                fVar.u();
                fVar.B(serializer, obj);
            }
        }

        public static void d(f fVar, k serializer, Object obj) {
            t.f(serializer, "serializer");
            serializer.serialize(fVar, obj);
        }

        public static void b(f fVar) {
        }
    }
}
