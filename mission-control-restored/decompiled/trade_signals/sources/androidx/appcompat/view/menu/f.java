package androidx.appcompat.view.menu;

import T.AbstractC0927i;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import g.AbstractC1766c;
import n.AbstractC2385b;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f10507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f10511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.a f10514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AbstractC2385b f10515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f10516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f10517l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            f.this.e();
        }
    }

    public f(Context context, d dVar, View view, boolean z7, int i8) {
        this(context, dVar, view, z7, i8, 0);
    }

    public final AbstractC2385b a() {
        Display defaultDisplay = ((WindowManager) this.f10506a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        AbstractC2385b bVar = Math.min(point.x, point.y) >= this.f10506a.getResources().getDimensionPixelSize(AbstractC1766c.f17674a) ? new b(this.f10506a, this.f10511f, this.f10509d, this.f10510e, this.f10508c) : new i(this.f10506a, this.f10507b, this.f10511f, this.f10509d, this.f10510e, this.f10508c);
        bVar.k(this.f10507b);
        bVar.t(this.f10517l);
        bVar.o(this.f10511f);
        bVar.g(this.f10514i);
        bVar.q(this.f10513h);
        bVar.r(this.f10512g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.f10515j.dismiss();
        }
    }

    public AbstractC2385b c() {
        if (this.f10515j == null) {
            this.f10515j = a();
        }
        return this.f10515j;
    }

    public boolean d() {
        AbstractC2385b abstractC2385b = this.f10515j;
        return abstractC2385b != null && abstractC2385b.e();
    }

    public void e() {
        this.f10515j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f10516k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f10511f = view;
    }

    public void g(boolean z7) {
        this.f10513h = z7;
        AbstractC2385b abstractC2385b = this.f10515j;
        if (abstractC2385b != null) {
            abstractC2385b.q(z7);
        }
    }

    public void h(int i8) {
        this.f10512g = i8;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f10516k = onDismissListener;
    }

    public void j(g.a aVar) {
        this.f10514i = aVar;
        AbstractC2385b abstractC2385b = this.f10515j;
        if (abstractC2385b != null) {
            abstractC2385b.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i8, int i9, boolean z7, boolean z8) {
        AbstractC2385b abstractC2385bC = c();
        abstractC2385bC.u(z8);
        if (z7) {
            if ((AbstractC0927i.a(this.f10512g, this.f10511f.getLayoutDirection()) & 7) == 5) {
                i8 -= this.f10511f.getWidth();
            }
            abstractC2385bC.s(i8);
            abstractC2385bC.v(i9);
            int i10 = (int) ((this.f10506a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC2385bC.p(new Rect(i8 - i10, i9 - i10, i8 + i10, i9 + i10));
        }
        abstractC2385bC.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f10511f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i8, int i9) {
        if (d()) {
            return true;
        }
        if (this.f10511f == null) {
            return false;
        }
        l(i8, i9, true, true);
        return true;
    }

    public f(Context context, d dVar, View view, boolean z7, int i8, int i9) {
        this.f10512g = 8388611;
        this.f10517l = new a();
        this.f10506a = context;
        this.f10507b = dVar;
        this.f10511f = view;
        this.f10508c = z7;
        this.f10509d = i8;
        this.f10510e = i9;
    }
}
