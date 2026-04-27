package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import s.AbstractC2680a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10804b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10803a = getResources().getDimensionPixelOffset(AbstractC2680a.f22942b);
        this.f10804b = getResources().getDimensionPixelOffset(AbstractC2680a.f22941a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f10803a * 2), this.f10804b), 1073741824), i9);
    }
}
