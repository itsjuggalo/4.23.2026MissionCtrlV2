package com.yalantis.ucrop.view.widget;

import B4.b;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalProgressWheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f13041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f13043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f13044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13050j;

    public interface a {
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        this.f13050j = G.a.getColor(getContext(), B4.a.f753g);
        this.f13045e = getContext().getResources().getDimensionPixelSize(b.f762i);
        this.f13046f = getContext().getResources().getDimensionPixelSize(b.f759f);
        this.f13047g = getContext().getResources().getDimensionPixelSize(b.f760g);
        Paint paint = new Paint(1);
        this.f13043c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f13043c.setStrokeWidth(this.f13045e);
        this.f13043c.setColor(getResources().getColor(B4.a.f750d));
        Paint paint2 = new Paint(this.f13043c);
        this.f13044d = paint2;
        paint2.setColor(this.f13050j);
        this.f13044d.setStrokeCap(Paint.Cap.ROUND);
        this.f13044d.setStrokeWidth(getContext().getResources().getDimensionPixelSize(b.f763j));
    }

    public final void b(MotionEvent motionEvent, float f7) {
        this.f13049i -= f7;
        postInvalidate();
        this.f13042b = motionEvent.getX();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f13041a);
        int iWidth = this.f13041a.width() / (this.f13045e + this.f13047g);
        float f7 = this.f13049i % (r2 + r1);
        for (int i7 = 0; i7 < iWidth; i7++) {
            int i8 = iWidth / 4;
            if (i7 < i8) {
                this.f13043c.setAlpha((int) ((i7 / i8) * 255.0f));
            } else if (i7 > (iWidth * 3) / 4) {
                this.f13043c.setAlpha((int) (((iWidth - i7) / i8) * 255.0f));
            } else {
                this.f13043c.setAlpha(255);
            }
            float f8 = -f7;
            Rect rect = this.f13041a;
            float f9 = rect.left + f8 + ((this.f13045e + this.f13047g) * i7);
            float fCenterY = rect.centerY() - (this.f13046f / 4.0f);
            Rect rect2 = this.f13041a;
            canvas.drawLine(f9, fCenterY, f8 + rect2.left + ((this.f13045e + this.f13047g) * i7), rect2.centerY() + (this.f13046f / 4.0f), this.f13043c);
        }
        canvas.drawLine(this.f13041a.centerX(), this.f13041a.centerY() - (this.f13046f / 2.0f), this.f13041a.centerX(), (this.f13046f / 2.0f) + this.f13041a.centerY(), this.f13044d);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13042b = motionEvent.getX();
        } else if (action != 1 && action == 2) {
            float x7 = motionEvent.getX() - this.f13042b;
            if (x7 != 0.0f) {
                if (!this.f13048h) {
                    this.f13048h = true;
                }
                b(motionEvent, x7);
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i7) {
        this.f13050j = i7;
        this.f13044d.setColor(i7);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f13041a = new Rect();
        a();
    }
}
