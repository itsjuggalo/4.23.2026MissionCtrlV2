package com.google.firebase.inappmessaging.display.internal.layout;

import F3.f;
import H3.l;
import L3.a;
import M3.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CardLayoutPortrait extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static double f15568i = 0.8d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f15569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f15570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f15571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f15572h;

    public CardLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        int size = getVisibleChildren().size();
        int measuredHeight = 0;
        for (int i12 = 0; i12 < size; i12++) {
            View view = getVisibleChildren().get(i12);
            int measuredHeight2 = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i13 = measuredHeight2 + measuredHeight;
            l.a("Layout child " + i12);
            l.d("\t(top, bottom)", (float) measuredHeight, (float) i13);
            l.d("\t(left, right)", (float) 0, (float) measuredWidth);
            view.layout(0, measuredHeight, measuredWidth, i13);
            l.d("Child " + i12 + " wants to be ", view.getMeasuredWidth(), view.getMeasuredHeight());
            measuredHeight += view.getMeasuredHeight();
        }
    }

    @Override // L3.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f15569e = d(f.f1580n);
        this.f15570f = d(f.f1582p);
        this.f15571g = d(f.f1573g);
        this.f15572h = d(f.f1567a);
        int iB = b(i8);
        int iA = a(i9);
        int iJ = j((int) (f15568i * ((double) iA)), 4);
        l.a("Measuring image");
        b.d(this.f15569e, iB, iA);
        if (e(this.f15569e) > iJ) {
            l.a("Image exceeded maximum height, remeasuring image");
            b.c(this.f15569e, iB, iJ);
        }
        int iF = f(this.f15569e);
        l.a("Measuring title");
        b.d(this.f15570f, iF, iA);
        l.a("Measuring action bar");
        b.d(this.f15572h, iF, iA);
        l.a("Measuring scroll view");
        b.d(this.f15571g, iF, ((iA - e(this.f15569e)) - e(this.f15570f)) - e(this.f15572h));
        int size = getVisibleChildren().size();
        int iE = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iE += e(getVisibleChildren().get(i10));
        }
        setMeasuredDimension(iF, iE);
    }
}
