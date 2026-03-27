package com.google.firebase.inappmessaging.display.internal;

import H3.l;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import o.C2442k;

/* JADX INFO: loaded from: classes.dex */
public class ResizableImageView extends C2442k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15560d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15562b;

        public b(int i8, int i9) {
            this.f15561a = i8;
            this.f15562b = i9;
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public final b c(int i8, int i9) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i8 > maxWidth) {
            l.c("Image: capping width", maxWidth);
            i9 = (i9 * maxWidth) / i8;
            i8 = maxWidth;
        }
        if (i9 > maxHeight) {
            l.c("Image: capping height", maxHeight);
            i8 = (i8 * maxHeight) / i9;
        } else {
            maxHeight = i9;
        }
        return new b(i8, maxHeight);
    }

    public final void d() {
        int iMax = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int iMax2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f8 = iMax;
        float f9 = iMax2;
        l.d("Image: min width, height", f8, f9);
        float f10 = measuredWidth;
        float f11 = measuredHeight;
        l.d("Image: actual width, height", f10, f11);
        float f12 = measuredWidth < iMax ? f8 / f10 : 1.0f;
        float f13 = measuredHeight < iMax2 ? f9 / f11 : 1.0f;
        if (f12 <= f13) {
            f12 = f13;
        }
        if (f12 > 1.0d) {
            int iCeil = (int) Math.ceil(f10 * f12);
            int iCeil2 = (int) Math.ceil(f11 * f12);
            l.a("Measured dimension (" + measuredWidth + "x" + measuredHeight + ") too small.  Resizing to " + iCeil + "x" + iCeil2);
            b bVarC = c(iCeil, iCeil2);
            setMeasuredDimension(bVarC.f15561a, bVarC.f15562b);
        }
    }

    public final void e(Context context) {
        this.f15560d = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    public final void f(Drawable drawable) {
        l.d("Image: intrinsic width, height", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        b bVarC = c((int) Math.ceil((r0 * this.f15560d) / 160), (int) Math.ceil((r5 * this.f15560d) / 160));
        l.d("Image: new target dimensions", bVarC.f15561a, bVarC.f15562b);
        setMeasuredDimension(bVarC.f15561a, bVarC.f15562b);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        Drawable drawable = getDrawable();
        boolean adjustViewBounds = getAdjustViewBounds();
        if (drawable == null || !adjustViewBounds) {
            return;
        }
        f(drawable);
        d();
    }
}
