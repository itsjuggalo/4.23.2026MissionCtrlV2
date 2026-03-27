package p7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.l;

/* JADX INFO: loaded from: classes2.dex */
public final class A implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f22424a = new A();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22425b = m7.k.e("kotlinx.serialization.json.JsonNull", l.b.f21530a, new m7.e[0], null, 8, null);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        r.g(decoder);
        if (decoder.t()) {
            throw new q7.C("Expected 'null' literal");
        }
        decoder.o();
        return z.INSTANCE;
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, z value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        r.h(encoder);
        encoder.f();
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22425b;
    }
}
