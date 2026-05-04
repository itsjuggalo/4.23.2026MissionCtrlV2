package androidx.appcompat.view.menu;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.a0;
import o.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n.b implements g, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = g.f.f9740e;
    public boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f996g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f1004o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1005p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1007r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1008s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1009t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1010u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g.a f1013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f1014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1015z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f997h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f998i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f999j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1000k = new ViewOnAttachStateChangeListenerC0014b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a0 f1001l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1002m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1003n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1011v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1006q = C();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.e() || b.this.f998i.size() <= 0 || ((d) b.this.f998i.get(0)).f1023a.m()) {
                return;
            }
            View view = b.this.f1005p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.f998i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f1023a.show();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements a0 {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f1019a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f1020b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ androidx.appcompat.view.menu.d f1021c;

            public a(d dVar, MenuItem menuItem, androidx.appcompat.view.menu.d dVar2) {
                this.f1019a = dVar;
                this.f1020b = menuItem;
                this.f1021c = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1019a;
                if (dVar != null) {
                    b.this.A = true;
                    dVar.f1024b.d(false);
                    b.this.A = false;
                }
                if (this.f1020b.isEnabled() && this.f1020b.hasSubMenu()) {
                    this.f1021c.I(this.f1020b, 4);
                }
            }
        }

        public c() {
        }

        @Override // o.a0
        public void a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f996g.removeCallbacksAndMessages(null);
            int size = b.this.f998i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (dVar == ((d) b.this.f998i.get(i10)).f1024b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            b.this.f996g.postAtTime(new a(i11 < b.this.f998i.size() ? (d) b.this.f998i.get(i11) : null, menuItem, dVar), dVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // o.a0
        public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f996g.removeCallbacksAndMessages(dVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f1023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.view.menu.d f1024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1025c;

        public d(b0 b0Var, androidx.appcompat.view.menu.d dVar, int i10) {
            this.f1023a = b0Var;
            this.f1024b = dVar;
            this.f1025c = i10;
        }

        public ListView a() {
            return this.f1023a.i();
        }
    }

    public b(Context context, View view, int i10, int i11, boolean z10) {
        this.f991b = context;
        this.f1004o = view;
        this.f993d = i10;
        this.f994e = i11;
        this.f995f = z10;
        Resources resources = context.getResources();
        this.f992c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.c.f9684b));
        this.f996g = new Handler();
    }

    public final MenuItem A(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.d dVar2) {
        int size = dVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = dVar.getItem(i10);
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
        MenuItem menuItemA = A(dVar.f1024b, dVar2);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i10 = 0;
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
            if (i10 >= count) {
                i10 = -1;
                break;
            }
            if (menuItemA == cVar.getItem(i10)) {
                break;
            }
            i10++;
        }
        if (i10 != -1 && (firstVisiblePosition = (i10 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int C() {
        return this.f1004o.getLayoutDirection() == 1 ? 0 : 1;
    }

    public final int D(int i10) {
        List list = this.f998i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1005p.getWindowVisibleDisplayFrame(rect);
        return this.f1006q == 1 ? (iArr[0] + listViewA.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    public final void E(androidx.appcompat.view.menu.d dVar) {
        d dVar2;
        View viewB;
        int i10;
        int i11;
        int i12;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f991b);
        androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(dVar, layoutInflaterFrom, this.f995f, B);
        if (!e() && this.f1011v) {
            cVar.d(true);
        } else if (e()) {
            cVar.d(n.b.w(dVar));
        }
        int iN = n.b.n(cVar, null, this.f991b, this.f992c);
        b0 b0VarY = y();
        b0VarY.o(cVar);
        b0VarY.r(iN);
        b0VarY.s(this.f1003n);
        if (this.f998i.size() > 0) {
            List list = this.f998i;
            dVar2 = (d) list.get(list.size() - 1);
            viewB = B(dVar2, dVar);
        } else {
            dVar2 = null;
            viewB = null;
        }
        if (viewB != null) {
            b0VarY.G(false);
            b0VarY.D(null);
            int iD = D(iN);
            boolean z10 = iD == 1;
            this.f1006q = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                b0VarY.p(viewB);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1004o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewB.getLocationOnScreen(iArr2);
                if ((this.f1003n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1004o.getWidth();
                    iArr2[0] = iArr2[0] + viewB.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f1003n & 5) == 5) {
                if (!z10) {
                    iN = viewB.getWidth();
                    i12 = i10 - iN;
                }
                i12 = i10 + iN;
            } else {
                if (z10) {
                    iN = viewB.getWidth();
                    i12 = i10 + iN;
                }
                i12 = i10 - iN;
            }
            b0VarY.u(i12);
            b0VarY.z(true);
            b0VarY.B(i11);
        } else {
            if (this.f1007r) {
                b0VarY.u(this.f1009t);
            }
            if (this.f1008s) {
                b0VarY.B(this.f1010u);
            }
            b0VarY.t(m());
        }
        this.f998i.add(new d(b0VarY, dVar, this.f1006q));
        b0VarY.show();
        ListView listViewI = b0VarY.i();
        listViewI.setOnKeyListener(this);
        if (dVar2 == null && this.f1012w && dVar.u() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(g.f.f9744i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(dVar.u());
            listViewI.addHeaderView(frameLayout, null, false);
            b0VarY.show();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z10) {
        int iZ = z(dVar);
        if (iZ < 0) {
            return;
        }
        int i10 = iZ + 1;
        if (i10 < this.f998i.size()) {
            ((d) this.f998i.get(i10)).f1024b.d(false);
        }
        d dVar2 = (d) this.f998i.remove(iZ);
        dVar2.f1024b.L(this);
        if (this.A) {
            dVar2.f1023a.E(null);
            dVar2.f1023a.q(0);
        }
        dVar2.f1023a.dismiss();
        int size = this.f998i.size();
        if (size > 0) {
            this.f1006q = ((d) this.f998i.get(size - 1)).f1025c;
        } else {
            this.f1006q = C();
        }
        if (size != 0) {
            if (z10) {
                ((d) this.f998i.get(0)).f1024b.d(false);
                return;
            }
            return;
        }
        dismiss();
        g.a aVar = this.f1013x;
        if (aVar != null) {
            aVar.a(dVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1014y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1014y.removeGlobalOnLayoutListener(this.f999j);
            }
            this.f1014y = null;
        }
        this.f1005p.removeOnAttachStateChangeListener(this.f1000k);
        this.f1015z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z10) {
        Iterator it = this.f998i.iterator();
        while (it.hasNext()) {
            n.b.x(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // n.c
    public void dismiss() {
        int size = this.f998i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f998i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f1023a.e()) {
                    dVar.f1023a.dismiss();
                }
            }
        }
    }

    @Override // n.c
    public boolean e() {
        return this.f998i.size() > 0 && ((d) this.f998i.get(0)).f1023a.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f1013x = aVar;
    }

    @Override // n.c
    public ListView i() {
        if (this.f998i.isEmpty()) {
            return null;
        }
        return ((d) this.f998i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        for (d dVar : this.f998i) {
            if (jVar == dVar.f1024b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        k(jVar);
        g.a aVar = this.f1013x;
        if (aVar != null) {
            aVar.b(jVar);
        }
        return true;
    }

    @Override // n.b
    public void k(androidx.appcompat.view.menu.d dVar) {
        dVar.b(this, this.f991b);
        if (e()) {
            E(dVar);
        } else {
            this.f997h.add(dVar);
        }
    }

    @Override // n.b
    public boolean l() {
        return false;
    }

    @Override // n.b
    public void o(View view) {
        if (this.f1004o != view) {
            this.f1004o = view;
            this.f1003n = t0.h.a(this.f1002m, view.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f998i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f998i.get(i10);
            if (!dVar.f1023a.e()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f1024b.d(false);
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
        this.f1011v = z10;
    }

    @Override // n.b
    public void r(int i10) {
        if (this.f1002m != i10) {
            this.f1002m = i10;
            this.f1003n = t0.h.a(i10, this.f1004o.getLayoutDirection());
        }
    }

    @Override // n.b
    public void s(int i10) {
        this.f1007r = true;
        this.f1009t = i10;
    }

    @Override // n.c
    public void show() {
        if (e()) {
            return;
        }
        Iterator it = this.f997h.iterator();
        while (it.hasNext()) {
            E((androidx.appcompat.view.menu.d) it.next());
        }
        this.f997h.clear();
        View view = this.f1004o;
        this.f1005p = view;
        if (view != null) {
            boolean z10 = this.f1014y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1014y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f999j);
            }
            this.f1005p.addOnAttachStateChangeListener(this.f1000k);
        }
    }

    @Override // n.b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f1015z = onDismissListener;
    }

    @Override // n.b
    public void u(boolean z10) {
        this.f1012w = z10;
    }

    @Override // n.b
    public void v(int i10) {
        this.f1008s = true;
        this.f1010u = i10;
    }

    public final b0 y() {
        b0 b0Var = new b0(this.f991b, null, this.f993d, this.f994e);
        b0Var.F(this.f1001l);
        b0Var.y(this);
        b0Var.x(this);
        b0Var.p(this.f1004o);
        b0Var.s(this.f1003n);
        b0Var.w(true);
        b0Var.v(2);
        return b0Var;
    }

    public final int z(androidx.appcompat.view.menu.d dVar) {
        int size = this.f998i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (dVar == ((d) this.f998i.get(i10)).f1024b) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class ViewOnAttachStateChangeListenerC0014b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0014b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f1014y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f1014y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f1014y.removeGlobalOnLayoutListener(bVar.f999j);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
