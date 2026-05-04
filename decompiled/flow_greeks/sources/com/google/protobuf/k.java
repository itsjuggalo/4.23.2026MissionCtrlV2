package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.a2;
import com.google.protobuf.d0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7071d = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7072a;

        static {
            int[] iArr = new int[a2.b.values().length];
            f7072a = iArr;
            try {
                iArr[a2.b.f6908j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7072a[a2.b.f6912n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7072a[a2.b.f6901c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7072a[a2.b.f6914p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7072a[a2.b.f6907i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7072a[a2.b.f6906h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7072a[a2.b.f6902d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7072a[a2.b.f6905g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7072a[a2.b.f6903e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7072a[a2.b.f6911m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7072a[a2.b.f6915q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7072a[a2.b.f6916r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7072a[a2.b.f6917s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7072a[a2.b.f6918t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7072a[a2.b.f6909k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7072a[a2.b.f6913o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7072a[a2.b.f6904f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public k(j jVar) {
        j jVar2 = (j) c0.b(jVar, "input");
        this.f7068a = jVar2;
        jVar2.f7020d = this;
    }

    public static k O(j jVar) {
        k kVar = jVar.f7020d;
        return kVar != null ? kVar : new k(jVar);
    }

    @Override // com.google.protobuf.k1
    public void A(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof w)) {
            int iB = a2.b(this.f7069b);
            if (iB == 2) {
                int iF = this.f7068a.F();
                Y(iF);
                int iE3 = this.f7068a.e() + iF;
                do {
                    list.add(Float.valueOf(this.f7068a.v()));
                } while (this.f7068a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw d0.e();
            }
            do {
                list.add(Float.valueOf(this.f7068a.v()));
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE = this.f7068a.E();
                }
            } while (iE == this.f7069b);
            this.f7071d = iE;
            return;
        }
        w wVar = (w) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 2) {
            int iF2 = this.f7068a.F();
            Y(iF2);
            int iE4 = this.f7068a.e() + iF2;
            do {
                wVar.c(this.f7068a.v());
            } while (this.f7068a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw d0.e();
        }
        do {
            wVar.c(this.f7068a.v());
            if (this.f7068a.f()) {
                return;
            } else {
                iE2 = this.f7068a.E();
            }
        } while (iE2 == this.f7069b);
        this.f7071d = iE2;
    }

    @Override // com.google.protobuf.k1
    public int B() throws d0.a {
        X(0);
        return this.f7068a.w();
    }

    @Override // com.google.protobuf.k1
    public boolean C() {
        int i10;
        if (this.f7068a.f() || (i10 = this.f7069b) == this.f7070c) {
            return false;
        }
        return this.f7068a.J(i10);
    }

    @Override // com.google.protobuf.k1
    public int D() throws d0.a {
        X(5);
        return this.f7068a.y();
    }

    @Override // com.google.protobuf.k1
    public void E(List list) throws d0.a {
        int iE;
        if (a2.b(this.f7069b) != 2) {
            throw d0.e();
        }
        do {
            list.add(z());
            if (this.f7068a.f()) {
                return;
            } else {
                iE = this.f7068a.E();
            }
        } while (iE == this.f7069b);
        this.f7071d = iE;
    }

    @Override // com.google.protobuf.k1
    public void F(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof n)) {
            int iB = a2.b(this.f7069b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.f7068a.r()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iF = this.f7068a.F();
            Z(iF);
            int iE3 = this.f7068a.e() + iF;
            do {
                list.add(Double.valueOf(this.f7068a.r()));
            } while (this.f7068a.e() < iE3);
            return;
        }
        n nVar = (n) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 1) {
            do {
                nVar.c(this.f7068a.r());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iF2 = this.f7068a.F();
        Z(iF2);
        int iE4 = this.f7068a.e() + iF2;
        do {
            nVar.c(this.f7068a.r());
        } while (this.f7068a.e() < iE4);
    }

    @Override // com.google.protobuf.k1
    public long G() throws d0.a {
        X(0);
        return this.f7068a.x();
    }

    @Override // com.google.protobuf.k1
    public String H() throws d0.a {
        X(2);
        return this.f7068a.D();
    }

    @Override // com.google.protobuf.k1
    public void I(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof l0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f7068a.u()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iF = this.f7068a.F();
            Z(iF);
            int iE3 = this.f7068a.e() + iF;
            do {
                list.add(Long.valueOf(this.f7068a.u()));
            } while (this.f7068a.e() < iE3);
            return;
        }
        l0 l0Var = (l0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 1) {
            do {
                l0Var.c(this.f7068a.u());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iF2 = this.f7068a.F();
        Z(iF2);
        int iE4 = this.f7068a.e() + iF2;
        do {
            l0Var.c(this.f7068a.u());
        } while (this.f7068a.e() < iE4);
    }

    @Override // com.google.protobuf.k1
    public void J(List list, m1 m1Var, q qVar) throws d0.a {
        int iE;
        if (a2.b(this.f7069b) != 3) {
            throw d0.e();
        }
        int i10 = this.f7069b;
        do {
            list.add(S(m1Var, qVar));
            if (this.f7068a.f() || this.f7071d != 0) {
                return;
            } else {
                iE = this.f7068a.E();
            }
        } while (iE == i10);
        this.f7071d = iE;
    }

    @Override // com.google.protobuf.k1
    public void K(Object obj, m1 m1Var, q qVar) throws d0.a {
        X(3);
        P(obj, m1Var, qVar);
    }

    @Override // com.google.protobuf.k1
    public void L(List list, m1 m1Var, q qVar) throws d0.a {
        int iE;
        if (a2.b(this.f7069b) != 2) {
            throw d0.e();
        }
        int i10 = this.f7069b;
        do {
            list.add(T(m1Var, qVar));
            if (this.f7068a.f() || this.f7071d != 0) {
                return;
            } else {
                iE = this.f7068a.E();
            }
        } while (iE == i10);
        this.f7071d = iE;
    }

    @Override // com.google.protobuf.k1
    public void M(Object obj, m1 m1Var, q qVar) throws d0 {
        X(2);
        Q(obj, m1Var, qVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f7068a.n(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // com.google.protobuf.k1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N(java.util.Map r8, com.google.protobuf.n0.a r9, com.google.protobuf.q r10) throws com.google.protobuf.d0.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            com.google.protobuf.j r1 = r7.f7068a
            int r1 = r1.F()
            com.google.protobuf.j r2 = r7.f7068a
            int r1 = r2.o(r1)
            java.lang.Object r2 = r9.f7111b
            java.lang.Object r3 = r9.f7113d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.j r5 = r7.f7068a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.d0 r4 = new com.google.protobuf.d0     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.a2$b r4 = r9.f7112c     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            java.lang.Object r5 = r9.f7113d     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            goto L14
        L49:
            com.google.protobuf.a2$b r4 = r9.f7110a     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.d0.a -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.d0 r8 = new com.google.protobuf.d0     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.j r8 = r7.f7068a
            r8.n(r1)
            return
        L67:
            com.google.protobuf.j r9 = r7.f7068a
            r9.n(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.k.N(java.util.Map, com.google.protobuf.n0$a, com.google.protobuf.q):void");
    }

    public final void P(Object obj, m1 m1Var, q qVar) {
        int i10 = this.f7070c;
        this.f7070c = a2.c(a2.a(this.f7069b), 4);
        try {
            m1Var.i(obj, this, qVar);
            if (this.f7069b == this.f7070c) {
            } else {
                throw d0.h();
            }
        } finally {
            this.f7070c = i10;
        }
    }

    public final void Q(Object obj, m1 m1Var, q qVar) throws d0 {
        int iF = this.f7068a.F();
        j jVar = this.f7068a;
        if (jVar.f7017a >= jVar.f7018b) {
            throw d0.i();
        }
        int iO = jVar.o(iF);
        this.f7068a.f7017a++;
        m1Var.i(obj, this, qVar);
        this.f7068a.a(0);
        r5.f7017a--;
        this.f7068a.n(iO);
    }

    public final Object R(a2.b bVar, Class cls, q qVar) {
        switch (a.f7072a[bVar.ordinal()]) {
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
                return U(cls, qVar);
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

    public final Object S(m1 m1Var, q qVar) {
        Object objF = m1Var.f();
        P(objF, m1Var, qVar);
        m1Var.b(objF);
        return objF;
    }

    public final Object T(m1 m1Var, q qVar) throws d0 {
        Object objF = m1Var.f();
        Q(objF, m1Var, qVar);
        m1Var.b(objF);
        return objF;
    }

    public Object U(Class cls, q qVar) throws d0.a {
        X(2);
        return T(h1.a().c(cls), qVar);
    }

    public void V(List list, boolean z10) throws d0.a {
        int iE;
        int iE2;
        if (a2.b(this.f7069b) != 2) {
            throw d0.e();
        }
        if (!(list instanceof j0) || z10) {
            do {
                list.add(z10 ? H() : v());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE = this.f7068a.E();
                }
            } while (iE == this.f7069b);
            this.f7071d = iE;
            return;
        }
        j0 j0Var = (j0) list;
        do {
            j0Var.o(z());
            if (this.f7068a.f()) {
                return;
            } else {
                iE2 = this.f7068a.E();
            }
        } while (iE2 == this.f7069b);
        this.f7071d = iE2;
    }

    public final void W(int i10) throws d0 {
        if (this.f7068a.e() != i10) {
            throw d0.m();
        }
    }

    public final void X(int i10) throws d0.a {
        if (a2.b(this.f7069b) != i10) {
            throw d0.e();
        }
    }

    public final void Y(int i10) throws d0 {
        if ((i10 & 3) != 0) {
            throw d0.h();
        }
    }

    public final void Z(int i10) throws d0 {
        if ((i10 & 7) != 0) {
            throw d0.h();
        }
    }

    @Override // com.google.protobuf.k1
    public int a() {
        return this.f7069b;
    }

    @Override // com.google.protobuf.k1
    public void b(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068a.A()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Integer.valueOf(this.f7068a.A()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                b0Var.e(this.f7068a.A());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            b0Var.e(this.f7068a.A());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public long c() throws d0.a {
        X(0);
        return this.f7068a.G();
    }

    @Override // com.google.protobuf.k1
    public long d() throws d0.a {
        X(1);
        return this.f7068a.u();
    }

    @Override // com.google.protobuf.k1
    public void e(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 2) {
                int iF = this.f7068a.F();
                Y(iF);
                int iE3 = this.f7068a.e() + iF;
                do {
                    list.add(Integer.valueOf(this.f7068a.y()));
                } while (this.f7068a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw d0.e();
            }
            do {
                list.add(Integer.valueOf(this.f7068a.y()));
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE = this.f7068a.E();
                }
            } while (iE == this.f7069b);
            this.f7071d = iE;
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 2) {
            int iF2 = this.f7068a.F();
            Y(iF2);
            int iE4 = this.f7068a.e() + iF2;
            do {
                b0Var.e(this.f7068a.y());
            } while (this.f7068a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw d0.e();
        }
        do {
            b0Var.e(this.f7068a.y());
            if (this.f7068a.f()) {
                return;
            } else {
                iE2 = this.f7068a.E();
            }
        } while (iE2 == this.f7069b);
        this.f7071d = iE2;
    }

    @Override // com.google.protobuf.k1
    public void f(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof l0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f7068a.B()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Long.valueOf(this.f7068a.B()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        l0 l0Var = (l0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                l0Var.c(this.f7068a.B());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            l0Var.c(this.f7068a.B());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public void g(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068a.F()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Integer.valueOf(this.f7068a.F()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                b0Var.e(this.f7068a.F());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            b0Var.e(this.f7068a.F());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public int h() throws d0.a {
        X(5);
        return this.f7068a.t();
    }

    @Override // com.google.protobuf.k1
    public boolean i() throws d0.a {
        X(0);
        return this.f7068a.p();
    }

    @Override // com.google.protobuf.k1
    public long j() throws d0.a {
        X(1);
        return this.f7068a.z();
    }

    @Override // com.google.protobuf.k1
    public void k(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof l0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f7068a.G()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Long.valueOf(this.f7068a.G()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        l0 l0Var = (l0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                l0Var.c(this.f7068a.G());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            l0Var.c(this.f7068a.G());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public int l() throws d0.a {
        X(0);
        return this.f7068a.F();
    }

    @Override // com.google.protobuf.k1
    public void m(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof l0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f7068a.x()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Long.valueOf(this.f7068a.x()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        l0 l0Var = (l0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                l0Var.c(this.f7068a.x());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            l0Var.c(this.f7068a.x());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public void n(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof l0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f7068a.z()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iF = this.f7068a.F();
            Z(iF);
            int iE3 = this.f7068a.e() + iF;
            do {
                list.add(Long.valueOf(this.f7068a.z()));
            } while (this.f7068a.e() < iE3);
            return;
        }
        l0 l0Var = (l0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 1) {
            do {
                l0Var.c(this.f7068a.z());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iF2 = this.f7068a.F();
        Z(iF2);
        int iE4 = this.f7068a.e() + iF2;
        do {
            l0Var.c(this.f7068a.z());
        } while (this.f7068a.e() < iE4);
    }

    @Override // com.google.protobuf.k1
    public void o(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068a.w()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Integer.valueOf(this.f7068a.w()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                b0Var.e(this.f7068a.w());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            b0Var.e(this.f7068a.w());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public void p(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f7068a.s()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Integer.valueOf(this.f7068a.s()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                b0Var.e(this.f7068a.s());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            b0Var.e(this.f7068a.s());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public int q() throws d0.a {
        X(0);
        return this.f7068a.s();
    }

    @Override // com.google.protobuf.k1
    public void r(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof b0)) {
            int iB = a2.b(this.f7069b);
            if (iB == 2) {
                int iF = this.f7068a.F();
                Y(iF);
                int iE3 = this.f7068a.e() + iF;
                do {
                    list.add(Integer.valueOf(this.f7068a.t()));
                } while (this.f7068a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw d0.e();
            }
            do {
                list.add(Integer.valueOf(this.f7068a.t()));
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE = this.f7068a.E();
                }
            } while (iE == this.f7069b);
            this.f7071d = iE;
            return;
        }
        b0 b0Var = (b0) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 2) {
            int iF2 = this.f7068a.F();
            Y(iF2);
            int iE4 = this.f7068a.e() + iF2;
            do {
                b0Var.e(this.f7068a.t());
            } while (this.f7068a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw d0.e();
        }
        do {
            b0Var.e(this.f7068a.t());
            if (this.f7068a.f()) {
                return;
            } else {
                iE2 = this.f7068a.E();
            }
        } while (iE2 == this.f7069b);
        this.f7071d = iE2;
    }

    @Override // com.google.protobuf.k1
    public double readDouble() throws d0.a {
        X(1);
        return this.f7068a.r();
    }

    @Override // com.google.protobuf.k1
    public float readFloat() throws d0.a {
        X(5);
        return this.f7068a.v();
    }

    @Override // com.google.protobuf.k1
    public int s() throws d0.a {
        X(0);
        return this.f7068a.A();
    }

    @Override // com.google.protobuf.k1
    public long t() throws d0.a {
        X(0);
        return this.f7068a.B();
    }

    @Override // com.google.protobuf.k1
    public void u(List list) throws d0 {
        int iE;
        int iE2;
        if (!(list instanceof g)) {
            int iB = a2.b(this.f7069b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.f7068a.p()));
                    if (this.f7068a.f()) {
                        return;
                    } else {
                        iE = this.f7068a.E();
                    }
                } while (iE == this.f7069b);
                this.f7071d = iE;
                return;
            }
            if (iB != 2) {
                throw d0.e();
            }
            int iE3 = this.f7068a.e() + this.f7068a.F();
            do {
                list.add(Boolean.valueOf(this.f7068a.p()));
            } while (this.f7068a.e() < iE3);
            W(iE3);
            return;
        }
        g gVar = (g) list;
        int iB2 = a2.b(this.f7069b);
        if (iB2 == 0) {
            do {
                gVar.c(this.f7068a.p());
                if (this.f7068a.f()) {
                    return;
                } else {
                    iE2 = this.f7068a.E();
                }
            } while (iE2 == this.f7069b);
            this.f7071d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw d0.e();
        }
        int iE4 = this.f7068a.e() + this.f7068a.F();
        do {
            gVar.c(this.f7068a.p());
        } while (this.f7068a.e() < iE4);
        W(iE4);
    }

    @Override // com.google.protobuf.k1
    public String v() throws d0.a {
        X(2);
        return this.f7068a.C();
    }

    @Override // com.google.protobuf.k1
    public int w() {
        int i10 = this.f7071d;
        if (i10 != 0) {
            this.f7069b = i10;
            this.f7071d = 0;
        } else {
            this.f7069b = this.f7068a.E();
        }
        int i11 = this.f7069b;
        return (i11 == 0 || i11 == this.f7070c) ? a.e.API_PRIORITY_OTHER : a2.a(i11);
    }

    @Override // com.google.protobuf.k1
    public void x(List list) throws d0.a {
        V(list, false);
    }

    @Override // com.google.protobuf.k1
    public void y(List list) throws d0.a {
        V(list, true);
    }

    @Override // com.google.protobuf.k1
    public i z() throws d0.a {
        X(2);
        return this.f7068a.q();
    }
}
