package androidx.appcompat.widget;

import T.D;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import g.i;
import o.L;
import o.W;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f10777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f10779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f10780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f10781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10785o;

    public static class a extends LinearLayout.LayoutParams {
        public a(int i8, int i9) {
            super(i8, i9);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g(int i8, int i9) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i10 = 0; i10 < i8; i10++) {
            View viewN = n(i10);
            if (viewN.getVisibility() != 8) {
                a aVar = (a) viewN.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i11 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewN.getMeasuredHeight();
                    measureChildWithMargins(viewN, iMakeMeasureSpec, 0, i9, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i11;
                }
            }
        }
    }

    private void v(View view, int i8, int i9, int i10, int i11) {
        view.layout(i8, i9, i10 + i8, i11 + i9);
    }

    public void b(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int virtualChildCount = getVirtualChildCount();
        boolean zA = W.a(this);
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View viewN = n(i8);
            if (viewN != null && viewN.getVisibility() != 8 && o(i8)) {
                a aVar = (a) viewN.getLayoutParams();
                e(canvas, zA ? viewN.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewN.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f10782l);
            }
        }
        if (o(virtualChildCount)) {
            View viewN2 = n(virtualChildCount - 1);
            if (viewN2 != null) {
                a aVar2 = (a) viewN2.getLayoutParams();
                if (zA) {
                    left = viewN2.getLeft();
                    paddingRight = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    right = (left - paddingRight) - this.f10782l;
                } else {
                    right = viewN2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.f10782l;
            }
            e(canvas, right);
        }
    }

    public void c(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View viewN = n(i8);
            if (viewN != null && viewN.getVisibility() != 8 && o(i8)) {
                d(canvas, (viewN.getTop() - ((LinearLayout.LayoutParams) ((a) viewN.getLayoutParams())).topMargin) - this.f10783m);
            }
        }
        if (o(virtualChildCount)) {
            View viewN2 = n(virtualChildCount - 1);
            d(canvas, viewN2 == null ? (getHeight() - getPaddingBottom()) - this.f10783m : viewN2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewN2.getLayoutParams())).bottomMargin);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void d(Canvas canvas, int i8) {
        this.f10781k.setBounds(getPaddingLeft() + this.f10785o, i8, (getWidth() - getPaddingRight()) - this.f10785o, this.f10783m + i8);
        this.f10781k.draw(canvas);
    }

    public void e(Canvas canvas, int i8) {
        this.f10781k.setBounds(i8, getPaddingTop() + this.f10785o, this.f10782l + i8, (getHeight() - getPaddingBottom()) - this.f10785o);
        this.f10781k.draw(canvas);
    }

    public final void f(int i8, int i9) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i10 = 0; i10 < i8; i10++) {
            View viewN = n(i10);
            if (viewN.getVisibility() != 8) {
                a aVar = (a) viewN.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i11 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewN.getMeasuredWidth();
                    measureChildWithMargins(viewN, i9, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i11;
                }
            }
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i8;
        if (this.f10772b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i9 = this.f10772b;
        if (childCount <= i9) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i9);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f10772b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f10773c;
        if (this.f10774d == 1 && (i8 = this.f10775e & 112) != 48) {
            if (i8 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f10776f) / 2;
            } else if (i8 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f10776f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f10772b;
    }

    public Drawable getDividerDrawable() {
        return this.f10781k;
    }

    public int getDividerPadding() {
        return this.f10785o;
    }

    public int getDividerWidth() {
        return this.f10782l;
    }

    public int getGravity() {
        return this.f10775e;
    }

    public int getOrientation() {
        return this.f10774d;
    }

    public int getShowDividers() {
        return this.f10784n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f10777g;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i8 = this.f10774d;
        if (i8 == 0) {
            return new a(-2, -2);
        }
        if (i8 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    public int k(View view, int i8) {
        return 0;
    }

    public int l(View view) {
        return 0;
    }

    public int m(View view) {
        return 0;
    }

    public View n(int i8) {
        return getChildAt(i8);
    }

    public boolean o(int i8) {
        if (i8 == 0) {
            return (this.f10784n & 1) != 0;
        }
        if (i8 == getChildCount()) {
            return (this.f10784n & 4) != 0;
        }
        if ((this.f10784n & 2) == 0) {
            return false;
        }
        for (int i9 = i8 - 1; i9 >= 0; i9--) {
            if (getChildAt(i9).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f10781k == null) {
            return;
        }
        if (this.f10774d == 1) {
            c(canvas);
        } else {
            b(canvas);
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
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        if (this.f10774d == 1) {
            q(i8, i9, i10, i11);
        } else {
            p(i8, i9, i10, i11);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f10774d == 1) {
            u(i8, i9);
        } else {
            s(i8, i9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.p(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.q(int, int, int, int):void");
    }

    public void r(View view, int i8, int i9, int i10, int i11, int i12) {
        measureChildWithMargins(view, i9, i10, i11, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03b1 A[PHI: r3
      0x03b1: PHI (r3v31 int) = (r3v27 int), (r3v32 int) binds: [B:173:0x03c2, B:167:0x03ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.s(int, int):void");
    }

    public void setBaselineAligned(boolean z7) {
        this.f10771a = z7;
    }

    public void setBaselineAlignedChildIndex(int i8) {
        if (i8 >= 0 && i8 < getChildCount()) {
            this.f10772b = i8;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f10781k) {
            return;
        }
        this.f10781k = drawable;
        if (drawable != null) {
            this.f10782l = drawable.getIntrinsicWidth();
            this.f10783m = drawable.getIntrinsicHeight();
        } else {
            this.f10782l = 0;
            this.f10783m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i8) {
        this.f10785o = i8;
    }

    public void setGravity(int i8) {
        if (this.f10775e != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            this.f10775e = i8;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i8) {
        int i9 = i8 & 8388615;
        int i10 = this.f10775e;
        if ((8388615 & i10) != i9) {
            this.f10775e = i9 | ((-8388616) & i10);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z7) {
        this.f10778h = z7;
    }

    public void setOrientation(int i8) {
        if (this.f10774d != i8) {
            this.f10774d = i8;
            requestLayout();
        }
    }

    public void setShowDividers(int i8) {
        if (i8 != this.f10784n) {
            requestLayout();
        }
        this.f10784n = i8;
    }

    public void setVerticalGravity(int i8) {
        int i9 = i8 & 112;
        int i10 = this.f10775e;
        if ((i10 & 112) != i9) {
            this.f10775e = i9 | (i10 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f8) {
        this.f10777g = Math.max(0.0f, f8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int t(int i8) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x02d4 A[PHI: r10
      0x02d4: PHI (r10v21 int) = (r10v19 int), (r10v22 int) binds: [B:136:0x02e5, B:130:0x02d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0327  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.u(int, int):void");
    }

    public b(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f10771a = true;
        this.f10772b = -1;
        this.f10773c = 0;
        this.f10775e = 8388659;
        L lS = L.s(context, attributeSet, i.f17930r0, i8, 0);
        D.I(this, context, i.f17930r0, attributeSet, lS.o(), i8, 0);
        int i9 = lS.i(i.f17938t0, -1);
        if (i9 >= 0) {
            setOrientation(i9);
        }
        int i10 = lS.i(i.f17934s0, -1);
        if (i10 >= 0) {
            setGravity(i10);
        }
        boolean zA = lS.a(i.f17942u0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f10777g = lS.g(i.f17950w0, -1.0f);
        this.f10772b = lS.i(i.f17946v0, -1);
        this.f10778h = lS.a(i.f17962z0, false);
        setDividerDrawable(lS.f(i.f17954x0));
        this.f10784n = lS.i(i.f17773A0, 0);
        this.f10785o = lS.e(i.f17958y0, 0);
        lS.u();
    }
}
