package r8;

import com.revenuecat.purchases.common.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f19419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19420b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19421a;

        static {
            int[] iArr = new int[n.b.values().length];
            f19421a = iArr;
            try {
                iArr[n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19421a[n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    public k(n nVar) {
        this.f19419a = nVar;
    }

    public static int c(l lVar, f fVar) {
        return Double.valueOf(((Long) lVar.getValue()).longValue()).compareTo((Double) fVar.getValue());
    }

    @Override // r8.n
    public boolean F(r8.b bVar) {
        return false;
    }

    @Override // r8.n
    public n I(j8.l lVar, n nVar) {
        r8.b bVarK = lVar.K();
        if (bVarK == null) {
            return nVar;
        }
        if (nVar.isEmpty() && !bVarK.s()) {
            return this;
        }
        boolean z10 = true;
        if (lVar.K().s() && lVar.size() != 1) {
            z10 = false;
        }
        m8.m.f(z10);
        return t(bVarK, g.y().I(lVar.S(), nVar));
    }

    @Override // r8.n
    public boolean J() {
        return true;
    }

    @Override // r8.n
    public Object N(boolean z10) {
        if (!z10 || this.f19419a.isEmpty()) {
            return getValue();
        }
        HashMap map = new HashMap();
        map.put(".value", getValue());
        map.put(".priority", this.f19419a.getValue());
        return map;
    }

    @Override // r8.n
    public n O(j8.l lVar) {
        return lVar.isEmpty() ? this : lVar.K().s() ? this.f19419a : g.y();
    }

    @Override // r8.n
    public Iterator P() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // r8.n
    public String Q() {
        if (this.f19420b == null) {
            this.f19420b = m8.m.i(C(n.b.V1));
        }
        return this.f19420b;
    }

    public abstract int a(k kVar);

    @Override // r8.n
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // r8.n
    public int j() {
        return 0;
    }

    @Override // r8.n
    public n n() {
        return this.f19419a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        if (nVar.isEmpty()) {
            return 1;
        }
        if (nVar instanceof c) {
            return -1;
        }
        m8.m.g(nVar.J(), "Node is not leaf node!");
        return ((this instanceof l) && (nVar instanceof f)) ? c((l) this, (f) nVar) : ((this instanceof f) && (nVar instanceof l)) ? c((l) nVar, (f) this) * (-1) : v((k) nVar);
    }

    public abstract b s();

    @Override // r8.n
    public n t(r8.b bVar, n nVar) {
        return bVar.s() ? D(nVar) : nVar.isEmpty() ? this : g.y().t(bVar, nVar).D(this.f19419a);
    }

    public String toString() {
        String string = N(true).toString();
        if (string.length() <= 100) {
            return string;
        }
        return string.substring(0, 100) + "...";
    }

    public String u(n.b bVar) {
        int i10 = a.f19421a[bVar.ordinal()];
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + bVar);
        }
        if (this.f19419a.isEmpty()) {
            return "";
        }
        return "priority:" + this.f19419a.C(bVar) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
    }

    public int v(k kVar) {
        b bVarS = s();
        b bVarS2 = kVar.s();
        return bVarS.equals(bVarS2) ? a(kVar) : bVarS.compareTo(bVarS2);
    }

    @Override // r8.n
    public r8.b x(r8.b bVar) {
        return null;
    }

    @Override // r8.n
    public n z(r8.b bVar) {
        return bVar.s() ? this.f19419a : g.y();
    }
}
