package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.lifecycle.AbstractC0846i;

/* JADX INFO: loaded from: classes3.dex */
public interface BroadcastReceiverControlSurface {
    void attachToBroadcastReceiver(BroadcastReceiver broadcastReceiver, AbstractC0846i abstractC0846i);

    void detachFromBroadcastReceiver();
}
