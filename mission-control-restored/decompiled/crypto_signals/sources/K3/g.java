package K3;

import E.l;
import Q3.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.WindowManager;
import android.widget.ImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.UCropView;
import m.C0837q;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends C0837q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f1002d;
    public final float[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f1003f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f1004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f1007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float[] f1008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1010q;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1002d = new float[8];
        this.e = new float[2];
        this.f1003f = new float[9];
        this.f1004k = new Matrix();
        this.f1009p = false;
        this.f1010q = 0;
        GestureCropImageView gestureCropImageView = (GestureCropImageView) this;
        gestureCropImageView.setScaleType(ImageView.ScaleType.MATRIX);
        gestureCropImageView.f5829D = new GestureDetector(gestureCropImageView.getContext(), new d(gestureCropImageView), null, true);
        gestureCropImageView.f5827B = new ScaleGestureDetector(gestureCropImageView.getContext(), new e(gestureCropImageView));
        l lVar = new l(gestureCropImageView, 4);
        J3.b bVar = new J3.b();
        bVar.i = lVar;
        bVar.e = -1;
        bVar.f788f = -1;
        gestureCropImageView.f5828C = bVar;
    }

    public final void b(float f6, float f7) {
        if (f6 == 0.0f && f7 == 0.0f) {
            return;
        }
        Matrix matrix = this.f1004k;
        matrix.postTranslate(f6, f7);
        setImageMatrix(matrix);
    }

    public float getCurrentAngle() {
        Matrix matrix = this.f1004k;
        float[] fArr = this.f1003f;
        matrix.getValues(fArr);
        double d4 = fArr[1];
        matrix.getValues(fArr);
        return (float) (-(Math.atan2(d4, fArr[0]) * 57.29577951308232d));
    }

    public float getCurrentScale() {
        Matrix matrix = this.f1004k;
        float[] fArr = this.f1003f;
        matrix.getValues(fArr);
        double dPow = Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(Math.pow(fArr[3], 2.0d) + dPow);
    }

    public I3.b getExifInfo() {
        return null;
    }

    public String getImageInputPath() {
        return null;
    }

    public Uri getImageInputUri() {
        return null;
    }

    public String getImageOutputPath() {
        return null;
    }

    public Uri getImageOutputUri() {
        return null;
    }

    public int getMaxBitmapSize() {
        int iW;
        if (this.f1010q <= 0) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            Point point = new Point();
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int i = point.x;
            int iSqrt = (int) Math.sqrt(Math.pow(point.y, 2.0d) + Math.pow(i, 2.0d));
            Canvas canvas = new Canvas();
            int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
            if (iMin > 0) {
                iSqrt = Math.min(iSqrt, iMin);
            }
            try {
                iW = y5.a.w();
            } catch (Exception e) {
                Log.d("EglUtils", "getMaxTextureSize: ", e);
                iW = 0;
            }
            if (iW > 0) {
                iSqrt = Math.min(iSqrt, iW);
            }
            Log.d("BitmapLoadUtils", "maxBitmapSize: " + iSqrt);
            this.f1010q = iSqrt;
        }
        return this.f1010q;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof J3.a)) {
            return null;
        }
        return ((J3.a) getDrawable()).f781b;
    }

    @Override // android.view.View
    public final void onLayout(boolean z6, int i, int i6, int i7, int i8) {
        super.onLayout(z6, i, i6, i7, i8);
        if (z6) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f1005l = width - paddingLeft;
            this.f1006m = height - paddingTop;
            c cVar = (c) this;
            Drawable drawable = cVar.getDrawable();
            if (drawable != null) {
                float intrinsicWidth = drawable.getIntrinsicWidth();
                float intrinsicHeight = drawable.getIntrinsicHeight();
                Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                float f6 = rectF.left;
                float f7 = rectF.top;
                float f8 = rectF.right;
                float f9 = rectF.bottom;
                cVar.f1007n = new float[]{f6, f7, f8, f7, f8, f9, f6, f9};
                cVar.f1008o = new float[]{rectF.centerX(), rectF.centerY()};
                cVar.f1009p = true;
            }
            Drawable drawable2 = cVar.getDrawable();
            if (drawable2 == null) {
                return;
            }
            float intrinsicWidth2 = drawable2.getIntrinsicWidth();
            float intrinsicHeight2 = drawable2.getIntrinsicHeight();
            if (cVar.f994t == 0.0f) {
                cVar.f994t = intrinsicWidth2 / intrinsicHeight2;
            }
            int i9 = cVar.f1005l;
            float f10 = i9;
            float f11 = cVar.f994t;
            int i10 = (int) (f10 / f11);
            int i11 = cVar.f1006m;
            RectF rectF2 = cVar.f992r;
            if (i10 > i11) {
                float f12 = i11;
                rectF2.set((i9 - ((int) (f11 * f12))) / 2, 0.0f, r3 + r0, f12);
            } else {
                rectF2.set(0.0f, (i11 - i10) / 2, f10, i10 + r5);
            }
            cVar.d(intrinsicWidth2, intrinsicHeight2);
            float fWidth = rectF2.width();
            float fHeight = rectF2.height();
            float fMax = Math.max(rectF2.width() / intrinsicWidth2, rectF2.height() / intrinsicHeight2);
            float f13 = ((fWidth - (intrinsicWidth2 * fMax)) / 2.0f) + rectF2.left;
            float f14 = ((fHeight - (intrinsicHeight2 * fMax)) / 2.0f) + rectF2.top;
            Matrix matrix = cVar.f1004k;
            matrix.reset();
            matrix.postScale(fMax, fMax);
            matrix.postTranslate(f13, f14);
            cVar.setImageMatrix(matrix);
            H3.a aVar = cVar.f996v;
            if (aVar != null) {
                ((UCropView) ((h) aVar).f2742b).f5862b.setTargetAspectRatio(cVar.f994t);
            }
        }
    }

    @Override // m.C0837q, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new J3.a(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        Matrix matrix2 = this.f1004k;
        matrix2.set(matrix);
        matrix2.mapPoints(this.f1002d, this.f1007n);
        matrix2.mapPoints(this.e, this.f1008o);
    }

    public void setMaxBitmapSize(int i) {
        this.f1010q = i;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(f fVar) {
    }
}
