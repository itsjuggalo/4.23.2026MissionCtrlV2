package n5;

import F5.AbstractC0556n;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public static final List b(Throwable th) {
        return AbstractC0556n.j(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }
}
