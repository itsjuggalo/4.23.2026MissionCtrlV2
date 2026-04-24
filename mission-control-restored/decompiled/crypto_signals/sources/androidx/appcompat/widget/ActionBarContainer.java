package androidx.appcompat.widget;

import D.C;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.cryptosignals.ap.android.R;
import h.AbstractC0616a;
import java.lang.reflect.Field;
import m.AbstractC0838q0;
import m.C0805a;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f4232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f4233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f4234d;
    public Drawable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f4235f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4238m;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0805a c0805a = new C0805a(this);
        Field field = C.f194a;
        setBackground(c0805a);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0616a.f6573a);
        boolean z6 = false;
        this.f4234d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f4238m = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f4236k = true;
            this.f4235f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f4236k ? !(this.f4234d != null || this.e != null) : this.f4235f == null) {
            z6 = true;
        }
        setWillNotDraw(z6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4234d;
        if (drawable != null && drawable.isStateful()) {
            this.f4234d.setState(getDrawableState());
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f4235f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f4235f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4234d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f4235f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f4232b = findViewById(R.id.action_bar);
        this.f4233c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4231a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i6, int i7, int i8) {
        super.onLayout(z6, i, i6, i7, i8);
        boolean z7 = true;
        if (this.f4236k) {
            Drawable drawable = this.f4235f;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z7 = false;
            }
        } else {
            if (this.f4234d == null) {
                z7 = false;
            } else if (this.f4232b.getVisibility() == 0) {
                this.f4234d.setBounds(this.f4232b.getLeft(), this.f4232b.getTop(), this.f4232b.getRight(), this.f4232b.getBottom());
            } else {
                View view = this.f4233c;
                if (view == null || view.getVisibility() != 0) {
                    this.f4234d.setBounds(0, 0, 0, 0);
                } else {
                    this.f4234d.setBounds(this.f4233c.getLeft(), this.f4233c.getTop(), this.f4233c.getRight(), this.f4233c.getBottom());
                }
            }
            this.f4237l = false;
        }
        if (z7) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        int i7;
        if (this.f4232b == null && View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE && (i7 = this.f4238m) >= 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i7, View.MeasureSpec.getSize(i6)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i6);
        if (this.f4232b == null) {
            return;
        }
        View.MeasureSpec.getMode(i6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f4234d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f4234d);
        }
        this.f4234d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f4232b;
            if (view != null) {
                this.f4234d.setBounds(view.getLeft(), this.f4232b.getTop(), this.f4232b.getRight(), this.f4232b.getBottom());
            }
        }
        boolean z6 = false;
        if (!this.f4236k ? !(this.f4234d != null || this.e != null) : this.f4235f == null) {
            z6 = true;
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f4235f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f4235f);
        }
        this.f4235f = drawable;
        boolean z6 = this.f4236k;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z6 && (drawable2 = this.f4235f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z6 ? !(this.f4234d != null || this.e != null) : this.f4235f == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f4237l && this.e != null) {
                throw null;
            }
        }
        boolean z6 = false;
        if (!this.f4236k ? !(this.f4234d != null || this.e != null) : this.f4235f == null) {
            z6 = true;
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z6) {
        this.f4231a = z6;
        setDescendantFocusability(z6 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z6 = i == 0;
        Drawable drawable = this.f4234d;
        if (drawable != null) {
            drawable.setVisible(z6, false);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setVisible(z6, false);
        }
        Drawable drawable3 = this.f4235f;
        if (drawable3 != null) {
            drawable3.setVisible(z6, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4234d;
        boolean z6 = this.f4236k;
        if (drawable == drawable2 && !z6) {
            return true;
        }
        if (drawable == this.e && this.f4237l) {
            return true;
        }
        return (drawable == this.f4235f && z6) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    public void setTabContainer(AbstractC0838q0 abstractC0838q0) {
    }
}
