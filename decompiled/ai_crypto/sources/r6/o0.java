package r6;

import p6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f22909a = new o0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22910b = new h0("kotlin.String", d.i.f22070a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.o();
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, String value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        encoder.F(value);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22910b;
    }
}
