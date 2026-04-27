package J3;

import kotlin.jvm.internal.C1579d;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f972a = new t0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f973b = E.a("kotlin.UByte", G3.a.w(C1579d.f13418a));

    public byte a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return W2.u.c(decoder.g(getDescriptor()).C());
    }

    public void b(I3.f encoder, byte b4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.f(getDescriptor()).m(b4);
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return W2.u.a(a(eVar));
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f973b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((W2.u) obj).k());
    }
}
