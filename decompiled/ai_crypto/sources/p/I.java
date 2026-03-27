package p;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class I extends AbstractC2338G implements InterfaceC2339H {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static Method f21239J;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public InterfaceC2339H f21240I;

    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    public static class b {
        public static void a(PopupWindow popupWindow, boolean z7) {
            popupWindow.setTouchModal(z7);
        }
    }

    public static class c extends AbstractC2335D {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f21241m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f21242n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public InterfaceC2339H f21243o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public MenuItem f21244p;

        public static class a {
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z7) {
            super(context, z7);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f21241m = 21;
                this.f21242n = 22;
            } else {
                this.f21241m = 22;
                this.f21242n = 21;
            }
        }

        @Override // p.AbstractC2335D
        public /* bridge */ /* synthetic */ int d(int i7, int i8, int i9, int i10, int i11) {
            return super.d(i7, i8, i9, i10, i11);
        }

        @Override // p.AbstractC2335D
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i7) {
            return super.e(motionEvent, i7);
        }

        @Override // p.AbstractC2335D, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // p.AbstractC2335D, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // p.AbstractC2335D, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // p.AbstractC2335D, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // p.AbstractC2335D, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.c cVar;
            int headersCount;
            int iPointToPosition;
            int i7;
            if (this.f21243o != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    cVar = (androidx.appcompat.view.menu.c) headerViewListAdapter.getWrappedAdapter();
                } else {
                    cVar = (androidx.appcompat.view.menu.c) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.e item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i7 = iPointToPosition - headersCount) < 0 || i7 >= cVar.getCount()) ? null : cVar.getItem(i7);
                MenuItem menuItem = this.f21244p;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.d dVarB = cVar.b();
                    if (menuItem != null) {
                        this.f21243o.c(dVarB, menuItem);
                    }
                    this.f21244p = item;
                    if (item != null) {
                        this.f21243o.b(dVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i7, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i7 == this.f21241m) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i7 != this.f21242n) {
                return super.onKeyDown(i7, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.c) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.c) adapter).b().d(false);
            return true;
        }

        @Override // p.AbstractC2335D, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(InterfaceC2339H interfaceC2339H) {
            this.f21243o = interfaceC2339H;
        }

        @Override // p.AbstractC2335D, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f21239J = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public I(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
    }

    public void E(Object obj) {
        a.a(this.f21205F, (Transition) obj);
    }

    public void F(Object obj) {
        a.b(this.f21205F, (Transition) obj);
    }

    public void G(InterfaceC2339H interfaceC2339H) {
        this.f21240I = interfaceC2339H;
    }

    public void H(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.f21205F, z7);
            return;
        }
        Method method = f21239J;
        if (method != null) {
            try {
                method.invoke(this.f21205F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // p.InterfaceC2339H
    public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
        InterfaceC2339H interfaceC2339H = this.f21240I;
        if (interfaceC2339H != null) {
            interfaceC2339H.b(dVar, menuItem);
        }
    }

    @Override // p.InterfaceC2339H
    public void c(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
        InterfaceC2339H interfaceC2339H = this.f21240I;
        if (interfaceC2339H != null) {
            interfaceC2339H.c(dVar, menuItem);
        }
    }

    @Override // p.AbstractC2338G
    public AbstractC2335D g(Context context, boolean z7) {
        c cVar = new c(context, z7);
        cVar.setHoverListener(this);
        return cVar;
    }
}
