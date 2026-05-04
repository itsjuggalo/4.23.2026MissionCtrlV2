package zd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class j extends ie.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f25750a;

    public j(c1 container) {
        kotlin.jvm.internal.t.f(container, "container");
        this.f25750a = container;
    }

    @Override // ie.o, fe.o
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a0 d(fe.z descriptor, cd.h0 data) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(data, "data");
        return new h1(this.f25750a, descriptor);
    }

    @Override // fe.o
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public a0 f(fe.y0 descriptor, cd.h0 data) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(data, "data");
        int i10 = (descriptor.e0() != null ? 1 : 0) + (descriptor.k0() != null ? 1 : 0);
        if (descriptor.i0()) {
            if (i10 == 0) {
                return new j1(this.f25750a, descriptor);
            }
            if (i10 == 1) {
                return new l1(this.f25750a, descriptor);
            }
            if (i10 == 2) {
                return new n1(this.f25750a, descriptor);
            }
        } else {
            if (i10 == 0) {
                return new a2(this.f25750a, descriptor);
            }
            if (i10 == 1) {
                return new d2(this.f25750a, descriptor);
            }
            if (i10 == 2) {
                return new g2(this.f25750a, descriptor);
            }
        }
        throw new x2("Unsupported property: " + descriptor);
    }
}
