package y9;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import s9.h;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DisplayMetrics f25328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f25329d;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25329d = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, h.f20178a, 0, 0);
        try {
            this.f25326a = typedArrayObtainStyledAttributes.getFloat(h.f20180c, -1.0f);
            this.f25327b = typedArrayObtainStyledAttributes.getFloat(h.f20179b, -1.0f);
            typedArrayObtainStyledAttributes.recycle();
            this.f25328c = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int a(int i10) {
        if (getMaxHeightPct() > 0.0f) {
            l.a("Height: restrict by pct");
            return j((int) (getDisplayMetrics().heightPixels * getMaxHeightPct()), 4);
        }
        l.a("Height: restrict by spec");
        return View.MeasureSpec.getSize(i10);
    }

    public int b(int i10) {
        if (getMaxWidthPct() > 0.0f) {
            l.a("Width: restrict by pct");
            return j((int) (getDisplayMetrics().widthPixels * getMaxWidthPct()), 4);
        }
        l.a("Width: restrict by spec");
        return View.MeasureSpec.getSize(i10);
    }

    public int c(int i10) {
        return (int) Math.floor(TypedValue.applyDimension(1, i10, this.f25328c));
    }

    public View d(int i10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException("No such child: " + i10);
    }

    public int e(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    public int f(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    public FrameLayout.LayoutParams g(View view) {
        return (FrameLayout.LayoutParams) view.getLayoutParams();
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f25328c;
    }

    public float getMaxHeightPct() {
        return this.f25327b;
    }

    public float getMaxWidthPct() {
        return this.f25326a;
    }

    public List<View> getVisibleChildren() {
        return this.f25329d;
    }

    public void h(View view, int i10, int i11) {
        i(view, i10, i11, i10 + f(view), i11 + e(view));
    }

    public void i(View view, int i10, int i11, int i12, int i13) {
        l.d("\tleft, right", i10, i12);
        l.d("\ttop, bottom", i11, i13);
        view.layout(i10, i11, i12, i13);
    }

    public int j(int i10, int i11) {
        return i11 * Math.round(i10 / i11);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        l.d("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        super.measureChildWithMargins(view, i10, i11, i12, i13);
        l.d("\tactual  (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        l.b("BEGIN LAYOUT");
        l.a("onLayout: l: " + i10 + ", t: " + i11 + ", r: " + i12 + ", b: " + i13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        l.b("BEGIN MEASURE");
        l.d("Display", getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
        this.f25329d.clear();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                this.f25329d.add(childAt);
            } else {
                l.c("Skipping GONE child", i12);
            }
        }
    }
}
