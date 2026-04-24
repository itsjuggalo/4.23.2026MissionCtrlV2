package J3;

import H3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f952a = new o0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f953b = new h0("kotlin.String", d.i.f742a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.q();
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, String value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        encoder.F(value);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f953b;
    }
}
