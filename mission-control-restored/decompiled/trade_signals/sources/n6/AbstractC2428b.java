package n6;

import l6.c;
import l6.j;
import l6.k;
import l6.x;
import s6.AbstractC2723j;

/* JADX INFO: renamed from: n6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2428b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final C0361b f21626A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final C0361b f21627B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final C0361b f21628C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final C0361b f21629D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final C0361b f21630E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final C0361b f21631F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final C0361b f21632G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final C0361b f21633H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final C0361b f21634I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final C0361b f21635J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final C0361b f21636K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final C0361b f21637L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final C0361b f21638M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final C0361b f21639N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final C0361b f21640O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final C0361b f21641P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0361b f21642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0361b f21643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0361b f21644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f21645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f21646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f21647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0361b f21648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0361b f21649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0361b f21650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0361b f21651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0361b f21652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0361b f21653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0361b f21654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0361b f21655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0361b f21656o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f21657p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final C0361b f21658q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0361b f21659r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0361b f21660s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final C0361b f21661t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final C0361b f21662u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0361b f21663v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C0361b f21664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C0361b f21665x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final C0361b f21666y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final C0361b f21667z;

    /* JADX INFO: renamed from: n6.b$b, reason: collision with other inner class name */
    public static class C0361b extends d {
        public C0361b(int i8) {
            super(i8, 1);
        }

        @Override // n6.AbstractC2428b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i8) {
            return Boolean.valueOf((i8 & (1 << this.f21669a)) != 0);
        }

        @Override // n6.AbstractC2428b.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f21669a;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: n6.b$c */
    public static class c extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC2723j.a[] f21668c;

        public c(int i8, AbstractC2723j.a[] aVarArr) {
            super(i8, g(aVarArr));
            this.f21668c = aVarArr;
        }

        private static /* synthetic */ void f(int i8) {
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
            for (int i8 = 31; i8 >= 0; i8--) {
                if (((1 << i8) & length) != 0) {
                    return i8 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + objArr.getClass());
        }

        @Override // n6.AbstractC2428b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public AbstractC2723j.a d(int i8) {
            int i9 = (1 << this.f21670b) - 1;
            int i10 = this.f21669a;
            int i11 = (i8 & (i9 << i10)) >> i10;
            for (AbstractC2723j.a aVar : this.f21668c) {
                if (aVar.d() == i11) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // n6.AbstractC2428b.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(AbstractC2723j.a aVar) {
            return aVar.d() << this.f21669a;
        }
    }

    /* JADX INFO: renamed from: n6.b$d */
    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21670b;

        public d(int i8, int i9) {
            this.f21669a = i8;
            this.f21670b = i9;
        }

        public static d a(d dVar, AbstractC2723j.a[] aVarArr) {
            return new c(dVar.f21669a + dVar.f21670b, aVarArr);
        }

        public static C0361b b(d dVar) {
            return new C0361b(dVar.f21669a + dVar.f21670b);
        }

        public static C0361b c() {
            return new C0361b(0);
        }

        public abstract Object d(int i8);

        public abstract int e(Object obj);
    }

    static {
        C0361b c0361bC = d.c();
        f21642a = c0361bC;
        f21643b = d.b(c0361bC);
        C0361b c0361bC2 = d.c();
        f21644c = c0361bC2;
        d dVarA = d.a(c0361bC2, x.values());
        f21645d = dVarA;
        d dVarA2 = d.a(dVarA, k.values());
        f21646e = dVarA2;
        d dVarA3 = d.a(dVarA2, c.EnumC0352c.values());
        f21647f = dVarA3;
        C0361b c0361bB = d.b(dVarA3);
        f21648g = c0361bB;
        C0361b c0361bB2 = d.b(c0361bB);
        f21649h = c0361bB2;
        C0361b c0361bB3 = d.b(c0361bB2);
        f21650i = c0361bB3;
        C0361b c0361bB4 = d.b(c0361bB3);
        f21651j = c0361bB4;
        C0361b c0361bB5 = d.b(c0361bB4);
        f21652k = c0361bB5;
        C0361b c0361bB6 = d.b(c0361bB5);
        f21653l = c0361bB6;
        f21654m = d.b(c0361bB6);
        C0361b c0361bB7 = d.b(dVarA);
        f21655n = c0361bB7;
        f21656o = d.b(c0361bB7);
        d dVarA4 = d.a(dVarA2, j.values());
        f21657p = dVarA4;
        C0361b c0361bB8 = d.b(dVarA4);
        f21658q = c0361bB8;
        C0361b c0361bB9 = d.b(c0361bB8);
        f21659r = c0361bB9;
        C0361b c0361bB10 = d.b(c0361bB9);
        f21660s = c0361bB10;
        C0361b c0361bB11 = d.b(c0361bB10);
        f21661t = c0361bB11;
        C0361b c0361bB12 = d.b(c0361bB11);
        f21662u = c0361bB12;
        C0361b c0361bB13 = d.b(c0361bB12);
        f21663v = c0361bB13;
        C0361b c0361bB14 = d.b(c0361bB13);
        f21664w = c0361bB14;
        f21665x = d.b(c0361bB14);
        C0361b c0361bB15 = d.b(dVarA4);
        f21666y = c0361bB15;
        C0361b c0361bB16 = d.b(c0361bB15);
        f21667z = c0361bB16;
        C0361b c0361bB17 = d.b(c0361bB16);
        f21626A = c0361bB17;
        C0361b c0361bB18 = d.b(c0361bB17);
        f21627B = c0361bB18;
        C0361b c0361bB19 = d.b(c0361bB18);
        f21628C = c0361bB19;
        C0361b c0361bB20 = d.b(c0361bB19);
        f21629D = c0361bB20;
        C0361b c0361bB21 = d.b(c0361bB20);
        f21630E = c0361bB21;
        C0361b c0361bB22 = d.b(c0361bB21);
        f21631F = c0361bB22;
        f21632G = d.b(c0361bB22);
        C0361b c0361bB23 = d.b(c0361bC2);
        f21633H = c0361bB23;
        C0361b c0361bB24 = d.b(c0361bB23);
        f21634I = c0361bB24;
        f21635J = d.b(c0361bB24);
        C0361b c0361bB25 = d.b(dVarA2);
        f21636K = c0361bB25;
        C0361b c0361bB26 = d.b(c0361bB25);
        f21637L = c0361bB26;
        f21638M = d.b(c0361bB26);
        C0361b c0361bC3 = d.c();
        f21639N = c0361bC3;
        f21640O = d.b(c0361bC3);
        f21641P = d.c();
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
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
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
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
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
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n6.AbstractC2428b.a(int):void");
    }

    public static int b(boolean z7, x xVar, k kVar, boolean z8, boolean z9, boolean z10) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f21644c.e(Boolean.valueOf(z7)) | f21646e.e(kVar) | f21645d.e(xVar) | f21636K.e(Boolean.valueOf(z8)) | f21637L.e(Boolean.valueOf(z9)) | f21638M.e(Boolean.valueOf(z10));
    }
}
