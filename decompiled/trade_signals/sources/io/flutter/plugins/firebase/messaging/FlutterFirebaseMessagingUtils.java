package io.flutter.plugins.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.V;
import io.flutter.plugins.firebase.database.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class FlutterFirebaseMessagingUtils {
    static final String EXTRA_REMOTE_MESSAGE = "notification";
    static final String IS_AUTO_INIT_ENABLED = "isAutoInitEnabled";
    static final int JOB_ID = 2020;
    private static final String KEY_COLLAPSE_KEY = "collapseKey";
    private static final String KEY_DATA = "data";
    private static final String KEY_FROM = "from";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_SENT_TIME = "sentTime";
    private static final String KEY_TO = "to";
    private static final String KEY_TTL = "ttl";
    static final String SHARED_PREFERENCES_KEY = "io.flutter.firebase.messaging.callback";

    public static FirebaseMessaging getFirebaseMessagingForArguments(Map<String, Object> map) {
        return FirebaseMessaging.r();
    }

    public static V getRemoteMessageForArguments(Map<String, Object> map) {
        Object obj = map.get(Constants.ERROR_MESSAGE);
        Objects.requireNonNull(obj);
        Map map2 = (Map) obj;
        Object obj2 = map2.get(KEY_TO);
        Objects.requireNonNull(obj2);
        V.b bVar = new V.b((String) obj2);
        String str = (String) map2.get(KEY_COLLAPSE_KEY);
        String str2 = (String) map2.get(KEY_MESSAGE_ID);
        String str3 = (String) map2.get(KEY_MESSAGE_TYPE);
        Integer num = (Integer) map2.get(KEY_TTL);
        Map map3 = (Map) map2.get(KEY_DATA);
        if (str != null) {
            bVar.b(str);
        }
        if (str3 != null) {
            bVar.e(str3);
        }
        if (str2 != null) {
            bVar.d(str2);
        }
        if (num != null) {
            bVar.f(num.intValue());
        }
        if (map3 != null) {
            bVar.c(map3);
        }
        return bVar.a();
    }

    public static Map<String, Object> getRemoteMessageNotificationForArguments(Map<String, Object> map) {
        Object obj = map.get(Constants.ERROR_MESSAGE);
        Objects.requireNonNull(obj);
        Map map2 = (Map) obj;
        if (map2.get(EXTRA_REMOTE_MESSAGE) == null) {
            return null;
        }
        return (Map) map2.get(EXTRA_REMOTE_MESSAGE);
    }

    public static boolean isApplicationForeground(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if ((keyguardManager != null && keyguardManager.isKeyguardLocked()) || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Object> remoteMessageNotificationToMap(V.c cVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (cVar.p() != null) {
            map.put(com.amazon.a.a.o.b.f14041S, cVar.p());
        }
        if (cVar.r() != null) {
            map.put("titleLocKey", cVar.r());
        }
        if (cVar.q() != null) {
            map.put("titleLocArgs", Arrays.asList(cVar.q()));
        }
        if (cVar.a() != null) {
            map.put("body", cVar.a());
        }
        if (cVar.c() != null) {
            map.put("bodyLocKey", cVar.c());
        }
        if (cVar.b() != null) {
            map.put("bodyLocArgs", Arrays.asList(cVar.b()));
        }
        if (cVar.d() != null) {
            map2.put("channelId", cVar.d());
        }
        if (cVar.e() != null) {
            map2.put("clickAction", cVar.e());
        }
        if (cVar.f() != null) {
            map2.put("color", cVar.f());
        }
        if (cVar.g() != null) {
            map2.put("smallIcon", cVar.g());
        }
        if (cVar.h() != null) {
            map2.put("imageUrl", cVar.h().toString());
        }
        if (cVar.i() != null) {
            map2.put("link", cVar.i().toString());
        }
        if (cVar.k() != null) {
            map2.put("count", cVar.k());
        }
        if (cVar.l() != null) {
            map2.put(Constants.PRIORITY, cVar.l());
        }
        if (cVar.m() != null) {
            map2.put("sound", cVar.m());
        }
        if (cVar.o() != null) {
            map2.put("ticker", cVar.o());
        }
        if (cVar.s() != null) {
            map2.put("visibility", cVar.s());
        }
        if (cVar.n() != null) {
            map2.put("tag", cVar.n());
        }
        map.put("android", map2);
        return map;
    }

    public static Map<String, Object> remoteMessageToMap(V v8) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (v8.a() != null) {
            map.put(KEY_COLLAPSE_KEY, v8.a());
        }
        if (v8.e() != null) {
            map.put(KEY_FROM, v8.e());
        }
        if (v8.I() != null) {
            map.put(KEY_TO, v8.I());
        }
        if (v8.f() != null) {
            map.put(KEY_MESSAGE_ID, v8.f());
        }
        if (v8.n() != null) {
            map.put(KEY_MESSAGE_TYPE, v8.n());
        }
        if (!v8.d().isEmpty()) {
            for (Map.Entry entry : v8.d().entrySet()) {
                map2.put((String) entry.getKey(), entry.getValue());
            }
        }
        map.put(KEY_DATA, map2);
        map.put(KEY_TTL, Integer.valueOf(v8.J()));
        map.put(KEY_SENT_TIME, Long.valueOf(v8.H()));
        if (v8.C() != null) {
            map.put(EXTRA_REMOTE_MESSAGE, remoteMessageNotificationToMap(v8.C()));
        }
        return map;
    }
}
