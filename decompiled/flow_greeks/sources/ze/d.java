package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends i.d implements gf.q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f26035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static gf.r f26036k = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f26040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f26041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f26042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26043i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public d c(gf.e eVar, gf.g gVar) {
            return new d(eVar, gVar);
        }
    }

    static {
        d dVar = new d(true);
        f26035j = dVar;
        dVar.P();
    }

    public static d H() {
        return f26035j;
    }

    private void P() {
        this.f26039e = 6;
        List list = Collections.EMPTY_LIST;
        this.f26040f = list;
        this.f26041g = list;
    }

    public static b Q() {
        return b.t();
    }

    public static b R(d dVar) {
        return Q().j(dVar);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public d a() {
        return f26035j;
    }

    public int J() {
        return this.f26039e;
    }

    public u K(int i10) {
        return (u) this.f26040f.get(i10);
    }

    public int L() {
        return this.f26040f.size();
    }

    public List M() {
        return this.f26040f;
    }

    public List N() {
        return this.f26041g;
    }

    public boolean O() {
        return (this.f26038d & 1) == 1;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public b c() {
        return Q();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public b f() {
        return R(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26043i;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26038d & 1) == 1 ? gf.f.o(1, this.f26039e) : 0;
        for (int i11 = 0; i11 < this.f26040f.size(); i11++) {
            iO += gf.f.r(2, (gf.p) this.f26040f.get(i11));
        }
        int iP = 0;
        for (int i12 = 0; i12 < this.f26041g.size(); i12++) {
            iP += gf.f.p(((Integer) this.f26041g.get(i12)).intValue());
        }
        int size = iO + iP + (N().size() * 2) + s() + this.f26037c.size();
        this.f26043i = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26042h;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < L(); i10++) {
            if (!K(i10).d()) {
                this.f26042h = (byte) 0;
                return false;
            }
        }
        if (r()) {
            this.f26042h = (byte) 1;
            return true;
        }
        this.f26042h = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26038d & 1) == 1) {
            fVar.Z(1, this.f26039e);
        }
        for (int i10 = 0; i10 < this.f26040f.size(); i10++) {
            fVar.c0(2, (gf.p) this.f26040f.get(i10));
        }
        for (int i11 = 0; i11 < this.f26041g.size(); i11++) {
            fVar.Z(31, ((Integer) this.f26041g.get(i11)).intValue());
        }
        aVarY.a(19000, fVar);
        fVar.h0(this.f26037c);
    }

    public d(i.c cVar) {
        super(cVar);
        this.f26042h = (byte) -1;
        this.f26043i = -1;
        this.f26037c = cVar.i();
    }

    public d(boolean z10) {
        this.f26042h = (byte) -1;
        this.f26043i = -1;
        this.f26037c = gf.d.f10630a;
    }

    public d(gf.e eVar, gf.g gVar) {
        this.f26042h = (byte) -1;
        this.f26043i = -1;
        P();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.f26038d |= 1;
                                this.f26039e = eVar.r();
                            } else if (iJ == 18) {
                                if ((i10 & 2) != 2) {
                                    this.f26040f = new ArrayList();
                                    i10 |= 2;
                                }
                                this.f26040f.add(eVar.t(u.f26390n, gVar));
                            } else if (iJ == 248) {
                                if ((i10 & 4) != 4) {
                                    this.f26041g = new ArrayList();
                                    i10 |= 4;
                                }
                                this.f26041g.add(Integer.valueOf(eVar.r()));
                            } else if (iJ != 250) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                int i11 = eVar.i(eVar.z());
                                if ((i10 & 4) != 4 && eVar.e() > 0) {
                                    this.f26041g = new ArrayList();
                                    i10 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.f26041g.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i11);
                            }
                        }
                        z10 = true;
                    } catch (gf.k e10) {
                        throw e10.i(this);
                    }
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 2) == 2) {
                    this.f26040f = Collections.unmodifiableList(this.f26040f);
                }
                if ((i10 & 4) == 4) {
                    this.f26041g = Collections.unmodifiableList(this.f26041g);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26037c = bVarV.u();
                    throw th2;
                }
                this.f26037c = bVarV.u();
                l();
                throw th;
            }
        }
        if ((i10 & 2) == 2) {
            this.f26040f = Collections.unmodifiableList(this.f26040f);
        }
        if ((i10 & 4) == 4) {
            this.f26041g = Collections.unmodifiableList(this.f26041g);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26037c = bVarV.u();
            throw th3;
        }
        this.f26037c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26045e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f26046f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f26047g;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26046f = list;
            this.f26047g = list;
            x();
        }

        public static b t() {
            return new b();
        }

        private void w() {
            if ((this.f26044d & 4) != 4) {
                this.f26047g = new ArrayList(this.f26047g);
                this.f26044d |= 4;
            }
        }

        public b A(int i10) {
            this.f26044d |= 1;
            this.f26045e = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public d build() {
            d dVarR = r();
            if (dVarR.d()) {
                return dVarR;
            }
            throw a.AbstractC0191a.h(dVarR);
        }

        public d r() {
            d dVar = new d(this);
            int i10 = (this.f26044d & 1) != 1 ? 0 : 1;
            dVar.f26039e = this.f26045e;
            if ((this.f26044d & 2) == 2) {
                this.f26046f = Collections.unmodifiableList(this.f26046f);
                this.f26044d &= -3;
            }
            dVar.f26040f = this.f26046f;
            if ((this.f26044d & 4) == 4) {
                this.f26047g = Collections.unmodifiableList(this.f26047g);
                this.f26044d &= -5;
            }
            dVar.f26041g = this.f26047g;
            dVar.f26038d = i10;
            return dVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        public final void v() {
            if ((this.f26044d & 2) != 2) {
                this.f26046f = new ArrayList(this.f26046f);
                this.f26044d |= 2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.d.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.d.f26036k     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.d r3 = (ze.d) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.d r4 = (ze.d) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.d.b.u(gf.e, gf.g):ze.d$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public b j(d dVar) {
            if (dVar == d.H()) {
                return this;
            }
            if (dVar.O()) {
                A(dVar.J());
            }
            if (!dVar.f26040f.isEmpty()) {
                if (this.f26046f.isEmpty()) {
                    this.f26046f = dVar.f26040f;
                    this.f26044d &= -3;
                } else {
                    v();
                    this.f26046f.addAll(dVar.f26040f);
                }
            }
            if (!dVar.f26041g.isEmpty()) {
                if (this.f26047g.isEmpty()) {
                    this.f26047g = dVar.f26041g;
                    this.f26044d &= -5;
                } else {
                    w();
                    this.f26047g.addAll(dVar.f26041g);
                }
            }
            o(dVar);
            k(i().c(dVar.f26037c));
            return this;
        }

        private void x() {
        }
    }
}
