package J3;

import H3.d;
import s3.C1779a;

/* JADX INFO: renamed from: J3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0347u implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0347u f974a = new C0347u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f975b = new h0("kotlin.time.Duration", d.i.f742a);

    public long a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return C1779a.f14679b.c(decoder.q());
    }

    public void b(I3.f encoder, long j4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.F(C1779a.J(j4));
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return C1779a.i(a(eVar));
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f975b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((C1779a) obj).N());
    }
}
