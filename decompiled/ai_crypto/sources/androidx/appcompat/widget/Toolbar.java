package androidx.appcompat.widget;

import Q.AbstractC0677s;
import Q.AbstractC0680v;
import Q.C0682x;
import Q.InterfaceC0681w;
import Q.InterfaceC0684z;
import Q.N;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import h.AbstractC1656a;
import h.AbstractC1664i;
import i.AbstractC1733a;
import j.AbstractC2040a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import n.C2248d;
import n.InterfaceC2246b;
import p.C2352m;
import p.C2354o;
import p.C2358t;
import p.InterfaceC2362x;
import p.L;
import p.S;
import p.W;
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0681w {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f6856A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f6857B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f6858C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ArrayList f6859D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final ArrayList f6860E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int[] f6861F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final C0682x f6862G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ArrayList f6863H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final ActionMenuView.e f6864I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public androidx.appcompat.widget.d f6865J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public androidx.appcompat.widget.a f6866K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public f f6867L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public g.a f6868M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public d.a f6869N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f6870O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public OnBackInvokedCallback f6871P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public OnBackInvokedDispatcher f6872Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f6873R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final Runnable f6874S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f6875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f6876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f6877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f6878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f6879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f6881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f6882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f6883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f6884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public L f6894t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6895u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6896v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6897w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f6898x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f6899y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f6900z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f6862G.d(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.M();
        }
    }

    public class c implements d.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            d.a aVar = Toolbar.this.f6869N;
            return aVar != null && aVar.a(dVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void b(androidx.appcompat.view.menu.d dVar) {
            if (!Toolbar.this.f6875a.H()) {
                Toolbar.this.f6862G.e(dVar);
            }
            d.a aVar = Toolbar.this.f6869N;
            if (aVar != null) {
                aVar.b(dVar);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.d();
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: p.V
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class f implements androidx.appcompat.view.menu.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f6905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f6906b;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.g
        public void b(androidx.appcompat.view.menu.d dVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.g
        public void c(boolean z7) {
            if (this.f6906b != null) {
                androidx.appcompat.view.menu.d dVar = this.f6905a;
                if (dVar != null) {
                    int size = dVar.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f6905a.getItem(i7) == this.f6906b) {
                            return;
                        }
                    }
                }
                e(this.f6905a, this.f6906b);
            }
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean e(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            KeyEvent.Callback callback = Toolbar.this.f6883i;
            if (callback instanceof InterfaceC2246b) {
                ((InterfaceC2246b) callback).e();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f6883i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f6882h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f6883i = null;
            toolbar3.a();
            this.f6906b = null;
            Toolbar.this.requestLayout();
            eVar.q(false);
            Toolbar.this.N();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean g(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f6882h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f6882h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f6882h);
            }
            Toolbar.this.f6883i = eVar.getActionView();
            this.f6906b = eVar;
            ViewParent parent2 = Toolbar.this.f6883i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f6883i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f14980a = (toolbar4.f6888n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f6908b = 2;
                toolbar4.f6883i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f6883i);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            eVar.q(true);
            KeyEvent.Callback callback = Toolbar.this.f6883i;
            if (callback instanceof InterfaceC2246b) {
                ((InterfaceC2246b) callback).b();
            }
            Toolbar.this.N();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public void i(Context context, androidx.appcompat.view.menu.d dVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.d dVar2 = this.f6905a;
            if (dVar2 != null && (eVar = this.f6906b) != null) {
                dVar2.e(eVar);
            }
            this.f6905a = dVar;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean k(j jVar) {
            return false;
        }
    }

    public interface h {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1656a.f14354u);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i7 = 0; i7 < menu.size(); i7++) {
            arrayList.add(menu.getItem(i7));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new C2248d(getContext());
    }

    public final int A(View view, int i7, int[] iArr, int i8) {
        g gVar = (g) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i7 + Math.max(0, i9);
        iArr[0] = Math.max(0, -i9);
        int iQ = q(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    public final int B(View view, int i7, int[] iArr, int i8) {
        g gVar = (g) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i7 - Math.max(0, i9);
        iArr[1] = Math.max(0, -i9);
        int iQ = q(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public final int C(View view, int i7, int i8, int i9, int i10, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i11 = marginLayoutParams.leftMargin - iArr[0];
        int i12 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i11) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i11);
        iArr[1] = Math.max(0, -i12);
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + iMax + i8, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i9, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void D(View view, int i7, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i9, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i11 >= 0) {
            if (mode != 0) {
                i11 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i11);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void E() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f6862G.b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f6863H = currentMenuItems2;
    }

    public final void F() {
        removeCallbacks(this.f6874S);
        post(this.f6874S);
    }

    public void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f6908b != 2 && childAt != this.f6875a) {
                removeViewAt(childCount);
                this.f6860E.add(childAt);
            }
        }
    }

    public void H(int i7, int i8) {
        f();
        this.f6894t.g(i7, i8);
    }

    public void I(Context context, int i7) {
        this.f6887m = i7;
        TextView textView = this.f6877c;
        if (textView != null) {
            textView.setTextAppearance(context, i7);
        }
    }

    public void J(Context context, int i7) {
        this.f6886l = i7;
        TextView textView = this.f6876b;
        if (textView != null) {
            textView.setTextAppearance(context, i7);
        }
    }

    public final boolean K() {
        if (!this.f6870O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (L(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean L(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean M() {
        ActionMenuView actionMenuView = this.f6875a;
        return actionMenuView != null && actionMenuView.M();
    }

    public void N() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z7 = v() && onBackInvokedDispatcherA != null && N.O(this) && this.f6873R;
            if (z7 && this.f6872Q == null) {
                if (this.f6871P == null) {
                    this.f6871P = e.b(new Runnable() { // from class: p.T
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21305a.d();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.f6871P);
                this.f6872Q = onBackInvokedDispatcherA;
                return;
            }
            if (z7 || (onBackInvokedDispatcher = this.f6872Q) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.f6871P);
            this.f6872Q = null;
        }
    }

    public void a() {
        for (int size = this.f6860E.size() - 1; size >= 0; size--) {
            addView((View) this.f6860E.get(size));
        }
        this.f6860E.clear();
    }

    public final void b(List list, int i7) {
        boolean z7 = N.z(this) == 1;
        int childCount = getChildCount();
        int iB = AbstractC0677s.b(i7, N.z(this));
        list.clear();
        if (!z7) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f6908b == 0 && L(childAt) && p(gVar.f14980a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i9 = childCount - 1; i9 >= 0; i9--) {
            View childAt2 = getChildAt(i9);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f6908b == 0 && L(childAt2) && p(gVar2.f14980a) == iB) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z7) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f6908b = 1;
        if (!z7 || this.f6883i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f6860E.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public void d() {
        f fVar = this.f6867L;
        androidx.appcompat.view.menu.e eVar = fVar == null ? null : fVar.f6906b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }

    public void e() {
        if (this.f6882h == null) {
            C2352m c2352m = new C2352m(getContext(), null, AbstractC1656a.f14353t);
            this.f6882h = c2352m;
            c2352m.setImageDrawable(this.f6880f);
            this.f6882h.setContentDescription(this.f6881g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f14980a = (this.f6888n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f6908b = 2;
            this.f6882h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f6882h.setOnClickListener(new d());
        }
    }

    public final void f() {
        if (this.f6894t == null) {
            this.f6894t = new L();
        }
    }

    @Override // Q.InterfaceC0681w
    public void g(InterfaceC0684z interfaceC0684z) {
        this.f6862G.a(interfaceC0684z);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f6882h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f6882h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        L l7 = this.f6894t;
        if (l7 != null) {
            return l7.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i7 = this.f6896v;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        L l7 = this.f6894t;
        if (l7 != null) {
            return l7.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        L l7 = this.f6894t;
        if (l7 != null) {
            return l7.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        L l7 = this.f6894t;
        if (l7 != null) {
            return l7.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i7 = this.f6895u;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.d dVarK;
        ActionMenuView actionMenuView = this.f6875a;
        return (actionMenuView == null || (dVarK = actionMenuView.K()) == null || !dVarK.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f6896v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return N.z(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return N.z(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f6895u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f6879e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f6879e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        i();
        return this.f6875a.getMenu();
    }

    public View getNavButtonView() {
        return this.f6878d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f6878d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f6878d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.f6866K;
    }

    public Drawable getOverflowIcon() {
        i();
        return this.f6875a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f6884j;
    }

    public int getPopupTheme() {
        return this.f6885k;
    }

    public CharSequence getSubtitle() {
        return this.f6899y;
    }

    public final TextView getSubtitleTextView() {
        return this.f6877c;
    }

    public CharSequence getTitle() {
        return this.f6898x;
    }

    public int getTitleMarginBottom() {
        return this.f6893s;
    }

    public int getTitleMarginEnd() {
        return this.f6891q;
    }

    public int getTitleMarginStart() {
        return this.f6890p;
    }

    public int getTitleMarginTop() {
        return this.f6892r;
    }

    public final TextView getTitleTextView() {
        return this.f6876b;
    }

    public InterfaceC2362x getWrapper() {
        if (this.f6865J == null) {
            this.f6865J = new androidx.appcompat.widget.d(this, true);
        }
        return this.f6865J;
    }

    public final void h() {
        if (this.f6879e == null) {
            this.f6879e = new C2354o(getContext());
        }
    }

    public final void i() {
        j();
        if (this.f6875a.K() == null) {
            androidx.appcompat.view.menu.d dVar = (androidx.appcompat.view.menu.d) this.f6875a.getMenu();
            if (this.f6867L == null) {
                this.f6867L = new f();
            }
            this.f6875a.setExpandedActionViewsExclusive(true);
            dVar.b(this.f6867L, this.f6884j);
            N();
        }
    }

    public final void j() {
        if (this.f6875a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f6875a = actionMenuView;
            actionMenuView.setPopupTheme(this.f6885k);
            this.f6875a.setOnMenuItemClickListener(this.f6864I);
            this.f6875a.L(this.f6868M, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f14980a = (this.f6888n & 112) | 8388613;
            this.f6875a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f6875a, false);
        }
    }

    public final void k() {
        if (this.f6878d == null) {
            this.f6878d = new C2352m(getContext(), null, AbstractC1656a.f14353t);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f14980a = (this.f6888n & 112) | 8388611;
            this.f6878d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof AbstractC1733a ? new g((AbstractC1733a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // Q.InterfaceC0681w
    public void o(InterfaceC0684z interfaceC0684z) {
        this.f6862G.f(interfaceC0684z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f6874S);
        N();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f6858C = false;
        }
        if (!this.f6858C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f6858C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f6858C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.f6861F;
        boolean zA = c0.a(this);
        int i9 = !zA ? 1 : 0;
        if (L(this.f6878d)) {
            D(this.f6878d, i7, 0, i8, 0, this.f6889o);
            measuredWidth = this.f6878d.getMeasuredWidth() + s(this.f6878d);
            iMax = Math.max(0, this.f6878d.getMeasuredHeight() + t(this.f6878d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f6878d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (L(this.f6882h)) {
            D(this.f6882h, i7, 0, i8, 0, this.f6889o);
            measuredWidth = this.f6882h.getMeasuredWidth() + s(this.f6882h);
            iMax = Math.max(iMax, this.f6882h.getMeasuredHeight() + t(this.f6882h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6882h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zA ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (L(this.f6875a)) {
            D(this.f6875a, i7, iMax3, i8, 0, this.f6889o);
            measuredWidth2 = this.f6875a.getMeasuredWidth() + s(this.f6875a);
            iMax = Math.max(iMax, this.f6875a.getMeasuredHeight() + t(this.f6875a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6875a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i9] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (L(this.f6883i)) {
            iMax4 += C(this.f6883i, i7, iMax4, i8, 0, iArr);
            iMax = Math.max(iMax, this.f6883i.getMeasuredHeight() + t(this.f6883i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6883i.getMeasuredState());
        }
        if (L(this.f6879e)) {
            iMax4 += C(this.f6879e, i7, iMax4, i8, 0, iArr);
            iMax = Math.max(iMax, this.f6879e.getMeasuredHeight() + t(this.f6879e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6879e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((g) childAt.getLayoutParams()).f6908b == 0 && L(childAt)) {
                iMax4 += C(childAt, i7, iMax4, i8, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i11 = this.f6892r + this.f6893s;
        int i12 = this.f6890p + this.f6891q;
        if (L(this.f6876b)) {
            C(this.f6876b, i7, iMax4 + i12, i8, i11, iArr);
            int measuredWidth3 = this.f6876b.getMeasuredWidth() + s(this.f6876b);
            measuredHeight = this.f6876b.getMeasuredHeight() + t(this.f6876b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f6876b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (L(this.f6877c)) {
            iMax2 = Math.max(iMax2, C(this.f6877c, i7, iMax4 + i12, i8, measuredHeight + i11, iArr));
            measuredHeight += this.f6877c.getMeasuredHeight() + t(this.f6877c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f6877c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i7, (-16777216) & iCombineMeasuredStates2), K() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i8, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        ActionMenuView actionMenuView = this.f6875a;
        androidx.appcompat.view.menu.d dVarK = actionMenuView != null ? actionMenuView.K() : null;
        int i7 = iVar.f6909c;
        if (i7 != 0 && this.f6867L != null && dVarK != null && (menuItemFindItem = dVarK.findItem(i7)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f6910d) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i7) {
        super.onRtlPropertiesChanged(i7);
        f();
        this.f6894t.f(i7 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.e eVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f6867L;
        if (fVar != null && (eVar = fVar.f6906b) != null) {
            iVar.f6909c = eVar.getItemId();
        }
        iVar.f6910d = z();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6857B = false;
        }
        if (!this.f6857B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f6857B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f6857B = false;
        }
        return true;
    }

    public final int p(int i7) {
        int iZ = N.z(this);
        int iB = AbstractC0677s.b(i7, iZ) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : iZ == 1 ? 5 : 3;
    }

    public final int q(View view, int i7) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i7 > 0 ? (measuredHeight - i7) / 2 : 0;
        int iR = r(gVar.f14980a);
        if (iR == 48) {
            return getPaddingTop() - i8;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i8;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i9) {
            iMax = i9;
        } else {
            int i10 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i11 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i10 < i11) {
                iMax = Math.max(0, iMax - (i11 - i10));
            }
        }
        return paddingTop + iMax;
    }

    public final int r(int i7) {
        int i8 = i7 & 112;
        return (i8 == 16 || i8 == 48 || i8 == 80) ? i8 : this.f6897w & 112;
    }

    public final int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0680v.b(marginLayoutParams) + AbstractC0680v.a(marginLayoutParams);
    }

    public void setBackInvokedCallbackEnabled(boolean z7) {
        if (this.f6873R != z7) {
            this.f6873R = z7;
            N();
        }
    }

    public void setCollapseContentDescription(int i7) {
        setCollapseContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setCollapseIcon(int i7) {
        setCollapseIcon(AbstractC2040a.b(getContext(), i7));
    }

    public void setCollapsible(boolean z7) {
        this.f6870O = z7;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.f6896v) {
            this.f6896v = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.f6895u) {
            this.f6895u = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i7) {
        setLogo(AbstractC2040a.b(getContext(), i7));
    }

    public void setLogoDescription(int i7) {
        setLogoDescription(getContext().getText(i7));
    }

    public void setNavigationContentDescription(int i7) {
        setNavigationContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setNavigationIcon(int i7) {
        setNavigationIcon(AbstractC2040a.b(getContext(), i7));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        k();
        this.f6878d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        i();
        this.f6875a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i7) {
        if (this.f6885k != i7) {
            this.f6885k = i7;
            if (i7 == 0) {
                this.f6884j = getContext();
            } else {
                this.f6884j = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    public void setSubtitle(int i7) {
        setSubtitle(getContext().getText(i7));
    }

    public void setSubtitleTextColor(int i7) {
        setSubtitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setTitle(int i7) {
        setTitle(getContext().getText(i7));
    }

    public void setTitleMarginBottom(int i7) {
        this.f6893s = i7;
        requestLayout();
    }

    public void setTitleMarginEnd(int i7) {
        this.f6891q = i7;
        requestLayout();
    }

    public void setTitleMarginStart(int i7) {
        this.f6890p = i7;
        requestLayout();
    }

    public void setTitleMarginTop(int i7) {
        this.f6892r = i7;
        requestLayout();
    }

    public void setTitleTextColor(int i7) {
        setTitleTextColor(ColorStateList.valueOf(i7));
    }

    public final int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int u(List list, int[] iArr) {
        int i7 = iArr[0];
        int i8 = iArr[1];
        int size = list.size();
        int i9 = 0;
        int measuredWidth = 0;
        while (i9 < size) {
            View view = (View) list.get(i9);
            g gVar = (g) view.getLayoutParams();
            int i10 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i7;
            int i11 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i8;
            int iMax = Math.max(0, i10);
            int iMax2 = Math.max(0, i11);
            int iMax3 = Math.max(0, -i10);
            int iMax4 = Math.max(0, -i11);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i9++;
            i8 = iMax4;
            i7 = iMax3;
        }
        return measuredWidth;
    }

    public boolean v() {
        f fVar = this.f6867L;
        return (fVar == null || fVar.f6906b == null) ? false : true;
    }

    public void w(int i7) {
        getMenuInflater().inflate(i7, getMenu());
    }

    public void x() {
        Iterator it = this.f6863H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        E();
    }

    public final boolean y(View view) {
        return view.getParent() == this || this.f6860E.contains(view);
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f6875a;
        return actionMenuView != null && actionMenuView.H();
    }

    public static class g extends AbstractC1733a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6908b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6908b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i7, int i8) {
            super(i7, i8);
            this.f6908b = 0;
            this.f14980a = 8388627;
        }

        public g(g gVar) {
            super((AbstractC1733a) gVar);
            this.f6908b = 0;
            this.f6908b = gVar.f6908b;
        }

        public g(AbstractC1733a abstractC1733a) {
            super(abstractC1733a);
            this.f6908b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6908b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6908b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6897w = 8388627;
        this.f6859D = new ArrayList();
        this.f6860E = new ArrayList();
        this.f6861F = new int[2];
        this.f6862G = new C0682x(new Runnable() { // from class: p.U
            @Override // java.lang.Runnable
            public final void run() {
                this.f21306a.x();
            }
        });
        this.f6863H = new ArrayList();
        this.f6864I = new a();
        this.f6874S = new b();
        S sT = S.t(getContext(), attributeSet, AbstractC1664i.f14665t2, i7, 0);
        N.j0(this, context, AbstractC1664i.f14665t2, attributeSet, sT.p(), i7, 0);
        this.f6886l = sT.m(AbstractC1664i.f14563V2, 0);
        this.f6887m = sT.m(AbstractC1664i.f14527M2, 0);
        this.f6897w = sT.k(AbstractC1664i.f14669u2, this.f6897w);
        this.f6888n = sT.k(AbstractC1664i.f14673v2, 48);
        int iE = sT.e(AbstractC1664i.f14539P2, 0);
        iE = sT.q(AbstractC1664i.f14559U2) ? sT.e(AbstractC1664i.f14559U2, iE) : iE;
        this.f6893s = iE;
        this.f6892r = iE;
        this.f6891q = iE;
        this.f6890p = iE;
        int iE2 = sT.e(AbstractC1664i.f14551S2, -1);
        if (iE2 >= 0) {
            this.f6890p = iE2;
        }
        int iE3 = sT.e(AbstractC1664i.f14547R2, -1);
        if (iE3 >= 0) {
            this.f6891q = iE3;
        }
        int iE4 = sT.e(AbstractC1664i.f14555T2, -1);
        if (iE4 >= 0) {
            this.f6892r = iE4;
        }
        int iE5 = sT.e(AbstractC1664i.f14543Q2, -1);
        if (iE5 >= 0) {
            this.f6893s = iE5;
        }
        this.f6889o = sT.f(AbstractC1664i.f14503G2, -1);
        int iE6 = sT.e(AbstractC1664i.f14487C2, Integer.MIN_VALUE);
        int iE7 = sT.e(AbstractC1664i.f14685y2, Integer.MIN_VALUE);
        int iF = sT.f(AbstractC1664i.f14479A2, 0);
        int iF2 = sT.f(AbstractC1664i.f14483B2, 0);
        f();
        this.f6894t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f6894t.g(iE6, iE7);
        }
        this.f6895u = sT.e(AbstractC1664i.f14491D2, Integer.MIN_VALUE);
        this.f6896v = sT.e(AbstractC1664i.f14689z2, Integer.MIN_VALUE);
        this.f6880f = sT.g(AbstractC1664i.f14681x2);
        this.f6881g = sT.o(AbstractC1664i.f14677w2);
        CharSequence charSequenceO = sT.o(AbstractC1664i.f14535O2);
        if (!TextUtils.isEmpty(charSequenceO)) {
            setTitle(charSequenceO);
        }
        CharSequence charSequenceO2 = sT.o(AbstractC1664i.f14523L2);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            setSubtitle(charSequenceO2);
        }
        this.f6884j = getContext();
        setPopupTheme(sT.m(AbstractC1664i.f14519K2, 0));
        Drawable drawableG = sT.g(AbstractC1664i.f14515J2);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceO3 = sT.o(AbstractC1664i.f14511I2);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            setNavigationContentDescription(charSequenceO3);
        }
        Drawable drawableG2 = sT.g(AbstractC1664i.f14495E2);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceO4 = sT.o(AbstractC1664i.f14499F2);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            setLogoDescription(charSequenceO4);
        }
        if (sT.q(AbstractC1664i.f14567W2)) {
            setTitleTextColor(sT.c(AbstractC1664i.f14567W2));
        }
        if (sT.q(AbstractC1664i.f14531N2)) {
            setSubtitleTextColor(sT.c(AbstractC1664i.f14531N2));
        }
        if (sT.q(AbstractC1664i.f14507H2)) {
            w(sT.m(AbstractC1664i.f14507H2, 0));
        }
        sT.u();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f6882h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            this.f6882h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f6882h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f6880f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            h();
            if (!y(this.f6879e)) {
                c(this.f6879e, true);
            }
        } else {
            ImageView imageView = this.f6879e;
            if (imageView != null && y(imageView)) {
                removeView(this.f6879e);
                this.f6860E.remove(this.f6879e);
            }
        }
        ImageView imageView2 = this.f6879e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        ImageView imageView = this.f6879e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            k();
        }
        ImageButton imageButton = this.f6878d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            W.a(this.f6878d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            k();
            if (!y(this.f6878d)) {
                c(this.f6878d, true);
            }
        } else {
            ImageButton imageButton = this.f6878d;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f6878d);
                this.f6860E.remove(this.f6878d);
            }
        }
        ImageButton imageButton2 = this.f6878d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f6877c;
            if (textView != null && y(textView)) {
                removeView(this.f6877c);
                this.f6860E.remove(this.f6877c);
            }
        } else {
            if (this.f6877c == null) {
                Context context = getContext();
                C2358t c2358t = new C2358t(context);
                this.f6877c = c2358t;
                c2358t.setSingleLine();
                this.f6877c.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f6887m;
                if (i7 != 0) {
                    this.f6877c.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.f6856A;
                if (colorStateList != null) {
                    this.f6877c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f6877c)) {
                c(this.f6877c, true);
            }
        }
        TextView textView2 = this.f6877c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f6899y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f6856A = colorStateList;
        TextView textView = this.f6877c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f6876b;
            if (textView != null && y(textView)) {
                removeView(this.f6876b);
                this.f6860E.remove(this.f6876b);
            }
        } else {
            if (this.f6876b == null) {
                Context context = getContext();
                C2358t c2358t = new C2358t(context);
                this.f6876b = c2358t;
                c2358t.setSingleLine();
                this.f6876b.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f6886l;
                if (i7 != 0) {
                    this.f6876b.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.f6900z;
                if (colorStateList != null) {
                    this.f6876b.setTextColor(colorStateList);
                }
            }
            if (!y(this.f6876b)) {
                c(this.f6876b, true);
            }
        }
        TextView textView2 = this.f6876b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f6898x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f6900z = colorStateList;
        TextView textView = this.f6876b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class i extends Z.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6910d;

        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i7) {
                return new i[i7];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6909c = parcel.readInt();
            this.f6910d = parcel.readInt() != 0;
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f6909c);
            parcel.writeInt(this.f6910d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
