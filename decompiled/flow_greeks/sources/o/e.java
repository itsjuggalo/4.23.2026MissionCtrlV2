package o;

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
import o.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f17237b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f17238c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f17239a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f17240a = {g.d.R, g.d.P, g.d.f9692a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f17241b = {g.d.f9706o, g.d.B, g.d.f9711t, g.d.f9707p, g.d.f9708q, g.d.f9710s, g.d.f9709r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f17242c = {g.d.O, g.d.Q, g.d.f9702k, g.d.K, g.d.L, g.d.M, g.d.N};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f17243d = {g.d.f9714w, g.d.f9700i, g.d.f9713v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f17244e = {g.d.J, g.d.S};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f17245f = {g.d.f9694c, g.d.f9698g, g.d.f9695d, g.d.f9699h};

        @Override // o.c0.c
        public Drawable a(c0 c0Var, Context context, int i10) {
            if (i10 == g.d.f9701j) {
                return new LayerDrawable(new Drawable[]{c0Var.i(context, g.d.f9700i), c0Var.i(context, g.d.f9702k)});
            }
            if (i10 == g.d.f9716y) {
                return l(c0Var, context, g.c.f9685c);
            }
            if (i10 == g.d.f9715x) {
                return l(c0Var, context, g.c.f9686d);
            }
            if (i10 == g.d.f9717z) {
                return l(c0Var, context, g.c.f9687e);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[RETURN] */
        @Override // o.c0.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = o.e.a()
                int[] r1 = r6.f17240a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = g.a.f9670l
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4e
            L15:
                int[] r1 = r6.f17242c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L20
                int r8 = g.a.f9668j
                goto L11
            L20:
                int[] r1 = r6.f17243d
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
                int r1 = g.d.f9712u
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
                int r1 = g.d.f9703l
                if (r8 != r1) goto L4a
                goto L2d
            L4a:
                r1 = r0
                r8 = r3
                r5 = r8
                goto L13
            L4e:
                if (r5 == 0) goto L65
                android.graphics.drawable.Drawable r9 = r9.mutate()
                int r7 = o.f0.c(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = o.e.d(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L64
                r9.setAlpha(r0)
            L64:
                return r2
            L65:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: o.e.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // o.c0.c
        public PorterDuff.Mode c(int i10) {
            if (i10 == g.d.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // o.c0.c
        public ColorStateList d(Context context, int i10) {
            if (i10 == g.d.f9704m) {
                return i.a.a(context, g.b.f9679c);
            }
            if (i10 == g.d.I) {
                return i.a.a(context, g.b.f9682f);
            }
            if (i10 == g.d.H) {
                return k(context);
            }
            if (i10 == g.d.f9697f) {
                return j(context);
            }
            if (i10 == g.d.f9693b) {
                return g(context);
            }
            if (i10 == g.d.f9696e) {
                return i(context);
            }
            if (i10 == g.d.D || i10 == g.d.E) {
                return i.a.a(context, g.b.f9681e);
            }
            if (f(this.f17241b, i10)) {
                return f0.e(context, g.a.f9670l);
            }
            if (f(this.f17244e, i10)) {
                return i.a.a(context, g.b.f9678b);
            }
            if (f(this.f17245f, i10)) {
                return i.a.a(context, g.b.f9677a);
            }
            if (i10 == g.d.A) {
                return i.a.a(context, g.b.f9680d);
            }
            return null;
        }

        @Override // o.c0.c
        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == g.d.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), f0.c(context, g.a.f9670l), e.f17237b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), f0.c(context, g.a.f9670l), e.f17237b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), f0.c(context, g.a.f9668j), e.f17237b);
                return true;
            }
            if (i10 != g.d.f9716y && i10 != g.d.f9715x && i10 != g.d.f9717z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), f0.b(context, g.a.f9670l), e.f17237b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), f0.c(context, g.a.f9668j), e.f17237b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), f0.c(context, g.a.f9668j), e.f17237b);
            return true;
        }

        public final boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i10) {
            int iC = f0.c(context, g.a.f9669k);
            return new ColorStateList(new int[][]{f0.f17257b, f0.f17260e, f0.f17258c, f0.f17264i}, new int[]{f0.b(context, g.a.f9667i), l0.a.c(iC, i10), l0.a.c(iC, i10), i10});
        }

        public final ColorStateList i(Context context) {
            return h(context, f0.c(context, g.a.f9666h));
        }

        public final ColorStateList j(Context context) {
            return h(context, f0.c(context, g.a.f9667i));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = f0.e(context, g.a.f9671m);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = f0.f17257b;
                iArr2[0] = f0.b(context, g.a.f9671m);
                iArr[1] = f0.f17261f;
                iArr2[1] = f0.c(context, g.a.f9668j);
                iArr[2] = f0.f17264i;
                iArr2[2] = f0.c(context, g.a.f9671m);
            } else {
                int[] iArr3 = f0.f17257b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = f0.f17261f;
                iArr2[1] = f0.c(context, g.a.f9668j);
                iArr[2] = f0.f17264i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(c0 c0Var, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawableI = c0Var.i(context, g.d.F);
            Drawable drawableI2 = c0Var.i(context, g.d.G);
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

        public final void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = e.f17237b;
            }
            drawableMutate.setColorFilter(e.d(i10, mode));
        }
    }

    public static synchronized e b() {
        try {
            if (f17238c == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17238c;
    }

    public static synchronized PorterDuffColorFilter d(int i10, PorterDuff.Mode mode) {
        return c0.k(i10, mode);
    }

    public static synchronized void f() {
        if (f17238c == null) {
            e eVar = new e();
            f17238c = eVar;
            eVar.f17239a = c0.g();
            f17238c.f17239a.s(new a());
        }
    }

    public static void g(Drawable drawable, h0 h0Var, int[] iArr) {
        c0.u(drawable, h0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f17239a.i(context, i10);
    }

    public synchronized ColorStateList e(Context context, int i10) {
        return this.f17239a.l(context, i10);
    }
}
