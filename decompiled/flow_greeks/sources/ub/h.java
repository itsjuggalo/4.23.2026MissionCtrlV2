package ub;

import java.io.EOFException;
import java.util.List;
import rb.k1;
import rb.y0;
import rb.z0;
import tb.a;
import tb.n2;
import tb.s;
import tb.u0;
import tb.u2;
import ub.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class h extends tb.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final hh.d f22810p = new hh.d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z0 f22811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n2 f22813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f22815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f22816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final rb.a f22817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22818o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a.b {
        public a() {
        }

        @Override // tb.a.b
        public void e(k1 k1Var) {
            bc.e eVarH = bc.c.h("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f22815l.f22821z) {
                    h.this.f22815l.a0(k1Var, true, null);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // tb.a.b
        public void f(u2 u2Var, boolean z10, boolean z11, int i10) {
            hh.d dVarC;
            bc.e eVarH = bc.c.h("OkHttpClientStream$Sink.writeFrame");
            try {
                if (u2Var == null) {
                    dVarC = h.f22810p;
                } else {
                    dVarC = ((p) u2Var).c();
                    int size = (int) dVarC.size();
                    if (size > 0) {
                        h.this.s(size);
                    }
                }
                synchronized (h.this.f22815l.f22821z) {
                    h.this.f22815l.e0(dVarC, z10, z11);
                    h.this.w().e(i10);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // tb.a.b
        public void g(y0 y0Var, byte[] bArr) {
            bc.e eVarH = bc.c.h("OkHttpClientStream$Sink.writeHeaders");
            try {
                String str = "/" + h.this.f22811h.c();
                if (bArr != null) {
                    h.this.f22818o = true;
                    str = str + "?" + r6.a.b().f(bArr);
                }
                synchronized (h.this.f22815l.f22821z) {
                    h.this.f22815l.g0(y0Var, str);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends u0 implements r.b {
        public List A;
        public hh.d B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public final ub.b H;
        public final r I;
        public final i J;
        public boolean K;
        public final bc.d L;
        public r.c M;
        public int N;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f22820y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Object f22821z;

        public b(int i10, n2 n2Var, Object obj, ub.b bVar, r rVar, i iVar, int i11, String str) {
            super(i10, n2Var, h.this.w());
            this.B = new hh.d();
            this.C = false;
            this.D = false;
            this.E = false;
            this.K = true;
            this.N = -1;
            this.f22821z = p6.n.o(obj, "lock");
            this.H = bVar;
            this.I = rVar;
            this.J = iVar;
            this.F = i11;
            this.G = i11;
            this.f22820y = i11;
            this.L = bc.c.b(str);
        }

        @Override // tb.u0
        public void P(k1 k1Var, boolean z10, y0 y0Var) throws EOFException {
            a0(k1Var, z10, y0Var);
        }

        public final void a0(k1 k1Var, boolean z10, y0 y0Var) throws EOFException {
            if (this.E) {
                return;
            }
            this.E = true;
            if (!this.K) {
                this.J.U(c0(), k1Var, s.a.PROCESSED, z10, wb.a.CANCEL, y0Var);
                return;
            }
            this.J.g0(h.this);
            this.A = null;
            this.B.c();
            this.K = false;
            if (y0Var == null) {
                y0Var = new y0();
            }
            N(k1Var, true, y0Var);
        }

        public r.c b0() {
            r.c cVar;
            synchronized (this.f22821z) {
                cVar = this.M;
            }
            return cVar;
        }

        @Override // tb.u0, tb.a.c, tb.l1.b
        public void c(boolean z10) {
            d0();
            super.c(z10);
        }

        public int c0() {
            return this.N;
        }

        @Override // tb.l1.b
        public void d(int i10) {
            int i11 = this.G - i10;
            this.G = i11;
            float f10 = i11;
            int i12 = this.f22820y;
            if (f10 <= i12 * 0.5f) {
                int i13 = i12 - i11;
                this.F += i13;
                this.G = i11 + i13;
                this.H.a(c0(), i13);
            }
        }

        public final void d0() {
            if (G()) {
                this.J.U(c0(), null, s.a.PROCESSED, false, null, null);
            } else {
                this.J.U(c0(), null, s.a.PROCESSED, false, wb.a.CANCEL, null);
            }
        }

        @Override // tb.l1.b
        public void e(Throwable th) throws EOFException {
            P(k1.l(th), true, new y0());
        }

        public final void e0(hh.d dVar, boolean z10, boolean z11) {
            if (this.E) {
                return;
            }
            if (!this.K) {
                p6.n.u(c0() != -1, "streamId should be set");
                this.I.d(z10, this.M, dVar, z11);
            } else {
                this.B.L(dVar, (int) dVar.size());
                this.C |= z10;
                this.D |= z11;
            }
        }

        @Override // tb.f.d
        public void f(Runnable runnable) {
            synchronized (this.f22821z) {
                runnable.run();
            }
        }

        public void f0(int i10) {
            p6.n.w(this.N == -1, "the stream has been started with id %s", i10);
            this.N = i10;
            this.M = this.I.c(this, i10);
            h.this.f22815l.r();
            if (this.K) {
                this.H.U(h.this.f22818o, false, this.N, 0, this.A);
                h.this.f22813j.c();
                this.A = null;
                if (this.B.size() > 0) {
                    this.I.d(this.C, this.M, this.B, this.D);
                }
                this.K = false;
            }
        }

        public final void g0(y0 y0Var, String str) {
            this.A = d.b(y0Var, str, h.this.f22814k, h.this.f22812i, h.this.f22818o, this.J.a0());
            this.J.n0(h.this);
        }

        public bc.d h0() {
            return this.L;
        }

        public void i0(hh.d dVar, boolean z10, int i10) throws Throwable {
            int size = this.F - (((int) dVar.size()) + i10);
            this.F = size;
            this.G -= i10;
            if (size >= 0) {
                super.S(new l(dVar), z10);
            } else {
                this.H.g(c0(), wb.a.FLOW_CONTROL_ERROR);
                this.J.U(c0(), k1.f19606s.r("Received data size exceeded our receiving window size"), s.a.PROCESSED, false, null, null);
            }
        }

        public void j0(List list, boolean z10) {
            if (z10) {
                U(s.c(list));
            } else {
                T(s.a(list));
            }
        }

        @Override // tb.c.a
        public void r() {
            super.r();
            m().c();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public h(rb.z0 r11, rb.y0 r12, ub.b r13, ub.i r14, ub.r r15, java.lang.Object r16, int r17, int r18, java.lang.String r19, java.lang.String r20, tb.n2 r21, tb.t2 r22, rb.c r23, boolean r24) {
        /*
            r10 = this;
            ub.q r1 = new ub.q
            r1.<init>()
            r7 = 0
            if (r24 == 0) goto L19
            boolean r0 = r11.f()
            if (r0 == 0) goto L19
            r0 = 1
            r6 = r0
            r4 = r12
            r2 = r21
            r3 = r22
            r5 = r23
            r0 = r10
            goto L22
        L19:
            r6 = r7
            r0 = r10
            r4 = r12
            r2 = r21
            r3 = r22
            r5 = r23
        L22:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            ub.h$a r0 = new ub.h$a
            r0.<init>()
            r10.f22816m = r0
            r10.f22818o = r7
            java.lang.String r0 = "statsTraceCtx"
            r2 = r21
            java.lang.Object r0 = p6.n.o(r2, r0)
            tb.n2 r0 = (tb.n2) r0
            r10.f22813j = r0
            r10.f22811h = r11
            r3 = r19
            r10.f22814k = r3
            r3 = r20
            r10.f22812i = r3
            rb.a r3 = r14.getAttributes()
            r10.f22817n = r3
            ub.h$b r0 = new ub.h$b
            java.lang.String r9 = r11.c()
            r1 = r10
            r5 = r13
            r7 = r14
            r6 = r15
            r4 = r16
            r8 = r18
            r3 = r2
            r2 = r17
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f22815l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.h.<init>(rb.z0, rb.y0, ub.b, ub.i, ub.r, java.lang.Object, int, int, java.lang.String, java.lang.String, tb.n2, tb.t2, rb.c, boolean):void");
    }

    public z0.d L() {
        return this.f22811h.e();
    }

    @Override // tb.a
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b y() {
        return this.f22815l;
    }

    public boolean N() {
        return this.f22818o;
    }

    @Override // tb.r
    public rb.a getAttributes() {
        return this.f22817n;
    }

    @Override // tb.r
    public void h(String str) {
        this.f22814k = (String) p6.n.o(str, "authority");
    }

    @Override // tb.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public a u() {
        return this.f22816m;
    }
}
