package L3;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class P extends L {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final K3.u f1463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f1464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1466n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(K3.a json, K3.u value) {
        super(json, value, null, null, 12, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(value, "value");
        this.f1463k = value;
        List listG0 = X2.x.g0(s0().keySet());
        this.f1464l = listG0;
        this.f1465m = listG0.size() * 2;
        this.f1466n = -1;
    }

    @Override // L3.L, J3.S
    public String a0(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return (String) this.f1464l.get(i4 / 2);
    }

    @Override // L3.L, L3.AbstractC0380c, I3.c
    public void c(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
    }

    @Override // L3.L, L3.AbstractC0380c
    public K3.h e0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        return this.f1466n % 2 == 0 ? K3.i.c(tag) : (K3.h) X2.L.f(s0(), tag);
    }

    @Override // L3.L, I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        int i4 = this.f1466n;
        if (i4 >= this.f1465m - 1) {
            return -1;
        }
        int i5 = i4 + 1;
        this.f1466n = i5;
        return i5;
    }

    @Override // L3.L, L3.AbstractC0380c
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public K3.u s0() {
        return this.f1463k;
    }
}
