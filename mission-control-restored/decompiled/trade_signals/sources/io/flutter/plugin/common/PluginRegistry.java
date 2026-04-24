package io.flutter.plugin.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface PluginRegistry {

    public interface ActivityResultListener {
        boolean onActivityResult(int i8, int i9, Intent intent);
    }

    public interface NewIntentListener {
        boolean onNewIntent(Intent intent);
    }

    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i8, String[] strArr, int[] iArr);
    }

    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(boolean z7);
    }
}
