package androidx.appcompat.view.menu;

import H.AbstractC0275i;
import H.E;
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
import g.AbstractC1250c;
import g.AbstractC1253f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.AbstractC1611b;
import o.N;
import o.P;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC1611b implements g, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final int f6364C = AbstractC1253f.f11656e;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6365A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f6366B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6368c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f6372h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f6380p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f6381q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6383s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6384t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6385u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6386v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6388x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g.a f6389y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewTreeObserver f6390z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f6373i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f6374j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f6375k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f6376l = new ViewOnAttachStateChangeListenerC0094b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final N f6377m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6378n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6379o = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6387w = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6382r = C();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.e() || b.this.f6374j.size() <= 0 || ((d) b.this.f6374j.get(0)).f6398a.m()) {
                return;
            }
            View view = b.this.f6381q;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.f6374j.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f6398a.show();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0094b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0094b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f6390z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f6390z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f6390z.removeGlobalOnLayoutListener(bVar.f6375k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements N {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f6394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f6395b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ androidx.appcompat.view.menu.d f6396c;

            public a(d dVar, MenuItem menuItem, androidx.appcompat.view.menu.d dVar2) {
                this.f6394a = dVar;
                this.f6395b = menuItem;
                this.f6396c = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f6394a;
                if (dVar != null) {
                    b.this.f6366B = true;
                    dVar.f6399b.d(false);
                    b.this.f6366B = false;
                }
                if (this.f6395b.isEnabled() && this.f6395b.hasSubMenu()) {
                    this.f6396c.H(this.f6395b, 4);
                }
            }
        }

        public c() {
        }

        @Override // o.N
        public void a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f6372h.removeCallbacksAndMessages(null);
            int size = b.this.f6374j.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                } else if (dVar == ((d) b.this.f6374j.get(i4)).f6399b) {
                    break;
                } else {
                    i4++;
                }
            }
            if (i4 == -1) {
                return;
            }
            int i5 = i4 + 1;
            b.this.f6372h.postAtTime(new a(i5 < b.this.f6374j.size() ? (d) b.this.f6374j.get(i5) : null, menuItem, dVar), dVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // o.N
        public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            b.this.f6372h.removeCallbacksAndMessages(dVar);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P f6398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.appcompat.view.menu.d f6399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6400c;

        public d(P p4, androidx.appcompat.view.menu.d dVar, int i4) {
            this.f6398a = p4;
            this.f6399b = dVar;
            this.f6400c = i4;
        }

        public ListView a() {
            return this.f6398a.i();
        }
    }

    public b(Context context, View view, int i4, int i5, boolean z4) {
        this.f6367b = context;
        this.f6380p = view;
        this.f6369e = i4;
        this.f6370f = i5;
        this.f6371g = z4;
        Resources resources = context.getResources();
        this.f6368c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(AbstractC1250c.f11569b));
        this.f6372h = new Handler();
    }

    public final MenuItem A(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.d dVar2) {
        int size = dVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = dVar.getItem(i4);
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
        MenuItem menuItemA = A(dVar.f6399b, dVar2);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i4 = 0;
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
            if (i4 >= count) {
                i4 = -1;
                break;
            }
            if (menuItemA == cVar.getItem(i4)) {
                break;
            }
            i4++;
        }
        if (i4 != -1 && (firstVisiblePosition = (i4 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int C() {
        return E.n(this.f6380p) == 1 ? 0 : 1;
    }

    public final int D(int i4) {
        List list = this.f6374j;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f6381q.getWindowVisibleDisplayFrame(rect);
        return this.f6382r == 1 ? (iArr[0] + listViewA.getWidth()) + i4 > rect.right ? 0 : 1 : iArr[0] - i4 < 0 ? 1 : 0;
    }

    public final void E(androidx.appcompat.view.menu.d dVar) {
        d dVar2;
        View viewB;
        int i4;
        int i5;
        int i6;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6367b);
        androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(dVar, layoutInflaterFrom, this.f6371g, f6364C);
        if (!e() && this.f6387w) {
            cVar.d(true);
        } else if (e()) {
            cVar.d(AbstractC1611b.w(dVar));
        }
        int iN = AbstractC1611b.n(cVar, null, this.f6367b, this.f6368c);
        P pY = y();
        pY.o(cVar);
        pY.r(iN);
        pY.s(this.f6379o);
        if (this.f6374j.size() > 0) {
            List list = this.f6374j;
            dVar2 = (d) list.get(list.size() - 1);
            viewB = B(dVar2, dVar);
        } else {
            dVar2 = null;
            viewB = null;
        }
        if (viewB != null) {
            pY.G(false);
            pY.D(null);
            int iD = D(iN);
            boolean z4 = iD == 1;
            this.f6382r = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                pY.p(viewB);
                i5 = 0;
                i4 = 0;
            } else {
                int[] iArr = new int[2];
                this.f6380p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewB.getLocationOnScreen(iArr2);
                if ((this.f6379o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f6380p.getWidth();
                    iArr2[0] = iArr2[0] + viewB.getWidth();
                }
                i4 = iArr2[0] - iArr[0];
                i5 = iArr2[1] - iArr[1];
            }
            if ((this.f6379o & 5) == 5) {
                if (!z4) {
                    iN = viewB.getWidth();
                    i6 = i4 - iN;
                }
                i6 = i4 + iN;
            } else {
                if (z4) {
                    iN = viewB.getWidth();
                    i6 = i4 + iN;
                }
                i6 = i4 - iN;
            }
            pY.u(i6);
            pY.z(true);
            pY.B(i5);
        } else {
            if (this.f6383s) {
                pY.u(this.f6385u);
            }
            if (this.f6384t) {
                pY.B(this.f6386v);
            }
            pY.t(m());
        }
        this.f6374j.add(new d(pY, dVar, this.f6382r));
        pY.show();
        ListView listViewI = pY.i();
        listViewI.setOnKeyListener(this);
        if (dVar2 == null && this.f6388x && dVar.u() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(AbstractC1253f.f11660i, (ViewGroup) listViewI, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(dVar.u());
            listViewI.addHeaderView(frameLayout, null, false);
            pY.show();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z4) {
        int iZ = z(dVar);
        if (iZ < 0) {
            return;
        }
        int i4 = iZ + 1;
        if (i4 < this.f6374j.size()) {
            ((d) this.f6374j.get(i4)).f6399b.d(false);
        }
        d dVar2 = (d) this.f6374j.remove(iZ);
        dVar2.f6399b.K(this);
        if (this.f6366B) {
            dVar2.f6398a.E(null);
            dVar2.f6398a.q(0);
        }
        dVar2.f6398a.dismiss();
        int size = this.f6374j.size();
        if (size > 0) {
            this.f6382r = ((d) this.f6374j.get(size - 1)).f6400c;
        } else {
            this.f6382r = C();
        }
        if (size != 0) {
            if (z4) {
                ((d) this.f6374j.get(0)).f6399b.d(false);
                return;
            }
            return;
        }
        dismiss();
        g.a aVar = this.f6389y;
        if (aVar != null) {
            aVar.a(dVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f6390z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f6390z.removeGlobalOnLayoutListener(this.f6375k);
            }
            this.f6390z = null;
        }
        this.f6381q.removeOnAttachStateChangeListener(this.f6376l);
        this.f6365A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z4) {
        Iterator it = this.f6374j.iterator();
        while (it.hasNext()) {
            AbstractC1611b.x(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // n.InterfaceC1612c
    public void dismiss() {
        int size = this.f6374j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f6374j.toArray(new d[size]);
            for (int i4 = size - 1; i4 >= 0; i4--) {
                d dVar = dVarArr[i4];
                if (dVar.f6398a.e()) {
                    dVar.f6398a.dismiss();
                }
            }
        }
    }

    @Override // n.InterfaceC1612c
    public boolean e() {
        return this.f6374j.size() > 0 && ((d) this.f6374j.get(0)).f6398a.e();
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f6389y = aVar;
    }

    @Override // n.InterfaceC1612c
    public ListView i() {
        if (this.f6374j.isEmpty()) {
            return null;
        }
        return ((d) this.f6374j.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        for (d dVar : this.f6374j) {
            if (jVar == dVar.f6399b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        k(jVar);
        g.a aVar = this.f6389y;
        if (aVar != null) {
            aVar.b(jVar);
        }
        return true;
    }

    @Override // n.AbstractC1611b
    public void k(androidx.appcompat.view.menu.d dVar) {
        dVar.b(this, this.f6367b);
        if (e()) {
            E(dVar);
        } else {
            this.f6373i.add(dVar);
        }
    }

    @Override // n.AbstractC1611b
    public boolean l() {
        return false;
    }

    @Override // n.AbstractC1611b
    public void o(View view) {
        if (this.f6380p != view) {
            this.f6380p = view;
            this.f6379o = AbstractC0275i.a(this.f6378n, E.n(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f6374j.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f6374j.get(i4);
            if (!dVar.f6398a.e()) {
                break;
            } else {
                i4++;
            }
        }
        if (dVar != null) {
            dVar.f6399b.d(false);
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
        this.f6387w = z4;
    }

    @Override // n.AbstractC1611b
    public void r(int i4) {
        if (this.f6378n != i4) {
            this.f6378n = i4;
            this.f6379o = AbstractC0275i.a(i4, E.n(this.f6380p));
        }
    }

    @Override // n.AbstractC1611b
    public void s(int i4) {
        this.f6383s = true;
        this.f6385u = i4;
    }

    @Override // n.InterfaceC1612c
    public void show() {
        if (e()) {
            return;
        }
        Iterator it = this.f6373i.iterator();
        while (it.hasNext()) {
            E((androidx.appcompat.view.menu.d) it.next());
        }
        this.f6373i.clear();
        View view = this.f6380p;
        this.f6381q = view;
        if (view != null) {
            boolean z4 = this.f6390z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f6390z = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f6375k);
            }
            this.f6381q.addOnAttachStateChangeListener(this.f6376l);
        }
    }

    @Override // n.AbstractC1611b
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f6365A = onDismissListener;
    }

    @Override // n.AbstractC1611b
    public void u(boolean z4) {
        this.f6388x = z4;
    }

    @Override // n.AbstractC1611b
    public void v(int i4) {
        this.f6384t = true;
        this.f6386v = i4;
    }

    public final P y() {
        P p4 = new P(this.f6367b, null, this.f6369e, this.f6370f);
        p4.F(this.f6377m);
        p4.y(this);
        p4.x(this);
        p4.p(this.f6380p);
        p4.s(this.f6379o);
        p4.w(true);
        p4.v(2);
        return p4;
    }

    public final int z(androidx.appcompat.view.menu.d dVar) {
        int size = this.f6374j.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (dVar == ((d) this.f6374j.get(i4)).f6399b) {
                return i4;
            }
        }
        return -1;
    }
}
