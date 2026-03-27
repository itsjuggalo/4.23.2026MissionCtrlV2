package androidx.appcompat.widget;

import T.D;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import g.AbstractC1768e;
import g.i;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10624c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10624c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f17910m0);
        D.I(this, context, i.f17910m0, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f10622a = typedArrayObtainStyledAttributes.getBoolean(i.f17914n0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f10622a);
        }
    }

    private void setStacked(boolean z7) {
        if (this.f10623b != z7) {
            if (!z7 || this.f10622a) {
                this.f10623b = z7;
                setOrientation(z7 ? 1 : 0);
                setGravity(z7 ? 8388613 : 80);
                View viewFindViewById = findViewById(AbstractC1768e.f17741n);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z7 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    public final int a(int i8) {
        int childCount = getChildCount();
        while (i8 < childCount) {
            if (getChildAt(i8).getVisibility() == 0) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public final boolean b() {
        return this.f10623b;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        int iMakeMeasureSpec;
        boolean z7;
        int size = View.MeasureSpec.getSize(i8);
        int paddingBottom = 0;
        if (this.f10622a) {
            if (size > this.f10624c && b()) {
                setStacked(false);
            }
            this.f10624c = size;
        }
        if (b() || View.MeasureSpec.getMode(i8) != 1073741824) {
            iMakeMeasureSpec = i8;
            z7 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z7 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i9);
        if (this.f10622a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z7 = true;
        }
        if (z7) {
            super.onMeasure(i8, i9);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (D.r(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i9 == 0) {
                super.onMeasure(i8, i9);
            }
        }
    }

    public void setAllowStacking(boolean z7) {
        if (this.f10622a != z7) {
            this.f10622a = z7;
            if (!z7 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
