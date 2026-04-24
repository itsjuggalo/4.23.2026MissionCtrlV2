package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import g.AbstractC1248a;
import g.AbstractC1249b;
import g.AbstractC1251d;
import i.AbstractC1284a;
import o.Q;
import z.AbstractC1962a;

/* JADX INFO: renamed from: o.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1639e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f13830b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C1639e f13831c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q f13832a;

    /* JADX INFO: renamed from: o.e$a */
    public static class a implements Q.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f13833a = {AbstractC1251d.f11596S, AbstractC1251d.f11594Q, AbstractC1251d.f11598a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f13834b = {AbstractC1251d.f11612o, AbstractC1251d.f11579B, AbstractC1251d.f11617t, AbstractC1251d.f11613p, AbstractC1251d.f11614q, AbstractC1251d.f11616s, AbstractC1251d.f11615r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f13835c = {AbstractC1251d.f11593P, AbstractC1251d.f11595R, AbstractC1251d.f11608k, AbstractC1251d.f11586I, AbstractC1251d.f11587J, AbstractC1251d.f11589L, AbstractC1251d.f11591N, AbstractC1251d.f11588K, AbstractC1251d.f11590M, AbstractC1251d.f11592O};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f13836d = {AbstractC1251d.f11620w, AbstractC1251d.f11606i, AbstractC1251d.f11619v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f13837e = {AbstractC1251d.f11585H, AbstractC1251d.f11597T};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f13838f = {AbstractC1251d.f11600c, AbstractC1251d.f11604g, AbstractC1251d.f11601d, AbstractC1251d.f11605h};

        @Override // o.Q.c
        public Drawable a(Q q4, Context context, int i4) {
            if (i4 == AbstractC1251d.f11607j) {
                return new LayerDrawable(new Drawable[]{q4.i(context, AbstractC1251d.f11606i), q4.i(context, AbstractC1251d.f11608k)});
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x006b A[RETURN] */
        @Override // o.Q.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = o.C1639e.a()
                int[] r1 = r6.f13833a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = g.AbstractC1248a.f11553l
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4e
            L15:
                int[] r1 = r6.f13835c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L20
                int r8 = g.AbstractC1248a.f11551j
                goto L11
            L20:
                int[] r1 = r6.f13836d
                boolean r1 = r6.f(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r0 = r4
                r8 = r5
            L30:
                r5 = r2
                goto L4e
            L32:
                int r1 = g.AbstractC1251d.f11618u
                if (r8 != r1) goto L45
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r5 = r0
                r0 = r8
                r8 = r1
                r1 = r5
                goto L30
            L45:
                int r1 = g.AbstractC1251d.f11609l
                if (r8 != r1) goto L4a
                goto L2d
            L4a:
                r1 = r0
                r8 = r3
                r5 = r8
                goto L13
            L4e:
                if (r5 == 0) goto L6b
                boolean r3 = o.G.a(r9)
                if (r3 == 0) goto L5a
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L5a:
                int r7 = o.W.b(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = o.C1639e.d(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L6a
                r9.setAlpha(r0)
            L6a:
                return r2
            L6b:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: o.C1639e.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // o.Q.c
        public PorterDuff.Mode c(int i4) {
            if (i4 == AbstractC1251d.f11583F) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // o.Q.c
        public ColorStateList d(Context context, int i4) {
            if (i4 == AbstractC1251d.f11610m) {
                return AbstractC1284a.a(context, AbstractC1249b.f11564c);
            }
            if (i4 == AbstractC1251d.f11584G) {
                return AbstractC1284a.a(context, AbstractC1249b.f11567f);
            }
            if (i4 == AbstractC1251d.f11583F) {
                return k(context);
            }
            if (i4 == AbstractC1251d.f11603f) {
                return j(context);
            }
            if (i4 == AbstractC1251d.f11599b) {
                return g(context);
            }
            if (i4 == AbstractC1251d.f11602e) {
                return i(context);
            }
            if (i4 == AbstractC1251d.f11581D || i4 == AbstractC1251d.f11582E) {
                return AbstractC1284a.a(context, AbstractC1249b.f11566e);
            }
            if (f(this.f13834b, i4)) {
                return W.d(context, AbstractC1248a.f11553l);
            }
            if (f(this.f13837e, i4)) {
                return AbstractC1284a.a(context, AbstractC1249b.f11563b);
            }
            if (f(this.f13838f, i4)) {
                return AbstractC1284a.a(context, AbstractC1249b.f11562a);
            }
            if (i4 == AbstractC1251d.f11578A) {
                return AbstractC1284a.a(context, AbstractC1249b.f11565d);
            }
            return null;
        }

        @Override // o.Q.c
        public boolean e(Context context, int i4, Drawable drawable) {
            if (i4 == AbstractC1251d.f11580C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                l(layerDrawable.findDrawableByLayerId(R.id.background), W.b(context, AbstractC1248a.f11553l), C1639e.f13830b);
                l(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), W.b(context, AbstractC1248a.f11553l), C1639e.f13830b);
                l(layerDrawable.findDrawableByLayerId(R.id.progress), W.b(context, AbstractC1248a.f11551j), C1639e.f13830b);
                return true;
            }
            if (i4 != AbstractC1251d.f11622y && i4 != AbstractC1251d.f11621x && i4 != AbstractC1251d.f11623z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            l(layerDrawable2.findDrawableByLayerId(R.id.background), W.a(context, AbstractC1248a.f11553l), C1639e.f13830b);
            l(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), W.b(context, AbstractC1248a.f11551j), C1639e.f13830b);
            l(layerDrawable2.findDrawableByLayerId(R.id.progress), W.b(context, AbstractC1248a.f11551j), C1639e.f13830b);
            return true;
        }

        public final boolean f(int[] iArr, int i4) {
            for (int i5 : iArr) {
                if (i5 == i4) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i4) {
            int iB = W.b(context, AbstractC1248a.f11552k);
            return new ColorStateList(new int[][]{W.f13777b, W.f13780e, W.f13778c, W.f13784i}, new int[]{W.a(context, AbstractC1248a.f11550i), AbstractC1962a.c(iB, i4), AbstractC1962a.c(iB, i4), i4});
        }

        public final ColorStateList i(Context context) {
            return h(context, W.b(context, AbstractC1248a.f11549h));
        }

        public final ColorStateList j(Context context) {
            return h(context, W.b(context, AbstractC1248a.f11550i));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListD = W.d(context, AbstractC1248a.f11554m);
            if (colorStateListD == null || !colorStateListD.isStateful()) {
                iArr[0] = W.f13777b;
                iArr2[0] = W.a(context, AbstractC1248a.f11554m);
                iArr[1] = W.f13781f;
                iArr2[1] = W.b(context, AbstractC1248a.f11551j);
                iArr[2] = W.f13784i;
                iArr2[2] = W.b(context, AbstractC1248a.f11554m);
            } else {
                int[] iArr3 = W.f13777b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
                iArr[1] = W.f13781f;
                iArr2[1] = W.b(context, AbstractC1248a.f11551j);
                iArr[2] = W.f13784i;
                iArr2[2] = colorStateListD.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final void l(Drawable drawable, int i4, PorterDuff.Mode mode) {
            if (G.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C1639e.f13830b;
            }
            drawable.setColorFilter(C1639e.d(i4, mode));
        }
    }

    public static synchronized C1639e b() {
        try {
            if (f13831c == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f13831c;
    }

    public static synchronized PorterDuffColorFilter d(int i4, PorterDuff.Mode mode) {
        return Q.k(i4, mode);
    }

    public static synchronized void f() {
        if (f13831c == null) {
            C1639e c1639e = new C1639e();
            f13831c = c1639e;
            c1639e.f13832a = Q.g();
            f13831c.f13832a.s(new a());
        }
    }

    public static void g(Drawable drawable, Y y4, int[] iArr) {
        Q.u(drawable, y4, iArr);
    }

    public synchronized Drawable c(Context context, int i4) {
        return this.f13832a.i(context, i4);
    }

    public synchronized ColorStateList e(Context context, int i4) {
        return this.f13832a.l(context, i4);
    }
}
