package L3;

/* JADX INFO: loaded from: classes3.dex */
public final class H extends AbstractC0380c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K3.h f1449f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(K3.a json, K3.h value) {
        super(json, value, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(value, "value");
        this.f1449f = value;
        X("primitive");
    }

    @Override // L3.AbstractC0380c
    public K3.h e0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        if (tag == "primitive") {
            return s0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return 0;
    }

    @Override // L3.AbstractC0380c
    public K3.h s0() {
        return this.f1449f;
    }
}
