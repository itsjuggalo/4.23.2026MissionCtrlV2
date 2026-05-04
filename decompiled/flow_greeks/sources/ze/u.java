package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;
import ze.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends i.d implements gf.q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u f26389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static gf.r f26390n = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f26395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f26397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f26398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f26399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26400l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public u c(gf.e eVar, gf.g gVar) {
            return new u(eVar, gVar);
        }
    }

    static {
        u uVar = new u(true);
        f26389m = uVar;
        uVar.W();
    }

    public static u I() {
        return f26389m;
    }

    private void W() {
        this.f26393e = 0;
        this.f26394f = 0;
        this.f26395g = q.X();
        this.f26396h = 0;
        this.f26397i = q.X();
        this.f26398j = 0;
    }

    public static b X() {
        return b.t();
    }

    public static b Y(u uVar) {
        return X().j(uVar);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public u a() {
        return f26389m;
    }

    public int K() {
        return this.f26393e;
    }

    public int L() {
        return this.f26394f;
    }

    public q M() {
        return this.f26395g;
    }

    public int N() {
        return this.f26396h;
    }

    public q O() {
        return this.f26397i;
    }

    public int P() {
        return this.f26398j;
    }

    public boolean Q() {
        return (this.f26392d & 1) == 1;
    }

    public boolean R() {
        return (this.f26392d & 2) == 2;
    }

    public boolean S() {
        return (this.f26392d & 4) == 4;
    }

    public boolean T() {
        return (this.f26392d & 8) == 8;
    }

    public boolean U() {
        return (this.f26392d & 16) == 16;
    }

    public boolean V() {
        return (this.f26392d & 32) == 32;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b c() {
        return X();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return Y(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26400l;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26392d & 1) == 1 ? gf.f.o(1, this.f26393e) : 0;
        if ((this.f26392d & 2) == 2) {
            iO += gf.f.o(2, this.f26394f);
        }
        if ((this.f26392d & 4) == 4) {
            iO += gf.f.r(3, this.f26395g);
        }
        if ((this.f26392d & 16) == 16) {
            iO += gf.f.r(4, this.f26397i);
        }
        if ((this.f26392d & 8) == 8) {
            iO += gf.f.o(5, this.f26396h);
        }
        if ((this.f26392d & 32) == 32) {
            iO += gf.f.o(6, this.f26398j);
        }
        int iS = iO + s() + this.f26391c.size();
        this.f26400l = iS;
        return iS;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26399k;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!R()) {
            this.f26399k = (byte) 0;
            return false;
        }
        if (S() && !M().d()) {
            this.f26399k = (byte) 0;
            return false;
        }
        if (U() && !O().d()) {
            this.f26399k = (byte) 0;
            return false;
        }
        if (r()) {
            this.f26399k = (byte) 1;
            return true;
        }
        this.f26399k = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26392d & 1) == 1) {
            fVar.Z(1, this.f26393e);
        }
        if ((this.f26392d & 2) == 2) {
            fVar.Z(2, this.f26394f);
        }
        if ((this.f26392d & 4) == 4) {
            fVar.c0(3, this.f26395g);
        }
        if ((this.f26392d & 16) == 16) {
            fVar.c0(4, this.f26397i);
        }
        if ((this.f26392d & 8) == 8) {
            fVar.Z(5, this.f26396h);
        }
        if ((this.f26392d & 32) == 32) {
            fVar.Z(6, this.f26398j);
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26391c);
    }

    public u(i.c cVar) {
        super(cVar);
        this.f26399k = (byte) -1;
        this.f26400l = -1;
        this.f26391c = cVar.i();
    }

    public u(boolean z10) {
        this.f26399k = (byte) -1;
        this.f26400l = -1;
        this.f26391c = gf.d.f10630a;
    }

    public u(gf.e eVar, gf.g gVar) {
        q.c cVarF;
        this.f26399k = (byte) -1;
        this.f26400l = -1;
        W();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f26392d |= 1;
                            this.f26393e = eVar.r();
                        } else if (iJ != 16) {
                            if (iJ == 26) {
                                cVarF = (this.f26392d & 4) == 4 ? this.f26395g.f() : null;
                                q qVar = (q) eVar.t(q.f26273v, gVar);
                                this.f26395g = qVar;
                                if (cVarF != null) {
                                    cVarF.j(qVar);
                                    this.f26395g = cVarF.r();
                                }
                                this.f26392d |= 4;
                            } else if (iJ == 34) {
                                cVarF = (this.f26392d & 16) == 16 ? this.f26397i.f() : null;
                                q qVar2 = (q) eVar.t(q.f26273v, gVar);
                                this.f26397i = qVar2;
                                if (cVarF != null) {
                                    cVarF.j(qVar2);
                                    this.f26397i = cVarF.r();
                                }
                                this.f26392d |= 16;
                            } else if (iJ == 40) {
                                this.f26392d |= 8;
                                this.f26396h = eVar.r();
                            } else if (iJ != 48) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                this.f26392d |= 32;
                                this.f26398j = eVar.r();
                            }
                        } else {
                            this.f26392d |= 2;
                            this.f26394f = eVar.r();
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
                    this.f26391c = bVarV.u();
                    throw th2;
                }
                this.f26391c = bVarV.u();
                l();
                throw th;
            }
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26391c = bVarV.u();
            throw th3;
        }
        this.f26391c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26403f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f26405h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f26407j;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public q f26404g = q.X();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public q f26406i = q.X();

        public b() {
            v();
        }

        public static b t() {
            return new b();
        }

        public b A(int i10) {
            this.f26401d |= 1;
            this.f26402e = i10;
            return this;
        }

        public b B(int i10) {
            this.f26401d |= 2;
            this.f26403f = i10;
            return this;
        }

        public b C(int i10) {
            this.f26401d |= 8;
            this.f26405h = i10;
            return this;
        }

        public b D(int i10) {
            this.f26401d |= 32;
            this.f26407j = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public u build() {
            u uVarR = r();
            if (uVarR.d()) {
                return uVarR;
            }
            throw a.AbstractC0191a.h(uVarR);
        }

        public u r() {
            u uVar = new u(this);
            int i10 = this.f26401d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            uVar.f26393e = this.f26402e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            uVar.f26394f = this.f26403f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            uVar.f26395g = this.f26404g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            uVar.f26396h = this.f26405h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            uVar.f26397i = this.f26406i;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            uVar.f26398j = this.f26407j;
            uVar.f26392d = i11;
            return uVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.u.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.u.f26390n     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.u r3 = (ze.u) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.u r4 = (ze.u) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.u.b.u(gf.e, gf.g):ze.u$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b j(u uVar) {
            if (uVar == u.I()) {
                return this;
            }
            if (uVar.Q()) {
                A(uVar.K());
            }
            if (uVar.R()) {
                B(uVar.L());
            }
            if (uVar.S()) {
                y(uVar.M());
            }
            if (uVar.T()) {
                C(uVar.N());
            }
            if (uVar.U()) {
                z(uVar.O());
            }
            if (uVar.V()) {
                D(uVar.P());
            }
            o(uVar);
            k(i().c(uVar.f26391c));
            return this;
        }

        public b y(q qVar) {
            if ((this.f26401d & 4) != 4 || this.f26404g == q.X()) {
                this.f26404g = qVar;
            } else {
                this.f26404g = q.y0(this.f26404g).j(qVar).r();
            }
            this.f26401d |= 4;
            return this;
        }

        public b z(q qVar) {
            if ((this.f26401d & 16) != 16 || this.f26406i == q.X()) {
                this.f26406i = qVar;
            } else {
                this.f26406i = q.y0(this.f26406i).j(qVar).r();
            }
            this.f26401d |= 16;
            return this;
        }

        private void v() {
        }
    }
}
