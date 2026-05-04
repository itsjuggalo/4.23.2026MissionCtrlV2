package fh;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends k0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final eh.c0 f9604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f9605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9607n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(eh.b json, eh.c0 value) {
        super(json, value, null, null, 12, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(value, "value");
        this.f9604k = value;
        List listI0 = dd.a0.I0(z0().keySet());
        this.f9605l = listI0;
        this.f9606m = listI0.size() * 2;
        this.f9607n = -1;
    }

    @Override // fh.k0, fh.c
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public eh.c0 z0() {
        return this.f9604k;
    }

    @Override // fh.k0, fh.c, ch.c
    public void c(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
    }

    @Override // fh.k0, dh.t0
    public String f0(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return (String) this.f9605l.get(i10 / 2);
    }

    @Override // fh.k0, fh.c
    public eh.i l0(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        return this.f9607n % 2 == 0 ? eh.j.c(tag) : (eh.i) dd.o0.i(z0(), tag);
    }

    @Override // fh.k0, ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        int i10 = this.f9607n;
        if (i10 >= this.f9606m - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.f9607n = i11;
        return i11;
    }
}
