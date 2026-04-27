package J3;

import H3.d;

/* JADX INFO: renamed from: J3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0342o implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0342o f950a = new C0342o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f951b = new h0("kotlin.Char", d.c.f736a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Character deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Character.valueOf(decoder.f());
    }

    public void b(I3.f encoder, char c4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.q(c4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f951b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Character) obj).charValue());
    }
}
