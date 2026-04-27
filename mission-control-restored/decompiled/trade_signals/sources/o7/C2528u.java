package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: renamed from: o7.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2528u implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2528u f22209a = new C2528u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22210b = new q0("kotlin.time.Duration", d.i.f21508a);

    public long a(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return W6.a.f9306b.c(decoder.q());
    }

    public void b(n7.f encoder, long j8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.E(W6.a.Y(j8));
    }

    @Override // k7.a
    public /* bridge */ /* synthetic */ Object deserialize(n7.e eVar) {
        return W6.a.k(a(eVar));
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22210b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((W6.a) obj).c0());
    }
}
