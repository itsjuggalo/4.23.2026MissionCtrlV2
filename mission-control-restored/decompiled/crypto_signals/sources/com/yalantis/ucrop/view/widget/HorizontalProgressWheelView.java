package com.yalantis.ucrop.view.widget;

import L3.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cryptosignals.ap.android.R;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalProgressWheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f5869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f5871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f5872d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5873f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f5876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5877n;

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5869a = new Rect();
        this.f5877n = AbstractC1193h.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.e = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f5873f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f5874k = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f5871c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f5871c.setStrokeWidth(this.e);
        this.f5871c.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f5871c);
        this.f5872d = paint2;
        paint2.setColor(this.f5877n);
        this.f5872d.setStrokeCap(Paint.Cap.ROUND);
        this.f5872d.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f5869a;
        canvas.getClipBounds(rect);
        int iWidth = rect.width() / (this.e + this.f5874k);
        float f6 = this.f5876m % (r4 + r3);
        for (int i = 0; i < iWidth; i++) {
            int i6 = iWidth / 4;
            if (i < i6) {
                this.f5871c.setAlpha((int) ((i / i6) * 255.0f));
            } else if (i > (iWidth * 3) / 4) {
                this.f5871c.setAlpha((int) (((iWidth - i) / i6) * 255.0f));
            } else {
                this.f5871c.setAlpha(255);
            }
            float f7 = -f6;
            canvas.drawLine(rect.left + f7 + ((this.e + this.f5874k) * i), rect.centerY() - (this.f5873f / 4.0f), f7 + rect.left + ((this.e + this.f5874k) * i), rect.centerY() + (this.f5873f / 4.0f), this.f5871c);
        }
        canvas.drawLine(rect.centerX(), rect.centerY() - (this.f5873f / 2.0f), rect.centerX(), (this.f5873f / 2.0f) + rect.centerY(), this.f5872d);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5870b = motionEvent.getX();
            return true;
        }
        if (action != 1 && action == 2) {
            float x6 = motionEvent.getX() - this.f5870b;
            if (x6 != 0.0f) {
                if (!this.f5875l) {
                    this.f5875l = true;
                }
                this.f5876m -= x6;
                postInvalidate();
                this.f5870b = motionEvent.getX();
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i) {
        this.f5877n = i;
        this.f5872d.setColor(i);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
    }
}
