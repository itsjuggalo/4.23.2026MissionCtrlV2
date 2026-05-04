package com.amazon.device.simplesignin;

import android.content.Context;
import android.util.Log;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.request.SSIEventRequest;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleSignInService {
    public static final String SDK_VERSION = "1.0.0";
    private static final String TAG = "SimpleSignInService";

    static {
        Log.i(SimpleSignInService.class.getSimpleName(), "Amazon Simple Sign-In SDK initializing. SDK version : 1.0.0");
    }

    public static String getSDKMode() {
        return c.a().b();
    }

    public static RequestId getUserAndLinks(@NonNull String str) {
        if (str != null) {
            return c.a().a(str);
        }
        throw new NullPointerException("identityProviderName is marked non-null but is null");
    }

    public static RequestId linkUserAccount(@NonNull LinkUserAccountRequest linkUserAccountRequest) {
        if (linkUserAccountRequest != null) {
            return c.a().a(linkUserAccountRequest);
        }
        throw new NullPointerException("linkUserAccountRequest is marked non-null but is null");
    }

    public static RequestId recordMetricEvent(@NonNull SSIEventRequest sSIEventRequest) {
        if (sSIEventRequest != null) {
            return c.a().a(sSIEventRequest);
        }
        throw new NullPointerException("ssiEventRequest is marked non-null but is null");
    }

    public static void registerResponseHandler(@NonNull Context context, @NonNull ISimpleSignInResponseHandler iSimpleSignInResponseHandler) {
        if (context == null) {
            throw new NullPointerException("appContext is marked non-null but is null");
        }
        if (iSimpleSignInResponseHandler == null) {
            throw new NullPointerException("responseHandler is marked non-null but is null");
        }
        c.a().a(context, iSimpleSignInResponseHandler);
    }

    public static RequestId showLoginSelection(@NonNull Map<String, String> map) {
        if (map != null) {
            return c.a().a(map);
        }
        throw new NullPointerException("loginNames is marked non-null but is null");
    }
}
