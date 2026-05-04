package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends i.d implements gf.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f26083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static gf.r f26084i = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f26088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26089g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public g c(gf.e eVar, gf.g gVar) {
            return new g(eVar, gVar);
        }
    }

    static {
        g gVar = new g(true);
        f26083h = gVar;
        gVar.H();
    }

    public static g D() {
        return f26083h;
    }

    private void H() {
        this.f26087e = 0;
    }

    public static b I() {
        return b.t();
    }

    public static b J(g gVar) {
        return I().j(gVar);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public g a() {
        return f26083h;
    }

    public int F() {
        return this.f26087e;
    }

    public boolean G() {
        return (this.f26086d & 1) == 1;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b c() {
        return I();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b f() {
        return J(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26089g;
        if (i10 != -1) {
            return i10;
        }
        int iO = ((this.f26086d & 1) == 1 ? gf.f.o(1, this.f26087e) : 0) + s() + this.f26085c.size();
        this.f26089g = iO;
        return iO;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26088f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (r()) {
            this.f26088f = (byte) 1;
            return true;
        }
        this.f26088f = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26086d & 1) == 1) {
            fVar.Z(1, this.f26087e);
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26085c);
    }

    public g(i.c cVar) {
        super(cVar);
        this.f26088f = (byte) -1;
        this.f26089g = -1;
        this.f26085c = cVar.i();
    }

    public g(boolean z10) {
        this.f26088f = (byte) -1;
        this.f26089g = -1;
        this.f26085c = gf.d.f10630a;
    }

    public g(gf.e eVar, gf.g gVar) {
        this.f26088f = (byte) -1;
        this.f26089g = -1;
        H();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ != 8) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            this.f26086d |= 1;
                            this.f26087e = eVar.r();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26085c = bVarV.u();
                        throw th2;
                    }
                    this.f26085c = bVarV.u();
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
            this.f26085c = bVarV.u();
            throw th3;
        }
        this.f26085c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26091e;

        public b() {
            v();
        }

        public static b t() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public g build() {
            g gVarR = r();
            if (gVarR.d()) {
                return gVarR;
            }
            throw a.AbstractC0191a.h(gVarR);
        }

        public g r() {
            g gVar = new g(this);
            int i10 = (this.f26090d & 1) != 1 ? 0 : 1;
            gVar.f26087e = this.f26091e;
            gVar.f26086d = i10;
            return gVar;
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
        public ze.g.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.g.f26084i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.g r3 = (ze.g) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.g r4 = (ze.g) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.g.b.u(gf.e, gf.g):ze.g$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b j(g gVar) {
            if (gVar == g.D()) {
                return this;
            }
            if (gVar.G()) {
                y(gVar.F());
            }
            o(gVar);
            k(i().c(gVar.f26085c));
            return this;
        }

        public b y(int i10) {
            this.f26090d |= 1;
            this.f26091e = i10;
            return this;
        }

        private void v() {
        }
    }
}
