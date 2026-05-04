package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends gf.i implements gf.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f26264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static gf.r f26265g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gf.n f26267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f26268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26269e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public p c(gf.e eVar, gf.g gVar) {
            return new p(eVar, gVar);
        }
    }

    static {
        p pVar = new p(true);
        f26264f = pVar;
        pVar.x();
    }

    public static p t() {
        return f26264f;
    }

    private void x() {
        this.f26267c = gf.m.f10689b;
    }

    public static b y() {
        return b.p();
    }

    public static b z(p pVar) {
        return y().j(pVar);
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
        int i10 = this.f26269e;
        if (i10 != -1) {
            return i10;
        }
        int iE = 0;
        for (int i11 = 0; i11 < this.f26267c.size(); i11++) {
            iE += gf.f.e(this.f26267c.H(i11));
        }
        int size = iE + w().size() + this.f26266b.size();
        this.f26269e = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26268d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f26268d = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        for (int i10 = 0; i10 < this.f26267c.size(); i10++) {
            fVar.N(1, this.f26267c.H(i10));
        }
        fVar.h0(this.f26266b);
    }

    public String v(int i10) {
        return (String) this.f26267c.get(i10);
    }

    public gf.s w() {
        return this.f26267c;
    }

    public p(i.b bVar) {
        super(bVar);
        this.f26268d = (byte) -1;
        this.f26269e = -1;
        this.f26266b = bVar.i();
    }

    public p(boolean z10) {
        this.f26268d = (byte) -1;
        this.f26269e = -1;
        this.f26266b = gf.d.f10630a;
    }

    public p(gf.e eVar, gf.g gVar) {
        this.f26268d = (byte) -1;
        this.f26269e = -1;
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
                                gf.d dVarK = eVar.k();
                                if (!z11) {
                                    this.f26267c = new gf.m();
                                    z11 = true;
                                }
                                this.f26267c.B(dVarK);
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
                    this.f26267c = this.f26267c.l();
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26266b = bVarV.u();
                    throw th2;
                }
                this.f26266b = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26267c = this.f26267c.l();
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26266b = bVarV.u();
            throw th3;
        }
        this.f26266b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gf.n f26271c = gf.m.f10689b;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public p build() {
            p pVarN = n();
            if (pVarN.d()) {
                return pVarN;
            }
            throw a.AbstractC0191a.h(pVarN);
        }

        public p n() {
            p pVar = new p(this);
            if ((this.f26270b & 1) == 1) {
                this.f26271c = this.f26271c.l();
                this.f26270b &= -2;
            }
            pVar.f26267c = this.f26271c;
            return pVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26270b & 1) != 1) {
                this.f26271c = new gf.m(this.f26271c);
                this.f26270b |= 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.p.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.p.f26265g     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.p r3 = (ze.p) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.p r4 = (ze.p) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.p.b.u(gf.e, gf.g):ze.p$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b j(p pVar) {
            if (pVar == p.t()) {
                return this;
            }
            if (!pVar.f26267c.isEmpty()) {
                if (this.f26271c.isEmpty()) {
                    this.f26271c = pVar.f26267c;
                    this.f26270b &= -2;
                } else {
                    q();
                    this.f26271c.addAll(pVar.f26267c);
                }
            }
            k(i().c(pVar.f26266b));
            return this;
        }

        private void r() {
        }
    }
}
