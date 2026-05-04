package androidx.appcompat.widget;

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
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.google.android.gms.common.api.a;
import o.q;
import t0.c0;
import t0.j0;
import t0.s;
import t0.t;
import t0.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements s, t {
    public static final int[] F = {g.a.f9660b, R.attr.windowContentOverlay};
    public static final j0 G = new j0.a().c(l0.b.b(0, 1, 0, 1)).a();
    public static final Rect H = new Rect();
    public final AnimatorListenerAdapter A;
    public final Runnable B;
    public final Runnable C;
    public final u D;
    public final f E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f1143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f1144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f1145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f1153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f1154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f1155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f1156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f1157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f1158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f1159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f1160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j0 f1161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j0 f1162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j0 f1163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j0 f1164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OverScroller f1165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewPropertyAnimator f1166z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1166z = null;
            actionBarOverlayLayout.f1150j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1166z = null;
            actionBarOverlayLayout.f1150j = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1166z = actionBarOverlayLayout.f1144d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.A);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1166z = actionBarOverlayLayout.f1144d.animate().translationY(-ActionBarOverlayLayout.this.f1144d.getHeight()).setListener(ActionBarOverlayLayout.this.A);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends View {
        public f(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1142b = 0;
        this.f1153m = new Rect();
        this.f1154n = new Rect();
        this.f1155o = new Rect();
        this.f1156p = new Rect();
        this.f1157q = new Rect();
        this.f1158r = new Rect();
        this.f1159s = new Rect();
        this.f1160t = new Rect();
        j0 j0Var = j0.f20501b;
        this.f1161u = j0Var;
        this.f1162v = j0Var;
        this.f1163w = j0Var;
        this.f1164x = j0Var;
        this.A = new a();
        this.B = new b();
        this.C = new c();
        n(context);
        this.D = new u(this);
        f fVar = new f(context);
        this.E = fVar;
        addView(fVar);
    }

    @Override // t0.t
    public void a(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        b(view, i10, i11, i12, i13, i14);
    }

    @Override // t0.s
    public void b(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // t0.s
    public boolean c(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // t0.s
    public void d(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1146f != null) {
            int bottom = this.f1144d.getVisibility() == 0 ? (int) (this.f1144d.getBottom() + this.f1144d.getTranslationY() + 0.5f) : 0;
            this.f1146f.setBounds(0, bottom, getWidth(), this.f1146f.getIntrinsicHeight() + bottom);
            this.f1146f.draw(canvas);
        }
    }

    @Override // t0.s
    public void e(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // t0.s
    public void f(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final void g() {
        m();
        this.C.run();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1144d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.D.a();
    }

    public CharSequence getTitle() {
        q();
        return this.f1145e.getTitle();
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

    public final boolean i() {
        c0.b(this.E, G, this.f1156p);
        return !this.f1156p.equals(H);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q l(View view) {
        if (view instanceof q) {
            return (q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void m() {
        removeCallbacks(this.B);
        removeCallbacks(this.C);
        ViewPropertyAnimator viewPropertyAnimator = this.f1166z;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void n(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(F);
        this.f1141a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1146f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1165y = new OverScroller(context);
    }

    public final void o() {
        m();
        postDelayed(this.C, 600L);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        q();
        j0 j0VarW = j0.w(windowInsets, this);
        boolean zH = h(this.f1144d, new Rect(j0VarW.i(), j0VarW.k(), j0VarW.j(), j0VarW.h()), true, true, false, true);
        c0.b(this, j0VarW, this.f1153m);
        Rect rect = this.f1153m;
        j0 j0VarL = j0VarW.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f1161u = j0VarL;
        boolean z10 = true;
        if (!this.f1162v.equals(j0VarL)) {
            this.f1162v = this.f1161u;
            zH = true;
        }
        if (this.f1154n.equals(this.f1153m)) {
            z10 = zH;
        } else {
            this.f1154n.set(this.f1153m);
        }
        if (z10) {
            requestLayout();
        }
        return j0VarW.a().c().b().u();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n(getContext());
        c0.H(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        q();
        measureChildWithMargins(this.f1144d, i10, 0, i11, 0);
        e eVar = (e) this.f1144d.getLayoutParams();
        int iMax = Math.max(0, this.f1144d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f1144d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1144d.getMeasuredState());
        boolean z10 = (c0.w(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1141a;
            if (this.f1148h && this.f1144d.getTabContainer() != null) {
                measuredHeight += this.f1141a;
            }
        } else {
            measuredHeight = this.f1144d.getVisibility() != 8 ? this.f1144d.getMeasuredHeight() : 0;
        }
        this.f1155o.set(this.f1153m);
        this.f1163w = this.f1161u;
        if (this.f1147g || z10 || !i()) {
            this.f1163w = new j0.a(this.f1163w).c(l0.b.b(this.f1163w.i(), this.f1163w.k() + measuredHeight, this.f1163w.j(), this.f1163w.h())).a();
        } else {
            Rect rect = this.f1155o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1163w = this.f1163w.l(0, measuredHeight, 0, 0);
        }
        h(this.f1143c, this.f1155o, true, true, true, true);
        if (!this.f1164x.equals(this.f1163w)) {
            j0 j0Var = this.f1163w;
            this.f1164x = j0Var;
            c0.c(this.f1143c, j0Var);
        }
        measureChildWithMargins(this.f1143c, i10, 0, i11, 0);
        e eVar2 = (e) this.f1143c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1143c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1143c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1143c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1149i || !z10) {
            return false;
        }
        if (s(f11)) {
            g();
        } else {
            r();
        }
        this.f1150j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1151k + i11;
        this.f1151k = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.D.b(view, view2, i10);
        this.f1151k = getActionBarHideOffset();
        m();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1144d.getVisibility() != 0) {
            return false;
        }
        return this.f1149i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (!this.f1149i || this.f1150j) {
            return;
        }
        if (this.f1151k <= this.f1144d.getHeight()) {
            p();
        } else {
            o();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        q();
        this.f1152l = i10;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1142b = i10;
    }

    public final void p() {
        m();
        postDelayed(this.B, 600L);
    }

    public void q() {
        if (this.f1143c == null) {
            this.f1143c = (ContentFrameLayout) findViewById(g.e.f9719b);
            this.f1144d = (ActionBarContainer) findViewById(g.e.f9720c);
            this.f1145e = l(findViewById(g.e.f9718a));
        }
    }

    public final void r() {
        m();
        this.B.run();
    }

    public final boolean s(float f10) {
        this.f1165y.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
        return this.f1165y.getFinalY() > this.f1144d.getHeight();
    }

    public void setActionBarHideOffset(int i10) {
        m();
        this.f1144d.setTranslationY(-Math.max(0, Math.min(i10, this.f1144d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        if (getWindowToken() != null) {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1148h = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1149i) {
            this.f1149i = z10;
            if (z10) {
                return;
            }
            m();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        q();
        this.f1145e.setIcon(i10);
    }

    public void setLogo(int i10) {
        q();
        this.f1145e.b(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f1147g = z10;
    }

    public void setWindowCallback(Window.Callback callback) {
        q();
        this.f1145e.c(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        q();
        this.f1145e.a(charSequence);
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
        q();
        this.f1145e.setIcon(drawable);
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }
}
