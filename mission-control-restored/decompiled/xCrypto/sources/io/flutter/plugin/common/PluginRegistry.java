package io.flutter.plugin.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface PluginRegistry {

    public interface ActivityResultListener {
        boolean onActivityResult(int i4, int i5, Intent intent);
    }

    public interface NewIntentListener {
        boolean onNewIntent(Intent intent);
    }

    public interface RequestPermissionsResultListener {
        boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr);
    }

    public interface UserLeaveHintListener {
        void onUserLeaveHint();
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(boolean z4);
    }
}
