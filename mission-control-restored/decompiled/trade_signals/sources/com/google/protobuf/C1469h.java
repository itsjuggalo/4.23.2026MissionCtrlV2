package com.google.protobuf;

import com.google.protobuf.C1482v;
import com.google.protobuf.l0;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1469h implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1468g f16403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16406d = 0;

    /* JADX INFO: renamed from: com.google.protobuf.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16407a;

        static {
            int[] iArr = new int[l0.b.values().length];
            f16407a = iArr;
            try {
                iArr[l0.b.f16466j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16407a[l0.b.f16470n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16407a[l0.b.f16459c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16407a[l0.b.f16472p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16407a[l0.b.f16465i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16407a[l0.b.f16464h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16407a[l0.b.f16460d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16407a[l0.b.f16463g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16407a[l0.b.f16461e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16407a[l0.b.f16469m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16407a[l0.b.f16473q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16407a[l0.b.f16474r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16407a[l0.b.f16475s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f16407a[l0.b.f16476t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f16407a[l0.b.f16467k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f16407a[l0.b.f16471o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f16407a[l0.b.f16462f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C1469h(AbstractC1468g abstractC1468g) {
        AbstractC1468g abstractC1468g2 = (AbstractC1468g) AbstractC1481u.b(abstractC1468g, "input");
        this.f16403a = abstractC1468g2;
        abstractC1468g2.f16378d = this;
    }

    public static C1469h O(AbstractC1468g abstractC1468g) {
        C1469h c1469h = abstractC1468g.f16378d;
        return c1469h != null ? c1469h : new C1469h(abstractC1468g);
    }

    @Override // com.google.protobuf.X
    public void A(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 2) {
            int iD = this.f16403a.D();
            Y(iD);
            int iE = this.f16403a.e() + iD;
            do {
                list.add(Float.valueOf(this.f16403a.t()));
            } while (this.f16403a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1482v.e();
        }
        do {
            list.add(Float.valueOf(this.f16403a.t()));
            if (this.f16403a.f()) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == this.f16404b);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public int B() throws C1482v.a {
        X(0);
        return this.f16403a.u();
    }

    @Override // com.google.protobuf.X
    public boolean C() {
        int i8;
        if (this.f16403a.f() || (i8 = this.f16404b) == this.f16405c) {
            return false;
        }
        return this.f16403a.H(i8);
    }

    @Override // com.google.protobuf.X
    public int D() throws C1482v.a {
        X(5);
        return this.f16403a.w();
    }

    @Override // com.google.protobuf.X
    public void E(List list) throws C1482v.a {
        int iC;
        if (l0.b(this.f16404b) != 2) {
            throw C1482v.e();
        }
        do {
            list.add(z());
            if (this.f16403a.f()) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == this.f16404b);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public void F(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 1) {
            do {
                list.add(Double.valueOf(this.f16403a.p()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iD = this.f16403a.D();
        Z(iD);
        int iE = this.f16403a.e() + iD;
        do {
            list.add(Double.valueOf(this.f16403a.p()));
        } while (this.f16403a.e() < iE);
    }

    @Override // com.google.protobuf.X
    public long G() throws C1482v.a {
        X(0);
        return this.f16403a.v();
    }

    @Override // com.google.protobuf.X
    public String H() throws C1482v.a {
        X(2);
        return this.f16403a.B();
    }

    @Override // com.google.protobuf.X
    public void I(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f16403a.s()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iD = this.f16403a.D();
        Z(iD);
        int iE = this.f16403a.e() + iD;
        do {
            list.add(Long.valueOf(this.f16403a.s()));
        } while (this.f16403a.e() < iE);
    }

    @Override // com.google.protobuf.X
    public void J(List list, Y y7, C1474m c1474m) throws C1482v.a {
        int iC;
        if (l0.b(this.f16404b) != 3) {
            throw C1482v.e();
        }
        int i8 = this.f16404b;
        do {
            list.add(S(y7, c1474m));
            if (this.f16403a.f() || this.f16406d != 0) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == i8);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public void K(Object obj, Y y7, C1474m c1474m) throws C1482v.a {
        X(3);
        P(obj, y7, c1474m);
    }

    @Override // com.google.protobuf.X
    public void L(List list, Y y7, C1474m c1474m) throws C1482v.a {
        int iC;
        if (l0.b(this.f16404b) != 2) {
            throw C1482v.e();
        }
        int i8 = this.f16404b;
        do {
            list.add(T(y7, c1474m));
            if (this.f16403a.f() || this.f16406d != 0) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == i8);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public void M(Object obj, Y y7, C1474m c1474m) throws C1482v {
        X(2);
        Q(obj, y7, c1474m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f16403a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // com.google.protobuf.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N(java.util.Map r8, com.google.protobuf.C.a r9, com.google.protobuf.C1474m r10) throws com.google.protobuf.C1482v.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            com.google.protobuf.g r1 = r7.f16403a
            int r1 = r1.D()
            com.google.protobuf.g r2 = r7.f16403a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.f16283b
            java.lang.Object r3 = r9.f16285d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.g r5 = r7.f16403a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.v r4 = new com.google.protobuf.v     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.l0$b r4 = r9.f16284c     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            java.lang.Object r5 = r9.f16285d     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            goto L14
        L49:
            com.google.protobuf.l0$b r4 = r9.f16282a     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.C1482v.a -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.v r8 = new com.google.protobuf.v     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.g r8 = r7.f16403a
            r8.l(r1)
            return
        L67:
            com.google.protobuf.g r9 = r7.f16403a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C1469h.N(java.util.Map, com.google.protobuf.C$a, com.google.protobuf.m):void");
    }

    public final void P(Object obj, Y y7, C1474m c1474m) {
        int i8 = this.f16405c;
        this.f16405c = l0.c(l0.a(this.f16404b), 4);
        try {
            y7.i(obj, this, c1474m);
            if (this.f16404b == this.f16405c) {
            } else {
                throw C1482v.h();
            }
        } finally {
            this.f16405c = i8;
        }
    }

    public final void Q(Object obj, Y y7, C1474m c1474m) throws C1482v {
        int iD = this.f16403a.D();
        AbstractC1468g abstractC1468g = this.f16403a;
        if (abstractC1468g.f16375a >= abstractC1468g.f16376b) {
            throw C1482v.i();
        }
        int iM = abstractC1468g.m(iD);
        this.f16403a.f16375a++;
        y7.i(obj, this, c1474m);
        this.f16403a.a(0);
        r5.f16375a--;
        this.f16403a.l(iM);
    }

    public final Object R(l0.b bVar, Class cls, C1474m c1474m) {
        switch (a.f16407a[bVar.ordinal()]) {
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
                return U(cls, c1474m);
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

    public final Object S(Y y7, C1474m c1474m) {
        Object objF = y7.f();
        P(objF, y7, c1474m);
        y7.b(objF);
        return objF;
    }

    public final Object T(Y y7, C1474m c1474m) throws C1482v {
        Object objF = y7.f();
        Q(objF, y7, c1474m);
        y7.b(objF);
        return objF;
    }

    public Object U(Class cls, C1474m c1474m) throws C1482v.a {
        X(2);
        return T(U.a().c(cls), c1474m);
    }

    public void V(List list, boolean z7) throws C1482v.a {
        int iC;
        int iC2;
        if (l0.b(this.f16404b) != 2) {
            throw C1482v.e();
        }
        if (!(list instanceof InterfaceC1486z) || z7) {
            do {
                list.add(z7 ? H() : v());
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        InterfaceC1486z interfaceC1486z = (InterfaceC1486z) list;
        do {
            interfaceC1486z.q(z());
            if (this.f16403a.f()) {
                return;
            } else {
                iC2 = this.f16403a.C();
            }
        } while (iC2 == this.f16404b);
        this.f16406d = iC2;
    }

    public final void W(int i8) throws C1482v {
        if (this.f16403a.e() != i8) {
            throw C1482v.m();
        }
    }

    public final void X(int i8) throws C1482v.a {
        if (l0.b(this.f16404b) != i8) {
            throw C1482v.e();
        }
    }

    public final void Y(int i8) throws C1482v {
        if ((i8 & 3) != 0) {
            throw C1482v.h();
        }
    }

    public final void Z(int i8) throws C1482v {
        if ((i8 & 7) != 0) {
            throw C1482v.h();
        }
    }

    @Override // com.google.protobuf.X
    public int a() {
        return this.f16404b;
    }

    @Override // com.google.protobuf.X
    public void b(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f16403a.y()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Integer.valueOf(this.f16403a.y()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public long c() throws C1482v.a {
        X(0);
        return this.f16403a.E();
    }

    @Override // com.google.protobuf.X
    public long d() throws C1482v.a {
        X(1);
        return this.f16403a.s();
    }

    @Override // com.google.protobuf.X
    public void e(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 2) {
            int iD = this.f16403a.D();
            Y(iD);
            int iE = this.f16403a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f16403a.w()));
            } while (this.f16403a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1482v.e();
        }
        do {
            list.add(Integer.valueOf(this.f16403a.w()));
            if (this.f16403a.f()) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == this.f16404b);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public void f(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f16403a.z()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Long.valueOf(this.f16403a.z()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public void g(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f16403a.D()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Integer.valueOf(this.f16403a.D()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public int h() throws C1482v.a {
        X(5);
        return this.f16403a.r();
    }

    @Override // com.google.protobuf.X
    public boolean i() throws C1482v.a {
        X(0);
        return this.f16403a.n();
    }

    @Override // com.google.protobuf.X
    public long j() throws C1482v.a {
        X(1);
        return this.f16403a.x();
    }

    @Override // com.google.protobuf.X
    public void k(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f16403a.E()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Long.valueOf(this.f16403a.E()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public int l() throws C1482v.a {
        X(0);
        return this.f16403a.D();
    }

    @Override // com.google.protobuf.X
    public void m(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f16403a.v()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Long.valueOf(this.f16403a.v()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public void n(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f16403a.x()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iD = this.f16403a.D();
        Z(iD);
        int iE = this.f16403a.e() + iD;
        do {
            list.add(Long.valueOf(this.f16403a.x()));
        } while (this.f16403a.e() < iE);
    }

    @Override // com.google.protobuf.X
    public void o(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f16403a.u()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Integer.valueOf(this.f16403a.u()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public void p(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f16403a.q()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Integer.valueOf(this.f16403a.q()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public int q() throws C1482v.a {
        X(0);
        return this.f16403a.q();
    }

    @Override // com.google.protobuf.X
    public void r(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 2) {
            int iD = this.f16403a.D();
            Y(iD);
            int iE = this.f16403a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f16403a.r()));
            } while (this.f16403a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C1482v.e();
        }
        do {
            list.add(Integer.valueOf(this.f16403a.r()));
            if (this.f16403a.f()) {
                return;
            } else {
                iC = this.f16403a.C();
            }
        } while (iC == this.f16404b);
        this.f16406d = iC;
    }

    @Override // com.google.protobuf.X
    public double readDouble() throws C1482v.a {
        X(1);
        return this.f16403a.p();
    }

    @Override // com.google.protobuf.X
    public float readFloat() throws C1482v.a {
        X(5);
        return this.f16403a.t();
    }

    @Override // com.google.protobuf.X
    public int s() throws C1482v.a {
        X(0);
        return this.f16403a.y();
    }

    @Override // com.google.protobuf.X
    public long t() throws C1482v.a {
        X(0);
        return this.f16403a.z();
    }

    @Override // com.google.protobuf.X
    public void u(List list) throws C1482v {
        int iC;
        int iB = l0.b(this.f16404b);
        if (iB == 0) {
            do {
                list.add(Boolean.valueOf(this.f16403a.n()));
                if (this.f16403a.f()) {
                    return;
                } else {
                    iC = this.f16403a.C();
                }
            } while (iC == this.f16404b);
            this.f16406d = iC;
            return;
        }
        if (iB != 2) {
            throw C1482v.e();
        }
        int iE = this.f16403a.e() + this.f16403a.D();
        do {
            list.add(Boolean.valueOf(this.f16403a.n()));
        } while (this.f16403a.e() < iE);
        W(iE);
    }

    @Override // com.google.protobuf.X
    public String v() throws C1482v.a {
        X(2);
        return this.f16403a.A();
    }

    @Override // com.google.protobuf.X
    public int w() {
        int i8 = this.f16406d;
        if (i8 != 0) {
            this.f16404b = i8;
            this.f16406d = 0;
        } else {
            this.f16404b = this.f16403a.C();
        }
        int i9 = this.f16404b;
        if (i9 == 0 || i9 == this.f16405c) {
            return Integer.MAX_VALUE;
        }
        return l0.a(i9);
    }

    @Override // com.google.protobuf.X
    public void x(List list) throws C1482v.a {
        V(list, false);
    }

    @Override // com.google.protobuf.X
    public void y(List list) throws C1482v.a {
        V(list, true);
    }

    @Override // com.google.protobuf.X
    public AbstractC1467f z() throws C1482v.a {
        X(2);
        return this.f16403a.o();
    }
}
