package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class K extends F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f21773b;

    public K(Context context, Resources resources) {
        super(resources);
        this.f21773b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i8) {
        Drawable drawableA = a(i8);
        Context context = (Context) this.f21773b.get();
        if (drawableA != null && context != null) {
            E.g().v(context, i8, drawableA);
        }
        return drawableA;
    }
}
