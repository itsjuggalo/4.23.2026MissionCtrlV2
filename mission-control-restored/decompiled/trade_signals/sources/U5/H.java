package U5;

import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import R5.h0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class H extends AbstractC0957n implements R5.N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q6.c f8213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f8214f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(R5.H module, q6.c fqName) {
        super(module, S5.h.f7663J.b(), fqName.g(), h0.f7249a);
        AbstractC2304t.f(module, "module");
        AbstractC2304t.f(fqName, "fqName");
        this.f8213e = fqName;
        this.f8214f = "package " + fqName + " of " + module;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o visitor, Object obj) {
        AbstractC2304t.f(visitor, "visitor");
        return visitor.c(this, obj);
    }

    @Override // R5.N
    public final q6.c e() {
        return this.f8213e;
    }

    @Override // U5.AbstractC0957n, R5.InterfaceC0859p
    public h0 j() {
        h0 NO_SOURCE = h0.f7249a;
        AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // U5.AbstractC0956m
    public String toString() {
        return this.f8214f;
    }

    @Override // U5.AbstractC0957n, R5.InterfaceC0856m
    public R5.H b() {
        InterfaceC0856m interfaceC0856mB = super.b();
        AbstractC2304t.d(interfaceC0856mB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (R5.H) interfaceC0856mB;
    }
}
