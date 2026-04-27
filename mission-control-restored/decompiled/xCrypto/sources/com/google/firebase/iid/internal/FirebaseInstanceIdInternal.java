package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface FirebaseInstanceIdInternal {

    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(String str, String str2);

    String getId();

    String getToken();

    Task<String> getTokenTask();
}
