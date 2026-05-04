package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.os.Bundle;
import io.flutter.plugin.common.PluginRegistry;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface ActivityPluginBinding {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface OnSaveInstanceStateListener {
        void onRestoreInstanceState(Bundle bundle);

        void onSaveInstanceState(Bundle bundle);
    }

    void addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener);

    void addOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener);

    void addOnSaveStateListener(OnSaveInstanceStateListener onSaveInstanceStateListener);

    void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener);

    void addOnWindowFocusChangedListener(PluginRegistry.WindowFocusChangedListener windowFocusChangedListener);

    void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);

    Activity getActivity();

    Object getLifecycle();

    void removeActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener);

    void removeOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener);

    void removeOnSaveStateListener(OnSaveInstanceStateListener onSaveInstanceStateListener);

    void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener);

    void removeOnWindowFocusChangedListener(PluginRegistry.WindowFocusChangedListener windowFocusChangedListener);

    void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);
}
