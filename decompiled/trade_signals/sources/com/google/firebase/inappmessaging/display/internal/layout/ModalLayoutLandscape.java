package com.google.firebase.inappmessaging.display.internal.layout;

import F3.f;
import H3.l;
import L3.a;
import M3.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModalLayoutLandscape extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f15576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f15577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f15578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f15579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15583l;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        super.onLayout(z7, i8, i9, i10, i11);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i14 = this.f15582k;
        int i15 = this.f15583l;
        if (i14 < i15) {
            i13 = (i15 - i14) / 2;
            i12 = 0;
        } else {
            i12 = (i14 - i15) / 2;
            i13 = 0;
        }
        l.a("Layout image");
        int i16 = paddingTop + i13;
        int iF = f(this.f15576e) + paddingLeft;
        i(this.f15576e, paddingLeft, i16, iF, i16 + e(this.f15576e));
        int i17 = iF + this.f15580i;
        l.a("Layout getTitle");
        int i18 = paddingTop + i12;
        int iE = e(this.f15577f) + i18;
        i(this.f15577f, i17, i18, measuredWidth, iE);
        l.a("Layout getBody");
        int i19 = iE + (this.f15577f.getVisibility() == 8 ? 0 : this.f15581j);
        int iE2 = e(this.f15578g) + i19;
        i(this.f15578g, i17, i19, measuredWidth, iE2);
        l.a("Layout button");
        h(this.f15579h, i17, iE2 + (this.f15578g.getVisibility() != 8 ? this.f15581j : 0));
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f15576e = d(f.f1580n);
        this.f15577f = d(f.f1582p);
        this.f15578g = d(f.f1573g);
        this.f15579h = d(f.f1574h);
        int iMax = 0;
        this.f15580i = this.f15576e.getVisibility() == 8 ? 0 : c(24);
        this.f15581j = c(24);
        List listAsList = Arrays.asList(this.f15577f, this.f15578g, this.f15579h);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iB = b(i8);
        int iA = a(i9) - paddingBottom;
        int i10 = iB - paddingLeft;
        l.a("Measuring image");
        b.b(this.f15576e, (int) (i10 * 0.4f), iA);
        int iF = f(this.f15576e);
        int i11 = i10 - (this.f15580i + iF);
        float f8 = iF;
        l.d("Max col widths (l, r)", f8, i11);
        Iterator it = listAsList.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i12++;
            }
        }
        int iMax2 = Math.max(0, (i12 - 1) * this.f15581j);
        int i13 = iA - iMax2;
        l.a("Measuring getTitle");
        b.b(this.f15577f, i11, i13);
        l.a("Measuring button");
        b.b(this.f15579h, i11, i13);
        l.a("Measuring scroll view");
        b.b(this.f15578g, i11, (i13 - e(this.f15577f)) - e(this.f15579h));
        this.f15582k = e(this.f15576e);
        this.f15583l = iMax2;
        Iterator it2 = listAsList.iterator();
        while (it2.hasNext()) {
            this.f15583l += e((View) it2.next());
        }
        int iMax3 = Math.max(this.f15582k + paddingBottom, this.f15583l + paddingBottom);
        Iterator it3 = listAsList.iterator();
        while (it3.hasNext()) {
            iMax = Math.max(f((View) it3.next()), iMax);
        }
        l.d("Measured columns (l, r)", f8, iMax);
        int i14 = iF + iMax + this.f15580i + paddingLeft;
        l.d("Measured dims", i14, iMax3);
        setMeasuredDimension(i14, iMax3);
    }
}
