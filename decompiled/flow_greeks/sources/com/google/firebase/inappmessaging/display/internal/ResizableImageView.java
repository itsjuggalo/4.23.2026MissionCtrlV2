package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import o.k;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ResizableImageView extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6213d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6215b;

        public b(int i10, int i11) {
            this.f6214a = i10;
            this.f6215b = i11;
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public final b c(int i10, int i11) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i10 > maxWidth) {
            l.c("Image: capping width", maxWidth);
            i11 = (i11 * maxWidth) / i10;
            i10 = maxWidth;
        }
        if (i11 > maxHeight) {
            l.c("Image: capping height", maxHeight);
            i10 = (i10 * maxHeight) / i11;
        } else {
            maxHeight = i11;
        }
        return new b(i10, maxHeight);
    }

    public final void d() {
        int iMax = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int iMax2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f10 = iMax;
        float f11 = iMax2;
        l.d("Image: min width, height", f10, f11);
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        l.d("Image: actual width, height", f12, f13);
        float f14 = measuredWidth < iMax ? f10 / f12 : 1.0f;
        float f15 = measuredHeight < iMax2 ? f11 / f13 : 1.0f;
        if (f14 <= f15) {
            f14 = f15;
        }
        if (f14 > 1.0d) {
            int iCeil = (int) Math.ceil(f12 * f14);
            int iCeil2 = (int) Math.ceil(f13 * f14);
            l.a("Measured dimension (" + measuredWidth + "x" + measuredHeight + ") too small.  Resizing to " + iCeil + "x" + iCeil2);
            b bVarC = c(iCeil, iCeil2);
            setMeasuredDimension(bVarC.f6214a, bVarC.f6215b);
        }
    }

    public final void e(Context context) {
        this.f6213d = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    public final void f(Drawable drawable) {
        l.d("Image: intrinsic width, height", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        b bVarC = c((int) Math.ceil((r0 * this.f6213d) / 160), (int) Math.ceil((r5 * this.f6213d) / 160));
        l.d("Image: new target dimensions", bVarC.f6214a, bVarC.f6215b);
        setMeasuredDimension(bVarC.f6214a, bVarC.f6215b);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Drawable drawable = getDrawable();
        boolean adjustViewBounds = getAdjustViewBounds();
        if (drawable == null || !adjustViewBounds) {
            return;
        }
        f(drawable);
        d();
    }
}
