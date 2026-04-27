package F4;

import E4.d;
import E4.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import p.C2354o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends C2354o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f2327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f2328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f2329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Matrix f2330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f2333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f2334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f2339p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Uri f2340q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Uri f2341r;

    public interface a {
    }

    public b(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f2327d = new float[8];
        this.f2328e = new float[2];
        this.f2329f = new float[9];
        this.f2330g = new Matrix();
        this.f2335l = false;
        this.f2336m = false;
        this.f2337n = 0;
        f();
    }

    public float c(Matrix matrix) {
        return (float) (-(Math.atan2(e(matrix, 1), e(matrix, 0)) * 57.29577951308232d));
    }

    public float d(Matrix matrix) {
        return (float) Math.sqrt(Math.pow(e(matrix, 0), 2.0d) + Math.pow(e(matrix, 3), 2.0d));
    }

    public float e(Matrix matrix, int i7) {
        matrix.getValues(this.f2329f);
        return this.f2329f[i7];
    }

    public void f() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void g() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f2333j = e.b(rectF);
        this.f2334k = e.a(rectF);
        this.f2336m = true;
    }

    public float getCurrentAngle() {
        return c(this.f2330g);
    }

    public float getCurrentScale() {
        return d(this.f2330g);
    }

    public D4.b getExifInfo() {
        return null;
    }

    public String getImageInputPath() {
        return this.f2338o;
    }

    public Uri getImageInputUri() {
        return this.f2340q;
    }

    public String getImageOutputPath() {
        return this.f2339p;
    }

    public Uri getImageOutputUri() {
        return this.f2341r;
    }

    public int getMaxBitmapSize() {
        if (this.f2337n <= 0) {
            this.f2337n = E4.a.a(getContext());
        }
        return this.f2337n;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof d)) {
            return null;
        }
        return ((d) getDrawable()).a();
    }

    public void h(float f7, float f8, float f9) {
        if (f7 != 0.0f) {
            this.f2330g.postRotate(f7, f8, f9);
            setImageMatrix(this.f2330g);
        }
    }

    public void i(float f7, float f8, float f9) {
        if (f7 != 0.0f) {
            this.f2330g.postScale(f7, f7, f8, f9);
            setImageMatrix(this.f2330g);
        }
    }

    public void j(float f7, float f8) {
        if (f7 == 0.0f && f8 == 0.0f) {
            return;
        }
        this.f2330g.postTranslate(f7, f8);
        setImageMatrix(this.f2330g);
    }

    public final void k() {
        this.f2330g.mapPoints(this.f2327d, this.f2333j);
        this.f2330g.mapPoints(this.f2328e, this.f2334k);
    }

    @Override // android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7 || (this.f2335l && !this.f2336m)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f2331h = width - paddingLeft;
            this.f2332i = height - paddingTop;
            g();
        }
    }

    @Override // p.C2354o, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new d(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f2330g.set(matrix);
        k();
    }

    public void setMaxBitmapSize(int i7) {
        this.f2337n = i7;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(a aVar) {
    }
}
