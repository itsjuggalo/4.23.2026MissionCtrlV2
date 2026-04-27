package p;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public class Z implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Z f21310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Z f21311l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f21313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f21315d = new Runnable() { // from class: p.X
        @Override // java.lang.Runnable
        public final void run() {
            this.f21308a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f21316e = new Runnable() { // from class: p.Y
        @Override // java.lang.Runnable
        public final void run() {
            this.f21309a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a0 f21319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21321j;

    public Z(View view, CharSequence charSequence) {
        this.f21312a = view;
        this.f21313b = charSequence;
        this.f21314c = Q.S.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void g(Z z7) {
        Z z8 = f21310k;
        if (z8 != null) {
            z8.b();
        }
        f21310k = z7;
        if (z7 != null) {
            z7.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        Z z7 = f21310k;
        if (z7 != null && z7.f21312a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new Z(view, charSequence);
            return;
        }
        Z z8 = f21311l;
        if (z8 != null && z8.f21312a == view) {
            z8.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f21312a.removeCallbacks(this.f21315d);
    }

    public final void c() {
        this.f21321j = true;
    }

    public void d() {
        if (f21311l == this) {
            f21311l = null;
            a0 a0Var = this.f21319h;
            if (a0Var != null) {
                a0Var.c();
                this.f21319h = null;
                c();
                this.f21312a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f21310k == this) {
            g(null);
        }
        this.f21312a.removeCallbacks(this.f21316e);
    }

    public final /* synthetic */ void e() {
        i(false);
    }

    public final void f() {
        this.f21312a.postDelayed(this.f21315d, ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z7) {
        long longPressTimeout;
        long j7;
        long j8;
        if (Q.N.O(this.f21312a)) {
            g(null);
            Z z8 = f21311l;
            if (z8 != null) {
                z8.d();
            }
            f21311l = this;
            this.f21320i = z7;
            a0 a0Var = new a0(this.f21312a.getContext());
            this.f21319h = a0Var;
            a0Var.e(this.f21312a, this.f21317f, this.f21318g, this.f21320i, this.f21313b);
            this.f21312a.addOnAttachStateChangeListener(this);
            if (this.f21320i) {
                j8 = 2500;
            } else {
                if ((Q.N.I(this.f21312a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = 15000;
                }
                j8 = j7 - longPressTimeout;
            }
            this.f21312a.removeCallbacks(this.f21316e);
            this.f21312a.postDelayed(this.f21316e, j8);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f21321j && Math.abs(x7 - this.f21317f) <= this.f21314c && Math.abs(y7 - this.f21318g) <= this.f21314c) {
            return false;
        }
        this.f21317f = x7;
        this.f21318g = y7;
        this.f21321j = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f21319h != null && this.f21320i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f21312a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f21312a.isEnabled() && this.f21319h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f21317f = view.getWidth() / 2;
        this.f21318g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
