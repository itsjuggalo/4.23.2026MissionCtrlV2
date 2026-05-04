package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends c1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f24943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qf.k f24946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final pd.k f24947f;

    public d1(u1 constructor, List arguments, boolean z10, qf.k memberScope, pd.k refinedTypeFactory) {
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(memberScope, "memberScope");
        kotlin.jvm.internal.t.f(refinedTypeFactory, "refinedTypeFactory");
        this.f24943b = constructor;
        this.f24944c = arguments;
        this.f24945d = z10;
        this.f24946e = memberScope;
        this.f24947f = refinedTypeFactory;
        if (!(q() instanceof zf.g) || (q() instanceof zf.m)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + q() + '\n' + N0());
    }

    @Override // xf.r0
    public List L0() {
        return this.f24944c;
    }

    @Override // xf.r0
    public q1 M0() {
        return q1.f25042b.k();
    }

    @Override // xf.r0
    public u1 N0() {
        return this.f24943b;
    }

    @Override // xf.r0
    public boolean O0() {
        return this.f24945d;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public c1 R0(boolean z10) {
        return z10 == O0() ? this : z10 ? new a1(this) : new y0(this);
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new e1(this, newAttributes);
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public c1 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        c1 c1Var = (c1) this.f24947f.invoke(kotlinTypeRefiner);
        return c1Var == null ? this : c1Var;
    }

    @Override // xf.r0
    public qf.k q() {
        return this.f24946e;
    }
}
