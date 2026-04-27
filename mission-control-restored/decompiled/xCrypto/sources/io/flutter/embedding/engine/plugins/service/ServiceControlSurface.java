package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes3.dex */
public interface ServiceControlSurface {
    void attachToService(Service service, AbstractC0846i abstractC0846i, boolean z4);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
