package androidx.appcompat.view.menu;

import Q.N;
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
import h.AbstractC1658c;
import h.AbstractC1661f;
import o.AbstractC2280b;
import p.I;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC2280b implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, g, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6626v = AbstractC1661f.f14456j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f6628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f6629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final I f6634i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f6638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g.a f6640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f6641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6644s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6646u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f6635j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f6636k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6645t = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!i.this.f() || i.this.f6634i.n()) {
                return;
            }
            View view = i.this.f6639n;
            if (view == null || !view.isShown()) {
                i.this.dismiss();
            } else {
                i.this.f6634i.a();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = i.this.f6641p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    i.this.f6641p = view.getViewTreeObserver();
                }
                i iVar = i.this;
                iVar.f6641p.removeGlobalOnLayoutListener(iVar.f6635j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public i(Context context, d dVar, View view, int i7, int i8, boolean z7) {
        this.f6627b = context;
        this.f6628c = dVar;
        this.f6630e = z7;
        this.f6629d = new c(dVar, LayoutInflater.from(context), z7, f6626v);
        this.f6632g = i7;
        this.f6633h = i8;
        Resources resources = context.getResources();
        this.f6631f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1658c.f14362b));
        this.f6638m = view;
        this.f6634i = new I(context, null, i7, i8);
        dVar.b(this, context);
    }

    @Override // o.InterfaceC2281c
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(d dVar, boolean z7) {
        if (dVar != this.f6628c) {
            return;
        }
        dismiss();
        g.a aVar = this.f6640o;
        if (aVar != null) {
            aVar.b(dVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void c(boolean z7) {
        this.f6643r = false;
        c cVar = this.f6629d;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d() {
        return false;
    }

    @Override // o.InterfaceC2281c
    public void dismiss() {
        if (f()) {
            this.f6634i.dismiss();
        }
    }

    @Override // o.InterfaceC2281c
    public boolean f() {
        return !this.f6642q && this.f6634i.f();
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(g.a aVar) {
        this.f6640o = aVar;
    }

    @Override // o.InterfaceC2281c
    public ListView j() {
        return this.f6634i.j();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean k(j jVar) {
        if (jVar.hasVisibleItems()) {
            f fVar = new f(this.f6627b, jVar, this.f6639n, this.f6630e, this.f6632g, this.f6633h);
            fVar.j(this.f6640o);
            fVar.g(AbstractC2280b.x(jVar));
            fVar.i(this.f6637l);
            this.f6637l = null;
            this.f6628c.d(false);
            int i7 = this.f6634i.i();
            int iL = this.f6634i.l();
            if ((Gravity.getAbsoluteGravity(this.f6645t, N.z(this.f6638m)) & 7) == 5) {
                i7 += this.f6638m.getWidth();
            }
            if (fVar.n(i7, iL)) {
                g.a aVar = this.f6640o;
                if (aVar == null) {
                    return true;
                }
                aVar.c(jVar);
                return true;
            }
        }
        return false;
    }

    @Override // o.AbstractC2280b
    public void l(d dVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f6642q = true;
        this.f6628c.close();
        ViewTreeObserver viewTreeObserver = this.f6641p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f6641p = this.f6639n.getViewTreeObserver();
            }
            this.f6641p.removeGlobalOnLayoutListener(this.f6635j);
            this.f6641p = null;
        }
        this.f6639n.removeOnAttachStateChangeListener(this.f6636k);
        PopupWindow.OnDismissListener onDismissListener = this.f6637l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i7, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i7 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // o.AbstractC2280b
    public void p(View view) {
        this.f6638m = view;
    }

    @Override // o.AbstractC2280b
    public void r(boolean z7) {
        this.f6629d.d(z7);
    }

    @Override // o.AbstractC2280b
    public void s(int i7) {
        this.f6645t = i7;
    }

    @Override // o.AbstractC2280b
    public void t(int i7) {
        this.f6634i.v(i7);
    }

    @Override // o.AbstractC2280b
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f6637l = onDismissListener;
    }

    @Override // o.AbstractC2280b
    public void v(boolean z7) {
        this.f6646u = z7;
    }

    @Override // o.AbstractC2280b
    public void w(int i7) {
        this.f6634i.C(i7);
    }

    public final boolean z() {
        View view;
        if (f()) {
            return true;
        }
        if (this.f6642q || (view = this.f6638m) == null) {
            return false;
        }
        this.f6639n = view;
        this.f6634i.y(this);
        this.f6634i.z(this);
        this.f6634i.x(true);
        View view2 = this.f6639n;
        boolean z7 = this.f6641p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f6641p = viewTreeObserver;
        if (z7) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f6635j);
        }
        view2.addOnAttachStateChangeListener(this.f6636k);
        this.f6634i.q(view2);
        this.f6634i.t(this.f6645t);
        if (!this.f6643r) {
            this.f6644s = AbstractC2280b.o(this.f6629d, null, this.f6627b, this.f6631f);
            this.f6643r = true;
        }
        this.f6634i.s(this.f6644s);
        this.f6634i.w(2);
        this.f6634i.u(n());
        this.f6634i.a();
        ListView listViewJ = this.f6634i.j();
        listViewJ.setOnKeyListener(this);
        if (this.f6646u && this.f6628c.u() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f6627b).inflate(AbstractC1661f.f14455i, (ViewGroup) listViewJ, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f6628c.u());
            }
            frameLayout.setEnabled(false);
            listViewJ.addHeaderView(frameLayout, null, false);
        }
        this.f6634i.p(this.f6629d);
        this.f6634i.a();
        return true;
    }
}
