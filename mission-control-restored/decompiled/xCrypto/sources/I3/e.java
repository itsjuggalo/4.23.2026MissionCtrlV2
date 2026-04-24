package I3;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface e {

    public static final class a {
        public static Object a(e eVar, F3.a deserializer) {
            r.f(deserializer, "deserializer");
            return deserializer.deserialize(eVar);
        }
    }

    int A(H3.e eVar);

    byte C();

    short F();

    float G();

    double H();

    c d(H3.e eVar);

    boolean e();

    char f();

    e g(H3.e eVar);

    int l();

    Void o();

    Object p(F3.a aVar);

    String q();

    long r();

    boolean t();
}
