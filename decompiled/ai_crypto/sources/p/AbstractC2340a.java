package p;

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
import h.AbstractC1656a;
import h.AbstractC1664i;

/* JADX INFO: renamed from: p.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2340a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0333a f21322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f21324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.appcompat.widget.a f21325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21328g;

    /* JADX INFO: renamed from: p.a$a, reason: collision with other inner class name */
    public class C0333a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21329a = false;

        public C0333a() {
        }
    }

    public AbstractC2340a(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f21322a = new C0333a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC1656a.f14334a, typedValue, true) || typedValue.resourceId == 0) {
            this.f21323b = context;
        } else {
            this.f21323b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int b(int i7, int i8, boolean z7) {
        return z7 ? i7 - i8 : i7 + i8;
    }

    public int a(View view, int i7, int i8, int i9) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), i8);
        return Math.max(0, (i7 - view.getMeasuredWidth()) - i9);
    }

    public int c(View view, int i7, int i8, int i9, boolean z7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i8 + ((i9 - measuredHeight) / 2);
        if (z7) {
            view.layout(i7 - measuredWidth, i10, i7, measuredHeight + i10);
        } else {
            view.layout(i7, i10, i7 + measuredWidth, measuredHeight + i10);
        }
        return z7 ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f21326e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC1664i.f14580a, AbstractC1656a.f14336c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(AbstractC1664i.f14618i, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.f21325d;
        if (aVar != null) {
            aVar.C(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f21328g = false;
        }
        if (!this.f21328g) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f21328g = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f21328g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f21327f = false;
        }
        if (!this.f21327f) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f21327f = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f21327f = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i7);

    @Override // android.view.View
    public void setVisibility(int i7) {
        if (i7 != getVisibility()) {
            super.setVisibility(i7);
        }
    }
}
