package com.google.android.recaptcha.internal;

import G4.f;
import H4.r;
import H4.t;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe {
    public zzbe() {
        new ConcurrentHashMap();
        zzb();
    }

    public static final Set zza(Context context) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object systemService = context.getSystemService("connectivity");
            j.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                linkedHashSet.add(zzqi.TRANSPORT_WIFI);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                linkedHashSet.add(zzqi.TRANSPORT_CELLULAR);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                linkedHashSet.add(zzqi.TRANSPORT_VPN);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                linkedHashSet.add(zzqi.TRANSPORT_ETHERNET);
            }
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                linkedHashSet.add(zzqi.NET_CAPABILITY_VALIDATED);
            }
            return linkedHashSet;
        } catch (Exception unused) {
            return r.f579a;
        }
    }

    private static final Map zzb() {
        LinkedHashMap linkedHashMapS = t.S(new f(0, zzqi.NET_CAPABILITY_MMS), new f(1, zzqi.NET_CAPABILITY_SUPL), new f(2, zzqi.NET_CAPABILITY_DUN), new f(3, zzqi.NET_CAPABILITY_FOTA), new f(4, zzqi.NET_CAPABILITY_IMS), new f(5, zzqi.NET_CAPABILITY_CBS), new f(6, zzqi.NET_CAPABILITY_WIFI_P2P), new f(7, zzqi.NET_CAPABILITY_IA), new f(8, zzqi.NET_CAPABILITY_RCS), new f(9, zzqi.NET_CAPABILITY_XCAP), new f(10, zzqi.NET_CAPABILITY_EIMS), new f(11, zzqi.NET_CAPABILITY_NOT_METERED), new f(12, zzqi.NET_CAPABILITY_INTERNET), new f(13, zzqi.NET_CAPABILITY_NOT_RESTRICTED), new f(14, zzqi.NET_CAPABILITY_TRUSTED), new f(15, zzqi.NET_CAPABILITY_NOT_VPN));
        int i = Build.VERSION.SDK_INT;
        linkedHashMapS.put(17, zzqi.NET_CAPABILITY_CAPTIVE_PORTAL);
        linkedHashMapS.put(16, zzqi.NET_CAPABILITY_VALIDATED);
        if (i >= 28) {
            linkedHashMapS.put(18, zzqi.NET_CAPABILITY_NOT_ROAMING);
            linkedHashMapS.put(19, zzqi.NET_CAPABILITY_FOREGROUND);
            linkedHashMapS.put(20, zzqi.NET_CAPABILITY_NOT_CONGESTED);
            linkedHashMapS.put(21, zzqi.NET_CAPABILITY_NOT_SUSPENDED);
        }
        if (i >= 29) {
            linkedHashMapS.put(23, zzqi.NET_CAPABILITY_MCX);
        }
        if (i >= 30) {
            linkedHashMapS.put(25, zzqi.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (i >= 31) {
            linkedHashMapS.put(32, zzqi.NET_CAPABILITY_HEAD_UNIT);
            linkedHashMapS.put(29, zzqi.NET_CAPABILITY_ENTERPRISE);
        }
        if (i >= 33) {
            linkedHashMapS.put(35, zzqi.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            linkedHashMapS.put(34, zzqi.NET_CAPABILITY_PRIORITIZE_LATENCY);
            linkedHashMapS.put(33, zzqi.NET_CAPABILITY_MMTEL);
        }
        return linkedHashMapS;
    }
}
