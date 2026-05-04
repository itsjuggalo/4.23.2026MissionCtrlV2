package ze;

import gf.a;
import gf.d;
import gf.i;
import gf.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends gf.i implements gf.q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f26056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static gf.r f26057k = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f26060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f26061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f26062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f26063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f26064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26065i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public f c(gf.e eVar, gf.g gVar) {
            return new f(eVar, gVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c implements j.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26074e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26076a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.a(i10);
            }
        }

        c(int i10, int i11) {
            this.f26076a = i11;
        }

        public static c a(int i10) {
            if (i10 == 0) {
                return RETURNS_CONSTANT;
            }
            if (i10 == 1) {
                return CALLS;
            }
            if (i10 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26076a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d implements j.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static j.b f26080e = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26082a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.a(i10);
            }
        }

        d(int i10, int i11) {
            this.f26082a = i11;
        }

        public static d a(int i10) {
            if (i10 == 0) {
                return AT_MOST_ONCE;
            }
            if (i10 == 1) {
                return EXACTLY_ONCE;
            }
            if (i10 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26082a;
        }
    }

    static {
        f fVar = new f(true);
        f26056j = fVar;
        fVar.H();
    }

    private void H() {
        this.f26060d = c.RETURNS_CONSTANT;
        this.f26061e = Collections.EMPTY_LIST;
        this.f26062f = h.F();
        this.f26063g = d.AT_MOST_ONCE;
    }

    public static b I() {
        return b.p();
    }

    public static b J(f fVar) {
        return I().j(fVar);
    }

    public static f z() {
        return f26056j;
    }

    public h A(int i10) {
        return (h) this.f26061e.get(i10);
    }

    public int B() {
        return this.f26061e.size();
    }

    public c C() {
        return this.f26060d;
    }

    public d D() {
        return this.f26063g;
    }

    public boolean E() {
        return (this.f26059c & 2) == 2;
    }

    public boolean F() {
        return (this.f26059c & 1) == 1;
    }

    public boolean G() {
        return (this.f26059c & 4) == 4;
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
        int i10 = this.f26065i;
        if (i10 != -1) {
            return i10;
        }
        int iH = (this.f26059c & 1) == 1 ? gf.f.h(1, this.f26060d.d()) : 0;
        for (int i11 = 0; i11 < this.f26061e.size(); i11++) {
            iH += gf.f.r(2, (gf.p) this.f26061e.get(i11));
        }
        if ((this.f26059c & 2) == 2) {
            iH += gf.f.r(3, this.f26062f);
        }
        if ((this.f26059c & 4) == 4) {
            iH += gf.f.h(4, this.f26063g.d());
        }
        int size = iH + this.f26058b.size();
        this.f26065i = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26064h;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < B(); i10++) {
            if (!A(i10).d()) {
                this.f26064h = (byte) 0;
                return false;
            }
        }
        if (!E() || y().d()) {
            this.f26064h = (byte) 1;
            return true;
        }
        this.f26064h = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        if ((this.f26059c & 1) == 1) {
            fVar.R(1, this.f26060d.d());
        }
        for (int i10 = 0; i10 < this.f26061e.size(); i10++) {
            fVar.c0(2, (gf.p) this.f26061e.get(i10));
        }
        if ((this.f26059c & 2) == 2) {
            fVar.c0(3, this.f26062f);
        }
        if ((this.f26059c & 4) == 4) {
            fVar.R(4, this.f26063g.d());
        }
        fVar.h0(this.f26058b);
    }

    public h y() {
        return this.f26062f;
    }

    public f(i.b bVar) {
        super(bVar);
        this.f26064h = (byte) -1;
        this.f26065i = -1;
        this.f26058b = bVar.i();
    }

    public f(boolean z10) {
        this.f26064h = (byte) -1;
        this.f26065i = -1;
        this.f26058b = gf.d.f10630a;
    }

    public f(gf.e eVar, gf.g gVar) {
        this.f26064h = (byte) -1;
        this.f26065i = -1;
        H();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        char c10 = 0;
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
                                this.f26059c |= 1;
                                this.f26060d = cVarA;
                            }
                        } else if (iJ == 18) {
                            if ((c10 & 2) != 2) {
                                this.f26061e = new ArrayList();
                                c10 = 2;
                            }
                            this.f26061e.add(eVar.t(h.f26093n, gVar));
                        } else if (iJ == 26) {
                            h.b bVarF = (this.f26059c & 2) == 2 ? this.f26062f.f() : null;
                            h hVar = (h) eVar.t(h.f26093n, gVar);
                            this.f26062f = hVar;
                            if (bVarF != null) {
                                bVarF.j(hVar);
                                this.f26062f = bVarF.n();
                            }
                            this.f26059c |= 2;
                        } else if (iJ != 32) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            int iM2 = eVar.m();
                            d dVarA = d.a(iM2);
                            if (dVarA == null) {
                                fVarI.n0(iJ);
                                fVarI.n0(iM2);
                            } else {
                                this.f26059c |= 4;
                                this.f26063g = dVarA;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.f26061e = Collections.unmodifiableList(this.f26061e);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26058b = bVarV.u();
                        throw th2;
                    }
                    this.f26058b = bVarV.u();
                    l();
                    throw th;
                }
            } catch (gf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new gf.k(e11.getMessage()).i(this);
            }
        }
        if ((c10 & 2) == 2) {
            this.f26061e = Collections.unmodifiableList(this.f26061e);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26058b = bVarV.u();
            throw th3;
        }
        this.f26058b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f26067c = c.RETURNS_CONSTANT;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f26068d = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h f26069e = h.F();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d f26070f = d.AT_MOST_ONCE;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public f build() {
            f fVarN = n();
            if (fVarN.d()) {
                return fVarN;
            }
            throw a.AbstractC0191a.h(fVarN);
        }

        public f n() {
            f fVar = new f(this);
            int i10 = this.f26066b;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            fVar.f26060d = this.f26067c;
            if ((this.f26066b & 2) == 2) {
                this.f26068d = Collections.unmodifiableList(this.f26068d);
                this.f26066b &= -3;
            }
            fVar.f26061e = this.f26068d;
            if ((i10 & 4) == 4) {
                i11 |= 2;
            }
            fVar.f26062f = this.f26069e;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            fVar.f26063g = this.f26070f;
            fVar.f26059c = i11;
            return fVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26066b & 2) != 2) {
                this.f26068d = new ArrayList(this.f26068d);
                this.f26066b |= 2;
            }
        }

        public b s(h hVar) {
            if ((this.f26066b & 4) != 4 || this.f26069e == h.F()) {
                this.f26069e = hVar;
            } else {
                this.f26069e = h.T(this.f26069e).j(hVar).n();
            }
            this.f26066b |= 4;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.f.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.f.f26057k     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.f r3 = (ze.f) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.f r4 = (ze.f) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.f.b.u(gf.e, gf.g):ze.f$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b j(f fVar) {
            if (fVar == f.z()) {
                return this;
            }
            if (fVar.F()) {
                w(fVar.C());
            }
            if (!fVar.f26061e.isEmpty()) {
                if (this.f26068d.isEmpty()) {
                    this.f26068d = fVar.f26061e;
                    this.f26066b &= -3;
                } else {
                    q();
                    this.f26068d.addAll(fVar.f26061e);
                }
            }
            if (fVar.E()) {
                s(fVar.y());
            }
            if (fVar.G()) {
                x(fVar.D());
            }
            k(i().c(fVar.f26058b));
            return this;
        }

        public b w(c cVar) {
            cVar.getClass();
            this.f26066b |= 1;
            this.f26067c = cVar;
            return this;
        }

        public b x(d dVar) {
            dVar.getClass();
            this.f26066b |= 8;
            this.f26070f = dVar;
            return this;
        }

        private void r() {
        }
    }
}
