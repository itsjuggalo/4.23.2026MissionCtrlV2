package androidx.appcompat.widget;

import T.AbstractC0927i;
import T.C0933o;
import T.D;
import T.InterfaceC0930l;
import T.InterfaceC0935q;
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
import g.AbstractC1764a;
import h.AbstractC1841a;
import i.AbstractC1906a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import o.C2440i;
import o.C2442k;
import o.C2446o;
import o.G;
import o.InterfaceC2449s;
import o.L;
import o.P;
import o.W;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0930l {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f10683A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f10684B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f10685C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ArrayList f10686D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final ArrayList f10687E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int[] f10688F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final C0933o f10689G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ArrayList f10690H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final ActionMenuView.e f10691I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public androidx.appcompat.widget.d f10692J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public androidx.appcompat.widget.a f10693K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public f f10694L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public g.a f10695M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public d.a f10696N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f10697O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public OnBackInvokedCallback f10698P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public OnBackInvokedDispatcher f10699Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f10700R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final Runnable f10701S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f10702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f10703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f10704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f10705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f10706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f10707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f10708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f10709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f10710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f10711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10713l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10714m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10715n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10716o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10717p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10718q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10719r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10720s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public G f10721t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10722u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10723v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10724w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f10725x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f10726y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f10727z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f10689G.j(menuItem)) {
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
            Toolbar.this.K();
        }
    }

    public class c implements d.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            d.a aVar = Toolbar.this.f10696N;
            return aVar != null && aVar.a(dVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void b(androidx.appcompat.view.menu.d dVar) {
            if (!Toolbar.this.f10702a.D()) {
                Toolbar.this.f10689G.k(dVar);
            }
            d.a aVar = Toolbar.this.f10696N;
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
            return new OnBackInvokedCallback() { // from class: o.O
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
        public androidx.appcompat.view.menu.d f10732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f10733b;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.g
        public void a(androidx.appcompat.view.menu.d dVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.g
        public void b(boolean z7) {
            if (this.f10733b != null) {
                androidx.appcompat.view.menu.d dVar = this.f10732a;
                if (dVar != null) {
                    int size = dVar.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        if (this.f10732a.getItem(i8) == this.f10733b) {
                            return;
                        }
                    }
                }
                d(this.f10732a, this.f10733b);
            }
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean d(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f10710i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f10709h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f10710i = null;
            toolbar3.a();
            this.f10733b = null;
            Toolbar.this.requestLayout();
            eVar.q(false);
            Toolbar.this.L();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean f(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f10709h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f10709h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f10709h);
            }
            Toolbar.this.f10710i = eVar.getActionView();
            this.f10733b = eVar;
            ViewParent parent2 = Toolbar.this.f10710i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f10710i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f18308a = (toolbar4.f10715n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f10735b = 2;
                toolbar4.f10710i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f10710i);
            }
            Toolbar.this.E();
            Toolbar.this.requestLayout();
            eVar.q(true);
            Toolbar toolbar6 = Toolbar.this;
            View view = toolbar6.f10710i;
            toolbar6.L();
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public void h(Context context, androidx.appcompat.view.menu.d dVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.d dVar2 = this.f10732a;
            if (dVar2 != null && (eVar = this.f10733b) != null) {
                dVar2.e(eVar);
            }
            this.f10732a = dVar;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean j(j jVar) {
            return false;
        }
    }

    public static class g extends AbstractC1841a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10735b;

        public g(int i8, int i9) {
            super(i8, i9);
            this.f10735b = 0;
            this.f18308a = 8388627;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10735b = 0;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10735b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f10735b = 0;
            a(marginLayoutParams);
        }

        public g(g gVar) {
            super((AbstractC1841a) gVar);
            this.f10735b = 0;
            this.f10735b = gVar.f10735b;
        }

        public g(AbstractC1841a abstractC1841a) {
            super(abstractC1841a);
            this.f10735b = 0;
        }
    }

    public interface h {
    }

    public static class i extends Z.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10737d;

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
            public i[] newArray(int i8) {
                return new i[i8];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10736c = parcel.readInt();
            this.f10737d = parcel.readInt() != 0;
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f10736c);
            parcel.writeInt(this.f10737d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1764a.f17667r);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i8 = 0; i8 < menu.size(); i8++) {
            arrayList.add(menu.getItem(i8));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new m.c(getContext());
    }

    public final int A(View view, int i8, int i9, int i10, int i11, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i12) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        view.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + iMax + i9, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void B(View view, int i8, int i9, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void C() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f10689G.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f10690H = currentMenuItems2;
    }

    public final void D() {
        removeCallbacks(this.f10701S);
        post(this.f10701S);
    }

    public void E() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f10735b != 2 && childAt != this.f10702a) {
                removeViewAt(childCount);
                this.f10687E.add(childAt);
            }
        }
    }

    public void F(int i8, int i9) {
        f();
        this.f10721t.g(i8, i9);
    }

    public void G(Context context, int i8) {
        this.f10714m = i8;
        TextView textView = this.f10704c;
        if (textView != null) {
            textView.setTextAppearance(context, i8);
        }
    }

    public void H(Context context, int i8) {
        this.f10713l = i8;
        TextView textView = this.f10703b;
        if (textView != null) {
            textView.setTextAppearance(context, i8);
        }
    }

    public final boolean I() {
        if (!this.f10697O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
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
        ActionMenuView actionMenuView = this.f10702a;
        return actionMenuView != null && actionMenuView.I();
    }

    public void L() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z7 = t() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f10700R;
            if (z7 && this.f10699Q == null) {
                if (this.f10698P == null) {
                    this.f10698P = e.b(new Runnable() { // from class: o.M
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21777a.d();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.f10698P);
            } else {
                if (z7 || (onBackInvokedDispatcher = this.f10699Q) == null) {
                    return;
                }
                e.d(onBackInvokedDispatcher, this.f10698P);
                onBackInvokedDispatcherA = null;
            }
            this.f10699Q = onBackInvokedDispatcherA;
        }
    }

    public void a() {
        for (int size = this.f10687E.size() - 1; size >= 0; size--) {
            addView((View) this.f10687E.get(size));
        }
        this.f10687E.clear();
    }

    @Override // T.InterfaceC0930l
    public void addMenuProvider(InterfaceC0935q interfaceC0935q) {
        this.f10689G.c(interfaceC0935q);
    }

    public final void b(List list, int i8) {
        boolean z7 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iA = AbstractC0927i.a(i8, getLayoutDirection());
        list.clear();
        if (!z7) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f10735b == 0 && J(childAt) && n(gVar.f18308a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt2 = getChildAt(i10);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f10735b == 0 && J(childAt2) && n(gVar2.f18308a) == iA) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z7) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f10735b = 1;
        if (!z7 || this.f10710i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f10687E.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public void d() {
        f fVar = this.f10694L;
        androidx.appcompat.view.menu.e eVar = fVar == null ? null : fVar.f10733b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }

    public void e() {
        if (this.f10709h == null) {
            C2440i c2440i = new C2440i(getContext(), null, AbstractC1764a.f17666q);
            this.f10709h = c2440i;
            c2440i.setImageDrawable(this.f10707f);
            this.f10709h.setContentDescription(this.f10708g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18308a = (this.f10715n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f10735b = 2;
            this.f10709h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f10709h.setOnClickListener(new d());
        }
    }

    public final void f() {
        if (this.f10721t == null) {
            this.f10721t = new G();
        }
    }

    public final void g() {
        if (this.f10706e == null) {
            this.f10706e = new C2442k(getContext());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f10709h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f10709h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        G g8 = this.f10721t;
        if (g8 != null) {
            return g8.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i8 = this.f10723v;
        return i8 != Integer.MIN_VALUE ? i8 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        G g8 = this.f10721t;
        if (g8 != null) {
            return g8.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        G g8 = this.f10721t;
        if (g8 != null) {
            return g8.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        G g8 = this.f10721t;
        if (g8 != null) {
            return g8.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i8 = this.f10722u;
        return i8 != Integer.MIN_VALUE ? i8 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.d dVarG;
        ActionMenuView actionMenuView = this.f10702a;
        return (actionMenuView == null || (dVarG = actionMenuView.G()) == null || !dVarG.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f10723v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f10722u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f10706e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f10706e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        h();
        return this.f10702a.getMenu();
    }

    public View getNavButtonView() {
        return this.f10705d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f10705d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f10705d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.f10693K;
    }

    public Drawable getOverflowIcon() {
        h();
        return this.f10702a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f10711j;
    }

    public int getPopupTheme() {
        return this.f10712k;
    }

    public CharSequence getSubtitle() {
        return this.f10726y;
    }

    public final TextView getSubtitleTextView() {
        return this.f10704c;
    }

    public CharSequence getTitle() {
        return this.f10725x;
    }

    public int getTitleMarginBottom() {
        return this.f10720s;
    }

    public int getTitleMarginEnd() {
        return this.f10718q;
    }

    public int getTitleMarginStart() {
        return this.f10717p;
    }

    public int getTitleMarginTop() {
        return this.f10719r;
    }

    public final TextView getTitleTextView() {
        return this.f10703b;
    }

    public InterfaceC2449s getWrapper() {
        if (this.f10692J == null) {
            this.f10692J = new androidx.appcompat.widget.d(this, true);
        }
        return this.f10692J;
    }

    public final void h() {
        i();
        if (this.f10702a.G() == null) {
            androidx.appcompat.view.menu.d dVar = (androidx.appcompat.view.menu.d) this.f10702a.getMenu();
            if (this.f10694L == null) {
                this.f10694L = new f();
            }
            this.f10702a.setExpandedActionViewsExclusive(true);
            dVar.b(this.f10694L, this.f10711j);
            L();
        }
    }

    public final void i() {
        if (this.f10702a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f10702a = actionMenuView;
            actionMenuView.setPopupTheme(this.f10712k);
            this.f10702a.setOnMenuItemClickListener(this.f10691I);
            this.f10702a.H(this.f10695M, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18308a = (this.f10715n & 112) | 8388613;
            this.f10702a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f10702a, false);
        }
    }

    public final void j() {
        if (this.f10705d == null) {
            this.f10705d = new C2440i(getContext(), null, AbstractC1764a.f17666q);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18308a = (this.f10715n & 112) | 8388611;
            this.f10705d.setLayoutParams(gVarGenerateDefaultLayoutParams);
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
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof AbstractC1841a ? new g((AbstractC1841a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public final int n(int i8) {
        int layoutDirection = getLayoutDirection();
        int iA = AbstractC0927i.a(i8, layoutDirection) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : layoutDirection == 1 ? 5 : 3;
    }

    public final int o(View view, int i8) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i9 = i8 > 0 ? (measuredHeight - i8) / 2 : 0;
        int iP = p(gVar.f18308a);
        if (iP == 48) {
            return getPaddingTop() - i9;
        }
        if (iP == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i9;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i10 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i10) {
            iMax = i10;
        } else {
            int i11 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i12 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i11 < i12) {
                iMax = Math.max(0, iMax - (i12 - i11));
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
        removeCallbacks(this.f10701S);
        L();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f10685C = false;
        }
        if (!this.f10685C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f10685C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f10685C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0297 A[LOOP:0: B:111:0x0295->B:112:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b9 A[LOOP:1: B:114:0x02b7->B:115:0x02b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f2 A[LOOP:2: B:123:0x02f0->B:124:0x02f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.f10688F;
        boolean zA = W.a(this);
        int i10 = !zA ? 1 : 0;
        if (J(this.f10705d)) {
            B(this.f10705d, i8, 0, i9, 0, this.f10716o);
            measuredWidth = this.f10705d.getMeasuredWidth() + q(this.f10705d);
            iMax = Math.max(0, this.f10705d.getMeasuredHeight() + r(this.f10705d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f10705d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (J(this.f10709h)) {
            B(this.f10709h, i8, 0, i9, 0, this.f10716o);
            measuredWidth = this.f10709h.getMeasuredWidth() + q(this.f10709h);
            iMax = Math.max(iMax, this.f10709h.getMeasuredHeight() + r(this.f10709h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f10709h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zA ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (J(this.f10702a)) {
            B(this.f10702a, i8, iMax3, i9, 0, this.f10716o);
            measuredWidth2 = this.f10702a.getMeasuredWidth() + q(this.f10702a);
            iMax = Math.max(iMax, this.f10702a.getMeasuredHeight() + r(this.f10702a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f10702a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i10] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (J(this.f10710i)) {
            iMax4 += A(this.f10710i, i8, iMax4, i9, 0, iArr);
            iMax = Math.max(iMax, this.f10710i.getMeasuredHeight() + r(this.f10710i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f10710i.getMeasuredState());
        }
        if (J(this.f10706e)) {
            iMax4 += A(this.f10706e, i8, iMax4, i9, 0, iArr);
            iMax = Math.max(iMax, this.f10706e.getMeasuredHeight() + r(this.f10706e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f10706e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((g) childAt.getLayoutParams()).f10735b == 0 && J(childAt)) {
                iMax4 += A(childAt, i8, iMax4, i9, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + r(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i12 = this.f10719r + this.f10720s;
        int i13 = this.f10717p + this.f10718q;
        if (J(this.f10703b)) {
            A(this.f10703b, i8, iMax4 + i13, i9, i12, iArr);
            int measuredWidth3 = this.f10703b.getMeasuredWidth() + q(this.f10703b);
            measuredHeight = this.f10703b.getMeasuredHeight() + r(this.f10703b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f10703b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (J(this.f10704c)) {
            iMax2 = Math.max(iMax2, A(this.f10704c, i8, iMax4 + i13, i9, measuredHeight + i12, iArr));
            measuredHeight += this.f10704c.getMeasuredHeight() + r(this.f10704c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f10704c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i8, (-16777216) & iCombineMeasuredStates2), I() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i9, iCombineMeasuredStates2 << 16));
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
        ActionMenuView actionMenuView = this.f10702a;
        androidx.appcompat.view.menu.d dVarG = actionMenuView != null ? actionMenuView.G() : null;
        int i8 = iVar.f10736c;
        if (i8 != 0 && this.f10694L != null && dVarG != null && (menuItemFindItem = dVarG.findItem(i8)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f10737d) {
            D();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        f();
        this.f10721t.f(i8 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.e eVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f10694L;
        if (fVar != null && (eVar = fVar.f10733b) != null) {
            iVar.f10736c = eVar.getItemId();
        }
        iVar.f10737d = x();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f10684B = false;
        }
        if (!this.f10684B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f10684B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f10684B = false;
        }
        return true;
    }

    public final int p(int i8) {
        int i9 = i8 & 112;
        return (i9 == 16 || i9 == 48 || i9 == 80) ? i9 : this.f10724w & 112;
    }

    public final int q(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    public final int r(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // T.InterfaceC0930l
    public void removeMenuProvider(InterfaceC0935q interfaceC0935q) {
        this.f10689G.l(interfaceC0935q);
    }

    public final int s(List list, int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int size = list.size();
        int i10 = 0;
        int measuredWidth = 0;
        while (i10 < size) {
            View view = (View) list.get(i10);
            g gVar = (g) view.getLayoutParams();
            int i11 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i8;
            int i12 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i9;
            int iMax = Math.max(0, i11);
            int iMax2 = Math.max(0, i12);
            int iMax3 = Math.max(0, -i11);
            int iMax4 = Math.max(0, -i12);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i10++;
            i9 = iMax4;
            i8 = iMax3;
        }
        return measuredWidth;
    }

    public void setBackInvokedCallbackEnabled(boolean z7) {
        if (this.f10700R != z7) {
            this.f10700R = z7;
            L();
        }
    }

    public void setCollapseContentDescription(int i8) {
        setCollapseContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setCollapseIcon(int i8) {
        setCollapseIcon(AbstractC1906a.b(getContext(), i8));
    }

    public void setCollapsible(boolean z7) {
        this.f10697O = z7;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.f10723v) {
            this.f10723v = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.f10722u) {
            this.f10722u = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i8) {
        setLogo(AbstractC1906a.b(getContext(), i8));
    }

    public void setLogoDescription(int i8) {
        setLogoDescription(getContext().getText(i8));
    }

    public void setNavigationContentDescription(int i8) {
        setNavigationContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setNavigationIcon(int i8) {
        setNavigationIcon(AbstractC1906a.b(getContext(), i8));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        j();
        this.f10705d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.f10702a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i8) {
        if (this.f10712k != i8) {
            this.f10712k = i8;
            if (i8 == 0) {
                this.f10711j = getContext();
            } else {
                this.f10711j = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setSubtitle(int i8) {
        setSubtitle(getContext().getText(i8));
    }

    public void setSubtitleTextColor(int i8) {
        setSubtitleTextColor(ColorStateList.valueOf(i8));
    }

    public void setTitle(int i8) {
        setTitle(getContext().getText(i8));
    }

    public void setTitleMarginBottom(int i8) {
        this.f10720s = i8;
        requestLayout();
    }

    public void setTitleMarginEnd(int i8) {
        this.f10718q = i8;
        requestLayout();
    }

    public void setTitleMarginStart(int i8) {
        this.f10717p = i8;
        requestLayout();
    }

    public void setTitleMarginTop(int i8) {
        this.f10719r = i8;
        requestLayout();
    }

    public void setTitleTextColor(int i8) {
        setTitleTextColor(ColorStateList.valueOf(i8));
    }

    public boolean t() {
        f fVar = this.f10694L;
        return (fVar == null || fVar.f10733b == null) ? false : true;
    }

    public void u(int i8) {
        getMenuInflater().inflate(i8, getMenu());
    }

    public void v() {
        Iterator it = this.f10690H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        C();
    }

    public final boolean w(View view) {
        return view.getParent() == this || this.f10687E.contains(view);
    }

    public boolean x() {
        ActionMenuView actionMenuView = this.f10702a;
        return actionMenuView != null && actionMenuView.D();
    }

    public final int y(View view, int i8, int[] iArr, int i9) {
        g gVar = (g) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i8 + Math.max(0, i10);
        iArr[0] = Math.max(0, -i10);
        int iO = o(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iO, iMax + measuredWidth, view.getMeasuredHeight() + iO);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    public final int z(View view, int i8, int[] iArr, int i9) {
        g gVar = (g) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i8 - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int iO = o(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iO, iMax, view.getMeasuredHeight() + iO);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f10724w = 8388627;
        this.f10686D = new ArrayList();
        this.f10687E = new ArrayList();
        this.f10688F = new int[2];
        this.f10689G = new C0933o(new Runnable() { // from class: o.N
            @Override // java.lang.Runnable
            public final void run() {
                this.f21778a.v();
            }
        });
        this.f10690H = new ArrayList();
        this.f10691I = new a();
        this.f10701S = new b();
        L lS = L.s(getContext(), attributeSet, g.i.f17857Y1, i8, 0);
        D.I(this, context, g.i.f17857Y1, attributeSet, lS.o(), i8, 0);
        this.f10713l = lS.l(g.i.f17775A2, 0);
        this.f10714m = lS.l(g.i.f17932r2, 0);
        this.f10724w = lS.j(g.i.f17860Z1, this.f10724w);
        this.f10715n = lS.j(g.i.f17864a2, 48);
        int iD = lS.d(g.i.f17944u2, 0);
        iD = lS.p(g.i.f17964z2) ? lS.d(g.i.f17964z2, iD) : iD;
        this.f10720s = iD;
        this.f10719r = iD;
        this.f10718q = iD;
        this.f10717p = iD;
        int iD2 = lS.d(g.i.f17956x2, -1);
        if (iD2 >= 0) {
            this.f10717p = iD2;
        }
        int iD3 = lS.d(g.i.f17952w2, -1);
        if (iD3 >= 0) {
            this.f10718q = iD3;
        }
        int iD4 = lS.d(g.i.f17960y2, -1);
        if (iD4 >= 0) {
            this.f10719r = iD4;
        }
        int iD5 = lS.d(g.i.f17948v2, -1);
        if (iD5 >= 0) {
            this.f10720s = iD5;
        }
        this.f10716o = lS.e(g.i.f17908l2, -1);
        int iD6 = lS.d(g.i.f17892h2, Integer.MIN_VALUE);
        int iD7 = lS.d(g.i.f17876d2, Integer.MIN_VALUE);
        int iE = lS.e(g.i.f17884f2, 0);
        int iE2 = lS.e(g.i.f17888g2, 0);
        f();
        this.f10721t.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f10721t.g(iD6, iD7);
        }
        this.f10722u = lS.d(g.i.f17896i2, Integer.MIN_VALUE);
        this.f10723v = lS.d(g.i.f17880e2, Integer.MIN_VALUE);
        this.f10707f = lS.f(g.i.f17872c2);
        this.f10708g = lS.n(g.i.f17868b2);
        CharSequence charSequenceN = lS.n(g.i.f17940t2);
        if (!TextUtils.isEmpty(charSequenceN)) {
            setTitle(charSequenceN);
        }
        CharSequence charSequenceN2 = lS.n(g.i.f17928q2);
        if (!TextUtils.isEmpty(charSequenceN2)) {
            setSubtitle(charSequenceN2);
        }
        this.f10711j = getContext();
        setPopupTheme(lS.l(g.i.f17924p2, 0));
        Drawable drawableF = lS.f(g.i.f17920o2);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceN3 = lS.n(g.i.f17916n2);
        if (!TextUtils.isEmpty(charSequenceN3)) {
            setNavigationContentDescription(charSequenceN3);
        }
        Drawable drawableF2 = lS.f(g.i.f17900j2);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceN4 = lS.n(g.i.f17904k2);
        if (!TextUtils.isEmpty(charSequenceN4)) {
            setLogoDescription(charSequenceN4);
        }
        if (lS.p(g.i.f17779B2)) {
            setTitleTextColor(lS.c(g.i.f17779B2));
        }
        if (lS.p(g.i.f17936s2)) {
            setSubtitleTextColor(lS.c(g.i.f17936s2));
        }
        if (lS.p(g.i.f17912m2)) {
            u(lS.l(g.i.f17912m2, 0));
        }
        lS.u();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f10709h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            this.f10709h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f10709h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f10707f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!w(this.f10706e)) {
                c(this.f10706e, true);
            }
        } else {
            ImageView imageView = this.f10706e;
            if (imageView != null && w(imageView)) {
                removeView(this.f10706e);
                this.f10687E.remove(this.f10706e);
            }
        }
        ImageView imageView2 = this.f10706e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageView imageView = this.f10706e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageButton imageButton = this.f10705d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            P.a(this.f10705d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!w(this.f10705d)) {
                c(this.f10705d, true);
            }
        } else {
            ImageButton imageButton = this.f10705d;
            if (imageButton != null && w(imageButton)) {
                removeView(this.f10705d);
                this.f10687E.remove(this.f10705d);
            }
        }
        ImageButton imageButton2 = this.f10705d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f10704c;
            if (textView != null && w(textView)) {
                removeView(this.f10704c);
                this.f10687E.remove(this.f10704c);
            }
        } else {
            if (this.f10704c == null) {
                Context context = getContext();
                C2446o c2446o = new C2446o(context);
                this.f10704c = c2446o;
                c2446o.setSingleLine();
                this.f10704c.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f10714m;
                if (i8 != 0) {
                    this.f10704c.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.f10683A;
                if (colorStateList != null) {
                    this.f10704c.setTextColor(colorStateList);
                }
            }
            if (!w(this.f10704c)) {
                c(this.f10704c, true);
            }
        }
        TextView textView2 = this.f10704c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f10726y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f10683A = colorStateList;
        TextView textView = this.f10704c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f10703b;
            if (textView != null && w(textView)) {
                removeView(this.f10703b);
                this.f10687E.remove(this.f10703b);
            }
        } else {
            if (this.f10703b == null) {
                Context context = getContext();
                C2446o c2446o = new C2446o(context);
                this.f10703b = c2446o;
                c2446o.setSingleLine();
                this.f10703b.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f10713l;
                if (i8 != 0) {
                    this.f10703b.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.f10727z;
                if (colorStateList != null) {
                    this.f10703b.setTextColor(colorStateList);
                }
            }
            if (!w(this.f10703b)) {
                c(this.f10703b, true);
            }
        }
        TextView textView2 = this.f10703b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f10725x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f10727z = colorStateList;
        TextView textView = this.f10703b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
