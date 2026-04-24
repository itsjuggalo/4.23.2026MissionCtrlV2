package r6;

import p6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class H implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f22831a = new H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22832b = new h0("kotlin.Int", d.f.f22067a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Integer.valueOf(decoder.k());
    }

    public void b(q6.f encoder, int i7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.A(i7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22832b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
