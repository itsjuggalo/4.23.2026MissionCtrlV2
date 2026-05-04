package zd;

import wd.n;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a2 extends j2 implements wd.n {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final cd.k f25679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final cd.k f25680p;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.c implements n.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final a2 f25681j;

        public a(a2 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25681j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public a2 o() {
            return this.f25681j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return o().get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        cd.n nVar = cd.n.f3864b;
        this.f25679o = cd.l.a(nVar, new y1(this));
        this.f25680p = cd.l.a(nVar, new z1(this));
    }

    public static final a h0(a2 a2Var) {
        return new a(a2Var);
    }

    public static final Object k0(a2 a2Var) {
        return a2Var.c0(a2Var.a0(), null, null);
    }

    @Override // wd.n
    public Object get() {
        return e0().call(new Object[0]);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // zd.j2
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a e0() {
        return (a) this.f25679o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(c1 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        cd.n nVar = cd.n.f3864b;
        this.f25679o = cd.l.a(nVar, new y1(this));
        this.f25680p = cd.l.a(nVar, new z1(this));
    }
}
