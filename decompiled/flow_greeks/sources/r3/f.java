package r3;

import android.graphics.drawable.Drawable;
import i3.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends e {
    public f(Drawable drawable) {
        super(drawable);
    }

    public static v f(Drawable drawable) {
        if (drawable != null) {
            return new f(drawable);
        }
        return null;
    }

    @Override // i3.v
    public int c() {
        return Math.max(1, this.f19292a.getIntrinsicWidth() * this.f19292a.getIntrinsicHeight() * 4);
    }

    @Override // i3.v
    public Class d() {
        return this.f19292a.getClass();
    }

    @Override // i3.v
    public void b() {
    }
}
