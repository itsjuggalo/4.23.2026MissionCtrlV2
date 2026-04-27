package l6;

import java.io.IOException;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.AbstractC2723j;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f21128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static s6.r f21129m = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f21130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f21134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f21137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f21138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21139k;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public v b(C2718e c2718e, C2720g c2720g) {
            return new v(c2718e, c2720g);
        }
    }

    public enum c implements AbstractC2723j.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static AbstractC2723j.b f21150e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21152a;

        public static class a implements AbstractC2723j.b {
            @Override // s6.AbstractC2723j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i8) {
                return c.a(i8);
            }
        }

        c(int i8, int i9) {
            this.f21152a = i9;
        }

        public static c a(int i8) {
            if (i8 == 0) {
                return WARNING;
            }
            if (i8 == 1) {
                return ERROR;
            }
            if (i8 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // s6.AbstractC2723j.a
        public final int d() {
            return this.f21152a;
        }
    }

    public enum d implements AbstractC2723j.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static AbstractC2723j.b f21156e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21158a;

        public static class a implements AbstractC2723j.b {
            @Override // s6.AbstractC2723j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i8) {
                return d.a(i8);
            }
        }

        d(int i8, int i9) {
            this.f21158a = i9;
        }

        public static d a(int i8) {
            if (i8 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i8 == 1) {
                return COMPILER_VERSION;
            }
            if (i8 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // s6.AbstractC2723j.a
        public final int d() {
            return this.f21158a;
        }
    }

    static {
        v vVar = new v(true);
        f21128l = vVar;
        vVar.N();
    }

    public v(C2718e c2718e, C2720g c2720g) {
        int iM;
        this.f21138j = (byte) -1;
        this.f21139k = -1;
        N();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        while (!z7) {
            try {
                try {
                    int iJ = c2718e.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f21131c |= 1;
                            this.f21132d = c2718e.r();
                        } else if (iJ == 16) {
                            this.f21131c |= 2;
                            this.f21133e = c2718e.r();
                        } else if (iJ == 24) {
                            iM = c2718e.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                c2719fI.n0(iJ);
                                c2719fI.n0(iM);
                            } else {
                                this.f21131c |= 4;
                                this.f21134f = cVarA;
                            }
                        } else if (iJ == 32) {
                            this.f21131c |= 8;
                            this.f21135g = c2718e.r();
                        } else if (iJ == 40) {
                            this.f21131c |= 16;
                            this.f21136h = c2718e.r();
                        } else if (iJ == 48) {
                            iM = c2718e.m();
                            d dVarA = d.a(iM);
                            if (dVarA == null) {
                                c2719fI.n0(iJ);
                                c2719fI.n0(iM);
                            } else {
                                this.f21131c |= 32;
                                this.f21137i = dVarA;
                            }
                        } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                        }
                    }
                    z7 = true;
                } catch (Throwable th) {
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f21130b = bVarK.n();
                        throw th2;
                    }
                    this.f21130b = bVarK.n();
                    m();
                    throw th;
                }
            } catch (C2724k e8) {
                throw e8.i(this);
            } catch (IOException e9) {
                throw new C2724k(e9.getMessage()).i(this);
            }
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f21130b = bVarK.n();
            throw th3;
        }
        this.f21130b = bVarK.n();
        m();
    }

    public static v A() {
        return f21128l;
    }

    private void N() {
        this.f21132d = 0;
        this.f21133e = 0;
        this.f21134f = c.ERROR;
        this.f21135g = 0;
        this.f21136h = 0;
        this.f21137i = d.LANGUAGE_VERSION;
    }

    public static b O() {
        return b.r();
    }

    public static b P(v vVar) {
        return O().k(vVar);
    }

    public int B() {
        return this.f21135g;
    }

    public c C() {
        return this.f21134f;
    }

    public int D() {
        return this.f21136h;
    }

    public int E() {
        return this.f21132d;
    }

    public int F() {
        return this.f21133e;
    }

    public d G() {
        return this.f21137i;
    }

    public boolean H() {
        return (this.f21131c & 8) == 8;
    }

    public boolean I() {
        return (this.f21131c & 4) == 4;
    }

    public boolean J() {
        return (this.f21131c & 16) == 16;
    }

    public boolean K() {
        return (this.f21131c & 1) == 1;
    }

    public boolean L() {
        return (this.f21131c & 2) == 2;
    }

    public boolean M() {
        return (this.f21131c & 32) == 32;
    }

    @Override // s6.p
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b d() {
        return O();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public b g() {
        return P(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f21139k;
        if (i8 != -1) {
            return i8;
        }
        int iO = (this.f21131c & 1) == 1 ? C2719f.o(1, this.f21132d) : 0;
        if ((this.f21131c & 2) == 2) {
            iO += C2719f.o(2, this.f21133e);
        }
        if ((this.f21131c & 4) == 4) {
            iO += C2719f.h(3, this.f21134f.d());
        }
        if ((this.f21131c & 8) == 8) {
            iO += C2719f.o(4, this.f21135g);
        }
        if ((this.f21131c & 16) == 16) {
            iO += C2719f.o(5, this.f21136h);
        }
        if ((this.f21131c & 32) == 32) {
            iO += C2719f.h(6, this.f21137i.d());
        }
        int size = iO + this.f21130b.size();
        this.f21139k = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f21138j;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        this.f21138j = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        if ((this.f21131c & 1) == 1) {
            c2719f.Z(1, this.f21132d);
        }
        if ((this.f21131c & 2) == 2) {
            c2719f.Z(2, this.f21133e);
        }
        if ((this.f21131c & 4) == 4) {
            c2719f.R(3, this.f21134f.d());
        }
        if ((this.f21131c & 8) == 8) {
            c2719f.Z(4, this.f21135g);
        }
        if ((this.f21131c & 16) == 16) {
            c2719f.Z(5, this.f21136h);
        }
        if ((this.f21131c & 32) == 32) {
            c2719f.R(6, this.f21137i.d());
        }
        c2719f.h0(this.f21130b);
    }

    public v(AbstractC2722i.b bVar) {
        super(bVar);
        this.f21138j = (byte) -1;
        this.f21139k = -1;
        this.f21130b = bVar.j();
    }

    public v(boolean z7) {
        this.f21138j = (byte) -1;
        this.f21139k = -1;
        this.f21130b = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21142d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21144f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f21145g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f21143e = c.ERROR;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f21146h = d.LANGUAGE_VERSION;

        public b() {
            s();
        }

        public static b r() {
            return new b();
        }

        public b A(d dVar) {
            dVar.getClass();
            this.f21140b |= 32;
            this.f21146h = dVar;
            return this;
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public v a() {
            v vVarP = p();
            if (vVarP.e()) {
                return vVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(vVarP);
        }

        public v p() {
            v vVar = new v(this);
            int i8 = this.f21140b;
            int i9 = (i8 & 1) != 1 ? 0 : 1;
            vVar.f21132d = this.f21141c;
            if ((i8 & 2) == 2) {
                i9 |= 2;
            }
            vVar.f21133e = this.f21142d;
            if ((i8 & 4) == 4) {
                i9 |= 4;
            }
            vVar.f21134f = this.f21143e;
            if ((i8 & 8) == 8) {
                i9 |= 8;
            }
            vVar.f21135g = this.f21144f;
            if ((i8 & 16) == 16) {
                i9 |= 16;
            }
            vVar.f21136h = this.f21145g;
            if ((i8 & 32) == 32) {
                i9 |= 32;
            }
            vVar.f21137i = this.f21146h;
            vVar.f21131c = i9;
            return vVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return r().k(p());
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b k(v vVar) {
            if (vVar == v.A()) {
                return this;
            }
            if (vVar.K()) {
                y(vVar.E());
            }
            if (vVar.L()) {
                z(vVar.F());
            }
            if (vVar.I()) {
                w(vVar.C());
            }
            if (vVar.H()) {
                v(vVar.B());
            }
            if (vVar.J()) {
                x(vVar.D());
            }
            if (vVar.M()) {
                A(vVar.G());
            }
            l(j().d(vVar.f21130b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.v.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.v.f21129m     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.v r3 = (l6.v) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                if (r3 == 0) goto Le
                r2.k(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                s6.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                l6.v r4 = (l6.v) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.k(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.v.b.n(s6.e, s6.g):l6.v$b");
        }

        public b v(int i8) {
            this.f21140b |= 8;
            this.f21144f = i8;
            return this;
        }

        public b w(c cVar) {
            cVar.getClass();
            this.f21140b |= 4;
            this.f21143e = cVar;
            return this;
        }

        public b x(int i8) {
            this.f21140b |= 16;
            this.f21145g = i8;
            return this;
        }

        public b y(int i8) {
            this.f21140b |= 1;
            this.f21141c = i8;
            return this;
        }

        public b z(int i8) {
            this.f21140b |= 2;
            this.f21142d = i8;
            return this;
        }

        private void s() {
        }
    }
}
