package ze;

import bb.d0;
import gf.a;
import gf.d;
import gf.i;
import gf.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends i.d implements gf.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final q f26272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static gf.r f26273v = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f26276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f26277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f26279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f26281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f26284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q f26285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26286o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q f26287p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f26288q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f26289r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f26290s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f26291t;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public q c(gf.e eVar, gf.g gVar) {
            return new q(eVar, gVar);
        }
    }

    static {
        q qVar = new q(true);
        f26272u = qVar;
        qVar.w0();
    }

    public static q X() {
        return f26272u;
    }

    private void w0() {
        this.f26276e = Collections.EMPTY_LIST;
        this.f26277f = false;
        this.f26278g = 0;
        this.f26279h = X();
        this.f26280i = 0;
        this.f26281j = 0;
        this.f26282k = 0;
        this.f26283l = 0;
        this.f26284m = 0;
        this.f26285n = X();
        this.f26286o = 0;
        this.f26287p = X();
        this.f26288q = 0;
        this.f26289r = 0;
    }

    public static c x0() {
        return c.t();
    }

    public static c y0(q qVar) {
        return x0().j(qVar);
    }

    @Override // gf.p
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public c f() {
        return y0(this);
    }

    public q R() {
        return this.f26287p;
    }

    public int S() {
        return this.f26288q;
    }

    public b T(int i10) {
        return (b) this.f26276e.get(i10);
    }

    public int U() {
        return this.f26276e.size();
    }

    public List V() {
        return this.f26276e;
    }

    public int W() {
        return this.f26281j;
    }

    @Override // gf.q
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public q a() {
        return f26272u;
    }

    public int Z() {
        return this.f26289r;
    }

    public int a0() {
        return this.f26278g;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26291t;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26275d & 4096) == 4096 ? gf.f.o(1, this.f26289r) : 0;
        for (int i11 = 0; i11 < this.f26276e.size(); i11++) {
            iO += gf.f.r(2, (gf.p) this.f26276e.get(i11));
        }
        if ((this.f26275d & 1) == 1) {
            iO += gf.f.a(3, this.f26277f);
        }
        if ((this.f26275d & 2) == 2) {
            iO += gf.f.o(4, this.f26278g);
        }
        if ((this.f26275d & 4) == 4) {
            iO += gf.f.r(5, this.f26279h);
        }
        if ((this.f26275d & 16) == 16) {
            iO += gf.f.o(6, this.f26281j);
        }
        if ((this.f26275d & 32) == 32) {
            iO += gf.f.o(7, this.f26282k);
        }
        if ((this.f26275d & 8) == 8) {
            iO += gf.f.o(8, this.f26280i);
        }
        if ((this.f26275d & 64) == 64) {
            iO += gf.f.o(9, this.f26283l);
        }
        if ((this.f26275d & 256) == 256) {
            iO += gf.f.r(10, this.f26285n);
        }
        if ((this.f26275d & 512) == 512) {
            iO += gf.f.o(11, this.f26286o);
        }
        if ((this.f26275d & 128) == 128) {
            iO += gf.f.o(12, this.f26284m);
        }
        if ((this.f26275d & 1024) == 1024) {
            iO += gf.f.r(13, this.f26287p);
        }
        if ((this.f26275d & 2048) == 2048) {
            iO += gf.f.o(14, this.f26288q);
        }
        int iS = iO + s() + this.f26274c.size();
        this.f26291t = iS;
        return iS;
    }

    public q b0() {
        return this.f26279h;
    }

    public int c0() {
        return this.f26280i;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26290s;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < U(); i10++) {
            if (!T(i10).d()) {
                this.f26290s = (byte) 0;
                return false;
            }
        }
        if (o0() && !b0().d()) {
            this.f26290s = (byte) 0;
            return false;
        }
        if (r0() && !e0().d()) {
            this.f26290s = (byte) 0;
            return false;
        }
        if (j0() && !R().d()) {
            this.f26290s = (byte) 0;
            return false;
        }
        if (r()) {
            this.f26290s = (byte) 1;
            return true;
        }
        this.f26290s = (byte) 0;
        return false;
    }

    public boolean d0() {
        return this.f26277f;
    }

    public q e0() {
        return this.f26285n;
    }

    public int f0() {
        return this.f26286o;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26275d & 4096) == 4096) {
            fVar.Z(1, this.f26289r);
        }
        for (int i10 = 0; i10 < this.f26276e.size(); i10++) {
            fVar.c0(2, (gf.p) this.f26276e.get(i10));
        }
        if ((this.f26275d & 1) == 1) {
            fVar.K(3, this.f26277f);
        }
        if ((this.f26275d & 2) == 2) {
            fVar.Z(4, this.f26278g);
        }
        if ((this.f26275d & 4) == 4) {
            fVar.c0(5, this.f26279h);
        }
        if ((this.f26275d & 16) == 16) {
            fVar.Z(6, this.f26281j);
        }
        if ((this.f26275d & 32) == 32) {
            fVar.Z(7, this.f26282k);
        }
        if ((this.f26275d & 8) == 8) {
            fVar.Z(8, this.f26280i);
        }
        if ((this.f26275d & 64) == 64) {
            fVar.Z(9, this.f26283l);
        }
        if ((this.f26275d & 256) == 256) {
            fVar.c0(10, this.f26285n);
        }
        if ((this.f26275d & 512) == 512) {
            fVar.Z(11, this.f26286o);
        }
        if ((this.f26275d & 128) == 128) {
            fVar.Z(12, this.f26284m);
        }
        if ((this.f26275d & 1024) == 1024) {
            fVar.c0(13, this.f26287p);
        }
        if ((this.f26275d & 2048) == 2048) {
            fVar.Z(14, this.f26288q);
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26274c);
    }

    public int g0() {
        return this.f26284m;
    }

    public int h0() {
        return this.f26282k;
    }

    public int i0() {
        return this.f26283l;
    }

    public boolean j0() {
        return (this.f26275d & 1024) == 1024;
    }

    public boolean k0() {
        return (this.f26275d & 2048) == 2048;
    }

    public boolean l0() {
        return (this.f26275d & 16) == 16;
    }

    public boolean m0() {
        return (this.f26275d & 4096) == 4096;
    }

    public boolean n0() {
        return (this.f26275d & 2) == 2;
    }

    public boolean o0() {
        return (this.f26275d & 4) == 4;
    }

    public boolean p0() {
        return (this.f26275d & 8) == 8;
    }

    public boolean q0() {
        return (this.f26275d & 1) == 1;
    }

    public boolean r0() {
        return (this.f26275d & 256) == 256;
    }

    public boolean s0() {
        return (this.f26275d & 512) == 512;
    }

    public boolean t0() {
        return (this.f26275d & 128) == 128;
    }

    public boolean u0() {
        return (this.f26275d & 32) == 32;
    }

    public boolean v0() {
        return (this.f26275d & 64) == 64;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public c c() {
        return x0();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends gf.i implements gf.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f26292i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static gf.r f26293j = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f26294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f26296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public q f26297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f26299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f26300h;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b c(gf.e eVar, gf.g gVar) {
                return new b(eVar, gVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum c implements j.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static j.b f26309f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f26311a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class a implements j.b {
                @Override // gf.j.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public c a(int i10) {
                    return c.a(i10);
                }
            }

            c(int i10, int i11) {
                this.f26311a = i11;
            }

            public static c a(int i10) {
                if (i10 == 0) {
                    return IN;
                }
                if (i10 == 1) {
                    return OUT;
                }
                if (i10 == 2) {
                    return INV;
                }
                if (i10 != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // gf.j.a
            public final int d() {
                return this.f26311a;
            }
        }

        static {
            b bVar = new b(true);
            f26292i = bVar;
            bVar.D();
        }

        private void D() {
            this.f26296d = c.INV;
            this.f26297e = q.X();
            this.f26298f = 0;
        }

        public static C0496b E() {
            return C0496b.p();
        }

        public static C0496b F(b bVar) {
            return E().j(bVar);
        }

        public static b w() {
            return f26292i;
        }

        public boolean A() {
            return (this.f26295c & 1) == 1;
        }

        public boolean B() {
            return (this.f26295c & 2) == 2;
        }

        public boolean C() {
            return (this.f26295c & 4) == 4;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0496b c() {
            return E();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public C0496b f() {
            return F(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f26300h;
            if (i10 != -1) {
                return i10;
            }
            int iH = (this.f26295c & 1) == 1 ? gf.f.h(1, this.f26296d.d()) : 0;
            if ((this.f26295c & 2) == 2) {
                iH += gf.f.r(2, this.f26297e);
            }
            if ((this.f26295c & 4) == 4) {
                iH += gf.f.o(3, this.f26298f);
            }
            int size = iH + this.f26294b.size();
            this.f26300h = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f26299g;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!B() || y().d()) {
                this.f26299g = (byte) 1;
                return true;
            }
            this.f26299g = (byte) 0;
            return false;
        }

        @Override // gf.p
        public void g(gf.f fVar) throws IOException {
            b();
            if ((this.f26295c & 1) == 1) {
                fVar.R(1, this.f26296d.d());
            }
            if ((this.f26295c & 2) == 2) {
                fVar.c0(2, this.f26297e);
            }
            if ((this.f26295c & 4) == 4) {
                fVar.Z(3, this.f26298f);
            }
            fVar.h0(this.f26294b);
        }

        public c x() {
            return this.f26296d;
        }

        public q y() {
            return this.f26297e;
        }

        public int z() {
            return this.f26298f;
        }

        public b(i.b bVar) {
            super(bVar);
            this.f26299g = (byte) -1;
            this.f26300h = -1;
            this.f26294b = bVar.i();
        }

        public b(boolean z10) {
            this.f26299g = (byte) -1;
            this.f26300h = -1;
            this.f26294b = gf.d.f10630a;
        }

        public b(gf.e eVar, gf.g gVar) {
            this.f26299g = (byte) -1;
            this.f26300h = -1;
            D();
            d.b bVarV = gf.d.v();
            gf.f fVarI = gf.f.I(bVarV, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                int iM = eVar.m();
                                c cVarA = c.a(iM);
                                if (cVarA == null) {
                                    fVarI.n0(iJ);
                                    fVarI.n0(iM);
                                } else {
                                    this.f26295c |= 1;
                                    this.f26296d = cVarA;
                                }
                            } else if (iJ == 18) {
                                c cVarF = (this.f26295c & 2) == 2 ? this.f26297e.f() : null;
                                q qVar = (q) eVar.t(q.f26273v, gVar);
                                this.f26297e = qVar;
                                if (cVarF != null) {
                                    cVarF.j(qVar);
                                    this.f26297e = cVarF.r();
                                }
                                this.f26295c |= 2;
                            } else if (iJ != 24) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                this.f26295c |= 4;
                                this.f26298f = eVar.r();
                            }
                        }
                        z10 = true;
                    } catch (gf.k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new gf.k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26294b = bVarV.u();
                        throw th2;
                    }
                    this.f26294b = bVarV.u();
                    l();
                    throw th;
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f26294b = bVarV.u();
                throw th3;
            }
            this.f26294b = bVarV.u();
            l();
        }

        /* JADX INFO: renamed from: ze.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0496b extends i.b implements gf.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f26301b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c f26302c = c.INV;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public q f26303d = q.X();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f26304e;

            public C0496b() {
                q();
            }

            public static C0496b p() {
                return new C0496b();
            }

            @Override // gf.p.a
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b build() {
                b bVarN = n();
                if (bVarN.d()) {
                    return bVarN;
                }
                throw a.AbstractC0191a.h(bVarN);
            }

            public b n() {
                b bVar = new b(this);
                int i10 = this.f26301b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.f26296d = this.f26302c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.f26297e = this.f26303d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                bVar.f26298f = this.f26304e;
                bVar.f26295c = i11;
                return bVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0496b clone() {
                return p().j(n());
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ze.q.b.C0496b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = ze.q.b.f26293j     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    ze.q$b r3 = (ze.q.b) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    if (r3 == 0) goto Le
                    r2.j(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    gf.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    ze.q$b r4 = (ze.q.b) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.j(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: ze.q.b.C0496b.u(gf.e, gf.g):ze.q$b$b");
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public C0496b j(b bVar) {
                if (bVar == b.w()) {
                    return this;
                }
                if (bVar.A()) {
                    v(bVar.x());
                }
                if (bVar.B()) {
                    t(bVar.y());
                }
                if (bVar.C()) {
                    w(bVar.z());
                }
                k(i().c(bVar.f26294b));
                return this;
            }

            public C0496b t(q qVar) {
                if ((this.f26301b & 2) != 2 || this.f26303d == q.X()) {
                    this.f26303d = qVar;
                } else {
                    this.f26303d = q.y0(this.f26303d).j(qVar).r();
                }
                this.f26301b |= 2;
                return this;
            }

            public C0496b v(c cVar) {
                cVar.getClass();
                this.f26301b |= 1;
                this.f26302c = cVar;
                return this;
            }

            public C0496b w(int i10) {
                this.f26301b |= 4;
                this.f26304e = i10;
                return this;
            }

            private void q() {
            }
        }
    }

    public q(i.c cVar) {
        super(cVar);
        this.f26290s = (byte) -1;
        this.f26291t = -1;
        this.f26274c = cVar.i();
    }

    public q(boolean z10) {
        this.f26290s = (byte) -1;
        this.f26291t = -1;
        this.f26274c = gf.d.f10630a;
    }

    public q(gf.e eVar, gf.g gVar) {
        c cVarF;
        this.f26290s = (byte) -1;
        this.f26291t = -1;
        w0();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z10 = true;
                                break;
                            case 8:
                                this.f26275d |= 4096;
                                this.f26289r = eVar.r();
                                break;
                            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                if (!z11) {
                                    this.f26276e = new ArrayList();
                                    z11 = true;
                                }
                                this.f26276e.add(eVar.t(b.f26293j, gVar));
                                break;
                            case 24:
                                this.f26275d |= 1;
                                this.f26277f = eVar.j();
                                break;
                            case 32:
                                this.f26275d |= 2;
                                this.f26278g = eVar.r();
                                break;
                            case 42:
                                cVarF = (this.f26275d & 4) == 4 ? this.f26279h.f() : null;
                                q qVar = (q) eVar.t(f26273v, gVar);
                                this.f26279h = qVar;
                                if (cVarF != null) {
                                    cVarF.j(qVar);
                                    this.f26279h = cVarF.r();
                                }
                                this.f26275d |= 4;
                                break;
                            case 48:
                                this.f26275d |= 16;
                                this.f26281j = eVar.r();
                                break;
                            case 56:
                                this.f26275d |= 32;
                                this.f26282k = eVar.r();
                                break;
                            case 64:
                                this.f26275d |= 8;
                                this.f26280i = eVar.r();
                                break;
                            case 72:
                                this.f26275d |= 64;
                                this.f26283l = eVar.r();
                                break;
                            case 82:
                                cVarF = (this.f26275d & 256) == 256 ? this.f26285n.f() : null;
                                q qVar2 = (q) eVar.t(f26273v, gVar);
                                this.f26285n = qVar2;
                                if (cVarF != null) {
                                    cVarF.j(qVar2);
                                    this.f26285n = cVarF.r();
                                }
                                this.f26275d |= 256;
                                break;
                            case 88:
                                this.f26275d |= 512;
                                this.f26286o = eVar.r();
                                break;
                            case 96:
                                this.f26275d |= 128;
                                this.f26284m = eVar.r();
                                break;
                            case 106:
                                cVarF = (this.f26275d & 1024) == 1024 ? this.f26287p.f() : null;
                                q qVar3 = (q) eVar.t(f26273v, gVar);
                                this.f26287p = qVar3;
                                if (cVarF != null) {
                                    cVarF.j(qVar3);
                                    this.f26287p = cVarF.r();
                                }
                                this.f26275d |= 1024;
                                break;
                            case 112:
                                this.f26275d |= 2048;
                                this.f26288q = eVar.r();
                                break;
                            default:
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                    z10 = true;
                                }
                                break;
                        }
                    } catch (gf.k e10) {
                        throw e10.i(this);
                    }
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z11) {
                    this.f26276e = Collections.unmodifiableList(this.f26276e);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26274c = bVarV.u();
                    throw th2;
                }
                this.f26274c = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26276e = Collections.unmodifiableList(this.f26276e);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26274c = bVarV.u();
            throw th3;
        }
        this.f26274c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26312d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f26314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26315g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f26317i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f26318j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f26319k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f26320l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f26321m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f26323o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f26325q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f26326r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f26313e = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f26316h = q.X();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public q f26322n = q.X();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public q f26324p = q.X();

        public c() {
            w();
        }

        public static c t() {
            return new c();
        }

        private void v() {
            if ((this.f26312d & 1) != 1) {
                this.f26313e = new ArrayList(this.f26313e);
                this.f26312d |= 1;
            }
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public c j(q qVar) {
            if (qVar == q.X()) {
                return this;
            }
            if (!qVar.f26276e.isEmpty()) {
                if (this.f26313e.isEmpty()) {
                    this.f26313e = qVar.f26276e;
                    this.f26312d &= -2;
                } else {
                    v();
                    this.f26313e.addAll(qVar.f26276e);
                }
            }
            if (qVar.q0()) {
                H(qVar.d0());
            }
            if (qVar.n0()) {
                F(qVar.a0());
            }
            if (qVar.o0()) {
                y(qVar.b0());
            }
            if (qVar.p0()) {
                G(qVar.c0());
            }
            if (qVar.l0()) {
                D(qVar.W());
            }
            if (qVar.u0()) {
                K(qVar.h0());
            }
            if (qVar.v0()) {
                L(qVar.i0());
            }
            if (qVar.t0()) {
                J(qVar.g0());
            }
            if (qVar.r0()) {
                B(qVar.e0());
            }
            if (qVar.s0()) {
                I(qVar.f0());
            }
            if (qVar.j0()) {
                x(qVar.R());
            }
            if (qVar.k0()) {
                C(qVar.S());
            }
            if (qVar.m0()) {
                E(qVar.Z());
            }
            o(qVar);
            k(i().c(qVar.f26274c));
            return this;
        }

        public c B(q qVar) {
            if ((this.f26312d & 512) != 512 || this.f26322n == q.X()) {
                this.f26322n = qVar;
            } else {
                this.f26322n = q.y0(this.f26322n).j(qVar).r();
            }
            this.f26312d |= 512;
            return this;
        }

        public c C(int i10) {
            this.f26312d |= 4096;
            this.f26325q = i10;
            return this;
        }

        public c D(int i10) {
            this.f26312d |= 32;
            this.f26318j = i10;
            return this;
        }

        public c E(int i10) {
            this.f26312d |= 8192;
            this.f26326r = i10;
            return this;
        }

        public c F(int i10) {
            this.f26312d |= 4;
            this.f26315g = i10;
            return this;
        }

        public c G(int i10) {
            this.f26312d |= 16;
            this.f26317i = i10;
            return this;
        }

        public c H(boolean z10) {
            this.f26312d |= 2;
            this.f26314f = z10;
            return this;
        }

        public c I(int i10) {
            this.f26312d |= 1024;
            this.f26323o = i10;
            return this;
        }

        public c J(int i10) {
            this.f26312d |= 256;
            this.f26321m = i10;
            return this;
        }

        public c K(int i10) {
            this.f26312d |= 64;
            this.f26319k = i10;
            return this;
        }

        public c L(int i10) {
            this.f26312d |= 128;
            this.f26320l = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public q build() {
            q qVarR = r();
            if (qVarR.d()) {
                return qVarR;
            }
            throw a.AbstractC0191a.h(qVarR);
        }

        public q r() {
            q qVar = new q(this);
            int i10 = this.f26312d;
            if ((i10 & 1) == 1) {
                this.f26313e = Collections.unmodifiableList(this.f26313e);
                this.f26312d &= -2;
            }
            qVar.f26276e = this.f26313e;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            qVar.f26277f = this.f26314f;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            qVar.f26278g = this.f26315g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            qVar.f26279h = this.f26316h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            qVar.f26280i = this.f26317i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            qVar.f26281j = this.f26318j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            qVar.f26282k = this.f26319k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            qVar.f26283l = this.f26320l;
            if ((i10 & 256) == 256) {
                i11 |= 128;
            }
            qVar.f26284m = this.f26321m;
            if ((i10 & 512) == 512) {
                i11 |= 256;
            }
            qVar.f26285n = this.f26322n;
            if ((i10 & 1024) == 1024) {
                i11 |= 512;
            }
            qVar.f26286o = this.f26323o;
            if ((i10 & 2048) == 2048) {
                i11 |= 1024;
            }
            qVar.f26287p = this.f26324p;
            if ((i10 & 4096) == 4096) {
                i11 |= 2048;
            }
            qVar.f26288q = this.f26325q;
            if ((i10 & 8192) == 8192) {
                i11 |= 4096;
            }
            qVar.f26289r = this.f26326r;
            qVar.f26275d = i11;
            return qVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return t().j(r());
        }

        public c x(q qVar) {
            if ((this.f26312d & 2048) != 2048 || this.f26324p == q.X()) {
                this.f26324p = qVar;
            } else {
                this.f26324p = q.y0(this.f26324p).j(qVar).r();
            }
            this.f26312d |= 2048;
            return this;
        }

        public c y(q qVar) {
            if ((this.f26312d & 8) != 8 || this.f26316h == q.X()) {
                this.f26316h = qVar;
            } else {
                this.f26316h = q.y0(this.f26316h).j(qVar).r();
            }
            this.f26312d |= 8;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.q.c u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.q.f26273v     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.q r3 = (ze.q) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                if (r3 == 0) goto Le
                r2.j(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                gf.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ze.q r4 = (ze.q) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.j(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ze.q.c.u(gf.e, gf.g):ze.q$c");
        }

        private void w() {
        }
    }
}
