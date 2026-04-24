package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: renamed from: m.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0826k0 extends U {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f8394q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8395r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public InterfaceC0818g0 f8396s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l.j f8397t;

    public C0826k0(Context context, boolean z6) {
        super(context, z6);
        if (1 == AbstractC0824j0.a(context.getResources().getConfiguration())) {
            this.f8394q = 21;
            this.f8395r = 22;
        } else {
            this.f8394q = 22;
            this.f8395r = 21;
        }
    }

    @Override // m.U, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        l.g gVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.f8396s != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                gVar = (l.g) headerViewListAdapter.getWrappedAdapter();
            } else {
                gVar = (l.g) adapter;
                headersCount = 0;
            }
            l.j item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= gVar.getCount()) ? null : gVar.getItem(i);
            l.j jVar = this.f8397t;
            if (jVar != item) {
                l.i iVar = gVar.f7976a;
                if (jVar != null) {
                    this.f8396s.c(iVar, jVar);
                }
                this.f8397t = item;
                if (item != null) {
                    this.f8396s.e(iVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.f8394q) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.f8395r) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (l.g) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (l.g) adapter).f7976a.c(false);
        return true;
    }

    public void setHoverListener(InterfaceC0818g0 interfaceC0818g0) {
        this.f8396s = interfaceC0818g0;
    }

    @Override // m.U, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
