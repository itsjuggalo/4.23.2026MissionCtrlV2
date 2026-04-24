package androidx.recyclerview.widget;

import T.D;
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
    public static final int[] f12427D = {R.attr.state_pressed};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final int[] f12428E = new int[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f12429A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Runnable f12430B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final RecyclerView.r f12431C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f12434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f12435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f12438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f12439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12447p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f12450s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f12457z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12448q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12449r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12451t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12452u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12453v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12454w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f12455x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f12456y = new int[2];

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
        public boolean f12460a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12460a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f12460a) {
                this.f12460a = false;
                return;
            }
            if (((Float) d.this.f12457z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.f12429A = 0;
                dVar.v(0);
            } else {
                d dVar2 = d.this;
                dVar2.f12429A = 2;
                dVar2.s();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    public class C0201d implements ValueAnimator.AnimatorUpdateListener {
        public C0201d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f12434c.setAlpha(iFloatValue);
            d.this.f12435d.setAlpha(iFloatValue);
            d.this.s();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i8, int i9, int i10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f12457z = valueAnimatorOfFloat;
        this.f12429A = 0;
        this.f12430B = new a();
        this.f12431C = new b();
        this.f12434c = stateListDrawable;
        this.f12435d = drawable;
        this.f12438g = stateListDrawable2;
        this.f12439h = drawable2;
        this.f12436e = Math.max(i8, stateListDrawable.getIntrinsicWidth());
        this.f12437f = Math.max(i8, drawable.getIntrinsicWidth());
        this.f12440i = Math.max(i8, stateListDrawable2.getIntrinsicWidth());
        this.f12441j = Math.max(i8, drawable2.getIntrinsicWidth());
        this.f12432a = i9;
        this.f12433b = i10;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0201d());
        g(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f12453v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zR = r(motionEvent.getX(), motionEvent.getY());
            boolean zQ = q(motionEvent.getX(), motionEvent.getY());
            if (zR || zQ) {
                if (zQ) {
                    this.f12454w = 1;
                    this.f12447p = (int) motionEvent.getX();
                } else if (zR) {
                    this.f12454w = 2;
                    this.f12444m = (int) motionEvent.getY();
                }
                v(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f12453v == 2) {
            this.f12444m = 0.0f;
            this.f12447p = 0.0f;
            v(1);
            this.f12454w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f12453v == 2) {
            x();
            if (this.f12454w == 1) {
                o(motionEvent.getX());
            }
            if (this.f12454w == 2) {
                y(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i8 = this.f12453v;
        if (i8 == 1) {
            boolean zR = r(motionEvent.getX(), motionEvent.getY());
            boolean zQ = q(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zR && !zQ) {
                return false;
            }
            if (zQ) {
                this.f12454w = 1;
                this.f12447p = (int) motionEvent.getX();
            } else if (zR) {
                this.f12454w = 2;
                this.f12444m = (int) motionEvent.getY();
            }
            v(2);
        } else if (i8 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if (this.f12448q != this.f12450s.getWidth() || this.f12449r != this.f12450s.getHeight()) {
            this.f12448q = this.f12450s.getWidth();
            this.f12449r = this.f12450s.getHeight();
            v(0);
        } else if (this.f12429A != 0) {
            if (this.f12451t) {
                k(canvas);
            }
            if (this.f12452u) {
                j(canvas);
            }
        }
    }

    public void g(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f12450s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            i();
        }
        this.f12450s = recyclerView;
        if (recyclerView != null) {
            w();
        }
    }

    public final void h() {
        this.f12450s.removeCallbacks(this.f12430B);
    }

    public final void i() {
        this.f12450s.j0(this);
        this.f12450s.k0(this);
        this.f12450s.l0(this.f12431C);
        h();
    }

    public final void j(Canvas canvas) {
        int i8 = this.f12449r;
        int i9 = this.f12440i;
        int i10 = this.f12446o;
        int i11 = this.f12445n;
        this.f12438g.setBounds(0, 0, i11, i9);
        this.f12439h.setBounds(0, 0, this.f12448q, this.f12441j);
        canvas.translate(0.0f, i8 - i9);
        this.f12439h.draw(canvas);
        canvas.translate(i10 - (i11 / 2), 0.0f);
        this.f12438g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void k(Canvas canvas) {
        int i8 = this.f12448q;
        int i9 = this.f12436e;
        int i10 = i8 - i9;
        int i11 = this.f12443l;
        int i12 = this.f12442k;
        int i13 = i11 - (i12 / 2);
        this.f12434c.setBounds(0, 0, i9, i12);
        this.f12435d.setBounds(0, 0, this.f12437f, this.f12449r);
        if (p()) {
            this.f12435d.draw(canvas);
            canvas.translate(this.f12436e, i13);
            canvas.scale(-1.0f, 1.0f);
            this.f12434c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i10 = this.f12436e;
        } else {
            canvas.translate(i10, 0.0f);
            this.f12435d.draw(canvas);
            canvas.translate(0.0f, i13);
            this.f12434c.draw(canvas);
        }
        canvas.translate(-i10, -i13);
    }

    public final int[] l() {
        int[] iArr = this.f12456y;
        int i8 = this.f12433b;
        iArr[0] = i8;
        iArr[1] = this.f12448q - i8;
        return iArr;
    }

    public final int[] m() {
        int[] iArr = this.f12455x;
        int i8 = this.f12433b;
        iArr[0] = i8;
        iArr[1] = this.f12449r - i8;
        return iArr;
    }

    public void n(int i8) {
        int i9 = this.f12429A;
        if (i9 == 1) {
            this.f12457z.cancel();
        } else if (i9 != 2) {
            return;
        }
        this.f12429A = 3;
        ValueAnimator valueAnimator = this.f12457z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f12457z.setDuration(i8);
        this.f12457z.start();
    }

    public final void o(float f8) {
        int[] iArrL = l();
        float fMax = Math.max(iArrL[0], Math.min(iArrL[1], f8));
        if (Math.abs(this.f12446o - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f12447p, fMax, iArrL, this.f12450s.computeHorizontalScrollRange(), this.f12450s.computeHorizontalScrollOffset(), this.f12448q);
        if (iU != 0) {
            this.f12450s.scrollBy(iU, 0);
        }
        this.f12447p = fMax;
    }

    public final boolean p() {
        return D.q(this.f12450s) == 1;
    }

    public boolean q(float f8, float f9) {
        if (f9 >= this.f12449r - this.f12440i) {
            int i8 = this.f12446o;
            int i9 = this.f12445n;
            if (f8 >= i8 - (i9 / 2) && f8 <= i8 + (i9 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean r(float f8, float f9) {
        if (!p() ? f8 >= this.f12448q - this.f12436e : f8 <= this.f12436e / 2) {
            int i8 = this.f12443l;
            int i9 = this.f12442k;
            if (f9 >= i8 - (i9 / 2) && f9 <= i8 + (i9 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void s() {
        this.f12450s.invalidate();
    }

    public final void t(int i8) {
        h();
        this.f12450s.postDelayed(this.f12430B, i8);
    }

    public final int u(float f8, float f9, int[] iArr, int i8, int i9, int i10) {
        int i11 = iArr[1] - iArr[0];
        if (i11 == 0) {
            return 0;
        }
        int i12 = i8 - i10;
        int i13 = (int) (((f9 - f8) / i11) * i12);
        int i14 = i9 + i13;
        if (i14 >= i12 || i14 < 0) {
            return 0;
        }
        return i13;
    }

    public void v(int i8) {
        int i9;
        if (i8 == 2 && this.f12453v != 2) {
            this.f12434c.setState(f12427D);
            h();
        }
        if (i8 == 0) {
            s();
        } else {
            x();
        }
        if (this.f12453v != 2 || i8 == 2) {
            i9 = i8 == 1 ? 1500 : 1200;
            this.f12453v = i8;
        }
        this.f12434c.setState(f12428E);
        t(i9);
        this.f12453v = i8;
    }

    public final void w() {
        this.f12450s.c(this);
        this.f12450s.e(this);
        this.f12450s.f(this.f12431C);
    }

    public void x() {
        int i8 = this.f12429A;
        if (i8 != 0) {
            if (i8 != 3) {
                return;
            } else {
                this.f12457z.cancel();
            }
        }
        this.f12429A = 1;
        ValueAnimator valueAnimator = this.f12457z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f12457z.setDuration(500L);
        this.f12457z.setStartDelay(0L);
        this.f12457z.start();
    }

    public final void y(float f8) {
        int[] iArrM = m();
        float fMax = Math.max(iArrM[0], Math.min(iArrM[1], f8));
        if (Math.abs(this.f12443l - fMax) < 2.0f) {
            return;
        }
        int iU = u(this.f12444m, fMax, iArrM, this.f12450s.computeVerticalScrollRange(), this.f12450s.computeVerticalScrollOffset(), this.f12449r);
        if (iU != 0) {
            this.f12450s.scrollBy(0, iU);
        }
        this.f12444m = fMax;
    }
}
