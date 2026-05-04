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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0303a f17202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f17204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.appcompat.widget.a f17205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17208g;

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0303a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17209a = false;

        public C0303a() {
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17202a = new C0303a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(g.a.f9659a, typedValue, true) || typedValue.resourceId == 0) {
            this.f17203b = context;
        } else {
            this.f17203b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int b(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public int a(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int c(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f17206e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.i.f9762a, g.a.f9661c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(g.i.f9794i, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.f17205d;
        if (aVar != null) {
            aVar.C(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f17208g = false;
        }
        if (!this.f17208g) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f17208g = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f17208g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f17207f = false;
        }
        if (!this.f17207f) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f17207f = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f17207f = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            super.setVisibility(i10);
        }
    }
}
