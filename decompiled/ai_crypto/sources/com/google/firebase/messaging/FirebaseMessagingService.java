package com.google.firebase.messaging;

import O1.C0639a;
import O1.C0641c;
import U3.AbstractC0701n;
import U3.AbstractServiceC0695h;
import U3.C0692e;
import U3.U;
import U3.V;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessagingService extends AbstractServiceC0695h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Queue f12215g = new ArrayDeque(10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0641c f12216f;

    @Override // U3.AbstractServiceC0695h
    public Intent e(Intent intent) {
        return V.b().c();
    }

    @Override // U3.AbstractServiceC0695h
    public void f(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            p(intent);
            return;
        }
        if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            t(intent.getStringExtra("token"));
            return;
        }
        Log.d("FirebaseMessaging", "Unknown intent action: " + intent.getAction());
    }

    public final boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue queue = f12215g;
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

    public final void m(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (c.t(extras)) {
            c cVar = new c(extras);
            ExecutorService executorServiceE = AbstractC0701n.e();
            try {
                if (new C0692e(this, cVar, executorServiceE).a()) {
                    return;
                }
                executorServiceE.shutdown();
                if (b.E(intent)) {
                    b.w(intent);
                }
            } finally {
                executorServiceE.shutdown();
            }
        }
        r(new d(extras));
    }

    public final String n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    public final C0641c o(Context context) {
        if (this.f12216f == null) {
            this.f12216f = new C0641c(context.getApplicationContext());
        }
        return this.f12216f;
    }

    public final void p(Intent intent) {
        if (!l(intent.getStringExtra("google.message_id"))) {
            v(intent);
        }
        o(this).b(new C0639a(intent));
    }

    public void q() {
    }

    public void r(d dVar) {
    }

    public void s(String str) {
    }

    public void t(String str) {
    }

    public void u(String str, Exception exc) {
    }

    public final void v(Intent intent) {
        String stringExtra;
        stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "deleted_messages":
                q();
                break;
            case "gcm":
                b.y(intent);
                m(intent);
                break;
            case "send_error":
                u(n(intent), new U(intent.getStringExtra("error")));
                break;
            case "send_event":
                s(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                break;
        }
    }
}
