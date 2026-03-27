package r6;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f22947a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22948b = E.a("kotlin.UInt", o6.a.B(kotlin.jvm.internal.q.f18270a));

    public int a(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return E5.w.b(decoder.x(getDescriptor()).k());
    }

    public void b(q6.f encoder, int i7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.u(getDescriptor()).A(i7);
    }

    @Override // n6.a
    public /* bridge */ /* synthetic */ Object deserialize(q6.e eVar) {
        return E5.w.a(a(eVar));
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22948b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((E5.w) obj).j());
    }
}
