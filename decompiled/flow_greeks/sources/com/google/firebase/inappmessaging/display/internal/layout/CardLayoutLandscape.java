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
public class CardLayoutLandscape extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static double f6216i = 0.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f6218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f6219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f6220h;

    public CardLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        l.a("Layout image");
        int iF = f(this.f6217e);
        i(this.f6217e, 0, 0, iF, e(this.f6217e));
        l.a("Layout title");
        int iE = e(this.f6218f);
        i(this.f6218f, iF, 0, measuredWidth, iE);
        l.a("Layout scroll");
        i(this.f6219g, iF, iE, measuredWidth, iE + e(this.f6219g));
        l.a("Layout action bar");
        i(this.f6220h, iF, measuredHeight - e(this.f6220h), measuredWidth, measuredHeight);
    }

    @Override // y9.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f6217e = d(f.f20167n);
        this.f6218f = d(f.f20169p);
        this.f6219g = d(f.f20160g);
        View viewD = d(f.f20154a);
        this.f6220h = viewD;
        List listAsList = Arrays.asList(this.f6218f, this.f6219g, viewD);
        int iB = b(i10);
        int iA = a(i11);
        int iJ = j((int) (f6216i * ((double) iB)), 4);
        l.a("Measuring image");
        b.c(this.f6217e, iB, iA);
        if (f(this.f6217e) > iJ) {
            l.a("Image exceeded maximum width, remeasuring image");
            b.d(this.f6217e, iJ, iA);
        }
        int iE = e(this.f6217e);
        int iF = f(this.f6217e);
        int i12 = iB - iF;
        float f10 = iF;
        l.d("Max col widths (l, r)", f10, i12);
        l.a("Measuring title");
        b.b(this.f6218f, i12, iE);
        l.a("Measuring action bar");
        b.b(this.f6220h, i12, iE);
        l.a("Measuring scroll view");
        b.c(this.f6219g, i12, (iE - e(this.f6218f)) - e(this.f6220h));
        Iterator it = listAsList.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(f((View) it.next()), iMax);
        }
        l.d("Measured columns (l, r)", f10, iMax);
        int i13 = iF + iMax;
        l.d("Measured dims", i13, iE);
        setMeasuredDimension(i13, iE);
    }
}
