package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import g.AbstractC1248a;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1635a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0217a f13795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f13796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f13797c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.appcompat.widget.a f13798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13801h;

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    public class C0217a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13802a = false;

        public C0217a() {
        }
    }

    public AbstractC1635a(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f13795a = new C0217a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC1248a.f11542a, typedValue, true) || typedValue.resourceId == 0) {
            this.f13796b = context;
        } else {
            this.f13796b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int b(int i4, int i5, boolean z4) {
        return z4 ? i4 - i5 : i4 + i5;
    }

    public int a(View view, int i4, int i5, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return Math.max(0, (i4 - view.getMeasuredWidth()) - i6);
    }

    public int c(View view, int i4, int i5, int i6, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = i5 + ((i6 - measuredHeight) / 2);
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f13799f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.i.f11782a, AbstractC1248a.f11544c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(g.i.f11822i, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.f13798e;
        if (aVar != null) {
            aVar.B(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f13801h = false;
        }
        if (!this.f13801h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f13801h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f13801h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f13800g = false;
        }
        if (!this.f13800g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f13800g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f13800g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i4);

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            super.setVisibility(i4);
        }
    }
}
