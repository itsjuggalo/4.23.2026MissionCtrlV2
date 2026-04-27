package o7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 implements k7.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O0 f22133b = new O0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2498c0 f22134a = new C2498c0("kotlin.Unit", C2470H.f21956a);

    public void a(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        this.f22134a.deserialize(decoder);
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, C2470H value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        this.f22134a.serialize(encoder, value);
    }

    @Override // k7.a
    public /* bridge */ /* synthetic */ Object deserialize(n7.e eVar) {
        a(eVar);
        return C2470H.f21956a;
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return this.f22134a.getDescriptor();
    }
}
