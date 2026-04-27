package I3;

import F3.h;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface f {
    void B(int i4);

    void C(H3.e eVar, int i4);

    void D(long j4);

    void F(String str);

    M3.e a();

    d d(H3.e eVar);

    void e();

    f f(H3.e eVar);

    void h(double d4);

    void i(short s4);

    void m(byte b4);

    void n(boolean z4);

    void p(float f4);

    void q(char c4);

    void r();

    d v(H3.e eVar, int i4);

    void z(h hVar, Object obj);

    public static final class a {
        public static d a(f fVar, H3.e descriptor, int i4) {
            r.f(descriptor, "descriptor");
            return fVar.d(descriptor);
        }

        public static void c(f fVar, h serializer, Object obj) {
            r.f(serializer, "serializer");
            if (serializer.getDescriptor().c()) {
                fVar.z(serializer, obj);
            } else if (obj == null) {
                fVar.e();
            } else {
                fVar.r();
                fVar.z(serializer, obj);
            }
        }

        public static void d(f fVar, h serializer, Object obj) {
            r.f(serializer, "serializer");
            serializer.serialize(fVar, obj);
        }

        public static void b(f fVar) {
        }
    }
}
