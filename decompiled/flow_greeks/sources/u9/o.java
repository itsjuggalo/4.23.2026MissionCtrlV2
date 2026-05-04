package u9;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f22477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f22478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f22479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22480g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f22485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f22486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f22487n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o.this.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f22489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f22490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f22491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f22492d;

        public b(float f10, float f11, float f12, float f13) {
            this.f22489a = f10;
            this.f22490b = f11;
            this.f22491c = f12;
            this.f22492d = f13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = this.f22489a + (valueAnimator.getAnimatedFraction() * this.f22490b);
            float animatedFraction2 = this.f22491c + (valueAnimator.getAnimatedFraction() * this.f22492d);
            o.this.i(animatedFraction);
            o.this.h(animatedFraction2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f22494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22495b;

        public c(ViewGroup.LayoutParams layoutParams, int i10) {
            this.f22494a = layoutParams;
            this.f22495b = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o.this.f22479f.b(o.this.f22478e, o.this.f22485l);
            o.this.f22478e.setAlpha(1.0f);
            o.this.f22478e.setTranslationX(0.0f);
            this.f22494a.height = this.f22495b;
            o.this.f22478e.setLayoutParams(this.f22494a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f22497a;

        public d(ViewGroup.LayoutParams layoutParams) {
            this.f22497a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f22497a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            o.this.f22478e.setLayoutParams(this.f22497a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        boolean a(Object obj);

        void b(View view, Object obj);
    }

    public o(View view, Object obj, e eVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f22474a = viewConfiguration.getScaledTouchSlop();
        this.f22475b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f22476c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f22477d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f22478e = view;
        this.f22485l = obj;
        this.f22479f = eVar;
    }

    public final void e(float f10, float f11, AnimatorListenerAdapter animatorListenerAdapter) {
        float f12 = f();
        float f13 = f10 - f12;
        float alpha = this.f22478e.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.f22477d);
        valueAnimatorOfFloat.addUpdateListener(new b(f12, f13, alpha, f11 - alpha));
        if (animatorListenerAdapter != null) {
            valueAnimatorOfFloat.addListener(animatorListenerAdapter);
        }
        valueAnimatorOfFloat.start();
    }

    public float f() {
        return this.f22478e.getTranslationX();
    }

    public final void g() {
        ViewGroup.LayoutParams layoutParams = this.f22478e.getLayoutParams();
        int height = this.f22478e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f22477d);
        duration.addListener(new c(layoutParams, height));
        duration.addUpdateListener(new d(layoutParams));
        duration.start();
    }

    public void h(float f10) {
        this.f22478e.setAlpha(f10);
    }

    public void i(float f10) {
        this.f22478e.setTranslationX(f10);
    }

    public void j() {
        e(0.0f, 1.0f, null);
    }

    public void k(boolean z10) {
        e(z10 ? this.f22480g : -this.f22480g, 0.0f, new a());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        motionEvent.offsetLocation(this.f22487n, 0.0f);
        if (this.f22480g < 2) {
            this.f22480g = this.f22478e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f22481h = motionEvent.getRawX();
            this.f22482i = motionEvent.getRawY();
            if (this.f22479f.a(this.f22485l)) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.f22486m = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
            }
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.f22486m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f22481h;
                    float rawY = motionEvent.getRawY() - this.f22482i;
                    if (Math.abs(rawX) > this.f22474a && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                        this.f22483j = true;
                        this.f22484k = rawX > 0.0f ? this.f22474a : -this.f22474a;
                        this.f22478e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f22478e.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (this.f22483j) {
                        this.f22487n = rawX;
                        i(rawX - this.f22484k);
                        h(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.f22480g))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.f22486m != null) {
                j();
                this.f22486m.recycle();
                this.f22486m = null;
                this.f22487n = 0.0f;
                this.f22481h = 0.0f;
                this.f22482i = 0.0f;
                this.f22483j = false;
            }
        } else if (this.f22486m != null) {
            float rawX2 = motionEvent.getRawX() - this.f22481h;
            this.f22486m.addMovement(motionEvent);
            this.f22486m.computeCurrentVelocity(1000);
            float xVelocity = this.f22486m.getXVelocity();
            float fAbs = Math.abs(xVelocity);
            float fAbs2 = Math.abs(this.f22486m.getYVelocity());
            if (Math.abs(rawX2) > this.f22480g / 2 && this.f22483j) {
                z10 = rawX2 > 0.0f;
            } else if (this.f22475b > fAbs || fAbs > this.f22476c || fAbs2 >= fAbs || fAbs2 >= fAbs || !this.f22483j) {
                z10 = false;
                z = false;
            } else {
                z = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z10 = this.f22486m.getXVelocity() > 0.0f;
            }
            if (z) {
                k(z10);
            } else if (this.f22483j) {
                j();
            }
            VelocityTracker velocityTracker2 = this.f22486m;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
            }
            this.f22486m = null;
            this.f22487n = 0.0f;
            this.f22481h = 0.0f;
            this.f22482i = 0.0f;
            this.f22483j = false;
        }
        return false;
    }
}
