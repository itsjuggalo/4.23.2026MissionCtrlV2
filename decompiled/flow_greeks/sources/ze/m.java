package ze;

import gf.a;
import gf.d;
import gf.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.l;
import ze.o;
import ze.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends i.d implements gf.q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f26186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static gf.r f26187l = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f26190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f26191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f26192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f26193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f26194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f26195j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public m c(gf.e eVar, gf.g gVar) {
            return new m(eVar, gVar);
        }
    }

    static {
        m mVar = new m(true);
        f26186k = mVar;
        mVar.S();
    }

    public static m K() {
        return f26186k;
    }

    private void S() {
        this.f26190e = p.t();
        this.f26191f = o.t();
        this.f26192g = l.K();
        this.f26193h = Collections.EMPTY_LIST;
    }

    public static b T() {
        return b.t();
    }

    public static b U(m mVar) {
        return T().j(mVar);
    }

    public static m W(InputStream inputStream, gf.g gVar) {
        return (m) f26187l.a(inputStream, gVar);
    }

    public c H(int i10) {
        return (c) this.f26193h.get(i10);
    }

    public int I() {
        return this.f26193h.size();
    }

    public List J() {
        return this.f26193h;
    }

    @Override // gf.q
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public m a() {
        return f26186k;
    }

    public l M() {
        return this.f26192g;
    }

    public o N() {
        return this.f26191f;
    }

    public p O() {
        return this.f26190e;
    }

    public boolean P() {
        return (this.f26189d & 4) == 4;
    }

    public boolean Q() {
        return (this.f26189d & 2) == 2;
    }

    public boolean R() {
        return (this.f26189d & 1) == 1;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b c() {
        return T();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public b f() {
        return U(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26195j;
        if (i10 != -1) {
            return i10;
        }
        int iR = (this.f26189d & 1) == 1 ? gf.f.r(1, this.f26190e) : 0;
        if ((this.f26189d & 2) == 2) {
            iR += gf.f.r(2, this.f26191f);
        }
        if ((this.f26189d & 4) == 4) {
            iR += gf.f.r(3, this.f26192g);
        }
        for (int i11 = 0; i11 < this.f26193h.size(); i11++) {
            iR += gf.f.r(4, (gf.p) this.f26193h.get(i11));
        }
        int iS = iR + s() + this.f26188c.size();
        this.f26195j = iS;
        return iS;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26194i;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (Q() && !N().d()) {
            this.f26194i = (byte) 0;
            return false;
        }
        if (P() && !M().d()) {
            this.f26194i = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < I(); i10++) {
            if (!H(i10).d()) {
                this.f26194i = (byte) 0;
                return false;
            }
        }
        if (r()) {
            this.f26194i = (byte) 1;
            return true;
        }
        this.f26194i = (byte) 0;
        return false;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26189d & 1) == 1) {
            fVar.c0(1, this.f26190e);
        }
        if ((this.f26189d & 2) == 2) {
            fVar.c0(2, this.f26191f);
        }
        if ((this.f26189d & 4) == 4) {
            fVar.c0(3, this.f26192g);
        }
        for (int i10 = 0; i10 < this.f26193h.size(); i10++) {
            fVar.c0(4, (gf.p) this.f26193h.get(i10));
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26188c);
    }

    public m(i.c cVar) {
        super(cVar);
        this.f26194i = (byte) -1;
        this.f26195j = -1;
        this.f26188c = cVar.i();
    }

    public m(boolean z10) {
        this.f26194i = (byte) -1;
        this.f26195j = -1;
        this.f26188c = gf.d.f10630a;
    }

    public m(gf.e eVar, gf.g gVar) {
        this.f26194i = (byte) -1;
        this.f26195j = -1;
        S();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                p.b bVarB = (this.f26189d & 1) == 1 ? this.f26190e.f() : null;
                                p pVar = (p) eVar.t(p.f26265g, gVar);
                                this.f26190e = pVar;
                                if (bVarB != null) {
                                    bVarB.j(pVar);
                                    this.f26190e = bVarB.n();
                                }
                                this.f26189d |= 1;
                            } else if (iJ == 18) {
                                o.b bVarB2 = (this.f26189d & 2) == 2 ? this.f26191f.f() : null;
                                o oVar = (o) eVar.t(o.f26238g, gVar);
                                this.f26191f = oVar;
                                if (bVarB2 != null) {
                                    bVarB2.j(oVar);
                                    this.f26191f = bVarB2.n();
                                }
                                this.f26189d |= 2;
                            } else if (iJ == 26) {
                                l.b bVarF = (this.f26189d & 4) == 4 ? this.f26192g.f() : null;
                                l lVar = (l) eVar.t(l.f26170m, gVar);
                                this.f26192g = lVar;
                                if (bVarF != null) {
                                    bVarF.j(lVar);
                                    this.f26192g = bVarF.r();
                                }
                                this.f26189d |= 4;
                            } else if (iJ != 34) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                int i10 = (c10 == true ? 1 : 0) & '\b';
                                c10 = c10;
                                if (i10 != 8) {
                                    this.f26193h = new ArrayList();
                                    c10 = '\b';
                                }
                                this.f26193h.add(eVar.t(c.S, gVar));
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
                if (((c10 == true ? 1 : 0) & '\b') == 8) {
                    this.f26193h = Collections.unmodifiableList(this.f26193h);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26188c = bVarV.u();
                    throw th2;
                }
                this.f26188c = bVarV.u();
                l();
                throw th;
            }
        }
        if (((c10 == true ? 1 : 0) & '\b') == 8) {
            this.f26193h = Collections.unmodifiableList(this.f26193h);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26188c = bVarV.u();
            throw th3;
        }
        this.f26188c = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p f26197e = p.t();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public o f26198f = o.t();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public l f26199g = l.K();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f26200h = Collections.EMPTY_LIST;

        public b() {
            w();
        }

        public static b t() {
            return new b();
        }

        public b A(o oVar) {
            if ((this.f26196d & 2) != 2 || this.f26198f == o.t()) {
                this.f26198f = oVar;
            } else {
                this.f26198f = o.z(this.f26198f).j(oVar).n();
            }
            this.f26196d |= 2;
            return this;
        }

        public b B(p pVar) {
            if ((this.f26196d & 1) != 1 || this.f26197e == p.t()) {
                this.f26197e = pVar;
            } else {
                this.f26197e = p.z(this.f26197e).j(pVar).n();
            }
            this.f26196d |= 1;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public m build() {
            m mVarR = r();
            if (mVarR.d()) {
                return mVarR;
            }
            throw a.AbstractC0191a.h(mVarR);
        }

        public m r() {
            m mVar = new m(this);
            int i10 = this.f26196d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            mVar.f26190e = this.f26197e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            mVar.f26191f = this.f26198f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            mVar.f26192g = this.f26199g;
            if ((this.f26196d & 8) == 8) {
                this.f26200h = Collections.unmodifiableList(this.f26200h);
                this.f26196d &= -9;
            }
            mVar.f26193h = this.f26200h;
            mVar.f26189d = i11;
            return mVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        public final void v() {
            if ((this.f26196d & 8) != 8) {
                this.f26200h = new ArrayList(this.f26200h);
                this.f26196d |= 8;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.m.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.m.f26187l     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.m r3 = (ze.m) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.m r4 = (ze.m) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.m.b.u(gf.e, gf.g):ze.m$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b j(m mVar) {
            if (mVar == m.K()) {
                return this;
            }
            if (mVar.R()) {
                B(mVar.O());
            }
            if (mVar.Q()) {
                A(mVar.N());
            }
            if (mVar.P()) {
                z(mVar.M());
            }
            if (!mVar.f26193h.isEmpty()) {
                if (this.f26200h.isEmpty()) {
                    this.f26200h = mVar.f26193h;
                    this.f26196d &= -9;
                } else {
                    v();
                    this.f26200h.addAll(mVar.f26193h);
                }
            }
            o(mVar);
            k(i().c(mVar.f26188c));
            return this;
        }

        public b z(l lVar) {
            if ((this.f26196d & 4) != 4 || this.f26199g == l.K()) {
                this.f26199g = lVar;
            } else {
                this.f26199g = l.b0(this.f26199g).j(lVar).r();
            }
            this.f26196d |= 4;
            return this;
        }

        private void w() {
        }
    }
}
