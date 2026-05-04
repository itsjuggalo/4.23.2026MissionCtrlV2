package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f1089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.a f1092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n.b f1093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f1095l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            f.this.e();
        }
    }

    public f(Context context, d dVar, View view, boolean z10, int i10) {
        this(context, dVar, view, z10, i10, 0);
    }

    public final n.b a() {
        Display defaultDisplay = ((WindowManager) this.f1084a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        n.b bVar = Math.min(point.x, point.y) >= this.f1084a.getResources().getDimensionPixelSize(g.c.f9683a) ? new b(this.f1084a, this.f1089f, this.f1087d, this.f1088e, this.f1086c) : new i(this.f1084a, this.f1085b, this.f1089f, this.f1087d, this.f1088e, this.f1086c);
        bVar.k(this.f1085b);
        bVar.t(this.f1095l);
        bVar.o(this.f1089f);
        bVar.g(this.f1092i);
        bVar.q(this.f1091h);
        bVar.r(this.f1090g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.f1093j.dismiss();
        }
    }

    public n.b c() {
        if (this.f1093j == null) {
            this.f1093j = a();
        }
        return this.f1093j;
    }

    public boolean d() {
        n.b bVar = this.f1093j;
        return bVar != null && bVar.e();
    }

    public void e() {
        this.f1093j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1094k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f1089f = view;
    }

    public void g(boolean z10) {
        this.f1091h = z10;
        n.b bVar = this.f1093j;
        if (bVar != null) {
            bVar.q(z10);
        }
    }

    public void h(int i10) {
        this.f1090g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1094k = onDismissListener;
    }

    public void j(g.a aVar) {
        this.f1092i = aVar;
        n.b bVar = this.f1093j;
        if (bVar != null) {
            bVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i10, int i11, boolean z10, boolean z11) {
        n.b bVarC = c();
        bVarC.u(z11);
        if (z10) {
            if ((t0.h.a(this.f1090g, this.f1089f.getLayoutDirection()) & 7) == 5) {
                i10 -= this.f1089f.getWidth();
            }
            bVarC.s(i10);
            bVarC.v(i11);
            int i12 = (int) ((this.f1084a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            bVarC.p(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        bVarC.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1089f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f1089f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public f(Context context, d dVar, View view, boolean z10, int i10, int i11) {
        this.f1090g = 8388611;
        this.f1095l = new a();
        this.f1084a = context;
        this.f1085b = dVar;
        this.f1089f = view;
        this.f1086c = z10;
        this.f1087d = i10;
        this.f1088e = i11;
    }
}
