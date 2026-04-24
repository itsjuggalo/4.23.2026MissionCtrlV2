package com.google.firebase.messaging;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;
import w.C2882a;

/* JADX INFO: renamed from: com.google.firebase.messaging.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1434e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f15715a = TimeUnit.MINUTES.toMillis(3);

    /* JADX INFO: renamed from: com.google.firebase.messaging.e$a */
    public static final class a {
        public static C2882a a(Bundle bundle) {
            C2882a c2882a = new C2882a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        c2882a.put(str, str2);
                    }
                }
            }
            return c2882a;
        }
    }
}
