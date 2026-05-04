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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23051a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f23053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f23054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23055e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f23058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f23059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f23060j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23056f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23057g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f23061k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f23052b = new Paint(5);

    public e(ColorStateList colorStateList, float f10) {
        this.f23051a = f10;
        e(colorStateList);
        this.f23053c = new RectF();
        this.f23054d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f23058h;
    }

    public float c() {
        return this.f23055e;
    }

    public float d() {
        return this.f23051a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f23052b;
        if (this.f23059i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f23059i);
            z10 = true;
        }
        RectF rectF = this.f23053c;
        float f10 = this.f23051a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f23058h = colorStateList;
        this.f23052b.setColor(colorStateList.getColorForState(getState(), this.f23058h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f23055e && this.f23056f == z10 && this.f23057g == z11) {
            return;
        }
        this.f23055e = f10;
        this.f23056f = z10;
        this.f23057g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f23054d, this.f23051a);
    }

    public void h(float f10) {
        if (f10 == this.f23051a) {
            return;
        }
        this.f23051a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f23053c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f23054d.set(rect);
        if (this.f23056f) {
            this.f23054d.inset((int) Math.ceil(f.a(this.f23055e, this.f23051a, this.f23057g)), (int) Math.ceil(f.b(this.f23055e, this.f23051a, this.f23057g)));
            this.f23053c.set(this.f23054d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f23060j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f23058h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f23058h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f23052b.getColor();
        if (z10) {
            this.f23052b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f23060j;
        if (colorStateList2 == null || (mode = this.f23061k) == null) {
            return z10;
        }
        this.f23059i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f23052b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f23052b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f23060j = colorStateList;
        this.f23059i = a(colorStateList, this.f23061k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f23061k = mode;
        this.f23059i = a(this.f23060j, mode);
        invalidateSelf();
    }
}
