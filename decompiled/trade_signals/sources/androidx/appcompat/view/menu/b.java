package androidx.appcompat.view.menu;

import T.AbstractC0927i;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import g.AbstractC1766c;
import g.AbstractC1769f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.AbstractC2385b;
import o.C;
import o.D;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC2385b implements g, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final int f10406B = AbstractC1769f.f17750e;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f10407A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f10413g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f10421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f10422p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10427u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g.a f10430x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f10431y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f10432z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f10414h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f10415i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f10416j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f10417k = new ViewOnAttachStateChangeListenerC0173b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C f10418l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10419m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10420n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10428v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10423q = C();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.e() || b.this.f10415i.size() <= 0 || ((d) b.this.f10415i.get(0)).f10440a.m()) {
                return;
            }
            View view = b.this.f10422p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.f10415i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f10440a.show();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0173b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0173b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f10431y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f10431y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f10431y.removeGlobalOnLayoutListener(bVar.f10416j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements C {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f10436a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f10437b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ androidx.appcompat.view.menu.d f10438c;

            public a(d dVar, MenuItem menuItem, androidx.appcompat.view.menu.d dVar2) {
                this.f10436a = dVar;
                this.f10437b = menuItem;
                this.f10438c = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f10436a;
                if (dVar != null) {
                    b.this.f10407A = true;
                    dVar.f10441b.d(false);
                    b.this.f10407A = false;
                }
                if (this.f10437b.isEnabled() && this.f10437b.hasSubMenu()) {
                    this.f10438c.I(this.f10437b, 4);
                }
            }
        }

        public c() {
        }

        @Override // o.C
        public void a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f10413g.removeCallbacksAndMessages(null);
            int size = b.this.f10415i.size();
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    i8 = -1;
                    break;
                } else if (dVar == ((d) b.this.f10415i.get(i8)).f10441b) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 == -1) {
                return;
            }
            int i9 = i8 + 1;
            b.this.f10413g.postAtTime(new a(i9 < b.this.f10415i.size() ? (d) b.this.f10415i.get(i9) : null, menuItem, dVar), dVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // o.C
        public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f10413g.removeCallbacksAndMessages(dVar);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f10440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.view.menu.d f10441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10442c;

        public d(D d8, androidx.appcompat.view.menu.d dVar, int i8) {
            this.f10440a = d8;
            this.f10441b = dVar;
            this.f10442c = i8;
        }

        public ListView a() {
            return this.f10440a.i();
        }
    }

    public b(Context context, View view, int i8, int i9, boolean z7) {
        this.f10408b = context;
        this.f10421o = view;
        this.f10410d = i8;
        this.f10411e = i9;
        this.f10412f = z7;
        Resources resources = context.getResources();
        this.f10409c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1766c.f17675b));
        this.f10413g = new Handler();
    }

    public final MenuItem A(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.d dVar2) {
        int size = dVar.size();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = dVar.getItem(i8);
            if (item.hasSubMenu() && dVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View B(d dVar, androidx.appcompat.view.menu.d dVar2) {
        androidx.appcompat.view.menu.c cVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemA = A(dVar.f10441b, dVar2);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i8 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            cVar = (androidx.appcompat.view.menu.c) headerViewListAdapter.getWrappedAdapter();
        } else {
            cVar = (androidx.appcompat.view.menu.c) adapter;
            headersCount = 0;
        }
        int count = cVar.getCount();
        while (true) {
            if (i8 >= count) {
                i8 = -1;
                break;
            }
            if (menuItemA == cVar.getItem(i8)) {
                break;
            }
            i8++;
        }
        if (i8 != -1 && (firstVisiblePosition = (i8 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int C() {
        return this.f10421o.getLayoutDirection() == 1 ? 0 : 1;
    }

    public final int D(int i8) {
        List list = this.f10415i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f10422p.getWindowVisibleDisplayFrame(rect);
        return this.f10423q == 1 ? (iArr[0] + listViewA.getWidth()) + i8 > rect.right ? 0 : 1 : iArr[0] - i8 < 0 ? 1 : 0;
    }

    public final void E(androidx.appcompat.view.menu.d dVar) {
        d dVar2;
        View viewB;
        int i8;
        int i9;
        int i10;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f10408b);
        androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(dVar, layoutInflaterFrom, this.f10412f, f10406B);
        if (!e() && this.f10428v) {
            cVar.d(true);
        } else if (e()) {
            cVar.d(AbstractC2385b.w(dVar));
        }
        int iN = AbstractC2385b.n(cVar, null, this.f10408b, this.f10409c);
        D dY = y();
        dY.o(cVar);
        dY.r(iN);
        dY.s(this.f10420n);
        if (this.f10415i.size() > 0) {
            List list = this.f10415i;
            dVar2 = (d) list.get(list.size() - 1);
            viewB = B(dVar2, dVar);
        } else {
            dVar2 = null;
            viewB = null;
        }
        if (viewB != null) {
            dY.G(false);
            dY.D(null);
            int iD = D(iN);
            boolean z7 = iD == 1;
            this.f10423q = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                dY.p(viewB);
                i9 = 0;
                i8 = 0;
            } else {
                int[] iArr = new int[2];
                this.f10421o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewB.getLocationOnScreen(iArr2);
                if ((this.f10420n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f10421o.getWidth();
                    iArr2[0] = iArr2[0] + viewB.getWidth();
                }
                i8 = iArr2[0] - iArr[0];
                i9 = iArr2[1] - iArr[1];
            }
            if ((this.f10420n & 5) == 5) {
                if (!z7) {
                    iN = viewB.getWidth();
                    i10 = i8 - iN;
                }
                i10 = i8 + iN;
            } else {
                if (z7) {
                    iN = viewB.getWidth();
                    i10 = i8 + iN;
                }
                i10 = i8 - iN;
            }
            dY.u(i10);
            dY.z(true);
            dY.B(i9);
        } else {
            if (this.f10424r) {
                dY.u(this.f10426t);
            }
            if (this.f10425s) {
                dY.B(this.f10427u);
            }
            dY.t(m());
        }
        this.f10415i.add(new d(dY, dVar, this.f10423q));
        dY.show();
        ListView listViewI = dY.i();
        listViewI.setOnKeyListener(this);
        if (dVar2 == null && this.f10429w && dVar.u() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(AbstractC1769f.f17754i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(dVar.u());
            listViewI.addHeaderView(frameLayout, null, false);
            dY.show();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z7) {
        int iZ = z(dVar);
        if (iZ < 0) {
            return;
        }
        int i8 = iZ + 1;
        if (i8 < this.f10415i.size()) {
            ((d) this.f10415i.get(i8)).f10441b.d(false);
        }
        d dVar2 = (d) this.f10415i.remove(iZ);
        dVar2.f10441b.L(this);
        if (this.f10407A) {
            dVar2.f10440a.E(null);
            dVar2.f10440a.q(0);
        }
        dVar2.f10440a.dismiss();
        int size = this.f10415i.size();
        this.f10423q = size > 0 ? ((d) this.f10415i.get(size - 1)).f10442c : C();
        if (size != 0) {
            if (z7) {
                ((d) this.f10415i.get(0)).f10441b.d(false);
                return;
            }
            return;
        }
        dismiss();
        g.a aVar = this.f10430x;
        if (aVar != null) {
            aVar.a(dVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f10431y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f10431y.removeGlobalOnLayoutListener(this.f10416j);
            }
            this.f10431y = null;
        }
        this.f10422p.removeOnAttachStateChangeListener(this.f10417k);
        this.f10432z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z7) {
        Iterator it = this.f10415i.iterator();
        while (it.hasNext()) {
            AbstractC2385b.x(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // n.c
    public void dismiss() {
        int size = this.f10415i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f10415i.toArray(new d[size]);
            for (int i8 = size - 1; i8 >= 0; i8--) {
                d dVar = dVarArr[i8];
                if (dVar.f10440a.e()) {
                    dVar.f10440a.dismiss();
                }
            }
        }
    }

    @Override // n.c
    public boolean e() {
        return this.f10415i.size() > 0 && ((d) this.f10415i.get(0)).f10440a.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f10430x = aVar;
    }

    @Override // n.c
    public ListView i() {
        if (this.f10415i.isEmpty()) {
            return null;
        }
        return ((d) this.f10415i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        for (d dVar : this.f10415i) {
            if (jVar == dVar.f10441b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        k(jVar);
        g.a aVar = this.f10430x;
        if (aVar != null) {
            aVar.b(jVar);
        }
        return true;
    }

    @Override // n.AbstractC2385b
    public void k(androidx.appcompat.view.menu.d dVar) {
        dVar.b(this, this.f10408b);
        if (e()) {
            E(dVar);
        } else {
            this.f10414h.add(dVar);
        }
    }

    @Override // n.AbstractC2385b
    public boolean l() {
        return false;
    }

    @Override // n.AbstractC2385b
    public void o(View view) {
        if (this.f10421o != view) {
            this.f10421o = view;
            this.f10420n = AbstractC0927i.a(this.f10419m, view.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f10415i.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f10415i.get(i8);
            if (!dVar.f10440a.e()) {
                break;
            } else {
                i8++;
            }
        }
        if (dVar != null) {
            dVar.f10441b.d(false);
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
        this.f10428v = z7;
    }

    @Override // n.AbstractC2385b
    public void r(int i8) {
        if (this.f10419m != i8) {
            this.f10419m = i8;
            this.f10420n = AbstractC0927i.a(i8, this.f10421o.getLayoutDirection());
        }
    }

    @Override // n.AbstractC2385b
    public void s(int i8) {
        this.f10424r = true;
        this.f10426t = i8;
    }

    @Override // n.c
    public void show() {
        if (e()) {
            return;
        }
        Iterator it = this.f10414h.iterator();
        while (it.hasNext()) {
            E((androidx.appcompat.view.menu.d) it.next());
        }
        this.f10414h.clear();
        View view = this.f10421o;
        this.f10422p = view;
        if (view != null) {
            boolean z7 = this.f10431y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f10431y = viewTreeObserver;
            if (z7) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f10416j);
            }
            this.f10422p.addOnAttachStateChangeListener(this.f10417k);
        }
    }

    @Override // n.AbstractC2385b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f10432z = onDismissListener;
    }

    @Override // n.AbstractC2385b
    public void u(boolean z7) {
        this.f10429w = z7;
    }

    @Override // n.AbstractC2385b
    public void v(int i8) {
        this.f10425s = true;
        this.f10427u = i8;
    }

    public final D y() {
        D d8 = new D(this.f10408b, null, this.f10410d, this.f10411e);
        d8.F(this.f10418l);
        d8.y(this);
        d8.x(this);
        d8.p(this.f10421o);
        d8.s(this.f10420n);
        d8.w(true);
        d8.v(2);
        return d8;
    }

    public final int z(androidx.appcompat.view.menu.d dVar) {
        int size = this.f10415i.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (dVar == ((d) this.f10415i.get(i8)).f10441b) {
                return i8;
            }
        }
        return -1;
    }
}
