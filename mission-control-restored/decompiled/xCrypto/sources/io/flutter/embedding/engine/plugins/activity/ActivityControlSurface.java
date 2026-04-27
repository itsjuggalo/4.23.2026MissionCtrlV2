package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import io.flutter.embedding.android.ExclusiveAppComponent;

/* JADX INFO: loaded from: classes3.dex */
public interface ActivityControlSurface {
    void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, AbstractC0846i abstractC0846i);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i4, int i5, Intent intent);

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr);

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void onUserLeaveHint();
}
