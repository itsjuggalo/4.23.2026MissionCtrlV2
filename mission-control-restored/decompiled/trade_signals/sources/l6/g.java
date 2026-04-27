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

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC2722i.d implements s6.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f20803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static s6.r f20804i = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2717d f20805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f20808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20809g;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public g b(C2718e c2718e, C2720g c2720g) {
            return new g(c2718e, c2720g);
        }
    }

    static {
        g gVar = new g(true);
        f20803h = gVar;
        gVar.I();
    }

    public g(C2718e c2718e, C2720g c2720g) {
        this.f20808f = (byte) -1;
        this.f20809g = -1;
        I();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        while (!z7) {
            try {
                try {
                    int iJ = c2718e.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f20806d |= 1;
                            this.f20807e = c2718e.r();
                        } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                        }
                    }
                    z7 = true;
                } catch (Throwable th) {
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f20805c = bVarK.n();
                        throw th2;
                    }
                    this.f20805c = bVarK.n();
                    m();
                    throw th;
                }
            } catch (C2724k e8) {
                throw e8.i(this);
            } catch (IOException e9) {
                throw new C2724k(e9.getMessage()).i(this);
            }
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20805c = bVarK.n();
            throw th3;
        }
        this.f20805c = bVarK.n();
        m();
    }

    public static g E() {
        return f20803h;
    }

    private void I() {
        this.f20807e = 0;
    }

    public static b J() {
        return b.v();
    }

    public static b K(g gVar) {
        return J().k(gVar);
    }

    @Override // s6.q
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public g b() {
        return f20803h;
    }

    public int G() {
        return this.f20807e;
    }

    public boolean H() {
        return (this.f20806d & 1) == 1;
    }

    @Override // s6.p
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b d() {
        return J();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public b g() {
        return K(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20809g;
        if (i8 != -1) {
            return i8;
        }
        int iO = ((this.f20806d & 1) == 1 ? C2719f.o(1, this.f20807e) : 0) + u() + this.f20805c.size();
        this.f20809g = iO;
        return iO;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20808f;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        if (t()) {
            this.f20808f = (byte) 1;
            return true;
        }
        this.f20808f = (byte) 0;
        return false;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        AbstractC2722i.d.a aVarZ = z();
        if ((this.f20806d & 1) == 1) {
            c2719f.Z(1, this.f20807e);
        }
        aVarZ.a(200, c2719f);
        c2719f.h0(this.f20805c);
    }

    public g(AbstractC2722i.c cVar) {
        super(cVar);
        this.f20808f = (byte) -1;
        this.f20809g = -1;
        this.f20805c = cVar.j();
    }

    public g(boolean z7) {
        this.f20808f = (byte) -1;
        this.f20809g = -1;
        this.f20805c = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.c implements s6.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20811e;

        public b() {
            w();
        }

        public static b v() {
            return new b();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public g a() {
            g gVarT = t();
            if (gVarT.e()) {
                return gVarT;
            }
            throw AbstractC2714a.AbstractC0396a.i(gVarT);
        }

        public g t() {
            g gVar = new g(this);
            int i8 = (this.f20810d & 1) != 1 ? 0 : 1;
            gVar.f20807e = this.f20811e;
            gVar.f20806d = i8;
            return gVar;
        }

        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return v().k(t());
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b k(g gVar) {
            if (gVar == g.E()) {
                return this;
            }
            if (gVar.H()) {
                z(gVar.G());
            }
            q(gVar);
            l(j().d(gVar.f20805c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.g.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.g.f20804i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.g r3 = (l6.g) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.g r4 = (l6.g) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.g.b.n(s6.e, s6.g):l6.g$b");
        }

        public b z(int i8) {
            this.f20810d |= 1;
            this.f20811e = i8;
            return this;
        }

        private void w() {
        }
    }
}
