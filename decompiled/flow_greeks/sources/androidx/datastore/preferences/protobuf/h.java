package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.v;
import com.google.android.gms.common.api.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1726d = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1727a;

        static {
            int[] iArr = new int[j1.b.values().length];
            f1727a = iArr;
            try {
                iArr[j1.b.f1775j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1727a[j1.b.f1779n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1727a[j1.b.f1768c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1727a[j1.b.f1781p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1727a[j1.b.f1774i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1727a[j1.b.f1773h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1727a[j1.b.f1769d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1727a[j1.b.f1772g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1727a[j1.b.f1770e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1727a[j1.b.f1778m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1727a[j1.b.f1782q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1727a[j1.b.f1783r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1727a[j1.b.f1784s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1727a[j1.b.f1785t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1727a[j1.b.f1776k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1727a[j1.b.f1780o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1727a[j1.b.f1771f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public h(g gVar) {
        g gVar2 = (g) u.b(gVar, "input");
        this.f1723a = gVar2;
        gVar2.f1702d = this;
    }

    public static h O(g gVar) {
        h hVar = gVar.f1702d;
        return hVar != null ? hVar : new h(gVar);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void A(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 2) {
            int iD = this.f1723a.D();
            Y(iD);
            int iE = this.f1723a.e() + iD;
            do {
                list.add(Float.valueOf(this.f1723a.t()));
            } while (this.f1723a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw v.e();
        }
        do {
            list.add(Float.valueOf(this.f1723a.t()));
            if (this.f1723a.f()) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == this.f1724b);
        this.f1726d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int B() throws v.a {
        X(0);
        return this.f1723a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public boolean C() {
        int i10;
        if (this.f1723a.f() || (i10 = this.f1724b) == this.f1725c) {
            return false;
        }
        return this.f1723a.F(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int D() throws v.a {
        X(5);
        return this.f1723a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void E(List list) throws v.a {
        int iC;
        if (j1.b(this.f1724b) != 2) {
            throw v.e();
        }
        do {
            list.add(z());
            if (this.f1723a.f()) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == this.f1724b);
        this.f1726d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void F(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 1) {
            do {
                list.add(Double.valueOf(this.f1723a.p()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iD = this.f1723a.D();
        Z(iD);
        int iE = this.f1723a.e() + iD;
        do {
            list.add(Double.valueOf(this.f1723a.p()));
        } while (this.f1723a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long G() throws v.a {
        X(0);
        return this.f1723a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public String H() throws v.a {
        X(2);
        return this.f1723a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void I(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f1723a.s()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iD = this.f1723a.D();
        Z(iD);
        int iE = this.f1723a.e() + iD;
        do {
            list.add(Long.valueOf(this.f1723a.s()));
        } while (this.f1723a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void J(Object obj, x0 x0Var, m mVar) throws v {
        X(2);
        Q(obj, x0Var, mVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f1723a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(java.util.Map r8, androidx.datastore.preferences.protobuf.c0.a r9, androidx.datastore.preferences.protobuf.m r10) throws androidx.datastore.preferences.protobuf.v.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.f1723a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.g r2 = r7.f1723a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.f1671b
            java.lang.Object r3 = r9.f1673d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.g r5 = r7.f1723a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.v r4 = new androidx.datastore.preferences.protobuf.v     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.j1$b r4 = r9.f1672c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            java.lang.Object r5 = r9.f1673d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.j1$b r4 = r9.f1670a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.v.a -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.v r8 = new androidx.datastore.preferences.protobuf.v     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.g r8 = r7.f1723a
            r8.l(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.g r9 = r7.f1723a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.K(java.util.Map, androidx.datastore.preferences.protobuf.c0$a, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void L(Object obj, x0 x0Var, m mVar) throws v.a {
        X(3);
        P(obj, x0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void M(List list, x0 x0Var, m mVar) throws v.a {
        int iC;
        if (j1.b(this.f1724b) != 3) {
            throw v.e();
        }
        int i10 = this.f1724b;
        do {
            list.add(S(x0Var, mVar));
            if (this.f1723a.f() || this.f1726d != 0) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == i10);
        this.f1726d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void N(List list, x0 x0Var, m mVar) throws v.a {
        int iC;
        if (j1.b(this.f1724b) != 2) {
            throw v.e();
        }
        int i10 = this.f1724b;
        do {
            list.add(T(x0Var, mVar));
            if (this.f1723a.f() || this.f1726d != 0) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == i10);
        this.f1726d = iC;
    }

    public final void P(Object obj, x0 x0Var, m mVar) {
        int i10 = this.f1725c;
        this.f1725c = j1.c(j1.a(this.f1724b), 4);
        try {
            x0Var.h(obj, this, mVar);
            if (this.f1724b == this.f1725c) {
            } else {
                throw v.h();
            }
        } finally {
            this.f1725c = i10;
        }
    }

    public final void Q(Object obj, x0 x0Var, m mVar) throws v {
        int iD = this.f1723a.D();
        g gVar = this.f1723a;
        if (gVar.f1699a >= gVar.f1700b) {
            throw v.i();
        }
        int iM = gVar.m(iD);
        this.f1723a.f1699a++;
        x0Var.h(obj, this, mVar);
        this.f1723a.a(0);
        r5.f1699a--;
        this.f1723a.l(iM);
    }

    public final Object R(j1.b bVar, Class cls, m mVar) {
        switch (a.f1727a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(i());
            case 2:
                return z();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(q());
            case 5:
                return Integer.valueOf(h());
            case 6:
                return Long.valueOf(d());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(B());
            case 9:
                return Long.valueOf(G());
            case 10:
                return U(cls, mVar);
            case 11:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(j());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return H();
            case 16:
                return Integer.valueOf(l());
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return Long.valueOf(c());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    public final Object S(x0 x0Var, m mVar) {
        Object objF = x0Var.f();
        P(objF, x0Var, mVar);
        x0Var.b(objF);
        return objF;
    }

    public final Object T(x0 x0Var, m mVar) throws v {
        Object objF = x0Var.f();
        Q(objF, x0Var, mVar);
        x0Var.b(objF);
        return objF;
    }

    public Object U(Class cls, m mVar) throws v.a {
        X(2);
        return T(t0.a().c(cls), mVar);
    }

    public void V(List list, boolean z10) throws v.a {
        int iC;
        if (j1.b(this.f1724b) != 2) {
            throw v.e();
        }
        do {
            list.add(z10 ? H() : v());
            if (this.f1723a.f()) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == this.f1724b);
        this.f1726d = iC;
    }

    public final void W(int i10) throws v {
        if (this.f1723a.e() != i10) {
            throw v.m();
        }
    }

    public final void X(int i10) throws v.a {
        if (j1.b(this.f1724b) != i10) {
            throw v.e();
        }
    }

    public final void Y(int i10) throws v {
        if ((i10 & 3) != 0) {
            throw v.h();
        }
    }

    public final void Z(int i10) throws v {
        if ((i10 & 7) != 0) {
            throw v.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int a() {
        return this.f1724b;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void b(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f1723a.y()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Integer.valueOf(this.f1723a.y()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long c() throws v.a {
        X(0);
        return this.f1723a.E();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long d() throws v.a {
        X(1);
        return this.f1723a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void e(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 2) {
            int iD = this.f1723a.D();
            Y(iD);
            int iE = this.f1723a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f1723a.w()));
            } while (this.f1723a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f1723a.w()));
            if (this.f1723a.f()) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == this.f1724b);
        this.f1726d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void f(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f1723a.z()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Long.valueOf(this.f1723a.z()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void g(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f1723a.D()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Integer.valueOf(this.f1723a.D()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int h() throws v.a {
        X(5);
        return this.f1723a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public boolean i() throws v.a {
        X(0);
        return this.f1723a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long j() throws v.a {
        X(1);
        return this.f1723a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void k(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f1723a.E()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Long.valueOf(this.f1723a.E()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int l() throws v.a {
        X(0);
        return this.f1723a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void m(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f1723a.v()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Long.valueOf(this.f1723a.v()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void n(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f1723a.x()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iD = this.f1723a.D();
        Z(iD);
        int iE = this.f1723a.e() + iD;
        do {
            list.add(Long.valueOf(this.f1723a.x()));
        } while (this.f1723a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void o(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f1723a.u()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Integer.valueOf(this.f1723a.u()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void p(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f1723a.q()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Integer.valueOf(this.f1723a.q()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int q() throws v.a {
        X(0);
        return this.f1723a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void r(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 2) {
            int iD = this.f1723a.D();
            Y(iD);
            int iE = this.f1723a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f1723a.r()));
            } while (this.f1723a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f1723a.r()));
            if (this.f1723a.f()) {
                return;
            } else {
                iC = this.f1723a.C();
            }
        } while (iC == this.f1724b);
        this.f1726d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public double readDouble() throws v.a {
        X(1);
        return this.f1723a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public float readFloat() throws v.a {
        X(5);
        return this.f1723a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int s() throws v.a {
        X(0);
        return this.f1723a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long t() throws v.a {
        X(0);
        return this.f1723a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void u(List list) throws v {
        int iC;
        int iB = j1.b(this.f1724b);
        if (iB == 0) {
            do {
                list.add(Boolean.valueOf(this.f1723a.n()));
                if (this.f1723a.f()) {
                    return;
                } else {
                    iC = this.f1723a.C();
                }
            } while (iC == this.f1724b);
            this.f1726d = iC;
            return;
        }
        if (iB != 2) {
            throw v.e();
        }
        int iE = this.f1723a.e() + this.f1723a.D();
        do {
            list.add(Boolean.valueOf(this.f1723a.n()));
        } while (this.f1723a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public String v() throws v.a {
        X(2);
        return this.f1723a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int w() {
        int i10 = this.f1726d;
        if (i10 != 0) {
            this.f1724b = i10;
            this.f1726d = 0;
        } else {
            this.f1724b = this.f1723a.C();
        }
        int i11 = this.f1724b;
        return (i11 == 0 || i11 == this.f1725c) ? a.e.API_PRIORITY_OTHER : j1.a(i11);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void x(List list) throws v.a {
        V(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void y(List list) throws v.a {
        V(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public f z() throws v.a {
        X(2);
        return this.f1723a.o();
    }
}
