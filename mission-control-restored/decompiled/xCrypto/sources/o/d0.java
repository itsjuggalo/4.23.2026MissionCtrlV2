package o;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static d0 f13817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static d0 f13818l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f13820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13821c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f13822e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f13823f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e0 f13826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13827j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.g(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.c();
        }
    }

    public d0(View view, CharSequence charSequence) {
        this.f13819a = view;
        this.f13820b = charSequence;
        this.f13821c = H.I.g(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void e(d0 d0Var) {
        d0 d0Var2 = f13817k;
        if (d0Var2 != null) {
            d0Var2.a();
        }
        f13817k = d0Var;
        if (d0Var != null) {
            d0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        d0 d0Var = f13817k;
        if (d0Var != null && d0Var.f13819a == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new d0(view, charSequence);
            return;
        }
        d0 d0Var2 = f13818l;
        if (d0Var2 != null && d0Var2.f13819a == view) {
            d0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void a() {
        this.f13819a.removeCallbacks(this.f13822e);
    }

    public final void b() {
        this.f13824g = Integer.MAX_VALUE;
        this.f13825h = Integer.MAX_VALUE;
    }

    public void c() {
        if (f13818l == this) {
            f13818l = null;
            e0 e0Var = this.f13826i;
            if (e0Var != null) {
                e0Var.c();
                this.f13826i = null;
                b();
                this.f13819a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f13817k == this) {
            e(null);
        }
        this.f13819a.removeCallbacks(this.f13823f);
    }

    public final void d() {
        this.f13819a.postDelayed(this.f13822e, ViewConfiguration.getLongPressTimeout());
    }

    public void g(boolean z4) {
        long longPressTimeout;
        long j4;
        long j5;
        if (H.E.w(this.f13819a)) {
            e(null);
            d0 d0Var = f13818l;
            if (d0Var != null) {
                d0Var.c();
            }
            f13818l = this;
            this.f13827j = z4;
            e0 e0Var = new e0(this.f13819a.getContext());
            this.f13826i = e0Var;
            e0Var.e(this.f13819a, this.f13824g, this.f13825h, this.f13827j, this.f13820b);
            this.f13819a.addOnAttachStateChangeListener(this);
            if (this.f13827j) {
                j5 = 2500;
            } else {
                if ((H.E.t(this.f13819a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 15000;
                }
                j5 = j4 - longPressTimeout;
            }
            this.f13819a.removeCallbacks(this.f13823f);
            this.f13819a.postDelayed(this.f13823f, j5);
        }
    }

    public final boolean h(MotionEvent motionEvent) {
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (Math.abs(x4 - this.f13824g) <= this.f13821c && Math.abs(y4 - this.f13825h) <= this.f13821c) {
            return false;
        }
        this.f13824g = x4;
        this.f13825h = y4;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f13826i != null && this.f13827j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f13819a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f13819a.isEnabled() && this.f13826i == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f13824g = view.getWidth() / 2;
        this.f13825h = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
