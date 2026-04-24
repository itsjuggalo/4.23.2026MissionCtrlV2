package androidx.coordinatorlayout.widget;

import Q.AbstractC0677s;
import Q.C;
import Q.D;
import Q.E;
import Q.F;
import Q.N;
import Q.W;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements C, D {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Class[] f7207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ThreadLocal f7208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Comparator f7209x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final P.c f7210y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D.b f7212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f7214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f7215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f7216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f7217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f7220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f7221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f7222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f7223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public W f7225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f7227q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f7228r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public F f7229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final E f7230t;

    public class a implements F {
        public a() {
        }

        @Override // Q.F
        public W a(View view, W w7) {
            return CoordinatorLayout.this.U(w7);
        }
    }

    public static abstract class b {
        public b() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
            if (i8 == 0) {
                return z(coordinatorLayout, view, view2, view3, i7);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i7) {
            if (i7 == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int i10) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f7, float f8, boolean z7) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f7, float f8) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr, int i9) {
            if (i9 == 0) {
                p(coordinatorLayout, view, view2, i7, i8, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11) {
            if (i11 == 0) {
                r(coordinatorLayout, view, view2, i7, i8, i9, i10);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
            iArr[0] = iArr[0] + i9;
            iArr[1] = iArr[1] + i10;
            s(coordinatorLayout, view, view2, i7, i8, i9, i10, i11);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
            if (i8 == 0) {
                u(coordinatorLayout, view, view2, view3, i7);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z7) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7) {
            return false;
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public W f(CoordinatorLayout coordinatorLayout, View view, W w7) {
            return w7;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class value();
    }

    public class d implements ViewGroup.OnHierarchyChangeListener {
        public d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7228r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.F(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7228r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.F(0);
            return true;
        }
    }

    public static class h implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fJ = N.J(view);
            float fJ2 = N.J(view2);
            if (fJ > fJ2) {
                return -1;
            }
            return fJ < fJ2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f7206u = r02 != null ? r02.getName() : null;
        f7209x = new h();
        f7207v = new Class[]{Context.class, AttributeSet.class};
        f7208w = new ThreadLocal();
        f7210y = new P.e(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C.a.f845a);
    }

    public static b I(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f7206u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + com.amazon.a.a.o.c.a.b.f10001a + str;
            }
        }
        try {
            ThreadLocal threadLocal = f7208w;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f7207v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e7) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e7);
        }
    }

    public static void M(Rect rect) {
        rect.setEmpty();
        f7210y.a(rect);
    }

    public static int P(int i7) {
        if (i7 == 0) {
            return 17;
        }
        return i7;
    }

    public static int Q(int i7) {
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        return (i7 & 112) == 0 ? i7 | 48 : i7;
    }

    public static int R(int i7) {
        if (i7 == 0) {
            return 8388661;
        }
        return i7;
    }

    public static Rect g() {
        Rect rect = (Rect) f7210y.b();
        return rect == null ? new Rect() : rect;
    }

    private static int i(int i7, int i8, int i9) {
        return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
    }

    public final void A(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        Rect rectG = g();
        rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.f7225o != null && N.w(this) && !N.w(view)) {
            rectG.left += this.f7225o.i();
            rectG.top += this.f7225o.k();
            rectG.right -= this.f7225o.j();
            rectG.bottom -= this.f7225o.h();
        }
        Rect rectG2 = g();
        AbstractC0677s.a(Q(eVar.f7235c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i7);
        view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        M(rectG);
        M(rectG2);
    }

    public final void B(View view, View view2, int i7) {
        Rect rectG = g();
        Rect rectG2 = g();
        try {
            r(view2, rectG);
            s(view, i7, rectG, rectG2);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        } finally {
            M(rectG);
            M(rectG2);
        }
    }

    public final void C(View view, int i7, int i8) {
        e eVar = (e) view.getLayoutParams();
        int iB = AbstractC0677s.b(R(eVar.f7235c), i8);
        int i9 = iB & 7;
        int i10 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i8 == 1) {
            i7 = width - i7;
        }
        int iU = u(i7) - measuredWidth;
        if (i9 == 1) {
            iU += measuredWidth / 2;
        } else if (i9 == 5) {
            iU += measuredWidth;
        }
        int i11 = i10 != 16 ? i10 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(iU, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    public final void D(View view, Rect rect, int i7) {
        boolean z7;
        boolean z8;
        int width;
        int i8;
        int i9;
        int i10;
        int height;
        int i11;
        int i12;
        int i13;
        if (N.P(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            Rect rectG = g();
            Rect rectG2 = g();
            rectG2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (bVarE == null || !bVarE.b(this, view, rectG)) {
                rectG.set(rectG2);
            } else if (!rectG2.contains(rectG)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectG.toShortString() + " | Bounds:" + rectG2.toShortString());
            }
            M(rectG2);
            if (rectG.isEmpty()) {
                M(rectG);
                return;
            }
            int iB = AbstractC0677s.b(eVar.f7240h, i7);
            boolean z9 = true;
            if ((iB & 48) != 48 || (i12 = (rectG.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f7242j) >= (i13 = rect.top)) {
                z7 = false;
            } else {
                T(view, i13 - i12);
                z7 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectG.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f7242j) < (i11 = rect.bottom)) {
                T(view, height - i11);
                z7 = true;
            }
            if (!z7) {
                T(view, 0);
            }
            if ((iB & 3) != 3 || (i9 = (rectG.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f7241i) >= (i10 = rect.left)) {
                z8 = false;
            } else {
                S(view, i10 - i9);
                z8 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectG.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f7241i) >= (i8 = rect.right)) {
                z9 = z8;
            } else {
                S(view, width - i8);
            }
            if (!z9) {
                S(view, 0);
            }
            M(rectG);
        }
    }

    public void E(View view, int i7) {
        b bVarE;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f7243k != null) {
            Rect rectG = g();
            Rect rectG2 = g();
            Rect rectG3 = g();
            r(eVar.f7243k, rectG);
            p(view, false, rectG2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            t(view, i7, rectG, rectG3, eVar, measuredWidth, measuredHeight);
            boolean z7 = (rectG3.left == rectG2.left && rectG3.top == rectG2.top) ? false : true;
            j(eVar, rectG3, measuredWidth, measuredHeight);
            int i8 = rectG3.left - rectG2.left;
            int i9 = rectG3.top - rectG2.top;
            if (i8 != 0) {
                N.V(view, i8);
            }
            if (i9 != 0) {
                N.W(view, i9);
            }
            if (z7 && (bVarE = eVar.e()) != null) {
                bVarE.h(this, view, eVar.f7243k);
            }
            M(rectG);
            M(rectG2);
            M(rectG3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.F(int):void");
    }

    public void G(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = eVar.f7243k;
        if (view2 != null) {
            B(view, view2, i7);
            return;
        }
        int i8 = eVar.f7237e;
        if (i8 >= 0) {
            C(view, i8, i7);
        } else {
            A(view, i7);
        }
    }

    public void H(View view, int i7, int i8, int i9, int i10) {
        measureChildWithMargins(view, i7, i8, i9, i10);
    }

    public final boolean J(MotionEvent motionEvent, int i7) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f7213c;
        x(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) list.get(i8);
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            if (!(zK || z7) || actionMasked == 0) {
                if (!zK && bVarE != null) {
                    if (i7 == 0) {
                        zK = bVarE.k(this, view, motionEvent);
                    } else if (i7 == 1) {
                        zK = bVarE.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f7221k = view;
                    }
                }
                boolean zC = eVar.c();
                boolean zH = eVar.h(this, view);
                z7 = zH && !zC;
                if (zH && !z7) {
                    break;
                }
            } else if (bVarE != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i7 == 0) {
                    bVarE.k(this, view, motionEventObtain);
                } else if (i7 == 1) {
                    bVarE.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    public final void K() {
        this.f7211a.clear();
        this.f7212b.c();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            e eVarW = w(childAt);
            eVarW.d(this, childAt);
            this.f7212b.b(childAt);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (i8 != i7) {
                    View childAt2 = getChildAt(i8);
                    if (eVarW.b(this, childAt, childAt2)) {
                        if (!this.f7212b.d(childAt2)) {
                            this.f7212b.b(childAt2);
                        }
                        this.f7212b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f7211a.addAll(this.f7212b.h());
        Collections.reverse(this.f7211a);
    }

    public void L(View view, Rect rect) {
        ((e) view.getLayoutParams()).p(rect);
    }

    public void N() {
        if (this.f7219i && this.f7223m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7223m);
        }
        this.f7224n = false;
    }

    public final void O(boolean z7) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (bVarE != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z7) {
                    bVarE.k(this, childAt, motionEventObtain);
                } else {
                    bVarE.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            ((e) getChildAt(i8).getLayoutParams()).l();
        }
        this.f7221k = null;
        this.f7218h = false;
    }

    public final void S(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = eVar.f7241i;
        if (i8 != i7) {
            N.V(view, i7 - i8);
            eVar.f7241i = i7;
        }
    }

    public final void T(View view, int i7) {
        e eVar = (e) view.getLayoutParams();
        int i8 = eVar.f7242j;
        if (i8 != i7) {
            N.W(view, i7 - i8);
            eVar.f7242j = i7;
        }
    }

    public final W U(W w7) {
        if (P.b.a(this.f7225o, w7)) {
            return w7;
        }
        this.f7225o = w7;
        boolean z7 = false;
        boolean z8 = w7 != null && w7.k() > 0;
        this.f7226p = z8;
        if (!z8 && getBackground() == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        W wK = k(w7);
        requestLayout();
        return wK;
    }

    public final void V() {
        if (!N.w(this)) {
            N.z0(this, null);
            return;
        }
        if (this.f7229s == null) {
            this.f7229s = new a();
        }
        N.z0(this, this.f7229s);
        setSystemUiVisibility(1280);
    }

    @Override // Q.D
    public void a(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        b bVarE;
        boolean z7;
        int iMin;
        int childCount = getChildCount();
        boolean z8 = false;
        int iMax = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i11) && (bVarE = eVar.e()) != null) {
                    int[] iArr2 = this.f7216f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVarE.t(this, childAt, view, i7, i8, i9, i10, i11, iArr2);
                    int[] iArr3 = this.f7216f;
                    iMax = i9 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i10 > 0) {
                        z7 = true;
                        iMin = Math.max(i12, this.f7216f[1]);
                    } else {
                        z7 = true;
                        iMin = Math.min(i12, this.f7216f[1]);
                    }
                    i12 = iMin;
                    z8 = z7;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i12;
        if (z8) {
            F(1);
        }
    }

    @Override // Q.C
    public void b(View view, int i7, int i8, int i9, int i10, int i11) {
        a(view, i7, i8, i9, i10, 0, this.f7217g);
    }

    @Override // Q.C
    public boolean c(View view, View view2, int i7, int i8) {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b bVarE = eVar.e();
                if (bVarE != null) {
                    boolean zA = bVarE.A(this, childAt, view, view2, i7, i8);
                    z7 |= zA;
                    eVar.q(i8, zA);
                } else {
                    eVar.q(i8, false);
                }
            }
        }
        return z7;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // Q.C
    public void d(View view, View view2, int i7, int i8) {
        b bVarE;
        this.f7230t.c(view, view2, i7, i8);
        this.f7222l = view2;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i8) && (bVarE = eVar.e()) != null) {
                bVarE.v(this, childAt, view, view2, i7, i8);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j7) {
        e eVar = (e) view.getLayoutParams();
        b bVar = eVar.f7233a;
        if (bVar != null) {
            float fD = bVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f7215e == null) {
                    this.f7215e = new Paint();
                }
                this.f7215e.setColor(eVar.f7233a.c(this, view));
                this.f7215e.setAlpha(i(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f7215e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7227q;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // Q.C
    public void e(View view, int i7) {
        this.f7230t.d(view, i7);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i7)) {
                b bVarE = eVar.e();
                if (bVarE != null) {
                    bVarE.C(this, childAt, view, i7);
                }
                eVar.k(i7);
                eVar.j();
            }
        }
        this.f7222l = null;
    }

    @Override // Q.C
    public void f(View view, int i7, int i8, int[] iArr, int i9) {
        b bVarE;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i9) && (bVarE = eVar.e()) != null) {
                    int[] iArr2 = this.f7216f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVarE.q(this, childAt, view, i7, i8, iArr2, i9);
                    int[] iArr3 = this.f7216f;
                    iMax = i7 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f7216f;
                    iMax2 = i8 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z7) {
            F(1);
        }
    }

    public final List<View> getDependencySortedChildren() {
        K();
        return Collections.unmodifiableList(this.f7211a);
    }

    public final W getLastWindowInsets() {
        return this.f7225o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f7230t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f7227q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void h() {
        if (this.f7219i) {
            if (this.f7223m == null) {
                this.f7223m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7223m);
        }
        this.f7224n = true;
    }

    public final void j(e eVar, Rect rect, int i7, int i8) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i7) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i8) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i7 + iMax, i8 + iMax2);
    }

    public final W k(W w7) {
        b bVarE;
        if (w7.n()) {
            return w7;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (N.w(childAt) && (bVarE = ((e) childAt.getLayoutParams()).e()) != null) {
                w7 = bVarE.f(this, childAt, w7);
                if (w7.n()) {
                    break;
                }
            }
        }
        return w7;
    }

    public void l() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            if (y(getChildAt(i7))) {
                z7 = true;
                break;
            }
            i7++;
        }
        if (z7 != this.f7224n) {
            if (z7) {
                h();
            } else {
                N();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O(false);
        if (this.f7224n) {
            if (this.f7223m == null) {
                this.f7223m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7223m);
        }
        if (this.f7225o == null && N.w(this)) {
            N.i0(this);
        }
        this.f7219i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O(false);
        if (this.f7224n && this.f7223m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7223m);
        }
        View view = this.f7222l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f7219i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7226p || this.f7227q == null) {
            return;
        }
        W w7 = this.f7225o;
        int iK = w7 != null ? w7.k() : 0;
        if (iK > 0) {
            this.f7227q.setBounds(0, 0, getWidth(), iK);
            this.f7227q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O(true);
        }
        boolean zJ = J(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            O(true);
        }
        return zJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        b bVarE;
        int iZ = N.z(this);
        int size = this.f7211a.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f7211a.get(i11);
            if (view.getVisibility() != 8 && ((bVarE = ((e) view.getLayoutParams()).e()) == null || !bVarE.l(this, view, iZ))) {
                G(view, iZ);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f7, float f8, boolean z7) {
        b bVarE;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (bVarE = eVar.e()) != null) {
                    zN |= bVarE.n(this, childAt, view, f7, f8, z7);
                }
            }
        }
        if (zN) {
            F(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f7, float f8) {
        b bVarE;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (bVarE = eVar.e()) != null) {
                    zO |= bVarE.o(this, childAt, view, f7, f8);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        f(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        b(view, i7, i8, i9, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i7) {
        d(view, view2, i7, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        SparseArray sparseArray = gVar.f7252c;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            b bVarE = w(childAt).e();
            if (id != -1 && bVarE != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVarE.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (id != -1 && bVarE != null && (parcelableY = bVarE.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        gVar.f7252c = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i7) {
        return c(view, view2, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        e(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f7221k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.J(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f7221k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.e()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f7221k
            boolean r6 = r6.D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f7221k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.O(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(View view, boolean z7, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z7) {
            r(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List q(View view) {
        List listG = this.f7212b.g(view);
        this.f7214d.clear();
        if (listG != null) {
            this.f7214d.addAll(listG);
        }
        return this.f7214d;
    }

    public void r(View view, Rect rect) {
        D.c.a(this, view, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        b bVarE = ((e) view.getLayoutParams()).e();
        if (bVarE == null || !bVarE.w(this, view, rect, z7)) {
            return super.requestChildRectangleOnScreen(view, rect, z7);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (!z7 || this.f7218h) {
            return;
        }
        O(false);
        this.f7218h = true;
    }

    public void s(View view, int i7, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        t(view, i7, rect, rect2, eVar, measuredWidth, measuredHeight);
        j(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z7) {
        super.setFitsSystemWindows(z7);
        V();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7228r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f7227q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7227q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f7227q.setState(getDrawableState());
                }
                J.a.g(this.f7227q, N.z(this));
                this.f7227q.setVisible(getVisibility() == 0, false);
                this.f7227q.setCallback(this);
            }
            N.c0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i7) {
        setStatusBarBackground(new ColorDrawable(i7));
    }

    public void setStatusBarBackgroundResource(int i7) {
        setStatusBarBackground(i7 != 0 ? G.a.getDrawable(getContext(), i7) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f7227q;
        if (drawable == null || drawable.isVisible() == z7) {
            return;
        }
        this.f7227q.setVisible(z7, false);
    }

    public final void t(View view, int i7, Rect rect, Rect rect2, e eVar, int i8, int i9) {
        int iB = AbstractC0677s.b(P(eVar.f7235c), i7);
        int iB2 = AbstractC0677s.b(Q(eVar.f7236d), i7);
        int i10 = iB & 7;
        int i11 = iB & 112;
        int i12 = iB2 & 7;
        int i13 = iB2 & 112;
        int iWidth = i12 != 1 ? i12 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i13 != 16 ? i13 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i10 == 1) {
            iWidth -= i8 / 2;
        } else if (i10 != 5) {
            iWidth -= i8;
        }
        if (i11 == 16) {
            iHeight -= i9 / 2;
        } else if (i11 != 80) {
            iHeight -= i9;
        }
        rect2.set(iWidth, iHeight, i8 + iWidth, i9 + iHeight);
    }

    public final int u(int i7) {
        int[] iArr = this.f7220j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i7);
            return 0;
        }
        if (i7 >= 0 && i7 < iArr.length) {
            return iArr[i7];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i7 + " out of range for " + this);
        return 0;
    }

    public void v(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).g());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7227q;
    }

    public e w(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f7234b) {
            c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (c) superclass.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    eVar.n((b) cVar.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e7) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e7);
                }
            }
            eVar.f7234b = true;
        }
        return eVar;
    }

    public final void x(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i7) : i7));
        }
        Comparator comparator = f7209x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean y(View view) {
        return this.f7212b.i(view);
    }

    public boolean z(View view, int i7, int i8) {
        Rect rectG = g();
        r(view, rectG);
        try {
            return rectG.contains(i7, i8);
        } finally {
            M(rectG);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f7211a = new ArrayList();
        this.f7212b = new D.b();
        this.f7213c = new ArrayList();
        this.f7214d = new ArrayList();
        this.f7216f = new int[2];
        this.f7217g = new int[2];
        this.f7230t = new E(this);
        TypedArray typedArrayObtainStyledAttributes = i7 == 0 ? context.obtainStyledAttributes(attributeSet, C.c.f848b, 0, C.b.f846a) : context.obtainStyledAttributes(attributeSet, C.c.f848b, i7, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i7 == 0) {
                saveAttributeDataForStyleable(context, C.c.f848b, attributeSet, typedArrayObtainStyledAttributes, 0, C.b.f846a);
            } else {
                saveAttributeDataForStyleable(context, C.c.f848b, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C.c.f849c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f7220j = resources.getIntArray(resourceId);
            float f7 = resources.getDisplayMetrics().density;
            int length = this.f7220j.length;
            for (int i8 = 0; i8 < length; i8++) {
                this.f7220j[i8] = (int) (r12[i8] * f7);
            }
        }
        this.f7227q = typedArrayObtainStyledAttributes.getDrawable(C.c.f850d);
        typedArrayObtainStyledAttributes.recycle();
        V();
        super.setOnHierarchyChangeListener(new d());
        if (N.x(this) == 0) {
            N.v0(this, 1);
        }
    }

    public static class g extends Z.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SparseArray f7252c;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i7) {
                return new g[i7];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i7 = parcel.readInt();
            int[] iArr = new int[i7];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f7252c = new SparseArray(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                this.f7252c.append(iArr[i8], parcelableArray[i8]);
            }
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            SparseArray sparseArray = this.f7252c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr[i8] = this.f7252c.keyAt(i8);
                parcelableArr[i8] = (Parcelable) this.f7252c.valueAt(i8);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i7);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f7233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7237e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7239g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7240h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7241i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7242j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f7243k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f7244l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7245m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7246n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7247o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7248p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Rect f7249q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f7250r;

        public e(int i7, int i8) {
            super(i7, i8);
            this.f7234b = false;
            this.f7235c = 0;
            this.f7236d = 0;
            this.f7237e = -1;
            this.f7238f = -1;
            this.f7239g = 0;
            this.f7240h = 0;
            this.f7249q = new Rect();
        }

        public boolean a() {
            return this.f7243k == null && this.f7238f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.f7244l || r(view2, N.z(coordinatorLayout)) || ((bVar = this.f7233a) != null && bVar.e(coordinatorLayout, view, view2));
        }

        public boolean c() {
            if (this.f7233a == null) {
                this.f7245m = false;
            }
            return this.f7245m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f7238f == -1) {
                this.f7244l = null;
                this.f7243k = null;
                return null;
            }
            if (this.f7243k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f7243k;
        }

        public b e() {
            return this.f7233a;
        }

        public boolean f() {
            return this.f7248p;
        }

        public Rect g() {
            return this.f7249q;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z7 = this.f7245m;
            if (z7) {
                return true;
            }
            b bVar = this.f7233a;
            boolean zA = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z7;
            this.f7245m = zA;
            return zA;
        }

        public boolean i(int i7) {
            if (i7 == 0) {
                return this.f7246n;
            }
            if (i7 != 1) {
                return false;
            }
            return this.f7247o;
        }

        public void j() {
            this.f7248p = false;
        }

        public void k(int i7) {
            q(i7, false);
        }

        public void l() {
            this.f7245m = false;
        }

        public final void m(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f7238f);
            this.f7243k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f7244l = null;
                    this.f7243k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f7238f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f7244l = null;
                this.f7243k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f7244l = null;
                    this.f7243k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f7244l = viewFindViewById;
        }

        public void n(b bVar) {
            b bVar2 = this.f7233a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.j();
                }
                this.f7233a = bVar;
                this.f7250r = null;
                this.f7234b = true;
                if (bVar != null) {
                    bVar.g(this);
                }
            }
        }

        public void o(boolean z7) {
            this.f7248p = z7;
        }

        public void p(Rect rect) {
            this.f7249q.set(rect);
        }

        public void q(int i7, boolean z7) {
            if (i7 == 0) {
                this.f7246n = z7;
            } else {
                if (i7 != 1) {
                    return;
                }
                this.f7247o = z7;
            }
        }

        public final boolean r(View view, int i7) {
            int iB = AbstractC0677s.b(((e) view.getLayoutParams()).f7239g, i7);
            return iB != 0 && (AbstractC0677s.b(this.f7240h, i7) & iB) == iB;
        }

        public final boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f7243k.getId() != this.f7238f) {
                return false;
            }
            View view2 = this.f7243k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f7244l = null;
                    this.f7243k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f7244l = view2;
            return true;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7234b = false;
            this.f7235c = 0;
            this.f7236d = 0;
            this.f7237e = -1;
            this.f7238f = -1;
            this.f7239g = 0;
            this.f7240h = 0;
            this.f7249q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.c.f851e);
            this.f7235c = typedArrayObtainStyledAttributes.getInteger(C.c.f852f, 0);
            this.f7238f = typedArrayObtainStyledAttributes.getResourceId(C.c.f853g, -1);
            this.f7236d = typedArrayObtainStyledAttributes.getInteger(C.c.f854h, 0);
            this.f7237e = typedArrayObtainStyledAttributes.getInteger(C.c.f858l, -1);
            this.f7239g = typedArrayObtainStyledAttributes.getInt(C.c.f857k, 0);
            this.f7240h = typedArrayObtainStyledAttributes.getInt(C.c.f856j, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C.c.f855i);
            this.f7234b = zHasValue;
            if (zHasValue) {
                this.f7233a = CoordinatorLayout.I(context, attributeSet, typedArrayObtainStyledAttributes.getString(C.c.f855i));
            }
            typedArrayObtainStyledAttributes.recycle();
            b bVar = this.f7233a;
            if (bVar != null) {
                bVar.g(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f7234b = false;
            this.f7235c = 0;
            this.f7236d = 0;
            this.f7237e = -1;
            this.f7238f = -1;
            this.f7239g = 0;
            this.f7240h = 0;
            this.f7249q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7234b = false;
            this.f7235c = 0;
            this.f7236d = 0;
            this.f7237e = -1;
            this.f7238f = -1;
            this.f7239g = 0;
            this.f7240h = 0;
            this.f7249q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7234b = false;
            this.f7235c = 0;
            this.f7236d = 0;
            this.f7237e = -1;
            this.f7238f = -1;
            this.f7239g = 0;
            this.f7240h = 0;
            this.f7249q = new Rect();
        }
    }
}
