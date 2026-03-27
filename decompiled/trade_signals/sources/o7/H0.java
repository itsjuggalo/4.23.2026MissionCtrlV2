package o7;

import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.C2303s;

/* JADX INFO: loaded from: classes2.dex */
public final class H0 implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H0 f22113a = new H0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22114b = G.a("kotlin.UInt", l7.a.x(C2303s.f20500a));

    public int a(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return o5.z.b(decoder.e(getDescriptor()).m());
    }

    public void b(n7.f encoder, int i8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.e(getDescriptor()).w(i8);
    }

    @Override // k7.a
    public /* bridge */ /* synthetic */ Object deserialize(n7.e eVar) {
        return o5.z.a(a(eVar));
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22114b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((o5.z) obj).l());
    }
}
