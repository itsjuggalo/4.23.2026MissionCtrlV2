package bf;

import gf.j;
import ze.c;
import ze.k;
import ze.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final C0061b A;
    public static final C0061b B;
    public static final C0061b C;
    public static final C0061b D;
    public static final C0061b E;
    public static final C0061b F;
    public static final C0061b G;
    public static final C0061b H;
    public static final C0061b I;
    public static final C0061b J;
    public static final C0061b K;
    public static final C0061b L;
    public static final C0061b M;
    public static final C0061b N;
    public static final C0061b O;
    public static final C0061b P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0061b f3315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0061b f3316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0061b f3317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f3318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f3319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f3320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0061b f3321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0061b f3322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0061b f3323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0061b f3324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0061b f3325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0061b f3326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0061b f3327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0061b f3328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0061b f3329o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f3330p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final C0061b f3331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0061b f3332r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0061b f3333s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final C0061b f3334t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final C0061b f3335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0061b f3336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C0061b f3337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C0061b f3338x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final C0061b f3339y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final C0061b f3340z;

    /* JADX INFO: renamed from: bf.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0061b extends d {
        public C0061b(int i10) {
            super(i10, 1);
        }

        @Override // bf.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i10) {
            return Boolean.valueOf((i10 & (1 << this.f3342a)) != 0);
        }

        @Override // bf.b.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f3342a;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j.a[] f3341c;

        public c(int i10, j.a[] aVarArr) {
            super(i10, g(aVarArr));
            this.f3341c = aVarArr;
        }

        private static /* synthetic */ void f(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public static int g(Object[] objArr) {
            if (objArr == null) {
                f(0);
            }
            int length = objArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    return i10 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + objArr.getClass());
        }

        @Override // bf.b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public j.a d(int i10) {
            int i11 = (1 << this.f3343b) - 1;
            int i12 = this.f3342a;
            int i13 = (i10 & (i11 << i12)) >> i12;
            for (j.a aVar : this.f3341c) {
                if (aVar.d() == i13) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // bf.b.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(j.a aVar) {
            return aVar.d() << this.f3342a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3343b;

        public static d a(d dVar, j.a[] aVarArr) {
            return new c(dVar.f3342a + dVar.f3343b, aVarArr);
        }

        public static C0061b b(d dVar) {
            return new C0061b(dVar.f3342a + dVar.f3343b);
        }

        public static C0061b c() {
            return new C0061b(0);
        }

        public abstract Object d(int i10);

        public abstract int e(Object obj);

        public d(int i10, int i11) {
            this.f3342a = i10;
            this.f3343b = i11;
        }
    }

    static {
        C0061b c0061bC = d.c();
        f3315a = c0061bC;
        f3316b = d.b(c0061bC);
        C0061b c0061bC2 = d.c();
        f3317c = c0061bC2;
        d dVarA = d.a(c0061bC2, x.values());
        f3318d = dVarA;
        d dVarA2 = d.a(dVarA, k.values());
        f3319e = dVarA2;
        d dVarA3 = d.a(dVarA2, c.EnumC0494c.values());
        f3320f = dVarA3;
        C0061b c0061bB = d.b(dVarA3);
        f3321g = c0061bB;
        C0061b c0061bB2 = d.b(c0061bB);
        f3322h = c0061bB2;
        C0061b c0061bB3 = d.b(c0061bB2);
        f3323i = c0061bB3;
        C0061b c0061bB4 = d.b(c0061bB3);
        f3324j = c0061bB4;
        C0061b c0061bB5 = d.b(c0061bB4);
        f3325k = c0061bB5;
        C0061b c0061bB6 = d.b(c0061bB5);
        f3326l = c0061bB6;
        f3327m = d.b(c0061bB6);
        C0061b c0061bB7 = d.b(dVarA);
        f3328n = c0061bB7;
        f3329o = d.b(c0061bB7);
        d dVarA4 = d.a(dVarA2, ze.j.values());
        f3330p = dVarA4;
        C0061b c0061bB8 = d.b(dVarA4);
        f3331q = c0061bB8;
        C0061b c0061bB9 = d.b(c0061bB8);
        f3332r = c0061bB9;
        C0061b c0061bB10 = d.b(c0061bB9);
        f3333s = c0061bB10;
        C0061b c0061bB11 = d.b(c0061bB10);
        f3334t = c0061bB11;
        C0061b c0061bB12 = d.b(c0061bB11);
        f3335u = c0061bB12;
        C0061b c0061bB13 = d.b(c0061bB12);
        f3336v = c0061bB13;
        C0061b c0061bB14 = d.b(c0061bB13);
        f3337w = c0061bB14;
        f3338x = d.b(c0061bB14);
        C0061b c0061bB15 = d.b(dVarA4);
        f3339y = c0061bB15;
        C0061b c0061bB16 = d.b(c0061bB15);
        f3340z = c0061bB16;
        C0061b c0061bB17 = d.b(c0061bB16);
        A = c0061bB17;
        C0061b c0061bB18 = d.b(c0061bB17);
        B = c0061bB18;
        C0061b c0061bB19 = d.b(c0061bB18);
        C = c0061bB19;
        C0061b c0061bB20 = d.b(c0061bB19);
        D = c0061bB20;
        C0061b c0061bB21 = d.b(c0061bB20);
        E = c0061bB21;
        C0061b c0061bB22 = d.b(c0061bB21);
        F = c0061bB22;
        G = d.b(c0061bB22);
        C0061b c0061bB23 = d.b(c0061bC2);
        H = c0061bB23;
        C0061b c0061bB24 = d.b(c0061bB23);
        I = c0061bB24;
        J = d.b(c0061bB24);
        C0061b c0061bB25 = d.b(dVarA2);
        K = c0061bB25;
        C0061b c0061bB26 = d.b(c0061bB25);
        L = c0061bB26;
        M = d.b(c0061bB26);
        C0061b c0061bC3 = d.c();
        N = c0061bC3;
        O = d.b(c0061bC3);
        P = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r2 = 2
            r3 = 1
            if (r5 == r3) goto L2b
            if (r5 == r2) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r1] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r1] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r1] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r1] = r4
        L2f:
            java.lang.String r1 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r3] = r1
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r2] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r2] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r2] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r2] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r2] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.b.a(int):void");
    }

    public static int b(boolean z10, x xVar, k kVar, boolean z11, boolean z12, boolean z13) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f3317c.e(Boolean.valueOf(z10)) | f3319e.e(kVar) | f3318d.e(xVar) | K.e(Boolean.valueOf(z11)) | L.e(Boolean.valueOf(z12)) | M.e(Boolean.valueOf(z13));
    }
}
