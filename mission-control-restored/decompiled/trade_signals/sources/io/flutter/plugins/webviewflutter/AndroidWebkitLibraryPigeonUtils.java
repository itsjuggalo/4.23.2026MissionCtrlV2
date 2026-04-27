package io.flutter.plugins.webviewflutter;

import android.util.Log;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
final class AndroidWebkitLibraryPigeonUtils {
    public static final AndroidWebkitLibraryPigeonUtils INSTANCE = new AndroidWebkitLibraryPigeonUtils();

    private AndroidWebkitLibraryPigeonUtils() {
    }

    public final AndroidWebKitError createConnectionError(String channelName) {
        AbstractC2304t.f(channelName, "channelName");
        return new AndroidWebKitError("channel-error", "Unable to establish connection on channel: '" + channelName + "'.", "");
    }

    public final List<Object> wrapError(Throwable exception) {
        AbstractC2304t.f(exception, "exception");
        if (exception instanceof AndroidWebKitError) {
            AndroidWebKitError androidWebKitError = (AndroidWebKitError) exception;
            return AbstractC2595q.l(androidWebKitError.getCode(), androidWebKitError.getMessage(), androidWebKitError.getDetails());
        }
        return AbstractC2595q.l(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return AbstractC2594p.e(obj);
    }
}
