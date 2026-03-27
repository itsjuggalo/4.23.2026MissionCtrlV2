package q6;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a {
        public static Object a(e eVar, n6.a deserializer) {
            r.f(deserializer, "deserializer");
            return deserializer.deserialize(eVar);
        }
    }

    byte D();

    short E();

    float F();

    double G();

    c c(p6.e eVar);

    boolean f();

    char g();

    int h(p6.e eVar);

    int k();

    Object l(n6.a aVar);

    Void m();

    String o();

    long r();

    boolean t();

    e x(p6.e eVar);
}
