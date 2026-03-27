package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1119v;
import androidx.datastore.preferences.protobuf.k0;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1106h implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1105g f11254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11257d = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11258a;

        static {
            int[] iArr = new int[k0.b.values().length];
            f11258a = iArr;
            try {
                iArr[k0.b.f11306j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11258a[k0.b.f11310n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11258a[k0.b.f11299c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11258a[k0.b.f11312p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11258a[k0.b.f11305i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11258a[k0.b.f11304h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11258a[k0.b.f11300d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11258a[k0.b.f11303g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11258a[k0.b.f11301e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11258a[k0.b.f11309m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11258a[k0.b.f11313q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11258a[k0.b.f11314r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11258a[k0.b.f11315s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11258a[k0.b.f11316t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11258a[k0.b.f11307k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11258a[k0.b.f11311o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11258a[k0.b.f11302f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C1106h(AbstractC1105g abstractC1105g) {
        AbstractC1105g abstractC1105g2 = (AbstractC1105g) AbstractC1118u.b(abstractC1105g, "input");
        this.f11254a = abstractC1105g2;
        abstractC1105g2.f11229d = this;
    }

    public static C1106h O(AbstractC1105g abstractC1105g) {
        C1106h c1106h = abstractC1105g.f11229d;
        return c1106h != null ? c1106h : new C1106h(abstractC1105g);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void A(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 2) {
            int iD = this.f11254a.D();
            Y(iD);
            int iE = this.f11254a.e() + iD;
            do {
                list.add(Float.valueOf(this.f11254a.t()));
            } while (this.f11254a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1119v.e();
        }
        do {
            list.add(Float.valueOf(this.f11254a.t()));
            if (this.f11254a.f()) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == this.f11255b);
        this.f11257d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int B() throws C1119v.a {
        X(0);
        return this.f11254a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean C() {
        int i8;
        if (this.f11254a.f() || (i8 = this.f11255b) == this.f11256c) {
            return false;
        }
        return this.f11254a.F(i8);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int D() throws C1119v.a {
        X(5);
        return this.f11254a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void E(List list) throws C1119v.a {
        int iC;
        if (k0.b(this.f11255b) != 2) {
            throw C1119v.e();
        }
        do {
            list.add(z());
            if (this.f11254a.f()) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == this.f11255b);
        this.f11257d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void F(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 1) {
            do {
                list.add(Double.valueOf(this.f11254a.p()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iD = this.f11254a.D();
        Z(iD);
        int iE = this.f11254a.e() + iD;
        do {
            list.add(Double.valueOf(this.f11254a.p()));
        } while (this.f11254a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long G() throws C1119v.a {
        X(0);
        return this.f11254a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String H() throws C1119v.a {
        X(2);
        return this.f11254a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void I(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f11254a.s()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iD = this.f11254a.D();
        Z(iD);
        int iE = this.f11254a.e() + iD;
        do {
            list.add(Long.valueOf(this.f11254a.s()));
        } while (this.f11254a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void J(Object obj, Y y7, C1111m c1111m) throws C1119v {
        X(2);
        Q(obj, y7, c1111m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f11254a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(java.util.Map r8, androidx.datastore.preferences.protobuf.C.a r9, androidx.datastore.preferences.protobuf.C1111m r10) throws androidx.datastore.preferences.protobuf.C1119v.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.f11254a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.g r2 = r7.f11254a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.f11138b
            java.lang.Object r3 = r9.f11140d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.g r5 = r7.f11254a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.v r4 = new androidx.datastore.preferences.protobuf.v     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f11139c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            java.lang.Object r5 = r9.f11140d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f11137a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C1119v.a -> L51
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
            androidx.datastore.preferences.protobuf.g r8 = r7.f11254a
            r8.l(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.g r9 = r7.f11254a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C1106h.K(java.util.Map, androidx.datastore.preferences.protobuf.C$a, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void L(Object obj, Y y7, C1111m c1111m) throws C1119v.a {
        X(3);
        P(obj, y7, c1111m);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void M(List list, Y y7, C1111m c1111m) throws C1119v.a {
        int iC;
        if (k0.b(this.f11255b) != 3) {
            throw C1119v.e();
        }
        int i8 = this.f11255b;
        do {
            list.add(S(y7, c1111m));
            if (this.f11254a.f() || this.f11257d != 0) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == i8);
        this.f11257d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void N(List list, Y y7, C1111m c1111m) throws C1119v.a {
        int iC;
        if (k0.b(this.f11255b) != 2) {
            throw C1119v.e();
        }
        int i8 = this.f11255b;
        do {
            list.add(T(y7, c1111m));
            if (this.f11254a.f() || this.f11257d != 0) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == i8);
        this.f11257d = iC;
    }

    public final void P(Object obj, Y y7, C1111m c1111m) {
        int i8 = this.f11256c;
        this.f11256c = k0.c(k0.a(this.f11255b), 4);
        try {
            y7.h(obj, this, c1111m);
            if (this.f11255b == this.f11256c) {
            } else {
                throw C1119v.h();
            }
        } finally {
            this.f11256c = i8;
        }
    }

    public final void Q(Object obj, Y y7, C1111m c1111m) throws C1119v {
        int iD = this.f11254a.D();
        AbstractC1105g abstractC1105g = this.f11254a;
        if (abstractC1105g.f11226a >= abstractC1105g.f11227b) {
            throw C1119v.i();
        }
        int iM = abstractC1105g.m(iD);
        this.f11254a.f11226a++;
        y7.h(obj, this, c1111m);
        this.f11254a.a(0);
        r5.f11226a--;
        this.f11254a.l(iM);
    }

    public final Object R(k0.b bVar, Class cls, C1111m c1111m) {
        switch (a.f11258a[bVar.ordinal()]) {
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
                return U(cls, c1111m);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(j());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return H();
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return Integer.valueOf(l());
            case 17:
                return Long.valueOf(c());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    public final Object S(Y y7, C1111m c1111m) {
        Object objF = y7.f();
        P(objF, y7, c1111m);
        y7.b(objF);
        return objF;
    }

    public final Object T(Y y7, C1111m c1111m) throws C1119v {
        Object objF = y7.f();
        Q(objF, y7, c1111m);
        y7.b(objF);
        return objF;
    }

    public Object U(Class cls, C1111m c1111m) throws C1119v.a {
        X(2);
        return T(U.a().c(cls), c1111m);
    }

    public void V(List list, boolean z7) throws C1119v.a {
        int iC;
        if (k0.b(this.f11255b) != 2) {
            throw C1119v.e();
        }
        do {
            list.add(z7 ? H() : v());
            if (this.f11254a.f()) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == this.f11255b);
        this.f11257d = iC;
    }

    public final void W(int i8) throws C1119v {
        if (this.f11254a.e() != i8) {
            throw C1119v.m();
        }
    }

    public final void X(int i8) throws C1119v.a {
        if (k0.b(this.f11255b) != i8) {
            throw C1119v.e();
        }
    }

    public final void Y(int i8) throws C1119v {
        if ((i8 & 3) != 0) {
            throw C1119v.h();
        }
    }

    public final void Z(int i8) throws C1119v {
        if ((i8 & 7) != 0) {
            throw C1119v.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int a() {
        return this.f11255b;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void b(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f11254a.y()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Integer.valueOf(this.f11254a.y()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long c() throws C1119v.a {
        X(0);
        return this.f11254a.E();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long d() throws C1119v.a {
        X(1);
        return this.f11254a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void e(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 2) {
            int iD = this.f11254a.D();
            Y(iD);
            int iE = this.f11254a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f11254a.w()));
            } while (this.f11254a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1119v.e();
        }
        do {
            list.add(Integer.valueOf(this.f11254a.w()));
            if (this.f11254a.f()) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == this.f11255b);
        this.f11257d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void f(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f11254a.z()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Long.valueOf(this.f11254a.z()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void g(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f11254a.D()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Integer.valueOf(this.f11254a.D()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int h() throws C1119v.a {
        X(5);
        return this.f11254a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean i() throws C1119v.a {
        X(0);
        return this.f11254a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long j() throws C1119v.a {
        X(1);
        return this.f11254a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void k(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f11254a.E()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Long.valueOf(this.f11254a.E()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int l() throws C1119v.a {
        X(0);
        return this.f11254a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void m(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f11254a.v()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Long.valueOf(this.f11254a.v()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void n(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f11254a.x()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iD = this.f11254a.D();
        Z(iD);
        int iE = this.f11254a.e() + iD;
        do {
            list.add(Long.valueOf(this.f11254a.x()));
        } while (this.f11254a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void o(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f11254a.u()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Integer.valueOf(this.f11254a.u()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void p(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f11254a.q()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Integer.valueOf(this.f11254a.q()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int q() throws C1119v.a {
        X(0);
        return this.f11254a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void r(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 2) {
            int iD = this.f11254a.D();
            Y(iD);
            int iE = this.f11254a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f11254a.r()));
            } while (this.f11254a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1119v.e();
        }
        do {
            list.add(Integer.valueOf(this.f11254a.r()));
            if (this.f11254a.f()) {
                return;
            } else {
                iC = this.f11254a.C();
            }
        } while (iC == this.f11255b);
        this.f11257d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public double readDouble() throws C1119v.a {
        X(1);
        return this.f11254a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public float readFloat() throws C1119v.a {
        X(5);
        return this.f11254a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int s() throws C1119v.a {
        X(0);
        return this.f11254a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long t() throws C1119v.a {
        X(0);
        return this.f11254a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void u(List list) throws C1119v {
        int iC;
        int iB = k0.b(this.f11255b);
        if (iB == 0) {
            do {
                list.add(Boolean.valueOf(this.f11254a.n()));
                if (this.f11254a.f()) {
                    return;
                } else {
                    iC = this.f11254a.C();
                }
            } while (iC == this.f11255b);
            this.f11257d = iC;
            return;
        }
        if (iB != 2) {
            throw C1119v.e();
        }
        int iE = this.f11254a.e() + this.f11254a.D();
        do {
            list.add(Boolean.valueOf(this.f11254a.n()));
        } while (this.f11254a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String v() throws C1119v.a {
        X(2);
        return this.f11254a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int w() {
        int i8 = this.f11257d;
        if (i8 != 0) {
            this.f11255b = i8;
            this.f11257d = 0;
        } else {
            this.f11255b = this.f11254a.C();
        }
        int i9 = this.f11255b;
        if (i9 == 0 || i9 == this.f11256c) {
            return Integer.MAX_VALUE;
        }
        return k0.a(i9);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void x(List list) throws C1119v.a {
        V(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void y(List list) throws C1119v.a {
        V(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public AbstractC1104f z() throws C1119v.a {
        X(2);
        return this.f11254a.o();
    }
}
