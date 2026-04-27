package l6;

import io.flutter.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public final class q extends AbstractC2722i.d implements s6.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final q f20992u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static s6.r f20993v = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2717d f20994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f20996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f20999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21004m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q f21005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21006o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q f21007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21009r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f21010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21011t;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public q b(C2718e c2718e, C2720g c2720g) {
            return new q(c2718e, c2720g);
        }
    }

    static {
        q qVar = new q(true);
        f20992u = qVar;
        qVar.x0();
    }

    public q(C2718e c2718e, C2720g c2720g) {
        int i8;
        c cVarG;
        int i9;
        this.f21010s = (byte) -1;
        this.f21011t = -1;
        x0();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        boolean z8 = false;
        while (!z7) {
            try {
                try {
                    try {
                        int iJ = c2718e.J();
                        switch (iJ) {
                            case 0:
                                z7 = true;
                                break;
                            case 8:
                                this.f20995d |= 4096;
                                this.f21009r = c2718e.r();
                                break;
                            case 18:
                                if (!z8) {
                                    this.f20996e = new ArrayList();
                                    z8 = true;
                                }
                                this.f20996e.add(c2718e.t(b.f21013j, c2720g));
                                break;
                            case Build.API_LEVELS.API_24 /* 24 */:
                                this.f20995d |= 1;
                                this.f20997f = c2718e.j();
                                break;
                            case 32:
                                this.f20995d |= 2;
                                this.f20998g = c2718e.r();
                                break;
                            case 42:
                                i8 = 4;
                                cVarG = (this.f20995d & 4) == 4 ? this.f20999h.g() : null;
                                q qVar = (q) c2718e.t(f20993v, c2720g);
                                this.f20999h = qVar;
                                if (cVarG != null) {
                                    cVarG.k(qVar);
                                    this.f20999h = cVarG.t();
                                }
                                i9 = this.f20995d;
                                this.f20995d = i9 | i8;
                                break;
                            case 48:
                                this.f20995d |= 16;
                                this.f21001j = c2718e.r();
                                break;
                            case 56:
                                this.f20995d |= 32;
                                this.f21002k = c2718e.r();
                                break;
                            case 64:
                                this.f20995d |= 8;
                                this.f21000i = c2718e.r();
                                break;
                            case 72:
                                this.f20995d |= 64;
                                this.f21003l = c2718e.r();
                                break;
                            case 82:
                                i8 = 256;
                                cVarG = (this.f20995d & 256) == 256 ? this.f21005n.g() : null;
                                q qVar2 = (q) c2718e.t(f20993v, c2720g);
                                this.f21005n = qVar2;
                                if (cVarG != null) {
                                    cVarG.k(qVar2);
                                    this.f21005n = cVarG.t();
                                }
                                i9 = this.f20995d;
                                this.f20995d = i9 | i8;
                                break;
                            case 88:
                                this.f20995d |= 512;
                                this.f21006o = c2718e.r();
                                break;
                            case 96:
                                this.f20995d |= 128;
                                this.f21004m = c2718e.r();
                                break;
                            case 106:
                                i8 = 1024;
                                cVarG = (this.f20995d & 1024) == 1024 ? this.f21007p.g() : null;
                                q qVar3 = (q) c2718e.t(f20993v, c2720g);
                                this.f21007p = qVar3;
                                if (cVarG != null) {
                                    cVarG.k(qVar3);
                                    this.f21007p = cVarG.t();
                                }
                                i9 = this.f20995d;
                                this.f20995d = i9 | i8;
                                break;
                            case 112:
                                this.f20995d |= 2048;
                                this.f21008q = c2718e.r();
                                break;
                            default:
                                if (!q(c2718e, c2719fI, c2720g, iJ)) {
                                    z7 = true;
                                }
                                break;
                        }
                    } catch (C2724k e8) {
                        throw e8.i(this);
                    }
                } catch (IOException e9) {
                    throw new C2724k(e9.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z8) {
                    this.f20996e = Collections.unmodifiableList(this.f20996e);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f20994c = bVarK.n();
                    throw th2;
                }
                this.f20994c = bVarK.n();
                m();
                throw th;
            }
        }
        if (z8) {
            this.f20996e = Collections.unmodifiableList(this.f20996e);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20994c = bVarK.n();
            throw th3;
        }
        this.f20994c = bVarK.n();
        m();
    }

    public static q Y() {
        return f20992u;
    }

    private void x0() {
        this.f20996e = Collections.emptyList();
        this.f20997f = false;
        this.f20998g = 0;
        this.f20999h = Y();
        this.f21000i = 0;
        this.f21001j = 0;
        this.f21002k = 0;
        this.f21003l = 0;
        this.f21004m = 0;
        this.f21005n = Y();
        this.f21006o = 0;
        this.f21007p = Y();
        this.f21008q = 0;
        this.f21009r = 0;
    }

    public static c y0() {
        return c.v();
    }

    public static c z0(q qVar) {
        return y0().k(qVar);
    }

    @Override // s6.p
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public c d() {
        return y0();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public c g() {
        return z0(this);
    }

    public q S() {
        return this.f21007p;
    }

    public int T() {
        return this.f21008q;
    }

    public b U(int i8) {
        return (b) this.f20996e.get(i8);
    }

    public int V() {
        return this.f20996e.size();
    }

    public List W() {
        return this.f20996e;
    }

    public int X() {
        return this.f21001j;
    }

    @Override // s6.q
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public q b() {
        return f20992u;
    }

    public int a0() {
        return this.f21009r;
    }

    public int b0() {
        return this.f20998g;
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f21011t;
        if (i8 != -1) {
            return i8;
        }
        int iO = (this.f20995d & 4096) == 4096 ? C2719f.o(1, this.f21009r) : 0;
        for (int i9 = 0; i9 < this.f20996e.size(); i9++) {
            iO += C2719f.r(2, (s6.p) this.f20996e.get(i9));
        }
        if ((this.f20995d & 1) == 1) {
            iO += C2719f.a(3, this.f20997f);
        }
        if ((this.f20995d & 2) == 2) {
            iO += C2719f.o(4, this.f20998g);
        }
        if ((this.f20995d & 4) == 4) {
            iO += C2719f.r(5, this.f20999h);
        }
        if ((this.f20995d & 16) == 16) {
            iO += C2719f.o(6, this.f21001j);
        }
        if ((this.f20995d & 32) == 32) {
            iO += C2719f.o(7, this.f21002k);
        }
        if ((this.f20995d & 8) == 8) {
            iO += C2719f.o(8, this.f21000i);
        }
        if ((this.f20995d & 64) == 64) {
            iO += C2719f.o(9, this.f21003l);
        }
        if ((this.f20995d & 256) == 256) {
            iO += C2719f.r(10, this.f21005n);
        }
        if ((this.f20995d & 512) == 512) {
            iO += C2719f.o(11, this.f21006o);
        }
        if ((this.f20995d & 128) == 128) {
            iO += C2719f.o(12, this.f21004m);
        }
        if ((this.f20995d & 1024) == 1024) {
            iO += C2719f.r(13, this.f21007p);
        }
        if ((this.f20995d & 2048) == 2048) {
            iO += C2719f.o(14, this.f21008q);
        }
        int iU = iO + u() + this.f20994c.size();
        this.f21011t = iU;
        return iU;
    }

    public q c0() {
        return this.f20999h;
    }

    public int d0() {
        return this.f21000i;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f21010s;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        for (int i8 = 0; i8 < V(); i8++) {
            if (!U(i8).e()) {
                this.f21010s = (byte) 0;
                return false;
            }
        }
        if (p0() && !c0().e()) {
            this.f21010s = (byte) 0;
            return false;
        }
        if (s0() && !f0().e()) {
            this.f21010s = (byte) 0;
            return false;
        }
        if (k0() && !S().e()) {
            this.f21010s = (byte) 0;
            return false;
        }
        if (t()) {
            this.f21010s = (byte) 1;
            return true;
        }
        this.f21010s = (byte) 0;
        return false;
    }

    public boolean e0() {
        return this.f20997f;
    }

    public q f0() {
        return this.f21005n;
    }

    public int g0() {
        return this.f21006o;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        AbstractC2722i.d.a aVarZ = z();
        if ((this.f20995d & 4096) == 4096) {
            c2719f.Z(1, this.f21009r);
        }
        for (int i8 = 0; i8 < this.f20996e.size(); i8++) {
            c2719f.c0(2, (s6.p) this.f20996e.get(i8));
        }
        if ((this.f20995d & 1) == 1) {
            c2719f.K(3, this.f20997f);
        }
        if ((this.f20995d & 2) == 2) {
            c2719f.Z(4, this.f20998g);
        }
        if ((this.f20995d & 4) == 4) {
            c2719f.c0(5, this.f20999h);
        }
        if ((this.f20995d & 16) == 16) {
            c2719f.Z(6, this.f21001j);
        }
        if ((this.f20995d & 32) == 32) {
            c2719f.Z(7, this.f21002k);
        }
        if ((this.f20995d & 8) == 8) {
            c2719f.Z(8, this.f21000i);
        }
        if ((this.f20995d & 64) == 64) {
            c2719f.Z(9, this.f21003l);
        }
        if ((this.f20995d & 256) == 256) {
            c2719f.c0(10, this.f21005n);
        }
        if ((this.f20995d & 512) == 512) {
            c2719f.Z(11, this.f21006o);
        }
        if ((this.f20995d & 128) == 128) {
            c2719f.Z(12, this.f21004m);
        }
        if ((this.f20995d & 1024) == 1024) {
            c2719f.c0(13, this.f21007p);
        }
        if ((this.f20995d & 2048) == 2048) {
            c2719f.Z(14, this.f21008q);
        }
        aVarZ.a(200, c2719f);
        c2719f.h0(this.f20994c);
    }

    public int h0() {
        return this.f21004m;
    }

    public int i0() {
        return this.f21002k;
    }

    public int j0() {
        return this.f21003l;
    }

    public boolean k0() {
        return (this.f20995d & 1024) == 1024;
    }

    public boolean l0() {
        return (this.f20995d & 2048) == 2048;
    }

    public boolean m0() {
        return (this.f20995d & 16) == 16;
    }

    public boolean n0() {
        return (this.f20995d & 4096) == 4096;
    }

    public boolean o0() {
        return (this.f20995d & 2) == 2;
    }

    public boolean p0() {
        return (this.f20995d & 4) == 4;
    }

    public boolean q0() {
        return (this.f20995d & 8) == 8;
    }

    public boolean r0() {
        return (this.f20995d & 1) == 1;
    }

    public boolean s0() {
        return (this.f20995d & 256) == 256;
    }

    public boolean t0() {
        return (this.f20995d & 512) == 512;
    }

    public boolean u0() {
        return (this.f20995d & 128) == 128;
    }

    public boolean v0() {
        return (this.f20995d & 32) == 32;
    }

    public boolean w0() {
        return (this.f20995d & 64) == 64;
    }

    public static final class b extends AbstractC2722i implements s6.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f21012i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static s6.r f21013j = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f21014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f21016d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public q f21017e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21018f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f21019g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f21020h;

        public static class a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b b(C2718e c2718e, C2720g c2720g) {
                return new b(c2718e, c2720g);
            }
        }

        public enum c implements AbstractC2723j.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static AbstractC2723j.b f21029f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f21031a;

            public static class a implements AbstractC2723j.b {
                @Override // s6.AbstractC2723j.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public c a(int i8) {
                    return c.a(i8);
                }
            }

            c(int i8, int i9) {
                this.f21031a = i9;
            }

            public static c a(int i8) {
                if (i8 == 0) {
                    return IN;
                }
                if (i8 == 1) {
                    return OUT;
                }
                if (i8 == 2) {
                    return INV;
                }
                if (i8 != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // s6.AbstractC2723j.a
            public final int d() {
                return this.f21031a;
            }
        }

        static {
            b bVar = new b(true);
            f21012i = bVar;
            bVar.E();
        }

        public b(C2718e c2718e, C2720g c2720g) {
            this.f21019g = (byte) -1;
            this.f21020h = -1;
            E();
            AbstractC2717d.b bVarK = AbstractC2717d.K();
            C2719f c2719fI = C2719f.I(bVarK, 1);
            boolean z7 = false;
            while (!z7) {
                try {
                    try {
                        try {
                            int iJ = c2718e.J();
                            if (iJ != 0) {
                                if (iJ == 8) {
                                    int iM = c2718e.m();
                                    c cVarA = c.a(iM);
                                    if (cVarA == null) {
                                        c2719fI.n0(iJ);
                                        c2719fI.n0(iM);
                                    } else {
                                        this.f21015c |= 1;
                                        this.f21016d = cVarA;
                                    }
                                } else if (iJ == 18) {
                                    c cVarG = (this.f21015c & 2) == 2 ? this.f21017e.g() : null;
                                    q qVar = (q) c2718e.t(q.f20993v, c2720g);
                                    this.f21017e = qVar;
                                    if (cVarG != null) {
                                        cVarG.k(qVar);
                                        this.f21017e = cVarG.t();
                                    }
                                    this.f21015c |= 2;
                                } else if (iJ == 24) {
                                    this.f21015c |= 4;
                                    this.f21018f = c2718e.r();
                                } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                                }
                            }
                            z7 = true;
                        } catch (IOException e8) {
                            throw new C2724k(e8.getMessage()).i(this);
                        }
                    } catch (C2724k e9) {
                        throw e9.i(this);
                    }
                } catch (Throwable th) {
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f21014b = bVarK.n();
                        throw th2;
                    }
                    this.f21014b = bVarK.n();
                    m();
                    throw th;
                }
            }
            try {
                c2719fI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f21014b = bVarK.n();
                throw th3;
            }
            this.f21014b = bVarK.n();
            m();
        }

        private void E() {
            this.f21016d = c.INV;
            this.f21017e = q.Y();
            this.f21018f = 0;
        }

        public static C0354b F() {
            return C0354b.r();
        }

        public static C0354b G(b bVar) {
            return F().k(bVar);
        }

        public static b x() {
            return f21012i;
        }

        public int A() {
            return this.f21018f;
        }

        public boolean B() {
            return (this.f21015c & 1) == 1;
        }

        public boolean C() {
            return (this.f21015c & 2) == 2;
        }

        public boolean D() {
            return (this.f21015c & 4) == 4;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public C0354b d() {
            return F();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public C0354b g() {
            return G(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f21020h;
            if (i8 != -1) {
                return i8;
            }
            int iH = (this.f21015c & 1) == 1 ? C2719f.h(1, this.f21016d.d()) : 0;
            if ((this.f21015c & 2) == 2) {
                iH += C2719f.r(2, this.f21017e);
            }
            if ((this.f21015c & 4) == 4) {
                iH += C2719f.o(3, this.f21018f);
            }
            int size = iH + this.f21014b.size();
            this.f21020h = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f21019g;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            if (!C() || z().e()) {
                this.f21019g = (byte) 1;
                return true;
            }
            this.f21019g = (byte) 0;
            return false;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f21015c & 1) == 1) {
                c2719f.R(1, this.f21016d.d());
            }
            if ((this.f21015c & 2) == 2) {
                c2719f.c0(2, this.f21017e);
            }
            if ((this.f21015c & 4) == 4) {
                c2719f.Z(3, this.f21018f);
            }
            c2719f.h0(this.f21014b);
        }

        public c y() {
            return this.f21016d;
        }

        public q z() {
            return this.f21017e;
        }

        public b(AbstractC2722i.b bVar) {
            super(bVar);
            this.f21019g = (byte) -1;
            this.f21020h = -1;
            this.f21014b = bVar.j();
        }

        public b(boolean z7) {
            this.f21019g = (byte) -1;
            this.f21020h = -1;
            this.f21014b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: l6.q$b$b, reason: collision with other inner class name */
        public static final class C0354b extends AbstractC2722i.b implements s6.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21021b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c f21022c = c.INV;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public q f21023d = q.Y();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21024e;

            public C0354b() {
                s();
            }

            public static C0354b r() {
                return new C0354b();
            }

            @Override // s6.p.a
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public b a() {
                b bVarP = p();
                if (bVarP.e()) {
                    return bVarP;
                }
                throw AbstractC2714a.AbstractC0396a.i(bVarP);
            }

            public b p() {
                b bVar = new b(this);
                int i8 = this.f21021b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                bVar.f21016d = this.f21022c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                bVar.f21017e = this.f21023d;
                if ((i8 & 4) == 4) {
                    i9 |= 4;
                }
                bVar.f21018f = this.f21024e;
                bVar.f21015c = i9;
                return bVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public C0354b clone() {
                return r().k(p());
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public C0354b k(b bVar) {
                if (bVar == b.x()) {
                    return this;
                }
                if (bVar.B()) {
                    w(bVar.y());
                }
                if (bVar.C()) {
                    v(bVar.z());
                }
                if (bVar.D()) {
                    x(bVar.A());
                }
                l(j().d(bVar.f21014b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public l6.q.b.C0354b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = l6.q.b.f21013j     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    l6.q$b r3 = (l6.q.b) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    l6.q$b r4 = (l6.q.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: l6.q.b.C0354b.n(s6.e, s6.g):l6.q$b$b");
            }

            public C0354b v(q qVar) {
                if ((this.f21021b & 2) == 2 && this.f21023d != q.Y()) {
                    qVar = q.z0(this.f21023d).k(qVar).t();
                }
                this.f21023d = qVar;
                this.f21021b |= 2;
                return this;
            }

            public C0354b w(c cVar) {
                cVar.getClass();
                this.f21021b |= 1;
                this.f21022c = cVar;
                return this;
            }

            public C0354b x(int i8) {
                this.f21021b |= 4;
                this.f21024e = i8;
                return this;
            }

            private void s() {
            }
        }
    }

    public q(AbstractC2722i.c cVar) {
        super(cVar);
        this.f21010s = (byte) -1;
        this.f21011t = -1;
        this.f20994c = cVar.j();
    }

    public q(boolean z7) {
        this.f21010s = (byte) -1;
        this.f21011t = -1;
        this.f20994c = AbstractC2717d.f23128a;
    }

    public static final class c extends AbstractC2722i.c implements s6.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21032d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f21034f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f21035g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f21037i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21038j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21039k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f21040l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f21041m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f21043o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f21045q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f21046r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f21033e = Collections.emptyList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f21036h = q.Y();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public q f21042n = q.Y();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public q f21044p = q.Y();

        public c() {
            x();
        }

        public static c v() {
            return new c();
        }

        private void w() {
            if ((this.f21032d & 1) != 1) {
                this.f21033e = new ArrayList(this.f21033e);
                this.f21032d |= 1;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public c k(q qVar) {
            if (qVar == q.Y()) {
                return this;
            }
            if (!qVar.f20996e.isEmpty()) {
                if (this.f21033e.isEmpty()) {
                    this.f21033e = qVar.f20996e;
                    this.f21032d &= -2;
                } else {
                    w();
                    this.f21033e.addAll(qVar.f20996e);
                }
            }
            if (qVar.r0()) {
                I(qVar.e0());
            }
            if (qVar.o0()) {
                G(qVar.b0());
            }
            if (qVar.p0()) {
                z(qVar.c0());
            }
            if (qVar.q0()) {
                H(qVar.d0());
            }
            if (qVar.m0()) {
                E(qVar.X());
            }
            if (qVar.v0()) {
                L(qVar.i0());
            }
            if (qVar.w0()) {
                M(qVar.j0());
            }
            if (qVar.u0()) {
                K(qVar.h0());
            }
            if (qVar.s0()) {
                C(qVar.f0());
            }
            if (qVar.t0()) {
                J(qVar.g0());
            }
            if (qVar.k0()) {
                y(qVar.S());
            }
            if (qVar.l0()) {
                D(qVar.T());
            }
            if (qVar.n0()) {
                F(qVar.a0());
            }
            q(qVar);
            l(j().d(qVar.f20994c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.q.c n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.q.f20993v     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.q r3 = (l6.q) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.q r4 = (l6.q) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.q.c.n(s6.e, s6.g):l6.q$c");
        }

        public c C(q qVar) {
            if ((this.f21032d & 512) == 512 && this.f21042n != q.Y()) {
                qVar = q.z0(this.f21042n).k(qVar).t();
            }
            this.f21042n = qVar;
            this.f21032d |= 512;
            return this;
        }

        public c D(int i8) {
            this.f21032d |= 4096;
            this.f21045q = i8;
            return this;
        }

        public c E(int i8) {
            this.f21032d |= 32;
            this.f21038j = i8;
            return this;
        }

        public c F(int i8) {
            this.f21032d |= 8192;
            this.f21046r = i8;
            return this;
        }

        public c G(int i8) {
            this.f21032d |= 4;
            this.f21035g = i8;
            return this;
        }

        public c H(int i8) {
            this.f21032d |= 16;
            this.f21037i = i8;
            return this;
        }

        public c I(boolean z7) {
            this.f21032d |= 2;
            this.f21034f = z7;
            return this;
        }

        public c J(int i8) {
            this.f21032d |= 1024;
            this.f21043o = i8;
            return this;
        }

        public c K(int i8) {
            this.f21032d |= 256;
            this.f21041m = i8;
            return this;
        }

        public c L(int i8) {
            this.f21032d |= 64;
            this.f21039k = i8;
            return this;
        }

        public c M(int i8) {
            this.f21032d |= 128;
            this.f21040l = i8;
            return this;
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public q a() {
            q qVarT = t();
            if (qVarT.e()) {
                return qVarT;
            }
            throw AbstractC2714a.AbstractC0396a.i(qVarT);
        }

        public q t() {
            q qVar = new q(this);
            int i8 = this.f21032d;
            if ((i8 & 1) == 1) {
                this.f21033e = Collections.unmodifiableList(this.f21033e);
                this.f21032d &= -2;
            }
            qVar.f20996e = this.f21033e;
            int i9 = (i8 & 2) != 2 ? 0 : 1;
            qVar.f20997f = this.f21034f;
            if ((i8 & 4) == 4) {
                i9 |= 2;
            }
            qVar.f20998g = this.f21035g;
            if ((i8 & 8) == 8) {
                i9 |= 4;
            }
            qVar.f20999h = this.f21036h;
            if ((i8 & 16) == 16) {
                i9 |= 8;
            }
            qVar.f21000i = this.f21037i;
            if ((i8 & 32) == 32) {
                i9 |= 16;
            }
            qVar.f21001j = this.f21038j;
            if ((i8 & 64) == 64) {
                i9 |= 32;
            }
            qVar.f21002k = this.f21039k;
            if ((i8 & 128) == 128) {
                i9 |= 64;
            }
            qVar.f21003l = this.f21040l;
            if ((i8 & 256) == 256) {
                i9 |= 128;
            }
            qVar.f21004m = this.f21041m;
            if ((i8 & 512) == 512) {
                i9 |= 256;
            }
            qVar.f21005n = this.f21042n;
            if ((i8 & 1024) == 1024) {
                i9 |= 512;
            }
            qVar.f21006o = this.f21043o;
            if ((i8 & 2048) == 2048) {
                i9 |= 1024;
            }
            qVar.f21007p = this.f21044p;
            if ((i8 & 4096) == 4096) {
                i9 |= 2048;
            }
            qVar.f21008q = this.f21045q;
            if ((i8 & 8192) == 8192) {
                i9 |= 4096;
            }
            qVar.f21009r = this.f21046r;
            qVar.f20995d = i9;
            return qVar;
        }

        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return v().k(t());
        }

        public c y(q qVar) {
            if ((this.f21032d & 2048) == 2048 && this.f21044p != q.Y()) {
                qVar = q.z0(this.f21044p).k(qVar).t();
            }
            this.f21044p = qVar;
            this.f21032d |= 2048;
            return this;
        }

        public c z(q qVar) {
            if ((this.f21032d & 8) == 8 && this.f21036h != q.Y()) {
                qVar = q.z0(this.f21036h).k(qVar).t();
            }
            this.f21036h = qVar;
            this.f21032d |= 8;
            return this;
        }

        private void x() {
        }
    }
}
