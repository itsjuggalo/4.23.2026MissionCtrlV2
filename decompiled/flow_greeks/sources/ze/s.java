package ze;

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
public final class s extends i.d implements gf.q {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s f26352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static gf.r f26353o = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f26358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f26359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f26360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f26361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte f26363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f26364m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public s c(gf.e eVar, gf.g gVar) {
            return new s(eVar, gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c implements j.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26375e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26377a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.a(i10);
            }
        }

        c(int i10, int i11) {
            this.f26377a = i11;
        }

        public static c a(int i10) {
            if (i10 == 0) {
                return IN;
            }
            if (i10 == 1) {
                return OUT;
            }
            if (i10 != 2) {
                return null;
            }
            return INV;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26377a;
        }
    }

    static {
        s sVar = new s(true);
        f26352n = sVar;
        sVar.Y();
    }

    public static s K() {
        return f26352n;
    }

    private void Y() {
        this.f26356e = 0;
        this.f26357f = 0;
        this.f26358g = false;
        this.f26359h = c.INV;
        List list = Collections.EMPTY_LIST;
        this.f26360i = list;
        this.f26361j = list;
    }

    public static b Z() {
        return b.t();
    }

    public static b a0(s sVar) {
        return Z().j(sVar);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public s a() {
        return f26352n;
    }

    public int M() {
        return this.f26356e;
    }

    public int N() {
        return this.f26357f;
    }

    public boolean O() {
        return this.f26358g;
    }

    public q P(int i10) {
        return (q) this.f26360i.get(i10);
    }

    public int Q() {
        return this.f26360i.size();
    }

    public List R() {
        return this.f26361j;
    }

    public List S() {
        return this.f26360i;
    }

    public c T() {
        return this.f26359h;
    }

    public boolean U() {
        return (this.f26355d & 1) == 1;
    }

    public boolean V() {
        return (this.f26355d & 2) == 2;
    }

    public boolean W() {
        return (this.f26355d & 4) == 4;
    }

    public boolean X() {
        return (this.f26355d & 8) == 8;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26364m;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26355d & 1) == 1 ? gf.f.o(1, this.f26356e) : 0;
        if ((this.f26355d & 2) == 2) {
            iO += gf.f.o(2, this.f26357f);
        }
        if ((this.f26355d & 4) == 4) {
            iO += gf.f.a(3, this.f26358g);
        }
        if ((this.f26355d & 8) == 8) {
            iO += gf.f.h(4, this.f26359h.d());
        }
        for (int i11 = 0; i11 < this.f26360i.size(); i11++) {
            iO += gf.f.r(5, (gf.p) this.f26360i.get(i11));
        }
        int iP = 0;
        for (int i12 = 0; i12 < this.f26361j.size(); i12++) {
            iP += gf.f.p(((Integer) this.f26361j.get(i12)).intValue());
        }
        int iP2 = iO + iP;
        if (!R().isEmpty()) {
            iP2 = iP2 + 1 + gf.f.p(iP);
        }
        this.f26362k = iP;
        int iS = iP2 + s() + this.f26354c.size();
        this.f26364m = iS;
        return iS;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return Z();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return a0(this);
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26363l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!U()) {
            this.f26363l = (byte) 0;
            return false;
        }
        if (!V()) {
            this.f26363l = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Q(); i10++) {
            if (!P(i10).d()) {
                this.f26363l = (byte) 0;
                return false;
            }
        }
        if (r()) {
            this.f26363l = (byte) 1;
            return true;
        }
        this.f26363l = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26355d & 1) == 1) {
            fVar.Z(1, this.f26356e);
        }
        if ((this.f26355d & 2) == 2) {
            fVar.Z(2, this.f26357f);
        }
        if ((this.f26355d & 4) == 4) {
            fVar.K(3, this.f26358g);
        }
        if ((this.f26355d & 8) == 8) {
            fVar.R(4, this.f26359h.d());
        }
        for (int i10 = 0; i10 < this.f26360i.size(); i10++) {
            fVar.c0(5, (gf.p) this.f26360i.get(i10));
        }
        if (R().size() > 0) {
            fVar.n0(50);
            fVar.n0(this.f26362k);
        }
        for (int i11 = 0; i11 < this.f26361j.size(); i11++) {
            fVar.a0(((Integer) this.f26361j.get(i11)).intValue());
        }
        aVarY.a(1000, fVar);
        fVar.h0(this.f26354c);
    }

    public s(i.c cVar) {
        super(cVar);
        this.f26362k = -1;
        this.f26363l = (byte) -1;
        this.f26364m = -1;
        this.f26354c = cVar.i();
    }

    public s(boolean z10) {
        this.f26362k = -1;
        this.f26363l = (byte) -1;
        this.f26364m = -1;
        this.f26354c = gf.d.f10630a;
    }

    public s(gf.e eVar, gf.g gVar) {
        this.f26362k = -1;
        this.f26363l = (byte) -1;
        this.f26364m = -1;
        Y();
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
                            this.f26355d |= 1;
                            this.f26356e = eVar.r();
                        } else if (iJ == 16) {
                            this.f26355d |= 2;
                            this.f26357f = eVar.r();
                        } else if (iJ == 24) {
                            this.f26355d |= 4;
                            this.f26358g = eVar.j();
                        } else if (iJ == 32) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                fVarI.n0(iJ);
                                fVarI.n0(iM);
                            } else {
                                this.f26355d |= 8;
                                this.f26359h = cVarA;
                            }
                        } else if (iJ == 42) {
                            if ((i10 & 16) != 16) {
                                this.f26360i = new ArrayList();
                                i10 |= 16;
                            }
                            this.f26360i.add(eVar.t(q.f26273v, gVar));
                        } else if (iJ == 48) {
                            if ((i10 & 32) != 32) {
                                this.f26361j = new ArrayList();
                                i10 |= 32;
                            }
                            this.f26361j.add(Integer.valueOf(eVar.r()));
                        } else if (iJ != 50) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            int i11 = eVar.i(eVar.z());
                            if ((i10 & 32) != 32 && eVar.e() > 0) {
                                this.f26361j = new ArrayList();
                                i10 |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.f26361j.add(Integer.valueOf(eVar.r()));
                            }
                            eVar.h(i11);
                        }
                    }
                    z10 = true;
                } catch (gf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 16) == 16) {
                    this.f26360i = Collections.unmodifiableList(this.f26360i);
                }
                if ((i10 & 32) == 32) {
                    this.f26361j = Collections.unmodifiableList(this.f26361j);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26354c = bVarV.u();
                    throw th2;
                }
                this.f26354c = bVarV.u();
                l();
                throw th;
            }
        }
        if ((i10 & 16) == 16) {
            this.f26360i = Collections.unmodifiableList(this.f26360i);
        }
        if ((i10 & 32) == 32) {
            this.f26361j = Collections.unmodifiableList(this.f26361j);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26354c = bVarV.u();
            throw th3;
        }
        this.f26354c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26367f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f26368g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f26369h = c.INV;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f26370i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f26371j;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26370i = list;
            this.f26371j = list;
            x();
        }

        public static b t() {
            return new b();
        }

        public b A(int i10) {
            this.f26365d |= 1;
            this.f26366e = i10;
            return this;
        }

        public b B(int i10) {
            this.f26365d |= 2;
            this.f26367f = i10;
            return this;
        }

        public b C(boolean z10) {
            this.f26365d |= 4;
            this.f26368g = z10;
            return this;
        }

        public b D(c cVar) {
            cVar.getClass();
            this.f26365d |= 8;
            this.f26369h = cVar;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public s build() {
            s sVarR = r();
            if (sVarR.d()) {
                return sVarR;
            }
            throw a.AbstractC0191a.h(sVarR);
        }

        public s r() {
            s sVar = new s(this);
            int i10 = this.f26365d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            sVar.f26356e = this.f26366e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            sVar.f26357f = this.f26367f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            sVar.f26358g = this.f26368g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            sVar.f26359h = this.f26369h;
            if ((this.f26365d & 16) == 16) {
                this.f26370i = Collections.unmodifiableList(this.f26370i);
                this.f26365d &= -17;
            }
            sVar.f26360i = this.f26370i;
            if ((this.f26365d & 32) == 32) {
                this.f26371j = Collections.unmodifiableList(this.f26371j);
                this.f26365d &= -33;
            }
            sVar.f26361j = this.f26371j;
            sVar.f26355d = i11;
            return sVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        public final void v() {
            if ((this.f26365d & 32) != 32) {
                this.f26371j = new ArrayList(this.f26371j);
                this.f26365d |= 32;
            }
        }

        public final void w() {
            if ((this.f26365d & 16) != 16) {
                this.f26370i = new ArrayList(this.f26370i);
                this.f26365d |= 16;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.s.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.s.f26353o     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.s r3 = (ze.s) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.s r4 = (ze.s) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.s.b.u(gf.e, gf.g):ze.s$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public b j(s sVar) {
            if (sVar == s.K()) {
                return this;
            }
            if (sVar.U()) {
                A(sVar.M());
            }
            if (sVar.V()) {
                B(sVar.N());
            }
            if (sVar.W()) {
                C(sVar.O());
            }
            if (sVar.X()) {
                D(sVar.T());
            }
            if (!sVar.f26360i.isEmpty()) {
                if (this.f26370i.isEmpty()) {
                    this.f26370i = sVar.f26360i;
                    this.f26365d &= -17;
                } else {
                    w();
                    this.f26370i.addAll(sVar.f26360i);
                }
            }
            if (!sVar.f26361j.isEmpty()) {
                if (this.f26371j.isEmpty()) {
                    this.f26371j = sVar.f26361j;
                    this.f26365d &= -33;
                } else {
                    v();
                    this.f26371j.addAll(sVar.f26361j);
                }
            }
            o(sVar);
            k(i().c(sVar.f26354c));
            return this;
        }

        private void x() {
        }
    }
}
