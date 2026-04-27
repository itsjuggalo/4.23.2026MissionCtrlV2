package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class Z extends S {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f13794b;

    public Z(Context context, Resources resources) {
        super(resources);
        this.f13794b = new WeakReference(context);
    }

    @Override // o.S, android.content.res.Resources
    public Drawable getDrawable(int i4) {
        Drawable drawable = super.getDrawable(i4);
        Context context = (Context) this.f13794b.get();
        if (drawable != null && context != null) {
            Q.g().v(context, i4, drawable);
        }
        return drawable;
    }
}
