package E4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f1638b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1641e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f1637a = new Paint(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1639c = 255;

    public d(Bitmap bitmap) {
        b(bitmap);
    }

    public Bitmap a() {
        return this.f1638b;
    }

    public void b(Bitmap bitmap) {
        this.f1638b = bitmap;
        if (bitmap != null) {
            this.f1640d = bitmap.getWidth();
            this.f1641e = this.f1638b.getHeight();
        } else {
            this.f1641e = 0;
            this.f1640d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1638b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f1638b, (Rect) null, getBounds(), this.f1637a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1639c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1641e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1640d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1641e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1640d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f1639c = i7;
        this.f1637a.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1637a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        this.f1637a.setFilterBitmap(z7);
    }
}
