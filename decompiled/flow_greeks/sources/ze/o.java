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
public final class o extends gf.i implements gf.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f26237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static gf.r f26238g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f26241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26242e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public o c(gf.e eVar, gf.g gVar) {
            return new o(eVar, gVar);
        }
    }

    static {
        o oVar = new o(true);
        f26237f = oVar;
        oVar.x();
    }

    public static o t() {
        return f26237f;
    }

    private void x() {
        this.f26240c = Collections.EMPTY_LIST;
    }

    public static b y() {
        return b.p();
    }

    public static b z(o oVar) {
        return y().j(oVar);
    }

    @Override // gf.p
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b c() {
        return y();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b f() {
        return z(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26242e;
        if (i10 != -1) {
            return i10;
        }
        int iR = 0;
        for (int i11 = 0; i11 < this.f26240c.size(); i11++) {
            iR += gf.f.r(1, (gf.p) this.f26240c.get(i11));
        }
        int size = iR + this.f26239b.size();
        this.f26242e = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26241d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < w(); i10++) {
            if (!v(i10).d()) {
                this.f26241d = (byte) 0;
                return false;
            }
        }
        this.f26241d = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        for (int i10 = 0; i10 < this.f26240c.size(); i10++) {
            fVar.c0(1, (gf.p) this.f26240c.get(i10));
        }
        fVar.h0(this.f26239b);
    }

    public c v(int i10) {
        return (c) this.f26240c.get(i10);
    }

    public int w() {
        return this.f26240c.size();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends gf.i implements gf.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f26245i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static gf.r f26246j = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f26247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26250e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EnumC0495c f26251f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f26252g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f26253h;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public c c(gf.e eVar, gf.g gVar) {
                return new c(eVar, gVar);
            }
        }

        /* JADX INFO: renamed from: ze.o$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum EnumC0495c implements j.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static j.b f26261e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f26263a;

            /* JADX INFO: renamed from: ze.o$c$c$a */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class a implements j.b {
                @Override // gf.j.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0495c a(int i10) {
                    return EnumC0495c.a(i10);
                }
            }

            EnumC0495c(int i10, int i11) {
                this.f26263a = i11;
            }

            public static EnumC0495c a(int i10) {
                if (i10 == 0) {
                    return CLASS;
                }
                if (i10 == 1) {
                    return PACKAGE;
                }
                if (i10 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // gf.j.a
            public final int d() {
                return this.f26263a;
            }
        }

        static {
            c cVar = new c(true);
            f26245i = cVar;
            cVar.D();
        }

        private void D() {
            this.f26249d = -1;
            this.f26250e = 0;
            this.f26251f = EnumC0495c.PACKAGE;
        }

        public static b E() {
            return b.p();
        }

        public static b F(c cVar) {
            return E().j(cVar);
        }

        public static c w() {
            return f26245i;
        }

        public boolean A() {
            return (this.f26248c & 4) == 4;
        }

        public boolean B() {
            return (this.f26248c & 1) == 1;
        }

        public boolean C() {
            return (this.f26248c & 2) == 2;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b c() {
            return E();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public b f() {
            return F(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f26253h;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f26248c & 1) == 1 ? gf.f.o(1, this.f26249d) : 0;
            if ((this.f26248c & 2) == 2) {
                iO += gf.f.o(2, this.f26250e);
            }
            if ((this.f26248c & 4) == 4) {
                iO += gf.f.h(3, this.f26251f.d());
            }
            int size = iO + this.f26247b.size();
            this.f26253h = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f26252g;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (C()) {
                this.f26252g = (byte) 1;
                return true;
            }
            this.f26252g = (byte) 0;
            return false;
        }

        @Override // gf.p
        public void g(gf.f fVar) throws IOException {
            b();
            if ((this.f26248c & 1) == 1) {
                fVar.Z(1, this.f26249d);
            }
            if ((this.f26248c & 2) == 2) {
                fVar.Z(2, this.f26250e);
            }
            if ((this.f26248c & 4) == 4) {
                fVar.R(3, this.f26251f.d());
            }
            fVar.h0(this.f26247b);
        }

        public EnumC0495c x() {
            return this.f26251f;
        }

        public int y() {
            return this.f26249d;
        }

        public int z() {
            return this.f26250e;
        }

        public c(i.b bVar) {
            super(bVar);
            this.f26252g = (byte) -1;
            this.f26253h = -1;
            this.f26247b = bVar.i();
        }

        public c(boolean z10) {
            this.f26252g = (byte) -1;
            this.f26253h = -1;
            this.f26247b = gf.d.f10630a;
        }

        public c(gf.e eVar, gf.g gVar) {
            this.f26252g = (byte) -1;
            this.f26253h = -1;
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
                                this.f26248c |= 1;
                                this.f26249d = eVar.r();
                            } else if (iJ == 16) {
                                this.f26248c |= 2;
                                this.f26250e = eVar.r();
                            } else if (iJ != 24) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                int iM = eVar.m();
                                EnumC0495c enumC0495cA = EnumC0495c.a(iM);
                                if (enumC0495cA == null) {
                                    fVarI.n0(iJ);
                                    fVarI.n0(iM);
                                } else {
                                    this.f26248c |= 4;
                                    this.f26251f = enumC0495cA;
                                }
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
                        this.f26247b = bVarV.u();
                        throw th2;
                    }
                    this.f26247b = bVarV.u();
                    l();
                    throw th;
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f26247b = bVarV.u();
                throw th3;
            }
            this.f26247b = bVarV.u();
            l();
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends i.b implements gf.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f26254b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f26256d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f26255c = -1;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public EnumC0495c f26257e = EnumC0495c.PACKAGE;

            public b() {
                q();
            }

            public static b p() {
                return new b();
            }

            @Override // gf.p.a
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c build() {
                c cVarN = n();
                if (cVarN.d()) {
                    return cVarN;
                }
                throw a.AbstractC0191a.h(cVarN);
            }

            public c n() {
                c cVar = new c(this);
                int i10 = this.f26254b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.f26249d = this.f26255c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.f26250e = this.f26256d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                cVar.f26251f = this.f26257e;
                cVar.f26248c = i11;
                return cVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return p().j(n());
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ze.o.c.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = ze.o.c.f26246j     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    ze.o$c r3 = (ze.o.c) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    ze.o$c r4 = (ze.o.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ze.o.c.b.u(gf.e, gf.g):ze.o$c$b");
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b j(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.B()) {
                    v(cVar.y());
                }
                if (cVar.C()) {
                    w(cVar.z());
                }
                if (cVar.A()) {
                    t(cVar.x());
                }
                k(i().c(cVar.f26247b));
                return this;
            }

            public b t(EnumC0495c enumC0495c) {
                enumC0495c.getClass();
                this.f26254b |= 4;
                this.f26257e = enumC0495c;
                return this;
            }

            public b v(int i10) {
                this.f26254b |= 1;
                this.f26255c = i10;
                return this;
            }

            public b w(int i10) {
                this.f26254b |= 2;
                this.f26256d = i10;
                return this;
            }

            private void q() {
            }
        }
    }

    public o(i.b bVar) {
        super(bVar);
        this.f26241d = (byte) -1;
        this.f26242e = -1;
        this.f26239b = bVar.i();
    }

    public o(boolean z10) {
        this.f26241d = (byte) -1;
        this.f26242e = -1;
        this.f26239b = gf.d.f10630a;
    }

    public o(gf.e eVar, gf.g gVar) {
        this.f26241d = (byte) -1;
        this.f26242e = -1;
        x();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ != 10) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                if (!z11) {
                                    this.f26240c = new ArrayList();
                                    z11 = true;
                                }
                                this.f26240c.add(eVar.t(c.f26246j, gVar));
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
                if (z11) {
                    this.f26240c = Collections.unmodifiableList(this.f26240c);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26239b = bVarV.u();
                    throw th2;
                }
                this.f26239b = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26240c = Collections.unmodifiableList(this.f26240c);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26239b = bVarV.u();
            throw th3;
        }
        this.f26239b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f26244c = Collections.EMPTY_LIST;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public o build() {
            o oVarN = n();
            if (oVarN.d()) {
                return oVarN;
            }
            throw a.AbstractC0191a.h(oVarN);
        }

        public o n() {
            o oVar = new o(this);
            if ((this.f26243b & 1) == 1) {
                this.f26244c = Collections.unmodifiableList(this.f26244c);
                this.f26243b &= -2;
            }
            oVar.f26240c = this.f26244c;
            return oVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26243b & 1) != 1) {
                this.f26244c = new ArrayList(this.f26244c);
                this.f26243b |= 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.o.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.o.f26238g     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.o r3 = (ze.o) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.o r4 = (ze.o) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.o.b.u(gf.e, gf.g):ze.o$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b j(o oVar) {
            if (oVar == o.t()) {
                return this;
            }
            if (!oVar.f26240c.isEmpty()) {
                if (this.f26244c.isEmpty()) {
                    this.f26244c = oVar.f26240c;
                    this.f26243b &= -2;
                } else {
                    q();
                    this.f26244c.addAll(oVar.f26240c);
                }
            }
            k(i().c(oVar.f26239b));
            return this;
        }

        private void r() {
        }
    }
}
