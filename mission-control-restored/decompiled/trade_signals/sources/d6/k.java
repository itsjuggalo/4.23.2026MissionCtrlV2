package d6;

import R5.H;
import a6.E;
import kotlin.jvm.internal.AbstractC2304t;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f17012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f17013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f6.e f17014d;

    public k(d components, p typeParameterResolver, InterfaceC2483k delegateForDefaultTypeQualifiers) {
        AbstractC2304t.f(components, "components");
        AbstractC2304t.f(typeParameterResolver, "typeParameterResolver");
        AbstractC2304t.f(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f17011a = components;
        this.f17012b = typeParameterResolver;
        this.f17013c = delegateForDefaultTypeQualifiers;
        this.f17014d = new f6.e(this, typeParameterResolver);
    }

    public final d a() {
        return this.f17011a;
    }

    public final E b() {
        return (E) this.f17013c.getValue();
    }

    public final InterfaceC2483k c() {
        return this.f17013c;
    }

    public final H d() {
        return this.f17011a.m();
    }

    public final H6.n e() {
        return this.f17011a.u();
    }

    public final p f() {
        return this.f17012b;
    }

    public final f6.e g() {
        return this.f17014d;
    }
}
