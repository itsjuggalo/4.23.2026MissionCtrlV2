package N2;

import K2.C0353a;
import K2.Z;
import K2.a0;
import K2.l0;
import M2.AbstractC0408a;
import M2.InterfaceC0443s;
import M2.O0;
import M2.V;
import M2.V0;
import N2.r;
import b2.AbstractC0862a;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h extends AbstractC0408a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final O3.d f2961p = new O3.d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f2962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final O0 f2964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f2966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f2967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C0353a f2968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2969o;

    public class a implements AbstractC0408a.b {
        public a() {
        }

        @Override // M2.AbstractC0408a.b
        public void c(l0 l0Var) {
            U2.e eVarH = U2.c.h("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f2966l.f2987z) {
                    h.this.f2966l.a0(l0Var, true, null);
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

        @Override // M2.AbstractC0408a.b
        public void d(Z z4, byte[] bArr) {
            U2.e eVarH = U2.c.h("OkHttpClientStream$Sink.writeHeaders");
            try {
                String str = RemoteSettings.FORWARD_SLASH_STRING + h.this.f2962h.c();
                if (bArr != null) {
                    h.this.f2969o = true;
                    str = str + "?" + AbstractC0862a.a().e(bArr);
                }
                synchronized (h.this.f2966l.f2987z) {
                    h.this.f2966l.g0(z4, str);
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

        @Override // M2.AbstractC0408a.b
        public void e(V0 v02, boolean z4, boolean z5, int i4) {
            O3.d dVarE;
            U2.e eVarH = U2.c.h("OkHttpClientStream$Sink.writeFrame");
            try {
                if (v02 == null) {
                    dVarE = h.f2961p;
                } else {
                    dVarE = ((p) v02).e();
                    int iI0 = (int) dVarE.i0();
                    if (iI0 > 0) {
                        h.this.u(iI0);
                    }
                }
                synchronized (h.this.f2966l.f2987z) {
                    h.this.f2966l.e0(dVarE, z4, z5);
                    h.this.y().e(i4);
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

    public class b extends V implements r.b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public List f2971A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public O3.d f2972B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public boolean f2973C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public boolean f2974D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public boolean f2975E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f2976F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f2977G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public final N2.b f2978H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public final r f2979I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public final i f2980J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public boolean f2981K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public final U2.d f2982L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public r.c f2983M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f2984N;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f2986y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Object f2987z;

        public b(int i4, O0 o02, Object obj, N2.b bVar, r rVar, i iVar, int i5, String str) {
            super(i4, o02, h.this.y());
            this.f2972B = new O3.d();
            this.f2973C = false;
            this.f2974D = false;
            this.f2975E = false;
            this.f2981K = true;
            this.f2984N = -1;
            this.f2987z = Z1.m.o(obj, "lock");
            this.f2978H = bVar;
            this.f2979I = rVar;
            this.f2980J = iVar;
            this.f2976F = i5;
            this.f2977G = i5;
            this.f2986y = i5;
            this.f2982L = U2.c.b(str);
        }

        @Override // M2.V
        public void P(l0 l0Var, boolean z4, Z z5) throws EOFException {
            a0(l0Var, z4, z5);
        }

        public final void a0(l0 l0Var, boolean z4, Z z5) throws EOFException {
            if (this.f2975E) {
                return;
            }
            this.f2975E = true;
            if (!this.f2981K) {
                this.f2980J.V(c0(), l0Var, InterfaceC0443s.a.PROCESSED, z4, P2.a.CANCEL, z5);
                return;
            }
            this.f2980J.h0(h.this);
            this.f2971A = null;
            this.f2972B.f();
            this.f2981K = false;
            if (z5 == null) {
                z5 = new Z();
            }
            N(l0Var, true, z5);
        }

        public r.c b0() {
            r.c cVar;
            synchronized (this.f2987z) {
                cVar = this.f2983M;
            }
            return cVar;
        }

        @Override // M2.V, M2.AbstractC0408a.c, M2.C0433m0.b
        public void c(boolean z4) {
            d0();
            super.c(z4);
        }

        public int c0() {
            return this.f2984N;
        }

        @Override // M2.C0433m0.b
        public void d(int i4) {
            int i5 = this.f2977G - i4;
            this.f2977G = i5;
            float f4 = i5;
            int i6 = this.f2986y;
            if (f4 <= i6 * 0.5f) {
                int i7 = i6 - i5;
                this.f2976F += i7;
                this.f2977G = i5 + i7;
                this.f2978H.b(c0(), i7);
            }
        }

        public final void d0() {
            if (G()) {
                this.f2980J.V(c0(), null, InterfaceC0443s.a.PROCESSED, false, null, null);
            } else {
                this.f2980J.V(c0(), null, InterfaceC0443s.a.PROCESSED, false, P2.a.CANCEL, null);
            }
        }

        @Override // M2.C0433m0.b
        public void e(Throwable th) throws EOFException {
            P(l0.k(th), true, new Z());
        }

        public final void e0(O3.d dVar, boolean z4, boolean z5) {
            if (this.f2975E) {
                return;
            }
            if (!this.f2981K) {
                Z1.m.u(c0() != -1, "streamId should be set");
                this.f2979I.d(z4, this.f2983M, dVar, z5);
            } else {
                this.f2972B.c0(dVar, (int) dVar.i0());
                this.f2973C |= z4;
                this.f2974D |= z5;
            }
        }

        @Override // M2.C0418f.d
        public void f(Runnable runnable) {
            synchronized (this.f2987z) {
                runnable.run();
            }
        }

        public void f0(int i4) {
            Z1.m.v(this.f2984N == -1, "the stream has been started with id %s", i4);
            this.f2984N = i4;
            this.f2983M = this.f2979I.c(this, i4);
            h.this.f2966l.r();
            if (this.f2981K) {
                this.f2978H.W(h.this.f2969o, false, this.f2984N, 0, this.f2971A);
                h.this.f2964j.c();
                this.f2971A = null;
                if (this.f2972B.i0() > 0) {
                    this.f2979I.d(this.f2973C, this.f2983M, this.f2972B, this.f2974D);
                }
                this.f2981K = false;
            }
        }

        public final void g0(Z z4, String str) {
            this.f2971A = d.b(z4, str, h.this.f2965k, h.this.f2963i, h.this.f2969o, this.f2980J.b0());
            this.f2980J.o0(h.this);
        }

        public U2.d h0() {
            return this.f2982L;
        }

        public void i0(O3.d dVar, boolean z4, int i4) throws Throwable {
            int iI0 = this.f2976F - (((int) dVar.i0()) + i4);
            this.f2976F = iI0;
            this.f2977G -= i4;
            if (iI0 >= 0) {
                super.S(new l(dVar), z4);
            } else {
                this.f2978H.a(c0(), P2.a.FLOW_CONTROL_ERROR);
                this.f2980J.V(c0(), l0.f1229s.q("Received data size exceeded our receiving window size"), InterfaceC0443s.a.PROCESSED, false, null, null);
            }
        }

        public void j0(List list, boolean z4) {
            if (z4) {
                U(s.c(list));
            } else {
                T(s.a(list));
            }
        }

        @Override // M2.AbstractC0412c.a
        public void r() {
            super.r();
            m().c();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public h(K2.a0 r11, K2.Z r12, N2.b r13, N2.i r14, N2.r r15, java.lang.Object r16, int r17, int r18, java.lang.String r19, java.lang.String r20, M2.O0 r21, M2.U0 r22, K2.C0355c r23, boolean r24) {
        /*
            r10 = this;
            N2.q r1 = new N2.q
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
            N2.h$a r0 = new N2.h$a
            r0.<init>()
            r10.f2967m = r0
            r10.f2969o = r7
            java.lang.String r0 = "statsTraceCtx"
            r2 = r21
            java.lang.Object r0 = Z1.m.o(r2, r0)
            M2.O0 r0 = (M2.O0) r0
            r10.f2964j = r0
            r10.f2962h = r11
            r3 = r19
            r10.f2965k = r3
            r3 = r20
            r10.f2963i = r3
            K2.a r3 = r14.d()
            r10.f2968n = r3
            N2.h$b r0 = new N2.h$b
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
            r10.f2966l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.h.<init>(K2.a0, K2.Z, N2.b, N2.i, N2.r, java.lang.Object, int, int, java.lang.String, java.lang.String, M2.O0, M2.U0, K2.c, boolean):void");
    }

    @Override // M2.AbstractC0408a
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public a w() {
        return this.f2967m;
    }

    public a0.d N() {
        return this.f2962h.e();
    }

    @Override // M2.AbstractC0412c
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b v() {
        return this.f2966l;
    }

    public boolean P() {
        return this.f2969o;
    }

    @Override // M2.r
    public C0353a d() {
        return this.f2968n;
    }

    @Override // M2.r
    public void l(String str) {
        this.f2965k = (String) Z1.m.o(str, "authority");
    }
}
