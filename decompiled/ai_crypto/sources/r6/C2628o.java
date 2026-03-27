package r6;

import p6.d;

/* JADX INFO: renamed from: r6.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2628o implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2628o f22907a = new C2628o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22908b = new h0("kotlin.Char", d.c.f22064a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Character deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Character.valueOf(decoder.g());
    }

    public void b(q6.f encoder, char c7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.p(c7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22908b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Character) obj).charValue());
    }
}
