package p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class Q extends K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f21301b;

    public Q(Context context, Resources resources) {
        super(resources);
        this.f21301b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i7) {
        Drawable drawableA = a(i7);
        Context context = (Context) this.f21301b.get();
        if (drawableA != null && context != null) {
            J.g().v(context, i7, drawableA);
        }
        return drawableA;
    }
}
