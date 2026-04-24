package r6;

/* JADX INFO: loaded from: classes2.dex */
public final class D0 implements n6.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D0 f22825b = new D0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f22826a = new Y("kotlin.Unit", E5.E.f1657a);

    public void a(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        this.f22826a.deserialize(decoder);
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, E5.E value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        this.f22826a.serialize(encoder, value);
    }

    @Override // n6.a
    public /* bridge */ /* synthetic */ Object deserialize(q6.e eVar) {
        a(eVar);
        return E5.E.f1657a;
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return this.f22826a.getDescriptor();
    }
}
