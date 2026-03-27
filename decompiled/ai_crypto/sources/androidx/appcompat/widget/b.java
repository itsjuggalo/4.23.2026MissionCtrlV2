package androidx.appcompat.widget;

import Q.N;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import h.AbstractC1664i;
import p.S;
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f6952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f6954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6955l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6956m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6957n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6958o;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i7, int i8) {
            super(i7, i8);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void k(int i7, int i8) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i9 = 0; i9 < i7; i9++) {
            View viewR = r(i9);
            if (viewR.getVisibility() != 8) {
                a aVar = (a) viewR.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i10 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewR.getMeasuredHeight();
                    measureChildWithMargins(viewR, iMakeMeasureSpec, 0, i8, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i10;
                }
            }
        }
    }

    private void z(View view, int i7, int i8, int i9, int i10) {
        view.layout(i7, i8, i9 + i7, i10 + i8);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void f(Canvas canvas) {
        int right;
        int left;
        int i7;
        int virtualChildCount = getVirtualChildCount();
        boolean zA = c0.a(this);
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View viewR = r(i8);
            if (viewR != null && viewR.getVisibility() != 8 && s(i8)) {
                a aVar = (a) viewR.getLayoutParams();
                i(canvas, zA ? viewR.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewR.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f6955l);
            }
        }
        if (s(virtualChildCount)) {
            View viewR2 = r(virtualChildCount - 1);
            if (viewR2 != null) {
                a aVar2 = (a) viewR2.getLayoutParams();
                if (zA) {
                    left = viewR2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i7 = this.f6955l;
                    right = left - i7;
                } else {
                    right = viewR2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i7 = this.f6955l;
                right = left - i7;
            }
            i(canvas, right);
        }
    }

    public void g(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i7 = 0; i7 < virtualChildCount; i7++) {
            View viewR = r(i7);
            if (viewR != null && viewR.getVisibility() != 8 && s(i7)) {
                h(canvas, (viewR.getTop() - ((LinearLayout.LayoutParams) ((a) viewR.getLayoutParams())).topMargin) - this.f6956m);
            }
        }
        if (s(virtualChildCount)) {
            View viewR2 = r(virtualChildCount - 1);
            h(canvas, viewR2 == null ? (getHeight() - getPaddingBottom()) - this.f6956m : viewR2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewR2.getLayoutParams())).bottomMargin);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i7;
        if (this.f6945b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i8 = this.f6945b;
        if (childCount <= i8) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i8);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f6945b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f6946c;
        if (this.f6947d == 1 && (i7 = this.f6948e & 112) != 48) {
            if (i7 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f6949f) / 2;
            } else if (i7 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f6949f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f6945b;
    }

    public Drawable getDividerDrawable() {
        return this.f6954k;
    }

    public int getDividerPadding() {
        return this.f6958o;
    }

    public int getDividerWidth() {
        return this.f6955l;
    }

    public int getGravity() {
        return this.f6948e;
    }

    public int getOrientation() {
        return this.f6947d;
    }

    public int getShowDividers() {
        return this.f6957n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f6950g;
    }

    public void h(Canvas canvas, int i7) {
        this.f6954k.setBounds(getPaddingLeft() + this.f6958o, i7, (getWidth() - getPaddingRight()) - this.f6958o, this.f6956m + i7);
        this.f6954k.draw(canvas);
    }

    public void i(Canvas canvas, int i7) {
        this.f6954k.setBounds(i7, getPaddingTop() + this.f6958o, this.f6955l + i7, (getHeight() - getPaddingBottom()) - this.f6958o);
        this.f6954k.draw(canvas);
    }

    public final void j(int i7, int i8) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i9 = 0; i9 < i7; i9++) {
            View viewR = r(i9);
            if (viewR.getVisibility() != 8) {
                a aVar = (a) viewR.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i10 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewR.getMeasuredWidth();
                    measureChildWithMargins(viewR, i8, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i10;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i7 = this.f6947d;
        if (i7 == 0) {
            return new a(-2, -2);
        }
        if (i7 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int o(View view, int i7) {
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f6954k == null) {
            return;
        }
        if (this.f6947d == 1) {
            g(canvas);
        } else {
            f(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        if (this.f6947d == 1) {
            u(i7, i8, i9, i10);
        } else {
            t(i7, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f6947d == 1) {
            y(i7, i8);
        } else {
            w(i7, i8);
        }
    }

    public int p(View view) {
        return 0;
    }

    public int q(View view) {
        return 0;
    }

    public View r(int i7) {
        return getChildAt(i7);
    }

    public boolean s(int i7) {
        if (i7 == 0) {
            return (this.f6957n & 1) != 0;
        }
        if (i7 == getChildCount()) {
            return (this.f6957n & 4) != 0;
        }
        if ((this.f6957n & 2) == 0) {
            return false;
        }
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            if (getChildAt(i8).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public void setBaselineAligned(boolean z7) {
        this.f6944a = z7;
    }

    public void setBaselineAlignedChildIndex(int i7) {
        if (i7 >= 0 && i7 < getChildCount()) {
            this.f6945b = i7;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f6954k) {
            return;
        }
        this.f6954k = drawable;
        if (drawable != null) {
            this.f6955l = drawable.getIntrinsicWidth();
            this.f6956m = drawable.getIntrinsicHeight();
        } else {
            this.f6955l = 0;
            this.f6956m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i7) {
        this.f6958o = i7;
    }

    public void setGravity(int i7) {
        if (this.f6948e != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f6948e = i7;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i7) {
        int i8 = i7 & 8388615;
        int i9 = this.f6948e;
        if ((8388615 & i9) != i8) {
            this.f6948e = i8 | ((-8388616) & i9);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z7) {
        this.f6951h = z7;
    }

    public void setOrientation(int i7) {
        if (this.f6947d != i7) {
            this.f6947d = i7;
            requestLayout();
        }
    }

    public void setShowDividers(int i7) {
        if (i7 != this.f6957n) {
            requestLayout();
        }
        this.f6957n = i7;
    }

    public void setVerticalGravity(int i7) {
        int i8 = i7 & 112;
        int i9 = this.f6948e;
        if ((i9 & 112) != i8) {
            this.f6948e = i8 | (i9 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f7) {
        this.f6950g = Math.max(0.0f, f7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.t(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.u(int, int, int, int):void");
    }

    public void v(View view, int i7, int i8, int i9, int i10, int i11) {
        measureChildWithMargins(view, i8, i9, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 1293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.w(int, int):void");
    }

    public int x(int i7) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x032f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.y(int, int):void");
    }

    public b(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6944a = true;
        this.f6945b = -1;
        this.f6946c = 0;
        this.f6948e = 8388659;
        S sT = S.t(context, attributeSet, AbstractC1664i.f14671v0, i7, 0);
        N.j0(this, context, AbstractC1664i.f14671v0, attributeSet, sT.p(), i7, 0);
        int iJ = sT.j(AbstractC1664i.f14679x0, -1);
        if (iJ >= 0) {
            setOrientation(iJ);
        }
        int iJ2 = sT.j(AbstractC1664i.f14675w0, -1);
        if (iJ2 >= 0) {
            setGravity(iJ2);
        }
        boolean zA = sT.a(AbstractC1664i.f14683y0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f6950g = sT.h(AbstractC1664i.f14477A0, -1.0f);
        this.f6945b = sT.j(AbstractC1664i.f14687z0, -1);
        this.f6951h = sT.a(AbstractC1664i.f14489D0, false);
        setDividerDrawable(sT.g(AbstractC1664i.f14481B0));
        this.f6957n = sT.j(AbstractC1664i.f14493E0, 0);
        this.f6958o = sT.f(AbstractC1664i.f14485C0, 0);
        sT.u();
    }
}
