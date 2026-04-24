package o;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;

/* JADX INFO: renamed from: o.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2280b implements InterfaceC2281c, g, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f19912a;

    public static int o(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i7) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i8 = 0;
        int i9 = 0;
        View view = null;
        for (int i10 = 0; i10 < count; i10++) {
            int itemViewType = listAdapter.getItemViewType(i10);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i10, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i7) {
                return i7;
            }
            if (measuredWidth > i8) {
                i8 = measuredWidth;
            }
        }
        return i8;
    }

    public static boolean x(d dVar) {
        int size = dVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = dVar.getItem(i7);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static androidx.appcompat.view.menu.c y(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.c) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (androidx.appcompat.view.menu.c) listAdapter;
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean e(d dVar, e eVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean g(d dVar, e eVar) {
        return false;
    }

    public abstract void l(d dVar);

    public boolean m() {
        return true;
    }

    public Rect n() {
        return this.f19912a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        y(listAdapter).f6550a.I((MenuItem) listAdapter.getItem(i7), this, m() ? 0 : 4);
    }

    public abstract void p(View view);

    public void q(Rect rect) {
        this.f19912a = rect;
    }

    public abstract void r(boolean z7);

    public abstract void s(int i7);

    public abstract void t(int i7);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z7);

    public abstract void w(int i7);

    @Override // androidx.appcompat.view.menu.g
    public void i(Context context, d dVar) {
    }
}
