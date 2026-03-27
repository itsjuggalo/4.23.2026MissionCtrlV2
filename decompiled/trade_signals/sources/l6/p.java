package l6;

import java.io.IOException;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;
import s6.C2726m;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f20984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static s6.r f20985g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f20986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s6.n f20987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f20988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20989e;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public p b(C2718e c2718e, C2720g c2720g) {
            return new p(c2718e, c2720g);
        }
    }

    static {
        p pVar = new p(true);
        f20984f = pVar;
        pVar.y();
    }

    public p(C2718e c2718e, C2720g c2720g) {
        this.f20988d = (byte) -1;
        this.f20989e = -1;
        y();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        boolean z8 = false;
        while (!z7) {
            try {
                try {
                    try {
                        int iJ = c2718e.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                AbstractC2717d abstractC2717dK = c2718e.k();
                                if (!z8) {
                                    this.f20987c = new C2726m();
                                    z8 = true;
                                }
                                this.f20987c.t(abstractC2717dK);
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
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
                if (z8) {
                    this.f20987c = this.f20987c.l();
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f20986b = bVarK.n();
                    throw th2;
                }
                this.f20986b = bVarK.n();
                m();
                throw th;
            }
        }
        if (z8) {
            this.f20987c = this.f20987c.l();
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20986b = bVarK.n();
            throw th3;
        }
        this.f20986b = bVarK.n();
        m();
    }

    public static b A(p pVar) {
        return z().k(pVar);
    }

    public static p v() {
        return f20984f;
    }

    private void y() {
        this.f20987c = C2726m.f23187b;
    }

    public static b z() {
        return b.r();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b d() {
        return z();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public b g() {
        return A(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20989e;
        if (i8 != -1) {
            return i8;
        }
        int iE = 0;
        for (int i9 = 0; i9 < this.f20987c.size(); i9++) {
            iE += C2719f.e(this.f20987c.w(i9));
        }
        int size = iE + x().size() + this.f20986b.size();
        this.f20989e = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20988d;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        this.f20988d = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        for (int i8 = 0; i8 < this.f20987c.size(); i8++) {
            c2719f.N(1, this.f20987c.w(i8));
        }
        c2719f.h0(this.f20986b);
    }

    public String w(int i8) {
        return (String) this.f20987c.get(i8);
    }

    public s6.s x() {
        return this.f20987c;
    }

    public p(AbstractC2722i.b bVar) {
        super(bVar);
        this.f20988d = (byte) -1;
        this.f20989e = -1;
        this.f20986b = bVar.j();
    }

    public p(boolean z7) {
        this.f20988d = (byte) -1;
        this.f20989e = -1;
        this.f20986b = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s6.n f20991c = C2726m.f23187b;

        public b() {
            t();
        }

        public static b r() {
            return new b();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public p a() {
            p pVarP = p();
            if (pVarP.e()) {
                return pVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(pVarP);
        }

        public p p() {
            p pVar = new p(this);
            if ((this.f20990b & 1) == 1) {
                this.f20991c = this.f20991c.l();
                this.f20990b &= -2;
            }
            pVar.f20987c = this.f20991c;
            return pVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return r().k(p());
        }

        public final void s() {
            if ((this.f20990b & 1) != 1) {
                this.f20991c = new C2726m(this.f20991c);
                this.f20990b |= 1;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b k(p pVar) {
            if (pVar == p.v()) {
                return this;
            }
            if (!pVar.f20987c.isEmpty()) {
                if (this.f20991c.isEmpty()) {
                    this.f20991c = pVar.f20987c;
                    this.f20990b &= -2;
                } else {
                    s();
                    this.f20991c.addAll(pVar.f20987c);
                }
            }
            l(j().d(pVar.f20986b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.p.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.p.f20985g     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.p r3 = (l6.p) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.p r4 = (l6.p) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.p.b.n(s6.e, s6.g):l6.p$b");
        }

        private void t() {
        }
    }
}
