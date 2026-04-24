package androidx.appcompat.widget;

import D.C;
import Y3.j;
import Z.B;
import Z.H;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.cryptosignals.ap.android.R;
import h.AbstractC0616a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l.i;
import m.C0803B;
import m.C0815f;
import m.C0821i;
import m.C0835p;
import m.C0836p0;
import m.C0837q;
import m.J0;
import m.K;
import m.K0;
import m.M0;
import m.N0;
import m.O0;
import m.P0;
import m.Q0;
import m.X0;
import s1.C0994k;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final int f4374A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f4375B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public CharSequence f4376C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorStateList f4377D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ColorStateList f4378E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f4379F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f4380G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final ArrayList f4381H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final ArrayList f4382I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int[] f4383J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final C0994k f4384K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public ArrayList f4385L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final j f4386M;
    public Q0 N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public M0 f4387O;
    public boolean P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public OnBackInvokedCallback f4388Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public OnBackInvokedDispatcher f4389R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f4390S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final A.b f4391T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f4392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0803B f4393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0803B f4394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0835p f4395d;
    public C0837q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f4396f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f4397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0835p f4398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f4399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Context f4400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f4404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f4405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public C0836p0 f4410x;
    public int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4411z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f4374A = 8388627;
        this.f4381H = new ArrayList();
        this.f4382I = new ArrayList();
        this.f4383J = new int[2];
        this.f4384K = new C0994k(new J0(this, 1));
        this.f4385L = new ArrayList();
        this.f4386M = new j(this, 17);
        this.f4391T = new A.b(this, 23);
        Context context2 = getContext();
        int[] iArr = AbstractC0616a.f6590t;
        f.d dVarQ = f.d.Q(context2, attributeSet, iArr, R.attr.toolbarStyle);
        C.c(this, context, iArr, attributeSet, (TypedArray) dVarQ.f6382b, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) dVarQ.f6382b;
        this.f4402p = typedArray.getResourceId(28, 0);
        this.f4403q = typedArray.getResourceId(19, 0);
        this.f4374A = typedArray.getInteger(0, 8388627);
        this.f4404r = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f4409w = dimensionPixelOffset;
        this.f4408v = dimensionPixelOffset;
        this.f4407u = dimensionPixelOffset;
        this.f4406t = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f4406t = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f4407u = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f4408v = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f4409w = dimensionPixelOffset5;
        }
        this.f4405s = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        C0836p0 c0836p0 = this.f4410x;
        c0836p0.f8425h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            c0836p0.e = dimensionPixelSize;
            c0836p0.f8419a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            c0836p0.f8423f = dimensionPixelSize2;
            c0836p0.f8420b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            c0836p0.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.y = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f4411z = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f4396f = dVarQ.G(4);
        this.f4397k = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f4400n = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableG = dVarQ.G(16);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableG2 = dVarQ.G(11);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(dVarQ.F(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(dVarQ.F(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        dVarQ.S();
    }

    public static N0 g() {
        N0 n02 = new N0(-2, -2);
        n02.f8264b = 0;
        n02.f8263a = 8388627;
        return n02;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new k.d(getContext());
    }

    public static N0 h(ViewGroup.LayoutParams layoutParams) {
        boolean z6 = layoutParams instanceof N0;
        if (z6) {
            N0 n02 = (N0) layoutParams;
            N0 n03 = new N0(n02);
            n03.f8264b = 0;
            n03.f8264b = n02.f8264b;
            return n03;
        }
        if (z6) {
            N0 n04 = new N0((N0) layoutParams);
            n04.f8264b = 0;
            return n04;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            N0 n05 = new N0(layoutParams);
            n05.f8264b = 0;
            return n05;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        N0 n06 = new N0(marginLayoutParams);
        n06.f8264b = 0;
        ((ViewGroup.MarginLayoutParams) n06).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) n06).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) n06).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) n06).bottomMargin = marginLayoutParams.bottomMargin;
        return n06;
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i, ArrayList arrayList) {
        Field field = C.f194a;
        boolean z6 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z6) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                N0 n02 = (N0) childAt.getLayoutParams();
                if (n02.f8264b == 0 && r(childAt)) {
                    int i7 = n02.f8263a;
                    Field field2 = C.f194a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i7, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i8 = childCount - 1; i8 >= 0; i8--) {
            View childAt2 = getChildAt(i8);
            N0 n03 = (N0) childAt2.getLayoutParams();
            if (n03.f8264b == 0 && r(childAt2)) {
                int i9 = n03.f8263a;
                Field field3 = C.f194a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i9, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        N0 n0G = layoutParams == null ? g() : !checkLayoutParams(layoutParams) ? h(layoutParams) : (N0) layoutParams;
        n0G.f8264b = 1;
        if (!z6 || this.f4399m == null) {
            addView(view, n0G);
        } else {
            view.setLayoutParams(n0G);
            this.f4382I.add(view);
        }
    }

    public final void c() {
        if (this.f4398l == null) {
            C0835p c0835p = new C0835p(getContext());
            this.f4398l = c0835p;
            c0835p.setImageDrawable(this.f4396f);
            this.f4398l.setContentDescription(this.f4397k);
            N0 n0G = g();
            n0G.f8263a = (this.f4404r & 112) | 8388611;
            n0G.f8264b = 2;
            this.f4398l.setLayoutParams(n0G);
            this.f4398l.setOnClickListener(new K0(this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof N0);
    }

    public final void d() {
        if (this.f4410x == null) {
            C0836p0 c0836p0 = new C0836p0();
            c0836p0.f8419a = 0;
            c0836p0.f8420b = 0;
            c0836p0.f8421c = Integer.MIN_VALUE;
            c0836p0.f8422d = Integer.MIN_VALUE;
            c0836p0.e = 0;
            c0836p0.f8423f = 0;
            c0836p0.f8424g = false;
            c0836p0.f8425h = false;
            this.f4410x = c0836p0;
        }
    }

    public final void e() {
        if (this.f4392a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f4392a = actionMenuView;
            actionMenuView.setPopupTheme(this.f4401o);
            this.f4392a.setOnMenuItemClickListener(this.f4386M);
            ActionMenuView actionMenuView2 = this.f4392a;
            B b3 = new B(this, 14);
            actionMenuView2.getClass();
            actionMenuView2.f4280x = b3;
            N0 n0G = g();
            n0G.f8263a = (this.f4404r & 112) | 8388613;
            this.f4392a.setLayoutParams(n0G);
            b(this.f4392a, false);
        }
        ActionMenuView actionMenuView3 = this.f4392a;
        if (actionMenuView3.f4276t == null) {
            i iVar = (i) actionMenuView3.getMenu();
            if (this.f4387O == null) {
                this.f4387O = new M0(this);
            }
            this.f4392a.setExpandedActionViewsExclusive(true);
            iVar.b(this.f4387O, this.f4400n);
            s();
        }
    }

    public final void f() {
        if (this.f4395d == null) {
            this.f4395d = new C0835p(getContext());
            N0 n0G = g();
            n0G.f8263a = (this.f4404r & 112) | 8388611;
            this.f4395d.setLayoutParams(n0G);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return h(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0835p c0835p = this.f4398l;
        if (c0835p != null) {
            return c0835p.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0835p c0835p = this.f4398l;
        if (c0835p != null) {
            return c0835p.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C0836p0 c0836p0 = this.f4410x;
        if (c0836p0 != null) {
            return c0836p0.f8424g ? c0836p0.f8419a : c0836p0.f8420b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f4411z;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C0836p0 c0836p0 = this.f4410x;
        if (c0836p0 != null) {
            return c0836p0.f8419a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        C0836p0 c0836p0 = this.f4410x;
        if (c0836p0 != null) {
            return c0836p0.f8420b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        C0836p0 c0836p0 = this.f4410x;
        if (c0836p0 != null) {
            return c0836p0.f8424g ? c0836p0.f8420b : c0836p0.f8419a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.y;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        i iVar;
        ActionMenuView actionMenuView = this.f4392a;
        return (actionMenuView == null || (iVar = actionMenuView.f4276t) == null || !iVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f4411z, 0));
    }

    public int getCurrentContentInsetLeft() {
        Field field = C.f194a;
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        Field field = C.f194a;
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.y, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        C0837q c0837q = this.e;
        if (c0837q != null) {
            return c0837q.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0837q c0837q = this.e;
        if (c0837q != null) {
            return c0837q.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f4392a.getMenu();
    }

    public View getNavButtonView() {
        return this.f4395d;
    }

    public CharSequence getNavigationContentDescription() {
        C0835p c0835p = this.f4395d;
        if (c0835p != null) {
            return c0835p.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0835p c0835p = this.f4395d;
        if (c0835p != null) {
            return c0835p.getDrawable();
        }
        return null;
    }

    public C0821i getOuterActionMenuPresenter() {
        return null;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f4392a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f4400n;
    }

    public int getPopupTheme() {
        return this.f4401o;
    }

    public CharSequence getSubtitle() {
        return this.f4376C;
    }

    public final TextView getSubtitleTextView() {
        return this.f4394c;
    }

    public CharSequence getTitle() {
        return this.f4375B;
    }

    public int getTitleMarginBottom() {
        return this.f4409w;
    }

    public int getTitleMarginEnd() {
        return this.f4407u;
    }

    public int getTitleMarginStart() {
        return this.f4406t;
    }

    public int getTitleMarginTop() {
        return this.f4408v;
    }

    public final TextView getTitleTextView() {
        return this.f4393b;
    }

    public K getWrapper() {
        Drawable drawable;
        if (this.N == null) {
            Q0 q02 = new Q0();
            q02.f8280l = 0;
            q02.f8271a = this;
            q02.f8277h = getTitle();
            q02.i = getSubtitle();
            q02.f8276g = q02.f8277h != null;
            q02.f8275f = getNavigationIcon();
            f.d dVarQ = f.d.Q(getContext(), null, AbstractC0616a.f6573a, R.attr.actionBarStyle);
            q02.f8281m = dVarQ.G(15);
            TypedArray typedArray = (TypedArray) dVarQ.f6382b;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                q02.f8276g = true;
                q02.f8277h = text;
                if ((q02.f8272b & 8) != 0) {
                    Toolbar toolbar = q02.f8271a;
                    toolbar.setTitle(text);
                    if (q02.f8276g) {
                        C.e(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                q02.i = text2;
                if ((q02.f8272b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableG = dVarQ.G(20);
            if (drawableG != null) {
                q02.e = drawableG;
                q02.c();
            }
            Drawable drawableG2 = dVarQ.G(17);
            if (drawableG2 != null) {
                q02.f8274d = drawableG2;
                q02.c();
            }
            if (q02.f8275f == null && (drawable = q02.f8281m) != null) {
                q02.f8275f = drawable;
                int i = q02.f8272b & 4;
                Toolbar toolbar2 = q02.f8271a;
                if (i != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            q02.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = q02.f8273c;
                if (view != null && (q02.f8272b & 16) != 0) {
                    removeView(view);
                }
                q02.f8273c = viewInflate;
                if (viewInflate != null && (q02.f8272b & 16) != 0) {
                    addView(viewInflate);
                }
                q02.a(q02.f8272b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.f4410x.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f4402p = resourceId2;
                C0803B c0803b = this.f4393b;
                if (c0803b != null) {
                    c0803b.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f4403q = resourceId3;
                C0803B c0803b2 = this.f4394c;
                if (c0803b2 != null) {
                    c0803b2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            dVarQ.S();
            if (R.string.abc_action_bar_up_description != q02.f8280l) {
                q02.f8280l = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i6 = q02.f8280l;
                    q02.f8278j = i6 != 0 ? getContext().getString(i6) : null;
                    q02.b();
                }
            }
            q02.f8278j = getNavigationContentDescription();
            setNavigationOnClickListener(new K0(q02));
            this.N = q02;
        }
        return this.N;
    }

    public final int i(View view, int i) {
        N0 n02 = (N0) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i7 = n02.f8263a & 112;
        if (i7 != 16 && i7 != 48 && i7 != 80) {
            i7 = this.f4374A & 112;
        }
        if (i7 == 48) {
            return getPaddingTop() - i6;
        }
        if (i7 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) n02).bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i8 = ((ViewGroup.MarginLayoutParams) n02).topMargin;
        if (iMax < i8) {
            iMax = i8;
        } else {
            int i9 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i10 = ((ViewGroup.MarginLayoutParams) n02).bottomMargin;
            if (i9 < i10) {
                iMax = Math.max(0, iMax - (i10 - i9));
            }
        }
        return paddingTop + iMax;
    }

    public final void l() {
        Iterator it = this.f4385L.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.f4384K.f9531c).iterator();
        while (it2.hasNext()) {
            ((H) it2.next()).f3712a.k();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f4385L = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.f4382I.contains(view);
    }

    public final int n(View view, int i, int i6, int[] iArr) {
        N0 n02 = (N0) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) n02).leftMargin - iArr[0];
        int iMax = Math.max(0, i7) + i;
        iArr[0] = Math.max(0, -i7);
        int i8 = i(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, i8, iMax + measuredWidth, view.getMeasuredHeight() + i8);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) n02).rightMargin + iMax;
    }

    public final int o(View view, int i, int i6, int[] iArr) {
        N0 n02 = (N0) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) n02).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int i8 = i(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, i8, iMax, view.getMeasuredHeight() + i8);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) n02).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4391T);
        s();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4380G = false;
        }
        if (!this.f4380G) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f4380G = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f4380G = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0295 A[LOOP:0: B:104:0x0293->B:105:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ad A[LOOP:1: B:107:0x02ab->B:108:0x02ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02cd A[LOOP:2: B:110:0x02cb->B:111:0x02cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0321 A[LOOP:3: B:119:0x031f->B:120:0x0321, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int iJ;
        int iMax;
        int iCombineMeasuredStates;
        int iJ2;
        int iK;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean zA = X0.a(this);
        int i7 = !zA ? 1 : 0;
        int i8 = 0;
        if (r(this.f4395d)) {
            q(this.f4395d, i, 0, i6, this.f4405s);
            iJ = j(this.f4395d) + this.f4395d.getMeasuredWidth();
            iMax = Math.max(0, k(this.f4395d) + this.f4395d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f4395d.getMeasuredState());
        } else {
            iJ = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (r(this.f4398l)) {
            q(this.f4398l, i, 0, i6, this.f4405s);
            iJ = j(this.f4398l) + this.f4398l.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f4398l) + this.f4398l.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4398l.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iJ);
        int iMax4 = Math.max(0, currentContentInsetStart - iJ);
        int[] iArr = this.f4383J;
        iArr[zA ? 1 : 0] = iMax4;
        if (r(this.f4392a)) {
            q(this.f4392a, i, iMax3, i6, this.f4405s);
            iJ2 = j(this.f4392a) + this.f4392a.getMeasuredWidth();
            iMax = Math.max(iMax, k(this.f4392a) + this.f4392a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4392a.getMeasuredState());
        } else {
            iJ2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iJ2);
        iArr[i7] = Math.max(0, currentContentInsetEnd - iJ2);
        if (r(this.f4399m)) {
            iMax5 += p(this.f4399m, i, iMax5, i6, 0, iArr);
            iMax = Math.max(iMax, k(this.f4399m) + this.f4399m.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4399m.getMeasuredState());
        }
        if (r(this.e)) {
            iMax5 += p(this.e, i, iMax5, i6, 0, iArr);
            iMax = Math.max(iMax, k(this.e) + this.e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (((N0) childAt.getLayoutParams()).f8264b == 0 && r(childAt)) {
                iMax5 += p(childAt, i, iMax5, i6, 0, iArr);
                int iMax6 = Math.max(iMax, k(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i10 = iMax5;
        int i11 = this.f4408v + this.f4409w;
        int i12 = this.f4406t + this.f4407u;
        if (r(this.f4393b)) {
            p(this.f4393b, i, i10 + i12, i6, i11, iArr);
            int iJ3 = j(this.f4393b) + this.f4393b.getMeasuredWidth();
            iK = k(this.f4393b) + this.f4393b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f4393b.getMeasuredState());
            iMax2 = iJ3;
        } else {
            iK = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (r(this.f4394c)) {
            iMax2 = Math.max(iMax2, p(this.f4394c, i, i10 + i12, i6, i11 + iK, iArr));
            iK += k(this.f4394c) + this.f4394c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f4394c.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iK);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i10 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i6, iCombineMeasuredStates2 << 16);
        if (!this.P) {
            i8 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i8 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i8);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof P0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        P0 p02 = (P0) parcelable;
        super.onRestoreInstanceState(p02.f1052a);
        ActionMenuView actionMenuView = this.f4392a;
        i iVar = actionMenuView != null ? actionMenuView.f4276t : null;
        int i = p02.f8269c;
        if (i != 0 && this.f4387O != null && iVar != null && (menuItemFindItem = iVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (p02.f8270d) {
            A.b bVar = this.f4391T;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        C0836p0 c0836p0 = this.f4410x;
        boolean z6 = i == 1;
        if (z6 == c0836p0.f8424g) {
            return;
        }
        c0836p0.f8424g = z6;
        if (!c0836p0.f8425h) {
            c0836p0.f8419a = c0836p0.e;
            c0836p0.f8420b = c0836p0.f8423f;
            return;
        }
        if (z6) {
            int i6 = c0836p0.f8422d;
            if (i6 == Integer.MIN_VALUE) {
                i6 = c0836p0.e;
            }
            c0836p0.f8419a = i6;
            int i7 = c0836p0.f8421c;
            if (i7 == Integer.MIN_VALUE) {
                i7 = c0836p0.f8423f;
            }
            c0836p0.f8420b = i7;
            return;
        }
        int i8 = c0836p0.f8421c;
        if (i8 == Integer.MIN_VALUE) {
            i8 = c0836p0.e;
        }
        c0836p0.f8419a = i8;
        int i9 = c0836p0.f8422d;
        if (i9 == Integer.MIN_VALUE) {
            i9 = c0836p0.f8423f;
        }
        c0836p0.f8420b = i9;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0821i c0821i;
        C0815f c0815f;
        l.j jVar;
        P0 p02 = new P0(super.onSaveInstanceState());
        M0 m02 = this.f4387O;
        if (m02 != null && (jVar = m02.f8258b) != null) {
            p02.f8269c = jVar.f8002a;
        }
        ActionMenuView actionMenuView = this.f4392a;
        p02.f8270d = (actionMenuView == null || (c0821i = actionMenuView.f4279w) == null || (c0815f = c0821i.f8385v) == null || !c0815f.b()) ? false : true;
        return p02;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4379F = false;
        }
        if (!this.f4379F) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f4379F = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f4379F = false;
        return true;
    }

    public final int p(View view, int i, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i10) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i8 >= 0) {
            if (mode != 0) {
                i8 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i8);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            r4 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r1 < r2) goto L4f
            android.window.OnBackInvokedDispatcher r1 = m.L0.a(r4)
            m.M0 r2 = r4.f4387O
            if (r2 == 0) goto L23
            l.j r2 = r2.f8258b
            if (r2 == 0) goto L23
            if (r1 == 0) goto L23
            java.lang.reflect.Field r2 = D.C.f194a
            boolean r2 = r4.isAttachedToWindow()
            if (r2 == 0) goto L23
            boolean r2 = r4.f4390S
            if (r2 == 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = r0
        L24:
            if (r2 == 0) goto L41
            android.window.OnBackInvokedDispatcher r3 = r4.f4389R
            if (r3 != 0) goto L41
            android.window.OnBackInvokedCallback r2 = r4.f4388Q
            if (r2 != 0) goto L39
            m.J0 r2 = new m.J0
            r2.<init>(r4, r0)
            android.window.OnBackInvokedCallback r0 = m.L0.b(r2)
            r4.f4388Q = r0
        L39:
            android.window.OnBackInvokedCallback r0 = r4.f4388Q
            m.L0.c(r1, r0)
            r4.f4389R = r1
            return
        L41:
            if (r2 != 0) goto L4f
            android.window.OnBackInvokedDispatcher r0 = r4.f4389R
            if (r0 == 0) goto L4f
            android.window.OnBackInvokedCallback r1 = r4.f4388Q
            m.L0.d(r0, r1)
            r0 = 0
            r4.f4389R = r0
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.s():void");
    }

    public void setBackInvokedCallbackEnabled(boolean z6) {
        if (this.f4390S != z6) {
            this.f4390S = z6;
            s();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(D1.b.r(getContext(), i));
    }

    public void setCollapsible(boolean z6) {
        this.P = z6;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f4411z) {
            this.f4411z = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.y) {
            this.y = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(D1.b.r(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(D1.b.r(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f4395d.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f4392a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f4401o != i) {
            this.f4401o = i;
            if (i == 0) {
                this.f4400n = getContext();
            } else {
                this.f4400n = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f4409w = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f4407u = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f4406t = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f4408v = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        N0 n02 = new N0(context, attributeSet);
        n02.f8263a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0616a.f6574b);
        n02.f8263a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        n02.f8264b = 0;
        return n02;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0835p c0835p = this.f4398l;
        if (c0835p != null) {
            c0835p.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f4398l.setImageDrawable(drawable);
        } else {
            C0835p c0835p = this.f4398l;
            if (c0835p != null) {
                c0835p.setImageDrawable(this.f4396f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.e == null) {
                this.e = new C0837q(getContext(), null, 0);
            }
            if (!m(this.e)) {
                b(this.e, true);
            }
        } else {
            C0837q c0837q = this.e;
            if (c0837q != null && m(c0837q)) {
                removeView(this.e);
                this.f4382I.remove(this.e);
            }
        }
        C0837q c0837q2 = this.e;
        if (c0837q2 != null) {
            c0837q2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.e == null) {
            this.e = new C0837q(getContext(), null, 0);
        }
        C0837q c0837q = this.e;
        if (c0837q != null) {
            c0837q.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        C0835p c0835p = this.f4395d;
        if (c0835p != null) {
            c0835p.setContentDescription(charSequence);
            D.g0(this.f4395d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.f4395d)) {
                b(this.f4395d, true);
            }
        } else {
            C0835p c0835p = this.f4395d;
            if (c0835p != null && m(c0835p)) {
                removeView(this.f4395d);
                this.f4382I.remove(this.f4395d);
            }
        }
        C0835p c0835p2 = this.f4395d;
        if (c0835p2 != null) {
            c0835p2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0803B c0803b = this.f4394c;
            if (c0803b != null && m(c0803b)) {
                removeView(this.f4394c);
                this.f4382I.remove(this.f4394c);
            }
        } else {
            if (this.f4394c == null) {
                Context context = getContext();
                C0803B c0803b2 = new C0803B(context, null);
                this.f4394c = c0803b2;
                c0803b2.setSingleLine();
                this.f4394c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f4403q;
                if (i != 0) {
                    this.f4394c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f4378E;
                if (colorStateList != null) {
                    this.f4394c.setTextColor(colorStateList);
                }
            }
            if (!m(this.f4394c)) {
                b(this.f4394c, true);
            }
        }
        C0803B c0803b3 = this.f4394c;
        if (c0803b3 != null) {
            c0803b3.setText(charSequence);
        }
        this.f4376C = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f4378E = colorStateList;
        C0803B c0803b = this.f4394c;
        if (c0803b != null) {
            c0803b.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0803B c0803b = this.f4393b;
            if (c0803b != null && m(c0803b)) {
                removeView(this.f4393b);
                this.f4382I.remove(this.f4393b);
            }
        } else {
            if (this.f4393b == null) {
                Context context = getContext();
                C0803B c0803b2 = new C0803B(context, null);
                this.f4393b = c0803b2;
                c0803b2.setSingleLine();
                this.f4393b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f4402p;
                if (i != 0) {
                    this.f4393b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f4377D;
                if (colorStateList != null) {
                    this.f4393b.setTextColor(colorStateList);
                }
            }
            if (!m(this.f4393b)) {
                b(this.f4393b, true);
            }
        }
        C0803B c0803b3 = this.f4393b;
        if (c0803b3 != null) {
            c0803b3.setText(charSequence);
        }
        this.f4375B = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f4377D = colorStateList;
        C0803B c0803b = this.f4393b;
        if (c0803b != null) {
            c0803b.setTextColor(colorStateList);
        }
    }

    public void setOnMenuItemClickListener(O0 o02) {
    }
}
