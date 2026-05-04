package g9;

import g9.m;
import g9.v0;
import g9.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f10397a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j9.m f10400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g8.e f10401e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y1.a f10398b = y1.a.NONE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g8.e f10402f = j9.k.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g8.e f10403g = j9.k.h();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10404a;

        static {
            int[] iArr = new int[m.a.values().length];
            f10404a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10404a[m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10404a[m.a.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10404a[m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j9.m f10405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f10406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f10407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g8.e f10408d;

        public /* synthetic */ b(j9.m mVar, n nVar, g8.e eVar, boolean z10, a aVar) {
            this(mVar, nVar, eVar, z10);
        }

        public boolean b() {
            return this.f10407c;
        }

        public b(j9.m mVar, n nVar, g8.e eVar, boolean z10) {
            this.f10405a = mVar;
            this.f10406b = nVar;
            this.f10408d = eVar;
            this.f10407c = z10;
        }
    }

    public w1(b1 b1Var, g8.e eVar) {
        this.f10397a = b1Var;
        this.f10400d = j9.m.d(b1Var.c());
        this.f10401e = eVar;
    }

    public static /* synthetic */ int a(Comparator comparator, m mVar, m mVar2) {
        int iCompare = Integer.compare(g(mVar), g(mVar2));
        return iCompare != 0 ? iCompare : comparator.compare(mVar.b(), mVar2.b());
    }

    public static int g(m mVar) {
        int i10 = a.f10404a[mVar.c().ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 3) {
                if (i10 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + mVar.c());
            }
        }
        return i11;
    }

    public x1 b(b bVar) {
        return c(bVar, null);
    }

    public x1 c(b bVar, m9.v0 v0Var) {
        return d(bVar, v0Var, false);
    }

    public x1 d(b bVar, m9.v0 v0Var, boolean z10) {
        y1 y1Var;
        n9.b.d(!bVar.f10407c, "Cannot apply changes that need a refill", new Object[0]);
        j9.m mVar = this.f10400d;
        this.f10400d = bVar.f10405a;
        this.f10403g = bVar.f10408d;
        List listB = bVar.f10406b.b();
        final Comparator comparatorC = this.f10397a.c();
        Collections.sort(listB, new Comparator() { // from class: g9.v1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return w1.a(comparatorC, (m) obj, (m) obj2);
            }
        });
        f(v0Var);
        List listN = z10 ? Collections.EMPTY_LIST : n();
        y1.a aVar = (this.f10402f.size() == 0 && this.f10399c && !z10) ? y1.a.SYNCED : y1.a.LOCAL;
        boolean z11 = aVar != this.f10398b;
        this.f10398b = aVar;
        if (listB.size() != 0 || z11) {
            y1Var = new y1(this.f10397a, bVar.f10405a, mVar, listB, aVar == y1.a.LOCAL, bVar.f10408d, z11, false, (v0Var == null || v0Var.e().isEmpty()) ? false : true);
        } else {
            y1Var = null;
        }
        return new x1(y1Var, listN);
    }

    public x1 e(z0 z0Var) {
        if (!this.f10399c || z0Var != z0.OFFLINE) {
            return new x1(null, Collections.EMPTY_LIST);
        }
        this.f10399c = false;
        return b(new b(this.f10400d, new n(), this.f10403g, false, null));
    }

    public final void f(m9.v0 v0Var) {
        if (v0Var != null) {
            Iterator it = v0Var.b().iterator();
            while (it.hasNext()) {
                this.f10401e = this.f10401e.e((j9.k) it.next());
            }
            for (j9.k kVar : v0Var.c()) {
                n9.b.d(this.f10401e.contains(kVar), "Modified document %s not found in view.", kVar);
            }
            Iterator it2 = v0Var.d().iterator();
            while (it2.hasNext()) {
                this.f10401e = this.f10401e.g((j9.k) it2.next());
            }
            this.f10399c = v0Var.f();
        }
    }

    public b h(g8.c cVar) {
        return i(cVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x012e A[PHI: r16
      0x012e: PHI (r16v5 j9.m) = (r16v1 j9.m), (r16v1 j9.m), (r16v6 j9.m), (r16v6 j9.m) binds: [B:70:0x012a, B:71:0x012c, B:58:0x00fd, B:55:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g9.w1.b i(g8.c r18, g9.w1.b r19) {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.w1.i(g8.c, g9.w1$b):g9.w1$b");
    }

    public y1.a j() {
        return this.f10398b;
    }

    public g8.e k() {
        return this.f10401e;
    }

    public final boolean l(j9.k kVar) {
        j9.h hVarE;
        return (this.f10401e.contains(kVar) || (hVarE = this.f10400d.e(kVar)) == null || hVarE.d()) ? false : true;
    }

    public final boolean m(j9.h hVar, j9.h hVar2) {
        return hVar.d() && hVar2.c() && !hVar2.d();
    }

    public final List n() {
        if (!this.f10399c) {
            return Collections.EMPTY_LIST;
        }
        g8.e<j9.k> eVar = this.f10402f;
        this.f10402f = j9.k.h();
        for (j9.h hVar : this.f10400d) {
            if (l(hVar.getKey())) {
                this.f10402f = this.f10402f.e(hVar.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(eVar.size() + this.f10402f.size());
        for (j9.k kVar : eVar) {
            if (!this.f10402f.contains(kVar)) {
                arrayList.add(new v0(v0.a.REMOVED, kVar));
            }
        }
        for (j9.k kVar2 : this.f10402f) {
            if (!eVar.contains(kVar2)) {
                arrayList.add(new v0(v0.a.ADDED, kVar2));
            }
        }
        return arrayList;
    }
}
