package r3;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c4.k;
import i3.r;
import i3.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements v, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f19292a;

    public e(Drawable drawable) {
        this.f19292a = (Drawable) k.e(drawable);
    }

    @Override // i3.r
    public void a() {
        Drawable drawable = this.f19292a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof t3.c) {
            ((t3.c) drawable).e().prepareToDraw();
        }
    }

    @Override // i3.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.f19292a.getConstantState();
        return constantState == null ? this.f19292a : constantState.newDrawable();
    }
}
