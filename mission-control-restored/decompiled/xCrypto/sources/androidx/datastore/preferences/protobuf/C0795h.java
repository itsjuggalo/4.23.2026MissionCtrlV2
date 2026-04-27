package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0808v;
import androidx.datastore.preferences.protobuf.k0;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.List;
import p2.C1698D;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0795h implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0794g f7034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7037d = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.h$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7038a;

        static {
            int[] iArr = new int[k0.b.values().length];
            f7038a = iArr;
            try {
                iArr[k0.b.f7086j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7038a[k0.b.f7090n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7038a[k0.b.f7079c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7038a[k0.b.f7092p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7038a[k0.b.f7085i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7038a[k0.b.f7084h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7038a[k0.b.f7080d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7038a[k0.b.f7083g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7038a[k0.b.f7081e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7038a[k0.b.f7089m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7038a[k0.b.f7093q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7038a[k0.b.f7094r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7038a[k0.b.f7095s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7038a[k0.b.f7096t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7038a[k0.b.f7087k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7038a[k0.b.f7091o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7038a[k0.b.f7082f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C0795h(AbstractC0794g abstractC0794g) {
        AbstractC0794g abstractC0794g2 = (AbstractC0794g) AbstractC0807u.b(abstractC0794g, "input");
        this.f7034a = abstractC0794g2;
        abstractC0794g2.f7009d = this;
    }

    public static C0795h O(AbstractC0794g abstractC0794g) {
        C0795h c0795h = abstractC0794g.f7009d;
        return c0795h != null ? c0795h : new C0795h(abstractC0794g);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void A(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 2) {
            int iD = this.f7034a.D();
            Y(iD);
            int iE = this.f7034a.e() + iD;
            do {
                list.add(Float.valueOf(this.f7034a.t()));
            } while (this.f7034a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0808v.e();
        }
        do {
            list.add(Float.valueOf(this.f7034a.t()));
            if (this.f7034a.f()) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == this.f7035b);
        this.f7037d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int B() throws C0808v.a {
        X(0);
        return this.f7034a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean C() {
        int i4;
        if (this.f7034a.f() || (i4 = this.f7035b) == this.f7036c) {
            return false;
        }
        return this.f7034a.F(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int D() throws C0808v.a {
        X(5);
        return this.f7034a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void E(List list) throws C0808v.a {
        int iC;
        if (k0.b(this.f7035b) != 2) {
            throw C0808v.e();
        }
        do {
            list.add(z());
            if (this.f7034a.f()) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == this.f7035b);
        this.f7037d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void F(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 1) {
            do {
                list.add(Double.valueOf(this.f7034a.p()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iD = this.f7034a.D();
        Z(iD);
        int iE = this.f7034a.e() + iD;
        do {
            list.add(Double.valueOf(this.f7034a.p()));
        } while (this.f7034a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long G() throws C0808v.a {
        X(0);
        return this.f7034a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String H() throws C0808v.a {
        X(2);
        return this.f7034a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void I(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f7034a.s()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iD = this.f7034a.D();
        Z(iD);
        int iE = this.f7034a.e() + iD;
        do {
            list.add(Long.valueOf(this.f7034a.s()));
        } while (this.f7034a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void J(Object obj, Y y4, C0800m c0800m) throws C0808v {
        X(2);
        Q(obj, y4, c0800m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f7034a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(java.util.Map r8, androidx.datastore.preferences.protobuf.C.a r9, androidx.datastore.preferences.protobuf.C0800m r10) throws androidx.datastore.preferences.protobuf.C0808v.a {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.f7034a
            int r1 = r1.D()
            androidx.datastore.preferences.protobuf.g r2 = r7.f7034a
            int r1 = r2.m(r1)
            java.lang.Object r2 = r9.f6918b
            java.lang.Object r3 = r9.f6920d
        L14:
            int r4 = r7.w()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.g r5 = r7.f7034a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.v r4 = new androidx.datastore.preferences.protobuf.v     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f6919c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            java.lang.Object r5 = r9.f6920d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            java.lang.Object r3 = r7.R(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.k0$b r4 = r9.f6917a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.R(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.C0808v.a -> L51
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
            androidx.datastore.preferences.protobuf.g r8 = r7.f7034a
            r8.l(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.g r9 = r7.f7034a
            r9.l(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0795h.K(java.util.Map, androidx.datastore.preferences.protobuf.C$a, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void L(Object obj, Y y4, C0800m c0800m) throws C0808v.a {
        X(3);
        P(obj, y4, c0800m);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void M(List list, Y y4, C0800m c0800m) throws C0808v.a {
        int iC;
        if (k0.b(this.f7035b) != 3) {
            throw C0808v.e();
        }
        int i4 = this.f7035b;
        do {
            list.add(S(y4, c0800m));
            if (this.f7034a.f() || this.f7037d != 0) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == i4);
        this.f7037d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void N(List list, Y y4, C0800m c0800m) throws C0808v.a {
        int iC;
        if (k0.b(this.f7035b) != 2) {
            throw C0808v.e();
        }
        int i4 = this.f7035b;
        do {
            list.add(T(y4, c0800m));
            if (this.f7034a.f() || this.f7037d != 0) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == i4);
        this.f7037d = iC;
    }

    public final void P(Object obj, Y y4, C0800m c0800m) {
        int i4 = this.f7036c;
        this.f7036c = k0.c(k0.a(this.f7035b), 4);
        try {
            y4.h(obj, this, c0800m);
            if (this.f7035b == this.f7036c) {
            } else {
                throw C0808v.h();
            }
        } finally {
            this.f7036c = i4;
        }
    }

    public final void Q(Object obj, Y y4, C0800m c0800m) throws C0808v {
        int iD = this.f7034a.D();
        AbstractC0794g abstractC0794g = this.f7034a;
        if (abstractC0794g.f7006a >= abstractC0794g.f7007b) {
            throw C0808v.i();
        }
        int iM = abstractC0794g.m(iD);
        this.f7034a.f7006a++;
        y4.h(obj, this, c0800m);
        this.f7034a.a(0);
        r5.f7006a--;
        this.f7034a.l(iM);
    }

    public final Object R(k0.b bVar, Class cls, C0800m c0800m) {
        switch (a.f7038a[bVar.ordinal()]) {
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
                return U(cls, c0800m);
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

    public final Object S(Y y4, C0800m c0800m) {
        Object objF = y4.f();
        P(objF, y4, c0800m);
        y4.b(objF);
        return objF;
    }

    public final Object T(Y y4, C0800m c0800m) throws C0808v {
        Object objF = y4.f();
        Q(objF, y4, c0800m);
        y4.b(objF);
        return objF;
    }

    public Object U(Class cls, C0800m c0800m) throws C0808v.a {
        X(2);
        return T(U.a().c(cls), c0800m);
    }

    public void V(List list, boolean z4) throws C0808v.a {
        int iC;
        if (k0.b(this.f7035b) != 2) {
            throw C0808v.e();
        }
        do {
            list.add(z4 ? H() : v());
            if (this.f7034a.f()) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == this.f7035b);
        this.f7037d = iC;
    }

    public final void W(int i4) throws C0808v {
        if (this.f7034a.e() != i4) {
            throw C0808v.m();
        }
    }

    public final void X(int i4) throws C0808v.a {
        if (k0.b(this.f7035b) != i4) {
            throw C0808v.e();
        }
    }

    public final void Y(int i4) throws C0808v {
        if ((i4 & 3) != 0) {
            throw C0808v.h();
        }
    }

    public final void Z(int i4) throws C0808v {
        if ((i4 & 7) != 0) {
            throw C0808v.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void a(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7034a.y()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Integer.valueOf(this.f7034a.y()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long b() throws C0808v.a {
        X(0);
        return this.f7034a.E();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long c() throws C0808v.a {
        X(1);
        return this.f7034a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void d(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 2) {
            int iD = this.f7034a.D();
            Y(iD);
            int iE = this.f7034a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f7034a.w()));
            } while (this.f7034a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0808v.e();
        }
        do {
            list.add(Integer.valueOf(this.f7034a.w()));
            if (this.f7034a.f()) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == this.f7035b);
        this.f7037d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void e(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7034a.z()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Long.valueOf(this.f7034a.z()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void f(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7034a.D()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Integer.valueOf(this.f7034a.D()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int g() throws C0808v.a {
        X(5);
        return this.f7034a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public boolean h() throws C0808v.a {
        X(0);
        return this.f7034a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long i() throws C0808v.a {
        X(1);
        return this.f7034a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void j(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7034a.E()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Long.valueOf(this.f7034a.E()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int k() throws C0808v.a {
        X(0);
        return this.f7034a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void l(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Long.valueOf(this.f7034a.v()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Long.valueOf(this.f7034a.v()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void m(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 1) {
            do {
                list.add(Long.valueOf(this.f7034a.x()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iD = this.f7034a.D();
        Z(iD);
        int iE = this.f7034a.e() + iD;
        do {
            list.add(Long.valueOf(this.f7034a.x()));
        } while (this.f7034a.e() < iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void n(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7034a.u()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Integer.valueOf(this.f7034a.u()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void o(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Integer.valueOf(this.f7034a.q()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Integer.valueOf(this.f7034a.q()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int p() throws C0808v.a {
        X(0);
        return this.f7034a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int q() {
        return this.f7035b;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void r(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 2) {
            int iD = this.f7034a.D();
            Y(iD);
            int iE = this.f7034a.e() + iD;
            do {
                list.add(Integer.valueOf(this.f7034a.r()));
            } while (this.f7034a.e() < iE);
            return;
        }
        if (iB != 5) {
            throw C0808v.e();
        }
        do {
            list.add(Integer.valueOf(this.f7034a.r()));
            if (this.f7034a.f()) {
                return;
            } else {
                iC = this.f7034a.C();
            }
        } while (iC == this.f7035b);
        this.f7037d = iC;
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public double readDouble() throws C0808v.a {
        X(1);
        return this.f7034a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public float readFloat() throws C0808v.a {
        X(5);
        return this.f7034a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int s() throws C0808v.a {
        X(0);
        return this.f7034a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public long t() throws C0808v.a {
        X(0);
        return this.f7034a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void u(List list) throws C0808v {
        int iC;
        int iB = k0.b(this.f7035b);
        if (iB == 0) {
            do {
                list.add(Boolean.valueOf(this.f7034a.n()));
                if (this.f7034a.f()) {
                    return;
                } else {
                    iC = this.f7034a.C();
                }
            } while (iC == this.f7035b);
            this.f7037d = iC;
            return;
        }
        if (iB != 2) {
            throw C0808v.e();
        }
        int iE = this.f7034a.e() + this.f7034a.D();
        do {
            list.add(Boolean.valueOf(this.f7034a.n()));
        } while (this.f7034a.e() < iE);
        W(iE);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public String v() throws C0808v.a {
        X(2);
        return this.f7034a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public int w() {
        int i4 = this.f7037d;
        if (i4 != 0) {
            this.f7035b = i4;
            this.f7037d = 0;
        } else {
            this.f7035b = this.f7034a.C();
        }
        int i5 = this.f7035b;
        if (i5 == 0 || i5 == this.f7036c) {
            return Integer.MAX_VALUE;
        }
        return k0.a(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void x(List list) throws C0808v.a {
        V(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public void y(List list) throws C0808v.a {
        V(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public AbstractC0793f z() throws C0808v.a {
        X(2);
        return this.f7034a.o();
    }
}
