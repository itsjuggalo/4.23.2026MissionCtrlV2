package com.google.firebase.messaging;

import P1.C0757a;
import P1.C0759c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessagingService extends AbstractServiceC1438i {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    static final String ACTION_NEW_TOKEN = "com.google.firebase.messaging.NEW_TOKEN";
    static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    static final String EXTRA_TOKEN = "token";
    private static final int RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE = 10;
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);
    private C0759c rpc;

    public static void resetForTesting() {
        recentlyReceivedMessageIds.clear();
    }

    public final boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        Log.d("FirebaseMessaging", "Received duplicate message: " + str);
        return true;
    }

    @Override // com.google.firebase.messaging.AbstractServiceC1438i
    public Intent getStartCommandIntent(Intent intent) {
        return a0.b().c();
    }

    public final void h(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (M.t(extras)) {
            M m8 = new M(extras);
            ExecutorService executorServiceE = AbstractC1444o.e();
            try {
                if (new C1435f(this, m8, executorServiceE).a()) {
                    return;
                }
                if (K.E(intent)) {
                    K.w(intent);
                }
            } finally {
                executorServiceE.shutdown();
            }
        }
        onMessageReceived(new V(extras));
    }

    @Override // com.google.firebase.messaging.AbstractServiceC1438i
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (ACTION_REMOTE_INTENT.equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            k(intent);
            return;
        }
        if (ACTION_NEW_TOKEN.equals(action)) {
            onNewToken(intent.getStringExtra("token"));
            return;
        }
        Log.d("FirebaseMessaging", "Unknown intent action: " + intent.getAction());
    }

    public final String i(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    public final C0759c j(Context context) {
        if (this.rpc == null) {
            this.rpc = new C0759c(context.getApplicationContext());
        }
        return this.rpc;
    }

    public final void k(Intent intent) {
        if (!g(intent.getStringExtra("google.message_id"))) {
            l(intent);
        }
        j(this).b(new C0757a(intent));
    }

    public final void l(Intent intent) {
        String stringExtra;
        stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "deleted_messages":
                onDeletedMessages();
                break;
            case "gcm":
                K.y(intent);
                h(intent);
                break;
            case "send_error":
                onSendError(i(intent), new Z(intent.getStringExtra("error")));
                break;
            case "send_event":
                onMessageSent(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                break;
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(V v8) {
    }

    @Deprecated
    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    @Deprecated
    public void onSendError(String str, Exception exc) {
    }

    public void setRpcForTesting(C0759c c0759c) {
        this.rpc = c0759c;
    }
}
