package f1;

import W0.v;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class k extends j {
    public k(Drawable drawable) {
        super(drawable);
    }

    public static v f(Drawable drawable) {
        if (drawable != null) {
            return new k(drawable);
        }
        return null;
    }

    @Override // W0.v
    public int c() {
        return Math.max(1, this.f17382a.getIntrinsicWidth() * this.f17382a.getIntrinsicHeight() * 4);
    }

    @Override // W0.v
    public Class d() {
        return this.f17382a.getClass();
    }

    @Override // W0.v
    public void b() {
    }
}
