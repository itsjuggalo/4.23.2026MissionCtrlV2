package p;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import h.AbstractC1656a;
import h.AbstractC1657b;
import h.AbstractC1658c;
import h.AbstractC1659d;
import j.AbstractC2040a;
import p.J;

/* JADX INFO: renamed from: p.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2347h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f21366b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C2347h f21367c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f21368a;

    /* JADX INFO: renamed from: p.h$a */
    public class a implements J.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f21369a = {AbstractC1659d.f14391R, AbstractC1659d.f14389P, AbstractC1659d.f14393a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f21370b = {AbstractC1659d.f14407o, AbstractC1659d.f14375B, AbstractC1659d.f14412t, AbstractC1659d.f14408p, AbstractC1659d.f14409q, AbstractC1659d.f14411s, AbstractC1659d.f14410r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f21371c = {AbstractC1659d.f14388O, AbstractC1659d.f14390Q, AbstractC1659d.f14403k, AbstractC1659d.f14384K, AbstractC1659d.f14385L, AbstractC1659d.f14386M, AbstractC1659d.f14387N};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f21372d = {AbstractC1659d.f14415w, AbstractC1659d.f14401i, AbstractC1659d.f14414v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f21373e = {AbstractC1659d.f14383J, AbstractC1659d.f14392S};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f21374f = {AbstractC1659d.f14395c, AbstractC1659d.f14399g, AbstractC1659d.f14396d, AbstractC1659d.f14400h};

        @Override // p.J.c
        public Drawable a(J j7, Context context, int i7) {
            if (i7 == AbstractC1659d.f14402j) {
                return new LayerDrawable(new Drawable[]{j7.i(context, AbstractC1659d.f14401i), j7.i(context, AbstractC1659d.f14403k)});
            }
            if (i7 == AbstractC1659d.f14417y) {
                return l(j7, context, AbstractC1658c.f14367g);
            }
            if (i7 == AbstractC1659d.f14416x) {
                return l(j7, context, AbstractC1658c.f14368h);
            }
            if (i7 == AbstractC1659d.f14418z) {
                return l(j7, context, AbstractC1658c.f14369i);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[RETURN] */
        @Override // p.J.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
            /*
                r7 = this;
                android.graphics.PorterDuff$Mode r0 = p.C2347h.a()
                int[] r1 = r7.f21369a
                boolean r1 = r7.f(r1, r9)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r9 = h.AbstractC1656a.f14345l
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4f
            L15:
                int[] r1 = r7.f21371c
                boolean r1 = r7.f(r1, r9)
                if (r1 == 0) goto L20
                int r9 = h.AbstractC1656a.f14343j
                goto L11
            L20:
                int[] r1 = r7.f21372d
                boolean r1 = r7.f(r1, r9)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r0 = r4
                r9 = r5
                r5 = r2
                goto L4f
            L32:
                int r1 = h.AbstractC1659d.f14413u
                if (r9 != r1) goto L46
                r9 = 1109603123(0x42233333, float:40.8)
                int r9 = java.lang.Math.round(r9)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r5 = r2
                r6 = r0
                r0 = r9
                r9 = r1
                r1 = r6
                goto L4f
            L46:
                int r1 = h.AbstractC1659d.f14404l
                if (r9 != r1) goto L4b
                goto L2d
            L4b:
                r1 = r0
                r9 = r3
                r5 = r9
                goto L13
            L4f:
                if (r5 == 0) goto L6c
                boolean r3 = p.AbstractC2334C.a(r10)
                if (r3 == 0) goto L5b
                android.graphics.drawable.Drawable r10 = r10.mutate()
            L5b:
                int r8 = p.N.c(r8, r9)
                android.graphics.PorterDuffColorFilter r8 = p.C2347h.d(r8, r1)
                r10.setColorFilter(r8)
                if (r0 == r4) goto L6b
                r10.setAlpha(r0)
            L6b:
                return r2
            L6c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p.C2347h.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // p.J.c
        public PorterDuff.Mode c(int i7) {
            if (i7 == AbstractC1659d.f14381H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // p.J.c
        public ColorStateList d(Context context, int i7) {
            if (i7 == AbstractC1659d.f14405m) {
                return AbstractC2040a.a(context, AbstractC1657b.f14357c);
            }
            if (i7 == AbstractC1659d.f14382I) {
                return AbstractC2040a.a(context, AbstractC1657b.f14360f);
            }
            if (i7 == AbstractC1659d.f14381H) {
                return k(context);
            }
            if (i7 == AbstractC1659d.f14398f) {
                return j(context);
            }
            if (i7 == AbstractC1659d.f14394b) {
                return g(context);
            }
            if (i7 == AbstractC1659d.f14397e) {
                return i(context);
            }
            if (i7 == AbstractC1659d.f14377D || i7 == AbstractC1659d.f14378E) {
                return AbstractC2040a.a(context, AbstractC1657b.f14359e);
            }
            if (f(this.f21370b, i7)) {
                return N.e(context, AbstractC1656a.f14345l);
            }
            if (f(this.f21373e, i7)) {
                return AbstractC2040a.a(context, AbstractC1657b.f14356b);
            }
            if (f(this.f21374f, i7)) {
                return AbstractC2040a.a(context, AbstractC1657b.f14355a);
            }
            if (i7 == AbstractC1659d.f14374A) {
                return AbstractC2040a.a(context, AbstractC1657b.f14358d);
            }
            return null;
        }

        @Override // p.J.c
        public boolean e(Context context, int i7, Drawable drawable) {
            if (i7 == AbstractC1659d.f14376C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), N.c(context, AbstractC1656a.f14345l), C2347h.f21366b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), N.c(context, AbstractC1656a.f14345l), C2347h.f21366b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), N.c(context, AbstractC1656a.f14343j), C2347h.f21366b);
                return true;
            }
            if (i7 != AbstractC1659d.f14417y && i7 != AbstractC1659d.f14416x && i7 != AbstractC1659d.f14418z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), N.b(context, AbstractC1656a.f14345l), C2347h.f21366b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), N.c(context, AbstractC1656a.f14343j), C2347h.f21366b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), N.c(context, AbstractC1656a.f14343j), C2347h.f21366b);
            return true;
        }

        public final boolean f(int[] iArr, int i7) {
            for (int i8 : iArr) {
                if (i8 == i7) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i7) {
            int iC = N.c(context, AbstractC1656a.f14344k);
            return new ColorStateList(new int[][]{N.f21284b, N.f21287e, N.f21285c, N.f21291i}, new int[]{N.b(context, AbstractC1656a.f14342i), I.a.f(iC, i7), I.a.f(iC, i7), i7});
        }

        public final ColorStateList i(Context context) {
            return h(context, N.c(context, AbstractC1656a.f14341h));
        }

        public final ColorStateList j(Context context) {
            return h(context, N.c(context, AbstractC1656a.f14342i));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = N.e(context, AbstractC1656a.f14346m);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = N.f21284b;
                iArr2[0] = N.b(context, AbstractC1656a.f14346m);
                iArr[1] = N.f21288f;
                iArr2[1] = N.c(context, AbstractC1656a.f14343j);
                iArr[2] = N.f21291i;
                iArr2[2] = N.c(context, AbstractC1656a.f14346m);
            } else {
                int[] iArr3 = N.f21284b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = N.f21288f;
                iArr2[1] = N.c(context, AbstractC1656a.f14343j);
                iArr[2] = N.f21291i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(J j7, Context context, int i7) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i7);
            Drawable drawableI = j7.i(context, AbstractC1659d.f14379F);
            Drawable drawableI2 = j7.i(context, AbstractC1659d.f14380G);
            if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableI;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableI2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i7, PorterDuff.Mode mode) {
            if (AbstractC2334C.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C2347h.f21366b;
            }
            drawable.setColorFilter(C2347h.d(i7, mode));
        }
    }

    public static synchronized C2347h b() {
        try {
            if (f21367c == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f21367c;
    }

    public static synchronized PorterDuffColorFilter d(int i7, PorterDuff.Mode mode) {
        return J.k(i7, mode);
    }

    public static synchronized void f() {
        if (f21367c == null) {
            C2347h c2347h = new C2347h();
            f21367c = c2347h;
            c2347h.f21368a = J.g();
            f21367c.f21368a.s(new a());
        }
    }

    public static void g(Drawable drawable, P p7, int[] iArr) {
        J.u(drawable, p7, iArr);
    }

    public synchronized Drawable c(Context context, int i7) {
        return this.f21368a.i(context, i7);
    }

    public synchronized ColorStateList e(Context context, int i7) {
        return this.f21368a.l(context, i7);
    }
}
