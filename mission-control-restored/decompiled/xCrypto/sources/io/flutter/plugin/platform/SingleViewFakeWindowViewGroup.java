package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
class SingleViewFakeWindowViewGroup extends ViewGroup {
    private final Rect childRect;
    private final Rect viewBounds;

    public SingleViewFakeWindowViewGroup(Context context) {
        super(context);
        this.viewBounds = new Rect();
        this.childRect = new Rect();
    }

    private static int atMost(int i4) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.viewBounds.set(i4, i5, i6, i7);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams.x, layoutParams.y, this.childRect);
            Rect rect = this.childRect;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildAt(i6).measure(atMost(i4), atMost(i5));
        }
        super.onMeasure(i4, i5);
    }
}
