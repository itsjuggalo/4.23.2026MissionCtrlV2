package K3;

import Q3.h;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.UCropView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends g {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public long f991A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Matrix f993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public H3.a f996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f998x;
    public float y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f999z;

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f992r = new RectF();
        this.f993s = new Matrix();
        this.f995u = 10.0f;
        this.f998x = null;
        this.f991A = 500L;
    }

    public final void d(float f6, float f7) {
        RectF rectF = this.f992r;
        float fMin = Math.min(Math.min(rectF.width() / f6, rectF.width() / f7), Math.min(rectF.height() / f7, rectF.height() / f6));
        this.f999z = fMin;
        this.y = fMin * this.f995u;
    }

    public final boolean e(float[] fArr) {
        Matrix matrix = this.f993s;
        matrix.reset();
        matrix.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        matrix.mapPoints(fArrCopyOf);
        RectF rectF = this.f992r;
        float f6 = rectF.left;
        float f7 = rectF.top;
        float f8 = rectF.right;
        float f9 = rectF.bottom;
        float[] fArr2 = {f6, f7, f8, f7, f8, f9, f6, f9};
        matrix.mapPoints(fArr2);
        return D1.b.J(fArrCopyOf).contains(D1.b.J(fArr2));
    }

    public final void f(float f6, float f7, float f8) {
        if (f6 > 1.0f && getCurrentScale() * f6 <= getMaxScale()) {
            if (f6 != 0.0f) {
                Matrix matrix = this.f1004k;
                matrix.postScale(f6, f6, f7, f8);
                setImageMatrix(matrix);
                return;
            }
            return;
        }
        if (f6 >= 1.0f || getCurrentScale() * f6 < getMinScale() || f6 == 0.0f) {
            return;
        }
        Matrix matrix2 = this.f1004k;
        matrix2.postScale(f6, f6, f7, f8);
        setImageMatrix(matrix2);
    }

    public final void g(float f6, float f7, float f8) {
        if (f6 <= getMaxScale()) {
            f(f6 / getCurrentScale(), f7, f8);
        }
    }

    public H3.a getCropBoundsChangeListener() {
        return this.f996v;
    }

    public float getMaxScale() {
        return this.y;
    }

    public float getMinScale() {
        return this.f999z;
    }

    public float getTargetAspectRatio() {
        return this.f994t;
    }

    public void setCropBoundsChangeListener(H3.a aVar) {
        this.f996v = aVar;
    }

    public void setCropRect(RectF rectF) {
        this.f994t = rectF.width() / rectF.height();
        this.f992r.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        if (getDrawable() != null) {
            d(r6.getIntrinsicWidth(), r6.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z6) {
        float f6;
        float fMax;
        if (this.f1009p) {
            float[] fArr = this.f1002d;
            if (e(fArr)) {
                return;
            }
            float[] fArr2 = this.e;
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            float currentScale = getCurrentScale();
            RectF rectF = this.f992r;
            float fCenterX = rectF.centerX() - f7;
            float fCenterY = rectF.centerY() - f8;
            Matrix matrix = this.f993s;
            matrix.reset();
            matrix.setTranslate(fCenterX, fCenterY);
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            matrix.mapPoints(fArrCopyOf);
            boolean zE = e(fArrCopyOf);
            if (zE) {
                matrix.reset();
                matrix.setRotate(-getCurrentAngle());
                float[] fArrCopyOf2 = Arrays.copyOf(fArr, fArr.length);
                float f9 = rectF.left;
                float f10 = rectF.top;
                float f11 = rectF.right;
                float f12 = rectF.bottom;
                float[] fArr3 = {f9, f10, f11, f10, f11, f12, f9, f12};
                matrix.mapPoints(fArrCopyOf2);
                matrix.mapPoints(fArr3);
                RectF rectFJ = D1.b.J(fArrCopyOf2);
                RectF rectFJ2 = D1.b.J(fArr3);
                float f13 = rectFJ.left - rectFJ2.left;
                float f14 = rectFJ.top - rectFJ2.top;
                float f15 = rectFJ.right - rectFJ2.right;
                float f16 = rectFJ.bottom - rectFJ2.bottom;
                fMax = 0.0f;
                if (f13 <= 0.0f) {
                    f13 = 0.0f;
                }
                if (f14 <= 0.0f) {
                    f14 = 0.0f;
                }
                if (f15 >= 0.0f) {
                    f15 = 0.0f;
                }
                if (f16 >= 0.0f) {
                    f16 = 0.0f;
                }
                float[] fArr4 = {f13, f14, f15, f16};
                matrix.reset();
                matrix.setRotate(getCurrentAngle());
                matrix.mapPoints(fArr4);
                fCenterX = -(fArr4[0] + fArr4[2]);
                fCenterY = -(fArr4[1] + fArr4[3]);
                f6 = f8;
            } else {
                RectF rectF2 = new RectF(rectF);
                matrix.reset();
                matrix.setRotate(getCurrentAngle());
                matrix.mapRect(rectF2);
                f6 = f8;
                float[] fArr5 = {(float) Math.sqrt(Math.pow(fArr[1] - fArr[3], 2.0d) + Math.pow(fArr[0] - fArr[2], 2.0d)), (float) Math.sqrt(Math.pow(fArr[3] - fArr[5], 2.0d) + Math.pow(fArr[2] - fArr[4], 2.0d))};
                fMax = (Math.max(rectF2.width() / fArr5[0], rectF2.height() / fArr5[1]) * currentScale) - currentScale;
            }
            float f17 = fCenterX;
            float f18 = fCenterY;
            if (z6) {
                a aVar = new a(this, this.f991A, f7, f6, f17, f18, currentScale, fMax, zE);
                this.f997w = aVar;
                post(aVar);
            } else {
                float f19 = fMax;
                b(f17, f18);
                if (zE) {
                    return;
                }
                g(currentScale + f19, rectF.centerX(), rectF.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j4) {
        if (j4 <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.f991A = j4;
    }

    public void setMaxScaleMultiplier(float f6) {
        this.f995u = f6;
    }

    public void setTargetAspectRatio(float f6) {
        if (getDrawable() == null) {
            this.f994t = f6;
            return;
        }
        if (f6 == 0.0f) {
            this.f994t = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.f994t = f6;
        }
        H3.a aVar = this.f996v;
        if (aVar != null) {
            ((UCropView) ((h) aVar).f2742b).f5862b.setTargetAspectRatio(this.f994t);
        }
    }

    public void setMaxResultImageSizeX(int i) {
    }

    public void setMaxResultImageSizeY(int i) {
    }
}
