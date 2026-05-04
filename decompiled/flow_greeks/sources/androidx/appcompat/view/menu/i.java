package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import o.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends n.b implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, g, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f1097v = g.f.f9745j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f1099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f1100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0 f1105i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f1109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f1110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g.a f1111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f1112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1114r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1115s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1117u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1106j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1107k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1116t = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!i.this.e() || i.this.f1105i.m()) {
                return;
            }
            View view = i.this.f1110n;
            if (view == null || !view.isShown()) {
                i.this.dismiss();
            } else {
                i.this.f1105i.show();
            }
        }
    }

    public i(Context context, d dVar, View view, int i10, int i11, boolean z10) {
        this.f1098b = context;
        this.f1099c = dVar;
        this.f1101e = z10;
        this.f1100d = new c(dVar, LayoutInflater.from(context), z10, f1097v);
        this.f1103g = i10;
        this.f1104h = i11;
        Resources resources = context.getResources();
        this.f1102f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.c.f9684b));
        this.f1109m = view;
        this.f1105i = new b0(context, null, i10, i11);
        dVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z10) {
        if (dVar != this.f1099c) {
            return;
        }
        dismiss();
        g.a aVar = this.f1111o;
        if (aVar != null) {
            aVar.a(dVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z10) {
        this.f1114r = false;
        c cVar = this.f1100d;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // n.c
    public void dismiss() {
        if (e()) {
            this.f1105i.dismiss();
        }
    }

    @Override // n.c
    public boolean e() {
        return !this.f1113q && this.f1105i.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f1111o = aVar;
    }

    @Override // n.c
    public ListView i() {
        return this.f1105i.i();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        if (jVar.hasVisibleItems()) {
            f fVar = new f(this.f1098b, jVar, this.f1110n, this.f1101e, this.f1103g, this.f1104h);
            fVar.j(this.f1111o);
            fVar.g(n.b.w(jVar));
            fVar.i(this.f1108l);
            this.f1108l = null;
            this.f1099c.d(false);
            int iH = this.f1105i.h();
            int iK = this.f1105i.k();
            if ((Gravity.getAbsoluteGravity(this.f1116t, this.f1109m.getLayoutDirection()) & 7) == 5) {
                iH += this.f1109m.getWidth();
            }
            if (fVar.n(iH, iK)) {
                g.a aVar = this.f1111o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(jVar);
                return true;
            }
        }
        return false;
    }

    @Override // n.b
    public void o(View view) {
        this.f1109m = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1113q = true;
        this.f1099c.close();
        ViewTreeObserver viewTreeObserver = this.f1112p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1112p = this.f1110n.getViewTreeObserver();
            }
            this.f1112p.removeGlobalOnLayoutListener(this.f1106j);
            this.f1112p = null;
        }
        this.f1110n.removeOnAttachStateChangeListener(this.f1107k);
        PopupWindow.OnDismissListener onDismissListener = this.f1108l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // n.b
    public void q(boolean z10) {
        this.f1100d.d(z10);
    }

    @Override // n.b
    public void r(int i10) {
        this.f1116t = i10;
    }

    @Override // n.b
    public void s(int i10) {
        this.f1105i.u(i10);
    }

    @Override // n.c
    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // n.b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f1108l = onDismissListener;
    }

    @Override // n.b
    public void u(boolean z10) {
        this.f1117u = z10;
    }

    @Override // n.b
    public void v(int i10) {
        this.f1105i.B(i10);
    }

    public final boolean y() {
        View view;
        if (e()) {
            return true;
        }
        if (this.f1113q || (view = this.f1109m) == null) {
            return false;
        }
        this.f1110n = view;
        this.f1105i.x(this);
        this.f1105i.y(this);
        this.f1105i.w(true);
        View view2 = this.f1110n;
        boolean z10 = this.f1112p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1112p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1106j);
        }
        view2.addOnAttachStateChangeListener(this.f1107k);
        this.f1105i.p(view2);
        this.f1105i.s(this.f1116t);
        if (!this.f1114r) {
            this.f1115s = n.b.n(this.f1100d, null, this.f1098b, this.f1102f);
            this.f1114r = true;
        }
        this.f1105i.r(this.f1115s);
        this.f1105i.v(2);
        this.f1105i.t(m());
        this.f1105i.show();
        ListView listViewI = this.f1105i.i();
        listViewI.setOnKeyListener(this);
        if (this.f1117u && this.f1099c.u() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1098b).inflate(g.f.f9744i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1099c.u());
            }
            frameLayout.setEnabled(false);
            listViewI.addHeaderView(frameLayout, null, false);
        }
        this.f1105i.o(this.f1100d);
        this.f1105i.show();
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = i.this.f1112p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    i.this.f1112p = view.getViewTreeObserver();
                }
                i iVar = i.this;
                iVar.f1112p.removeGlobalOnLayoutListener(iVar.f1106j);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    @Override // n.b
    public void k(d dVar) {
    }
}
