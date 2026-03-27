package U;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final File a(Context context, String name) {
        r.f(context, "<this>");
        r.f(name, "name");
        return R.a.a(context, name + ".preferences_pb");
    }
}
