package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import s9.f;
import u9.l;
import y9.a;
import z9.b;
import z9.c;
import z9.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ModalLayoutPortrait extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f6237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6238f;

    public ModalLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6237e = new c();
    }

    public final boolean k(View view) {
        return view.getId() == f.f20160g || view.getId() == f.f20167n;
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i16 = 0; i16 < size; i16++) {
            View view = getVisibleChildren().get(i16);
            FrameLayout.LayoutParams layoutParamsG = g(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i17 = measuredHeight + paddingTop;
            if ((layoutParamsG.gravity & 1) == 1) {
                int i18 = (i12 - i10) / 2;
                int i19 = measuredWidth / 2;
                i15 = i18 - i19;
                i14 = i18 + i19;
            } else {
                i14 = paddingLeft + measuredWidth;
                i15 = paddingLeft;
            }
            l.a("Layout child " + i16);
            l.d("\t(top, bottom)", (float) paddingTop, (float) i17);
            l.d("\t(left, right)", (float) i15, (float) i14);
            view.layout(i15, paddingTop, i14, i17);
            paddingTop += view.getMeasuredHeight();
            if (i16 < size - 1) {
                paddingTop += this.f6238f;
            }
        }
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f6238f = c(24);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iB = b(i10);
        int iA = a(i11);
        int size = paddingBottom + ((getVisibleChildren().size() - 1) * this.f6238f);
        this.f6237e.f(iB, iA);
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            this.f6237e.a(childAt, k(childAt));
        }
        l.a("Screen dimens: " + getDisplayMetrics());
        l.d("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f10 = (float) iB;
        l.d("Base dimens", f10, (float) iA);
        for (d dVar : this.f6237e.e()) {
            l.a("Pre-measure child");
            dVar.e(iB, iA);
        }
        int iD = this.f6237e.d() + size;
        l.c("Total reserved height", size);
        l.c("Total desired height", iD);
        boolean z10 = iD > iA;
        l.a("Total height constrained: " + z10);
        if (z10) {
            this.f6237e.b((iA - size) - this.f6237e.c());
        }
        int i13 = iB - paddingRight;
        for (d dVar2 : this.f6237e.e()) {
            l.a("Measuring child");
            b.b(dVar2.c(), i13, dVar2.b());
            size += e(dVar2.c());
        }
        l.d("Measured dims", f10, size);
        setMeasuredDimension(iB, size);
    }
}
