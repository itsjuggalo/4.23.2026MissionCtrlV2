package androidx.appcompat.view.menu;

import Q.AbstractC0677s;
import Q.N;
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
import h.AbstractC1658c;
import h.AbstractC1661f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.AbstractC2280b;
import p.I;
import p.InterfaceC2339H;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC2280b implements g, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final int f6513B = AbstractC1661f.f14451e;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f6514A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f6520g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f6529p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6531r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6532s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6533t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6534u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6536w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g.a f6537x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f6538y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6539z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f6521h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f6522i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f6523j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f6524k = new ViewOnAttachStateChangeListenerC0117b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final InterfaceC2339H f6525l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6526m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6527n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6535v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6530q = D();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.f() || b.this.f6522i.size() <= 0 || ((d) b.this.f6522i.get(0)).f6547a.n()) {
                return;
            }
            View view = b.this.f6529p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.f6522i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f6547a.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0117b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0117b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f6538y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f6538y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f6538y.removeGlobalOnLayoutListener(bVar.f6523j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements InterfaceC2339H {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f6543a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f6544b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ androidx.appcompat.view.menu.d f6545c;

            public a(d dVar, MenuItem menuItem, androidx.appcompat.view.menu.d dVar2) {
                this.f6543a = dVar;
                this.f6544b = menuItem;
                this.f6545c = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f6543a;
                if (dVar != null) {
                    b.this.f6514A = true;
                    dVar.f6548b.d(false);
                    b.this.f6514A = false;
                }
                if (this.f6544b.isEnabled() && this.f6544b.hasSubMenu()) {
                    this.f6545c.H(this.f6544b, 4);
                }
            }
        }

        public c() {
        }

        @Override // p.InterfaceC2339H
        public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f6520g.removeCallbacksAndMessages(null);
            int size = b.this.f6522i.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                } else if (dVar == ((d) b.this.f6522i.get(i7)).f6548b) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == -1) {
                return;
            }
            int i8 = i7 + 1;
            b.this.f6520g.postAtTime(new a(i8 < b.this.f6522i.size() ? (d) b.this.f6522i.get(i8) : null, menuItem, dVar), dVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // p.InterfaceC2339H
        public void c(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f6520g.removeCallbacksAndMessages(dVar);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final I f6547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.view.menu.d f6548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6549c;

        public d(I i7, androidx.appcompat.view.menu.d dVar, int i8) {
            this.f6547a = i7;
            this.f6548b = dVar;
            this.f6549c = i8;
        }

        public ListView a() {
            return this.f6547a.j();
        }
    }

    public b(Context context, View view, int i7, int i8, boolean z7) {
        this.f6515b = context;
        this.f6528o = view;
        this.f6517d = i7;
        this.f6518e = i8;
        this.f6519f = z7;
        Resources resources = context.getResources();
        this.f6516c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1658c.f14362b));
        this.f6520g = new Handler();
    }

    public final int A(androidx.appcompat.view.menu.d dVar) {
        int size = this.f6522i.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (dVar == ((d) this.f6522i.get(i7)).f6548b) {
                return i7;
            }
        }
        return -1;
    }

    public final MenuItem B(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.d dVar2) {
        int size = dVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = dVar.getItem(i7);
            if (item.hasSubMenu() && dVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View C(d dVar, androidx.appcompat.view.menu.d dVar2) {
        androidx.appcompat.view.menu.c cVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f6548b, dVar2);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i7 = 0;
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
            if (i7 >= count) {
                i7 = -1;
                break;
            }
            if (menuItemB == cVar.getItem(i7)) {
                break;
            }
            i7++;
        }
        if (i7 != -1 && (firstVisiblePosition = (i7 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int D() {
        return N.z(this.f6528o) == 1 ? 0 : 1;
    }

    public final int E(int i7) {
        List list = this.f6522i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f6529p.getWindowVisibleDisplayFrame(rect);
        return this.f6530q == 1 ? (iArr[0] + listViewA.getWidth()) + i7 > rect.right ? 0 : 1 : iArr[0] - i7 < 0 ? 1 : 0;
    }

    public final void F(androidx.appcompat.view.menu.d dVar) {
        d dVar2;
        View viewC;
        int i7;
        int i8;
        int i9;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6515b);
        androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(dVar, layoutInflaterFrom, this.f6519f, f6513B);
        if (!f() && this.f6535v) {
            cVar.d(true);
        } else if (f()) {
            cVar.d(AbstractC2280b.x(dVar));
        }
        int iO = AbstractC2280b.o(cVar, null, this.f6515b, this.f6516c);
        I iZ = z();
        iZ.p(cVar);
        iZ.s(iO);
        iZ.t(this.f6527n);
        if (this.f6522i.size() > 0) {
            List list = this.f6522i;
            dVar2 = (d) list.get(list.size() - 1);
            viewC = C(dVar2, dVar);
        } else {
            dVar2 = null;
            viewC = null;
        }
        if (viewC != null) {
            iZ.H(false);
            iZ.E(null);
            int iE = E(iO);
            boolean z7 = iE == 1;
            this.f6530q = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                iZ.q(viewC);
                i8 = 0;
                i7 = 0;
            } else {
                int[] iArr = new int[2];
                this.f6528o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.f6527n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f6528o.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i7 = iArr2[0] - iArr[0];
                i8 = iArr2[1] - iArr[1];
            }
            if ((this.f6527n & 5) == 5) {
                if (!z7) {
                    iO = viewC.getWidth();
                    i9 = i7 - iO;
                }
                i9 = i7 + iO;
            } else {
                if (z7) {
                    iO = viewC.getWidth();
                    i9 = i7 + iO;
                }
                i9 = i7 - iO;
            }
            iZ.v(i9);
            iZ.A(true);
            iZ.C(i8);
        } else {
            if (this.f6531r) {
                iZ.v(this.f6533t);
            }
            if (this.f6532s) {
                iZ.C(this.f6534u);
            }
            iZ.u(n());
        }
        this.f6522i.add(new d(iZ, dVar, this.f6530q));
        iZ.a();
        ListView listViewJ = iZ.j();
        listViewJ.setOnKeyListener(this);
        if (dVar2 == null && this.f6536w && dVar.u() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(AbstractC1661f.f14455i, (ViewGroup) listViewJ, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(dVar.u());
            listViewJ.addHeaderView(frameLayout, null, false);
            iZ.a();
        }
    }

    @Override // o.InterfaceC2281c
    public void a() {
        if (f()) {
            return;
        }
        Iterator it = this.f6521h.iterator();
        while (it.hasNext()) {
            F((androidx.appcompat.view.menu.d) it.next());
        }
        this.f6521h.clear();
        View view = this.f6528o;
        this.f6529p = view;
        if (view != null) {
            boolean z7 = this.f6538y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f6538y = viewTreeObserver;
            if (z7) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f6523j);
            }
            this.f6529p.addOnAttachStateChangeListener(this.f6524k);
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(androidx.appcompat.view.menu.d dVar, boolean z7) {
        int iA = A(dVar);
        if (iA < 0) {
            return;
        }
        int i7 = iA + 1;
        if (i7 < this.f6522i.size()) {
            ((d) this.f6522i.get(i7)).f6548b.d(false);
        }
        d dVar2 = (d) this.f6522i.remove(iA);
        dVar2.f6548b.K(this);
        if (this.f6514A) {
            dVar2.f6547a.F(null);
            dVar2.f6547a.r(0);
        }
        dVar2.f6547a.dismiss();
        int size = this.f6522i.size();
        if (size > 0) {
            this.f6530q = ((d) this.f6522i.get(size - 1)).f6549c;
        } else {
            this.f6530q = D();
        }
        if (size != 0) {
            if (z7) {
                ((d) this.f6522i.get(0)).f6548b.d(false);
                return;
            }
            return;
        }
        dismiss();
        g.a aVar = this.f6537x;
        if (aVar != null) {
            aVar.b(dVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f6538y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f6538y.removeGlobalOnLayoutListener(this.f6523j);
            }
            this.f6538y = null;
        }
        this.f6529p.removeOnAttachStateChangeListener(this.f6524k);
        this.f6539z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.g
    public void c(boolean z7) {
        Iterator it = this.f6522i.iterator();
        while (it.hasNext()) {
            AbstractC2280b.y(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d() {
        return false;
    }

    @Override // o.InterfaceC2281c
    public void dismiss() {
        int size = this.f6522i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f6522i.toArray(new d[size]);
            for (int i7 = size - 1; i7 >= 0; i7--) {
                d dVar = dVarArr[i7];
                if (dVar.f6547a.f()) {
                    dVar.f6547a.dismiss();
                }
            }
        }
    }

    @Override // o.InterfaceC2281c
    public boolean f() {
        return this.f6522i.size() > 0 && ((d) this.f6522i.get(0)).f6547a.f();
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(g.a aVar) {
        this.f6537x = aVar;
    }

    @Override // o.InterfaceC2281c
    public ListView j() {
        if (this.f6522i.isEmpty()) {
            return null;
        }
        return ((d) this.f6522i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean k(j jVar) {
        for (d dVar : this.f6522i) {
            if (jVar == dVar.f6548b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        l(jVar);
        g.a aVar = this.f6537x;
        if (aVar != null) {
            aVar.c(jVar);
        }
        return true;
    }

    @Override // o.AbstractC2280b
    public void l(androidx.appcompat.view.menu.d dVar) {
        dVar.b(this, this.f6515b);
        if (f()) {
            F(dVar);
        } else {
            this.f6521h.add(dVar);
        }
    }

    @Override // o.AbstractC2280b
    public boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f6522i.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f6522i.get(i7);
            if (!dVar.f6547a.f()) {
                break;
            } else {
                i7++;
            }
        }
        if (dVar != null) {
            dVar.f6548b.d(false);
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
        if (this.f6528o != view) {
            this.f6528o = view;
            this.f6527n = AbstractC0677s.b(this.f6526m, N.z(view));
        }
    }

    @Override // o.AbstractC2280b
    public void r(boolean z7) {
        this.f6535v = z7;
    }

    @Override // o.AbstractC2280b
    public void s(int i7) {
        if (this.f6526m != i7) {
            this.f6526m = i7;
            this.f6527n = AbstractC0677s.b(i7, N.z(this.f6528o));
        }
    }

    @Override // o.AbstractC2280b
    public void t(int i7) {
        this.f6531r = true;
        this.f6533t = i7;
    }

    @Override // o.AbstractC2280b
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f6539z = onDismissListener;
    }

    @Override // o.AbstractC2280b
    public void v(boolean z7) {
        this.f6536w = z7;
    }

    @Override // o.AbstractC2280b
    public void w(int i7) {
        this.f6532s = true;
        this.f6534u = i7;
    }

    public final I z() {
        I i7 = new I(this.f6515b, null, this.f6517d, this.f6518e);
        i7.G(this.f6525l);
        i7.z(this);
        i7.y(this);
        i7.q(this.f6528o);
        i7.t(this.f6527n);
        i7.x(true);
        i7.w(2);
        return i7;
    }
}
