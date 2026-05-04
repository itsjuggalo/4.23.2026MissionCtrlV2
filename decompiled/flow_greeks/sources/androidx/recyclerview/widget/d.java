package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import t0.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.m implements RecyclerView.q {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.r C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f2796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f2797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f2800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f2801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2809p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f2812s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f2819z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2810q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2811r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2813t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2814u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2815v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2816w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f2817x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f2818y = new int[2];

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.n(500);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends RecyclerView.r {
        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2822a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2822a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2822a) {
                this.f2822a = false;
                return;
            }
            if (((Float) d.this.f2819z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.v(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.s();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0042d implements ValueAnimator.AnimatorUpdateListener {
        public C0042d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f2796c.setAlpha(iFloatValue);
            d.this.f2797d.setAlpha(iFloatValue);
            d.this.s();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2819z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f2796c = stateListDrawable;
        this.f2797d = drawable;
        this.f2800g = stateListDrawable2;
        this.f2801h = drawable2;
        this.f2798e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f2799f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f2802i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f2803j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f2794a = i11;
        this.f2795b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0042d());
        g(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2815v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zR = r(motionEvent.getX(), motionEvent.getY());
            boolean zQ = q(motionEvent.getX(), motionEvent.getY());
            if (zR || zQ) {
                if (zQ) {
                    this.f2816w = 1;
                    this.f2809p = (int) motionEvent.getX();
                } else if (zR) {
                    this.f2816w = 2;
                    this.f2806m = (int) motionEvent.getY();
                }
                v(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f2815v == 2) {
            this.f2806m = 0.0f;
            this.f2809p = 0.0f;
            v(1);
            this.f2816w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f2815v == 2) {
            x();
            if (this.f2816w == 1) {
                o(motionEvent.getX());
            }
            if (this.f2816w == 2) {
                y(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f2815v;
        if (i10 != 1) {
            return i10 == 2;
        }
        boolean zR = r(motionEvent.getX(), motionEvent.getY());
        boolean zQ = q(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zR && !zQ)) {
            return false;
        }
        if (zQ) {
            this.f2816w = 1;
            this.f2809p = (int) motionEvent.getX();
        } else if (zR) {
            this.f2816w = 2;
            this.f2806m = (int) motionEvent.getY();
        }
        v(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if (this.f2810q != this.f2812s.getWidth() || this.f2811r != this.f2812s.getHeight()) {
            this.f2810q = this.f2812s.getWidth();
            this.f2811r = this.f2812s.getHeight();
            v(0);
        } else if (this.A != 0) {
            if (this.f2813t) {
                k(canvas);
            }
            if (this.f2814u) {
                j(canvas);
            }
        }
    }

    public void g(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2812s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            i();
        }
        this.f2812s = recyclerView;
        if (recyclerView != null) {
            w();
        }
    }

    public final void h() {
        this.f2812s.removeCallbacks(this.B);
    }

    public final void i() {
        this.f2812s.j0(this);
        this.f2812s.k0(this);
        this.f2812s.l0(this.C);
        h();
    }

    public final void j(Canvas canvas) {
        int i10 = this.f2811r;
        int i11 = this.f2802i;
        int i12 = this.f2808o;
        int i13 = this.f2807n;
        this.f2800g.setBounds(0, 0, i13, i11);
        this.f2801h.setBounds(0, 0, this.f2810q, this.f2803j);
        canvas.translate(0.0f, i10 - i11);
        this.f2801h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f2800g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void k(Canvas canvas) {
        int i10 = this.f2810q;
        int i11 = this.f2798e;
        int i12 = i10 - i11;
        int i13 = this.f2805l;
        int i14 = this.f2804k;
        int i15 = i13 - (i14 / 2);
        this.f2796c.setBounds(0, 0, i11, i14);
        this.f2797d.setBounds(0, 0, this.f2799f, this.f2811r);
        if (!p()) {
            canvas.translate(i12, 0.0f);
            this.f2797d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f2796c.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f2797d.draw(canvas);
        canvas.translate(this.f2798e, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f2796c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f2798e, -i15);
    }

    public final int[] l() {
        int[] iArr = this.f2818y;
        int i10 = this.f2795b;
        iArr[0] = i10;
        iArr[1] = this.f2810q - i10;
        return iArr;
    }

    public final int[] m() {
        int[] iArr = this.f2817x;
        int i10 = this.f2795b;
        iArr[0] = i10;
        iArr[1] = this.f2811r - i10;
        return iArr;
    }

    public void n(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f2819z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f2819z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f2819z.setDuration(i10);
        this.f2819z.start();
    }

    public final void o(float f10) {
        int[] iArrL = l();
        float fMax = Math.max(iArrL[0], Math.min(iArrL[1], f10));
        if (Math.abs(this.f2808o - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f2809p, fMax, iArrL, this.f2812s.computeHorizontalScrollRange(), this.f2812s.computeHorizontalScrollOffset(), this.f2810q);
        if (iU != 0) {
            this.f2812s.scrollBy(iU, 0);
        }
        this.f2809p = fMax;
    }

    public final boolean p() {
        return c0.q(this.f2812s) == 1;
    }

    public boolean q(float f10, float f11) {
        if (f11 < this.f2811r - this.f2802i) {
            return false;
        }
        int i10 = this.f2808o;
        int i11 = this.f2807n;
        return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) (i10 + (i11 / 2)));
    }

    public boolean r(float f10, float f11) {
        if (p()) {
            if (f10 > this.f2798e / 2) {
                return false;
            }
        } else if (f10 < this.f2810q - this.f2798e) {
            return false;
        }
        int i10 = this.f2805l;
        int i11 = this.f2804k;
        return f11 >= ((float) (i10 - (i11 / 2))) && f11 <= ((float) (i10 + (i11 / 2)));
    }

    public void s() {
        this.f2812s.invalidate();
    }

    public final void t(int i10) {
        h();
        this.f2812s.postDelayed(this.B, i10);
    }

    public final int u(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    public void v(int i10) {
        if (i10 == 2 && this.f2815v != 2) {
            this.f2796c.setState(D);
            h();
        }
        if (i10 == 0) {
            s();
        } else {
            x();
        }
        if (this.f2815v == 2 && i10 != 2) {
            this.f2796c.setState(E);
            t(1200);
        } else if (i10 == 1) {
            t(1500);
        }
        this.f2815v = i10;
    }

    public final void w() {
        this.f2812s.c(this);
        this.f2812s.e(this);
        this.f2812s.f(this.C);
    }

    public void x() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f2819z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2819z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2819z.setDuration(500L);
        this.f2819z.setStartDelay(0L);
        this.f2819z.start();
    }

    public final void y(float f10) {
        int[] iArrM = m();
        float fMax = Math.max(iArrM[0], Math.min(iArrM[1], f10));
        if (Math.abs(this.f2805l - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f2806m, fMax, iArrM, this.f2812s.computeVerticalScrollRange(), this.f2812s.computeVerticalScrollOffset(), this.f2811r);
        if (iU != 0) {
            this.f2812s.scrollBy(0, iU);
        }
        this.f2806m = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z10) {
    }
}
