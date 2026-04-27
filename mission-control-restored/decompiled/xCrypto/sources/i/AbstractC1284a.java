package i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import java.util.WeakHashMap;
import o.Q;

/* JADX INFO: renamed from: i.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1284a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f12166a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f12167b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f12168c = new Object();

    public static ColorStateList a(Context context, int i4) {
        return context.getColorStateList(i4);
    }

    public static Drawable b(Context context, int i4) {
        return Q.g().i(context, i4);
    }
}
