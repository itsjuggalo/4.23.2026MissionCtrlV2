package l6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final t f21098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static s6.r f21099i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f21100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f21102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f21104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21105g;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public t b(C2718e c2718e, C2720g c2720g) {
            return new t(c2718e, c2720g);
        }
    }

    static {
        t tVar = new t(true);
        f21098h = tVar;
        tVar.D();
    }

    public t(C2718e c2718e, C2720g c2720g) {
        this.f21104f = (byte) -1;
        this.f21105g = -1;
        D();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        boolean z8 = false;
        while (!z7) {
            try {
                try {
                    int iJ = c2718e.J();
                    if (iJ != 0) {
                        if (iJ == 10) {
                            if (!z8) {
                                this.f21102d = new ArrayList();
                                z8 = true;
                            }
                            this.f21102d.add(c2718e.t(q.f20993v, c2720g));
                        } else if (iJ == 16) {
                            this.f21101c |= 1;
                            this.f21103e = c2718e.r();
                        } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                        }
                    }
                    z7 = true;
                } catch (Throwable th) {
                    if (z8) {
                        this.f21102d = Collections.unmodifiableList(this.f21102d);
                    }
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f21100b = bVarK.n();
                        throw th2;
                    }
                    this.f21100b = bVarK.n();
                    m();
                    throw th;
                }
            } catch (C2724k e8) {
                throw e8.i(this);
            } catch (IOException e9) {
                throw new C2724k(e9.getMessage()).i(this);
            }
        }
        if (z8) {
            this.f21102d = Collections.unmodifiableList(this.f21102d);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f21100b = bVarK.n();
            throw th3;
        }
        this.f21100b = bVarK.n();
        m();
    }

    private void D() {
        this.f21102d = Collections.emptyList();
        this.f21103e = -1;
    }

    public static b E() {
        return b.r();
    }

    public static b F(t tVar) {
        return E().k(tVar);
    }

    public static t x() {
        return f21098h;
    }

    public int A() {
        return this.f21102d.size();
    }

    public List B() {
        return this.f21102d;
    }

    public boolean C() {
        return (this.f21101c & 1) == 1;
    }

    @Override // s6.p
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public b d() {
        return E();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public b g() {
        return F(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f21105g;
        if (i8 != -1) {
            return i8;
        }
        int iO = 0;
        for (int i9 = 0; i9 < this.f21102d.size(); i9++) {
            iO += C2719f.r(1, (s6.p) this.f21102d.get(i9));
        }
        if ((this.f21101c & 1) == 1) {
            iO += C2719f.o(2, this.f21103e);
        }
        int size = iO + this.f21100b.size();
        this.f21105g = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f21104f;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        for (int i8 = 0; i8 < A(); i8++) {
            if (!z(i8).e()) {
                this.f21104f = (byte) 0;
                return false;
            }
        }
        this.f21104f = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        for (int i8 = 0; i8 < this.f21102d.size(); i8++) {
            c2719f.c0(1, (s6.p) this.f21102d.get(i8));
        }
        if ((this.f21101c & 1) == 1) {
            c2719f.Z(2, this.f21103e);
        }
        c2719f.h0(this.f21100b);
    }

    public int y() {
        return this.f21103e;
    }

    public q z(int i8) {
        return (q) this.f21102d.get(i8);
    }

    public t(AbstractC2722i.b bVar) {
        super(bVar);
        this.f21104f = (byte) -1;
        this.f21105g = -1;
        this.f21100b = bVar.j();
    }

    public t(boolean z7) {
        this.f21104f = (byte) -1;
        this.f21105g = -1;
        this.f21100b = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f21107c = Collections.emptyList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21108d = -1;

        public b() {
            t();
        }

        public static b r() {
            return new b();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public t a() {
            t tVarP = p();
            if (tVarP.e()) {
                return tVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(tVarP);
        }

        public t p() {
            t tVar = new t(this);
            int i8 = this.f21106b;
            if ((i8 & 1) == 1) {
                this.f21107c = Collections.unmodifiableList(this.f21107c);
                this.f21106b &= -2;
            }
            tVar.f21102d = this.f21107c;
            int i9 = (i8 & 2) != 2 ? 0 : 1;
            tVar.f21103e = this.f21108d;
            tVar.f21101c = i9;
            return tVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return r().k(p());
        }

        public final void s() {
            if ((this.f21106b & 1) != 1) {
                this.f21107c = new ArrayList(this.f21107c);
                this.f21106b |= 1;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b k(t tVar) {
            if (tVar == t.x()) {
                return this;
            }
            if (!tVar.f21102d.isEmpty()) {
                if (this.f21107c.isEmpty()) {
                    this.f21107c = tVar.f21102d;
                    this.f21106b &= -2;
                } else {
                    s();
                    this.f21107c.addAll(tVar.f21102d);
                }
            }
            if (tVar.C()) {
                w(tVar.y());
            }
            l(j().d(tVar.f21100b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.t.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.t.f21099i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.t r3 = (l6.t) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.t r4 = (l6.t) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.t.b.n(s6.e, s6.g):l6.t$b");
        }

        public b w(int i8) {
            this.f21106b |= 2;
            this.f21108d = i8;
            return this;
        }

        private void t() {
        }
    }
}
