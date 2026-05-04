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
public final class w extends gf.i implements gf.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f26439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static gf.r f26440g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f26443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26444e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public w c(gf.e eVar, gf.g gVar) {
            return new w(eVar, gVar);
        }
    }

    static {
        w wVar = new w(true);
        f26439f = wVar;
        wVar.x();
    }

    public static w t() {
        return f26439f;
    }

    private void x() {
        this.f26442c = Collections.EMPTY_LIST;
    }

    public static b y() {
        return b.p();
    }

    public static b z(w wVar) {
        return y().j(wVar);
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
        int i10 = this.f26444e;
        if (i10 != -1) {
            return i10;
        }
        int iR = 0;
        for (int i11 = 0; i11 < this.f26442c.size(); i11++) {
            iR += gf.f.r(1, (gf.p) this.f26442c.get(i11));
        }
        int size = iR + this.f26441b.size();
        this.f26444e = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26443d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f26443d = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        for (int i10 = 0; i10 < this.f26442c.size(); i10++) {
            fVar.c0(1, (gf.p) this.f26442c.get(i10));
        }
        fVar.h0(this.f26441b);
    }

    public int v() {
        return this.f26442c.size();
    }

    public List w() {
        return this.f26442c;
    }

    public w(i.b bVar) {
        super(bVar);
        this.f26443d = (byte) -1;
        this.f26444e = -1;
        this.f26441b = bVar.i();
    }

    public w(boolean z10) {
        this.f26443d = (byte) -1;
        this.f26444e = -1;
        this.f26441b = gf.d.f10630a;
    }

    public w(gf.e eVar, gf.g gVar) {
        this.f26443d = (byte) -1;
        this.f26444e = -1;
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
                                if (!z11) {
                                    this.f26442c = new ArrayList();
                                    z11 = true;
                                }
                                this.f26442c.add(eVar.t(v.f26409m, gVar));
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
                    this.f26442c = Collections.unmodifiableList(this.f26442c);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26441b = bVarV.u();
                    throw th2;
                }
                this.f26441b = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26442c = Collections.unmodifiableList(this.f26442c);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26441b = bVarV.u();
            throw th3;
        }
        this.f26441b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f26446c = Collections.EMPTY_LIST;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public w build() {
            w wVarN = n();
            if (wVarN.d()) {
                return wVarN;
            }
            throw a.AbstractC0191a.h(wVarN);
        }

        public w n() {
            w wVar = new w(this);
            if ((this.f26445b & 1) == 1) {
                this.f26446c = Collections.unmodifiableList(this.f26446c);
                this.f26445b &= -2;
            }
            wVar.f26442c = this.f26446c;
            return wVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26445b & 1) != 1) {
                this.f26446c = new ArrayList(this.f26446c);
                this.f26445b |= 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.w.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.w.f26440g     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.w r3 = (ze.w) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.w r4 = (ze.w) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.w.b.u(gf.e, gf.g):ze.w$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b j(w wVar) {
            if (wVar == w.t()) {
                return this;
            }
            if (!wVar.f26442c.isEmpty()) {
                if (this.f26446c.isEmpty()) {
                    this.f26446c = wVar.f26442c;
                    this.f26445b &= -2;
                } else {
                    q();
                    this.f26446c.addAll(wVar.f26442c);
                }
            }
            k(i().c(wVar.f26441b));
            return this;
        }

        private void r() {
        }
    }
}
