package r6;

import p6.d;

/* JADX INFO: renamed from: r6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2624k implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2624k f22897a = new C2624k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22898b = new h0("kotlin.Byte", d.b.f22063a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Byte.valueOf(decoder.D());
    }

    public void b(q6.f encoder, byte b7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.j(b7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22898b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).byteValue());
    }
}
