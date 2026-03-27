package com.yalantis.ucrop.view;

import B4.a;
import B4.f;
import C4.b;
import E4.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class OverlayView extends View {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public b f13001A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f13002B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f13003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f13004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f13007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f13008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f13012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f13017o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f13018p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f13019q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f13020r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f13021s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13022t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13023u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13024v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13025w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13026x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13027y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13028z;

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(Canvas canvas) {
        if (this.f13014l) {
            if (this.f13012j == null && !this.f13003a.isEmpty()) {
                this.f13012j = new float[(this.f13009g * 4) + (this.f13010h * 4)];
                int i7 = 0;
                for (int i8 = 0; i8 < this.f13009g; i8++) {
                    float[] fArr = this.f13012j;
                    RectF rectF = this.f13003a;
                    fArr[i7] = rectF.left;
                    float f7 = i8 + 1.0f;
                    float fHeight = rectF.height() * (f7 / (this.f13009g + 1));
                    RectF rectF2 = this.f13003a;
                    fArr[i7 + 1] = fHeight + rectF2.top;
                    float[] fArr2 = this.f13012j;
                    int i9 = i7 + 3;
                    fArr2[i7 + 2] = rectF2.right;
                    i7 += 4;
                    fArr2[i9] = (rectF2.height() * (f7 / (this.f13009g + 1))) + this.f13003a.top;
                }
                for (int i10 = 0; i10 < this.f13010h; i10++) {
                    float[] fArr3 = this.f13012j;
                    float f8 = i10 + 1.0f;
                    float fWidth = this.f13003a.width() * (f8 / (this.f13010h + 1));
                    RectF rectF3 = this.f13003a;
                    fArr3[i7] = fWidth + rectF3.left;
                    float[] fArr4 = this.f13012j;
                    fArr4[i7 + 1] = rectF3.top;
                    int i11 = i7 + 3;
                    float fWidth2 = rectF3.width() * (f8 / (this.f13010h + 1));
                    RectF rectF4 = this.f13003a;
                    fArr4[i7 + 2] = fWidth2 + rectF4.left;
                    i7 += 4;
                    this.f13012j[i11] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f13012j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f13019q);
            }
        }
        if (this.f13013k) {
            canvas.drawRect(this.f13003a, this.f13020r);
        }
        if (this.f13022t != 0) {
            canvas.save();
            this.f13004b.set(this.f13003a);
            this.f13004b.inset(this.f13028z, -r1);
            RectF rectF5 = this.f13004b;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF5, op);
            this.f13004b.set(this.f13003a);
            this.f13004b.inset(-r2, this.f13028z);
            canvas.clipRect(this.f13004b, op);
            canvas.drawRect(this.f13003a, this.f13021s);
            canvas.restore();
        }
    }

    public void b(Canvas canvas) {
        canvas.save();
        if (this.f13015m) {
            canvas.clipPath(this.f13017o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f13003a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f13016n);
        canvas.restore();
        if (this.f13015m) {
            canvas.drawCircle(this.f13003a.centerX(), this.f13003a.centerY(), Math.min(this.f13003a.width(), this.f13003a.height()) / 2.0f, this.f13018p);
        }
    }

    public final int c(float f7, float f8) {
        double d7 = this.f13026x;
        int i7 = -1;
        for (int i8 = 0; i8 < 8; i8 += 2) {
            double dSqrt = Math.sqrt(Math.pow(f7 - this.f13007e[i8], 2.0d) + Math.pow(f8 - this.f13007e[i8 + 1], 2.0d));
            if (dSqrt < d7) {
                i7 = i8 / 2;
                d7 = dSqrt;
            }
        }
        if (this.f13022t == 1 && i7 < 0 && this.f13003a.contains(f7, f8)) {
            return 4;
        }
        return i7;
    }

    public void d() {
    }

    public final void e(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(f.f809h0, getResources().getDimensionPixelSize(B4.b.f754a));
        int color = typedArray.getColor(f.f807g0, getResources().getColor(a.f747a));
        this.f13020r.setStrokeWidth(dimensionPixelSize);
        this.f13020r.setColor(color);
        Paint paint = this.f13020r;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f13021s.setStrokeWidth(dimensionPixelSize * 3);
        this.f13021s.setColor(color);
        this.f13021s.setStyle(style);
    }

    public final void f(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(f.f817l0, getResources().getDimensionPixelSize(B4.b.f755b));
        int color = typedArray.getColor(f.f811i0, getResources().getColor(a.f748b));
        this.f13019q.setStrokeWidth(dimensionPixelSize);
        this.f13019q.setColor(color);
        this.f13009g = typedArray.getInt(f.f815k0, 2);
        this.f13010h = typedArray.getInt(f.f813j0, 2);
    }

    public void g(TypedArray typedArray) {
        this.f13015m = typedArray.getBoolean(f.f803e0, false);
        int color = typedArray.getColor(f.f805f0, getResources().getColor(a.f749c));
        this.f13016n = color;
        this.f13018p.setColor(color);
        this.f13018p.setStyle(Paint.Style.STROKE);
        this.f13018p.setStrokeWidth(1.0f);
        e(typedArray);
        this.f13013k = typedArray.getBoolean(f.f819m0, true);
        f(typedArray);
        this.f13014l = typedArray.getBoolean(f.f821n0, true);
    }

    public RectF getCropViewRect() {
        return this.f13003a;
    }

    public int getFreestyleCropMode() {
        return this.f13022t;
    }

    public b getOverlayViewChangeListener() {
        return this.f13001A;
    }

    public void h() {
        int i7 = this.f13005c;
        float f7 = this.f13011i;
        int i8 = (int) (i7 / f7);
        int i9 = this.f13006d;
        if (i8 > i9) {
            int i10 = (i7 - ((int) (i9 * f7))) / 2;
            this.f13003a.set(getPaddingLeft() + i10, getPaddingTop(), getPaddingLeft() + r1 + i10, getPaddingTop() + this.f13006d);
        } else {
            int i11 = (i9 - i8) / 2;
            this.f13003a.set(getPaddingLeft(), getPaddingTop() + i11, getPaddingLeft() + this.f13005c, getPaddingTop() + i8 + i11);
        }
        b bVar = this.f13001A;
        if (bVar != null) {
            bVar.a(this.f13003a);
        }
        j();
    }

    public final void i(float f7, float f8) {
        this.f13004b.set(this.f13003a);
        int i7 = this.f13025w;
        if (i7 == 0) {
            RectF rectF = this.f13004b;
            RectF rectF2 = this.f13003a;
            rectF.set(f7, f8, rectF2.right, rectF2.bottom);
        } else if (i7 == 1) {
            RectF rectF3 = this.f13004b;
            RectF rectF4 = this.f13003a;
            rectF3.set(rectF4.left, f8, f7, rectF4.bottom);
        } else if (i7 == 2) {
            RectF rectF5 = this.f13004b;
            RectF rectF6 = this.f13003a;
            rectF5.set(rectF6.left, rectF6.top, f7, f8);
        } else if (i7 == 3) {
            RectF rectF7 = this.f13004b;
            RectF rectF8 = this.f13003a;
            rectF7.set(f7, rectF8.top, rectF8.right, f8);
        } else if (i7 == 4) {
            this.f13004b.offset(f7 - this.f13023u, f8 - this.f13024v);
            if (this.f13004b.left <= getLeft() || this.f13004b.top <= getTop() || this.f13004b.right >= getRight() || this.f13004b.bottom >= getBottom()) {
                return;
            }
            this.f13003a.set(this.f13004b);
            j();
            postInvalidate();
            return;
        }
        boolean z7 = this.f13004b.height() >= ((float) this.f13027y);
        boolean z8 = this.f13004b.width() >= ((float) this.f13027y);
        RectF rectF9 = this.f13003a;
        rectF9.set(z8 ? this.f13004b.left : rectF9.left, z7 ? this.f13004b.top : rectF9.top, z8 ? this.f13004b.right : rectF9.right, z7 ? this.f13004b.bottom : rectF9.bottom);
        if (z7 || z8) {
            j();
            postInvalidate();
        }
    }

    public final void j() {
        this.f13007e = e.b(this.f13003a);
        this.f13008f = e.a(this.f13003a);
        this.f13012j = null;
        this.f13017o.reset();
        this.f13017o.addCircle(this.f13003a.centerX(), this.f13003a.centerY(), Math.min(this.f13003a.width(), this.f13003a.height()) / 2.0f, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f13005c = width - paddingLeft;
            this.f13006d = height - paddingTop;
            if (this.f13002B) {
                this.f13002B = false;
                setTargetAspectRatio(this.f13011i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f13003a.isEmpty() && this.f13022t != 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int iC = c(x7, y7);
                this.f13025w = iC;
                boolean z7 = iC != -1;
                if (!z7) {
                    this.f13023u = -1.0f;
                    this.f13024v = -1.0f;
                } else if (this.f13023u < 0.0f) {
                    this.f13023u = x7;
                    this.f13024v = y7;
                }
                return z7;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f13025w != -1) {
                float fMin = Math.min(Math.max(x7, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = Math.min(Math.max(y7, getPaddingTop()), getHeight() - getPaddingBottom());
                i(fMin, fMin2);
                this.f13023u = fMin;
                this.f13024v = fMin2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.f13023u = -1.0f;
                this.f13024v = -1.0f;
                this.f13025w = -1;
                b bVar = this.f13001A;
                if (bVar != null) {
                    bVar.a(this.f13003a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z7) {
        this.f13015m = z7;
    }

    public void setCropFrameColor(int i7) {
        this.f13020r.setColor(i7);
    }

    public void setCropFrameStrokeWidth(int i7) {
        this.f13020r.setStrokeWidth(i7);
    }

    public void setCropGridColor(int i7) {
        this.f13019q.setColor(i7);
    }

    public void setCropGridColumnCount(int i7) {
        this.f13010h = i7;
        this.f13012j = null;
    }

    public void setCropGridRowCount(int i7) {
        this.f13009g = i7;
        this.f13012j = null;
    }

    public void setCropGridStrokeWidth(int i7) {
        this.f13019q.setStrokeWidth(i7);
    }

    public void setDimmedColor(int i7) {
        this.f13016n = i7;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z7) {
        this.f13022t = z7 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i7) {
        this.f13022t = i7;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(b bVar) {
        this.f13001A = bVar;
    }

    public void setShowCropFrame(boolean z7) {
        this.f13013k = z7;
    }

    public void setShowCropGrid(boolean z7) {
        this.f13014l = z7;
    }

    public void setTargetAspectRatio(float f7) {
        this.f13011i = f7;
        if (this.f13005c <= 0) {
            this.f13002B = true;
        } else {
            h();
            postInvalidate();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f13003a = new RectF();
        this.f13004b = new RectF();
        this.f13012j = null;
        this.f13017o = new Path();
        this.f13018p = new Paint(1);
        this.f13019q = new Paint(1);
        this.f13020r = new Paint(1);
        this.f13021s = new Paint(1);
        this.f13022t = 0;
        this.f13023u = -1.0f;
        this.f13024v = -1.0f;
        this.f13025w = -1;
        this.f13026x = getResources().getDimensionPixelSize(B4.b.f757d);
        this.f13027y = getResources().getDimensionPixelSize(B4.b.f758e);
        this.f13028z = getResources().getDimensionPixelSize(B4.b.f756c);
        d();
    }
}
