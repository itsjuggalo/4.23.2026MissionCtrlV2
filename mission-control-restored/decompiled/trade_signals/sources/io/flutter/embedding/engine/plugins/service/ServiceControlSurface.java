package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.AbstractC1157i;

/* JADX INFO: loaded from: classes.dex */
public interface ServiceControlSurface {
    void attachToService(Service service, AbstractC1157i abstractC1157i, boolean z7);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
