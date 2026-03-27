package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f1002a = new z0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1003b = E.a("kotlin.ULong", G3.a.B(kotlin.jvm.internal.t.f13432a));

    public long a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return W2.y.c(decoder.g(getDescriptor()).r());
    }

    public void b(I3.f encoder, long j4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.f(getDescriptor()).D(j4);
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return W2.y.a(a(eVar));
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1003b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((W2.y) obj).k());
    }
}
