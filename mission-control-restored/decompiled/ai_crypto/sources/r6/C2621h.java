package r6;

import p6.d;

/* JADX INFO: renamed from: r6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2621h implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2621h f22886a = new C2621h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22887b = new h0("kotlin.Boolean", d.a.f22062a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Boolean.valueOf(decoder.f());
    }

    public void b(q6.f encoder, boolean z7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.k(z7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22887b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Boolean) obj).booleanValue());
    }
}
