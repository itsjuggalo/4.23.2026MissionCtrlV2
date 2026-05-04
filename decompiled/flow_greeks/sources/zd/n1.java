package zd;

import wd.i;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends g2 implements wd.p, wd.i {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final cd.k f25794q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.d implements i.a, pd.p {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final n1 f25795j;

        public a(n1 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25795j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public n1 o() {
            return this.f25795j;
        }

        public void e0(Object obj, Object obj2, Object obj3) throws xd.a {
            o().p0(obj, obj2, obj3);
        }

        @Override // pd.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws xd.a {
            e0(obj, obj2, obj3);
            return cd.h0.f3852a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f25794q = cd.l.a(cd.n.f3864b, new m1(this));
    }

    public static final a m0(n1 n1Var) {
        return new a(n1Var);
    }

    @Override // wd.i
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a g() {
        return (a) this.f25794q.getValue();
    }

    public void p0(Object obj, Object obj2, Object obj3) throws xd.a {
        g().call(obj, obj2, obj3);
    }
}
