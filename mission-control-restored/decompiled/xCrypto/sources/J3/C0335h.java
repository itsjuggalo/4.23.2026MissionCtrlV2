package J3;

import H3.d;

/* JADX INFO: renamed from: J3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0335h implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0335h f929a = new C0335h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f930b = new h0("kotlin.Boolean", d.a.f734a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Boolean.valueOf(decoder.e());
    }

    public void b(I3.f encoder, boolean z4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.n(z4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f930b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Boolean) obj).booleanValue());
    }
}
