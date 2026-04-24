package D3;

import D3.C0446p;
import D3.b0;
import G3.p;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G3.t f1317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0439i f1320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0439i f1321h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1322a;

        static {
            int[] iArr = new int[C0446p.b.values().length];
            f1322a = iArr;
            try {
                iArr[C0446p.b.ARRAY_CONTAINS_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1322a[C0446p.b.ARRAY_CONTAINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1322a[C0446p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1322a[C0446p.b.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1322a[C0446p.b.NOT_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1322a[C0446p.b.NOT_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1322a[C0446p.b.LESS_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1322a[C0446p.b.LESS_THAN_OR_EQUAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1322a[C0446p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1322a[C0446p.b.GREATER_THAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public h0(G3.t tVar, String str, List list, List list2, long j7, C0439i c0439i, C0439i c0439i2) {
        this.f1317d = tVar;
        this.f1318e = str;
        this.f1315b = list2;
        this.f1316c = list;
        this.f1319f = j7;
        this.f1320g = c0439i;
        this.f1321h = c0439i2;
    }

    public List a(G3.p pVar) {
        p.c cVarC = pVar.c();
        if (cVarC == null) {
            return null;
        }
        for (C0446p c0446p : g(cVarC.c())) {
            int i7 = a.f1322a[c0446p.g().ordinal()];
            if (i7 == 1) {
                return c0446p.h().l0().g();
            }
            if (i7 == 2) {
                return Collections.singletonList(c0446p.h());
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair b(p.c cVar, C0439i c0439i) {
        C2105D c2105d = G3.y.f2483c;
        Iterator it = g(cVar.c()).iterator();
        boolean zC = true;
        while (true) {
            int i7 = 0;
            boolean z7 = false;
            if (!it.hasNext()) {
                if (c0439i != null) {
                    while (true) {
                        if (i7 < this.f1315b.size()) {
                            if (((b0) this.f1315b.get(i7)).c().equals(cVar.c())) {
                                C2105D c2105d2 = (C2105D) c0439i.b().get(i7);
                                if (G3.y.E(c2105d, zC, c2105d2, c0439i.c()) < 0) {
                                    zC = c0439i.c();
                                    c2105d = c2105d2;
                                }
                            } else {
                                i7++;
                            }
                        }
                    }
                }
                return new Pair(c2105d, Boolean.valueOf(zC));
            }
            C0446p c0446p = (C0446p) it.next();
            C2105D c2105dH = G3.y.f2483c;
            switch (a.f1322a[c0446p.g().ordinal()]) {
                case 3:
                case 4:
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    c2105dH = c0446p.h();
                    z7 = true;
                    break;
                case 5:
                case 6:
                default:
                    z7 = true;
                    break;
                case 7:
                case 8:
                    c2105dH = G3.y.s(c0446p.h());
                    z7 = true;
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    c2105dH = c0446p.h();
                    break;
            }
            if (G3.y.E(c2105d, zC, c2105dH, z7) < 0) {
                zC = z7;
                c2105d = c2105dH;
            }
        }
    }

    public String c() {
        String str = this.f1314a;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n().c());
        if (this.f1318e != null) {
            sb.append("|cg:");
            sb.append(this.f1318e);
        }
        sb.append("|f:");
        Iterator it = h().iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC0447q) it.next()).a());
        }
        sb.append("|ob:");
        for (b0 b0Var : m()) {
            sb.append(b0Var.c().c());
            sb.append(b0Var.b().equals(b0.a.ASCENDING) ? "asc" : "desc");
        }
        if (r()) {
            sb.append("|l:");
            sb.append(j());
        }
        if (this.f1320g != null) {
            sb.append("|lb:");
            sb.append(this.f1320g.c() ? "b:" : "a:");
            sb.append(this.f1320g.d());
        }
        if (this.f1321h != null) {
            sb.append("|ub:");
            sb.append(this.f1321h.c() ? "a:" : "b:");
            sb.append(this.f1321h.d());
        }
        String string = sb.toString();
        this.f1314a = string;
        return string;
    }

    public String d() {
        return this.f1318e;
    }

    public final Pair e(p.c cVar, C0439i c0439i) {
        C2105D c2105d = G3.y.f2485e;
        Iterator it = g(cVar.c()).iterator();
        boolean zC = true;
        while (true) {
            int i7 = 0;
            z = false;
            boolean z7 = false;
            if (!it.hasNext()) {
                if (c0439i != null) {
                    while (true) {
                        if (i7 < this.f1315b.size()) {
                            if (((b0) this.f1315b.get(i7)).c().equals(cVar.c())) {
                                C2105D c2105d2 = (C2105D) c0439i.b().get(i7);
                                if (G3.y.J(c2105d, zC, c2105d2, c0439i.c()) > 0) {
                                    zC = c0439i.c();
                                    c2105d = c2105d2;
                                }
                            } else {
                                i7++;
                            }
                        }
                    }
                }
                return new Pair(c2105d, Boolean.valueOf(zC));
            }
            C0446p c0446p = (C0446p) it.next();
            C2105D c2105dH = G3.y.f2485e;
            switch (a.f1322a[c0446p.g().ordinal()]) {
                case 3:
                case 4:
                case 8:
                    c2105dH = c0446p.h();
                case 5:
                case 6:
                default:
                    z7 = true;
                    break;
                case 7:
                    c2105dH = c0446p.h();
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    c2105dH = G3.y.t(c0446p.h());
                    break;
            }
            if (G3.y.J(c2105d, zC, c2105dH, z7) > 0) {
                zC = z7;
                c2105d = c2105dH;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        h0 h0Var = (h0) obj;
        String str = this.f1318e;
        if (str == null ? h0Var.f1318e != null : !str.equals(h0Var.f1318e)) {
            return false;
        }
        if (this.f1319f != h0Var.f1319f || !this.f1315b.equals(h0Var.f1315b) || !this.f1316c.equals(h0Var.f1316c) || !this.f1317d.equals(h0Var.f1317d)) {
            return false;
        }
        C0439i c0439i = this.f1320g;
        if (c0439i == null ? h0Var.f1320g != null : !c0439i.equals(h0Var.f1320g)) {
            return false;
        }
        C0439i c0439i2 = this.f1321h;
        C0439i c0439i3 = h0Var.f1321h;
        return c0439i2 != null ? c0439i2.equals(c0439i3) : c0439i3 == null;
    }

    public C0439i f() {
        return this.f1321h;
    }

    public final List g(G3.q qVar) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0447q abstractC0447q : this.f1316c) {
            if (abstractC0447q instanceof C0446p) {
                C0446p c0446p = (C0446p) abstractC0447q;
                if (c0446p.f().equals(qVar)) {
                    arrayList.add(c0446p);
                }
            }
        }
        return arrayList;
    }

    public List h() {
        return this.f1316c;
    }

    public int hashCode() {
        int iHashCode = this.f1315b.hashCode() * 31;
        String str = this.f1318e;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f1316c.hashCode()) * 31) + this.f1317d.hashCode()) * 31;
        long j7 = this.f1319f;
        int i7 = (iHashCode2 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        C0439i c0439i = this.f1320g;
        int iHashCode3 = (i7 + (c0439i != null ? c0439i.hashCode() : 0)) * 31;
        C0439i c0439i2 = this.f1321h;
        return iHashCode3 + (c0439i2 != null ? c0439i2.hashCode() : 0);
    }

    public b0.a i() {
        return ((b0) this.f1315b.get(r0.size() - 1)).b();
    }

    public long j() {
        return this.f1319f;
    }

    public C0439i k(G3.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (p.c cVar : pVar.e()) {
            Pair pairB = cVar.h().equals(p.c.a.ASCENDING) ? b(cVar, this.f1320g) : e(cVar, this.f1320g);
            arrayList.add((C2105D) pairB.first);
            zBooleanValue &= ((Boolean) pairB.second).booleanValue();
        }
        return new C0439i(arrayList, zBooleanValue);
    }

    public Collection l(G3.p pVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (p.c cVar : pVar.e()) {
            for (C0446p c0446p : g(cVar.c())) {
                int i7 = a.f1322a[c0446p.g().ordinal()];
                if (i7 == 3 || i7 == 4) {
                    linkedHashMap.put(cVar.c(), c0446p.h());
                } else if (i7 == 5 || i7 == 6) {
                    linkedHashMap.put(cVar.c(), c0446p.h());
                    return linkedHashMap.values();
                }
            }
        }
        return null;
    }

    public List m() {
        return this.f1315b;
    }

    public G3.t n() {
        return this.f1317d;
    }

    public int o() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1316c.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            for (C0446p c0446p : ((AbstractC0447q) it.next()).c()) {
                if (!c0446p.f().x()) {
                    if (c0446p.g().equals(C0446p.b.ARRAY_CONTAINS) || c0446p.g().equals(C0446p.b.ARRAY_CONTAINS_ANY)) {
                        i7 = 1;
                    } else {
                        hashSet.add(c0446p.f());
                    }
                }
            }
        }
        for (b0 b0Var : this.f1315b) {
            if (!b0Var.c().x()) {
                hashSet.add(b0Var.c());
            }
        }
        return hashSet.size() + i7;
    }

    public C0439i p() {
        return this.f1320g;
    }

    public C0439i q(G3.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (p.c cVar : pVar.e()) {
            Pair pairE = cVar.h().equals(p.c.a.ASCENDING) ? e(cVar, this.f1321h) : b(cVar, this.f1321h);
            arrayList.add((C2105D) pairE.first);
            zBooleanValue &= ((Boolean) pairE.second).booleanValue();
        }
        return new C0439i(arrayList, zBooleanValue);
    }

    public boolean r() {
        return this.f1319f != -1;
    }

    public boolean s() {
        return G3.k.q(this.f1317d) && this.f1318e == null && this.f1316c.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(");
        sb.append(this.f1317d.c());
        if (this.f1318e != null) {
            sb.append(" collectionGroup=");
            sb.append(this.f1318e);
        }
        if (!this.f1316c.isEmpty()) {
            sb.append(" where ");
            for (int i7 = 0; i7 < this.f1316c.size(); i7++) {
                if (i7 > 0) {
                    sb.append(" and ");
                }
                sb.append(this.f1316c.get(i7));
            }
        }
        if (!this.f1315b.isEmpty()) {
            sb.append(" order by ");
            for (int i8 = 0; i8 < this.f1315b.size(); i8++) {
                if (i8 > 0) {
                    sb.append(", ");
                }
                sb.append(this.f1315b.get(i8));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
