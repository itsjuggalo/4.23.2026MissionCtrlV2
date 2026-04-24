package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class J implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final J f22118a = new J();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22119b = new q0("kotlin.Int", d.f.f21505a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Integer.valueOf(decoder.m());
    }

    public void b(n7.f encoder, int i8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.w(i8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22119b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
