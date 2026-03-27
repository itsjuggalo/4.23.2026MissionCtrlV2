package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import g.i;
import o.a0;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6782c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f6789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f6790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6793o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6794p;

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.p(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.b$a r1 = (androidx.appcompat.widget.b.a) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L36
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L37
        L36:
            r6 = r11
        L37:
            int r0 = r0 + 1
            r11 = r6
            goto Lb
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.i(int, int):void");
    }

    private void x(View view, int i4, int i5, int i6, int i7) {
        view.layout(i4, i5, i6 + i4, i7 + i5);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void d(Canvas canvas) {
        int right;
        int left;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = g0.b(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View viewP = p(i5);
            if (viewP != null && viewP.getVisibility() != 8 && q(i5)) {
                a aVar = (a) viewP.getLayoutParams();
                g(canvas, zB ? viewP.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (viewP.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.f6791m);
            }
        }
        if (q(virtualChildCount)) {
            View viewP2 = p(virtualChildCount - 1);
            if (viewP2 != null) {
                a aVar2 = (a) viewP2.getLayoutParams();
                if (zB) {
                    left = viewP2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i4 = this.f6791m;
                    right = left - i4;
                } else {
                    right = viewP2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i4 = this.f6791m;
                right = left - i4;
            }
            g(canvas, right);
        }
    }

    public void e(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View viewP = p(i4);
            if (viewP != null && viewP.getVisibility() != 8 && q(i4)) {
                f(canvas, (viewP.getTop() - ((ViewGroup.MarginLayoutParams) ((a) viewP.getLayoutParams())).topMargin) - this.f6792n);
            }
        }
        if (q(virtualChildCount)) {
            View viewP2 = p(virtualChildCount - 1);
            f(canvas, viewP2 == null ? (getHeight() - getPaddingBottom()) - this.f6792n : viewP2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) viewP2.getLayoutParams())).bottomMargin);
        }
    }

    public void f(Canvas canvas, int i4) {
        this.f6790l.setBounds(getPaddingLeft() + this.f6794p, i4, (getWidth() - getPaddingRight()) - this.f6794p, this.f6792n + i4);
        this.f6790l.draw(canvas);
    }

    public void g(Canvas canvas, int i4) {
        this.f6790l.setBounds(i4, getPaddingTop() + this.f6794p, this.f6791m + i4, (getHeight() - getPaddingBottom()) - this.f6794p);
        this.f6790l.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i4;
        if (this.f6781b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f6781b;
        if (childCount <= i5) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i5);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f6781b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f6782c;
        if (this.f6783e == 1 && (i4 = this.f6784f & 112) != 48) {
            if (i4 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f6785g) / 2;
            } else if (i4 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f6785g;
            }
        }
        return bottom + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f6781b;
    }

    public Drawable getDividerDrawable() {
        return this.f6790l;
    }

    public int getDividerPadding() {
        return this.f6794p;
    }

    public int getDividerWidth() {
        return this.f6791m;
    }

    public int getGravity() {
        return this.f6784f;
    }

    public int getOrientation() {
        return this.f6783e;
    }

    public int getShowDividers() {
        return this.f6793o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f6786h;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.p(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.b$a r1 = (androidx.appcompat.widget.b.a) r1
            int r2 = r1.height
            r4 = -1
            if (r2 != r4) goto L36
            int r8 = r1.width
            int r2 = r3.getMeasuredWidth()
            r1.width = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r4 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.width = r8
            goto L37
        L36:
            r4 = r11
        L37:
            int r0 = r0 + 1
            r11 = r4
            goto Lb
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.h(int, int):void");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i4 = this.f6783e;
        if (i4 == 0) {
            return new a(-2, -2);
        }
        if (i4 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int m(View view, int i4) {
        return 0;
    }

    public int n(View view) {
        return 0;
    }

    public int o(View view) {
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f6790l == null) {
            return;
        }
        if (this.f6783e == 1) {
            e(canvas);
        } else {
            d(canvas);
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
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        if (this.f6783e == 1) {
            s(i4, i5, i6, i7);
        } else {
            r(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.f6783e == 1) {
            w(i4, i5);
        } else {
            u(i4, i5);
        }
    }

    public View p(int i4) {
        return getChildAt(i4);
    }

    public boolean q(int i4) {
        if (i4 == 0) {
            return (this.f6793o & 1) != 0;
        }
        if (i4 == getChildCount()) {
            return (this.f6793o & 4) != 0;
        }
        if ((this.f6793o & 2) != 0) {
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                if (getChildAt(i5).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.r(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r11.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r0
            int r1 = r11.getPaddingRight()
            int r14 = r14 - r1
            int r1 = r11.getVirtualChildCount()
            int r2 = r11.f6784f
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L35
            r4 = 80
            if (r3 == r4) goto L2a
            int r13 = r11.getPaddingTop()
            goto L41
        L2a:
            int r3 = r11.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r11.f6785g
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.f6785g
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
        L42:
            if (r15 >= r1) goto Lb9
            android.view.View r4 = r11.p(r15)
            r9 = 1
            if (r4 != 0) goto L52
            int r3 = r11.v(r15)
            int r13 = r13 + r3
        L50:
            r3 = r11
            goto Lb7
        L52:
            int r3 = r4.getVisibility()
            r5 = 8
            if (r3 == r5) goto L50
            int r7 = r4.getMeasuredWidth()
            int r8 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            r10 = r3
            androidx.appcompat.widget.b$a r10 = (androidx.appcompat.widget.b.a) r10
            int r3 = r10.f6796b
            if (r3 >= 0) goto L6e
            r3 = r2
        L6e:
            int r5 = H.E.n(r11)
            int r3 = H.AbstractC0275i.a(r3, r5)
            r3 = r3 & 7
            if (r3 == r9) goto L88
            r5 = 5
            if (r3 == r5) goto L82
            int r3 = r10.leftMargin
            int r3 = r3 + r0
        L80:
            r5 = r3
            goto L93
        L82:
            int r3 = r12 - r7
            int r5 = r10.rightMargin
        L86:
            int r3 = r3 - r5
            goto L80
        L88:
            int r3 = r14 - r7
            int r3 = r3 / 2
            int r3 = r3 + r0
            int r5 = r10.leftMargin
            int r3 = r3 + r5
            int r5 = r10.rightMargin
            goto L86
        L93:
            boolean r3 = r11.q(r15)
            if (r3 == 0) goto L9c
            int r3 = r11.f6792n
            int r13 = r13 + r3
        L9c:
            int r3 = r10.topMargin
            int r13 = r13 + r3
            int r3 = r11.n(r4)
            int r6 = r13 + r3
            r3 = r11
            r3.x(r4, r5, r6, r7, r8)
            int r5 = r10.bottomMargin
            int r8 = r8 + r5
            int r5 = r11.o(r4)
            int r8 = r8 + r5
            int r13 = r13 + r8
            int r4 = r11.m(r4, r15)
            int r15 = r15 + r4
        Lb7:
            int r15 = r15 + r9
            goto L42
        Lb9:
            r3 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.s(int, int, int, int):void");
    }

    public void setBaselineAligned(boolean z4) {
        this.f6780a = z4;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 >= 0 && i4 < getChildCount()) {
            this.f6781b = i4;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f6790l) {
            return;
        }
        this.f6790l = drawable;
        if (drawable != null) {
            this.f6791m = drawable.getIntrinsicWidth();
            this.f6792n = drawable.getIntrinsicHeight();
        } else {
            this.f6791m = 0;
            this.f6792n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i4) {
        this.f6794p = i4;
    }

    public void setGravity(int i4) {
        if (this.f6784f != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.f6784f = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & 8388615;
        int i6 = this.f6784f;
        if ((8388615 & i6) != i5) {
            this.f6784f = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f6787i = z4;
    }

    public void setOrientation(int i4) {
        if (this.f6783e != i4) {
            this.f6783e = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.f6793o) {
            requestLayout();
        }
        this.f6793o = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.f6784f;
        if ((i6 & 112) != i5) {
            this.f6784f = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f6786h = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(View view, int i4, int i5, int i6, int i7, int i8) {
        measureChildWithMargins(view, i5, i6, i7, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 1286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.u(int, int):void");
    }

    public int v(int i4) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 881
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.w(int, int):void");
    }

    public b(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6780a = true;
        this.f6781b = -1;
        this.f6782c = 0;
        this.f6784f = 8388659;
        a0 a0VarR = a0.r(context, attributeSet, i.f11877v0, i4, 0);
        int i5 = a0VarR.i(i.f11885x0, -1);
        if (i5 >= 0) {
            setOrientation(i5);
        }
        int i6 = a0VarR.i(i.f11881w0, -1);
        if (i6 >= 0) {
            setGravity(i6);
        }
        boolean zA = a0VarR.a(i.f11889y0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f6786h = a0VarR.g(i.f11679A0, -1.0f);
        this.f6781b = a0VarR.i(i.f11893z0, -1);
        this.f6787i = a0VarR.a(i.f11691D0, false);
        setDividerDrawable(a0VarR.f(i.f11683B0));
        this.f6793o = a0VarR.i(i.f11695E0, 0);
        this.f6794p = a0VarR.e(i.f11687C0, 0);
        a0VarR.s();
    }

    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6796b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6796b = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f11699F0);
            this.f6795a = typedArrayObtainStyledAttributes.getFloat(i.f11707H0, 0.0f);
            this.f6796b = typedArrayObtainStyledAttributes.getInt(i.f11703G0, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(int i4, int i5) {
            super(i4, i5);
            this.f6796b = -1;
            this.f6795a = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6796b = -1;
        }
    }
}
