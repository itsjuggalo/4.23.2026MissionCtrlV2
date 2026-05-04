package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import s9.f;
import u9.l;
import y9.a;
import z9.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class CardLayoutPortrait extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static double f6221i = 0.8d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f6224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f6225h;

    public CardLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int size = getVisibleChildren().size();
        int measuredHeight = 0;
        for (int i14 = 0; i14 < size; i14++) {
            View view = getVisibleChildren().get(i14);
            int measuredHeight2 = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredHeight2 + measuredHeight;
            l.a("Layout child " + i14);
            l.d("\t(top, bottom)", (float) measuredHeight, (float) i15);
            l.d("\t(left, right)", (float) 0, (float) measuredWidth);
            view.layout(0, measuredHeight, measuredWidth, i15);
            l.d("Child " + i14 + " wants to be ", view.getMeasuredWidth(), view.getMeasuredHeight());
            measuredHeight += view.getMeasuredHeight();
        }
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f6222e = d(f.f20167n);
        this.f6223f = d(f.f20169p);
        this.f6224g = d(f.f20160g);
        this.f6225h = d(f.f20154a);
        int iB = b(i10);
        int iA = a(i11);
        int iJ = j((int) (f6221i * ((double) iA)), 4);
        l.a("Measuring image");
        b.d(this.f6222e, iB, iA);
        if (e(this.f6222e) > iJ) {
            l.a("Image exceeded maximum height, remeasuring image");
            b.c(this.f6222e, iB, iJ);
        }
        int iF = f(this.f6222e);
        l.a("Measuring title");
        b.d(this.f6223f, iF, iA);
        l.a("Measuring action bar");
        b.d(this.f6225h, iF, iA);
        l.a("Measuring scroll view");
        b.d(this.f6224g, iF, ((iA - e(this.f6222e)) - e(this.f6223f)) - e(this.f6225h));
        int size = getVisibleChildren().size();
        int iE = 0;
        for (int i12 = 0; i12 < size; i12++) {
            iE += e(getVisibleChildren().get(i12));
        }
        setMeasuredDimension(iF, iE);
    }
}
