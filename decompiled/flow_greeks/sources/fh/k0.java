package fh;

import bh.l;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class k0 extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eh.c0 f9587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bh.e f9588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9590j;

    public /* synthetic */ k0(eh.b bVar, eh.c0 c0Var, String str, bh.e eVar, int i10, kotlin.jvm.internal.k kVar) {
        this(bVar, c0Var, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : eVar);
    }

    public final boolean C0(bh.e eVar, int i10) {
        boolean z10 = (d().f().j() || eVar.p(i10) || !eVar.o(i10).j()) ? false : true;
        this.f9590j = z10;
        return z10;
    }

    public final boolean D0(bh.e eVar, int i10, String str) {
        eh.b bVarD = d();
        boolean zP = eVar.p(i10);
        bh.e eVarO = eVar.o(i10);
        if (zP && !eVarO.j() && (l0(str) instanceof eh.z)) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(eVarO.h(), l.b.f3401a) || (eVarO.j() && (l0(str) instanceof eh.z))) {
            return false;
        }
        eh.i iVarL0 = l0(str);
        eh.e0 e0Var = iVarL0 instanceof eh.e0 ? (eh.e0) iVarL0 : null;
        String strF = e0Var != null ? eh.j.f(e0Var) : null;
        if (strF == null) {
            return false;
        }
        return e0.i(eVarO, bVarD, strF) == -3 && (zP || (!bVarD.f().j() && eVarO.j()));
    }

    @Override // fh.c
    /* JADX INFO: renamed from: E0 */
    public eh.c0 z0() {
        return this.f9587g;
    }

    @Override // fh.c, ch.e
    public ch.c b(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (descriptor != this.f9588h) {
            return super.b(descriptor);
        }
        eh.b bVarD = d();
        eh.i iVarM0 = m0();
        String strI = this.f9588h.i();
        if (iVarM0 instanceof eh.c0) {
            return new k0(bVarD, (eh.c0) iVarM0, y0(), this.f9588h);
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarM0.getClass()).c() + " as the serialized body of " + strI + " at element: " + i0(), iVarM0.toString());
    }

    @Override // fh.c, ch.c
    public void c(bh.e descriptor) {
        Set setL;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (this.f9552f.k() || (descriptor.h() instanceof bh.c)) {
            return;
        }
        e0.m(descriptor, d());
        if (this.f9552f.o()) {
            Set setA = dh.k0.a(descriptor);
            Map map = (Map) eh.g0.a(d()).a(descriptor, e0.g());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = dd.u0.d();
            }
            setL = dd.v0.l(setA, setKeySet);
        } else {
            setL = dh.k0.a(descriptor);
        }
        for (String str : z0().keySet()) {
            if (!setL.contains(str) && !kotlin.jvm.internal.t.b(str, y0())) {
                throw c0.g(str, z0().toString());
            }
        }
    }

    @Override // dh.t0
    public String f0(bh.e descriptor, int i10) {
        Object next;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        e0.m(descriptor, d());
        String strM = descriptor.m(i10);
        if (!this.f9552f.o() || z0().keySet().contains(strM)) {
            return strM;
        }
        Map mapE = e0.e(d(), descriptor);
        Iterator<T> it = z0().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer num = (Integer) mapE.get((String) next);
            if (num != null && num.intValue() == i10) {
                break;
            }
        }
        String str = (String) next;
        return str != null ? str : strM;
    }

    @Override // fh.c
    public eh.i l0(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        return (eh.i) dd.o0.i(z0(), tag);
    }

    @Override // fh.c, ch.e
    public boolean t() {
        return !this.f9590j && super.t();
    }

    @Override // ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        while (this.f9589i < descriptor.l()) {
            int i10 = this.f9589i;
            this.f9589i = i10 + 1;
            String strZ = Z(descriptor, i10);
            int i11 = this.f9589i - 1;
            this.f9590j = false;
            if (z0().containsKey(strZ) || C0(descriptor, i11)) {
                if (!this.f9552f.g() || !D0(descriptor, i11, strZ)) {
                    return i11;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(eh.b json, eh.c0 value, String str, bh.e eVar) {
        super(json, value, str, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(value, "value");
        this.f9587g = value;
        this.f9588h = eVar;
    }
}
