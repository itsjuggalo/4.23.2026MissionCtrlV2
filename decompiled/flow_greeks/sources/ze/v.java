package ze;

import gf.a;
import gf.d;
import gf.i;
import gf.j;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends gf.i implements gf.q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f26408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static gf.r f26409m = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f26414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f26417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f26418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26419k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public v c(gf.e eVar, gf.g gVar) {
            return new v(eVar, gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c implements j.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26430e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26432a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.a(i10);
            }
        }

        c(int i10, int i11) {
            this.f26432a = i11;
        }

        public static c a(int i10) {
            if (i10 == 0) {
                return WARNING;
            }
            if (i10 == 1) {
                return ERROR;
            }
            if (i10 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26432a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d implements j.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26436e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26438a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.a(i10);
            }
        }

        d(int i10, int i11) {
            this.f26438a = i11;
        }

        public static d a(int i10) {
            if (i10 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i10 == 1) {
                return COMPILER_VERSION;
            }
            if (i10 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26438a;
        }
    }

    static {
        v vVar = new v(true);
        f26408l = vVar;
        vVar.M();
    }

    private void M() {
        this.f26412d = 0;
        this.f26413e = 0;
        this.f26414f = c.ERROR;
        this.f26415g = 0;
        this.f26416h = 0;
        this.f26417i = d.LANGUAGE_VERSION;
    }

    public static b N() {
        return b.p();
    }

    public static b O(v vVar) {
        return N().j(vVar);
    }

    public static v z() {
        return f26408l;
    }

    public int A() {
        return this.f26415g;
    }

    public c B() {
        return this.f26414f;
    }

    public int C() {
        return this.f26416h;
    }

    public int D() {
        return this.f26412d;
    }

    public int E() {
        return this.f26413e;
    }

    public d F() {
        return this.f26417i;
    }

    public boolean G() {
        return (this.f26411c & 8) == 8;
    }

    public boolean H() {
        return (this.f26411c & 4) == 4;
    }

    public boolean I() {
        return (this.f26411c & 16) == 16;
    }

    public boolean J() {
        return (this.f26411c & 1) == 1;
    }

    public boolean K() {
        return (this.f26411c & 2) == 2;
    }

    public boolean L() {
        return (this.f26411c & 32) == 32;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public b c() {
        return N();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b f() {
        return O(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26419k;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26411c & 1) == 1 ? gf.f.o(1, this.f26412d) : 0;
        if ((this.f26411c & 2) == 2) {
            iO += gf.f.o(2, this.f26413e);
        }
        if ((this.f26411c & 4) == 4) {
            iO += gf.f.h(3, this.f26414f.d());
        }
        if ((this.f26411c & 8) == 8) {
            iO += gf.f.o(4, this.f26415g);
        }
        if ((this.f26411c & 16) == 16) {
            iO += gf.f.o(5, this.f26416h);
        }
        if ((this.f26411c & 32) == 32) {
            iO += gf.f.h(6, this.f26417i.d());
        }
        int size = iO + this.f26410b.size();
        this.f26419k = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26418j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f26418j = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        if ((this.f26411c & 1) == 1) {
            fVar.Z(1, this.f26412d);
        }
        if ((this.f26411c & 2) == 2) {
            fVar.Z(2, this.f26413e);
        }
        if ((this.f26411c & 4) == 4) {
            fVar.R(3, this.f26414f.d());
        }
        if ((this.f26411c & 8) == 8) {
            fVar.Z(4, this.f26415g);
        }
        if ((this.f26411c & 16) == 16) {
            fVar.Z(5, this.f26416h);
        }
        if ((this.f26411c & 32) == 32) {
            fVar.R(6, this.f26417i.d());
        }
        fVar.h0(this.f26410b);
    }

    public v(i.b bVar) {
        super(bVar);
        this.f26418j = (byte) -1;
        this.f26419k = -1;
        this.f26410b = bVar.i();
    }

    public v(boolean z10) {
        this.f26418j = (byte) -1;
        this.f26419k = -1;
        this.f26410b = gf.d.f10630a;
    }

    public v(gf.e eVar, gf.g gVar) {
        this.f26418j = (byte) -1;
        this.f26419k = -1;
        M();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f26411c |= 1;
                            this.f26412d = eVar.r();
                        } else if (iJ == 16) {
                            this.f26411c |= 2;
                            this.f26413e = eVar.r();
                        } else if (iJ == 24) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                fVarI.n0(iJ);
                                fVarI.n0(iM);
                            } else {
                                this.f26411c |= 4;
                                this.f26414f = cVarA;
                            }
                        } else if (iJ == 32) {
                            this.f26411c |= 8;
                            this.f26415g = eVar.r();
                        } else if (iJ == 40) {
                            this.f26411c |= 16;
                            this.f26416h = eVar.r();
                        } else if (iJ != 48) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            int iM2 = eVar.m();
                            d dVarA = d.a(iM2);
                            if (dVarA == null) {
                                fVarI.n0(iJ);
                                fVarI.n0(iM2);
                            } else {
                                this.f26411c |= 32;
                                this.f26417i = dVarA;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26410b = bVarV.u();
                        throw th2;
                    }
                    this.f26410b = bVarV.u();
                    l();
                    throw th;
                }
            } catch (gf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new gf.k(e11.getMessage()).i(this);
            }
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26410b = bVarV.u();
            throw th3;
        }
        this.f26410b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26422d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26424f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26425g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f26423e = c.ERROR;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f26426h = d.LANGUAGE_VERSION;

        public b() {
            q();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public v build() {
            v vVarN = n();
            if (vVarN.d()) {
                return vVarN;
            }
            throw a.AbstractC0191a.h(vVarN);
        }

        public v n() {
            v vVar = new v(this);
            int i10 = this.f26420b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            vVar.f26412d = this.f26421c;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            vVar.f26413e = this.f26422d;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            vVar.f26414f = this.f26423e;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            vVar.f26415g = this.f26424f;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            vVar.f26416h = this.f26425g;
            if ((i10 & 32) == 32) {
                i11 |= 32;
            }
            vVar.f26417i = this.f26426h;
            vVar.f26411c = i11;
            return vVar;
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
        public ze.v.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.v.f26409m     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.v r3 = (ze.v) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.v r4 = (ze.v) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.v.b.u(gf.e, gf.g):ze.v$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b j(v vVar) {
            if (vVar == v.z()) {
                return this;
            }
            if (vVar.J()) {
                x(vVar.D());
            }
            if (vVar.K()) {
                y(vVar.E());
            }
            if (vVar.H()) {
                v(vVar.B());
            }
            if (vVar.G()) {
                t(vVar.A());
            }
            if (vVar.I()) {
                w(vVar.C());
            }
            if (vVar.L()) {
                z(vVar.F());
            }
            k(i().c(vVar.f26410b));
            return this;
        }

        public b t(int i10) {
            this.f26420b |= 8;
            this.f26424f = i10;
            return this;
        }

        public b v(c cVar) {
            cVar.getClass();
            this.f26420b |= 4;
            this.f26423e = cVar;
            return this;
        }

        public b w(int i10) {
            this.f26420b |= 16;
            this.f26425g = i10;
            return this;
        }

        public b x(int i10) {
            this.f26420b |= 1;
            this.f26421c = i10;
            return this;
        }

        public b y(int i10) {
            this.f26420b |= 2;
            this.f26422d = i10;
            return this;
        }

        public b z(d dVar) {
            dVar.getClass();
            this.f26420b |= 32;
            this.f26426h = dVar;
            return this;
        }

        private void q() {
        }
    }
}
