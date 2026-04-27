package s6;

import p6.i;
import t6.A;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f23066a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f23067b = p6.h.d("kotlinx.serialization.json.JsonNull", i.b.f22093a, new p6.e[0], null, 8, null);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public s deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        k.g(decoder);
        if (decoder.t()) {
            throw new A("Expected 'null' literal");
        }
        decoder.m();
        return s.INSTANCE;
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, s value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        encoder.e();
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f23067b;
    }
}
