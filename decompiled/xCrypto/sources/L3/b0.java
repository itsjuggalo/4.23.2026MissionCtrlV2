package L3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {
    public static final Object a(K3.a aVar, K3.h element, F3.a deserializer) {
        I3.e h4;
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(element, "element");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        if (element instanceof K3.u) {
            h4 = new L(aVar, (K3.u) element, null, null, 12, null);
        } else if (element instanceof K3.b) {
            h4 = new N(aVar, (K3.b) element);
        } else {
            if (!(element instanceof K3.o ? true : kotlin.jvm.internal.r.b(element, K3.s.INSTANCE))) {
                throw new W2.m();
            }
            h4 = new H(aVar, (K3.w) element);
        }
        return h4.p(deserializer);
    }

    public static final Object b(K3.a aVar, String discriminator, K3.u element, F3.a deserializer) {
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(discriminator, "discriminator");
        kotlin.jvm.internal.r.f(element, "element");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return new L(aVar, element, discriminator, deserializer.getDescriptor()).p(deserializer);
    }
}
