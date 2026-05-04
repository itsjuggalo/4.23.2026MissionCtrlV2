package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.t;
import ze.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends i.d implements gf.q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f26169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static gf.r f26170m = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f26173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f26174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f26175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f26176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f26177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f26178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26179k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public l c(gf.e eVar, gf.g gVar) {
            return new l(eVar, gVar);
        }
    }

    static {
        l lVar = new l(true);
        f26169l = lVar;
        lVar.Z();
    }

    public static l K() {
        return f26169l;
    }

    private void Z() {
        List list = Collections.EMPTY_LIST;
        this.f26173e = list;
        this.f26174f = list;
        this.f26175g = list;
        this.f26176h = t.w();
        this.f26177i = w.t();
    }

    public static b a0() {
        return b.t();
    }

    public static b b0(l lVar) {
        return a0().j(lVar);
    }

    public static l d0(InputStream inputStream, gf.g gVar) {
        return (l) f26170m.a(inputStream, gVar);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public l a() {
        return f26169l;
    }

    public i M(int i10) {
        return (i) this.f26173e.get(i10);
    }

    public int N() {
        return this.f26173e.size();
    }

    public List O() {
        return this.f26173e;
    }

    public n P(int i10) {
        return (n) this.f26174f.get(i10);
    }

    public int Q() {
        return this.f26174f.size();
    }

    public List R() {
        return this.f26174f;
    }

    public r S(int i10) {
        return (r) this.f26175g.get(i10);
    }

    public int T() {
        return this.f26175g.size();
    }

    public List U() {
        return this.f26175g;
    }

    public t V() {
        return this.f26176h;
    }

    public w W() {
        return this.f26177i;
    }

    public boolean X() {
        return (this.f26172d & 1) == 1;
    }

    public boolean Y() {
        return (this.f26172d & 2) == 2;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26179k;
        if (i10 != -1) {
            return i10;
        }
        int iR = 0;
        for (int i11 = 0; i11 < this.f26173e.size(); i11++) {
            iR += gf.f.r(3, (gf.p) this.f26173e.get(i11));
        }
        for (int i12 = 0; i12 < this.f26174f.size(); i12++) {
            iR += gf.f.r(4, (gf.p) this.f26174f.get(i12));
        }
        for (int i13 = 0; i13 < this.f26175g.size(); i13++) {
            iR += gf.f.r(5, (gf.p) this.f26175g.get(i13));
        }
        if ((this.f26172d & 1) == 1) {
            iR += gf.f.r(30, this.f26176h);
        }
        if ((this.f26172d & 2) == 2) {
            iR += gf.f.r(32, this.f26177i);
        }
        int iS = iR + s() + this.f26171c.size();
        this.f26179k = iS;
        return iS;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return a0();
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26178j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < N(); i10++) {
            if (!M(i10).d()) {
                this.f26178j = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < Q(); i11++) {
            if (!P(i11).d()) {
                this.f26178j = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < T(); i12++) {
            if (!S(i12).d()) {
                this.f26178j = (byte) 0;
                return false;
            }
        }
        if (X() && !V().d()) {
            this.f26178j = (byte) 0;
            return false;
        }
        if (r()) {
            this.f26178j = (byte) 1;
            return true;
        }
        this.f26178j = (byte) 0;
        return false;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return b0(this);
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        for (int i10 = 0; i10 < this.f26173e.size(); i10++) {
            fVar.c0(3, (gf.p) this.f26173e.get(i10));
        }
        for (int i11 = 0; i11 < this.f26174f.size(); i11++) {
            fVar.c0(4, (gf.p) this.f26174f.get(i11));
        }
        for (int i12 = 0; i12 < this.f26175g.size(); i12++) {
            fVar.c0(5, (gf.p) this.f26175g.get(i12));
        }
        if ((this.f26172d & 1) == 1) {
            fVar.c0(30, this.f26176h);
        }
        if ((this.f26172d & 2) == 2) {
            fVar.c0(32, this.f26177i);
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26171c);
    }

    public l(i.c cVar) {
        super(cVar);
        this.f26178j = (byte) -1;
        this.f26179k = -1;
        this.f26171c = cVar.i();
    }

    public l(boolean z10) {
        this.f26178j = (byte) -1;
        this.f26179k = -1;
        this.f26171c = gf.d.f10630a;
    }

    public l(gf.e eVar, gf.g gVar) {
        this.f26178j = (byte) -1;
        this.f26179k = -1;
        Z();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 26) {
                            int i11 = (i10 == true ? 1 : 0) & 1;
                            i10 = i10;
                            if (i11 != 1) {
                                this.f26173e = new ArrayList();
                                i10 = (i10 == true ? 1 : 0) | 1;
                            }
                            this.f26173e.add(eVar.t(i.f26120w, gVar));
                        } else if (iJ == 34) {
                            int i12 = (i10 == true ? 1 : 0) & 2;
                            i10 = i10;
                            if (i12 != 2) {
                                this.f26174f = new ArrayList();
                                i10 = (i10 == true ? 1 : 0) | 2;
                            }
                            this.f26174f.add(eVar.t(n.f26202w, gVar));
                        } else if (iJ != 42) {
                            if (iJ == 242) {
                                t.b bVarG = (this.f26172d & 1) == 1 ? this.f26176h.f() : null;
                                t tVar = (t) eVar.t(t.f26379i, gVar);
                                this.f26176h = tVar;
                                if (bVarG != null) {
                                    bVarG.j(tVar);
                                    this.f26176h = bVarG.n();
                                }
                                this.f26172d |= 1;
                            } else if (iJ != 258) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                w.b bVarF = (this.f26172d & 2) == 2 ? this.f26177i.f() : null;
                                w wVar = (w) eVar.t(w.f26440g, gVar);
                                this.f26177i = wVar;
                                if (bVarF != null) {
                                    bVarF.j(wVar);
                                    this.f26177i = bVarF.n();
                                }
                                this.f26172d |= 2;
                            }
                        } else {
                            int i13 = (i10 == true ? 1 : 0) & 4;
                            i10 = i10;
                            if (i13 != 4) {
                                this.f26175g = new ArrayList();
                                i10 = (i10 == true ? 1 : 0) | 4;
                            }
                            this.f26175g.add(eVar.t(r.f26328q, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((i10 == true ? 1 : 0) & 1) == 1) {
                        this.f26173e = Collections.unmodifiableList(this.f26173e);
                    }
                    if (((i10 == true ? 1 : 0) & 2) == 2) {
                        this.f26174f = Collections.unmodifiableList(this.f26174f);
                    }
                    if (((i10 == true ? 1 : 0) & 4) == 4) {
                        this.f26175g = Collections.unmodifiableList(this.f26175g);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26171c = bVarV.u();
                        throw th2;
                    }
                    this.f26171c = bVarV.u();
                    l();
                    throw th;
                }
            } catch (gf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new gf.k(e11.getMessage()).i(this);
            }
        }
        if (((i10 == true ? 1 : 0) & 1) == 1) {
            this.f26173e = Collections.unmodifiableList(this.f26173e);
        }
        if (((i10 == true ? 1 : 0) & 2) == 2) {
            this.f26174f = Collections.unmodifiableList(this.f26174f);
        }
        if (((i10 == true ? 1 : 0) & 4) == 4) {
            this.f26175g = Collections.unmodifiableList(this.f26175g);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26171c = bVarV.u();
            throw th3;
        }
        this.f26171c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f26181e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f26182f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f26183g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t f26184h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public w f26185i;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26181e = list;
            this.f26182f = list;
            this.f26183g = list;
            this.f26184h = t.w();
            this.f26185i = w.t();
            y();
        }

        public static b t() {
            return new b();
        }

        private void v() {
            if ((this.f26180d & 1) != 1) {
                this.f26181e = new ArrayList(this.f26181e);
                this.f26180d |= 1;
            }
        }

        private void w() {
            if ((this.f26180d & 2) != 2) {
                this.f26182f = new ArrayList(this.f26182f);
                this.f26180d |= 2;
            }
        }

        private void x() {
            if ((this.f26180d & 4) != 4) {
                this.f26183g = new ArrayList(this.f26183g);
                this.f26180d |= 4;
            }
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public b j(l lVar) {
            if (lVar == l.K()) {
                return this;
            }
            if (!lVar.f26173e.isEmpty()) {
                if (this.f26181e.isEmpty()) {
                    this.f26181e = lVar.f26173e;
                    this.f26180d &= -2;
                } else {
                    v();
                    this.f26181e.addAll(lVar.f26173e);
                }
            }
            if (!lVar.f26174f.isEmpty()) {
                if (this.f26182f.isEmpty()) {
                    this.f26182f = lVar.f26174f;
                    this.f26180d &= -3;
                } else {
                    w();
                    this.f26182f.addAll(lVar.f26174f);
                }
            }
            if (!lVar.f26175g.isEmpty()) {
                if (this.f26183g.isEmpty()) {
                    this.f26183g = lVar.f26175g;
                    this.f26180d &= -5;
                } else {
                    x();
                    this.f26183g.addAll(lVar.f26175g);
                }
            }
            if (lVar.X()) {
                B(lVar.V());
            }
            if (lVar.Y()) {
                C(lVar.W());
            }
            o(lVar);
            k(i().c(lVar.f26171c));
            return this;
        }

        public b B(t tVar) {
            if ((this.f26180d & 8) != 8 || this.f26184h == t.w()) {
                this.f26184h = tVar;
            } else {
                this.f26184h = t.E(this.f26184h).j(tVar).n();
            }
            this.f26180d |= 8;
            return this;
        }

        public b C(w wVar) {
            if ((this.f26180d & 16) != 16 || this.f26185i == w.t()) {
                this.f26185i = wVar;
            } else {
                this.f26185i = w.z(this.f26185i).j(wVar).n();
            }
            this.f26180d |= 16;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public l build() {
            l lVarR = r();
            if (lVarR.d()) {
                return lVarR;
            }
            throw a.AbstractC0191a.h(lVarR);
        }

        public l r() {
            l lVar = new l(this);
            int i10 = this.f26180d;
            if ((i10 & 1) == 1) {
                this.f26181e = Collections.unmodifiableList(this.f26181e);
                this.f26180d &= -2;
            }
            lVar.f26173e = this.f26181e;
            if ((this.f26180d & 2) == 2) {
                this.f26182f = Collections.unmodifiableList(this.f26182f);
                this.f26180d &= -3;
            }
            lVar.f26174f = this.f26182f;
            if ((this.f26180d & 4) == 4) {
                this.f26183g = Collections.unmodifiableList(this.f26183g);
                this.f26180d &= -5;
            }
            lVar.f26175g = this.f26183g;
            int i11 = (i10 & 8) != 8 ? 0 : 1;
            lVar.f26176h = this.f26184h;
            if ((i10 & 16) == 16) {
                i11 |= 2;
            }
            lVar.f26177i = this.f26185i;
            lVar.f26172d = i11;
            return lVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.l.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.l.f26170m     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.l r3 = (ze.l) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.l r4 = (ze.l) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.l.b.u(gf.e, gf.g):ze.l$b");
        }

        private void y() {
        }
    }
}
