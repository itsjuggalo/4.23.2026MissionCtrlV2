package R;

import android.content.Context;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final boolean a(Context context, String name) {
        j.e(context, "context");
        j.e(name, "name");
        return context.deleteSharedPreferences(name);
    }
}
