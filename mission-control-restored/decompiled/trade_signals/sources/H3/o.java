package H3;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class o implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f3712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f3713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3714g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f3719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f3720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3721n;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o.this.g();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f3723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f3724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f3725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f3726d;

        public b(float f8, float f9, float f10, float f11) {
            this.f3723a = f8;
            this.f3724b = f9;
            this.f3725c = f10;
            this.f3726d = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = this.f3723a + (valueAnimator.getAnimatedFraction() * this.f3724b);
            float animatedFraction2 = this.f3725c + (valueAnimator.getAnimatedFraction() * this.f3726d);
            o.this.i(animatedFraction);
            o.this.h(animatedFraction2);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f3728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3729b;

        public c(ViewGroup.LayoutParams layoutParams, int i8) {
            this.f3728a = layoutParams;
            this.f3729b = i8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o.this.f3713f.b(o.this.f3712e, o.this.f3719l);
            o.this.f3712e.setAlpha(1.0f);
            o.this.f3712e.setTranslationX(0.0f);
            this.f3728a.height = this.f3729b;
            o.this.f3712e.setLayoutParams(this.f3728a);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f3731a;

        public d(ViewGroup.LayoutParams layoutParams) {
            this.f3731a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3731a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            o.this.f3712e.setLayoutParams(this.f3731a);
        }
    }

    public interface e {
        boolean a(Object obj);

        void b(View view, Object obj);
    }

    public o(View view, Object obj, e eVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f3708a = viewConfiguration.getScaledTouchSlop();
        this.f3709b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f3710c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3711d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f3712e = view;
        this.f3719l = obj;
        this.f3713f = eVar;
    }

    public final void e(float f8, float f9, AnimatorListenerAdapter animatorListenerAdapter) {
        float f10 = f();
        float f11 = f8 - f10;
        float alpha = this.f3712e.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.f3711d);
        valueAnimatorOfFloat.addUpdateListener(new b(f10, f11, alpha, f9 - alpha));
        if (animatorListenerAdapter != null) {
            valueAnimatorOfFloat.addListener(animatorListenerAdapter);
        }
        valueAnimatorOfFloat.start();
    }

    public float f() {
        return this.f3712e.getTranslationX();
    }

    public final void g() {
        ViewGroup.LayoutParams layoutParams = this.f3712e.getLayoutParams();
        int height = this.f3712e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f3711d);
        duration.addListener(new c(layoutParams, height));
        duration.addUpdateListener(new d(layoutParams));
        duration.start();
    }

    public void h(float f8) {
        this.f3712e.setAlpha(f8);
    }

    public void i(float f8) {
        this.f3712e.setTranslationX(f8);
    }

    public void j() {
        e(0.0f, 1.0f, null);
    }

    public void k(boolean z7) {
        e(z7 ? this.f3714g : -this.f3714g, 0.0f, new a());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        VelocityTracker velocityTracker;
        motionEvent.offsetLocation(this.f3721n, 0.0f);
        if (this.f3714g < 2) {
            this.f3714g = this.f3712e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3715h = motionEvent.getRawX();
            this.f3716i = motionEvent.getRawY();
            if (this.f3713f.a(this.f3719l)) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.f3720m = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
            }
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.f3720m;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f3715h;
                    float rawY = motionEvent.getRawY() - this.f3716i;
                    if (Math.abs(rawX) > this.f3708a && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                        this.f3717j = true;
                        this.f3718k = rawX > 0.0f ? this.f3708a : -this.f3708a;
                        this.f3712e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f3712e.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (this.f3717j) {
                        this.f3721n = rawX;
                        i(rawX - this.f3718k);
                        h(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.f3714g))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.f3720m != null) {
                j();
                velocityTracker = this.f3720m;
                velocityTracker.recycle();
            }
            return false;
        }
        if (this.f3720m != null) {
            float rawX2 = motionEvent.getRawX() - this.f3715h;
            this.f3720m.addMovement(motionEvent);
            this.f3720m.computeCurrentVelocity(1000);
            float xVelocity = this.f3720m.getXVelocity();
            float fAbs = Math.abs(xVelocity);
            float fAbs2 = Math.abs(this.f3720m.getYVelocity());
            if (Math.abs(rawX2) > this.f3714g / 2 && this.f3717j) {
                z7 = rawX2 > 0.0f;
            } else if (this.f3709b > fAbs || fAbs > this.f3710c || fAbs2 >= fAbs || fAbs2 >= fAbs || !this.f3717j) {
                z7 = false;
                z = false;
            } else {
                z = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z7 = this.f3720m.getXVelocity() > 0.0f;
            }
            if (z) {
                k(z7);
            } else if (this.f3717j) {
                j();
            }
            velocityTracker = this.f3720m;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
        }
        return false;
        this.f3720m = null;
        this.f3721n = 0.0f;
        this.f3715h = 0.0f;
        this.f3716i = 0.0f;
        this.f3717j = false;
        return false;
    }
}
