package o;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static q0 f17344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static q0 f17345l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f17347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f17349d = new Runnable() { // from class: o.o0
        @Override // java.lang.Runnable
        public final void run() {
            this.f17329a.h(false);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f17350e = new Runnable() { // from class: o.p0
        @Override // java.lang.Runnable
        public final void run() {
            this.f17343a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r0 f17353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17355j;

    public q0(View view, CharSequence charSequence) {
        this.f17346a = view;
        this.f17347b = charSequence;
        this.f17348c = t0.f0.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void f(q0 q0Var) {
        q0 q0Var2 = f17344k;
        if (q0Var2 != null) {
            q0Var2.b();
        }
        f17344k = q0Var;
        if (q0Var != null) {
            q0Var.e();
        }
    }

    public static void g(View view, CharSequence charSequence) {
        q0 q0Var = f17344k;
        if (q0Var != null && q0Var.f17346a == view) {
            f(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new q0(view, charSequence);
            return;
        }
        q0 q0Var2 = f17345l;
        if (q0Var2 != null && q0Var2.f17346a == view) {
            q0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f17346a.removeCallbacks(this.f17349d);
    }

    public final void c() {
        this.f17355j = true;
    }

    public void d() {
        if (f17345l == this) {
            f17345l = null;
            r0 r0Var = this.f17353h;
            if (r0Var != null) {
                r0Var.c();
                this.f17353h = null;
                c();
                this.f17346a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f17344k == this) {
            f(null);
        }
        this.f17346a.removeCallbacks(this.f17350e);
    }

    public final void e() {
        this.f17346a.postDelayed(this.f17349d, ViewConfiguration.getLongPressTimeout());
    }

    public void h(boolean z10) {
        long longPressTimeout;
        long j10;
        long j11;
        if (this.f17346a.isAttachedToWindow()) {
            f(null);
            q0 q0Var = f17345l;
            if (q0Var != null) {
                q0Var.d();
            }
            f17345l = this;
            this.f17354i = z10;
            r0 r0Var = new r0(this.f17346a.getContext());
            this.f17353h = r0Var;
            r0Var.e(this.f17346a, this.f17351f, this.f17352g, this.f17354i, this.f17347b);
            this.f17346a.addOnAttachStateChangeListener(this);
            if (this.f17354i) {
                j11 = 2500;
            } else {
                if ((t0.c0.w(this.f17346a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 15000;
                }
                j11 = j10 - longPressTimeout;
            }
            this.f17346a.removeCallbacks(this.f17350e);
            this.f17346a.postDelayed(this.f17350e, j11);
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f17355j && Math.abs(x10 - this.f17351f) <= this.f17348c && Math.abs(y10 - this.f17352g) <= this.f17348c) {
            return false;
        }
        this.f17351f = x10;
        this.f17352g = y10;
        this.f17355j = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f17353h != null && this.f17354i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f17346a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f17346a.isEnabled() && this.f17353h == null && i(motionEvent)) {
            f(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f17351f = view.getWidth() / 2;
        this.f17352g = view.getHeight() / 2;
        h(true);
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
