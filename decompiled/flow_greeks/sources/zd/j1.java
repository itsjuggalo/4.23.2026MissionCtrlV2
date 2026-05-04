package zd;

import wd.j;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends a2 implements wd.j {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final cd.k f25752q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.d implements j.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final j1 f25753j;

        public a(j1 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25753j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public j1 o() {
            return this.f25753j;
        }

        public void e0(Object obj) throws xd.a {
            o().p0(obj);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws xd.a {
            e0(obj);
            return cd.h0.f3852a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f25752q = cd.l.a(cd.n.f3864b, new i1(this));
    }

    public static final a m0(j1 j1Var) {
        return new a(j1Var);
    }

    @Override // wd.j, wd.i
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a g() {
        return (a) this.f25752q.getValue();
    }

    public void p0(Object obj) throws xd.a {
        g().call(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(c1 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        this.f25752q = cd.l.a(cd.n.f3864b, new i1(this));
    }
}
