package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0950v;
import androidx.datastore.preferences.protobuf.k0;
import com.google.android.gms.common.api.a;
import java.util.List;
import k4.C2105D;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0937h implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0936g f7442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7445d = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7446a;

        static {
            int[] iArr = new int[k0.b.values().length];
            f7446a = iArr;
            try {
                iArr[k0.b.f7494j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7446a[k0.b.f7498n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7446a[k0.b.f7487c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7446a[k0.b.f7500p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7446a[k0.b.f7493i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7446a[k0.b.f7492h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7446a[k0.b.f7488d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7446a[k0.b.f7491g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7446a[k0.b.f7489e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7446a[k0.b.f7497m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7446a[k0.b.f7501q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7446a[k0.b.f7502r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7446a[k0.b.f7503s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7446a[k0.b.f7504t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7446a[k0.b.f7495k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7446a[k0.b.f7499o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7446a[k0.b.f7490f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C0937h(AbstractC0936g abstractC0936g) {
        AbstractC0936g abstractC0936g2 = (AbstractC0936g) AbstractC0949u.b(abstractC0936g, "input");
        this.f7442a = abstractC0936g2;
        abstractC0936g2.f7417d = this;
    }

    public static C0937h O(AbstractC0936g abstractC0936g) {
        C0937h c0937h = abstractC0936g.f7417d;
        return c0937h != null ? c0937h : new C0937h(abstractC0936g);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void A(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 2) {
            int iD = this.f7442a.D();
            Y(iD);
            int iE = this.f7442a.e() + iD;
            do {
                list.add(Float.valueOf(this.f7442a.t()));
            } while (this.f7442a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0950v.e();
        }
        do {
            list.add(Float.valueOf(this.f7442a.t()));
            if (this.f7442a.f()) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == this.f7443b);
        this.f7445d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int B() throws C0950v.a {
        X(0);
        return this.f7442a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean C() {
        int i7;
        if (this.f7442a.f() || (i7 = this.f7443b) == this.f7444c) {
            return false;
        }
        return this.f7442a.F(i7);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int D() throws C0950v.a {
        X(5);
        return this.f7442a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void E(List list) throws C0950v.a {
        int iC;
        if (k0.b(this.f7443b) != 2) {
            throw C0950v.e();
        }
        do {
            list.add(z());
            if (this.f7442a.f()) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == this.f7443b);
        this.f7445d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void F(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 1) {
            do {
                list.add(Double.valueOf(this.f7442a.p()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iD = this.f7442a.D();
        Z(iD);
        int iE = this.f7442a.e() + iD;
        do {
            list.add(Double.valueOf(this.f7442a.p()));
        } while (this.f7442a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long G() throws C0950v.a {
        X(0);
        return this.f7442a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String H() throws C0950v.a {
        X(2);
        return this.f7442a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void I(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f7442a.s()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iD = this.f7442a.D();
        Z(iD);
        int iE = this.f7442a.e() + iD;
        do {
            list.add(Long.valueOf(this.f7442a.s()));
        } while (this.f7442a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void J(Object obj, Y y7, C0942m c0942m) throws C0950v {
        X(2);
        Q(obj, y7, c0942m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f7442a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(java.util.Map r8, androidx.datastore.preferences.protobuf.C.a r9, androidx.datastore.preferences.protobuf.C0942m r10) throws androidx.datastore.preferences.protobuf.C0950v.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.f7442a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.g r2 = r7.f7442a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.f7326b
            java.lang.Object r3 = r9.f7328d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.g r5 = r7.f7442a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.v r4 = new androidx.datastore.preferences.protobuf.v     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f7327c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            java.lang.Object r5 = r9.f7328d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f7325a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0950v.a -> L51
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
            androidx.datastore.preferences.protobuf.g r8 = r7.f7442a
            r8.l(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.g r9 = r7.f7442a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0937h.K(java.util.Map, androidx.datastore.preferences.protobuf.C$a, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void L(Object obj, Y y7, C0942m c0942m) throws C0950v.a {
        X(3);
        P(obj, y7, c0942m);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void M(List list, Y y7, C0942m c0942m) throws C0950v.a {
        int iC;
        if (k0.b(this.f7443b) != 3) {
            throw C0950v.e();
        }
        int i7 = this.f7443b;
        do {
            list.add(S(y7, c0942m));
            if (this.f7442a.f() || this.f7445d != 0) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == i7);
        this.f7445d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void N(List list, Y y7, C0942m c0942m) throws C0950v.a {
        int iC;
        if (k0.b(this.f7443b) != 2) {
            throw C0950v.e();
        }
        int i7 = this.f7443b;
        do {
            list.add(T(y7, c0942m));
            if (this.f7442a.f() || this.f7445d != 0) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == i7);
        this.f7445d = iC;
    }

    public final void P(Object obj, Y y7, C0942m c0942m) {
        int i7 = this.f7444c;
        this.f7444c = k0.c(k0.a(this.f7443b), 4);
        try {
            y7.h(obj, this, c0942m);
            if (this.f7443b == this.f7444c) {
            } else {
                throw C0950v.h();
            }
        } finally {
            this.f7444c = i7;
        }
    }

    public final void Q(Object obj, Y y7, C0942m c0942m) throws C0950v {
        int iD = this.f7442a.D();
        AbstractC0936g abstractC0936g = this.f7442a;
        if (abstractC0936g.f7414a >= abstractC0936g.f7415b) {
            throw C0950v.i();
        }
        int iM = abstractC0936g.m(iD);
        this.f7442a.f7414a++;
        y7.h(obj, this, c0942m);
        this.f7442a.a(0);
        r5.f7414a--;
        this.f7442a.l(iM);
    }

    public final Object R(k0.b bVar, Class cls, C0942m c0942m) {
        switch (a.f7446a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(h());
            case 2:
                return z();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(g());
            case 6:
                return Long.valueOf(c());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(B());
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return Long.valueOf(G());
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return U(cls, c0942m);
            case 11:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(i());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return H();
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return Integer.valueOf(k());
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return Long.valueOf(b());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    public final Object S(Y y7, C0942m c0942m) {
        Object objF = y7.f();
        P(objF, y7, c0942m);
        y7.b(objF);
        return objF;
    }

    public final Object T(Y y7, C0942m c0942m) throws C0950v {
        Object objF = y7.f();
        Q(objF, y7, c0942m);
        y7.b(objF);
        return objF;
    }

    public Object U(Class cls, C0942m c0942m) throws C0950v.a {
        X(2);
        return T(U.a().c(cls), c0942m);
    }

    public void V(List list, boolean z7) throws C0950v.a {
        int iC;
        if (k0.b(this.f7443b) != 2) {
            throw C0950v.e();
        }
        do {
            list.add(z7 ? H() : v());
            if (this.f7442a.f()) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == this.f7443b);
        this.f7445d = iC;
    }

    public final void W(int i7) throws C0950v {
        if (this.f7442a.e() != i7) {
            throw C0950v.m();
        }
    }

    public final void X(int i7) throws C0950v.a {
        if (k0.b(this.f7443b) != i7) {
            throw C0950v.e();
        }
    }

    public final void Y(int i7) throws C0950v {
        if ((i7 & 3) != 0) {
            throw C0950v.h();
        }
    }

    public final void Z(int i7) throws C0950v {
        if ((i7 & 7) != 0) {
            throw C0950v.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void a(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7442a.y()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Integer.valueOf(this.f7442a.y()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long b() throws C0950v.a {
        X(0);
        return this.f7442a.E();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long c() throws C0950v.a {
        X(1);
        return this.f7442a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void d(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 2) {
            int iD = this.f7442a.D();
            Y(iD);
            int iE = this.f7442a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f7442a.w()));
            } while (this.f7442a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0950v.e();
        }
        do {
            list.add(Integer.valueOf(this.f7442a.w()));
            if (this.f7442a.f()) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == this.f7443b);
        this.f7445d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void e(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7442a.z()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Long.valueOf(this.f7442a.z()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void f(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7442a.D()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Integer.valueOf(this.f7442a.D()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int g() throws C0950v.a {
        X(5);
        return this.f7442a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean h() throws C0950v.a {
        X(0);
        return this.f7442a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long i() throws C0950v.a {
        X(1);
        return this.f7442a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void j(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7442a.E()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Long.valueOf(this.f7442a.E()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int k() throws C0950v.a {
        X(0);
        return this.f7442a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void l(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7442a.v()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Long.valueOf(this.f7442a.v()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void m(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f7442a.x()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iD = this.f7442a.D();
        Z(iD);
        int iE = this.f7442a.e() + iD;
        do {
            list.add(Long.valueOf(this.f7442a.x()));
        } while (this.f7442a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void n(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7442a.u()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Integer.valueOf(this.f7442a.u()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void o(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7442a.q()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Integer.valueOf(this.f7442a.q()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int p() throws C0950v.a {
        X(0);
        return this.f7442a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int q() {
        return this.f7443b;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void r(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 2) {
            int iD = this.f7442a.D();
            Y(iD);
            int iE = this.f7442a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f7442a.r()));
            } while (this.f7442a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0950v.e();
        }
        do {
            list.add(Integer.valueOf(this.f7442a.r()));
            if (this.f7442a.f()) {
                return;
            } else {
                iC = this.f7442a.C();
            }
        } while (iC == this.f7443b);
        this.f7445d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public double readDouble() throws C0950v.a {
        X(1);
        return this.f7442a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public float readFloat() throws C0950v.a {
        X(5);
        return this.f7442a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int s() throws C0950v.a {
        X(0);
        return this.f7442a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long t() throws C0950v.a {
        X(0);
        return this.f7442a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void u(List list) throws C0950v {
        int iC;
        int iB = k0.b(this.f7443b);
        if (iB == 0) {
            do {
                list.add(Boolean.valueOf(this.f7442a.n()));
                if (this.f7442a.f()) {
                    return;
                } else {
                    iC = this.f7442a.C();
                }
            } while (iC == this.f7443b);
            this.f7445d = iC;
            return;
        }
        if (iB != 2) {
            throw C0950v.e();
        }
        int iE = this.f7442a.e() + this.f7442a.D();
        do {
            list.add(Boolean.valueOf(this.f7442a.n()));
        } while (this.f7442a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String v() throws C0950v.a {
        X(2);
        return this.f7442a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int w() {
        int i7 = this.f7445d;
        if (i7 != 0) {
            this.f7443b = i7;
            this.f7445d = 0;
        } else {
            this.f7443b = this.f7442a.C();
        }
        int i8 = this.f7443b;
        return (i8 == 0 || i8 == this.f7444c) ? a.e.API_PRIORITY_OTHER : k0.a(i8);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void x(List list) throws C0950v.a {
        V(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void y(List list) throws C0950v.a {
        V(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public AbstractC0935f z() throws C0950v.a {
        X(2);
        return this.f7442a.o();
    }
}
