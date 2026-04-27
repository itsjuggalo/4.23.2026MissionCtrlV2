package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class FlutterFirebasePermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private final int permissionCode = 240;
    private boolean requestInProgress = false;
    private RequestPermissionsSuccessCallback successCallback;

    @FunctionalInterface
    public interface RequestPermissionsSuccessCallback {
        void onSuccess(int i8);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i8, String[] strArr, int[] iArr) {
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback;
        int i9 = 0;
        if (!this.requestInProgress || i8 != 240 || (requestPermissionsSuccessCallback = this.successCallback) == null) {
            return false;
        }
        this.requestInProgress = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            i9 = 1;
        }
        requestPermissionsSuccessCallback.onSuccess(i9);
        return true;
    }

    public void requestPermissions(Activity activity, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        String str;
        if (this.requestInProgress) {
            str = "A request for permissions is already running, please wait for it to finish before doing another request.";
        } else {
            if (activity != null) {
                this.successCallback = requestPermissionsSuccessCallback;
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.POST_NOTIFICATIONS");
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (this.requestInProgress) {
                    return;
                }
                H.a.q(activity, strArr, 240);
                this.requestInProgress = true;
                return;
            }
            str = "Unable to detect current Android Activity.";
        }
        errorCallback.onError(str);
    }
}
