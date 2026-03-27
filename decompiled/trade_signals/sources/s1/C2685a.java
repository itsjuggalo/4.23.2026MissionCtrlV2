package s1;

import android.content.Context;
import android.content.SharedPreferences;
import io.flutter.view.FlutterCallbackInformation;

/* JADX INFO: renamed from: s1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2685a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23065a = "com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23066b = "com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f23067c;

    public C2685a(Context context) {
        this.f23067c = context;
    }

    public final SharedPreferences a() {
        return this.f23067c.getSharedPreferences("flutter_local_notifications_plugin", 0);
    }

    public Long b() {
        return Long.valueOf(a().getLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", -1L));
    }

    public Long c() {
        return Long.valueOf(a().getLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", -1L));
    }

    public FlutterCallbackInformation d() {
        return FlutterCallbackInformation.lookupCallbackInformation(b().longValue());
    }

    public void e(Long l8, Long l9) {
        a().edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", l8.longValue()).apply();
        a().edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", l9.longValue()).apply();
    }
}
