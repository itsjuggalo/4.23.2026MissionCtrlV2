package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import w.AbstractC1897a;

/* JADX INFO: loaded from: classes3.dex */
class FlutterFirebasePermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private final int permissionCode = 240;
    private boolean requestInProgress = false;
    private RequestPermissionsSuccessCallback successCallback;

    @FunctionalInterface
    public interface RequestPermissionsSuccessCallback {
        void onSuccess(int i4);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback;
        int i5 = 0;
        if (!this.requestInProgress || i4 != 240 || (requestPermissionsSuccessCallback = this.successCallback) == null) {
            return false;
        }
        this.requestInProgress = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            i5 = 1;
        }
        requestPermissionsSuccessCallback.onSuccess(i5);
        return true;
    }

    public void requestPermissions(Activity activity, RequestPermissionsSuccessCallback requestPermissionsSuccessCallback, ErrorCallback errorCallback) {
        if (this.requestInProgress) {
            errorCallback.onError("A request for permissions is already running, please wait for it to finish before doing another request.");
            return;
        }
        if (activity == null) {
            errorCallback.onError("Unable to detect current Android Activity.");
            return;
        }
        this.successCallback = requestPermissionsSuccessCallback;
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.POST_NOTIFICATIONS");
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (this.requestInProgress) {
            return;
        }
        AbstractC1897a.c(activity, strArr, 240);
        this.requestInProgress = true;
    }
}
