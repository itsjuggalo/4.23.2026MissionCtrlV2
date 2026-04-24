package com.google.firebase.inappmessaging.display.internal.layout;

import F3.f;
import H3.l;
import L3.a;
import M3.b;
import M3.c;
import M3.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ModalLayoutPortrait extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f15584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15585f;

    public ModalLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15584e = new c();
    }

    public final boolean k(View view) {
        return view.getId() == f.f1573g || view.getId() == f.f1580n;
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        super.onLayout(z7, i8, i9, i10, i11);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = getVisibleChildren().get(i14);
            FrameLayout.LayoutParams layoutParamsG = g(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredHeight + paddingTop;
            if ((layoutParamsG.gravity & 1) == 1) {
                int i16 = (i10 - i8) / 2;
                int i17 = measuredWidth / 2;
                i13 = i16 - i17;
                i12 = i16 + i17;
            } else {
                i12 = paddingLeft + measuredWidth;
                i13 = paddingLeft;
            }
            l.a("Layout child " + i14);
            l.d("\t(top, bottom)", (float) paddingTop, (float) i15);
            l.d("\t(left, right)", (float) i13, (float) i12);
            view.layout(i13, paddingTop, i12, i15);
            paddingTop += view.getMeasuredHeight();
            if (i14 < size - 1) {
                paddingTop += this.f15585f;
            }
        }
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f15585f = c(24);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iB = b(i8);
        int iA = a(i9);
        int size = paddingBottom + ((getVisibleChildren().size() - 1) * this.f15585f);
        this.f15584e.f(iB, iA);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            this.f15584e.a(childAt, k(childAt));
        }
        l.a("Screen dimens: " + getDisplayMetrics());
        l.d("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f8 = (float) iB;
        l.d("Base dimens", f8, (float) iA);
        for (d dVar : this.f15584e.e()) {
            l.a("Pre-measure child");
            dVar.e(iB, iA);
        }
        int iD = this.f15584e.d() + size;
        l.c("Total reserved height", size);
        l.c("Total desired height", iD);
        boolean z7 = iD > iA;
        l.a("Total height constrained: " + z7);
        if (z7) {
            this.f15584e.b((iA - size) - this.f15584e.c());
        }
        int i11 = iB - paddingRight;
        for (d dVar2 : this.f15584e.e()) {
            l.a("Measuring child");
            b.b(dVar2.c(), i11, dVar2.b());
            size += e(dVar2.c());
        }
        l.d("Measured dims", f8, size);
        setMeasuredDimension(iB, size);
    }
}
