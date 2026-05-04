package m9;

import g9.g1;
import g9.m;
import i9.k1;
import i9.n4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m9.m;
import m9.x0;
import m9.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f16353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16354b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f16355c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f16356d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f16357e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j9.f f16358f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16359a;

        static {
            int[] iArr = new int[y0.e.values().length];
            f16359a = iArr;
            try {
                iArr[y0.e.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16359a[y0.e.Added.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16359a[y0.e.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16359a[y0.e.Current.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16359a[y0.e.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        SUCCESS,
        SKIPPED,
        FALSE_POSITIVE
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        n4 a(int i10);

        g8.e b(int i10);
    }

    public z0(j9.f fVar, c cVar) {
        this.f16358f = fVar;
        this.f16353a = cVar;
    }

    public final void a(int i10, j9.r rVar) {
        if (l(i10)) {
            e(i10).a(rVar.getKey(), s(i10, rVar.getKey()) ? m.a.MODIFIED : m.a.ADDED);
            this.f16355c.put(rVar.getKey(), rVar);
            d(rVar.getKey()).add(Integer.valueOf(i10));
        }
    }

    public final b b(m mVar, y0.c cVar, int i10) {
        return cVar.a().a() == i10 - f(mVar, cVar.b()) ? b.SUCCESS : b.FALSE_POSITIVE;
    }

    public n0 c(j9.v vVar) {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f16354b.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int iIntValue = num.intValue();
            w0 w0Var = (w0) entry.getValue();
            n4 n4VarN = n(iIntValue);
            if (n4VarN != null) {
                if (w0Var.d() && n4VarN.g().s()) {
                    j9.k kVarK = j9.k.k(n4VarN.g().n());
                    if (this.f16355c.get(kVarK) == null && !s(iIntValue, kVarK)) {
                        p(iIntValue, kVarK, j9.r.r(kVarK, vVar));
                    }
                }
                if (w0Var.c()) {
                    map.put(num, w0Var.j());
                    w0Var.b();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry2 : this.f16356d.entrySet()) {
            j9.k kVar = (j9.k) entry2.getKey();
            Iterator it = ((Set) entry2.getValue()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.add(kVar);
                    break;
                }
                n4 n4VarN2 = n(((Integer) it.next()).intValue());
                if (n4VarN2 == null || n4VarN2.c().equals(k1.LIMBO_RESOLUTION)) {
                }
            }
        }
        Iterator it2 = this.f16355c.values().iterator();
        while (it2.hasNext()) {
            ((j9.r) it2.next()).v(vVar);
        }
        n0 n0Var = new n0(vVar, Collections.unmodifiableMap(map), Collections.unmodifiableMap(this.f16357e), Collections.unmodifiableMap(this.f16355c), Collections.unmodifiableSet(hashSet));
        this.f16355c = new HashMap();
        this.f16356d = new HashMap();
        this.f16357e = new HashMap();
        return n0Var;
    }

    public final Set d(j9.k kVar) {
        Set set = (Set) this.f16356d.get(kVar);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.f16356d.put(kVar, hashSet);
        return hashSet;
    }

    public final w0 e(int i10) {
        w0 w0Var = (w0) this.f16354b.get(Integer.valueOf(i10));
        if (w0Var != null) {
            return w0Var;
        }
        w0 w0Var2 = new w0();
        this.f16354b.put(Integer.valueOf(i10), w0Var2);
        return w0Var2;
    }

    public final int f(m mVar, int i10) {
        g8.e<j9.k> eVarB = this.f16353a.b(i10);
        String str = "projects/" + this.f16358f.i() + "/databases/" + this.f16358f.h() + "/documents/";
        int i11 = 0;
        for (j9.k kVar : eVarB) {
            if (!mVar.h(str + kVar.s().c())) {
                p(i10, kVar, null);
                i11++;
            }
        }
        return i11;
    }

    public final int g(int i10) {
        v0 v0VarJ = e(i10).j();
        return (this.f16353a.b(i10).size() + v0VarJ.b().size()) - v0VarJ.d().size();
    }

    public final Collection h(y0.d dVar) {
        List listD = dVar.d();
        if (!listD.isEmpty()) {
            return listD;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.f16354b.keySet()) {
            if (l(num.intValue())) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    public void i(y0.b bVar) {
        j9.r rVarB = bVar.b();
        j9.k kVarA = bVar.a();
        Iterator it = bVar.d().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (rVarB == null || !rVarB.b()) {
                p(iIntValue, kVarA, rVarB);
            } else {
                a(iIntValue, rVarB);
            }
        }
        Iterator it2 = bVar.c().iterator();
        while (it2.hasNext()) {
            p(((Integer) it2.next()).intValue(), kVarA, bVar.b());
        }
    }

    public void j(y0.c cVar) {
        int iB = cVar.b();
        int iA = cVar.a().a();
        n4 n4VarN = n(iB);
        if (n4VarN != null) {
            g1 g1VarG = n4VarN.g();
            if (g1VarG.s()) {
                if (iA != 0) {
                    n9.b.d(iA == 1, "Single document existence filter with count: %d", Integer.valueOf(iA));
                    return;
                } else {
                    j9.k kVarK = j9.k.k(g1VarG.n());
                    p(iB, kVarK, j9.r.r(kVarK, j9.v.f14278b));
                    return;
                }
            }
            int iG = g(iB);
            if (iG != iA) {
                m mVarM = m(cVar);
                b bVarB = mVarM != null ? b(mVarM, cVar, iG) : b.SKIPPED;
                if (bVarB != b.SUCCESS) {
                    r(iB);
                    this.f16357e.put(Integer.valueOf(iB), bVarB == b.FALSE_POSITIVE ? k1.EXISTENCE_FILTER_MISMATCH_BLOOM : k1.EXISTENCE_FILTER_MISMATCH);
                }
                x0.a().b(x0.b.e(iG, cVar.a(), this.f16358f, mVarM, bVarB));
            }
        }
    }

    public void k(y0.d dVar) {
        Iterator it = h(dVar).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            w0 w0VarE = e(iIntValue);
            int i10 = a.f16359a[dVar.b().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    w0VarE.h();
                    if (!w0VarE.e()) {
                        w0VarE.b();
                    }
                    w0VarE.k(dVar.c());
                } else if (i10 == 3) {
                    w0VarE.h();
                    if (!w0VarE.e()) {
                        q(iIntValue);
                    }
                    n9.b.d(dVar.a() == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                } else if (i10 != 4) {
                    if (i10 != 5) {
                        throw n9.b.a("Unknown target watch change state: %s", dVar.b());
                    }
                    if (l(iIntValue)) {
                        r(iIntValue);
                        w0VarE.k(dVar.c());
                    }
                } else if (l(iIntValue)) {
                    w0VarE.f();
                    w0VarE.k(dVar.c());
                }
            } else if (l(iIntValue)) {
                w0VarE.k(dVar.c());
            }
        }
    }

    public final boolean l(int i10) {
        return n(i10) != null;
    }

    public final m m(y0.c cVar) {
        bb.g gVarB = cVar.a().b();
        if (gVarB != null && gVarB.d0()) {
            try {
                m mVarA = m.a(gVarB.a0().a0(), gVarB.a0().c0(), gVarB.c0());
                if (mVarA.c() == 0) {
                    return null;
                }
                return mVarA;
            } catch (m.a e10) {
                n9.v.e("WatchChangeAggregator", "Applying bloom filter failed: (" + e10.getMessage() + "); ignoring the bloom filter and falling back to full re-query.", new Object[0]);
            }
        }
        return null;
    }

    public final n4 n(int i10) {
        w0 w0Var = (w0) this.f16354b.get(Integer.valueOf(i10));
        if (w0Var == null || !w0Var.e()) {
            return this.f16353a.a(i10);
        }
        return null;
    }

    public void o(int i10) {
        e(i10).g();
    }

    public final void p(int i10, j9.k kVar, j9.r rVar) {
        if (l(i10)) {
            w0 w0VarE = e(i10);
            if (s(i10, kVar)) {
                w0VarE.a(kVar, m.a.REMOVED);
            } else {
                w0VarE.i(kVar);
            }
            d(kVar).add(Integer.valueOf(i10));
            if (rVar != null) {
                this.f16355c.put(kVar, rVar);
            }
        }
    }

    public void q(int i10) {
        this.f16354b.remove(Integer.valueOf(i10));
    }

    public final void r(int i10) {
        n9.b.d((this.f16354b.get(Integer.valueOf(i10)) == null || ((w0) this.f16354b.get(Integer.valueOf(i10))).e()) ? false : true, "Should only reset active targets", new Object[0]);
        this.f16354b.put(Integer.valueOf(i10), new w0());
        Iterator it = this.f16353a.b(i10).iterator();
        while (it.hasNext()) {
            p(i10, (j9.k) it.next(), null);
        }
    }

    public final boolean s(int i10, j9.k kVar) {
        return this.f16353a.b(i10).contains(kVar);
    }
}
