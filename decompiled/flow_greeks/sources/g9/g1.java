package g9;

import android.util.Pair;
import g9.a1;
import g9.p;
import j9.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j9.t f10216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f10218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f10219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f10220h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10221a;

        static {
            int[] iArr = new int[p.b.values().length];
            f10221a = iArr;
            try {
                iArr[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10221a[p.b.ARRAY_CONTAINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10221a[p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10221a[p.b.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10221a[p.b.NOT_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10221a[p.b.NOT_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10221a[p.b.LESS_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10221a[p.b.LESS_THAN_OR_EQUAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10221a[p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10221a[p.b.GREATER_THAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public g1(j9.t tVar, String str, List list, List list2, long j10, i iVar, i iVar2) {
        this.f10216d = tVar;
        this.f10217e = str;
        this.f10214b = list2;
        this.f10215c = list;
        this.f10218f = j10;
        this.f10219g = iVar;
        this.f10220h = iVar2;
    }

    public List a(j9.p pVar) {
        p.c cVarC = pVar.c();
        if (cVarC == null) {
            return null;
        }
        for (p pVar2 : g(cVarC.c())) {
            int i10 = a.f10221a[pVar2.g().ordinal()];
            if (i10 == 1) {
                return pVar2.h().l0().h();
            }
            if (i10 == 2) {
                return Collections.singletonList(pVar2.h());
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair b(p.c cVar, i iVar) {
        bb.d0 d0Var = j9.y.f14286c;
        Iterator it = g(cVar.c()).iterator();
        boolean zC = true;
        while (true) {
            int i10 = 0;
            boolean z10 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    while (true) {
                        if (i10 < this.f10214b.size()) {
                            if (((a1) this.f10214b.get(i10)).c().equals(cVar.c())) {
                                bb.d0 d0Var2 = (bb.d0) iVar.b().get(i10);
                                if (j9.y.E(d0Var, zC, d0Var2, iVar.c()) < 0) {
                                    zC = iVar.c();
                                    d0Var = d0Var2;
                                }
                            } else {
                                i10++;
                            }
                        }
                    }
                }
                return new Pair(d0Var, Boolean.valueOf(zC));
            }
            p pVar = (p) it.next();
            bb.d0 d0VarH = j9.y.f14286c;
            switch (a.f10221a[pVar.g().ordinal()]) {
                case 3:
                case 4:
                case 9:
                    d0VarH = pVar.h();
                    z10 = true;
                    break;
                case 5:
                case 6:
                default:
                    z10 = true;
                    break;
                case 7:
                case 8:
                    d0VarH = j9.y.s(pVar.h());
                    z10 = true;
                    break;
                case 10:
                    d0VarH = pVar.h();
                    break;
            }
            if (j9.y.E(d0Var, zC, d0VarH, z10) < 0) {
                zC = z10;
                d0Var = d0VarH;
            }
        }
    }

    public String c() {
        String str = this.f10213a;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(n().c());
        if (this.f10217e != null) {
            sb2.append("|cg:");
            sb2.append(this.f10217e);
        }
        sb2.append("|f:");
        Iterator it = h().iterator();
        while (it.hasNext()) {
            sb2.append(((q) it.next()).a());
        }
        sb2.append("|ob:");
        for (a1 a1Var : m()) {
            sb2.append(a1Var.c().c());
            sb2.append(a1Var.b().equals(a1.a.ASCENDING) ? "asc" : "desc");
        }
        if (r()) {
            sb2.append("|l:");
            sb2.append(j());
        }
        if (this.f10219g != null) {
            sb2.append("|lb:");
            sb2.append(this.f10219g.c() ? "b:" : "a:");
            sb2.append(this.f10219g.d());
        }
        if (this.f10220h != null) {
            sb2.append("|ub:");
            sb2.append(this.f10220h.c() ? "a:" : "b:");
            sb2.append(this.f10220h.d());
        }
        String string = sb2.toString();
        this.f10213a = string;
        return string;
    }

    public String d() {
        return this.f10217e;
    }

    public final Pair e(p.c cVar, i iVar) {
        bb.d0 d0Var = j9.y.f14288e;
        Iterator it = g(cVar.c()).iterator();
        boolean zC = true;
        while (true) {
            int i10 = 0;
            z = false;
            boolean z10 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    while (true) {
                        if (i10 < this.f10214b.size()) {
                            if (((a1) this.f10214b.get(i10)).c().equals(cVar.c())) {
                                bb.d0 d0Var2 = (bb.d0) iVar.b().get(i10);
                                if (j9.y.J(d0Var, zC, d0Var2, iVar.c()) > 0) {
                                    zC = iVar.c();
                                    d0Var = d0Var2;
                                }
                            } else {
                                i10++;
                            }
                        }
                    }
                }
                return new Pair(d0Var, Boolean.valueOf(zC));
            }
            p pVar = (p) it.next();
            bb.d0 d0VarH = j9.y.f14288e;
            switch (a.f10221a[pVar.g().ordinal()]) {
                case 3:
                case 4:
                case 8:
                    d0VarH = pVar.h();
                case 5:
                case 6:
                default:
                    z10 = true;
                    break;
                case 7:
                    d0VarH = pVar.h();
                    break;
                case 9:
                case 10:
                    d0VarH = j9.y.t(pVar.h());
                    break;
            }
            if (j9.y.J(d0Var, zC, d0VarH, z10) > 0) {
                zC = z10;
                d0Var = d0VarH;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g1.class == obj.getClass()) {
            g1 g1Var = (g1) obj;
            String str = this.f10217e;
            if (str == null ? g1Var.f10217e != null : !str.equals(g1Var.f10217e)) {
                return false;
            }
            if (this.f10218f != g1Var.f10218f || !this.f10214b.equals(g1Var.f10214b) || !this.f10215c.equals(g1Var.f10215c) || !this.f10216d.equals(g1Var.f10216d)) {
                return false;
            }
            i iVar = this.f10219g;
            if (iVar == null ? g1Var.f10219g != null : !iVar.equals(g1Var.f10219g)) {
                return false;
            }
            i iVar2 = this.f10220h;
            i iVar3 = g1Var.f10220h;
            if (iVar2 != null) {
                return iVar2.equals(iVar3);
            }
            if (iVar3 == null) {
                return true;
            }
        }
        return false;
    }

    public i f() {
        return this.f10220h;
    }

    public final List g(j9.q qVar) {
        ArrayList arrayList = new ArrayList();
        for (q qVar2 : this.f10215c) {
            if (qVar2 instanceof p) {
                p pVar = (p) qVar2;
                if (pVar.f().equals(qVar)) {
                    arrayList.add(pVar);
                }
            }
        }
        return arrayList;
    }

    public List h() {
        return this.f10215c;
    }

    public int hashCode() {
        int iHashCode = this.f10214b.hashCode() * 31;
        String str = this.f10217e;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f10215c.hashCode()) * 31) + this.f10216d.hashCode()) * 31;
        long j10 = this.f10218f;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        i iVar = this.f10219g;
        int iHashCode3 = (i10 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        i iVar2 = this.f10220h;
        return iHashCode3 + (iVar2 != null ? iVar2.hashCode() : 0);
    }

    public a1.a i() {
        return ((a1) this.f10214b.get(r0.size() - 1)).b();
    }

    public long j() {
        return this.f10218f;
    }

    public i k(j9.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (p.c cVar : pVar.e()) {
            Pair pairB = cVar.h().equals(p.c.a.ASCENDING) ? b(cVar, this.f10219g) : e(cVar, this.f10219g);
            arrayList.add((bb.d0) pairB.first);
            zBooleanValue &= ((Boolean) pairB.second).booleanValue();
        }
        return new i(arrayList, zBooleanValue);
    }

    public Collection l(j9.p pVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (p.c cVar : pVar.e()) {
            for (p pVar2 : g(cVar.c())) {
                int i10 = a.f10221a[pVar2.g().ordinal()];
                if (i10 == 3 || i10 == 4) {
                    linkedHashMap.put(cVar.c(), pVar2.h());
                } else if (i10 == 5 || i10 == 6) {
                    linkedHashMap.put(cVar.c(), pVar2.h());
                    return linkedHashMap.values();
                }
            }
        }
        return null;
    }

    public List m() {
        return this.f10214b;
    }

    public j9.t n() {
        return this.f10216d;
    }

    public int o() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f10215c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            for (p pVar : ((q) it.next()).c()) {
                if (!pVar.f().G()) {
                    if (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY)) {
                        i10 = 1;
                    } else {
                        hashSet.add(pVar.f());
                    }
                }
            }
        }
        for (a1 a1Var : this.f10214b) {
            if (!a1Var.c().G()) {
                hashSet.add(a1Var.c());
            }
        }
        return hashSet.size() + i10;
    }

    public i p() {
        return this.f10219g;
    }

    public i q(j9.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (p.c cVar : pVar.e()) {
            Pair pairE = cVar.h().equals(p.c.a.ASCENDING) ? e(cVar, this.f10220h) : b(cVar, this.f10220h);
            arrayList.add((bb.d0) pairE.first);
            zBooleanValue &= ((Boolean) pairE.second).booleanValue();
        }
        return new i(arrayList, zBooleanValue);
    }

    public boolean r() {
        return this.f10218f != -1;
    }

    public boolean s() {
        return j9.k.v(this.f10216d) && this.f10217e == null && this.f10215c.isEmpty();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Query(");
        sb2.append(this.f10216d.c());
        if (this.f10217e != null) {
            sb2.append(" collectionGroup=");
            sb2.append(this.f10217e);
        }
        if (!this.f10215c.isEmpty()) {
            sb2.append(" where ");
            for (int i10 = 0; i10 < this.f10215c.size(); i10++) {
                if (i10 > 0) {
                    sb2.append(" and ");
                }
                sb2.append(this.f10215c.get(i10));
            }
        }
        if (!this.f10214b.isEmpty()) {
            sb2.append(" order by ");
            for (int i11 = 0; i11 < this.f10214b.size(); i11++) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(this.f10214b.get(i11));
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
