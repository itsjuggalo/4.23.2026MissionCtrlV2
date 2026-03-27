package androidx.appcompat.widget;

import H.C0288w;
import H.E;
import H.InterfaceC0286u;
import H.InterfaceC0287v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import g.AbstractC1248a;
import g.AbstractC1252e;
import o.InterfaceC1634A;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0286u, InterfaceC0287v {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final int[] f6523B = {AbstractC1248a.f11543b, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final C0288w f6524A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f6527c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionBarContainer f6528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC1634A f6529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f6538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f6539p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f6540q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f6541r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f6542s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f6543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f6544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OverScroller f6545v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimator f6546w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AnimatorListenerAdapter f6547x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f6548y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Runnable f6549z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f6546w = null;
            actionBarOverlayLayout.f6535l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f6546w = null;
            actionBarOverlayLayout.f6535l = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.l();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f6546w = actionBarOverlayLayout.f6528e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f6547x);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.l();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f6546w = actionBarOverlayLayout.f6528e.animate().translationY(-ActionBarOverlayLayout.this.f6528e.getHeight()).setListener(ActionBarOverlayLayout.this.f6547x);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i4, int i5) {
            super(i4, i5);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6526b = 0;
        this.f6538o = new Rect();
        this.f6539p = new Rect();
        this.f6540q = new Rect();
        this.f6541r = new Rect();
        this.f6542s = new Rect();
        this.f6543t = new Rect();
        this.f6544u = new Rect();
        this.f6547x = new a();
        this.f6548y = new b();
        this.f6549z = new c();
        m(context);
        this.f6524A = new C0288w(this);
    }

    @Override // H.InterfaceC0287v
    public void a(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        b(view, i4, i5, i6, i7, i8);
    }

    @Override // H.InterfaceC0286u
    public void b(View view, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(view, i4, i5, i6, i7);
        }
    }

    @Override // H.InterfaceC0286u
    public boolean c(View view, View view2, int i4, int i5) {
        return i5 == 0 && onStartNestedScroll(view, view2, i4);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // H.InterfaceC0286u
    public void d(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f6530g == null || this.f6531h) {
            return;
        }
        int bottom = this.f6528e.getVisibility() == 0 ? (int) (this.f6528e.getBottom() + this.f6528e.getTranslationY() + 0.5f) : 0;
        this.f6530g.setBounds(0, bottom, getWidth(), this.f6530g.getIntrinsicHeight() + bottom);
        this.f6530g.draw(canvas);
    }

    @Override // H.InterfaceC0286u
    public void e(View view, int i4) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // H.InterfaceC0286u
    public void f(View view, int i4, int i5, int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(view, i4, i5, iArr);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        p();
        E.t(this);
        boolean zH = h(this.f6528e, rect, true, true, false, true);
        this.f6541r.set(rect);
        g0.a(this, this.f6541r, this.f6538o);
        if (!this.f6542s.equals(this.f6541r)) {
            this.f6542s.set(this.f6541r);
            zH = true;
        }
        if (!this.f6539p.equals(this.f6538o)) {
            this.f6539p.set(this.f6538o);
            zH = true;
        }
        if (zH) {
            requestLayout();
        }
        return true;
    }

    public final void g() {
        l();
        this.f6549z.run();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f6528e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f6524A.a();
    }

    public CharSequence getTitle() {
        p();
        return this.f6529f.getTitle();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            return r0
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.h(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InterfaceC1634A k(View view) {
        if (view instanceof InterfaceC1634A) {
            return (InterfaceC1634A) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void l() {
        removeCallbacks(this.f6548y);
        removeCallbacks(this.f6549z);
        ViewPropertyAnimator viewPropertyAnimator = this.f6546w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void m(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f6523B);
        this.f6525a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f6530g = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f6531h = context.getApplicationInfo().targetSdkVersion < 19;
        this.f6545v = new OverScroller(context);
    }

    public final void n() {
        l();
        postDelayed(this.f6549z, 600L);
    }

    public final void o() {
        l();
        postDelayed(this.f6548y, 600L);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m(getContext());
        E.F(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i10 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        p();
        measureChildWithMargins(this.f6528e, i4, 0, i5, 0);
        e eVar = (e) this.f6528e.getLayoutParams();
        int measuredHeight = 0;
        int iMax = Math.max(0, this.f6528e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f6528e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f6528e.getMeasuredState());
        boolean z4 = (E.t(this) & 256) != 0;
        if (z4) {
            measuredHeight = this.f6525a;
            if (this.f6533j && this.f6528e.getTabContainer() != null) {
                measuredHeight += this.f6525a;
            }
        } else if (this.f6528e.getVisibility() != 8) {
            measuredHeight = this.f6528e.getMeasuredHeight();
        }
        this.f6540q.set(this.f6538o);
        this.f6543t.set(this.f6541r);
        if (this.f6532i || z4) {
            Rect rect = this.f6543t;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
        } else {
            Rect rect2 = this.f6540q;
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
        }
        h(this.f6527c, this.f6540q, true, true, true, true);
        if (!this.f6544u.equals(this.f6543t)) {
            this.f6544u.set(this.f6543t);
            this.f6527c.a(this.f6543t);
        }
        measureChildWithMargins(this.f6527c, i4, 0, i5, 0);
        e eVar2 = (e) this.f6527c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f6527c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f6527c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f6527c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (!this.f6534k || !z4) {
            return false;
        }
        if (r(f4, f5)) {
            g();
        } else {
            q();
        }
        this.f6535l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        int i8 = this.f6536m + i5;
        this.f6536m = i8;
        setActionBarHideOffset(i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        this.f6524A.b(view, view2, i4);
        this.f6536m = getActionBarHideOffset();
        l();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f6528e.getVisibility() != 0) {
            return false;
        }
        return this.f6534k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (!this.f6534k || this.f6535l) {
            return;
        }
        if (this.f6536m <= this.f6528e.getHeight()) {
            o();
        } else {
            n();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i4) {
        super.onWindowSystemUiVisibilityChanged(i4);
        p();
        this.f6537n = i4;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f6526b = i4;
    }

    public void p() {
        if (this.f6527c == null) {
            this.f6527c = (ContentFrameLayout) findViewById(AbstractC1252e.f11627b);
            this.f6528e = (ActionBarContainer) findViewById(AbstractC1252e.f11628c);
            this.f6529f = k(findViewById(AbstractC1252e.f11626a));
        }
    }

    public final void q() {
        l();
        this.f6548y.run();
    }

    public final boolean r(float f4, float f5) {
        this.f6545v.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f6545v.getFinalY() > this.f6528e.getHeight();
    }

    public void setActionBarHideOffset(int i4) {
        l();
        this.f6528e.setTranslationY(-Math.max(0, Math.min(i4, this.f6528e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        if (getWindowToken() != null) {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f6533j = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f6534k) {
            this.f6534k = z4;
            if (z4) {
                return;
            }
            l();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i4) {
        p();
        this.f6529f.setIcon(i4);
    }

    public void setLogo(int i4) {
        p();
        this.f6529f.b(i4);
    }

    public void setOverlayMode(boolean z4) {
        this.f6532i = z4;
        this.f6531h = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i4) {
    }

    public void setWindowCallback(Window.Callback callback) {
        p();
        this.f6529f.c(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        p();
        this.f6529f.a(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        p();
        this.f6529f.setIcon(drawable);
    }
}
