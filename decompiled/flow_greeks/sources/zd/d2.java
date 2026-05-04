package zd;

import java.lang.reflect.Member;
import wd.o;
import zd.j2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d2 extends j2 implements wd.o {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final cd.k f25705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final cd.k f25706p;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends j2.c implements o.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final d2 f25707j;

        public a(d2 property) {
            kotlin.jvm.internal.t.f(property, "property");
            this.f25707j = property;
        }

        @Override // wd.m.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public d2 o() {
            return this.f25707j;
        }

        @Override // pd.k
        public Object invoke(Object obj) {
            return X().get(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(c1 container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
        cd.n nVar = cd.n.f3864b;
        this.f25705o = cd.l.a(nVar, new b2(this));
        this.f25706p = cd.l.a(nVar, new c2(this));
    }

    public static final a h0(d2 d2Var) {
        return new a(d2Var);
    }

    public static final Member k0(d2 d2Var) {
        return d2Var.a0();
    }

    @Override // wd.o
    public Object get(Object obj) {
        return d().call(obj);
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // zd.j2
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a e0() {
        return (a) this.f25705o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(c1 container, fe.y0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        cd.n nVar = cd.n.f3864b;
        this.f25705o = cd.l.a(nVar, new b2(this));
        this.f25706p = cd.l.a(nVar, new c2(this));
    }
}
