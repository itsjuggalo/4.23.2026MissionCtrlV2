package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n2 implements zg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n2 f8193b = new n2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f8194a = new b1("kotlin.Unit", cd.h0.f3852a);

    public void a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        this.f8194a.deserialize(decoder);
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, cd.h0 value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        this.f8194a.serialize(encoder, value);
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        a(eVar);
        return cd.h0.f3852a;
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return this.f8194a.getDescriptor();
    }
}
