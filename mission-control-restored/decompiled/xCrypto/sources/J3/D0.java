package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class D0 implements F3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D0 f868b = new D0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f869a = new Y("kotlin.Unit", W2.E.f5463a);

    public void a(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        this.f869a.deserialize(decoder);
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, W2.E value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        this.f869a.serialize(encoder, value);
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        a(eVar);
        return W2.E.f5463a;
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return this.f869a.getDescriptor();
    }
}
