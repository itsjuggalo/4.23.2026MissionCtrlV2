package io.flutter.plugins.sharedpreferences;

import android.util.Log;
import java.util.List;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class MessagesAsync_gKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> wrapError(Throwable th) {
        if (th instanceof SharedPreferencesError) {
            SharedPreferencesError sharedPreferencesError = (SharedPreferencesError) th;
            return AbstractC2595q.l(sharedPreferencesError.getCode(), sharedPreferencesError.getMessage(), sharedPreferencesError.getDetails());
        }
        return AbstractC2595q.l(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }

    private static final List<Object> wrapResult(Object obj) {
        return AbstractC2594p.e(obj);
    }
}
