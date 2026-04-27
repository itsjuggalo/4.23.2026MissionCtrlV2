package J3;

import H3.d;

/* JADX INFO: renamed from: J3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0338k implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0338k f940a = new C0338k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f941b = new h0("kotlin.Byte", d.b.f735a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Byte.valueOf(decoder.C());
    }

    public void b(I3.f encoder, byte b4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.m(b4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f941b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Number) obj).byteValue());
    }
}
