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
import g.AbstractC1764a;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2432a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0362a f21804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f21806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.appcompat.widget.a f21807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21810g;

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    public class C0362a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21811a = false;

        public C0362a() {
        }
    }

    public AbstractC2432a(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f21804a = new C0362a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC1764a.f17650a, typedValue, true) || typedValue.resourceId == 0) {
            this.f21805b = context;
        } else {
            this.f21805b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int b(int i8, int i9, boolean z7) {
        return z7 ? i8 - i9 : i8 + i9;
    }

    public int a(View view, int i8, int i9, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE), i9);
        return Math.max(0, (i8 - view.getMeasuredWidth()) - i10);
    }

    public int c(View view, int i8, int i9, int i10, boolean z7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i9 + ((i10 - measuredHeight) / 2);
        if (z7) {
            view.layout(i8 - measuredWidth, i11, i8, measuredHeight + i11);
        } else {
            view.layout(i8, i11, i8 + measuredWidth, measuredHeight + i11);
        }
        return z7 ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f21808e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.i.f17861a, AbstractC1764a.f17652c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(g.i.f17893i, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.f21807d;
        if (aVar != null) {
            aVar.C(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f21810g = false;
        }
        if (!this.f21810g) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f21810g = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f21810g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f21809f = false;
        }
        if (!this.f21809f) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f21809f = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f21809f = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i8);

    @Override // android.view.View
    public void setVisibility(int i8) {
        if (i8 != getVisibility()) {
            super.setVisibility(i8);
        }
    }
}
