package l6;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.l;
import l6.o;
import l6.p;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AbstractC2722i.d implements s6.q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f20906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static s6.r f20907l = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2717d f20908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f20910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f20911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f20912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f20913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f20914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20915j;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public m b(C2718e c2718e, C2720g c2720g) {
            return new m(c2718e, c2720g);
        }
    }

    static {
        m mVar = new m(true);
        f20906k = mVar;
        mVar.T();
    }

    public m(C2718e c2718e, C2720g c2720g) {
        int i8;
        int i9;
        this.f20914i = (byte) -1;
        this.f20915j = -1;
        T();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        char c8 = 0;
        while (!z7) {
            try {
                try {
                    try {
                        int iJ = c2718e.J();
                        if (iJ != 0) {
                            if (iJ != 10) {
                                if (iJ == 18) {
                                    i8 = 2;
                                    o.b bVarC = (this.f20909d & 2) == 2 ? this.f20911f.g() : null;
                                    o oVar = (o) c2718e.t(o.f20958g, c2720g);
                                    this.f20911f = oVar;
                                    if (bVarC != null) {
                                        bVarC.k(oVar);
                                        this.f20911f = bVarC.p();
                                    }
                                    i9 = this.f20909d;
                                } else if (iJ == 26) {
                                    i8 = 4;
                                    l.b bVarG = (this.f20909d & 4) == 4 ? this.f20912g.g() : null;
                                    l lVar = (l) c2718e.t(l.f20890m, c2720g);
                                    this.f20912g = lVar;
                                    if (bVarG != null) {
                                        bVarG.k(lVar);
                                        this.f20912g = bVarG.t();
                                    }
                                    i9 = this.f20909d;
                                } else if (iJ == 34) {
                                    int i10 = (c8 == true ? 1 : 0) & '\b';
                                    c8 = c8;
                                    if (i10 != 8) {
                                        this.f20913h = new ArrayList();
                                        c8 = '\b';
                                    }
                                    this.f20913h.add(c2718e.t(c.f20685R, c2720g));
                                } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                                }
                                this.f20909d = i9 | i8;
                            } else {
                                p.b bVarC2 = (this.f20909d & 1) == 1 ? this.f20910e.g() : null;
                                p pVar = (p) c2718e.t(p.f20985g, c2720g);
                                this.f20910e = pVar;
                                if (bVarC2 != null) {
                                    bVarC2.k(pVar);
                                    this.f20910e = bVarC2.p();
                                }
                                this.f20909d |= 1;
                            }
                        }
                        z7 = true;
                    } catch (C2724k e8) {
                        throw e8.i(this);
                    }
                } catch (IOException e9) {
                    throw new C2724k(e9.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (((c8 == true ? 1 : 0) & '\b') == 8) {
                    this.f20913h = Collections.unmodifiableList(this.f20913h);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f20908c = bVarK.n();
                    throw th2;
                }
                this.f20908c = bVarK.n();
                m();
                throw th;
            }
        }
        if (((c8 == true ? 1 : 0) & '\b') == 8) {
            this.f20913h = Collections.unmodifiableList(this.f20913h);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20908c = bVarK.n();
            throw th3;
        }
        this.f20908c = bVarK.n();
        m();
    }

    public static m L() {
        return f20906k;
    }

    private void T() {
        this.f20910e = p.v();
        this.f20911f = o.v();
        this.f20912g = l.L();
        this.f20913h = Collections.emptyList();
    }

    public static b U() {
        return b.v();
    }

    public static b V(m mVar) {
        return U().k(mVar);
    }

    public static m X(InputStream inputStream, C2720g c2720g) {
        return (m) f20907l.c(inputStream, c2720g);
    }

    public c I(int i8) {
        return (c) this.f20913h.get(i8);
    }

    public int J() {
        return this.f20913h.size();
    }

    public List K() {
        return this.f20913h;
    }

    @Override // s6.q
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public m b() {
        return f20906k;
    }

    public l N() {
        return this.f20912g;
    }

    public o O() {
        return this.f20911f;
    }

    public p P() {
        return this.f20910e;
    }

    public boolean Q() {
        return (this.f20909d & 4) == 4;
    }

    public boolean R() {
        return (this.f20909d & 2) == 2;
    }

    public boolean S() {
        return (this.f20909d & 1) == 1;
    }

    @Override // s6.p
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public b d() {
        return U();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public b g() {
        return V(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20915j;
        if (i8 != -1) {
            return i8;
        }
        int iR = (this.f20909d & 1) == 1 ? C2719f.r(1, this.f20910e) : 0;
        if ((this.f20909d & 2) == 2) {
            iR += C2719f.r(2, this.f20911f);
        }
        if ((this.f20909d & 4) == 4) {
            iR += C2719f.r(3, this.f20912g);
        }
        for (int i9 = 0; i9 < this.f20913h.size(); i9++) {
            iR += C2719f.r(4, (s6.p) this.f20913h.get(i9));
        }
        int iU = iR + u() + this.f20908c.size();
        this.f20915j = iU;
        return iU;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20914i;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        if (R() && !O().e()) {
            this.f20914i = (byte) 0;
            return false;
        }
        if (Q() && !N().e()) {
            this.f20914i = (byte) 0;
            return false;
        }
        for (int i8 = 0; i8 < J(); i8++) {
            if (!I(i8).e()) {
                this.f20914i = (byte) 0;
                return false;
            }
        }
        if (t()) {
            this.f20914i = (byte) 1;
            return true;
        }
        this.f20914i = (byte) 0;
        return false;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        AbstractC2722i.d.a aVarZ = z();
        if ((this.f20909d & 1) == 1) {
            c2719f.c0(1, this.f20910e);
        }
        if ((this.f20909d & 2) == 2) {
            c2719f.c0(2, this.f20911f);
        }
        if ((this.f20909d & 4) == 4) {
            c2719f.c0(3, this.f20912g);
        }
        for (int i8 = 0; i8 < this.f20913h.size(); i8++) {
            c2719f.c0(4, (s6.p) this.f20913h.get(i8));
        }
        aVarZ.a(200, c2719f);
        c2719f.h0(this.f20908c);
    }

    public m(AbstractC2722i.c cVar) {
        super(cVar);
        this.f20914i = (byte) -1;
        this.f20915j = -1;
        this.f20908c = cVar.j();
    }

    public m(boolean z7) {
        this.f20914i = (byte) -1;
        this.f20915j = -1;
        this.f20908c = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.c implements s6.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20916d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p f20917e = p.v();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public o f20918f = o.v();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public l f20919g = l.L();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f20920h = Collections.emptyList();

        public b() {
            x();
        }

        public static b v() {
            return new b();
        }

        public b A(l lVar) {
            if ((this.f20916d & 4) == 4 && this.f20919g != l.L()) {
                lVar = l.c0(this.f20919g).k(lVar).t();
            }
            this.f20919g = lVar;
            this.f20916d |= 4;
            return this;
        }

        public b B(o oVar) {
            if ((this.f20916d & 2) == 2 && this.f20918f != o.v()) {
                oVar = o.A(this.f20918f).k(oVar).p();
            }
            this.f20918f = oVar;
            this.f20916d |= 2;
            return this;
        }

        public b C(p pVar) {
            if ((this.f20916d & 1) == 1 && this.f20917e != p.v()) {
                pVar = p.A(this.f20917e).k(pVar).p();
            }
            this.f20917e = pVar;
            this.f20916d |= 1;
            return this;
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public m a() {
            m mVarT = t();
            if (mVarT.e()) {
                return mVarT;
            }
            throw AbstractC2714a.AbstractC0396a.i(mVarT);
        }

        public m t() {
            m mVar = new m(this);
            int i8 = this.f20916d;
            int i9 = (i8 & 1) != 1 ? 0 : 1;
            mVar.f20910e = this.f20917e;
            if ((i8 & 2) == 2) {
                i9 |= 2;
            }
            mVar.f20911f = this.f20918f;
            if ((i8 & 4) == 4) {
                i9 |= 4;
            }
            mVar.f20912g = this.f20919g;
            if ((this.f20916d & 8) == 8) {
                this.f20920h = Collections.unmodifiableList(this.f20920h);
                this.f20916d &= -9;
            }
            mVar.f20913h = this.f20920h;
            mVar.f20909d = i9;
            return mVar;
        }

        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return v().k(t());
        }

        public final void w() {
            if ((this.f20916d & 8) != 8) {
                this.f20920h = new ArrayList(this.f20920h);
                this.f20916d |= 8;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public b k(m mVar) {
            if (mVar == m.L()) {
                return this;
            }
            if (mVar.S()) {
                C(mVar.P());
            }
            if (mVar.R()) {
                B(mVar.O());
            }
            if (mVar.Q()) {
                A(mVar.N());
            }
            if (!mVar.f20913h.isEmpty()) {
                if (this.f20920h.isEmpty()) {
                    this.f20920h = mVar.f20913h;
                    this.f20916d &= -9;
                } else {
                    w();
                    this.f20920h.addAll(mVar.f20913h);
                }
            }
            q(mVar);
            l(j().d(mVar.f20908c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.m.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.m.f20907l     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.m r3 = (l6.m) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                if (r3 == 0) goto Le
                r2.k(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                s6.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                l6.m r4 = (l6.m) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.k(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.m.b.n(s6.e, s6.g):l6.m$b");
        }

        private void x() {
        }
    }
}
