package com.google.android.material.timepicker;

import Q.N;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n2.AbstractC2252a;
import n2.i;
import n2.j;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f11800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f11806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f11808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f11809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f11810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f11814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11815p;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f7, boolean z7);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC2252a.f19113q);
    }

    public void b(c cVar) {
        this.f11806g.add(cVar);
    }

    public final void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.f11815p * ((float) Math.cos(this.f11814o))) + width;
        float f7 = height;
        float fSin = (this.f11815p * ((float) Math.sin(this.f11814o))) + f7;
        this.f11809j.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f11807h, this.f11809j);
        double dSin = Math.sin(this.f11814o);
        double dCos = Math.cos(this.f11814o);
        this.f11809j.setStrokeWidth(this.f11811l);
        canvas.drawLine(width, f7, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f11809j);
        canvas.drawCircle(width, f7, this.f11808i, this.f11809j);
    }

    public RectF d() {
        return this.f11810k;
    }

    public final int e(float f7, float f8) {
        int degrees = (int) Math.toDegrees(Math.atan2(f8 - (getHeight() / 2), f7 - (getWidth() / 2)));
        int i7 = degrees + 90;
        return i7 < 0 ? degrees + 450 : i7;
    }

    public float f() {
        return this.f11812m;
    }

    public int g() {
        return this.f11807h;
    }

    public final Pair h(float f7) {
        float f8 = f();
        if (Math.abs(f8 - f7) > 180.0f) {
            if (f8 > 180.0f && f7 < 180.0f) {
                f7 += 360.0f;
            }
            if (f8 < 180.0f && f7 > 180.0f) {
                f8 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f8), Float.valueOf(f7));
    }

    public final boolean i(float f7, float f8, boolean z7, boolean z8, boolean z9) {
        float fE = e(f7, f8);
        boolean z10 = false;
        boolean z11 = f() != fE;
        if (z8 && z11) {
            return true;
        }
        if (!z11 && !z7) {
            return false;
        }
        if (z9 && this.f11801b) {
            z10 = true;
        }
        l(fE, z10);
        return true;
    }

    public void j(int i7) {
        this.f11815p = i7;
        invalidate();
    }

    public void k(float f7) {
        l(f7, false);
    }

    public void l(float f7, boolean z7) {
        ValueAnimator valueAnimator = this.f11800a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z7) {
            m(f7, false);
            return;
        }
        Pair pairH = h(f7);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.f11800a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f11800a.addUpdateListener(new a());
        this.f11800a.addListener(new b());
        this.f11800a.start();
    }

    public final void m(float f7, boolean z7) {
        float f8 = f7 % 360.0f;
        this.f11812m = f8;
        this.f11814o = Math.toRadians(f8 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f11815p * ((float) Math.cos(this.f11814o)));
        float fSin = height + (this.f11815p * ((float) Math.sin(this.f11814o)));
        RectF rectF = this.f11810k;
        int i7 = this.f11807h;
        rectF.set(width - i7, fSin - i7, width + i7, fSin + i7);
        Iterator it = this.f11806g.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f8, z7);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        k(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z8;
        boolean z9;
        int actionMasked = motionEvent.getActionMasked();
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f11802c = x7;
            this.f11803d = y7;
            this.f11804e = true;
            this.f11813n = false;
            z7 = true;
            z8 = false;
            z9 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i7 = (int) (x7 - this.f11802c);
            int i8 = (int) (y7 - this.f11803d);
            this.f11804e = (i7 * i7) + (i8 * i8) > this.f11805f;
            z8 = this.f11813n;
            z9 = actionMasked == 1;
            z7 = false;
        } else {
            z8 = false;
            z7 = false;
            z9 = false;
        }
        this.f11813n |= i(x7, y7, z8, z7, z9);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11806g = new ArrayList();
        Paint paint = new Paint();
        this.f11809j = paint;
        this.f11810k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f19378R0, i7, i.f19257j);
        this.f11815p = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19392T0, 0);
        this.f11807h = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19399U0, 0);
        this.f11811l = getResources().getDimensionPixelSize(n2.c.f19149h);
        this.f11808i = r6.getDimensionPixelSize(n2.c.f19147f);
        int color = typedArrayObtainStyledAttributes.getColor(j.f19385S0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f11805f = ViewConfiguration.get(context).getScaledTouchSlop();
        N.v0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
