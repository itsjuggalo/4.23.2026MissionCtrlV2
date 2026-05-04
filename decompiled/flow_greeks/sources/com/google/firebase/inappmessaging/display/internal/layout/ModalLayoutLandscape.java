package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s9.f;
import u9.l;
import y9.a;
import z9.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ModalLayoutLandscape extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f6231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f6232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6236l;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i16 = this.f6235k;
        int i17 = this.f6236l;
        if (i16 < i17) {
            i15 = (i17 - i16) / 2;
            i14 = 0;
        } else {
            i14 = (i16 - i17) / 2;
            i15 = 0;
        }
        l.a("Layout image");
        int i18 = paddingTop + i15;
        int iF = paddingLeft + f(this.f6229e);
        i(this.f6229e, paddingLeft, i18, iF, i18 + e(this.f6229e));
        int i19 = iF + this.f6233i;
        l.a("Layout getTitle");
        int i20 = paddingTop + i14;
        int iE = i20 + e(this.f6230f);
        i(this.f6230f, i19, i20, measuredWidth, iE);
        l.a("Layout getBody");
        int i21 = iE + (this.f6230f.getVisibility() == 8 ? 0 : this.f6234j);
        int iE2 = i21 + e(this.f6231g);
        i(this.f6231g, i19, i21, measuredWidth, iE2);
        l.a("Layout button");
        h(this.f6232h, i19, iE2 + (this.f6231g.getVisibility() != 8 ? this.f6234j : 0));
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f6229e = d(f.f20167n);
        this.f6230f = d(f.f20169p);
        this.f6231g = d(f.f20160g);
        this.f6232h = d(f.f20161h);
        int iMax = 0;
        this.f6233i = this.f6229e.getVisibility() == 8 ? 0 : c(24);
        this.f6234j = c(24);
        List listAsList = Arrays.asList(this.f6230f, this.f6231g, this.f6232h);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iB = b(i10);
        int iA = a(i11) - paddingBottom;
        int i12 = iB - paddingLeft;
        l.a("Measuring image");
        b.b(this.f6229e, (int) (i12 * 0.4f), iA);
        int iF = f(this.f6229e);
        int i13 = i12 - (this.f6233i + iF);
        float f10 = iF;
        l.d("Max col widths (l, r)", f10, i13);
        Iterator it = listAsList.iterator();
        int i14 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i14++;
            }
        }
        int iMax2 = Math.max(0, (i14 - 1) * this.f6234j);
        int i15 = iA - iMax2;
        l.a("Measuring getTitle");
        b.b(this.f6230f, i13, i15);
        l.a("Measuring button");
        b.b(this.f6232h, i13, i15);
        l.a("Measuring scroll view");
        b.b(this.f6231g, i13, (i15 - e(this.f6230f)) - e(this.f6232h));
        this.f6235k = e(this.f6229e);
        this.f6236l = iMax2;
        Iterator it2 = listAsList.iterator();
        while (it2.hasNext()) {
            this.f6236l += e((View) it2.next());
        }
        int iMax3 = Math.max(this.f6235k + paddingBottom, this.f6236l + paddingBottom);
        Iterator it3 = listAsList.iterator();
        while (it3.hasNext()) {
            iMax = Math.max(f((View) it3.next()), iMax);
        }
        l.d("Measured columns (l, r)", f10, iMax);
        int i16 = iF + iMax + this.f6233i + paddingLeft;
        l.d("Measured dims", i16, iMax3);
        setMeasuredDimension(i16, iMax3);
    }
}
