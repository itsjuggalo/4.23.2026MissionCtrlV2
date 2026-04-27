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
import g.AbstractC1764a;
import g.AbstractC1765b;
import g.AbstractC1766c;
import g.AbstractC1767d;
import i.AbstractC1906a;
import o.E;

/* JADX INFO: renamed from: o.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2436e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f21824b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C2436e f21825c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f21826a;

    /* JADX INFO: renamed from: o.e$a */
    public class a implements E.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f21827a = {AbstractC1767d.f17700R, AbstractC1767d.f17698P, AbstractC1767d.f17702a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f21828b = {AbstractC1767d.f17716o, AbstractC1767d.f17684B, AbstractC1767d.f17721t, AbstractC1767d.f17717p, AbstractC1767d.f17718q, AbstractC1767d.f17720s, AbstractC1767d.f17719r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f21829c = {AbstractC1767d.f17697O, AbstractC1767d.f17699Q, AbstractC1767d.f17712k, AbstractC1767d.f17693K, AbstractC1767d.f17694L, AbstractC1767d.f17695M, AbstractC1767d.f17696N};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f21830d = {AbstractC1767d.f17724w, AbstractC1767d.f17710i, AbstractC1767d.f17723v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f21831e = {AbstractC1767d.f17692J, AbstractC1767d.f17701S};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f21832f = {AbstractC1767d.f17704c, AbstractC1767d.f17708g, AbstractC1767d.f17705d, AbstractC1767d.f17709h};

        @Override // o.E.c
        public Drawable a(E e8, Context context, int i8) {
            int i9;
            if (i8 == AbstractC1767d.f17711j) {
                return new LayerDrawable(new Drawable[]{e8.i(context, AbstractC1767d.f17710i), e8.i(context, AbstractC1767d.f17712k)});
            }
            if (i8 == AbstractC1767d.f17726y) {
                i9 = AbstractC1766c.f17676c;
            } else if (i8 == AbstractC1767d.f17725x) {
                i9 = AbstractC1766c.f17677d;
            } else {
                if (i8 != AbstractC1767d.f17727z) {
                    return null;
                }
                i9 = AbstractC1766c.f17678e;
            }
            return l(e8, context, i9);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[RETURN] */
        @Override // o.E.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
            /*
                r7 = this;
                android.graphics.PorterDuff$Mode r0 = o.C2436e.a()
                int[] r1 = r7.f21827a
                boolean r1 = r7.f(r1, r9)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r9 = g.AbstractC1764a.f17661l
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4f
            L15:
                int[] r1 = r7.f21829c
                boolean r1 = r7.f(r1, r9)
                if (r1 == 0) goto L20
                int r9 = g.AbstractC1764a.f17659j
                goto L11
            L20:
                int[] r1 = r7.f21830d
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
                int r1 = g.AbstractC1767d.f17722u
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
                int r1 = g.AbstractC1767d.f17713l
                if (r9 != r1) goto L4b
                goto L2d
            L4b:
                r1 = r0
                r9 = r3
                r5 = r9
                goto L13
            L4f:
                if (r5 == 0) goto L66
                android.graphics.drawable.Drawable r10 = r10.mutate()
                int r8 = o.H.c(r8, r9)
                android.graphics.PorterDuffColorFilter r8 = o.C2436e.d(r8, r1)
                r10.setColorFilter(r8)
                if (r0 == r4) goto L65
                r10.setAlpha(r0)
            L65:
                return r2
            L66:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: o.C2436e.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // o.E.c
        public PorterDuff.Mode c(int i8) {
            if (i8 == AbstractC1767d.f17690H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // o.E.c
        public ColorStateList d(Context context, int i8) {
            if (i8 == AbstractC1767d.f17714m) {
                return AbstractC1906a.a(context, AbstractC1765b.f17670c);
            }
            if (i8 == AbstractC1767d.f17691I) {
                return AbstractC1906a.a(context, AbstractC1765b.f17673f);
            }
            if (i8 == AbstractC1767d.f17690H) {
                return k(context);
            }
            if (i8 == AbstractC1767d.f17707f) {
                return j(context);
            }
            if (i8 == AbstractC1767d.f17703b) {
                return g(context);
            }
            if (i8 == AbstractC1767d.f17706e) {
                return i(context);
            }
            if (i8 == AbstractC1767d.f17686D || i8 == AbstractC1767d.f17687E) {
                return AbstractC1906a.a(context, AbstractC1765b.f17672e);
            }
            if (f(this.f21828b, i8)) {
                return H.e(context, AbstractC1764a.f17661l);
            }
            if (f(this.f21831e, i8)) {
                return AbstractC1906a.a(context, AbstractC1765b.f17669b);
            }
            if (f(this.f21832f, i8)) {
                return AbstractC1906a.a(context, AbstractC1765b.f17668a);
            }
            if (i8 == AbstractC1767d.f17683A) {
                return AbstractC1906a.a(context, AbstractC1765b.f17671d);
            }
            return null;
        }

        @Override // o.E.c
        public boolean e(Context context, int i8, Drawable drawable) {
            LayerDrawable layerDrawable;
            Drawable drawableFindDrawableByLayerId;
            int i9;
            if (i8 == AbstractC1767d.f17685C) {
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), H.c(context, AbstractC1764a.f17661l), C2436e.f21824b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i9 = AbstractC1764a.f17661l;
            } else {
                if (i8 != AbstractC1767d.f17726y && i8 != AbstractC1767d.f17725x && i8 != AbstractC1767d.f17727z) {
                    return false;
                }
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), H.b(context, AbstractC1764a.f17661l), C2436e.f21824b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i9 = AbstractC1764a.f17659j;
            }
            m(drawableFindDrawableByLayerId, H.c(context, i9), C2436e.f21824b);
            m(layerDrawable.findDrawableByLayerId(R.id.progress), H.c(context, AbstractC1764a.f17659j), C2436e.f21824b);
            return true;
        }

        public final boolean f(int[] iArr, int i8) {
            for (int i9 : iArr) {
                if (i9 == i8) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i8) {
            int iC = H.c(context, AbstractC1764a.f17660k);
            return new ColorStateList(new int[][]{H.f21756b, H.f21759e, H.f21757c, H.f21763i}, new int[]{H.b(context, AbstractC1764a.f17658i), L.a.c(iC, i8), L.a.c(iC, i8), i8});
        }

        public final ColorStateList i(Context context) {
            return h(context, H.c(context, AbstractC1764a.f17657h));
        }

        public final ColorStateList j(Context context) {
            return h(context, H.c(context, AbstractC1764a.f17658i));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = H.e(context, AbstractC1764a.f17662m);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = H.f21756b;
                iArr2[0] = H.b(context, AbstractC1764a.f17662m);
                iArr[1] = H.f21760f;
                iArr2[1] = H.c(context, AbstractC1764a.f17659j);
                iArr[2] = H.f21763i;
                iArr2[2] = H.c(context, AbstractC1764a.f17662m);
            } else {
                int[] iArr3 = H.f21756b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = H.f21760f;
                iArr2[1] = H.c(context, AbstractC1764a.f17659j);
                iArr[2] = H.f21763i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(E e8, Context context, int i8) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i8);
            Drawable drawableI = e8.i(context, AbstractC1767d.f17688F);
            Drawable drawableI2 = e8.i(context, AbstractC1767d.f17689G);
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

        public final void m(Drawable drawable, int i8, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C2436e.f21824b;
            }
            drawableMutate.setColorFilter(C2436e.d(i8, mode));
        }
    }

    public static synchronized C2436e b() {
        try {
            if (f21825c == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f21825c;
    }

    public static synchronized PorterDuffColorFilter d(int i8, PorterDuff.Mode mode) {
        return E.k(i8, mode);
    }

    public static synchronized void f() {
        if (f21825c == null) {
            C2436e c2436e = new C2436e();
            f21825c = c2436e;
            c2436e.f21826a = E.g();
            f21825c.f21826a.s(new a());
        }
    }

    public static void g(Drawable drawable, J j8, int[] iArr) {
        E.u(drawable, j8, iArr);
    }

    public synchronized Drawable c(Context context, int i8) {
        return this.f21826a.i(context, i8);
    }

    public synchronized ColorStateList e(Context context, int i8) {
        return this.f21826a.l(context, i8);
    }
}
