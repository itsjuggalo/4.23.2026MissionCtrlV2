package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f990a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f991b = E.a("kotlin.UInt", G3.a.A(kotlin.jvm.internal.q.f13431a));

    public int a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return W2.w.c(decoder.g(getDescriptor()).l());
    }

    public void b(I3.f encoder, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.f(getDescriptor()).B(i4);
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return W2.w.a(a(eVar));
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f991b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((W2.w) obj).k());
    }
}
