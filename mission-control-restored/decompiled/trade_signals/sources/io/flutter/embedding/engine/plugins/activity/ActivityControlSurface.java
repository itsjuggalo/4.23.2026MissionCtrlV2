package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import io.flutter.embedding.android.ExclusiveAppComponent;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityControlSurface {
    void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, AbstractC1157i abstractC1157i);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i8, int i9, Intent intent);

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i8, String[] strArr, int[] iArr);

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void onUserLeaveHint();
}
