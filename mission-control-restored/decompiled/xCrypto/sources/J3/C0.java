package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class C0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0 f865a = new C0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f866b = E.a("kotlin.UShort", G3.a.C(kotlin.jvm.internal.I.f13413a));

    public short a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return W2.B.c(decoder.g(getDescriptor()).F());
    }

    public void b(I3.f encoder, short s4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.f(getDescriptor()).i(s4);
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return W2.B.a(a(eVar));
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f866b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((W2.B) obj).k());
    }
}
