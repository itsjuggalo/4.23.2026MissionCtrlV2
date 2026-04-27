package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;

/* JADX INFO: loaded from: classes.dex */
public interface SessionLifecycleServiceBinder {
    void bindToService(Messenger messenger, ServiceConnection serviceConnection);
}
