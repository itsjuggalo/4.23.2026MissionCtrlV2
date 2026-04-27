package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import s.AbstractC1763a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6815b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6814a = getResources().getDimensionPixelOffset(AbstractC1763a.f14605b);
        this.f6815b = getResources().getDimensionPixelOffset(AbstractC1763a.f14604a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f6814a * 2), this.f6815b), 1073741824), i5);
    }
}
