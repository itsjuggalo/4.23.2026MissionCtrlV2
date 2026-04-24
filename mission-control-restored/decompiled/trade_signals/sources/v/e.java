package v;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23694a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f23696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f23697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23698e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f23701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f23702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f23703j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23699f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23700g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f23704k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f23695b = new Paint(5);

    public e(ColorStateList colorStateList, float f8) {
        this.f23694a = f8;
        e(colorStateList);
        this.f23696c = new RectF();
        this.f23697d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f23701h;
    }

    public float c() {
        return this.f23698e;
    }

    public float d() {
        return this.f23694a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z7;
        Paint paint = this.f23695b;
        if (this.f23702i == null || paint.getColorFilter() != null) {
            z7 = false;
        } else {
            paint.setColorFilter(this.f23702i);
            z7 = true;
        }
        RectF rectF = this.f23696c;
        float f8 = this.f23694a;
        canvas.drawRoundRect(rectF, f8, f8, paint);
        if (z7) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f23701h = colorStateList;
        this.f23695b.setColor(colorStateList.getColorForState(getState(), this.f23701h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f8, boolean z7, boolean z8) {
        if (f8 == this.f23698e && this.f23699f == z7 && this.f23700g == z8) {
            return;
        }
        this.f23698e = f8;
        this.f23699f = z7;
        this.f23700g = z8;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f23697d, this.f23694a);
    }

    public void h(float f8) {
        if (f8 == this.f23694a) {
            return;
        }
        this.f23694a = f8;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f23696c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f23697d.set(rect);
        if (this.f23699f) {
            this.f23697d.inset((int) Math.ceil(f.a(this.f23698e, this.f23694a, this.f23700g)), (int) Math.ceil(f.b(this.f23698e, this.f23694a, this.f23700g)));
            this.f23696c.set(this.f23697d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f23703j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f23701h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f23701h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z7 = colorForState != this.f23695b.getColor();
        if (z7) {
            this.f23695b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f23703j;
        if (colorStateList2 == null || (mode = this.f23704k) == null) {
            return z7;
        }
        this.f23702i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f23695b.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f23695b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f23703j = colorStateList;
        this.f23702i = a(colorStateList, this.f23704k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f23704k = mode;
        this.f23702i = a(this.f23703j, mode);
        invalidateSelf();
    }
}
