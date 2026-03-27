package io.flutter.plugins.webviewflutter;

import X2.AbstractC0768o;
import X2.AbstractC0769p;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidWebkitLibraryPigeonUtils {
    public static final AndroidWebkitLibraryPigeonUtils INSTANCE = new AndroidWebkitLibraryPigeonUtils();

    private AndroidWebkitLibraryPigeonUtils() {
    }

    public final AndroidWebKitError createConnectionError(String channelName) {
        kotlin.jvm.internal.r.f(channelName, "channelName");
        return new AndroidWebKitError("channel-error", "Unable to establish connection on channel: '" + channelName + "'.", "");
    }

    public final List<Object> wrapError(Throwable exception) {
        kotlin.jvm.internal.r.f(exception, "exception");
        if (exception instanceof AndroidWebKitError) {
            AndroidWebKitError androidWebKitError = (AndroidWebKitError) exception;
            return AbstractC0769p.j(androidWebKitError.getCode(), androidWebKitError.getMessage(), androidWebKitError.getDetails());
        }
        return AbstractC0769p.j(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return AbstractC0768o.b(obj);
    }
}
