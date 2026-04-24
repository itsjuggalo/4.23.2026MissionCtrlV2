package K3;

import H3.i;
import L3.A;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f1379a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1380b = H3.h.d("kotlinx.serialization.json.JsonNull", i.b.f765a, new H3.e[0], null, 8, null);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public s deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        k.g(decoder);
        if (decoder.t()) {
            throw new A("Expected 'null' literal");
        }
        decoder.o();
        return s.INSTANCE;
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, s value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        encoder.e();
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1380b;
    }
}
