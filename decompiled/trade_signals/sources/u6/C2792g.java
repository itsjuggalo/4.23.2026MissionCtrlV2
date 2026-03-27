package u6;

import I6.v0;
import J6.g;
import R5.D;
import R5.InterfaceC0844a;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.N;
import R5.h0;
import R5.m0;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;
import u6.C2800o;

/* JADX INFO: renamed from: u6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2792g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2792g f23537a = new C2792g();

    public static /* synthetic */ boolean f(C2792g c2792g, InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2, boolean z7, boolean z8, boolean z9, J6.g gVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z8 = true;
        }
        boolean z10 = z8;
        if ((i8 & 16) != 0) {
            z9 = false;
        }
        return c2792g.e(interfaceC0844a, interfaceC0844a2, z7, z10, z9, gVar);
    }

    public static final boolean g(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2) {
        return false;
    }

    public static final boolean h(boolean z7, InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2, v0 c12, v0 c22) {
        AbstractC2304t.f(c12, "c1");
        AbstractC2304t.f(c22, "c2");
        if (AbstractC2304t.b(c12, c22)) {
            return true;
        }
        InterfaceC0851h interfaceC0851hS = c12.s();
        InterfaceC0851h interfaceC0851hS2 = c22.s();
        if ((interfaceC0851hS instanceof m0) && (interfaceC0851hS2 instanceof m0)) {
            return f23537a.n((m0) interfaceC0851hS, (m0) interfaceC0851hS2, z7, new C2791f(interfaceC0844a, interfaceC0844a2));
        }
        return false;
    }

    public static final boolean i(InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2, InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2) {
        return AbstractC2304t.b(interfaceC0856m, interfaceC0844a) && AbstractC2304t.b(interfaceC0856m2, interfaceC0844a2);
    }

    public static /* synthetic */ boolean l(C2792g c2792g, InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z8 = true;
        }
        return c2792g.k(interfaceC0856m, interfaceC0856m2, z7, z8);
    }

    public static /* synthetic */ boolean o(C2792g c2792g, m0 m0Var, m0 m0Var2, boolean z7, B5.o oVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            oVar = C2788c.f23530a;
        }
        return c2792g.n(m0Var, m0Var2, z7, oVar);
    }

    public static final boolean p(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2) {
        return false;
    }

    public final boolean e(InterfaceC0844a a8, InterfaceC0844a b8, boolean z7, boolean z8, boolean z9, J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (AbstractC2304t.b(a8, b8)) {
            return true;
        }
        if (!AbstractC2304t.b(a8.getName(), b8.getName())) {
            return false;
        }
        if (z8 && (a8 instanceof D) && (b8 instanceof D) && ((D) a8).L() != ((D) b8).L()) {
            return false;
        }
        if ((AbstractC2304t.b(a8.b(), b8.b()) && (!z7 || !AbstractC2304t.b(r(a8), r(b8)))) || AbstractC2794i.E(a8) || AbstractC2794i.E(b8) || !q(a8, b8, C2789d.f23531a, z7)) {
            return false;
        }
        C2800o c2800oI = C2800o.i(kotlinTypeRefiner, new C2790e(z7, a8, b8));
        AbstractC2304t.e(c2800oI, "create(...)");
        C2800o.i.a aVarC = c2800oI.E(a8, b8, null, !z9).c();
        C2800o.i.a aVar = C2800o.i.a.OVERRIDABLE;
        return aVarC == aVar && c2800oI.E(b8, a8, null, z9 ^ true).c() == aVar;
    }

    public final boolean j(InterfaceC0848e interfaceC0848e, InterfaceC0848e interfaceC0848e2) {
        return AbstractC2304t.b(interfaceC0848e.l(), interfaceC0848e2.l());
    }

    public final boolean k(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2, boolean z7, boolean z8) {
        if ((interfaceC0856m instanceof InterfaceC0848e) && (interfaceC0856m2 instanceof InterfaceC0848e)) {
            return j((InterfaceC0848e) interfaceC0856m, (InterfaceC0848e) interfaceC0856m2);
        }
        if ((interfaceC0856m instanceof m0) && (interfaceC0856m2 instanceof m0)) {
            return o(this, (m0) interfaceC0856m, (m0) interfaceC0856m2, z7, null, 8, null);
        }
        if ((interfaceC0856m instanceof InterfaceC0844a) && (interfaceC0856m2 instanceof InterfaceC0844a)) {
            return f(this, (InterfaceC0844a) interfaceC0856m, (InterfaceC0844a) interfaceC0856m2, z7, z8, false, g.a.f4645a, 16, null);
        }
        boolean z9 = interfaceC0856m instanceof N;
        Object objE = interfaceC0856m;
        Object objE2 = interfaceC0856m2;
        if (z9) {
            boolean z10 = interfaceC0856m2 instanceof N;
            objE = interfaceC0856m;
            objE2 = interfaceC0856m2;
            if (z10) {
                objE = ((N) interfaceC0856m).e();
                objE2 = ((N) interfaceC0856m2).e();
            }
        }
        return AbstractC2304t.b(objE, objE2);
    }

    public final boolean m(m0 a8, m0 b8, boolean z7) {
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        return o(this, a8, b8, z7, null, 8, null);
    }

    public final boolean n(m0 a8, m0 b8, boolean z7, B5.o equivalentCallables) {
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        AbstractC2304t.f(equivalentCallables, "equivalentCallables");
        if (AbstractC2304t.b(a8, b8)) {
            return true;
        }
        return !AbstractC2304t.b(a8.b(), b8.b()) && q(a8, b8, equivalentCallables, z7) && a8.g() == b8.g();
    }

    public final boolean q(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2, B5.o oVar, boolean z7) {
        InterfaceC0856m interfaceC0856mB = interfaceC0856m.b();
        InterfaceC0856m interfaceC0856mB2 = interfaceC0856m2.b();
        return ((interfaceC0856mB instanceof InterfaceC0845b) || (interfaceC0856mB2 instanceof InterfaceC0845b)) ? ((Boolean) oVar.invoke(interfaceC0856mB, interfaceC0856mB2)).booleanValue() : l(this, interfaceC0856mB, interfaceC0856mB2, z7, false, 8, null);
    }

    public final h0 r(InterfaceC0844a interfaceC0844a) {
        while (interfaceC0844a instanceof InterfaceC0845b) {
            InterfaceC0845b interfaceC0845b = (InterfaceC0845b) interfaceC0844a;
            if (interfaceC0845b.i() != InterfaceC0845b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection collectionF = interfaceC0845b.f();
            AbstractC2304t.e(collectionF, "getOverriddenDescriptors(...)");
            interfaceC0844a = (InterfaceC0845b) z.v0(collectionF);
            if (interfaceC0844a == null) {
                return null;
            }
        }
        return interfaceC0844a.j();
    }
}
