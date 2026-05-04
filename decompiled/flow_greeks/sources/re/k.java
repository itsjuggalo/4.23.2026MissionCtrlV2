package re;

import fe.h0;
import kotlin.jvm.internal.t;
import oe.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f19859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f19860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f19861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final te.e f19862d;

    public k(d components, p typeParameterResolver, cd.k delegateForDefaultTypeQualifiers) {
        t.f(components, "components");
        t.f(typeParameterResolver, "typeParameterResolver");
        t.f(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f19859a = components;
        this.f19860b = typeParameterResolver;
        this.f19861c = delegateForDefaultTypeQualifiers;
        this.f19862d = new te.e(this, typeParameterResolver);
    }

    public final d a() {
        return this.f19859a;
    }

    public final e0 b() {
        return (e0) this.f19861c.getValue();
    }

    public final cd.k c() {
        return this.f19861c;
    }

    public final h0 d() {
        return this.f19859a.m();
    }

    public final wf.n e() {
        return this.f19859a.u();
    }

    public final p f() {
        return this.f19860b;
    }

    public final te.e g() {
        return this.f19862d;
    }
}
