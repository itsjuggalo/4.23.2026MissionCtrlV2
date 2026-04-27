package r6;

import a6.C0929a;
import p6.d;

/* JADX INFO: renamed from: r6.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2633u implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2633u f22931a = new C2633u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22932b = new h0("kotlin.time.Duration", d.i.f22070a);

    public long a(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return C0929a.f6400b.c(decoder.o());
    }

    public void b(q6.f encoder, long j7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.F(C0929a.I(j7));
    }

    @Override // n6.a
    public /* bridge */ /* synthetic */ Object deserialize(q6.e eVar) {
        return C0929a.i(a(eVar));
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22932b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((C0929a) obj).M());
    }
}
