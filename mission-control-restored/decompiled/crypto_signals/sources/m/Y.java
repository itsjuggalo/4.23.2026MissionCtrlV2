package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import h.AbstractC0616a;

/* JADX INFO: loaded from: classes.dex */
public abstract class Y extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8322d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8323f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f8326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f8327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f8328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8330q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8332s;

    public Y(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8319a = true;
        this.f8320b = -1;
        this.f8321c = 0;
        this.e = 8388659;
        int[] iArr = AbstractC0616a.f6580j;
        f.d dVarQ = f.d.Q(context, attributeSet, iArr, i);
        D.C.c(this, context, iArr, attributeSet, (TypedArray) dVarQ.f6382b, i);
        TypedArray typedArray = (TypedArray) dVarQ.f6382b;
        int i6 = typedArray.getInt(1, -1);
        if (i6 >= 0) {
            setOrientation(i6);
        }
        int i7 = typedArray.getInt(0, -1);
        if (i7 >= 0) {
            setGravity(i7);
        }
        boolean z6 = typedArray.getBoolean(2, true);
        if (!z6) {
            setBaselineAligned(z6);
        }
        this.f8324k = typedArray.getFloat(4, -1.0f);
        this.f8320b = typedArray.getInt(3, -1);
        this.f8325l = typedArray.getBoolean(7, false);
        setDividerDrawable(dVarQ.G(5));
        this.f8331r = typedArray.getInt(8, 0);
        this.f8332s = typedArray.getDimensionPixelSize(6, 0);
        dVarQ.S();
    }

    public final void b(Canvas canvas, int i) {
        this.f8328o.setBounds(getPaddingLeft() + this.f8332s, i, (getWidth() - getPaddingRight()) - this.f8332s, this.f8330q + i);
        this.f8328o.draw(canvas);
    }

    public final void c(Canvas canvas, int i) {
        this.f8328o.setBounds(i, getPaddingTop() + this.f8332s, this.f8329p + i, (getHeight() - getPaddingBottom()) - this.f8332s);
        this.f8328o.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof X;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public X generateDefaultLayoutParams() {
        int i = this.f8322d;
        if (i == 0) {
            return new X(-2, -2);
        }
        if (i == 1) {
            return new X(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public X generateLayoutParams(AttributeSet attributeSet) {
        return new X(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public X generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new X(layoutParams);
    }

    public final boolean g(int i) {
        if (i == 0) {
            return (this.f8331r & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f8331r & 4) != 0;
        }
        if ((this.f8331r & 2) != 0) {
            for (int i6 = i - 1; i6 >= 0; i6--) {
                if (getChildAt(i6).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f8320b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.f8320b;
        if (childCount <= i6) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i6);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f8320b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f8321c;
        if (this.f8322d == 1 && (i = this.e & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f8323f) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f8323f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((X) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f8320b;
    }

    public Drawable getDividerDrawable() {
        return this.f8328o;
    }

    public int getDividerPadding() {
        return this.f8332s;
    }

    public int getDividerWidth() {
        return this.f8329p;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.f8322d;
    }

    public int getShowDividers() {
        return this.f8331r;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f8324k;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.f8328o == null) {
            return;
        }
        int i6 = 0;
        if (this.f8322d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i6 < virtualChildCount) {
                View childAt = getChildAt(i6);
                if (childAt != null && childAt.getVisibility() != 8 && g(i6)) {
                    b(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((X) childAt.getLayoutParams())).topMargin) - this.f8330q);
                }
                i6++;
            }
            if (g(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                b(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f8330q : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((X) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zA = X0.a(this);
        while (i6 < virtualChildCount2) {
            View childAt3 = getChildAt(i6);
            if (childAt3 != null && childAt3.getVisibility() != 8 && g(i6)) {
                X x6 = (X) childAt3.getLayoutParams();
                c(canvas, zA ? childAt3.getRight() + ((LinearLayout.LayoutParams) x6).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) x6).leftMargin) - this.f8329p);
            }
            i6++;
        }
        if (g(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                X x7 = (X) childAt4.getLayoutParams();
                if (zA) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) x7).leftMargin;
                    i = this.f8329p;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) x7).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.f8329p;
                right = left - i;
            }
            c(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a5  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.Y.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 2151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.Y.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z6) {
        this.f8319a = z6;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f8320b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f8328o) {
            return;
        }
        this.f8328o = drawable;
        if (drawable != null) {
            this.f8329p = drawable.getIntrinsicWidth();
            this.f8330q = drawable.getIntrinsicHeight();
        } else {
            this.f8329p = 0;
            this.f8330q = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f8332s = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i6 = i & 8388615;
        int i7 = this.e;
        if ((8388615 & i7) != i6) {
            this.e = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z6) {
        this.f8325l = z6;
    }

    public void setOrientation(int i) {
        if (this.f8322d != i) {
            this.f8322d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f8331r) {
            requestLayout();
        }
        this.f8331r = i;
    }

    public void setVerticalGravity(int i) {
        int i6 = i & 112;
        int i7 = this.e;
        if ((i7 & 112) != i6) {
            this.e = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f6) {
        this.f8324k = Math.max(0.0f, f6);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
