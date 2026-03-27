package r6;

import p6.d;

/* JADX INFO: renamed from: r6.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2632t implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2632t f22927a = new C2632t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22928b = new h0("kotlin.Double", d.C0336d.f22065a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Double.valueOf(decoder.G());
    }

    public void b(q6.f encoder, double d7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.g(d7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22928b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).doubleValue());
    }
}
