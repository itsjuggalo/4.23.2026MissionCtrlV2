package androidx.appcompat.view.menu;

import H.AbstractC0275i;
import H.E;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import g.AbstractC1250c;
import n.AbstractC1611b;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f6465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.a f6472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AbstractC1611b f6473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f6475l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            f.this.e();
        }
    }

    public f(Context context, d dVar, View view, boolean z4, int i4) {
        this(context, dVar, view, z4, i4, 0);
    }

    public final AbstractC1611b a() {
        Display defaultDisplay = ((WindowManager) this.f6464a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        AbstractC1611b bVar = Math.min(point.x, point.y) >= this.f6464a.getResources().getDimensionPixelSize(AbstractC1250c.f11568a) ? new b(this.f6464a, this.f6469f, this.f6467d, this.f6468e, this.f6466c) : new i(this.f6464a, this.f6465b, this.f6469f, this.f6467d, this.f6468e, this.f6466c);
        bVar.k(this.f6465b);
        bVar.t(this.f6475l);
        bVar.o(this.f6469f);
        bVar.g(this.f6472i);
        bVar.q(this.f6471h);
        bVar.r(this.f6470g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.f6473j.dismiss();
        }
    }

    public AbstractC1611b c() {
        if (this.f6473j == null) {
            this.f6473j = a();
        }
        return this.f6473j;
    }

    public boolean d() {
        AbstractC1611b abstractC1611b = this.f6473j;
        return abstractC1611b != null && abstractC1611b.e();
    }

    public void e() {
        this.f6473j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f6474k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f6469f = view;
    }

    public void g(boolean z4) {
        this.f6471h = z4;
        AbstractC1611b abstractC1611b = this.f6473j;
        if (abstractC1611b != null) {
            abstractC1611b.q(z4);
        }
    }

    public void h(int i4) {
        this.f6470g = i4;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f6474k = onDismissListener;
    }

    public void j(g.a aVar) {
        this.f6472i = aVar;
        AbstractC1611b abstractC1611b = this.f6473j;
        if (abstractC1611b != null) {
            abstractC1611b.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i4, int i5, boolean z4, boolean z5) {
        AbstractC1611b abstractC1611bC = c();
        abstractC1611bC.u(z5);
        if (z4) {
            if ((AbstractC0275i.a(this.f6470g, E.n(this.f6469f)) & 7) == 5) {
                i4 -= this.f6469f.getWidth();
            }
            abstractC1611bC.s(i4);
            abstractC1611bC.v(i5);
            int i6 = (int) ((this.f6464a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC1611bC.p(new Rect(i4 - i6, i5 - i6, i4 + i6, i5 + i6));
        }
        abstractC1611bC.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f6469f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i4, int i5) {
        if (d()) {
            return true;
        }
        if (this.f6469f == null) {
            return false;
        }
        l(i4, i5, true, true);
        return true;
    }

    public f(Context context, d dVar, View view, boolean z4, int i4, int i5) {
        this.f6470g = 8388611;
        this.f6475l = new a();
        this.f6464a = context;
        this.f6465b = dVar;
        this.f6469f = view;
        this.f6466c = z4;
        this.f6467d = i4;
        this.f6468e = i5;
    }
}
