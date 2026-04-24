package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: renamed from: o7.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2513k implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2513k f22175a = new C2513k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22176b = new q0("kotlin.Byte", d.b.f21501a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Byte.valueOf(decoder.D());
    }

    public void b(n7.f encoder, byte b8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.j(b8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22176b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).byteValue());
    }
}
