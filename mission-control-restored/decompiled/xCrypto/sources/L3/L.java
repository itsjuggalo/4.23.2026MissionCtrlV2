package L3;

import H3.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public class L extends AbstractC0380c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K3.u f1453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final H3.e f1455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1457j;

    public /* synthetic */ L(K3.a aVar, K3.u uVar, String str, H3.e eVar, int i4, AbstractC1585j abstractC1585j) {
        this(aVar, uVar, (i4 & 4) != 0 ? null : str, (i4 & 8) != 0 ? null : eVar);
    }

    @Override // J3.S
    public String a0(H3.e descriptor, int i4) {
        Object next;
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        F.k(descriptor, b());
        String strG = descriptor.g(i4);
        if (!this.f1513e.k() || s0().keySet().contains(strG)) {
            return strG;
        }
        Map mapD = F.d(b(), descriptor);
        Iterator<T> it = s0().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer num = (Integer) mapD.get((String) next);
            if (num != null && num.intValue() == i4) {
                break;
            }
        }
        String str = (String) next;
        return str != null ? str : strG;
    }

    @Override // L3.AbstractC0380c, I3.c
    public void c(H3.e descriptor) {
        Set setH;
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (this.f1513e.g() || (descriptor.e() instanceof H3.c)) {
            return;
        }
        F.k(descriptor, b());
        if (this.f1513e.k()) {
            Set setA = J3.I.a(descriptor);
            Map map = (Map) K3.y.a(b()).a(descriptor, F.e());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = X2.Q.b();
            }
            setH = X2.S.h(setA, setKeySet);
        } else {
            setH = J3.I.a(descriptor);
        }
        for (String str : s0().keySet()) {
            if (!setH.contains(str) && !kotlin.jvm.internal.r.b(str, this.f1454g)) {
                throw E.g(str, s0().toString());
            }
        }
    }

    @Override // L3.AbstractC0380c, I3.e
    public I3.c d(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return descriptor == this.f1455h ? this : super.d(descriptor);
    }

    @Override // L3.AbstractC0380c
    public K3.h e0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        return (K3.h) X2.L.f(s0(), tag);
    }

    @Override // I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        while (this.f1456i < descriptor.f()) {
            int i4 = this.f1456i;
            this.f1456i = i4 + 1;
            String strV = V(descriptor, i4);
            int i5 = this.f1456i - 1;
            this.f1457j = false;
            if (s0().containsKey(strV) || u0(descriptor, i5)) {
                if (!this.f1513e.d() || !v0(descriptor, i5, strV)) {
                    return i5;
                }
            }
        }
        return -1;
    }

    @Override // L3.AbstractC0380c, J3.p0, I3.e
    public boolean t() {
        return !this.f1457j && super.t();
    }

    public final boolean u0(H3.e eVar, int i4) {
        boolean z4 = (b().f().f() || eVar.j(i4) || !eVar.i(i4).c()) ? false : true;
        this.f1457j = z4;
        return z4;
    }

    public final boolean v0(H3.e eVar, int i4, String str) {
        K3.a aVarB = b();
        H3.e eVarI = eVar.i(i4);
        if (!eVarI.c() && (e0(str) instanceof K3.s)) {
            return true;
        }
        if (!kotlin.jvm.internal.r.b(eVarI.e(), i.b.f765a) || (eVarI.c() && (e0(str) instanceof K3.s))) {
            return false;
        }
        K3.h hVarE0 = e0(str);
        K3.w wVar = hVarE0 instanceof K3.w ? (K3.w) hVarE0 : null;
        String strF = wVar != null ? K3.i.f(wVar) : null;
        return strF != null && F.g(eVarI, aVarB, strF) == -3;
    }

    @Override // L3.AbstractC0380c
    /* JADX INFO: renamed from: w0 */
    public K3.u s0() {
        return this.f1453f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(K3.a json, K3.u value, String str, H3.e eVar) {
        super(json, value, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(value, "value");
        this.f1453f = value;
        this.f1454g = str;
        this.f1455h = eVar;
    }
}
