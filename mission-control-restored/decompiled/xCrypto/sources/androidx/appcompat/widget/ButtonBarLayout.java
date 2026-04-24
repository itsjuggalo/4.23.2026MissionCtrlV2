package androidx.appcompat.widget;

import H.E;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import g.AbstractC1252e;
import g.i;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6575c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        ButtonBarLayout buttonBarLayout;
        super(context, attributeSet);
        this.f6574b = -1;
        this.f6575c = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f11841m0);
        if (Build.VERSION.SDK_INT >= 29) {
            buttonBarLayout = this;
            buttonBarLayout.saveAttributeDataForStyleable(context, i.f11841m0, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        } else {
            buttonBarLayout = this;
        }
        buttonBarLayout.f6573a = typedArrayObtainStyledAttributes.getBoolean(i.f11845n0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setStacked(boolean z4) {
        setOrientation(z4 ? 1 : 0);
        setGravity(z4 ? 5 : 80);
        View viewFindViewById = findViewById(AbstractC1252e.f11648w);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z4 ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    public final int a(int i4) {
        int childCount = getChildCount();
        while (i4 < childCount) {
            if (getChildAt(i4).getVisibility() == 0) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public final boolean b() {
        return getOrientation() == 1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f6575c, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        int iMakeMeasureSpec;
        boolean z4;
        int size = View.MeasureSpec.getSize(i4);
        int paddingBottom = 0;
        if (this.f6573a) {
            if (size > this.f6574b && b()) {
                setStacked(false);
            }
            this.f6574b = size;
        }
        if (b() || View.MeasureSpec.getMode(i4) != 1073741824) {
            iMakeMeasureSpec = i4;
            z4 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z4 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i5);
        if (this.f6573a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z4 = true;
        }
        if (z4) {
            super.onMeasure(i4, i5);
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
        if (E.o(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
        }
    }

    public void setAllowStacking(boolean z4) {
        if (this.f6573a != z4) {
            this.f6573a = z4;
            if (!z4 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
