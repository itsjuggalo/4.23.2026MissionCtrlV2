package c0;

import c0.d;
import com.google.android.gms.common.api.a;
import d0.l;
import d0.n;
import d0.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static float K0 = 0.5f;
    public int A0;
    public boolean B0;
    public boolean C0;
    public float[] D0;
    public e[] E0;
    public e[] F0;
    public e G0;
    public e H0;
    public int I0;
    public int J0;
    public boolean K;
    public d V;
    public d[] W;
    public ArrayList X;
    public boolean[] Y;
    public b[] Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public e f3458a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3460b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0.c f3461c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f3462c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0.c f3463d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f3464d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f3466e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f3468f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f3470g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f3472h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3474i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f3476j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f3478k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3480l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3482m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3484n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3485o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f3486o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f3488p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public Object f3490q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f3492r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3494s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f3496t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f3498u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f3500v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f3502w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f3504x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f3506y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f3508z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3457a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p[] f3459b = new p[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f3465e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f3467f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f3469g = {true, true};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3471h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3473i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3475j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3477k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3479l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3481m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b0.a f3483n = new b0.a(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3487p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3489q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3491r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3493s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3495t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3497u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3499v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3501w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3503x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f3505y = new int[2];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3507z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    public int F = -1;
    public float G = 1.0f;
    public int[] H = {a.e.API_PRIORITY_OTHER, a.e.API_PRIORITY_OTHER};
    public float I = 0.0f;
    public boolean J = false;
    public boolean L = false;
    public int M = 0;
    public int N = 0;
    public d O = new d(this, d.b.LEFT);
    public d P = new d(this, d.b.TOP);
    public d Q = new d(this, d.b.RIGHT);
    public d R = new d(this, d.b.BOTTOM);
    public d S = new d(this, d.b.BASELINE);
    public d T = new d(this, d.b.CENTER_X);
    public d U = new d(this, d.b.CENTER_Y);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3510b;

        static {
            int[] iArr = new int[b.values().length];
            f3510b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3510b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3510b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3510b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f3509a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3509a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3509a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3509a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3509a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3509a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3509a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3509a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3509a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.V = dVar;
        this.W = new d[]{this.O, this.Q, this.P, this.R, this.S, dVar};
        this.X = new ArrayList();
        this.Y = new boolean[2];
        b bVar = b.FIXED;
        this.Z = new b[]{bVar, bVar};
        this.f3458a0 = null;
        this.f3460b0 = 0;
        this.f3462c0 = 0;
        this.f3464d0 = 0.0f;
        this.f3466e0 = -1;
        this.f3468f0 = 0;
        this.f3470g0 = 0;
        this.f3472h0 = 0;
        this.f3474i0 = 0;
        this.f3476j0 = 0;
        this.f3478k0 = 0;
        this.f3480l0 = 0;
        float f10 = K0;
        this.f3486o0 = f10;
        this.f3488p0 = f10;
        this.f3492r0 = 0;
        this.f3494s0 = 0;
        this.f3496t0 = false;
        this.f3498u0 = null;
        this.f3500v0 = null;
        this.f3506y0 = false;
        this.f3508z0 = 0;
        this.A0 = 0;
        this.D0 = new float[]{-1.0f, -1.0f};
        this.E0 = new e[]{null, null};
        this.F0 = new e[]{null, null};
        this.G0 = null;
        this.H0 = null;
        this.I0 = -1;
        this.J0 = -1;
        d();
    }

    public int A() {
        return this.M;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L90
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L90
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = r4
            goto L36
        L35:
            r3 = r5
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L86
            int r2 = r9.length()
            if (r2 <= 0) goto L86
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L86:
            r9 = r0
        L87:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8f
            r8.f3464d0 = r9
            r8.f3466e0 = r5
        L8f:
            return
        L90:
            r8.f3464d0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.e.A0(java.lang.String):void");
    }

    public int B() {
        return this.N;
    }

    public void B0(int i10) {
        if (this.J) {
            int i11 = i10 - this.f3480l0;
            int i12 = this.f3462c0 + i11;
            this.f3470g0 = i11;
            this.P.s(i11);
            this.R.s(i12);
            this.S.s(i10);
            this.f3489q = true;
        }
    }

    public int C(int i10) {
        if (i10 == 0) {
            return U();
        }
        if (i10 == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i10, int i11) {
        if (this.f3487p) {
            return;
        }
        this.O.s(i10);
        this.Q.s(i11);
        this.f3468f0 = i10;
        this.f3460b0 = i11 - i10;
        this.f3487p = true;
    }

    public int D() {
        return this.H[1];
    }

    public void D0(int i10) {
        this.O.s(i10);
        this.f3468f0 = i10;
    }

    public int E() {
        return this.H[0];
    }

    public void E0(int i10) {
        this.P.s(i10);
        this.f3470g0 = i10;
    }

    public int F() {
        return this.f3484n0;
    }

    public void F0(int i10, int i11) {
        if (this.f3489q) {
            return;
        }
        this.P.s(i10);
        this.R.s(i11);
        this.f3470g0 = i10;
        this.f3462c0 = i11 - i10;
        if (this.J) {
            this.S.s(i10 + this.f3480l0);
        }
        this.f3489q = true;
    }

    public int G() {
        return this.f3482m0;
    }

    public void G0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f3468f0 = i10;
        this.f3470g0 = i11;
        if (this.f3494s0 == 8) {
            this.f3460b0 = 0;
            this.f3462c0 = 0;
            return;
        }
        b[] bVarArr = this.Z;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.f3460b0)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.f3462c0)) {
            i17 = i14;
        }
        this.f3460b0 = i16;
        this.f3462c0 = i17;
        int i18 = this.f3484n0;
        if (i17 < i18) {
            this.f3462c0 = i18;
        }
        int i19 = this.f3482m0;
        if (i16 < i19) {
            this.f3460b0 = i19;
        }
        int i20 = this.A;
        if (i20 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f3460b0 = Math.min(this.f3460b0, i20);
        }
        int i21 = this.D;
        if (i21 > 0 && this.Z[1] == b.MATCH_CONSTRAINT) {
            this.f3462c0 = Math.min(this.f3462c0, i21);
        }
        int i22 = this.f3460b0;
        if (i16 != i22) {
            this.f3479l = i22;
        }
        int i23 = this.f3462c0;
        if (i17 != i23) {
            this.f3481m = i23;
        }
    }

    public e H(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.R).f3442f) != null && dVar2.f3442f == dVar) {
                return dVar2.f3440d;
            }
            return null;
        }
        d dVar3 = this.Q;
        d dVar4 = dVar3.f3442f;
        if (dVar4 == null || dVar4.f3442f != dVar3) {
            return null;
        }
        return dVar4.f3440d;
    }

    public void H0(boolean z10) {
        this.J = z10;
    }

    public e I() {
        return this.f3458a0;
    }

    public void I0(int i10) {
        this.f3462c0 = i10;
        int i11 = this.f3484n0;
        if (i10 < i11) {
            this.f3462c0 = i11;
        }
    }

    public e J(int i10) {
        d dVar;
        d dVar2;
        if (i10 != 0) {
            if (i10 == 1 && (dVar2 = (dVar = this.P).f3442f) != null && dVar2.f3442f == dVar) {
                return dVar2.f3440d;
            }
            return null;
        }
        d dVar3 = this.O;
        d dVar4 = dVar3.f3442f;
        if (dVar4 == null || dVar4.f3442f != dVar3) {
            return null;
        }
        return dVar4.f3440d;
    }

    public void J0(float f10) {
        this.f3486o0 = f10;
    }

    public int K() {
        return V() + this.f3460b0;
    }

    public void K0(int i10) {
        this.f3508z0 = i10;
    }

    public p L(int i10) {
        if (i10 == 0) {
            return this.f3465e;
        }
        if (i10 == 1) {
            return this.f3467f;
        }
        return null;
    }

    public void L0(int i10, int i11) {
        this.f3468f0 = i10;
        int i12 = i11 - i10;
        this.f3460b0 = i12;
        int i13 = this.f3482m0;
        if (i12 < i13) {
            this.f3460b0 = i13;
        }
    }

    public void M(StringBuilder sb2) {
        sb2.append("  " + this.f3485o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f3460b0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f3462c0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f3468f0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f3470g0);
        sb2.append("\n");
        O(sb2, "left", this.O);
        O(sb2, "top", this.P);
        O(sb2, "right", this.Q);
        O(sb2, "bottom", this.R);
        O(sb2, "baseline", this.S);
        O(sb2, "centerX", this.T);
        O(sb2, "centerY", this.U);
        N(sb2, "    width", this.f3460b0, this.f3482m0, this.H[0], this.f3479l, this.f3507z, this.f3501w, this.B, this.D0[0]);
        N(sb2, "    height", this.f3462c0, this.f3484n0, this.H[1], this.f3481m, this.C, this.f3503x, this.E, this.D0[1]);
        w0(sb2, "    dimensionRatio", this.f3464d0, this.f3466e0);
        u0(sb2, "    horizontalBias", this.f3486o0, K0);
        u0(sb2, "    verticalBias", this.f3488p0, K0);
        v0(sb2, "    horizontalChainStyle", this.f3508z0, 0);
        v0(sb2, "    verticalChainStyle", this.A0, 0);
        sb2.append("  }");
    }

    public void M0(b bVar) {
        this.Z[0] = bVar;
    }

    public final void N(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        v0(sb2, "      size", i10, 0);
        v0(sb2, "      min", i11, 0);
        v0(sb2, "      max", i12, a.e.API_PRIORITY_OTHER);
        v0(sb2, "      matchMin", i14, 0);
        v0(sb2, "      matchDef", i15, 0);
        u0(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    public void N0(int i10, int i11, int i12, float f10) {
        this.f3501w = i10;
        this.f3507z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.A = i12;
        this.B = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f3501w = 2;
    }

    public final void O(StringBuilder sb2, String str, d dVar) {
        if (dVar.f3442f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(dVar.f3442f);
        sb2.append("'");
        if (dVar.f3444h != Integer.MIN_VALUE || dVar.f3443g != 0) {
            sb2.append(com.amazon.a.a.o.b.f.f4598a);
            sb2.append(dVar.f3443g);
            if (dVar.f3444h != Integer.MIN_VALUE) {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
                sb2.append(dVar.f3444h);
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
        }
        sb2.append(" ] ,\n");
    }

    public void O0(float f10) {
        this.D0[0] = f10;
    }

    public float P() {
        return this.f3488p0;
    }

    public void P0(int i10, boolean z10) {
        this.Y[i10] = z10;
    }

    public int Q() {
        return this.A0;
    }

    public void Q0(boolean z10) {
        this.K = z10;
    }

    public b R() {
        return this.Z[1];
    }

    public void R0(int i10, int i11) {
        this.M = i10;
        this.N = i11;
        U0(false);
    }

    public int S() {
        int i10 = this.O != null ? this.P.f3443g : 0;
        return this.Q != null ? i10 + this.R.f3443g : i10;
    }

    public void S0(int i10) {
        this.H[1] = i10;
    }

    public int T() {
        return this.f3494s0;
    }

    public void T0(int i10) {
        this.H[0] = i10;
    }

    public int U() {
        if (this.f3494s0 == 8) {
            return 0;
        }
        return this.f3460b0;
    }

    public void U0(boolean z10) {
        this.f3473i = z10;
    }

    public int V() {
        e eVar = this.f3458a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f3468f0 : ((f) eVar).S0 + this.f3468f0;
    }

    public void V0(int i10) {
        if (i10 < 0) {
            this.f3484n0 = 0;
        } else {
            this.f3484n0 = i10;
        }
    }

    public int W() {
        e eVar = this.f3458a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f3470g0 : ((f) eVar).T0 + this.f3470g0;
    }

    public void W0(int i10) {
        if (i10 < 0) {
            this.f3482m0 = 0;
        } else {
            this.f3482m0 = i10;
        }
    }

    public boolean X() {
        return this.J;
    }

    public void X0(int i10, int i11) {
        this.f3468f0 = i10;
        this.f3470g0 = i11;
    }

    public boolean Y(int i10) {
        if (i10 == 0) {
            return (this.O.f3442f != null ? 1 : 0) + (this.Q.f3442f != null ? 1 : 0) < 2;
        }
        return ((this.P.f3442f != null ? 1 : 0) + (this.R.f3442f != null ? 1 : 0)) + (this.S.f3442f != null ? 1 : 0) < 2;
    }

    public void Y0(e eVar) {
        this.f3458a0 = eVar;
    }

    public boolean Z() {
        int size = this.X.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((d) this.X.get(i10)).l()) {
                return true;
            }
        }
        return false;
    }

    public void Z0(float f10) {
        this.f3488p0 = f10;
    }

    public boolean a0() {
        return (this.f3479l == -1 && this.f3481m == -1) ? false : true;
    }

    public void a1(int i10) {
        this.A0 = i10;
    }

    public boolean b0(int i10, int i11) {
        d dVar;
        d dVar2;
        if (i10 == 0) {
            d dVar3 = this.O.f3442f;
            return dVar3 != null && dVar3.m() && (dVar2 = this.Q.f3442f) != null && dVar2.m() && (this.Q.f3442f.d() - this.Q.e()) - (this.O.f3442f.d() + this.O.e()) >= i11;
        }
        d dVar4 = this.P.f3442f;
        if (dVar4 != null && dVar4.m() && (dVar = this.R.f3442f) != null && dVar.m() && (this.R.f3442f.d() - this.R.e()) - (this.P.f3442f.d() + this.P.e()) >= i11) {
            return true;
        }
        return false;
    }

    public void b1(int i10, int i11) {
        this.f3470g0 = i10;
        int i12 = i11 - i10;
        this.f3462c0 = i12;
        int i13 = this.f3484n0;
        if (i12 < i13) {
            this.f3462c0 = i13;
        }
    }

    public void c0(d.b bVar, e eVar, d.b bVar2, int i10, int i11) {
        m(bVar).a(eVar.m(bVar2), i10, i11, true);
    }

    public void c1(b bVar) {
        this.Z[1] = bVar;
    }

    public final void d() {
        this.X.add(this.O);
        this.X.add(this.P);
        this.X.add(this.Q);
        this.X.add(this.R);
        this.X.add(this.T);
        this.X.add(this.U);
        this.X.add(this.V);
        this.X.add(this.S);
    }

    public final boolean d0(int i10) {
        d dVar;
        d dVar2;
        int i11 = i10 * 2;
        d[] dVarArr = this.W;
        d dVar3 = dVarArr[i11];
        d dVar4 = dVar3.f3442f;
        return (dVar4 == null || dVar4.f3442f == dVar3 || (dVar2 = (dVar = dVarArr[i11 + 1]).f3442f) == null || dVar2.f3442f != dVar) ? false : true;
    }

    public void d1(int i10, int i11, int i12, float f10) {
        this.f3503x = i10;
        this.C = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.D = i12;
        this.E = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f3503x = 2;
    }

    public void e(f fVar, z.d dVar, HashSet hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.O1(64));
        }
        if (i10 == 0) {
            HashSet hashSetC = this.O.c();
            if (hashSetC != null) {
                Iterator it = hashSetC.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f3440d.e(fVar, dVar, hashSet, i10, true);
                }
            }
            HashSet hashSetC2 = this.Q.c();
            if (hashSetC2 != null) {
                Iterator it2 = hashSetC2.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f3440d.e(fVar, dVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet hashSetC3 = this.P.c();
        if (hashSetC3 != null) {
            Iterator it3 = hashSetC3.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f3440d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet hashSetC4 = this.R.c();
        if (hashSetC4 != null) {
            Iterator it4 = hashSetC4.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f3440d.e(fVar, dVar, hashSet, i10, true);
            }
        }
        HashSet hashSetC5 = this.S.c();
        if (hashSetC5 != null) {
            Iterator it5 = hashSetC5.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f3440d.e(fVar, dVar, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        return this.f3491r;
    }

    public void e1(float f10) {
        this.D0[1] = f10;
    }

    public boolean f() {
        return this instanceof g;
    }

    public boolean f0(int i10) {
        return this.Y[i10];
    }

    public void f1(int i10) {
        this.f3494s0 = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x056f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(z.d r51, boolean r52) {
        /*
            Method dump skipped, instruction units count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.e.g(z.d, boolean):void");
    }

    public boolean g0() {
        d dVar = this.O;
        d dVar2 = dVar.f3442f;
        if (dVar2 != null && dVar2.f3442f == dVar) {
            return true;
        }
        d dVar3 = this.Q;
        d dVar4 = dVar3.f3442f;
        return dVar4 != null && dVar4.f3442f == dVar3;
    }

    public void g1(int i10) {
        this.f3460b0 = i10;
        int i11 = this.f3482m0;
        if (i10 < i11) {
            this.f3460b0 = i11;
        }
    }

    public boolean h() {
        return this.f3494s0 != 8;
    }

    public boolean h0() {
        return this.K;
    }

    public void h1(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.f3499v = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0557 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(z.d r31, boolean r32, boolean r33, boolean r34, boolean r35, z.i r36, z.i r37, c0.e.b r38, boolean r39, c0.d r40, c0.d r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instruction units count: 1430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.e.i(z.d, boolean, boolean, boolean, boolean, z.i, z.i, c0.e$b, boolean, c0.d, c0.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public boolean i0() {
        d dVar = this.P;
        d dVar2 = dVar.f3442f;
        if (dVar2 != null && dVar2.f3442f == dVar) {
            return true;
        }
        d dVar3 = this.R;
        d dVar4 = dVar3.f3442f;
        return dVar4 != null && dVar4.f3442f == dVar3;
    }

    public void i1(int i10) {
        this.f3468f0 = i10;
    }

    public void j(e eVar, float f10, int i10) {
        d.b bVar = d.b.CENTER;
        c0(bVar, eVar, bVar, i10, 0);
        this.I = f10;
    }

    public boolean j0() {
        return this.L;
    }

    public void j1(int i10) {
        this.f3470g0 = i10;
    }

    public void k(z.d dVar) {
        dVar.q(this.O);
        dVar.q(this.P);
        dVar.q(this.Q);
        dVar.q(this.R);
        if (this.f3480l0 > 0) {
            dVar.q(this.S);
        }
    }

    public boolean k0() {
        return this.f3473i && this.f3494s0 != 8;
    }

    public void k1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.F == -1) {
            if (z12 && !z13) {
                this.F = 0;
            } else if (!z12 && z13) {
                this.F = 1;
                if (this.f3466e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (this.F == 0 && (!this.P.n() || !this.R.n())) {
            this.F = 1;
        } else if (this.F == 1 && (!this.O.n() || !this.Q.n())) {
            this.F = 0;
        }
        if (this.F == -1 && (!this.P.n() || !this.R.n() || !this.O.n() || !this.Q.n())) {
            if (this.P.n() && this.R.n()) {
                this.F = 0;
            } else if (this.O.n() && this.Q.n()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            int i10 = this.f3507z;
            if (i10 > 0 && this.C == 0) {
                this.F = 0;
            } else {
                if (i10 != 0 || this.C <= 0) {
                    return;
                }
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }

    public void l() {
        if (this.f3465e == null) {
            this.f3465e = new l(this);
        }
        if (this.f3467f == null) {
            this.f3467f = new n(this);
        }
    }

    public boolean l0() {
        if (this.f3487p) {
            return true;
        }
        return this.O.m() && this.Q.m();
    }

    public void l1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zK = z10 & this.f3465e.k();
        boolean zK2 = z11 & this.f3467f.k();
        l lVar = this.f3465e;
        int i12 = lVar.f7484h.f7430g;
        n nVar = this.f3467f;
        int i13 = nVar.f7484h.f7430g;
        int i14 = lVar.f7485i.f7430g;
        int i15 = nVar.f7485i.f7430g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zK) {
            this.f3468f0 = i12;
        }
        if (zK2) {
            this.f3470g0 = i13;
        }
        if (this.f3494s0 == 8) {
            this.f3460b0 = 0;
            this.f3462c0 = 0;
            return;
        }
        if (zK) {
            if (this.Z[0] == b.FIXED && i17 < (i11 = this.f3460b0)) {
                i17 = i11;
            }
            this.f3460b0 = i17;
            int i19 = this.f3482m0;
            if (i17 < i19) {
                this.f3460b0 = i19;
            }
        }
        if (zK2) {
            if (this.Z[1] == b.FIXED && i18 < (i10 = this.f3462c0)) {
                i18 = i10;
            }
            this.f3462c0 = i18;
            int i20 = this.f3484n0;
            if (i18 < i20) {
                this.f3462c0 = i20;
            }
        }
    }

    public d m(d.b bVar) {
        switch (a.f3509a[bVar.ordinal()]) {
            case 1:
                return this.O;
            case 2:
                return this.P;
            case 3:
                return this.Q;
            case 4:
                return this.R;
            case 5:
                return this.S;
            case 6:
                return this.V;
            case 7:
                return this.T;
            case 8:
                return this.U;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean m0() {
        if (this.f3489q) {
            return true;
        }
        return this.P.m() && this.R.m();
    }

    public void m1(z.d dVar, boolean z10) {
        n nVar;
        l lVar;
        int iX = dVar.x(this.O);
        int iX2 = dVar.x(this.P);
        int iX3 = dVar.x(this.Q);
        int iX4 = dVar.x(this.R);
        if (z10 && (lVar = this.f3465e) != null) {
            d0.f fVar = lVar.f7484h;
            if (fVar.f7433j) {
                d0.f fVar2 = lVar.f7485i;
                if (fVar2.f7433j) {
                    iX = fVar.f7430g;
                    iX3 = fVar2.f7430g;
                }
            }
        }
        if (z10 && (nVar = this.f3467f) != null) {
            d0.f fVar3 = nVar.f7484h;
            if (fVar3.f7433j) {
                d0.f fVar4 = nVar.f7485i;
                if (fVar4.f7433j) {
                    iX2 = fVar3.f7430g;
                    iX4 = fVar4.f7430g;
                }
            }
        }
        int i10 = iX4 - iX2;
        if (iX3 - iX < 0 || i10 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX = 0;
            iX4 = 0;
            iX2 = 0;
            iX3 = 0;
        }
        G0(iX, iX2, iX3, iX4);
    }

    public int n() {
        return this.f3480l0;
    }

    public boolean n0() {
        return this.f3493s;
    }

    public float o(int i10) {
        if (i10 == 0) {
            return this.f3486o0;
        }
        if (i10 == 1) {
            return this.f3488p0;
        }
        return -1.0f;
    }

    public void o0() {
        this.f3491r = true;
    }

    public int p() {
        return W() + this.f3462c0;
    }

    public void p0() {
        this.f3493s = true;
    }

    public Object q() {
        return this.f3490q0;
    }

    public boolean q0() {
        b[] bVarArr = this.Z;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String r() {
        return this.f3498u0;
    }

    public void r0() {
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        this.S.p();
        this.T.p();
        this.U.p();
        this.V.p();
        this.f3458a0 = null;
        this.I = 0.0f;
        this.f3460b0 = 0;
        this.f3462c0 = 0;
        this.f3464d0 = 0.0f;
        this.f3466e0 = -1;
        this.f3468f0 = 0;
        this.f3470g0 = 0;
        this.f3476j0 = 0;
        this.f3478k0 = 0;
        this.f3480l0 = 0;
        this.f3482m0 = 0;
        this.f3484n0 = 0;
        float f10 = K0;
        this.f3486o0 = f10;
        this.f3488p0 = f10;
        b[] bVarArr = this.Z;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f3490q0 = null;
        this.f3492r0 = 0;
        this.f3494s0 = 0;
        this.f3500v0 = null;
        this.f3502w0 = false;
        this.f3504x0 = false;
        this.f3508z0 = 0;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        float[] fArr = this.D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f3495t = -1;
        this.f3497u = -1;
        int[] iArr = this.H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f3501w = 0;
        this.f3503x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = a.e.API_PRIORITY_OTHER;
        this.D = a.e.API_PRIORITY_OTHER;
        this.f3507z = 0;
        this.C = 0;
        this.f3471h = false;
        this.F = -1;
        this.G = 1.0f;
        this.f3506y0 = false;
        boolean[] zArr = this.f3469g;
        zArr[0] = true;
        zArr[1] = true;
        this.L = false;
        boolean[] zArr2 = this.Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3473i = true;
        int[] iArr2 = this.f3505y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f3479l = -1;
        this.f3481m = -1;
    }

    public b s(int i10) {
        if (i10 == 0) {
            return y();
        }
        if (i10 == 1) {
            return R();
        }
        return null;
    }

    public void s0() {
        this.f3487p = false;
        this.f3489q = false;
        this.f3491r = false;
        this.f3493s = false;
        int size = this.X.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((d) this.X.get(i10)).q();
        }
    }

    public float t() {
        return this.f3464d0;
    }

    public void t0(z.c cVar) {
        this.O.r(cVar);
        this.P.r(cVar);
        this.Q.r(cVar);
        this.R.r(cVar);
        this.S.r(cVar);
        this.V.r(cVar);
        this.T.r(cVar);
        this.U.r(cVar);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f3500v0 != null) {
            str = "type: " + this.f3500v0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f3498u0 != null) {
            str2 = "id: " + this.f3498u0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f3468f0);
        sb2.append(", ");
        sb2.append(this.f3470g0);
        sb2.append(") - (");
        sb2.append(this.f3460b0);
        sb2.append(" x ");
        sb2.append(this.f3462c0);
        sb2.append(")");
        return sb2.toString();
    }

    public int u() {
        return this.f3466e0;
    }

    public final void u0(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    public int v() {
        if (this.f3494s0 == 8) {
            return 0;
        }
        return this.f3462c0;
    }

    public final void v0(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public float w() {
        return this.f3486o0;
    }

    public final void w0(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f10);
        sb2.append(com.amazon.a.a.o.b.f.f4598a);
        sb2.append(i10);
        sb2.append("");
        sb2.append("],\n");
    }

    public int x() {
        return this.f3508z0;
    }

    public void x0(int i10) {
        this.f3480l0 = i10;
        this.J = i10 > 0;
    }

    public b y() {
        return this.Z[0];
    }

    public void y0(Object obj) {
        this.f3490q0 = obj;
    }

    public int z() {
        d dVar = this.O;
        int i10 = dVar != null ? dVar.f3443g : 0;
        d dVar2 = this.Q;
        return dVar2 != null ? i10 + dVar2.f3443g : i10;
    }

    public void z0(String str) {
        this.f3498u0 = str;
    }
}
