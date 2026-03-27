package androidx.appcompat.view.menu;

import Q.AbstractC0677s;
import Q.N;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import h.AbstractC1658c;
import o.AbstractC2280b;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f6614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.a f6621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AbstractC2280b f6622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f6624l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            f.this.e();
        }
    }

    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public f(Context context, d dVar, View view, boolean z7, int i7) {
        this(context, dVar, view, z7, i7, 0);
    }

    public final AbstractC2280b a() {
        Display defaultDisplay = ((WindowManager) this.f6613a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        AbstractC2280b bVar = Math.min(point.x, point.y) >= this.f6613a.getResources().getDimensionPixelSize(AbstractC1658c.f14361a) ? new androidx.appcompat.view.menu.b(this.f6613a, this.f6618f, this.f6616d, this.f6617e, this.f6615c) : new i(this.f6613a, this.f6614b, this.f6618f, this.f6616d, this.f6617e, this.f6615c);
        bVar.l(this.f6614b);
        bVar.u(this.f6624l);
        bVar.p(this.f6618f);
        bVar.h(this.f6621i);
        bVar.r(this.f6620h);
        bVar.s(this.f6619g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.f6622j.dismiss();
        }
    }

    public AbstractC2280b c() {
        if (this.f6622j == null) {
            this.f6622j = a();
        }
        return this.f6622j;
    }

    public boolean d() {
        AbstractC2280b abstractC2280b = this.f6622j;
        return abstractC2280b != null && abstractC2280b.f();
    }

    public void e() {
        this.f6622j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f6623k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f6618f = view;
    }

    public void g(boolean z7) {
        this.f6620h = z7;
        AbstractC2280b abstractC2280b = this.f6622j;
        if (abstractC2280b != null) {
            abstractC2280b.r(z7);
        }
    }

    public void h(int i7) {
        this.f6619g = i7;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f6623k = onDismissListener;
    }

    public void j(g.a aVar) {
        this.f6621i = aVar;
        AbstractC2280b abstractC2280b = this.f6622j;
        if (abstractC2280b != null) {
            abstractC2280b.h(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i7, int i8, boolean z7, boolean z8) {
        AbstractC2280b abstractC2280bC = c();
        abstractC2280bC.v(z8);
        if (z7) {
            if ((AbstractC0677s.b(this.f6619g, N.z(this.f6618f)) & 7) == 5) {
                i7 -= this.f6618f.getWidth();
            }
            abstractC2280bC.t(i7);
            abstractC2280bC.w(i8);
            int i9 = (int) ((this.f6613a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC2280bC.q(new Rect(i7 - i9, i8 - i9, i7 + i9, i8 + i9));
        }
        abstractC2280bC.a();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f6618f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i7, int i8) {
        if (d()) {
            return true;
        }
        if (this.f6618f == null) {
            return false;
        }
        l(i7, i8, true, true);
        return true;
    }

    public f(Context context, d dVar, View view, boolean z7, int i7, int i8) {
        this.f6619g = 8388611;
        this.f6624l = new a();
        this.f6613a = context;
        this.f6614b = dVar;
        this.f6618f = view;
        this.f6615c = z7;
        this.f6616d = i7;
        this.f6617e = i8;
    }
}
