package z6;

import B6.k;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import b6.InterfaceC1234j;
import d6.j;
import e6.C1677D;
import h6.EnumC1891D;
import h6.InterfaceC1898g;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: renamed from: z6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3019c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f24805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1234j f24806b;

    public C3019c(j packageFragmentProvider, InterfaceC1234j javaResolverCache) {
        AbstractC2304t.f(packageFragmentProvider, "packageFragmentProvider");
        AbstractC2304t.f(javaResolverCache, "javaResolverCache");
        this.f24805a = packageFragmentProvider;
        this.f24806b = javaResolverCache;
    }

    public final j a() {
        return this.f24805a;
    }

    public final InterfaceC0848e b(InterfaceC1898g javaClass) {
        C1677D c1677d;
        AbstractC2304t.f(javaClass, "javaClass");
        q6.c cVarE = javaClass.e();
        if (cVarE != null && javaClass.I() == EnumC1891D.f18710a) {
            return this.f24806b.e(cVarE);
        }
        InterfaceC1898g interfaceC1898gG = javaClass.g();
        if (interfaceC1898gG == null) {
            if (cVarE == null || (c1677d = (C1677D) z.a0(this.f24805a.c(cVarE.d()))) == null) {
                return null;
            }
            return c1677d.O0(javaClass);
        }
        InterfaceC0848e interfaceC0848eB = b(interfaceC1898gG);
        k kVarA0 = interfaceC0848eB != null ? interfaceC0848eB.A0() : null;
        InterfaceC0851h interfaceC0851hE = kVarA0 != null ? kVarA0.e(javaClass.getName(), Z5.d.f9788s) : null;
        if (interfaceC0851hE instanceof InterfaceC0848e) {
            return (InterfaceC0848e) interfaceC0851hE;
        }
        return null;
    }
}
