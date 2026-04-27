package n7;

import k7.k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void A(long j8);

    void C(k kVar, Object obj);

    void E(String str);

    r7.e a();

    d c(m7.e eVar);

    f e(m7.e eVar);

    void f();

    void h(double d8);

    void i(short s8);

    void j(byte b8);

    void k(boolean z7);

    void m(float f8);

    void n(char c8);

    void o();

    void s(m7.e eVar, int i8);

    void w(int i8);

    d z(m7.e eVar, int i8);

    public static final class a {
        public static d a(f fVar, m7.e descriptor, int i8) {
            AbstractC2304t.f(descriptor, "descriptor");
            return fVar.c(descriptor);
        }

        public static void c(f fVar, k serializer, Object obj) {
            AbstractC2304t.f(serializer, "serializer");
            if (serializer.getDescriptor().c()) {
                fVar.C(serializer, obj);
            } else if (obj == null) {
                fVar.f();
            } else {
                fVar.o();
                fVar.C(serializer, obj);
            }
        }

        public static void d(f fVar, k serializer, Object obj) {
            AbstractC2304t.f(serializer, "serializer");
            serializer.serialize(fVar, obj);
        }

        public static void b(f fVar) {
        }
    }
}
