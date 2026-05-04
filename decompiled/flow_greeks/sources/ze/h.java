package ze;

import gf.a;
import gf.d;
import gf.i;
import gf.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends gf.i implements gf.q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final h f26092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static gf.r f26093n = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f26098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f26099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f26101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f26102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f26103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26104l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public h c(gf.e eVar, gf.g gVar) {
            return new h(eVar, gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c implements j.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26116e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26118a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.a(i10);
            }
        }

        c(int i10, int i11) {
            this.f26118a = i11;
        }

        public static c a(int i10) {
            if (i10 == 0) {
                return TRUE;
            }
            if (i10 == 1) {
                return FALSE;
            }
            if (i10 != 2) {
                return null;
            }
            return NULL;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26118a;
        }
    }

    static {
        h hVar = new h(true);
        f26092m = hVar;
        hVar.R();
    }

    public static h F() {
        return f26092m;
    }

    private void R() {
        this.f26096d = 0;
        this.f26097e = 0;
        this.f26098f = c.TRUE;
        this.f26099g = q.X();
        this.f26100h = 0;
        List list = Collections.EMPTY_LIST;
        this.f26101i = list;
        this.f26102j = list;
    }

    public static b S() {
        return b.p();
    }

    public static b T(h hVar) {
        return S().j(hVar);
    }

    public h C(int i10) {
        return (h) this.f26101i.get(i10);
    }

    public int D() {
        return this.f26101i.size();
    }

    public c E() {
        return this.f26098f;
    }

    public int G() {
        return this.f26096d;
    }

    public q H() {
        return this.f26099g;
    }

    public int I() {
        return this.f26100h;
    }

    public h J(int i10) {
        return (h) this.f26102j.get(i10);
    }

    public int K() {
        return this.f26102j.size();
    }

    public int L() {
        return this.f26097e;
    }

    public boolean M() {
        return (this.f26095c & 4) == 4;
    }

    public boolean N() {
        return (this.f26095c & 1) == 1;
    }

    public boolean O() {
        return (this.f26095c & 8) == 8;
    }

    public boolean P() {
        return (this.f26095c & 16) == 16;
    }

    public boolean Q() {
        return (this.f26095c & 2) == 2;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public b c() {
        return S();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b f() {
        return T(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26104l;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26095c & 1) == 1 ? gf.f.o(1, this.f26096d) : 0;
        if ((this.f26095c & 2) == 2) {
            iO += gf.f.o(2, this.f26097e);
        }
        if ((this.f26095c & 4) == 4) {
            iO += gf.f.h(3, this.f26098f.d());
        }
        if ((this.f26095c & 8) == 8) {
            iO += gf.f.r(4, this.f26099g);
        }
        if ((this.f26095c & 16) == 16) {
            iO += gf.f.o(5, this.f26100h);
        }
        for (int i11 = 0; i11 < this.f26101i.size(); i11++) {
            iO += gf.f.r(6, (gf.p) this.f26101i.get(i11));
        }
        for (int i12 = 0; i12 < this.f26102j.size(); i12++) {
            iO += gf.f.r(7, (gf.p) this.f26102j.get(i12));
        }
        int size = iO + this.f26094b.size();
        this.f26104l = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26103k;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (O() && !H().d()) {
            this.f26103k = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < D(); i10++) {
            if (!C(i10).d()) {
                this.f26103k = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < K(); i11++) {
            if (!J(i11).d()) {
                this.f26103k = (byte) 0;
                return false;
            }
        }
        this.f26103k = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        if ((this.f26095c & 1) == 1) {
            fVar.Z(1, this.f26096d);
        }
        if ((this.f26095c & 2) == 2) {
            fVar.Z(2, this.f26097e);
        }
        if ((this.f26095c & 4) == 4) {
            fVar.R(3, this.f26098f.d());
        }
        if ((this.f26095c & 8) == 8) {
            fVar.c0(4, this.f26099g);
        }
        if ((this.f26095c & 16) == 16) {
            fVar.Z(5, this.f26100h);
        }
        for (int i10 = 0; i10 < this.f26101i.size(); i10++) {
            fVar.c0(6, (gf.p) this.f26101i.get(i10));
        }
        for (int i11 = 0; i11 < this.f26102j.size(); i11++) {
            fVar.c0(7, (gf.p) this.f26102j.get(i11));
        }
        fVar.h0(this.f26094b);
    }

    public h(i.b bVar) {
        super(bVar);
        this.f26103k = (byte) -1;
        this.f26104l = -1;
        this.f26094b = bVar.i();
    }

    public h(boolean z10) {
        this.f26103k = (byte) -1;
        this.f26104l = -1;
        this.f26094b = gf.d.f10630a;
    }

    public h(gf.e eVar, gf.g gVar) {
        this.f26103k = (byte) -1;
        this.f26104l = -1;
        R();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f26095c |= 1;
                            this.f26096d = eVar.r();
                        } else if (iJ == 16) {
                            this.f26095c |= 2;
                            this.f26097e = eVar.r();
                        } else if (iJ == 24) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                fVarI.n0(iJ);
                                fVarI.n0(iM);
                            } else {
                                this.f26095c |= 4;
                                this.f26098f = cVarA;
                            }
                        } else if (iJ == 34) {
                            q.c cVarF = (this.f26095c & 8) == 8 ? this.f26099g.f() : null;
                            q qVar = (q) eVar.t(q.f26273v, gVar);
                            this.f26099g = qVar;
                            if (cVarF != null) {
                                cVarF.j(qVar);
                                this.f26099g = cVarF.r();
                            }
                            this.f26095c |= 8;
                        } else if (iJ == 40) {
                            this.f26095c |= 16;
                            this.f26100h = eVar.r();
                        } else if (iJ == 50) {
                            if ((i10 & 32) != 32) {
                                this.f26101i = new ArrayList();
                                i10 |= 32;
                            }
                            this.f26101i.add(eVar.t(f26093n, gVar));
                        } else if (iJ != 58) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            if ((i10 & 64) != 64) {
                                this.f26102j = new ArrayList();
                                i10 |= 64;
                            }
                            this.f26102j.add(eVar.t(f26093n, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 32) == 32) {
                        this.f26101i = Collections.unmodifiableList(this.f26101i);
                    }
                    if ((i10 & 64) == 64) {
                        this.f26102j = Collections.unmodifiableList(this.f26102j);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26094b = bVarV.u();
                        throw th2;
                    }
                    this.f26094b = bVarV.u();
                    l();
                    throw th;
                }
            } catch (gf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new gf.k(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 32) == 32) {
            this.f26101i = Collections.unmodifiableList(this.f26101i);
        }
        if ((i10 & 64) == 64) {
            this.f26102j = Collections.unmodifiableList(this.f26102j);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26094b = bVarV.u();
            throw th3;
        }
        this.f26094b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f26108e = c.TRUE;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q f26109f = q.X();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26110g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f26111h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f26112i;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26111h = list;
            this.f26112i = list;
            s();
        }

        public static b p() {
            return new b();
        }

        public b A(int i10) {
            this.f26105b |= 2;
            this.f26107d = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public h build() {
            h hVarN = n();
            if (hVarN.d()) {
                return hVarN;
            }
            throw a.AbstractC0191a.h(hVarN);
        }

        public h n() {
            h hVar = new h(this);
            int i10 = this.f26105b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            hVar.f26096d = this.f26106c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            hVar.f26097e = this.f26107d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            hVar.f26098f = this.f26108e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            hVar.f26099g = this.f26109f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            hVar.f26100h = this.f26110g;
            if ((this.f26105b & 32) == 32) {
                this.f26111h = Collections.unmodifiableList(this.f26111h);
                this.f26105b &= -33;
            }
            hVar.f26101i = this.f26111h;
            if ((this.f26105b & 64) == 64) {
                this.f26112i = Collections.unmodifiableList(this.f26112i);
                this.f26105b &= -65;
            }
            hVar.f26102j = this.f26112i;
            hVar.f26095c = i11;
            return hVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26105b & 32) != 32) {
                this.f26111h = new ArrayList(this.f26111h);
                this.f26105b |= 32;
            }
        }

        public final void r() {
            if ((this.f26105b & 64) != 64) {
                this.f26112i = new ArrayList(this.f26112i);
                this.f26105b |= 64;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.h.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.h.f26093n     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.h r3 = (ze.h) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.h r4 = (ze.h) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.h.b.u(gf.e, gf.g):ze.h$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b j(h hVar) {
            if (hVar == h.F()) {
                return this;
            }
            if (hVar.N()) {
                y(hVar.G());
            }
            if (hVar.Q()) {
                A(hVar.L());
            }
            if (hVar.M()) {
                x(hVar.E());
            }
            if (hVar.O()) {
                w(hVar.H());
            }
            if (hVar.P()) {
                z(hVar.I());
            }
            if (!hVar.f26101i.isEmpty()) {
                if (this.f26111h.isEmpty()) {
                    this.f26111h = hVar.f26101i;
                    this.f26105b &= -33;
                } else {
                    q();
                    this.f26111h.addAll(hVar.f26101i);
                }
            }
            if (!hVar.f26102j.isEmpty()) {
                if (this.f26112i.isEmpty()) {
                    this.f26112i = hVar.f26102j;
                    this.f26105b &= -65;
                } else {
                    r();
                    this.f26112i.addAll(hVar.f26102j);
                }
            }
            k(i().c(hVar.f26094b));
            return this;
        }

        public b w(q qVar) {
            if ((this.f26105b & 8) != 8 || this.f26109f == q.X()) {
                this.f26109f = qVar;
            } else {
                this.f26109f = q.y0(this.f26109f).j(qVar).r();
            }
            this.f26105b |= 8;
            return this;
        }

        public b x(c cVar) {
            cVar.getClass();
            this.f26105b |= 4;
            this.f26108e = cVar;
            return this;
        }

        public b y(int i10) {
            this.f26105b |= 1;
            this.f26106c = i10;
            return this;
        }

        public b z(int i10) {
            this.f26105b |= 16;
            this.f26110g = i10;
            return this;
        }

        private void s() {
        }
    }
}
