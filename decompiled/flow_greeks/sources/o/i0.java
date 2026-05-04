package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f17279b;

    public i0(Context context, Resources resources) {
        super(resources);
        this.f17279b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Drawable drawableA = a(i10);
        Context context = (Context) this.f17279b.get();
        if (drawableA != null && context != null) {
            c0.g().v(context, i10, drawableA);
        }
        return drawableA;
    }
}
