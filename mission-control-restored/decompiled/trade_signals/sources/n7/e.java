package n7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a {
        public static Object a(e eVar, k7.a deserializer) {
            AbstractC2304t.f(deserializer, "deserializer");
            return deserializer.deserialize(eVar);
        }
    }

    byte D();

    short F();

    float G();

    double H();

    c c(m7.e eVar);

    e e(m7.e eVar);

    boolean g();

    char h();

    int i(m7.e eVar);

    int m();

    Void o();

    String q();

    long s();

    boolean t();

    Object v(k7.a aVar);
}
