package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import s.AbstractC2639a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6977b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6976a = getResources().getDimensionPixelOffset(AbstractC2639a.f22962b);
        this.f6977b = getResources().getDimensionPixelOffset(AbstractC2639a.f22961a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f6976a * 2), this.f6977b), 1073741824), i8);
    }
}
