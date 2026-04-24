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
public class CardLayoutLandscape extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static double f15563i = 0.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f15564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f15565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f15566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f15567h;

    public CardLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        l.a("Layout image");
        int iF = f(this.f15564e);
        i(this.f15564e, 0, 0, iF, e(this.f15564e));
        l.a("Layout title");
        int iE = e(this.f15565f);
        i(this.f15565f, iF, 0, measuredWidth, iE);
        l.a("Layout scroll");
        i(this.f15566g, iF, iE, measuredWidth, iE + e(this.f15566g));
        l.a("Layout action bar");
        i(this.f15567h, iF, measuredHeight - e(this.f15567h), measuredWidth, measuredHeight);
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f15564e = d(f.f1580n);
        this.f15565f = d(f.f1582p);
        this.f15566g = d(f.f1573g);
        View viewD = d(f.f1567a);
        this.f15567h = viewD;
        List listAsList = Arrays.asList(this.f15565f, this.f15566g, viewD);
        int iB = b(i8);
        int iA = a(i9);
        int iJ = j((int) (f15563i * ((double) iB)), 4);
        l.a("Measuring image");
        b.c(this.f15564e, iB, iA);
        if (f(this.f15564e) > iJ) {
            l.a("Image exceeded maximum width, remeasuring image");
            b.d(this.f15564e, iJ, iA);
        }
        int iE = e(this.f15564e);
        int iF = f(this.f15564e);
        int i10 = iB - iF;
        float f8 = iF;
        l.d("Max col widths (l, r)", f8, i10);
        l.a("Measuring title");
        b.b(this.f15565f, i10, iE);
        l.a("Measuring action bar");
        b.b(this.f15567h, i10, iE);
        l.a("Measuring scroll view");
        b.c(this.f15566g, i10, (iE - e(this.f15565f)) - e(this.f15567h));
        Iterator it = listAsList.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(f((View) it.next()), iMax);
        }
        l.d("Measured columns (l, r)", f8, iMax);
        int i11 = iF + iMax;
        l.d("Measured dims", i11, iE);
        setMeasuredDimension(i11, iE);
    }
}
