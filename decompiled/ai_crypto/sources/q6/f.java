package q6;

import kotlin.jvm.internal.r;
import n6.h;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void A(int i7);

    void B(long j7);

    void F(String str);

    u6.e a();

    d c(p6.e eVar);

    void e();

    void g(double d7);

    void h(short s7);

    void j(byte b7);

    void k(boolean z7);

    void n(float f7);

    void o(p6.e eVar, int i7);

    void p(char c7);

    void q();

    void s(h hVar, Object obj);

    f u(p6.e eVar);

    d v(p6.e eVar, int i7);

    public static final class a {
        public static d a(f fVar, p6.e descriptor, int i7) {
            r.f(descriptor, "descriptor");
            return fVar.c(descriptor);
        }

        public static void c(f fVar, h serializer, Object obj) {
            r.f(serializer, "serializer");
            if (serializer.getDescriptor().c()) {
                fVar.s(serializer, obj);
            } else if (obj == null) {
                fVar.e();
            } else {
                fVar.q();
                fVar.s(serializer, obj);
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
