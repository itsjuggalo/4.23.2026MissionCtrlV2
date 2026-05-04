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
public final class e extends gf.i implements gf.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f26048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static gf.r f26049g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f26050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f26052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26053e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public e c(gf.e eVar, gf.g gVar) {
            return new e(eVar, gVar);
        }
    }

    static {
        e eVar = new e(true);
        f26048f = eVar;
        eVar.x();
    }

    public static e t() {
        return f26048f;
    }

    private void x() {
        this.f26051c = Collections.EMPTY_LIST;
    }

    public static b y() {
        return b.p();
    }

    public static b z(e eVar) {
        return y().j(eVar);
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
        int i10 = this.f26053e;
        if (i10 != -1) {
            return i10;
        }
        int iR = 0;
        for (int i11 = 0; i11 < this.f26051c.size(); i11++) {
            iR += gf.f.r(1, (gf.p) this.f26051c.get(i11));
        }
        int size = iR + this.f26050b.size();
        this.f26053e = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26052d;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < w(); i10++) {
            if (!v(i10).d()) {
                this.f26052d = (byte) 0;
                return false;
            }
        }
        this.f26052d = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        for (int i10 = 0; i10 < this.f26051c.size(); i10++) {
            fVar.c0(1, (gf.p) this.f26051c.get(i10));
        }
        fVar.h0(this.f26050b);
    }

    public f v(int i10) {
        return (f) this.f26051c.get(i10);
    }

    public int w() {
        return this.f26051c.size();
    }

    public e(i.b bVar) {
        super(bVar);
        this.f26052d = (byte) -1;
        this.f26053e = -1;
        this.f26050b = bVar.i();
    }

    public e(boolean z10) {
        this.f26052d = (byte) -1;
        this.f26053e = -1;
        this.f26050b = gf.d.f10630a;
    }

    public e(gf.e eVar, gf.g gVar) {
        this.f26052d = (byte) -1;
        this.f26053e = -1;
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
                                    this.f26051c = new ArrayList();
                                    z11 = true;
                                }
                                this.f26051c.add(eVar.t(f.f26057k, gVar));
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
                    this.f26051c = Collections.unmodifiableList(this.f26051c);
                }
                try {
                    fVarI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f26050b = bVarV.u();
                    throw th2;
                }
                this.f26050b = bVarV.u();
                l();
                throw th;
            }
        }
        if (z11) {
            this.f26051c = Collections.unmodifiableList(this.f26051c);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f26050b = bVarV.u();
            throw th3;
        }
        this.f26050b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f26055c = Collections.EMPTY_LIST;

        public b() {
            r();
        }

        public static b p() {
            return new b();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public e build() {
            e eVarN = n();
            if (eVarN.d()) {
                return eVarN;
            }
            throw a.AbstractC0191a.h(eVarN);
        }

        public e n() {
            e eVar = new e(this);
            if ((this.f26054b & 1) == 1) {
                this.f26055c = Collections.unmodifiableList(this.f26055c);
                this.f26054b &= -2;
            }
            eVar.f26051c = this.f26055c;
            return eVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f26054b & 1) != 1) {
                this.f26055c = new ArrayList(this.f26055c);
                this.f26054b |= 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.e.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.e.f26049g     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.e r3 = (ze.e) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.e r4 = (ze.e) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.e.b.u(gf.e, gf.g):ze.e$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b j(e eVar) {
            if (eVar == e.t()) {
                return this;
            }
            if (!eVar.f26051c.isEmpty()) {
                if (this.f26055c.isEmpty()) {
                    this.f26055c = eVar.f26051c;
                    this.f26054b &= -2;
                } else {
                    q();
                    this.f26055c.addAll(eVar.f26051c);
                }
            }
            k(i().c(eVar.f26050b));
            return this;
        }

        private void r() {
        }
    }
}
