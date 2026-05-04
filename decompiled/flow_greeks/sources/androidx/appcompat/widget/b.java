package androidx.appcompat.widget;

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
import o.j0;
import o.t0;
import t0.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f1311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f1312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f1313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1317o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i10, int i11) {
            super(i10, i11);
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

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.n(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.g(int, int):void");
    }

    private void v(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    public void b(Canvas canvas) {
        int right;
        int left;
        int i10;
        int virtualChildCount = getVirtualChildCount();
        boolean zA = t0.a(this);
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View viewN = n(i11);
            if (viewN != null && viewN.getVisibility() != 8 && o(i11)) {
                a aVar = (a) viewN.getLayoutParams();
                e(canvas, zA ? viewN.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewN.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f1314l);
            }
        }
        if (o(virtualChildCount)) {
            View viewN2 = n(virtualChildCount - 1);
            if (viewN2 != null) {
                a aVar2 = (a) viewN2.getLayoutParams();
                if (zA) {
                    left = viewN2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i10 = this.f1314l;
                    right = left - i10;
                } else {
                    right = viewN2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i10 = this.f1314l;
                right = left - i10;
            }
            e(canvas, right);
        }
    }

    public void c(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            View viewN = n(i10);
            if (viewN != null && viewN.getVisibility() != 8 && o(i10)) {
                d(canvas, (viewN.getTop() - ((LinearLayout.LayoutParams) ((a) viewN.getLayoutParams())).topMargin) - this.f1315m);
            }
        }
        if (o(virtualChildCount)) {
            View viewN2 = n(virtualChildCount - 1);
            d(canvas, viewN2 == null ? (getHeight() - getPaddingBottom()) - this.f1315m : viewN2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewN2.getLayoutParams())).bottomMargin);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void d(Canvas canvas, int i10) {
        this.f1313k.setBounds(getPaddingLeft() + this.f1317o, i10, (getWidth() - getPaddingRight()) - this.f1317o, this.f1315m + i10);
        this.f1313k.draw(canvas);
    }

    public void e(Canvas canvas, int i10) {
        this.f1313k.setBounds(i10, getPaddingTop() + this.f1317o, this.f1314l + i10, (getHeight() - getPaddingBottom()) - this.f1317o);
        this.f1313k.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.n(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.f(int, int):void");
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f1304b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f1304b;
        if (childCount <= i11) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i11);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1304b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1305c;
        if (this.f1306d == 1 && (i10 = this.f1307e & 112) != 48) {
            if (i10 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1308f) / 2;
            } else if (i10 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1308f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1304b;
    }

    public Drawable getDividerDrawable() {
        return this.f1313k;
    }

    public int getDividerPadding() {
        return this.f1317o;
    }

    public int getDividerWidth() {
        return this.f1314l;
    }

    public int getGravity() {
        return this.f1307e;
    }

    public int getOrientation() {
        return this.f1306d;
    }

    public int getShowDividers() {
        return this.f1316n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1309g;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i10 = this.f1306d;
        if (i10 == 0) {
            return new a(-2, -2);
        }
        if (i10 == 1) {
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

    public int k(View view, int i10) {
        return 0;
    }

    public int l(View view) {
        return 0;
    }

    public int m(View view) {
        return 0;
    }

    public View n(int i10) {
        return getChildAt(i10);
    }

    public boolean o(int i10) {
        if (i10 == 0) {
            return (this.f1316n & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f1316n & 4) != 0;
        }
        if ((this.f1316n & 2) != 0) {
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                if (getChildAt(i11).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1313k == null) {
            return;
        }
        if (this.f1306d == 1) {
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
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f1306d == 1) {
            q(i10, i11, i12, i13);
        } else {
            p(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1306d == 1) {
            u(i10, i11);
        } else {
            s(i10, i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.p(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(int r12, int r13, int r14, int r15) {
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
            int r2 = r11.f1307e
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
            int r13 = r11.f1308f
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.f1308f
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
        L42:
            if (r15 >= r1) goto Lb9
            android.view.View r4 = r11.n(r15)
            r9 = 1
            if (r4 != 0) goto L52
            int r3 = r11.t(r15)
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
            int r3 = r10.gravity
            if (r3 >= 0) goto L6e
            r3 = r2
        L6e:
            int r5 = r11.getLayoutDirection()
            int r3 = t0.h.a(r3, r5)
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
            boolean r3 = r11.o(r15)
            if (r3 == 0) goto L9c
            int r3 = r11.f1315m
            int r13 = r13 + r3
        L9c:
            int r3 = r10.topMargin
            int r13 = r13 + r3
            int r3 = r11.l(r4)
            int r6 = r13 + r3
            r3 = r11
            r3.v(r4, r5, r6, r7, r8)
            int r5 = r10.bottomMargin
            int r8 = r8 + r5
            int r5 = r11.m(r4)
            int r8 = r8 + r5
            int r13 = r13 + r8
            int r4 = r11.k(r4, r15)
            int r15 = r15 + r4
        Lb7:
            int r15 = r15 + r9
            goto L42
        Lb9:
            r3 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.q(int, int, int, int):void");
    }

    public void r(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0461  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 1294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.s(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f1303a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.f1304b = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1313k) {
            return;
        }
        this.f1313k = drawable;
        if (drawable != null) {
            this.f1314l = drawable.getIntrinsicWidth();
            this.f1315m = drawable.getIntrinsicHeight();
        } else {
            this.f1314l = 0;
            this.f1315m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.f1317o = i10;
    }

    public void setGravity(int i10) {
        if (this.f1307e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f1307e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f1307e;
        if ((8388615 & i12) != i11) {
            this.f1307e = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f1310h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f1306d != i10) {
            this.f1306d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f1316n) {
            requestLayout();
        }
        this.f1316n = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f1307e;
        if ((i12 & 112) != i11) {
            this.f1307e = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f1309g = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int t(int i10) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.u(int, int):void");
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1303a = true;
        this.f1304b = -1;
        this.f1305c = 0;
        this.f1307e = 8388659;
        j0 j0VarS = j0.s(context, attributeSet, i.f9831r0, i10, 0);
        c0.I(this, context, i.f9831r0, attributeSet, j0VarS.o(), i10, 0);
        int i11 = j0VarS.i(i.f9839t0, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = j0VarS.i(i.f9835s0, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean zA = j0VarS.a(i.f9843u0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f1309g = j0VarS.g(i.f9851w0, -1.0f);
        this.f1304b = j0VarS.i(i.f9847v0, -1);
        this.f1310h = j0VarS.a(i.f9863z0, false);
        setDividerDrawable(j0VarS.f(i.f9855x0));
        this.f1316n = j0VarS.i(i.A0, 0);
        this.f1317o = j0VarS.e(i.f9859y0, 0);
        j0VarS.u();
    }
}
