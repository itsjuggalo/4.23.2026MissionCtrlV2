package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class S extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f16711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f16712b;

    public S(Context context) {
        super(context);
        this.f16711a = new Rect();
        this.f16712b = new Rect();
    }

    public static int a(int i7) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7), Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.f16711a.set(i7, i8, i9, i10);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f16711a, layoutParams.x, layoutParams.y, this.f16712b);
            Rect rect = this.f16712b;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            getChildAt(i9).measure(a(i7), a(i8));
        }
        super.onMeasure(i7, i8);
    }
}
