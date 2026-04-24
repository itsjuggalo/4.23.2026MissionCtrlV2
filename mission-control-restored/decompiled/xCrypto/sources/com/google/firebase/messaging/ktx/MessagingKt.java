package com.google.firebase.messaging.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        r.e(firebaseMessaging, "getInstance()");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String to, k init) {
        r.f(to, "to");
        r.f(init, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        init.invoke(builder);
        RemoteMessage remoteMessageBuild = builder.build();
        r.e(remoteMessageBuild, "builder.build()");
        return remoteMessageBuild;
    }
}
