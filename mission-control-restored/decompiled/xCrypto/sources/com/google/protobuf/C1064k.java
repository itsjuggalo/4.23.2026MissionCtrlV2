package com.google.protobuf;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.protobuf.C0;
import com.google.protobuf.D;
import java.util.List;
import p2.C1698D;

/* JADX INFO: renamed from: com.google.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1064k implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1063j f11092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11095d = 0;

    /* JADX INFO: renamed from: com.google.protobuf.k$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11096a;

        static {
            int[] iArr = new int[C0.b.values().length];
            f11096a = iArr;
            try {
                iArr[C0.b.f10898j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11096a[C0.b.f10902n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11096a[C0.b.f10891c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11096a[C0.b.f10904p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11096a[C0.b.f10897i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11096a[C0.b.f10896h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11096a[C0.b.f10892d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11096a[C0.b.f10895g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11096a[C0.b.f10893e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11096a[C0.b.f10901m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11096a[C0.b.f10905q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11096a[C0.b.f10906r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11096a[C0.b.f10907s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11096a[C0.b.f10908t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11096a[C0.b.f10899k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11096a[C0.b.f10903o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11096a[C0.b.f10894f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C1064k(AbstractC1063j abstractC1063j) {
        AbstractC1063j abstractC1063j2 = (AbstractC1063j) C.b(abstractC1063j, "input");
        this.f11092a = abstractC1063j2;
        abstractC1063j2.f11045d = this;
    }

    public static C1064k Q(AbstractC1063j abstractC1063j) {
        C1064k c1064k = abstractC1063j.f11045d;
        return c1064k != null ? c1064k : new C1064k(abstractC1063j);
    }

    @Override // com.google.protobuf.m0
    public void A(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof C1075w)) {
            int iB = C0.b(this.f11093b);
            if (iB == 2) {
                int iH = this.f11092a.H();
                Z(iH);
                int iE = this.f11092a.e() + iH;
                do {
                    list.add(Float.valueOf(this.f11092a.w()));
                } while (this.f11092a.e() < iE);
                return;
            }
            if (iB != 5) {
                throw D.e();
            }
            do {
                list.add(Float.valueOf(this.f11092a.w()));
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG = this.f11092a.G();
                }
            } while (iG == this.f11093b);
            this.f11095d = iG;
            return;
        }
        C1075w c1075w = (C1075w) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 2) {
            int iH2 = this.f11092a.H();
            Z(iH2);
            int iE2 = this.f11092a.e() + iH2;
            do {
                c1075w.k(this.f11092a.w());
            } while (this.f11092a.e() < iE2);
            return;
        }
        if (iB2 != 5) {
            throw D.e();
        }
        do {
            c1075w.k(this.f11092a.w());
            if (this.f11092a.f()) {
                return;
            } else {
                iG2 = this.f11092a.G();
            }
        } while (iG2 == this.f11093b);
        this.f11095d = iG2;
    }

    @Override // com.google.protobuf.m0
    public int B() throws D.a {
        Y(0);
        return this.f11092a.x();
    }

    @Override // com.google.protobuf.m0
    public boolean C() {
        int i4;
        if (this.f11092a.f() || (i4 = this.f11093b) == this.f11094c) {
            return false;
        }
        return this.f11092a.L(i4);
    }

    @Override // com.google.protobuf.m0
    public int D() throws D.a {
        Y(5);
        return this.f11092a.A();
    }

    @Override // com.google.protobuf.m0
    public void E(List list) throws D.a {
        int iG;
        if (C0.b(this.f11093b) != 2) {
            throw D.e();
        }
        do {
            list.add(z());
            if (this.f11092a.f()) {
                return;
            } else {
                iG = this.f11092a.G();
            }
        } while (iG == this.f11093b);
        this.f11095d = iG;
    }

    @Override // com.google.protobuf.m0
    public void F(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof C1067n)) {
            int iB = C0.b(this.f11093b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.f11092a.s()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iH = this.f11092a.H();
            a0(iH);
            int iE = this.f11092a.e() + iH;
            do {
                list.add(Double.valueOf(this.f11092a.s()));
            } while (this.f11092a.e() < iE);
            return;
        }
        C1067n c1067n = (C1067n) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 1) {
            do {
                c1067n.k(this.f11092a.s());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iH2 = this.f11092a.H();
        a0(iH2);
        int iE2 = this.f11092a.e() + iH2;
        do {
            c1067n.k(this.f11092a.s());
        } while (this.f11092a.e() < iE2);
    }

    @Override // com.google.protobuf.m0
    public long G() throws D.a {
        Y(0);
        return this.f11092a.y();
    }

    @Override // com.google.protobuf.m0
    public String H() throws D.a {
        Y(2);
        return this.f11092a.F();
    }

    @Override // com.google.protobuf.m0
    public void I(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof M)) {
            int iB = C0.b(this.f11093b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f11092a.v()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iH = this.f11092a.H();
            a0(iH);
            int iE = this.f11092a.e() + iH;
            do {
                list.add(Long.valueOf(this.f11092a.v()));
            } while (this.f11092a.e() < iE);
            return;
        }
        M m4 = (M) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 1) {
            do {
                m4.l(this.f11092a.v());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iH2 = this.f11092a.H();
        a0(iH2);
        int iE2 = this.f11092a.e() + iH2;
        do {
            m4.l(this.f11092a.v());
        } while (this.f11092a.e() < iE2);
    }

    @Override // com.google.protobuf.m0
    public void J(List list, o0 o0Var, C1070q c1070q) throws D.a {
        int iG;
        if (C0.b(this.f11093b) != 3) {
            throw D.e();
        }
        int i4 = this.f11093b;
        do {
            list.add(U(o0Var, c1070q));
            if (this.f11092a.f() || this.f11095d != 0) {
                return;
            } else {
                iG = this.f11092a.G();
            }
        } while (iG == i4);
        this.f11095d = iG;
    }

    @Override // com.google.protobuf.m0
    public Object K(Class cls, C1070q c1070q) throws D.a {
        Y(2);
        return V(j0.a().c(cls), c1070q);
    }

    @Override // com.google.protobuf.m0
    public void L(Object obj, o0 o0Var, C1070q c1070q) throws D.a {
        Y(3);
        R(obj, o0Var, c1070q);
    }

    @Override // com.google.protobuf.m0
    public void M(List list, o0 o0Var, C1070q c1070q) throws D.a {
        int iG;
        if (C0.b(this.f11093b) != 2) {
            throw D.e();
        }
        int i4 = this.f11093b;
        do {
            list.add(V(o0Var, c1070q));
            if (this.f11092a.f() || this.f11095d != 0) {
                return;
            } else {
                iG = this.f11092a.G();
            }
        } while (iG == i4);
        this.f11095d = iG;
    }

    @Override // com.google.protobuf.m0
    public Object N(Class cls, C1070q c1070q) throws D.a {
        Y(3);
        return U(j0.a().c(cls), c1070q);
    }

    @Override // com.google.protobuf.m0
    public void O(Object obj, o0 o0Var, C1070q c1070q) throws D {
        Y(2);
        S(obj, o0Var, c1070q);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f11092a.o(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // com.google.protobuf.m0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P(java.util.Map r8, com.google.protobuf.O.a r9, com.google.protobuf.C1070q r10) throws com.google.protobuf.D.a {
        /*
            r7 = this;
            r0 = 2
            r7.Y(r0)
            com.google.protobuf.j r1 = r7.f11092a
            int r1 = r1.H()
            com.google.protobuf.j r2 = r7.f11092a
            int r1 = r2.p(r1)
            java.lang.Object r2 = r9.f10969b
            java.lang.Object r3 = r9.f10971d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.j r5 = r7.f11092a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.D r4 = new com.google.protobuf.D     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.C0$b r4 = r9.f10970c     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            java.lang.Object r5 = r9.f10971d     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            goto L14
        L49:
            com.google.protobuf.C0$b r4 = r9.f10968a     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.T(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.D.a -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.D r8 = new com.google.protobuf.D     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.j r8 = r7.f11092a
            r8.o(r1)
            return
        L67:
            com.google.protobuf.j r9 = r7.f11092a
            r9.o(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C1064k.P(java.util.Map, com.google.protobuf.O$a, com.google.protobuf.q):void");
    }

    public final void R(Object obj, o0 o0Var, C1070q c1070q) {
        int i4 = this.f11094c;
        this.f11094c = C0.c(C0.a(this.f11093b), 4);
        try {
            o0Var.i(obj, this, c1070q);
            if (this.f11093b == this.f11094c) {
            } else {
                throw D.h();
            }
        } finally {
            this.f11094c = i4;
        }
    }

    public final void S(Object obj, o0 o0Var, C1070q c1070q) throws D {
        int iH = this.f11092a.H();
        AbstractC1063j abstractC1063j = this.f11092a;
        if (abstractC1063j.f11042a >= abstractC1063j.f11043b) {
            throw D.i();
        }
        int iP = abstractC1063j.p(iH);
        this.f11092a.f11042a++;
        o0Var.i(obj, this, c1070q);
        this.f11092a.a(0);
        r5.f11042a--;
        this.f11092a.o(iP);
    }

    public final Object T(C0.b bVar, Class cls, C1070q c1070q) {
        switch (a.f11096a[bVar.ordinal()]) {
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
            case 9:
                return Long.valueOf(G());
            case 10:
                return K(cls, c1070q);
            case 11:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(i());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return H();
            case 16:
                return Integer.valueOf(k());
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return Long.valueOf(b());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    public final Object U(o0 o0Var, C1070q c1070q) {
        Object objF = o0Var.f();
        R(objF, o0Var, c1070q);
        o0Var.b(objF);
        return objF;
    }

    public final Object V(o0 o0Var, C1070q c1070q) throws D {
        Object objF = o0Var.f();
        S(objF, o0Var, c1070q);
        o0Var.b(objF);
        return objF;
    }

    public void W(List list, boolean z4) throws D.a {
        int iG;
        int iG2;
        if (C0.b(this.f11093b) != 2) {
            throw D.e();
        }
        if (!(list instanceof K) || z4) {
            do {
                list.add(z4 ? H() : v());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG = this.f11092a.G();
                }
            } while (iG == this.f11093b);
            this.f11095d = iG;
            return;
        }
        K k4 = (K) list;
        do {
            k4.b(z());
            if (this.f11092a.f()) {
                return;
            } else {
                iG2 = this.f11092a.G();
            }
        } while (iG2 == this.f11093b);
        this.f11095d = iG2;
    }

    public final void X(int i4) throws D {
        if (this.f11092a.e() != i4) {
            throw D.m();
        }
    }

    public final void Y(int i4) throws D.a {
        if (C0.b(this.f11093b) != i4) {
            throw D.e();
        }
    }

    public final void Z(int i4) throws D {
        if ((i4 & 3) != 0) {
            throw D.h();
        }
    }

    @Override // com.google.protobuf.m0
    public void a(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f11092a.C()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Integer.valueOf(this.f11092a.C()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                b4.k(this.f11092a.C());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            b4.k(this.f11092a.C());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    public final void a0(int i4) throws D {
        if ((i4 & 7) != 0) {
            throw D.h();
        }
    }

    @Override // com.google.protobuf.m0
    public long b() throws D.a {
        Y(0);
        return this.f11092a.I();
    }

    @Override // com.google.protobuf.m0
    public long c() throws D.a {
        Y(1);
        return this.f11092a.v();
    }

    @Override // com.google.protobuf.m0
    public void d(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 2) {
                int iH = this.f11092a.H();
                Z(iH);
                int iE = this.f11092a.e() + iH;
                do {
                    list.add(Integer.valueOf(this.f11092a.A()));
                } while (this.f11092a.e() < iE);
                return;
            }
            if (iB != 5) {
                throw D.e();
            }
            do {
                list.add(Integer.valueOf(this.f11092a.A()));
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG = this.f11092a.G();
                }
            } while (iG == this.f11093b);
            this.f11095d = iG;
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 2) {
            int iH2 = this.f11092a.H();
            Z(iH2);
            int iE2 = this.f11092a.e() + iH2;
            do {
                b4.k(this.f11092a.A());
            } while (this.f11092a.e() < iE2);
            return;
        }
        if (iB2 != 5) {
            throw D.e();
        }
        do {
            b4.k(this.f11092a.A());
            if (this.f11092a.f()) {
                return;
            } else {
                iG2 = this.f11092a.G();
            }
        } while (iG2 == this.f11093b);
        this.f11095d = iG2;
    }

    @Override // com.google.protobuf.m0
    public void e(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof M)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f11092a.D()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Long.valueOf(this.f11092a.D()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        M m4 = (M) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                m4.l(this.f11092a.D());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            m4.l(this.f11092a.D());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public void f(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f11092a.H()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Integer.valueOf(this.f11092a.H()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                b4.k(this.f11092a.H());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            b4.k(this.f11092a.H());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public int g() throws D.a {
        Y(5);
        return this.f11092a.u();
    }

    @Override // com.google.protobuf.m0
    public boolean h() throws D.a {
        Y(0);
        return this.f11092a.q();
    }

    @Override // com.google.protobuf.m0
    public long i() throws D.a {
        Y(1);
        return this.f11092a.B();
    }

    @Override // com.google.protobuf.m0
    public void j(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof M)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f11092a.I()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Long.valueOf(this.f11092a.I()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        M m4 = (M) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                m4.l(this.f11092a.I());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            m4.l(this.f11092a.I());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public int k() throws D.a {
        Y(0);
        return this.f11092a.H();
    }

    @Override // com.google.protobuf.m0
    public void l(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof M)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f11092a.y()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Long.valueOf(this.f11092a.y()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        M m4 = (M) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                m4.l(this.f11092a.y());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            m4.l(this.f11092a.y());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public void m(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof M)) {
            int iB = C0.b(this.f11093b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f11092a.B()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iH = this.f11092a.H();
            a0(iH);
            int iE = this.f11092a.e() + iH;
            do {
                list.add(Long.valueOf(this.f11092a.B()));
            } while (this.f11092a.e() < iE);
            return;
        }
        M m4 = (M) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 1) {
            do {
                m4.l(this.f11092a.B());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iH2 = this.f11092a.H();
        a0(iH2);
        int iE2 = this.f11092a.e() + iH2;
        do {
            m4.l(this.f11092a.B());
        } while (this.f11092a.e() < iE2);
    }

    @Override // com.google.protobuf.m0
    public void n(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f11092a.x()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Integer.valueOf(this.f11092a.x()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                b4.k(this.f11092a.x());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            b4.k(this.f11092a.x());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public void o(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f11092a.t()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Integer.valueOf(this.f11092a.t()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                b4.k(this.f11092a.t());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            b4.k(this.f11092a.t());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public int p() throws D.a {
        Y(0);
        return this.f11092a.t();
    }

    @Override // com.google.protobuf.m0
    public int q() {
        return this.f11093b;
    }

    @Override // com.google.protobuf.m0
    public void r(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof B)) {
            int iB = C0.b(this.f11093b);
            if (iB == 2) {
                int iH = this.f11092a.H();
                Z(iH);
                int iE = this.f11092a.e() + iH;
                do {
                    list.add(Integer.valueOf(this.f11092a.u()));
                } while (this.f11092a.e() < iE);
                return;
            }
            if (iB != 5) {
                throw D.e();
            }
            do {
                list.add(Integer.valueOf(this.f11092a.u()));
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG = this.f11092a.G();
                }
            } while (iG == this.f11093b);
            this.f11095d = iG;
            return;
        }
        B b4 = (B) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 2) {
            int iH2 = this.f11092a.H();
            Z(iH2);
            int iE2 = this.f11092a.e() + iH2;
            do {
                b4.k(this.f11092a.u());
            } while (this.f11092a.e() < iE2);
            return;
        }
        if (iB2 != 5) {
            throw D.e();
        }
        do {
            b4.k(this.f11092a.u());
            if (this.f11092a.f()) {
                return;
            } else {
                iG2 = this.f11092a.G();
            }
        } while (iG2 == this.f11093b);
        this.f11095d = iG2;
    }

    @Override // com.google.protobuf.m0
    public double readDouble() throws D.a {
        Y(1);
        return this.f11092a.s();
    }

    @Override // com.google.protobuf.m0
    public float readFloat() throws D.a {
        Y(5);
        return this.f11092a.w();
    }

    @Override // com.google.protobuf.m0
    public int s() throws D.a {
        Y(0);
        return this.f11092a.C();
    }

    @Override // com.google.protobuf.m0
    public long t() throws D.a {
        Y(0);
        return this.f11092a.D();
    }

    @Override // com.google.protobuf.m0
    public void u(List list) throws D {
        int iG;
        int iG2;
        if (!(list instanceof C1060g)) {
            int iB = C0.b(this.f11093b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.f11092a.q()));
                    if (this.f11092a.f()) {
                        return;
                    } else {
                        iG = this.f11092a.G();
                    }
                } while (iG == this.f11093b);
                this.f11095d = iG;
                return;
            }
            if (iB != 2) {
                throw D.e();
            }
            int iE = this.f11092a.e() + this.f11092a.H();
            do {
                list.add(Boolean.valueOf(this.f11092a.q()));
            } while (this.f11092a.e() < iE);
            X(iE);
            return;
        }
        C1060g c1060g = (C1060g) list;
        int iB2 = C0.b(this.f11093b);
        if (iB2 == 0) {
            do {
                c1060g.l(this.f11092a.q());
                if (this.f11092a.f()) {
                    return;
                } else {
                    iG2 = this.f11092a.G();
                }
            } while (iG2 == this.f11093b);
            this.f11095d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw D.e();
        }
        int iE2 = this.f11092a.e() + this.f11092a.H();
        do {
            c1060g.l(this.f11092a.q());
        } while (this.f11092a.e() < iE2);
        X(iE2);
    }

    @Override // com.google.protobuf.m0
    public String v() throws D.a {
        Y(2);
        return this.f11092a.E();
    }

    @Override // com.google.protobuf.m0
    public int w() {
        int i4 = this.f11095d;
        if (i4 != 0) {
            this.f11093b = i4;
            this.f11095d = 0;
        } else {
            this.f11093b = this.f11092a.G();
        }
        int i5 = this.f11093b;
        if (i5 == 0 || i5 == this.f11094c) {
            return Integer.MAX_VALUE;
        }
        return C0.a(i5);
    }

    @Override // com.google.protobuf.m0
    public void x(List list) throws D.a {
        W(list, false);
    }

    @Override // com.google.protobuf.m0
    public void y(List list) throws D.a {
        W(list, true);
    }

    @Override // com.google.protobuf.m0
    public AbstractC1062i z() throws D.a {
        Y(2);
        return this.f11092a.r();
    }
}
