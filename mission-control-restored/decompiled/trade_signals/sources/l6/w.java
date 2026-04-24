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
public final class w extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f21159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static s6.r f21160g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f21161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f21162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f21163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21164e;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public w b(C2718e c2718e, C2720g c2720g) {
            return new w(c2718e, c2720g);
        }
    }

    static {
        w wVar = new w(true);
        f21159f = wVar;
        wVar.y();
    }

    public w(C2718e c2718e, C2720g c2720g) {
        this.f21163d = (byte) -1;
        this.f21164e = -1;
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
                                if (!z8) {
                                    this.f21162c = new ArrayList();
                                    z8 = true;
                                }
                                this.f21162c.add(c2718e.t(v.f21129m, c2720g));
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
                    this.f21162c = Collections.unmodifiableList(this.f21162c);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f21161b = bVarK.n();
                    throw th2;
                }
                this.f21161b = bVarK.n();
                m();
                throw th;
            }
        }
        if (z8) {
            this.f21162c = Collections.unmodifiableList(this.f21162c);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f21161b = bVarK.n();
            throw th3;
        }
        this.f21161b = bVarK.n();
        m();
    }

    public static b A(w wVar) {
        return z().k(wVar);
    }

    public static w v() {
        return f21159f;
    }

    private void y() {
        this.f21162c = Collections.emptyList();
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
        int i8 = this.f21164e;
        if (i8 != -1) {
            return i8;
        }
        int iR = 0;
        for (int i9 = 0; i9 < this.f21162c.size(); i9++) {
            iR += C2719f.r(1, (s6.p) this.f21162c.get(i9));
        }
        int size = iR + this.f21161b.size();
        this.f21164e = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f21163d;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        this.f21163d = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        for (int i8 = 0; i8 < this.f21162c.size(); i8++) {
            c2719f.c0(1, (s6.p) this.f21162c.get(i8));
        }
        c2719f.h0(this.f21161b);
    }

    public int w() {
        return this.f21162c.size();
    }

    public List x() {
        return this.f21162c;
    }

    public w(AbstractC2722i.b bVar) {
        super(bVar);
        this.f21163d = (byte) -1;
        this.f21164e = -1;
        this.f21161b = bVar.j();
    }

    public w(boolean z7) {
        this.f21163d = (byte) -1;
        this.f21164e = -1;
        this.f21161b = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f21166c = Collections.emptyList();

        public b() {
            t();
        }

        public static b r() {
            return new b();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public w a() {
            w wVarP = p();
            if (wVarP.e()) {
                return wVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(wVarP);
        }

        public w p() {
            w wVar = new w(this);
            if ((this.f21165b & 1) == 1) {
                this.f21166c = Collections.unmodifiableList(this.f21166c);
                this.f21165b &= -2;
            }
            wVar.f21162c = this.f21166c;
            return wVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return r().k(p());
        }

        public final void s() {
            if ((this.f21165b & 1) != 1) {
                this.f21166c = new ArrayList(this.f21166c);
                this.f21165b |= 1;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b k(w wVar) {
            if (wVar == w.v()) {
                return this;
            }
            if (!wVar.f21162c.isEmpty()) {
                if (this.f21166c.isEmpty()) {
                    this.f21166c = wVar.f21162c;
                    this.f21165b &= -2;
                } else {
                    s();
                    this.f21166c.addAll(wVar.f21162c);
                }
            }
            l(j().d(wVar.f21161b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.w.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.w.f21160g     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.w r3 = (l6.w) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.w r4 = (l6.w) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.w.b.n(s6.e, s6.g):l6.w$b");
        }

        private void t() {
        }
    }
}
