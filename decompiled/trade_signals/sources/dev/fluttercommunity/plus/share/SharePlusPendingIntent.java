package dev.fluttercommunity.plus.share;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class SharePlusPendingIntent extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17083a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f17084b = "";

    public static final class a {
        public a() {
        }

        public final String a() {
            return SharePlusPendingIntent.f17084b;
        }

        public final void b(String str) {
            AbstractC2304t.f(str, "<set-?>");
            SharePlusPendingIntent.f17084b = str;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(intent, "intent");
        ComponentName componentName = (ComponentName) (Build.VERSION.SDK_INT >= 33 ? intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class) : intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT"));
        if (componentName != null) {
            f17084b = componentName.flattenToString();
        }
    }
}
