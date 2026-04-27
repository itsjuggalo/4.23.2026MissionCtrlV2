package J3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f781b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f783d;
    public final int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f780a = new Paint(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f782c = 255;

    public a(Bitmap bitmap) {
        this.f781b = bitmap;
        if (bitmap != null) {
            this.f783d = bitmap.getWidth();
            this.e = this.f781b.getHeight();
        } else {
            this.e = 0;
            this.f783d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f781b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f781b, (Rect) null, getBounds(), this.f780a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f782c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f783d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f783d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f782c = i;
        this.f780a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f780a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z6) {
        this.f780a.setFilterBitmap(z6);
    }
}
