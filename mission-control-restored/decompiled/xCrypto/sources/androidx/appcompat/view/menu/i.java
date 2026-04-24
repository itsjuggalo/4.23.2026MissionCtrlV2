package androidx.appcompat.view.menu;

import H.E;
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
import g.AbstractC1250c;
import g.AbstractC1253f;
import n.AbstractC1611b;
import o.P;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC1611b implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, g, View.OnKeyListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6477w = AbstractC1253f.f11661j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f6479c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f6480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f6484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final P f6485j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f6489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g.a f6491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewTreeObserver f6492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6495t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6497v;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f6486k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f6487l = new b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6496u = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!i.this.e() || i.this.f6485j.m()) {
                return;
            }
            View view = i.this.f6490o;
            if (view == null || !view.isShown()) {
                i.this.dismiss();
            } else {
                i.this.f6485j.show();
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
            ViewTreeObserver viewTreeObserver = i.this.f6492q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    i.this.f6492q = view.getViewTreeObserver();
                }
                i iVar = i.this;
                iVar.f6492q.removeGlobalOnLayoutListener(iVar.f6486k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public i(Context context, d dVar, View view, int i4, int i5, boolean z4) {
        this.f6478b = context;
        this.f6479c = dVar;
        this.f6481f = z4;
        this.f6480e = new c(dVar, LayoutInflater.from(context), z4, f6477w);
        this.f6483h = i4;
        this.f6484i = i5;
        Resources resources = context.getResources();
        this.f6482g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1250c.f11569b));
        this.f6489n = view;
        this.f6485j = new P(context, null, i4, i5);
        dVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z4) {
        if (dVar != this.f6479c) {
            return;
        }
        dismiss();
        g.a aVar = this.f6491p;
        if (aVar != null) {
            aVar.a(dVar, z4);
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z4) {
        this.f6494s = false;
        c cVar = this.f6480e;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // n.InterfaceC1612c
    public void dismiss() {
        if (e()) {
            this.f6485j.dismiss();
        }
    }

    @Override // n.InterfaceC1612c
    public boolean e() {
        return !this.f6493r && this.f6485j.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f6491p = aVar;
    }

    @Override // n.InterfaceC1612c
    public ListView i() {
        return this.f6485j.i();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        if (jVar.hasVisibleItems()) {
            f fVar = new f(this.f6478b, jVar, this.f6490o, this.f6481f, this.f6483h, this.f6484i);
            fVar.j(this.f6491p);
            fVar.g(AbstractC1611b.w(jVar));
            fVar.i(this.f6488m);
            this.f6488m = null;
            this.f6479c.d(false);
            int iH = this.f6485j.h();
            int iK = this.f6485j.k();
            if ((Gravity.getAbsoluteGravity(this.f6496u, E.n(this.f6489n)) & 7) == 5) {
                iH += this.f6489n.getWidth();
            }
            if (fVar.n(iH, iK)) {
                g.a aVar = this.f6491p;
                if (aVar == null) {
                    return true;
                }
                aVar.b(jVar);
                return true;
            }
        }
        return false;
    }

    @Override // n.AbstractC1611b
    public void k(d dVar) {
    }

    @Override // n.AbstractC1611b
    public void o(View view) {
        this.f6489n = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f6493r = true;
        this.f6479c.close();
        ViewTreeObserver viewTreeObserver = this.f6492q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f6492q = this.f6490o.getViewTreeObserver();
            }
            this.f6492q.removeGlobalOnLayoutListener(this.f6486k);
            this.f6492q = null;
        }
        this.f6490o.removeOnAttachStateChangeListener(this.f6487l);
        PopupWindow.OnDismissListener onDismissListener = this.f6488m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i4 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // n.AbstractC1611b
    public void q(boolean z4) {
        this.f6480e.d(z4);
    }

    @Override // n.AbstractC1611b
    public void r(int i4) {
        this.f6496u = i4;
    }

    @Override // n.AbstractC1611b
    public void s(int i4) {
        this.f6485j.u(i4);
    }

    @Override // n.InterfaceC1612c
    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // n.AbstractC1611b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f6488m = onDismissListener;
    }

    @Override // n.AbstractC1611b
    public void u(boolean z4) {
        this.f6497v = z4;
    }

    @Override // n.AbstractC1611b
    public void v(int i4) {
        this.f6485j.B(i4);
    }

    public final boolean y() {
        View view;
        if (e()) {
            return true;
        }
        if (this.f6493r || (view = this.f6489n) == null) {
            return false;
        }
        this.f6490o = view;
        this.f6485j.x(this);
        this.f6485j.y(this);
        this.f6485j.w(true);
        View view2 = this.f6490o;
        boolean z4 = this.f6492q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f6492q = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f6486k);
        }
        view2.addOnAttachStateChangeListener(this.f6487l);
        this.f6485j.p(view2);
        this.f6485j.s(this.f6496u);
        if (!this.f6494s) {
            this.f6495t = AbstractC1611b.n(this.f6480e, null, this.f6478b, this.f6482g);
            this.f6494s = true;
        }
        this.f6485j.r(this.f6495t);
        this.f6485j.v(2);
        this.f6485j.t(m());
        this.f6485j.show();
        ListView listViewI = this.f6485j.i();
        listViewI.setOnKeyListener(this);
        if (this.f6497v && this.f6479c.u() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f6478b).inflate(AbstractC1253f.f11660i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f6479c.u());
            }
            frameLayout.setEnabled(false);
            listViewI.addHeaderView(frameLayout, null, false);
        }
        this.f6485j.o(this.f6480e);
        this.f6485j.show();
        return true;
    }
}
