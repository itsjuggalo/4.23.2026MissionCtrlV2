package o;

import android.content.Context;
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
public class D extends B implements C {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static Method f21730J;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public C f21731I;

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

    public static class c extends y {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f21732m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f21733n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public C f21734o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public MenuItem f21735p;

        public c(Context context, boolean z7) {
            super(context, z7);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f21732m = 21;
                this.f21733n = 22;
            } else {
                this.f21732m = 22;
                this.f21733n = 21;
            }
        }

        @Override // o.y
        public /* bridge */ /* synthetic */ int d(int i8, int i9, int i10, int i11, int i12) {
            return super.d(i8, i9, i10, i11, i12);
        }

        @Override // o.y
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i8) {
            return super.e(motionEvent, i8);
        }

        @Override // o.y, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // o.y, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // o.y, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // o.y, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // o.y, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.c cVar;
            int headersCount;
            int iPointToPosition;
            int i8;
            if (this.f21734o != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    cVar = (androidx.appcompat.view.menu.c) headerViewListAdapter.getWrappedAdapter();
                } else {
                    cVar = (androidx.appcompat.view.menu.c) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.e item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i8 = iPointToPosition - headersCount) < 0 || i8 >= cVar.getCount()) ? null : cVar.getItem(i8);
                MenuItem menuItem = this.f21735p;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.d dVarB = cVar.b();
                    if (menuItem != null) {
                        this.f21734o.b(dVarB, menuItem);
                    }
                    this.f21735p = item;
                    if (item != null) {
                        this.f21734o.a(dVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i8, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i8 == this.f21732m) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i8 != this.f21733n) {
                return super.onKeyDown(i8, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((androidx.appcompat.view.menu.c) adapter).b().d(false);
            return true;
        }

        @Override // o.y, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(C c8) {
            this.f21734o = c8;
        }

        @Override // o.y, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f21730J = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public D(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
    }

    public void D(Object obj) {
        a.a(this.f21696F, (Transition) obj);
    }

    public void E(Object obj) {
        a.b(this.f21696F, (Transition) obj);
    }

    public void F(C c8) {
        this.f21731I = c8;
    }

    public void G(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.f21696F, z7);
            return;
        }
        Method method = f21730J;
        if (method != null) {
            try {
                method.invoke(this.f21696F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // o.C
    public void a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
        C c8 = this.f21731I;
        if (c8 != null) {
            c8.a(dVar, menuItem);
        }
    }

    @Override // o.C
    public void b(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
        C c8 = this.f21731I;
        if (c8 != null) {
            c8.b(dVar, menuItem);
        }
    }

    @Override // o.B
    public y f(Context context, boolean z7) {
        c cVar = new c(context, z7);
        cVar.setHoverListener(this);
        return cVar;
    }
}
