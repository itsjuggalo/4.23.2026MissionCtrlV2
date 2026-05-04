package zd;

import wd.k;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends d2 implements wd.k {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final cd.k f25778q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.d implements k.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final l1 f25779j;

        public a(l1 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25779j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public l1 o() {
            return this.f25779j;
        }

        public void e0(Object obj, Object obj2) throws xd.a {
            o().p0(obj, obj2);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws xd.a {
            e0(obj, obj2);
            return cd.h0.f3852a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(c1 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        this.f25778q = cd.l.a(cd.n.f3864b, new k1(this));
    }

    public static final a m0(l1 l1Var) {
        return new a(l1Var);
    }

    @Override // wd.k, wd.i
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a g() {
        return (a) this.f25778q.getValue();
    }

    public void p0(Object obj, Object obj2) throws xd.a {
        g().call(obj, obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f25778q = cd.l.a(cd.n.f3864b, new k1(this));
    }
}
