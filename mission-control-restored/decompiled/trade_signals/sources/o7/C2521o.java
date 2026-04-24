package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: renamed from: o7.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2521o implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2521o f22193a = new C2521o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22194b = new q0("kotlin.Char", d.c.f21502a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Character deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Character.valueOf(decoder.h());
    }

    public void b(n7.f encoder, char c8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.n(c8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22194b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Character) obj).charValue());
    }
}
