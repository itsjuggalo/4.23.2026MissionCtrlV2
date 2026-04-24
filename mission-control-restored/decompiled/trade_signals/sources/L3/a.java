package L3;

import F3.h;
import H3.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DisplayMetrics f5018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f5019d;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5019d = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, h.f1591a, 0, 0);
        try {
            this.f5016a = typedArrayObtainStyledAttributes.getFloat(h.f1593c, -1.0f);
            this.f5017b = typedArrayObtainStyledAttributes.getFloat(h.f1592b, -1.0f);
            typedArrayObtainStyledAttributes.recycle();
            this.f5018c = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int a(int i8) {
        if (getMaxHeightPct() > 0.0f) {
            l.a("Height: restrict by pct");
            return j((int) (getDisplayMetrics().heightPixels * getMaxHeightPct()), 4);
        }
        l.a("Height: restrict by spec");
        return View.MeasureSpec.getSize(i8);
    }

    public int b(int i8) {
        if (getMaxWidthPct() > 0.0f) {
            l.a("Width: restrict by pct");
            return j((int) (getDisplayMetrics().widthPixels * getMaxWidthPct()), 4);
        }
        l.a("Width: restrict by spec");
        return View.MeasureSpec.getSize(i8);
    }

    public int c(int i8) {
        return (int) Math.floor(TypedValue.applyDimension(1, i8, this.f5018c));
    }

    public View d(int i8) {
        View viewFindViewById = findViewById(i8);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException("No such child: " + i8);
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
        return this.f5018c;
    }

    public float getMaxHeightPct() {
        return this.f5017b;
    }

    public float getMaxWidthPct() {
        return this.f5016a;
    }

    public List<View> getVisibleChildren() {
        return this.f5019d;
    }

    public void h(View view, int i8, int i9) {
        i(view, i8, i9, i8 + f(view), i9 + e(view));
    }

    public void i(View view, int i8, int i9, int i10, int i11) {
        l.d("\tleft, right", i8, i10);
        l.d("\ttop, bottom", i9, i11);
        view.layout(i8, i9, i10, i11);
    }

    public int j(int i8, int i9) {
        return i9 * Math.round(i8 / i9);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i8, int i9, int i10, int i11) {
        l.d("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        super.measureChildWithMargins(view, i8, i9, i10, i11);
        l.d("\tactual  (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        l.b("BEGIN LAYOUT");
        l.a("onLayout: l: " + i8 + ", t: " + i9 + ", r: " + i10 + ", b: " + i11);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        l.b("BEGIN MEASURE");
        l.d("Display", getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
        this.f5019d.clear();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                this.f5019d.add(childAt);
            } else {
                l.c("Skipping GONE child", i10);
            }
        }
    }
}
