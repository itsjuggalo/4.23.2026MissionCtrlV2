package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import o.e0;
import o.j0;
import o.n0;
import o.o;
import o.q;
import o.t0;
import t0.c0;
import t0.k;
import t0.n;
import t0.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements k {
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public final ArrayList D;
    public final ArrayList E;
    public final int[] F;
    public final n G;
    public ArrayList H;
    public final ActionMenuView.e I;
    public androidx.appcompat.widget.d Q;
    public androidx.appcompat.widget.a R;
    public f S;
    public g.a T;
    public d.a U;
    public boolean V;
    public OnBackInvokedCallback W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f1234a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public OnBackInvokedDispatcher f1235a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1236b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1237b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1238c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Runnable f1239c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f1240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f1241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f1243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f1244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f1245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f1246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1254r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1255s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e0 f1256t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1257u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1258v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1259w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f1260x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f1261y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f1262z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.G.h(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.K();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements d.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            d.a aVar = Toolbar.this.U;
            return aVar != null && aVar.a(dVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void b(androidx.appcompat.view.menu.d dVar) {
            if (!Toolbar.this.f1234a.D()) {
                Toolbar.this.G.i(dVar);
            }
            d.a aVar = Toolbar.this.U;
            if (aVar != null) {
                aVar.b(dVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: o.m0
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface h {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.f9676r);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new m.c(getContext());
    }

    public final int A(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void B(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void C() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.G.f(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    public final void D() {
        removeCallbacks(this.f1239c0);
        post(this.f1239c0);
    }

    public void E() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f1270b != 2 && childAt != this.f1234a) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public void F(int i10, int i11) {
        f();
        this.f1256t.g(i10, i11);
    }

    public void G(Context context, int i10) {
        this.f1249m = i10;
        TextView textView = this.f1238c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void H(Context context, int i10) {
        this.f1248l = i10;
        TextView textView = this.f1236b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public final boolean I() {
        if (!this.V) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (J(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean J(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean K() {
        ActionMenuView actionMenuView = this.f1234a;
        return actionMenuView != null && actionMenuView.I();
    }

    public void L() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z10 = t() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f1237b0;
            if (z10 && this.f1235a0 == null) {
                if (this.W == null) {
                    this.W = e.b(new Runnable() { // from class: o.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17291a.d();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.W);
                this.f1235a0 = onBackInvokedDispatcherA;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.f1235a0) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.W);
            this.f1235a0 = null;
        }
    }

    public void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView((View) this.E.get(size));
        }
        this.E.clear();
    }

    @Override // t0.k
    public void addMenuProvider(p pVar) {
        this.G.c(pVar);
    }

    public final void b(List list, int i10) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iA = t0.h.a(i10, getLayoutDirection());
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1270b == 0 && J(childAt) && n(gVar.f10789a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f1270b == 0 && J(childAt2) && n(gVar2.f10789a) == iA) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f1270b = 1;
        if (!z10 || this.f1245i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.E.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public void d() {
        f fVar = this.S;
        androidx.appcompat.view.menu.e eVar = fVar == null ? null : fVar.f1268b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }

    public void e() {
        if (this.f1244h == null) {
            o.i iVar = new o.i(getContext(), null, g.a.f9675q);
            this.f1244h = iVar;
            iVar.setImageDrawable(this.f1242f);
            this.f1244h.setContentDescription(this.f1243g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f10789a = (this.f1250n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f1270b = 2;
            this.f1244h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f1244h.setOnClickListener(new d());
        }
    }

    public final void f() {
        if (this.f1256t == null) {
            this.f1256t = new e0();
        }
    }

    public final void g() {
        if (this.f1241e == null) {
            this.f1241e = new o.k(getContext());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1244h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1244h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        e0 e0Var = this.f1256t;
        if (e0Var != null) {
            return e0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f1258v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        e0 e0Var = this.f1256t;
        if (e0Var != null) {
            return e0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        e0 e0Var = this.f1256t;
        if (e0Var != null) {
            return e0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        e0 e0Var = this.f1256t;
        if (e0Var != null) {
            return e0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f1257u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.d dVarG;
        ActionMenuView actionMenuView = this.f1234a;
        return (actionMenuView == null || (dVarG = actionMenuView.G()) == null || !dVarG.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f1258v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1257u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1241e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1241e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        h();
        return this.f1234a.getMenu();
    }

    public View getNavButtonView() {
        return this.f1240d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1240d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1240d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.R;
    }

    public Drawable getOverflowIcon() {
        h();
        return this.f1234a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1246j;
    }

    public int getPopupTheme() {
        return this.f1247k;
    }

    public CharSequence getSubtitle() {
        return this.f1261y;
    }

    public final TextView getSubtitleTextView() {
        return this.f1238c;
    }

    public CharSequence getTitle() {
        return this.f1260x;
    }

    public int getTitleMarginBottom() {
        return this.f1255s;
    }

    public int getTitleMarginEnd() {
        return this.f1253q;
    }

    public int getTitleMarginStart() {
        return this.f1252p;
    }

    public int getTitleMarginTop() {
        return this.f1254r;
    }

    public final TextView getTitleTextView() {
        return this.f1236b;
    }

    public q getWrapper() {
        if (this.Q == null) {
            this.Q = new androidx.appcompat.widget.d(this, true);
        }
        return this.Q;
    }

    public final void h() {
        i();
        if (this.f1234a.G() == null) {
            androidx.appcompat.view.menu.d dVar = (androidx.appcompat.view.menu.d) this.f1234a.getMenu();
            if (this.S == null) {
                this.S = new f();
            }
            this.f1234a.setExpandedActionViewsExclusive(true);
            dVar.b(this.S, this.f1246j);
            L();
        }
    }

    public final void i() {
        if (this.f1234a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1234a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1247k);
            this.f1234a.setOnMenuItemClickListener(this.I);
            this.f1234a.H(this.T, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f10789a = (this.f1250n & 112) | 8388613;
            this.f1234a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f1234a, false);
        }
    }

    public final void j() {
        if (this.f1240d == null) {
            this.f1240d = new o.i(getContext(), null, g.a.f9675q);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f10789a = (this.f1250n & 112) | 8388611;
            this.f1240d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof h.a ? new g((h.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public final int n(int i10) {
        int layoutDirection = getLayoutDirection();
        int iA = t0.h.a(i10, layoutDirection) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : layoutDirection == 1 ? 5 : 3;
    }

    public final int o(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int iP = p(gVar.f10789a);
        if (iP == 48) {
            return getPaddingTop() - i11;
        }
        if (iP == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        L();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1239c0);
        L();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0297 A[LOOP:0: B:104:0x0295->B:105:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b5 A[LOOP:1: B:107:0x02b3->B:108:0x02b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ec A[LOOP:2: B:116:0x02ea->B:117:0x02ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.F;
        boolean zA = t0.a(this);
        int i12 = !zA ? 1 : 0;
        if (J(this.f1240d)) {
            B(this.f1240d, i10, 0, i11, 0, this.f1251o);
            measuredWidth = this.f1240d.getMeasuredWidth() + q(this.f1240d);
            iMax = Math.max(0, this.f1240d.getMeasuredHeight() + r(this.f1240d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1240d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (J(this.f1244h)) {
            B(this.f1244h, i10, 0, i11, 0, this.f1251o);
            measuredWidth = this.f1244h.getMeasuredWidth() + q(this.f1244h);
            iMax = Math.max(iMax, this.f1244h.getMeasuredHeight() + r(this.f1244h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1244h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zA ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (J(this.f1234a)) {
            B(this.f1234a, i10, iMax3, i11, 0, this.f1251o);
            measuredWidth2 = this.f1234a.getMeasuredWidth() + q(this.f1234a);
            iMax = Math.max(iMax, this.f1234a.getMeasuredHeight() + r(this.f1234a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1234a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i12] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (J(this.f1245i)) {
            iArr = iArr2;
            iMax4 += A(this.f1245i, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f1245i.getMeasuredHeight() + r(this.f1245i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1245i.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (J(this.f1241e)) {
            iMax4 += A(this.f1241e, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f1241e.getMeasuredHeight() + r(this.f1241e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1241e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((g) childAt.getLayoutParams()).f1270b == 0 && J(childAt)) {
                iMax4 += A(childAt, i10, iMax4, i11, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + r(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i14 = iMax4;
        int i15 = this.f1254r + this.f1255s;
        int i16 = this.f1252p + this.f1253q;
        if (J(this.f1236b)) {
            A(this.f1236b, i10, i14 + i16, i11, i15, iArr);
            int measuredWidth3 = this.f1236b.getMeasuredWidth() + q(this.f1236b);
            int measuredHeight2 = this.f1236b.getMeasuredHeight() + r(this.f1236b);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1236b.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (J(this.f1238c)) {
            iMax2 = Math.max(iMax2, A(this.f1238c, i10, i14 + i16, i11, i15 + measuredHeight, iArr));
            measuredHeight += this.f1238c.getMeasuredHeight() + r(this.f1238c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1238c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i14 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2), I() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
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
        ActionMenuView actionMenuView = this.f1234a;
        androidx.appcompat.view.menu.d dVarG = actionMenuView != null ? actionMenuView.G() : null;
        int i10 = iVar.f1271c;
        if (i10 != 0 && this.S != null && dVarG != null && (menuItemFindItem = dVarG.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f1272d) {
            D();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        f();
        this.f1256t.f(i10 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.e eVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.S;
        if (fVar != null && (eVar = fVar.f1268b) != null) {
            iVar.f1271c = eVar.getItemId();
        }
        iVar.f1272d = x();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public final int p(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f1259w & 112;
    }

    public final int q(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    public final int r(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // t0.k
    public void removeMenuProvider(p pVar) {
        this.G.j(pVar);
    }

    public final int s(List list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int measuredWidth = 0;
        while (i12 < size) {
            View view = (View) list.get(i12);
            g gVar = (g) view.getLayoutParams();
            int i13 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i10;
            int i14 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i11;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, i14);
            int iMax3 = Math.max(0, -i13);
            int iMax4 = Math.max(0, -i14);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i12++;
            i11 = iMax4;
            i10 = iMax3;
        }
        return measuredWidth;
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f1237b0 != z10) {
            this.f1237b0 = z10;
            L();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(i.a.b(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.V = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f1258v) {
            this.f1258v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f1257u) {
            this.f1257u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(i.a.b(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(i.a.b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        j();
        this.f1240d.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.f1234a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f1247k != i10) {
            this.f1247k = i10;
            if (i10 == 0) {
                this.f1246j = getContext();
            } else {
                this.f1246j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f1255s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f1253q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f1252p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f1254r = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public boolean t() {
        f fVar = this.S;
        return (fVar == null || fVar.f1268b == null) ? false : true;
    }

    public void u(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public void v() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        C();
    }

    public final boolean w(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public boolean x() {
        ActionMenuView actionMenuView = this.f1234a;
        return actionMenuView != null && actionMenuView.D();
    }

    public final int y(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int iO = o(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iO, iMax + measuredWidth, view.getMeasuredHeight() + iO);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    public final int z(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iO = o(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iO, iMax, view.getMeasuredHeight() + iO);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g extends h.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1270b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1270b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i10, int i11) {
            super(i10, i11);
            this.f1270b = 0;
            this.f10789a = 8388627;
        }

        public g(g gVar) {
            super((h.a) gVar);
            this.f1270b = 0;
            this.f1270b = gVar.f1270b;
        }

        public g(h.a aVar) {
            super(aVar);
            this.f1270b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1270b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1270b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1259w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new n(new Runnable() { // from class: o.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17294a.v();
            }
        });
        this.H = new ArrayList();
        this.I = new a();
        this.f1239c0 = new b();
        j0 j0VarS = j0.s(getContext(), attributeSet, g.i.Y1, i10, 0);
        c0.I(this, context, g.i.Y1, attributeSet, j0VarS.o(), i10, 0);
        this.f1248l = j0VarS.l(g.i.A2, 0);
        this.f1249m = j0VarS.l(g.i.f9833r2, 0);
        this.f1259w = j0VarS.j(g.i.Z1, this.f1259w);
        this.f1250n = j0VarS.j(g.i.f9765a2, 48);
        int iD = j0VarS.d(g.i.f9845u2, 0);
        iD = j0VarS.p(g.i.f9865z2) ? j0VarS.d(g.i.f9865z2, iD) : iD;
        this.f1255s = iD;
        this.f1254r = iD;
        this.f1253q = iD;
        this.f1252p = iD;
        int iD2 = j0VarS.d(g.i.f9857x2, -1);
        if (iD2 >= 0) {
            this.f1252p = iD2;
        }
        int iD3 = j0VarS.d(g.i.f9853w2, -1);
        if (iD3 >= 0) {
            this.f1253q = iD3;
        }
        int iD4 = j0VarS.d(g.i.f9861y2, -1);
        if (iD4 >= 0) {
            this.f1254r = iD4;
        }
        int iD5 = j0VarS.d(g.i.f9849v2, -1);
        if (iD5 >= 0) {
            this.f1255s = iD5;
        }
        this.f1251o = j0VarS.e(g.i.f9809l2, -1);
        int iD6 = j0VarS.d(g.i.f9793h2, Integer.MIN_VALUE);
        int iD7 = j0VarS.d(g.i.f9777d2, Integer.MIN_VALUE);
        int iE = j0VarS.e(g.i.f9785f2, 0);
        int iE2 = j0VarS.e(g.i.f9789g2, 0);
        f();
        this.f1256t.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f1256t.g(iD6, iD7);
        }
        this.f1257u = j0VarS.d(g.i.f9797i2, Integer.MIN_VALUE);
        this.f1258v = j0VarS.d(g.i.f9781e2, Integer.MIN_VALUE);
        this.f1242f = j0VarS.f(g.i.f9773c2);
        this.f1243g = j0VarS.n(g.i.f9769b2);
        CharSequence charSequenceN = j0VarS.n(g.i.f9841t2);
        if (!TextUtils.isEmpty(charSequenceN)) {
            setTitle(charSequenceN);
        }
        CharSequence charSequenceN2 = j0VarS.n(g.i.f9829q2);
        if (!TextUtils.isEmpty(charSequenceN2)) {
            setSubtitle(charSequenceN2);
        }
        this.f1246j = getContext();
        setPopupTheme(j0VarS.l(g.i.f9825p2, 0));
        Drawable drawableF = j0VarS.f(g.i.f9821o2);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceN3 = j0VarS.n(g.i.f9817n2);
        if (!TextUtils.isEmpty(charSequenceN3)) {
            setNavigationContentDescription(charSequenceN3);
        }
        Drawable drawableF2 = j0VarS.f(g.i.f9801j2);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceN4 = j0VarS.n(g.i.f9805k2);
        if (!TextUtils.isEmpty(charSequenceN4)) {
            setLogoDescription(charSequenceN4);
        }
        if (j0VarS.p(g.i.B2)) {
            setTitleTextColor(j0VarS.c(g.i.B2));
        }
        if (j0VarS.p(g.i.f9837s2)) {
            setSubtitleTextColor(j0VarS.c(g.i.f9837s2));
        }
        if (j0VarS.p(g.i.f9813m2)) {
            u(j0VarS.l(g.i.f9813m2, 0));
        }
        j0VarS.u();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f1244h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            this.f1244h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1244h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1242f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!w(this.f1241e)) {
                c(this.f1241e, true);
            }
        } else {
            ImageView imageView = this.f1241e;
            if (imageView != null && w(imageView)) {
                removeView(this.f1241e);
                this.E.remove(this.f1241e);
            }
        }
        ImageView imageView2 = this.f1241e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageView imageView = this.f1241e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageButton imageButton = this.f1240d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            n0.a(this.f1240d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!w(this.f1240d)) {
                c(this.f1240d, true);
            }
        } else {
            ImageButton imageButton = this.f1240d;
            if (imageButton != null && w(imageButton)) {
                removeView(this.f1240d);
                this.E.remove(this.f1240d);
            }
        }
        ImageButton imageButton2 = this.f1240d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1238c;
            if (textView != null && w(textView)) {
                removeView(this.f1238c);
                this.E.remove(this.f1238c);
            }
        } else {
            if (this.f1238c == null) {
                Context context = getContext();
                o oVar = new o(context);
                this.f1238c = oVar;
                oVar.setSingleLine();
                this.f1238c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1249m;
                if (i10 != 0) {
                    this.f1238c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1238c.setTextColor(colorStateList);
                }
            }
            if (!w(this.f1238c)) {
                c(this.f1238c, true);
            }
        }
        TextView textView2 = this.f1238c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1261y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1238c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1236b;
            if (textView != null && w(textView)) {
                removeView(this.f1236b);
                this.E.remove(this.f1236b);
            }
        } else {
            if (this.f1236b == null) {
                Context context = getContext();
                o oVar = new o(context);
                this.f1236b = oVar;
                oVar.setSingleLine();
                this.f1236b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1248l;
                if (i10 != 0) {
                    this.f1236b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f1262z;
                if (colorStateList != null) {
                    this.f1236b.setTextColor(colorStateList);
                }
            }
            if (!w(this.f1236b)) {
                c(this.f1236b, true);
            }
        }
        TextView textView2 = this.f1236b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1260x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1262z = colorStateList;
        TextView textView = this.f1236b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i extends j1.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1272d;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            public i[] newArray(int i10) {
                return new i[i10];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1271c = parcel.readInt();
            this.f1272d = parcel.readInt() != 0;
        }

        @Override // j1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1271c);
            parcel.writeInt(this.f1272d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements androidx.appcompat.view.menu.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f1267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f1268b;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.g
        public void b(boolean z10) {
            if (this.f1268b != null) {
                androidx.appcompat.view.menu.d dVar = this.f1267a;
                if (dVar != null) {
                    int size = dVar.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f1267a.getItem(i10) == this.f1268b) {
                            return;
                        }
                    }
                }
                d(this.f1267a, this.f1268b);
            }
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean d(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1245i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1244h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1245i = null;
            toolbar3.a();
            this.f1268b = null;
            Toolbar.this.requestLayout();
            eVar.q(false);
            Toolbar.this.L();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean f(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f1244h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1244h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1244h);
            }
            Toolbar.this.f1245i = eVar.getActionView();
            this.f1268b = eVar;
            ViewParent parent2 = Toolbar.this.f1245i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1245i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f10789a = (toolbar4.f1250n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f1270b = 2;
                toolbar4.f1245i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1245i);
            }
            Toolbar.this.E();
            Toolbar.this.requestLayout();
            eVar.q(true);
            Toolbar toolbar6 = Toolbar.this;
            View view = toolbar6.f1245i;
            toolbar6.L();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public void h(Context context, androidx.appcompat.view.menu.d dVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.d dVar2 = this.f1267a;
            if (dVar2 != null && (eVar = this.f1268b) != null) {
                dVar2.e(eVar);
            }
            this.f1267a = dVar;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean j(j jVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g
        public void a(androidx.appcompat.view.menu.d dVar, boolean z10) {
        }
    }
}
