package androidx.recyclerview.widget;

import H.E;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.m implements RecyclerView.q {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final int[] f8131D = {R.attr.state_pressed};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final int[] f8132E = new int[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f8133A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Runnable f8134B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final RecyclerView.r f8135C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f8138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f8139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f8142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f8143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f8148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8151p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f8154s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f8161z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8152q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8153r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f8155t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8156u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8157v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8158w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f8159x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f8160y = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.n(500);
        }
    }

    public class b extends RecyclerView.r {
        public b() {
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8164a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8164a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8164a) {
                this.f8164a = false;
                return;
            }
            if (((Float) d.this.f8161z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.f8133A = 0;
                dVar.v(0);
            } else {
                d dVar2 = d.this;
                dVar2.f8133A = 2;
                dVar2.s();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    public class C0118d implements ValueAnimator.AnimatorUpdateListener {
        public C0118d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f8138c.setAlpha(iFloatValue);
            d.this.f8139d.setAlpha(iFloatValue);
            d.this.s();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i4, int i5, int i6) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8161z = valueAnimatorOfFloat;
        this.f8133A = 0;
        this.f8134B = new a();
        this.f8135C = new b();
        this.f8138c = stateListDrawable;
        this.f8139d = drawable;
        this.f8142g = stateListDrawable2;
        this.f8143h = drawable2;
        this.f8140e = Math.max(i4, stateListDrawable.getIntrinsicWidth());
        this.f8141f = Math.max(i4, drawable.getIntrinsicWidth());
        this.f8144i = Math.max(i4, stateListDrawable2.getIntrinsicWidth());
        this.f8145j = Math.max(i4, drawable2.getIntrinsicWidth());
        this.f8136a = i5;
        this.f8137b = i6;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0118d());
        g(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f8157v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zR = r(motionEvent.getX(), motionEvent.getY());
            boolean zQ = q(motionEvent.getX(), motionEvent.getY());
            if (zR || zQ) {
                if (zQ) {
                    this.f8158w = 1;
                    this.f8151p = (int) motionEvent.getX();
                } else if (zR) {
                    this.f8158w = 2;
                    this.f8148m = (int) motionEvent.getY();
                }
                v(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f8157v == 2) {
            this.f8148m = 0.0f;
            this.f8151p = 0.0f;
            v(1);
            this.f8158w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f8157v == 2) {
            x();
            if (this.f8158w == 1) {
                o(motionEvent.getX());
            }
            if (this.f8158w == 2) {
                y(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i4 = this.f8157v;
        if (i4 != 1) {
            return i4 == 2;
        }
        boolean zR = r(motionEvent.getX(), motionEvent.getY());
        boolean zQ = q(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zR && !zQ)) {
            return false;
        }
        if (zQ) {
            this.f8158w = 1;
            this.f8151p = (int) motionEvent.getX();
        } else if (zR) {
            this.f8158w = 2;
            this.f8148m = (int) motionEvent.getY();
        }
        v(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if (this.f8152q != this.f8154s.getWidth() || this.f8153r != this.f8154s.getHeight()) {
            this.f8152q = this.f8154s.getWidth();
            this.f8153r = this.f8154s.getHeight();
            v(0);
        } else if (this.f8133A != 0) {
            if (this.f8155t) {
                k(canvas);
            }
            if (this.f8156u) {
                j(canvas);
            }
        }
    }

    public void g(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f8154s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            i();
        }
        this.f8154s = recyclerView;
        if (recyclerView != null) {
            w();
        }
    }

    public final void h() {
        this.f8154s.removeCallbacks(this.f8134B);
    }

    public final void i() {
        this.f8154s.j0(this);
        this.f8154s.k0(this);
        this.f8154s.l0(this.f8135C);
        h();
    }

    public final void j(Canvas canvas) {
        int i4 = this.f8153r;
        int i5 = this.f8144i;
        int i6 = this.f8150o;
        int i7 = this.f8149n;
        this.f8142g.setBounds(0, 0, i7, i5);
        this.f8143h.setBounds(0, 0, this.f8152q, this.f8145j);
        canvas.translate(0.0f, i4 - i5);
        this.f8143h.draw(canvas);
        canvas.translate(i6 - (i7 / 2), 0.0f);
        this.f8142g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void k(Canvas canvas) {
        int i4 = this.f8152q;
        int i5 = this.f8140e;
        int i6 = i4 - i5;
        int i7 = this.f8147l;
        int i8 = this.f8146k;
        int i9 = i7 - (i8 / 2);
        this.f8138c.setBounds(0, 0, i5, i8);
        this.f8139d.setBounds(0, 0, this.f8141f, this.f8153r);
        if (!p()) {
            canvas.translate(i6, 0.0f);
            this.f8139d.draw(canvas);
            canvas.translate(0.0f, i9);
            this.f8138c.draw(canvas);
            canvas.translate(-i6, -i9);
            return;
        }
        this.f8139d.draw(canvas);
        canvas.translate(this.f8140e, i9);
        canvas.scale(-1.0f, 1.0f);
        this.f8138c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f8140e, -i9);
    }

    public final int[] l() {
        int[] iArr = this.f8160y;
        int i4 = this.f8137b;
        iArr[0] = i4;
        iArr[1] = this.f8152q - i4;
        return iArr;
    }

    public final int[] m() {
        int[] iArr = this.f8159x;
        int i4 = this.f8137b;
        iArr[0] = i4;
        iArr[1] = this.f8153r - i4;
        return iArr;
    }

    public void n(int i4) {
        int i5 = this.f8133A;
        if (i5 == 1) {
            this.f8161z.cancel();
        } else if (i5 != 2) {
            return;
        }
        this.f8133A = 3;
        ValueAnimator valueAnimator = this.f8161z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f8161z.setDuration(i4);
        this.f8161z.start();
    }

    public final void o(float f4) {
        int[] iArrL = l();
        float fMax = Math.max(iArrL[0], Math.min(iArrL[1], f4));
        if (Math.abs(this.f8150o - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f8151p, fMax, iArrL, this.f8154s.computeHorizontalScrollRange(), this.f8154s.computeHorizontalScrollOffset(), this.f8152q);
        if (iU != 0) {
            this.f8154s.scrollBy(iU, 0);
        }
        this.f8151p = fMax;
    }

    public final boolean p() {
        return E.n(this.f8154s) == 1;
    }

    public boolean q(float f4, float f5) {
        if (f5 < this.f8153r - this.f8144i) {
            return false;
        }
        int i4 = this.f8150o;
        int i5 = this.f8149n;
        return f4 >= ((float) (i4 - (i5 / 2))) && f4 <= ((float) (i4 + (i5 / 2)));
    }

    public boolean r(float f4, float f5) {
        if (p()) {
            if (f4 > this.f8140e / 2) {
                return false;
            }
        } else if (f4 < this.f8152q - this.f8140e) {
            return false;
        }
        int i4 = this.f8147l;
        int i5 = this.f8146k;
        return f5 >= ((float) (i4 - (i5 / 2))) && f5 <= ((float) (i4 + (i5 / 2)));
    }

    public void s() {
        this.f8154s.invalidate();
    }

    public final void t(int i4) {
        h();
        this.f8154s.postDelayed(this.f8134B, i4);
    }

    public final int u(float f4, float f5, int[] iArr, int i4, int i5, int i6) {
        int i7 = iArr[1] - iArr[0];
        if (i7 == 0) {
            return 0;
        }
        int i8 = i4 - i6;
        int i9 = (int) (((f5 - f4) / i7) * i8);
        int i10 = i5 + i9;
        if (i10 >= i8 || i10 < 0) {
            return 0;
        }
        return i9;
    }

    public void v(int i4) {
        if (i4 == 2 && this.f8157v != 2) {
            this.f8138c.setState(f8131D);
            h();
        }
        if (i4 == 0) {
            s();
        } else {
            x();
        }
        if (this.f8157v == 2 && i4 != 2) {
            this.f8138c.setState(f8132E);
            t(1200);
        } else if (i4 == 1) {
            t(1500);
        }
        this.f8157v = i4;
    }

    public final void w() {
        this.f8154s.c(this);
        this.f8154s.e(this);
        this.f8154s.f(this.f8135C);
    }

    public void x() {
        int i4 = this.f8133A;
        if (i4 != 0) {
            if (i4 != 3) {
                return;
            } else {
                this.f8161z.cancel();
            }
        }
        this.f8133A = 1;
        ValueAnimator valueAnimator = this.f8161z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f8161z.setDuration(500L);
        this.f8161z.setStartDelay(0L);
        this.f8161z.start();
    }

    public final void y(float f4) {
        int[] iArrM = m();
        float fMax = Math.max(iArrM[0], Math.min(iArrM[1], f4));
        if (Math.abs(this.f8147l - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f8148m, fMax, iArrM, this.f8154s.computeVerticalScrollRange(), this.f8154s.computeVerticalScrollOffset(), this.f8153r);
        if (iU != 0) {
            this.f8154s.scrollBy(0, iU);
        }
        this.f8148m = fMax;
    }
}
