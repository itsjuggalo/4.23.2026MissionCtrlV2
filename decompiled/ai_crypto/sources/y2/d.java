package y2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends androidx.appcompat.widget.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f25605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f25606q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f25607r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f25608s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f25609t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f25610u;

    public d(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25606q = new Rect();
        this.f25607r = new Rect();
        this.f25608s = 119;
        this.f25609t = true;
        this.f25610u = false;
        TypedArray typedArrayH = k.h(context, attributeSet, n2.j.f19564s1, i7, 0, new int[0]);
        this.f25608s = typedArrayH.getInt(n2.j.f19578u1, this.f25608s);
        Drawable drawable = typedArrayH.getDrawable(n2.j.f19571t1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f25609t = typedArrayH.getBoolean(n2.j.f19585v1, true);
        typedArrayH.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f25605p;
        if (drawable != null) {
            if (this.f25610u) {
                this.f25610u = false;
                Rect rect = this.f25606q;
                Rect rect2 = this.f25607r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f25609t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f25608s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f7, float f8) {
        super.drawableHotspotChanged(f7, f8);
        Drawable drawable = this.f25605p;
        if (drawable != null) {
            drawable.setHotspot(f7, f8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f25605p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f25605p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f25605p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f25608s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f25605p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        this.f25610u = z7 | this.f25610u;
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        this.f25610u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f25605p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f25605p);
            }
            this.f25605p = drawable;
            this.f25610u = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f25608s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i7) {
        if (this.f25608s != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f25608s = i7;
            if (i7 == 119 && this.f25605p != null) {
                this.f25605p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f25605p;
    }
}
