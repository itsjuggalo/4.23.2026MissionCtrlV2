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
import g.AbstractC1766c;
import g.AbstractC1769f;
import n.AbstractC2385b;
import o.D;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC2385b implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, g, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10519v = AbstractC1769f.f17755j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f10521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f10522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final D f10527i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f10530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f10531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f10532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g.a f10533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f10534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10537s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10539u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f10528j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f10529k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10538t = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!i.this.e() || i.this.f10527i.m()) {
                return;
            }
            View view = i.this.f10532n;
            if (view == null || !view.isShown()) {
                i.this.dismiss();
            } else {
                i.this.f10527i.show();
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
            ViewTreeObserver viewTreeObserver = i.this.f10534p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    i.this.f10534p = view.getViewTreeObserver();
                }
                i iVar = i.this;
                iVar.f10534p.removeGlobalOnLayoutListener(iVar.f10528j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public i(Context context, d dVar, View view, int i8, int i9, boolean z7) {
        this.f10520b = context;
        this.f10521c = dVar;
        this.f10523e = z7;
        this.f10522d = new c(dVar, LayoutInflater.from(context), z7, f10519v);
        this.f10525g = i8;
        this.f10526h = i9;
        Resources resources = context.getResources();
        this.f10524f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1766c.f17675b));
        this.f10531m = view;
        this.f10527i = new D(context, null, i8, i9);
        dVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z7) {
        if (dVar != this.f10521c) {
            return;
        }
        dismiss();
        g.a aVar = this.f10533o;
        if (aVar != null) {
            aVar.a(dVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z7) {
        this.f10536r = false;
        c cVar = this.f10522d;
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
            this.f10527i.dismiss();
        }
    }

    @Override // n.c
    public boolean e() {
        return !this.f10535q && this.f10527i.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f10533o = aVar;
    }

    @Override // n.c
    public ListView i() {
        return this.f10527i.i();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        if (jVar.hasVisibleItems()) {
            f fVar = new f(this.f10520b, jVar, this.f10532n, this.f10523e, this.f10525g, this.f10526h);
            fVar.j(this.f10533o);
            fVar.g(AbstractC2385b.w(jVar));
            fVar.i(this.f10530l);
            this.f10530l = null;
            this.f10521c.d(false);
            int iH = this.f10527i.h();
            int iK = this.f10527i.k();
            if ((Gravity.getAbsoluteGravity(this.f10538t, this.f10531m.getLayoutDirection()) & 7) == 5) {
                iH += this.f10531m.getWidth();
            }
            if (fVar.n(iH, iK)) {
                g.a aVar = this.f10533o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(jVar);
                return true;
            }
        }
        return false;
    }

    @Override // n.AbstractC2385b
    public void k(d dVar) {
    }

    @Override // n.AbstractC2385b
    public void o(View view) {
        this.f10531m = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f10535q = true;
        this.f10521c.close();
        ViewTreeObserver viewTreeObserver = this.f10534p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f10534p = this.f10532n.getViewTreeObserver();
            }
            this.f10534p.removeGlobalOnLayoutListener(this.f10528j);
            this.f10534p = null;
        }
        this.f10532n.removeOnAttachStateChangeListener(this.f10529k);
        PopupWindow.OnDismissListener onDismissListener = this.f10530l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i8, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i8 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // n.AbstractC2385b
    public void q(boolean z7) {
        this.f10522d.d(z7);
    }

    @Override // n.AbstractC2385b
    public void r(int i8) {
        this.f10538t = i8;
    }

    @Override // n.AbstractC2385b
    public void s(int i8) {
        this.f10527i.u(i8);
    }

    @Override // n.c
    public void show() {
        if (!y()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // n.AbstractC2385b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f10530l = onDismissListener;
    }

    @Override // n.AbstractC2385b
    public void u(boolean z7) {
        this.f10539u = z7;
    }

    @Override // n.AbstractC2385b
    public void v(int i8) {
        this.f10527i.B(i8);
    }

    public final boolean y() {
        View view;
        if (e()) {
            return true;
        }
        if (this.f10535q || (view = this.f10531m) == null) {
            return false;
        }
        this.f10532n = view;
        this.f10527i.x(this);
        this.f10527i.y(this);
        this.f10527i.w(true);
        View view2 = this.f10532n;
        boolean z7 = this.f10534p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f10534p = viewTreeObserver;
        if (z7) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f10528j);
        }
        view2.addOnAttachStateChangeListener(this.f10529k);
        this.f10527i.p(view2);
        this.f10527i.s(this.f10538t);
        if (!this.f10536r) {
            this.f10537s = AbstractC2385b.n(this.f10522d, null, this.f10520b, this.f10524f);
            this.f10536r = true;
        }
        this.f10527i.r(this.f10537s);
        this.f10527i.v(2);
        this.f10527i.t(m());
        this.f10527i.show();
        ListView listViewI = this.f10527i.i();
        listViewI.setOnKeyListener(this);
        if (this.f10539u && this.f10521c.u() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f10520b).inflate(AbstractC1769f.f17754i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f10521c.u());
            }
            frameLayout.setEnabled(false);
            listViewI.addHeaderView(frameLayout, null, false);
        }
        this.f10527i.o(this.f10522d);
        this.f10527i.show();
        return true;
    }
}
