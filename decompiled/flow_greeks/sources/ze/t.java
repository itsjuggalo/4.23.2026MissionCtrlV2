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
public final class t extends gf.i implements gf.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final t f26378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static gf.r f26379i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f26382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f26384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26385g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public t c(gf.e eVar, gf.g gVar) {
            return new t(eVar, gVar);
        }
    }

    static {
        t tVar = new t(true);
        f26378h = tVar;
        tVar.C();
    }

    private void C() {
        this.f26382d = Collections.EMPTY_LIST;
        this.f26383e = -1;
    }

    public static b D() {
        return b.p();
    }

    public static b E(t tVar) {
        return D().j(tVar);
    }

    public static t w() {
        return f26378h;
    }

    public List A() {
        return this.f26382d;
    }

    public boolean B() {
        return (this.f26381c & 1) == 1;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public b c() {
        return D();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public b f() {
        return E(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26385g;
        if (i10 != -1) {
            return i10;
        }
        int iO = 0;
        for (int i11 = 0; i11 < this.f26382d.size(); i11++) {
            iO += gf.f.r(1, (gf.p) this.f26382d.get(i11));
        }
        if ((this.f26381c & 1) == 1) {
            iO += gf.f.o(2, this.f26383e);
        }
        int size = iO + this.f26380b.size();
        this.f26385g = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26384f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < z(); i10++) {
            if (!y(i10).d()) {
                this.f26384f = (byte) 0;
                return false;
            }
        }
        this.f26384f = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        for (int i10 = 0; i10 < this.f26382d.size(); i10++) {
            fVar.c0(1, (gf.p) this.f26382d.get(i10));
        }
        if ((this.f26381c & 1) == 1) {
            fVar.Z(2, this.f26383e);
        }
        fVar.h0(this.f26380b);
    }

    public int x() {
        return this.f26383e;
    }

    public q y(int i10) {
        return (q) this.f26382d.get(i10);
    }

    public int z() {
        return this.f26382d.size();
    }

    public t(i.b bVar) {
        super(bVar);
        this.f26384f = (byte) -1;
        this.f26385g = -1;
        this.f26380b = bVar.i();
    }

    public t(boolean z10) {
        this.f26384f = (byte) -1;
        this.f26385g = -1;
        this.f26380b = gf.d.f10630a;
    }

    public t(gf.e eVar, gf.g gVar) {
        this.f26384f = (byte) -1;
        this.f26385g = -1;
        C();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 10) {
                            if (!z11) {
                                this.f26382d = new ArrayList();
                                z11 = true;
                            }
                            this.f26382d.add(eVar.t(q.f26273v, gVar));
                        } else if (iJ != 16) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            this.f26381c |= 1;
                            this.f26383e = eVar.r();
                        }
                    }
                    z10 = true;
                } catch (gf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z11) {
                    this.f26382d = Collections.unmodifiableList(this.f26382d);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26380b = bVarV.u();
                    throw th2;
                }
                this.f26380b = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26382d = Collections.unmodifiableList(this.f26382d);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26380b = bVarV.u();
            throw th3;
        }
        this.f26380b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f26387c = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26388d = -1;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public t build() {
            t tVarN = n();
            if (tVarN.d()) {
                return tVarN;
            }
            throw a.AbstractC0191a.h(tVarN);
        }

        public t n() {
            t tVar = new t(this);
            int i10 = this.f26386b;
            if ((i10 & 1) == 1) {
                this.f26387c = Collections.unmodifiableList(this.f26387c);
                this.f26386b &= -2;
            }
            tVar.f26382d = this.f26387c;
            int i11 = (i10 & 2) != 2 ? 0 : 1;
            tVar.f26383e = this.f26388d;
            tVar.f26381c = i11;
            return tVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26386b & 1) != 1) {
                this.f26387c = new ArrayList(this.f26387c);
                this.f26386b |= 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.t.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.t.f26379i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.t r3 = (ze.t) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.t r4 = (ze.t) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.t.b.u(gf.e, gf.g):ze.t$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b j(t tVar) {
            if (tVar == t.w()) {
                return this;
            }
            if (!tVar.f26382d.isEmpty()) {
                if (this.f26387c.isEmpty()) {
                    this.f26387c = tVar.f26382d;
                    this.f26386b &= -2;
                } else {
                    q();
                    this.f26387c.addAll(tVar.f26382d);
                }
            }
            if (tVar.B()) {
                v(tVar.x());
            }
            k(i().c(tVar.f26380b));
            return this;
        }

        public b v(int i10) {
            this.f26386b |= 2;
            this.f26388d = i10;
            return this;
        }

        private void r() {
        }
    }
}
