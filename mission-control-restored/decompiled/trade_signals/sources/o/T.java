package o;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public class T implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static T f21782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static T f21783l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f21785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f21787d = new Runnable() { // from class: o.Q
        @Override // java.lang.Runnable
        public final void run() {
            this.f21780a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f21788e = new Runnable() { // from class: o.S
        @Override // java.lang.Runnable
        public final void run() {
            this.f21781a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f21791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21793j;

    public T(View view, CharSequence charSequence) {
        this.f21784a = view;
        this.f21785b = charSequence;
        this.f21786c = T.H.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void g(T t8) {
        T t9 = f21782k;
        if (t9 != null) {
            t9.b();
        }
        f21782k = t8;
        if (t8 != null) {
            t8.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        T t8 = f21782k;
        if (t8 != null && t8.f21784a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new T(view, charSequence);
            return;
        }
        T t9 = f21783l;
        if (t9 != null && t9.f21784a == view) {
            t9.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void b() {
        this.f21784a.removeCallbacks(this.f21787d);
    }

    public final void c() {
        this.f21793j = true;
    }

    public void d() {
        if (f21783l == this) {
            f21783l = null;
            U u8 = this.f21791h;
            if (u8 != null) {
                u8.c();
                this.f21791h = null;
                c();
                this.f21784a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f21782k == this) {
            g(null);
        }
        this.f21784a.removeCallbacks(this.f21788e);
    }

    public final /* synthetic */ void e() {
        i(false);
    }

    public final void f() {
        this.f21784a.postDelayed(this.f21787d, ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z7) {
        long longPressTimeout;
        long j8;
        long j9;
        if (this.f21784a.isAttachedToWindow()) {
            g(null);
            T t8 = f21783l;
            if (t8 != null) {
                t8.d();
            }
            f21783l = this;
            this.f21792i = z7;
            U u8 = new U(this.f21784a.getContext());
            this.f21791h = u8;
            u8.e(this.f21784a, this.f21789f, this.f21790g, this.f21792i, this.f21785b);
            this.f21784a.addOnAttachStateChangeListener(this);
            if (this.f21792i) {
                j9 = 2500;
            } else {
                if ((T.D.w(this.f21784a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j8 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j8 = 15000;
                }
                j9 = j8 - longPressTimeout;
            }
            this.f21784a.removeCallbacks(this.f21788e);
            this.f21784a.postDelayed(this.f21788e, j9);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x8 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f21793j && Math.abs(x8 - this.f21789f) <= this.f21786c && Math.abs(y7 - this.f21790g) <= this.f21786c) {
            return false;
        }
        this.f21789f = x8;
        this.f21790g = y7;
        this.f21793j = false;
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f21791h != null && this.f21792i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f21784a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f21784a.isEnabled() && this.f21791h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f21789f = view.getWidth() / 2;
        this.f21790g = view.getHeight() / 2;
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
