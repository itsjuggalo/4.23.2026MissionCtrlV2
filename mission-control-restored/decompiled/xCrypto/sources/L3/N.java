package L3;

/* JADX INFO: loaded from: classes3.dex */
public final class N extends AbstractC0380c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K3.b f1459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1461h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(K3.a json, K3.b value) {
        super(json, value, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(value, "value");
        this.f1459f = value;
        this.f1460g = s0().size();
        this.f1461h = -1;
    }

    @Override // J3.S
    public String a0(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return String.valueOf(i4);
    }

    @Override // L3.AbstractC0380c
    public K3.h e0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        return s0().get(Integer.parseInt(tag));
    }

    @Override // I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        int i4 = this.f1461h;
        if (i4 >= this.f1460g - 1) {
            return -1;
        }
        int i5 = i4 + 1;
        this.f1461h = i5;
        return i5;
    }

    @Override // L3.AbstractC0380c
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public K3.b s0() {
        return this.f1459f;
    }
}
