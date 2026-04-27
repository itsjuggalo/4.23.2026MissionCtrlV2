package D3;

import D3.C0443m;
import D3.W;
import D3.z0;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f1451a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public G3.m f1454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r3.e f1455e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z0.a f1452b = z0.a.NONE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r3.e f1456f = G3.k.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r3.e f1457g = G3.k.h();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1458a;

        static {
            int[] iArr = new int[C0443m.a.values().length];
            f1458a = iArr;
            try {
                iArr[C0443m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1458a[C0443m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1458a[C0443m.a.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1458a[C0443m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final G3.m f1459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0444n f1460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r3.e f1462d;

        public /* synthetic */ b(G3.m mVar, C0444n c0444n, r3.e eVar, boolean z7, a aVar) {
            this(mVar, c0444n, eVar, z7);
        }

        public boolean b() {
            return this.f1461c;
        }

        public b(G3.m mVar, C0444n c0444n, r3.e eVar, boolean z7) {
            this.f1459a = mVar;
            this.f1460b = c0444n;
            this.f1462d = eVar;
            this.f1461c = z7;
        }
    }

    public x0(c0 c0Var, r3.e eVar) {
        this.f1451a = c0Var;
        this.f1454d = G3.m.c(c0Var.c());
        this.f1455e = eVar;
    }

    public static int g(C0443m c0443m) {
        int i7 = a.f1458a[c0443m.c().ordinal()];
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2 && i7 != 3) {
                if (i7 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + c0443m.c());
            }
        }
        return i8;
    }

    public y0 b(b bVar) {
        return c(bVar, null);
    }

    public y0 c(b bVar, J3.W w7) {
        return d(bVar, w7, false);
    }

    public y0 d(b bVar, J3.W w7, boolean z7) {
        z0 z0Var;
        AbstractC0612b.d(!bVar.f1461c, "Cannot apply changes that need a refill", new Object[0]);
        G3.m mVar = this.f1454d;
        this.f1454d = bVar.f1459a;
        this.f1457g = bVar.f1462d;
        List listB = bVar.f1460b.b();
        Collections.sort(listB, new Comparator() { // from class: D3.w0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f1449a.l((C0443m) obj, (C0443m) obj2);
            }
        });
        f(w7);
        List listEmptyList = z7 ? Collections.emptyList() : o();
        z0.a aVar = (this.f1456f.size() == 0 && this.f1453c && !z7) ? z0.a.SYNCED : z0.a.LOCAL;
        boolean z8 = aVar != this.f1452b;
        this.f1452b = aVar;
        if (listB.size() != 0 || z8) {
            z0Var = new z0(this.f1451a, bVar.f1459a, mVar, listB, aVar == z0.a.LOCAL, bVar.f1462d, z8, false, (w7 == null || w7.e().isEmpty()) ? false : true);
        } else {
            z0Var = null;
        }
        return new y0(z0Var, listEmptyList);
    }

    public y0 e(a0 a0Var) {
        if (!this.f1453c || a0Var != a0.OFFLINE) {
            return new y0(null, Collections.emptyList());
        }
        this.f1453c = false;
        return b(new b(this.f1454d, new C0444n(), this.f1457g, false, null));
    }

    public final void f(J3.W w7) {
        if (w7 != null) {
            Iterator it = w7.b().iterator();
            while (it.hasNext()) {
                this.f1455e = this.f1455e.c((G3.k) it.next());
            }
            for (G3.k kVar : w7.c()) {
                AbstractC0612b.d(this.f1455e.contains(kVar), "Modified document %s not found in view.", kVar);
            }
            Iterator it2 = w7.d().iterator();
            while (it2.hasNext()) {
                this.f1455e = this.f1455e.h((G3.k) it2.next());
            }
            this.f1453c = w7.f();
        }
    }

    public b h(r3.c cVar) {
        return i(cVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0134 A[PHI: r17
      0x0134: PHI (r17v4 G3.m) = (r17v0 G3.m), (r17v0 G3.m), (r17v5 G3.m), (r17v5 G3.m) binds: [B:70:0x0130, B:71:0x0132, B:58:0x0103, B:55:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D3.x0.b i(r3.c r19, D3.x0.b r20) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D3.x0.i(r3.c, D3.x0$b):D3.x0$b");
    }

    public z0.a j() {
        return this.f1452b;
    }

    public r3.e k() {
        return this.f1455e;
    }

    public final /* synthetic */ int l(C0443m c0443m, C0443m c0443m2) {
        int iL = K3.I.l(g(c0443m), g(c0443m2));
        return iL != 0 ? iL : this.f1451a.c().compare(c0443m.b(), c0443m2.b());
    }

    public final boolean m(G3.k kVar) {
        G3.h hVarG;
        return (this.f1455e.contains(kVar) || (hVarG = this.f1454d.g(kVar)) == null || hVarG.e()) ? false : true;
    }

    public final boolean n(G3.h hVar, G3.h hVar2) {
        return hVar.e() && hVar2.c() && !hVar2.e();
    }

    public final List o() {
        if (!this.f1453c) {
            return Collections.emptyList();
        }
        r3.e<G3.k> eVar = this.f1456f;
        this.f1456f = G3.k.h();
        for (G3.h hVar : this.f1454d) {
            if (m(hVar.getKey())) {
                this.f1456f = this.f1456f.c(hVar.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(eVar.size() + this.f1456f.size());
        for (G3.k kVar : eVar) {
            if (!this.f1456f.contains(kVar)) {
                arrayList.add(new W(W.a.REMOVED, kVar));
            }
        }
        for (G3.k kVar2 : this.f1456f) {
            if (!eVar.contains(kVar2)) {
                arrayList.add(new W(W.a.ADDED, kVar2));
            }
        }
        return arrayList;
    }
}
