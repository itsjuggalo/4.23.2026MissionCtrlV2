package zd;

import java.lang.reflect.Member;
import wd.p;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class g2 extends j2 implements wd.p {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final cd.k f25726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final cd.k f25727p;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.c implements p.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final g2 f25728j;

        public a(g2 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25728j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public g2 o() {
            return this.f25728j;
        }

        @Override // pd.o
        public Object invoke(Object obj, Object obj2) {
            return o().m(obj, obj2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(c1 container, String name, String signature) {
        super(container, name, signature, kotlin.jvm.internal.f.NO_RECEIVER);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        cd.n nVar = cd.n.f3864b;
        this.f25726o = cd.l.a(nVar, new e2(this));
        this.f25727p = cd.l.a(nVar, new f2(this));
    }

    public static final a h0(g2 g2Var) {
        return new a(g2Var);
    }

    public static final Member k0(g2 g2Var) {
        return g2Var.a0();
    }

    @Override // pd.o
    public Object invoke(Object obj, Object obj2) {
        return m(obj, obj2);
    }

    @Override // zd.j2
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a e0() {
        return (a) this.f25726o.getValue();
    }

    @Override // wd.p
    public Object m(Object obj, Object obj2) {
        return e0().call(obj, obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        cd.n nVar = cd.n.f3864b;
        this.f25726o = cd.l.a(nVar, new e2(this));
        this.f25727p = cd.l.a(nVar, new f2(this));
    }
}
