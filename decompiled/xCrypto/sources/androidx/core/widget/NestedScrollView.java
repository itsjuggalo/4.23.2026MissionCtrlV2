package androidx.core.widget;

import H.AbstractC0284s;
import H.C0267a;
import H.C0271e;
import H.C0285t;
import H.C0288w;
import H.E;
import H.InterfaceC0272f;
import H.InterfaceC0287v;
import I.t;
import I.x;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import v.AbstractC1869a;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0287v {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final float f6862D = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final a f6863E = new a();

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final int[] f6864F = {R.attr.fillViewport};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f6865A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final c f6866B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public C0271e f6867C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f6870c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f6871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f6872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeEffect f6873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f6877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f6879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6881o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6882p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6883q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6884r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6885s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f6886t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f6887u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6888v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6889w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f6890x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final C0288w f6891y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0285t f6892z;

    public static class a extends C0267a {
        @Override // H.C0267a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            x.a(accessibilityEvent, nestedScrollView.getScrollX());
            x.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // H.C0267a
        public void g(View view, t tVar) {
            int scrollRange;
            super.g(view, tVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            tVar.W(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            tVar.b0(true);
            if (nestedScrollView.getScrollY() > 0) {
                tVar.b(t.a.f811q);
                tVar.b(t.a.f778B);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                tVar.b(t.a.f810p);
                tVar.b(t.a.f780D);
            }
        }

        @Override // H.C0267a
        public boolean j(View view, int i4, Bundle bundle) {
            if (super.j(view, i4, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i4 != 4096) {
                if (i4 == 8192 || i4 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.W(0, iMax, true);
                    return true;
                }
                if (i4 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.W(0, iMin, true);
            return true;
        }
    }

    public static class b {
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public class c implements InterfaceC0272f {
        public c() {
        }

        @Override // H.InterfaceC0272f
        public boolean a(float f4) {
            if (f4 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.v((int) f4);
            return true;
        }

        @Override // H.InterfaceC0272f
        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // H.InterfaceC0272f
        public void c() {
            NestedScrollView.this.f6871e.abortAnimation();
        }
    }

    public interface d {
    }

    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6894a;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i4) {
                return new e[i4];
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f6894a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f6894a);
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f6894a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1869a.f15114c);
    }

    public static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    public static int l(int i4, int i5, int i6) {
        if (i5 >= i6 || i4 < 0) {
            return 0;
        }
        return i5 + i4 > i6 ? i6 - i5 : i4;
    }

    public final void A() {
        VelocityTracker velocityTracker = this.f6879m;
        if (velocityTracker == null) {
            this.f6879m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void B() {
        this.f6871e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f6882p = viewConfiguration.getScaledTouchSlop();
        this.f6883q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6884r = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void C() {
        if (this.f6879m == null) {
            this.f6879m = VelocityTracker.obtain();
        }
    }

    public final void D(int i4, int i5) {
        this.f6874h = i4;
        this.f6885s = i5;
        X(2, 0);
    }

    public final boolean E(View view) {
        return !G(view, 0, getHeight());
    }

    public final boolean G(View view, int i4, int i5) {
        view.getDrawingRect(this.f6870c);
        offsetDescendantRectToMyCoords(view, this.f6870c);
        return this.f6870c.bottom + i4 >= getScrollY() && this.f6870c.top - i4 <= getScrollY() + i5;
    }

    public final void H(int i4, int i5, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f6892z.e(0, scrollY2, 0, i4 - scrollY2, null, i5, iArr);
    }

    public final void I(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f6885s) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.f6874h = (int) motionEvent.getY(i4);
            this.f6885s = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.f6879m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean J(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z4) {
        boolean z5;
        boolean z6;
        int i12;
        int overScrollMode = getOverScrollMode();
        boolean z7 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z8 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z9 = overScrollMode == 0 || (overScrollMode == 1 && z7);
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        int i13 = i6 + i4;
        int i14 = !z9 ? 0 : i10;
        int i15 = i7 + i5;
        int i16 = !z10 ? 0 : i11;
        int i17 = -i14;
        int i18 = i14 + i8;
        int i19 = -i16;
        int i20 = i16 + i9;
        if (i13 > i18) {
            i13 = i18;
            z5 = true;
        } else if (i13 < i17) {
            z5 = true;
            i13 = i17;
        } else {
            z5 = false;
        }
        if (i15 > i20) {
            i15 = i20;
            z6 = true;
        } else if (i15 < i19) {
            z6 = true;
            i15 = i19;
        } else {
            z6 = false;
        }
        if (!z6 || y(1)) {
            i12 = i13;
        } else {
            int i21 = i13;
            this.f6871e.springBack(i21, i15, 0, 0, 0, getScrollRange());
            i12 = i21;
        }
        onOverScrolled(i12, i15, z5, z6);
        return z5 || z6;
    }

    public boolean K(int i4) {
        boolean z4 = i4 == 130;
        int height = getHeight();
        if (z4) {
            this.f6870c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f6870c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f6870c.top = getScrollY() - height;
            Rect rect2 = this.f6870c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f6870c;
        int i5 = rect3.top;
        int i6 = height + i5;
        rect3.bottom = i6;
        return O(i4, i5, i6);
    }

    public final void L() {
        VelocityTracker velocityTracker = this.f6879m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6879m = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f6872f
            float r0 = M.c.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f6872f
            float r4 = -r4
            float r4 = M.c.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f6872f
            float r5 = M.c.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f6872f
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f6873g
            float r0 = M.c.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f6873g
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = M.c.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f6873g
            float r5 = M.c.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f6873g
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.M(int, float):int");
    }

    public final void N(boolean z4) {
        if (z4) {
            X(2, 1);
        } else {
            Z(1);
        }
        this.f6889w = getScrollY();
        postInvalidateOnAnimation();
    }

    public final boolean O(int i4, int i5, int i6) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = height + scrollY;
        boolean z4 = false;
        boolean z5 = i4 == 33;
        View viewU = u(z5, i5, i6);
        if (viewU == null) {
            viewU = this;
        }
        if (i5 < scrollY || i6 > i7) {
            P(z5 ? i5 - scrollY : i6 - i7, 0, 1, true);
            z4 = true;
        }
        if (viewU != findFocus()) {
            viewU.requestFocus(i4);
        }
        return z4;
    }

    public final int P(int i4, int i5, int i6, boolean z4) {
        int i7;
        int i8;
        VelocityTracker velocityTracker;
        if (i6 == 1) {
            X(2, i6);
        }
        boolean z5 = false;
        if (o(0, i4, this.f6887u, this.f6886t, i6)) {
            int i9 = i4 - this.f6887u[1];
            i8 = this.f6886t[1];
            i7 = i9;
        } else {
            i7 = i4;
            i8 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z6 = j() && !z4;
        int i10 = i7;
        boolean z7 = J(0, i7, 0, scrollY, 0, scrollRange, 0, 0, true) && !y(i6);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f6887u;
        iArr[1] = 0;
        p(0, scrollY2, 0, i10 - scrollY2, this.f6886t, i6, iArr);
        int i11 = i8 + this.f6886t[1];
        int i12 = i10 - this.f6887u[1];
        int i13 = scrollY + i12;
        if (i13 < 0) {
            if (z6) {
                M.c.d(this.f6872f, (-i12) / getHeight(), i5 / getWidth());
                if (!this.f6873g.isFinished()) {
                    this.f6873g.onRelease();
                }
            }
        } else if (i13 > scrollRange && z6) {
            M.c.d(this.f6873g, i12 / getHeight(), 1.0f - (i5 / getWidth()));
            if (!this.f6872f.isFinished()) {
                this.f6872f.onRelease();
            }
        }
        if (this.f6872f.isFinished() && this.f6873g.isFinished()) {
            z5 = z7;
        } else {
            postInvalidateOnAnimation();
        }
        if (z5 && i6 == 0 && (velocityTracker = this.f6879m) != null) {
            velocityTracker.clear();
        }
        if (i6 == 1) {
            Z(i6);
            this.f6872f.onRelease();
            this.f6873g.onRelease();
        }
        return i11;
    }

    public final void Q(View view) {
        view.getDrawingRect(this.f6870c);
        offsetDescendantRectToMyCoords(view, this.f6870c);
        int iM = m(this.f6870c);
        if (iM != 0) {
            scrollBy(0, iM);
        }
    }

    public final boolean R(Rect rect, boolean z4) {
        int iM = m(rect);
        boolean z5 = iM != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, iM);
                return z5;
            }
            T(0, iM);
        }
        return z5;
    }

    public final boolean S(EdgeEffect edgeEffect, int i4) {
        if (i4 > 0) {
            return true;
        }
        return x(-i4) < M.c.b(edgeEffect) * ((float) getHeight());
    }

    public final void T(int i4, int i5) {
        U(i4, i5, ExponentialBackoffSender.RND_MAX, false);
    }

    public final void U(int i4, int i5, int i6, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f6869b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f6871e.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i5 + scrollY, Math.max(0, height - height2))) - scrollY, i6);
            N(z4);
        } else {
            if (!this.f6871e.isFinished()) {
                g();
            }
            scrollBy(i4, i5);
        }
        this.f6869b = AnimationUtils.currentAnimationTimeMillis();
    }

    public void V(int i4, int i5, int i6, boolean z4) {
        U(i4 - getScrollX(), i5 - getScrollY(), i6, z4);
    }

    public void W(int i4, int i5, boolean z4) {
        V(i4, i5, ExponentialBackoffSender.RND_MAX, z4);
    }

    public boolean X(int i4, int i5) {
        return this.f6892z.q(i4, i5);
    }

    public final boolean Y(MotionEvent motionEvent) {
        boolean z4;
        if (M.c.b(this.f6872f) != 0.0f) {
            M.c.d(this.f6872f, 0.0f, motionEvent.getX() / getWidth());
            z4 = true;
        } else {
            z4 = false;
        }
        if (M.c.b(this.f6873g) == 0.0f) {
            return z4;
        }
        M.c.d(this.f6873g, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public void Z(int i4) {
        this.f6892z.s(i4);
    }

    @Override // H.InterfaceC0287v
    public void a(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        H(i7, i8, iArr);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // H.InterfaceC0286u
    public void b(View view, int i4, int i5, int i6, int i7, int i8) {
        H(i7, i8, null);
    }

    @Override // H.InterfaceC0286u
    public boolean c(View view, View view2, int i4, int i5) {
        return (i4 & 2) != 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        int i4;
        if (this.f6871e.isFinished()) {
            return;
        }
        this.f6871e.computeScrollOffset();
        int currY = this.f6871e.getCurrY();
        int iN = n(currY - this.f6889w);
        this.f6889w = currY;
        int[] iArr = this.f6887u;
        iArr[1] = 0;
        o(0, iN, iArr, null, 1);
        int i5 = iN - this.f6887u[1];
        int scrollRange = getScrollRange();
        if (i5 != 0) {
            int scrollY = getScrollY();
            J(0, i5, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i4 = scrollRange;
            int scrollY2 = getScrollY() - scrollY;
            int i6 = i5 - scrollY2;
            int[] iArr2 = this.f6887u;
            iArr2[1] = 0;
            p(0, scrollY2, 0, i6, this.f6886t, 1, iArr2);
            i5 = i6 - this.f6887u[1];
        } else {
            i4 = scrollRange;
        }
        if (i5 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && i4 > 0)) {
                if (i5 < 0) {
                    if (this.f6872f.isFinished()) {
                        this.f6872f.onAbsorb((int) this.f6871e.getCurrVelocity());
                    }
                } else if (this.f6873g.isFinished()) {
                    this.f6873g.onAbsorb((int) this.f6871e.getCurrVelocity());
                }
            }
            g();
        }
        if (this.f6871e.isFinished()) {
            Z(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // H.InterfaceC0286u
    public void d(View view, View view2, int i4, int i5) {
        this.f6891y.c(view, view2, i4, i5);
        X(2, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return this.f6892z.a(f4, f5, z4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f6892z.b(f4, f5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return o(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.f6892z.f(i4, i5, i6, i7, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f6872f.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f6872f.setSize(width, height);
            if (this.f6872f.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f6873g.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f6873g.setSize(width2, height2);
        if (this.f6873g.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // H.InterfaceC0286u
    public void e(View view, int i4) {
        this.f6891y.d(view, i4);
        Z(i4);
    }

    @Override // H.InterfaceC0286u
    public void f(View view, int i4, int i5, int[] iArr, int i6) {
        o(i4, i5, iArr, null, i6);
    }

    public final void g() {
        this.f6871e.abortAnimation();
        Z(1);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f6891y.a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f6865A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f6865A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f6865A;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    public boolean i(int i4) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i4);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !G(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i4 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i4 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i4 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            P(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f6870c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f6870c);
            P(m(this.f6870c), 0, 1, true);
            viewFindNextFocus.requestFocus(i4);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && E(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f6892z.m();
    }

    public final boolean j() {
        int overScrollMode = getOverScrollMode();
        return overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0);
    }

    public final boolean k() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    public int m(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i5, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        }
        if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i5 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i4, int i5) {
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public int n(int i4) {
        int height = getHeight();
        if (i4 > 0 && M.c.b(this.f6872f) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * M.c.d(this.f6872f, ((-i4) * 4.0f) / height, 0.5f));
            if (iRound != i4) {
                this.f6872f.finish();
            }
            return i4 - iRound;
        }
        if (i4 >= 0 || M.c.b(this.f6873g) == 0.0f) {
            return i4;
        }
        float f4 = height;
        int iRound2 = Math.round((f4 / 4.0f) * M.c.d(this.f6873g, (i4 * 4.0f) / f4, 0.5f));
        if (iRound2 != i4) {
            this.f6873g.finish();
        }
        return i4 - iRound2;
    }

    public boolean o(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return this.f6892z.d(i4, i5, iArr, iArr2, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6876j = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i4;
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.f6878l) {
            if (AbstractC0284s.a(motionEvent, 2)) {
                i4 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (AbstractC0284s.a(motionEvent, 4194304)) {
                float axisValue2 = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i4 = 26;
                axisValue = axisValue2;
            } else {
                i4 = 0;
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                P(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, AbstractC0284s.a(motionEvent, 8194));
                if (i4 != 0) {
                    this.f6867C.g(motionEvent, i4);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int measuredHeight = 0;
        this.f6875i = false;
        View view = this.f6877k;
        if (view != null && F(view, this)) {
            Q(this.f6877k);
        }
        this.f6877k = null;
        if (!this.f6876j) {
            if (this.f6890x != null) {
                scrollTo(getScrollX(), this.f6890x.f6894a);
                this.f6890x = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iL = l(scrollY, paddingTop, measuredHeight);
            if (iL != scrollY) {
                scrollTo(getScrollX(), iL);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f6876j = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f6880n && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f5, true);
        v((int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        f(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        H(i7, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        d(view, view2, i4, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i4, int i5, boolean z4, boolean z5) {
        super.scrollTo(i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (i4 == 2) {
            i4 = 130;
        } else if (i4 == 1) {
            i4 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i4) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i4);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i4, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f6890x = eVar;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f6894a = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    public void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
    }

    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !G(viewFindFocus, 0, i7)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f6870c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f6870c);
        q(m(this.f6870c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        return c(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        e(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        C();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6888v = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f6888v);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f6879m;
                velocityTracker.computeCurrentVelocity(1000, this.f6884r);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f6885s);
                if (Math.abs(yVelocity) >= this.f6883q) {
                    if (!r(yVelocity)) {
                        int i4 = -yVelocity;
                        float f4 = i4;
                        if (!dispatchNestedPreFling(0.0f, f4)) {
                            dispatchNestedFling(0.0f, f4, true);
                            v(i4);
                        }
                    }
                } else if (this.f6871e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f6885s);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f6885s + " in onTouchEvent");
                } else {
                    int y4 = (int) motionEvent.getY(iFindPointerIndex);
                    int i5 = this.f6874h - y4;
                    int iM = i5 - M(i5, motionEvent.getX(iFindPointerIndex));
                    if (!this.f6878l && Math.abs(iM) > this.f6882p) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f6878l = true;
                        iM = iM > 0 ? iM - this.f6882p : iM + this.f6882p;
                    }
                    if (this.f6878l) {
                        int iP = P(iM, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f6874h = y4 - iP;
                        this.f6888v += iP;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f6878l && getChildCount() > 0 && this.f6871e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f6874h = (int) motionEvent.getY(actionIndex);
                this.f6885s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                I(motionEvent);
                this.f6874h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f6885s));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f6878l && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f6871e.isFinished()) {
                g();
            }
            D((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f6879m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void p(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        this.f6892z.e(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    public final void q(int i4) {
        if (i4 != 0) {
            if (this.f6881o) {
                T(0, i4);
            } else {
                scrollBy(0, i4);
            }
        }
    }

    public final boolean r(int i4) {
        if (M.c.b(this.f6872f) != 0.0f) {
            if (S(this.f6872f, i4)) {
                this.f6872f.onAbsorb(i4);
                return true;
            }
            v(-i4);
            return true;
        }
        if (M.c.b(this.f6873g) == 0.0f) {
            return false;
        }
        int i5 = -i4;
        if (S(this.f6873g, i5)) {
            this.f6873g.onAbsorb(i5);
            return true;
        }
        v(i5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f6875i) {
            this.f6877k = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z4) {
        if (z4) {
            L();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f6875i = true;
        super.requestLayout();
    }

    public final void s() {
        this.f6885s = -1;
        this.f6878l = false;
        L();
        Z(0);
        this.f6872f.onRelease();
        this.f6873g.onRelease();
    }

    @Override // android.view.View
    public void scrollTo(int i4, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iL = l(i4, width, width2);
            int iL2 = l(i5, height, height2);
            if (iL == getScrollX() && iL2 == getScrollY()) {
                return;
            }
            super.scrollTo(iL, iL2);
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f6880n) {
            this.f6880n = z4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        this.f6892z.n(z4);
    }

    public void setOnScrollChangeListener(d dVar) {
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f6881o = z4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return X(i4, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Z(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f6870c.setEmpty();
        if (!k()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus != null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return keyEvent.isAltPressed() ? w(33) : i(33);
            }
            if (keyCode == 20) {
                return keyEvent.isAltPressed() ? w(130) : i(130);
            }
            if (keyCode == 62) {
                K(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
            if (keyCode == 92) {
                return w(33);
            }
            if (keyCode == 93) {
                return w(130);
            }
            if (keyCode == 122) {
                K(33);
                return false;
            }
            if (keyCode == 123) {
                K(130);
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View u(boolean r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 2
            java.util.ArrayList r0 = r12.getFocusables(r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            if (r4 >= r1) goto L53
            java.lang.Object r6 = r0.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getTop()
            int r8 = r6.getBottom()
            if (r14 >= r8) goto L50
            if (r7 >= r15) goto L50
            r9 = 1
            if (r14 >= r7) goto L28
            if (r8 >= r15) goto L28
            r10 = r9
            goto L29
        L28:
            r10 = r3
        L29:
            if (r2 != 0) goto L2e
            r2 = r6
            r5 = r10
            goto L50
        L2e:
            if (r13 == 0) goto L36
            int r11 = r2.getTop()
            if (r7 < r11) goto L3e
        L36:
            if (r13 != 0) goto L40
            int r7 = r2.getBottom()
            if (r8 <= r7) goto L40
        L3e:
            r7 = r9
            goto L41
        L40:
            r7 = r3
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r2 = r6
            r5 = r9
            goto L50
        L4d:
            if (r7 == 0) goto L50
        L4f:
            r2 = r6
        L50:
            int r4 = r4 + 1
            goto Ld
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.u(boolean, int, int):android.view.View");
    }

    public void v(int i4) {
        if (getChildCount() > 0) {
            this.f6871e.fling(getScrollX(), getScrollY(), 0, i4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            N(true);
        }
    }

    public boolean w(int i4) {
        int childCount;
        boolean z4 = i4 == 130;
        int height = getHeight();
        Rect rect = this.f6870c;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f6870c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f6870c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f6870c;
        return O(i4, rect3.top, rect3.bottom);
    }

    public final float x(int i4) {
        double dLog = Math.log((Math.abs(i4) * 0.35f) / (this.f6868a * 0.015f));
        float f4 = f6862D;
        return (float) (((double) (this.f6868a * 0.015f)) * Math.exp((((double) f4) / (((double) f4) - 1.0d)) * dLog));
    }

    public boolean y(int i4) {
        return this.f6892z.l(i4);
    }

    public final boolean z(int i4, int i5) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i5 >= childAt.getTop() - scrollY && i5 < childAt.getBottom() - scrollY && i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                return true;
            }
        }
        return false;
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6870c = new Rect();
        this.f6875i = true;
        this.f6876j = false;
        this.f6877k = null;
        this.f6878l = false;
        this.f6881o = true;
        this.f6885s = -1;
        this.f6886t = new int[2];
        this.f6887u = new int[2];
        c cVar = new c();
        this.f6866B = cVar;
        this.f6867C = new C0271e(getContext(), cVar);
        this.f6872f = M.c.a(context, attributeSet);
        this.f6873g = M.c.a(context, attributeSet);
        this.f6868a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6864F, i4, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f6891y = new C0288w(this);
        this.f6892z = new C0285t(this);
        setNestedScrollingEnabled(true);
        E.H(this, f6863E);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4) {
        if (getChildCount() <= 0) {
            super.addView(view, i4);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i4, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
