package F4;

import B4.f;
import E4.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends F4.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f2298A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f2299B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f2300C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public long f2301D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f2302s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Matrix f2303t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f2304u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2305v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public C4.a f2306w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f2307x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Runnable f2308y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2309z;

    /* JADX INFO: renamed from: F4.a$a, reason: collision with other inner class name */
    public static class RunnableC0016a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f2310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2312c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f2313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f2314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f2315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f2316g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f2317h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f2318i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f2319j;

        public RunnableC0016a(a aVar, long j7, float f7, float f8, float f9, float f10, float f11, float f12, boolean z7) {
            this.f2310a = new WeakReference(aVar);
            this.f2311b = j7;
            this.f2313d = f7;
            this.f2314e = f8;
            this.f2315f = f9;
            this.f2316g = f10;
            this.f2317h = f11;
            this.f2318i = f12;
            this.f2319j = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = (a) this.f2310a.get();
            if (aVar == null) {
                return;
            }
            float fMin = Math.min(this.f2311b, System.currentTimeMillis() - this.f2312c);
            float fB = E4.b.b(fMin, 0.0f, this.f2315f, this.f2311b);
            float fB2 = E4.b.b(fMin, 0.0f, this.f2316g, this.f2311b);
            float fA = E4.b.a(fMin, 0.0f, this.f2318i, this.f2311b);
            if (fMin < this.f2311b) {
                float[] fArr = aVar.f2328e;
                aVar.j(fB - (fArr[0] - this.f2313d), fB2 - (fArr[1] - this.f2314e));
                if (!this.f2319j) {
                    aVar.w(this.f2317h + fA, aVar.f2302s.centerX(), aVar.f2302s.centerY());
                }
                if (aVar.q()) {
                    return;
                }
                aVar.post(this);
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f2320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2322c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f2323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f2324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f2325f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f2326g;

        public b(a aVar, long j7, float f7, float f8, float f9, float f10) {
            this.f2320a = new WeakReference(aVar);
            this.f2321b = j7;
            this.f2323d = f7;
            this.f2324e = f8;
            this.f2325f = f9;
            this.f2326g = f10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = (a) this.f2320a.get();
            if (aVar == null) {
                return;
            }
            float fMin = Math.min(this.f2321b, System.currentTimeMillis() - this.f2322c);
            float fA = E4.b.a(fMin, 0.0f, this.f2324e, this.f2321b);
            if (fMin >= this.f2321b) {
                aVar.t();
            } else {
                aVar.w(this.f2323d + fA, this.f2325f, this.f2326g);
                aVar.post(this);
            }
        }
    }

    public a(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f2302s = new RectF();
        this.f2303t = new Matrix();
        this.f2305v = 10.0f;
        this.f2308y = null;
        this.f2299B = 0;
        this.f2300C = 0;
        this.f2301D = 500L;
    }

    @Override // F4.b
    public void g() {
        super.g();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f2304u == 0.0f) {
            this.f2304u = intrinsicWidth / intrinsicHeight;
        }
        int i7 = this.f2331h;
        float f7 = this.f2304u;
        int i8 = (int) (i7 / f7);
        int i9 = this.f2332i;
        if (i8 > i9) {
            this.f2302s.set((i7 - ((int) (i9 * f7))) / 2, 0.0f, r4 + r2, i9);
        } else {
            this.f2302s.set(0.0f, (i9 - i8) / 2, i7, i8 + r6);
        }
        o(intrinsicWidth, intrinsicHeight);
        u(intrinsicWidth, intrinsicHeight);
        C4.a aVar = this.f2306w;
        if (aVar != null) {
            aVar.a(this.f2304u);
        }
    }

    public C4.a getCropBoundsChangeListener() {
        return this.f2306w;
    }

    public float getMaxScale() {
        return this.f2309z;
    }

    public float getMinScale() {
        return this.f2298A;
    }

    public float getTargetAspectRatio() {
        return this.f2304u;
    }

    @Override // F4.b
    public void i(float f7, float f8, float f9) {
        if (f7 > 1.0f && getCurrentScale() * f7 <= getMaxScale()) {
            super.i(f7, f8, f9);
        } else {
            if (f7 >= 1.0f || getCurrentScale() * f7 < getMinScale()) {
                return;
            }
            super.i(f7, f8, f9);
        }
    }

    public final float[] m() {
        this.f2303t.reset();
        this.f2303t.setRotate(-getCurrentAngle());
        float[] fArr = this.f2327d;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        float[] fArrB = e.b(this.f2302s);
        this.f2303t.mapPoints(fArrCopyOf);
        this.f2303t.mapPoints(fArrB);
        RectF rectFD = e.d(fArrCopyOf);
        RectF rectFD2 = e.d(fArrB);
        float f7 = rectFD.left - rectFD2.left;
        float f8 = rectFD.top - rectFD2.top;
        float f9 = rectFD.right - rectFD2.right;
        float f10 = rectFD.bottom - rectFD2.bottom;
        if (f7 <= 0.0f) {
            f7 = 0.0f;
        }
        if (f8 <= 0.0f) {
            f8 = 0.0f;
        }
        if (f9 >= 0.0f) {
            f9 = 0.0f;
        }
        if (f10 >= 0.0f) {
            f10 = 0.0f;
        }
        float[] fArr2 = {f7, f8, f9, f10};
        this.f2303t.reset();
        this.f2303t.setRotate(getCurrentAngle());
        this.f2303t.mapPoints(fArr2);
        return fArr2;
    }

    public final void n() {
        if (getDrawable() == null) {
            return;
        }
        o(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    public final void o(float f7, float f8) {
        float fMin = Math.min(Math.min(this.f2302s.width() / f7, this.f2302s.width() / f8), Math.min(this.f2302s.height() / f8, this.f2302s.height() / f7));
        this.f2298A = fMin;
        this.f2309z = fMin * this.f2305v;
    }

    public void p() {
        removeCallbacks(this.f2307x);
        removeCallbacks(this.f2308y);
    }

    public boolean q() {
        return r(this.f2327d);
    }

    public boolean r(float[] fArr) {
        this.f2303t.reset();
        this.f2303t.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.f2303t.mapPoints(fArrCopyOf);
        float[] fArrB = e.b(this.f2302s);
        this.f2303t.mapPoints(fArrB);
        return e.d(fArrCopyOf).contains(e.d(fArrB));
    }

    public void s(TypedArray typedArray) {
        float fAbs = Math.abs(typedArray.getFloat(f.f799c0, 0.0f));
        float fAbs2 = Math.abs(typedArray.getFloat(f.f801d0, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            this.f2304u = 0.0f;
        } else {
            this.f2304u = fAbs / fAbs2;
        }
    }

    public void setCropBoundsChangeListener(C4.a aVar) {
        this.f2306w = aVar;
    }

    public void setCropRect(RectF rectF) {
        this.f2304u = rectF.width() / rectF.height();
        this.f2302s.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        n();
        t();
    }

    public void setImageToWrapCropBounds(boolean z7) {
        float f7;
        float fMax;
        float f8;
        if (!this.f2336m || q()) {
            return;
        }
        float[] fArr = this.f2328e;
        float f9 = fArr[0];
        float f10 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.f2302s.centerX() - f9;
        float fCenterY = this.f2302s.centerY() - f10;
        this.f2303t.reset();
        this.f2303t.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.f2327d;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f2303t.mapPoints(fArrCopyOf);
        boolean zR = r(fArrCopyOf);
        if (zR) {
            float[] fArrM = m();
            float f11 = -(fArrM[0] + fArrM[2]);
            f8 = -(fArrM[1] + fArrM[3]);
            f7 = f11;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.f2302s);
            this.f2303t.reset();
            this.f2303t.setRotate(getCurrentAngle());
            this.f2303t.mapRect(rectF);
            float[] fArrC = e.c(this.f2327d);
            f7 = fCenterX;
            fMax = (Math.max(rectF.width() / fArrC[0], rectF.height() / fArrC[1]) * currentScale) - currentScale;
            f8 = fCenterY;
        }
        if (z7) {
            RunnableC0016a runnableC0016a = new RunnableC0016a(this, this.f2301D, f9, f10, f7, f8, currentScale, fMax, zR);
            this.f2307x = runnableC0016a;
            post(runnableC0016a);
        } else {
            j(f7, f8);
            if (zR) {
                return;
            }
            w(currentScale + fMax, this.f2302s.centerX(), this.f2302s.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j7) {
        if (j7 <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.f2301D = j7;
    }

    public void setMaxResultImageSizeX(int i7) {
        this.f2299B = i7;
    }

    public void setMaxResultImageSizeY(int i7) {
        this.f2300C = i7;
    }

    public void setMaxScaleMultiplier(float f7) {
        this.f2305v = f7;
    }

    public void setTargetAspectRatio(float f7) {
        if (getDrawable() == null) {
            this.f2304u = f7;
            return;
        }
        if (f7 == 0.0f) {
            this.f2304u = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.f2304u = f7;
        }
        C4.a aVar = this.f2306w;
        if (aVar != null) {
            aVar.a(this.f2304u);
        }
    }

    public void t() {
        setImageToWrapCropBounds(true);
    }

    public final void u(float f7, float f8) {
        float fWidth = this.f2302s.width();
        float fHeight = this.f2302s.height();
        float fMax = Math.max(this.f2302s.width() / f7, this.f2302s.height() / f8);
        RectF rectF = this.f2302s;
        float f9 = ((fWidth - (f7 * fMax)) / 2.0f) + rectF.left;
        float f10 = ((fHeight - (f8 * fMax)) / 2.0f) + rectF.top;
        this.f2330g.reset();
        this.f2330g.postScale(fMax, fMax);
        this.f2330g.postTranslate(f9, f10);
        setImageMatrix(this.f2330g);
    }

    public void v(float f7, float f8, float f9, long j7) {
        if (f7 > getMaxScale()) {
            f7 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j7, currentScale, f7 - currentScale, f8, f9);
        this.f2308y = bVar;
        post(bVar);
    }

    public void w(float f7, float f8, float f9) {
        if (f7 <= getMaxScale()) {
            i(f7 / getCurrentScale(), f8, f9);
        }
    }
}
