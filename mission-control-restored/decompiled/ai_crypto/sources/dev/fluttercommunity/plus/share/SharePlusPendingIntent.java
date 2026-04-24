package dev.fluttercommunity.plus.share;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class SharePlusPendingIntent extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13504a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f13505b = "";

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final String a() {
            return SharePlusPendingIntent.f13505b;
        }

        public final void b(String str) {
            r.f(str, "<set-?>");
            SharePlusPendingIntent.f13505b = str;
        }

        public a() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        r.f(context, "context");
        r.f(intent, "intent");
        ComponentName componentName = Build.VERSION.SDK_INT >= 33 ? (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class) : (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
        if (componentName != null) {
            f13505b = componentName.flattenToString();
        }
    }
}
