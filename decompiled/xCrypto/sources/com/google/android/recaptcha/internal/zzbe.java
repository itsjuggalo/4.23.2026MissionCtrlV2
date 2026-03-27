package com.google.android.recaptcha.internal;

import W2.t;
import X2.L;
import X2.Q;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.r;

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
            r.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
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
            return Q.b();
        }
    }

    private static final Map zzb() {
        Map mapI = L.i(t.a(0, zzqi.NET_CAPABILITY_MMS), t.a(1, zzqi.NET_CAPABILITY_SUPL), t.a(2, zzqi.NET_CAPABILITY_DUN), t.a(3, zzqi.NET_CAPABILITY_FOTA), t.a(4, zzqi.NET_CAPABILITY_IMS), t.a(5, zzqi.NET_CAPABILITY_CBS), t.a(6, zzqi.NET_CAPABILITY_WIFI_P2P), t.a(7, zzqi.NET_CAPABILITY_IA), t.a(8, zzqi.NET_CAPABILITY_RCS), t.a(9, zzqi.NET_CAPABILITY_XCAP), t.a(10, zzqi.NET_CAPABILITY_EIMS), t.a(11, zzqi.NET_CAPABILITY_NOT_METERED), t.a(12, zzqi.NET_CAPABILITY_INTERNET), t.a(13, zzqi.NET_CAPABILITY_NOT_RESTRICTED), t.a(14, zzqi.NET_CAPABILITY_TRUSTED), t.a(15, zzqi.NET_CAPABILITY_NOT_VPN));
        int i4 = Build.VERSION.SDK_INT;
        mapI.put(17, zzqi.NET_CAPABILITY_CAPTIVE_PORTAL);
        mapI.put(16, zzqi.NET_CAPABILITY_VALIDATED);
        if (i4 >= 28) {
            mapI.put(18, zzqi.NET_CAPABILITY_NOT_ROAMING);
            mapI.put(19, zzqi.NET_CAPABILITY_FOREGROUND);
            mapI.put(20, zzqi.NET_CAPABILITY_NOT_CONGESTED);
            mapI.put(21, zzqi.NET_CAPABILITY_NOT_SUSPENDED);
        }
        if (i4 >= 29) {
            mapI.put(23, zzqi.NET_CAPABILITY_MCX);
        }
        if (i4 >= 30) {
            mapI.put(25, zzqi.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (i4 >= 31) {
            mapI.put(32, zzqi.NET_CAPABILITY_HEAD_UNIT);
            mapI.put(29, zzqi.NET_CAPABILITY_ENTERPRISE);
        }
        if (i4 >= 33) {
            mapI.put(35, zzqi.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            mapI.put(34, zzqi.NET_CAPABILITY_PRIORITIZE_LATENCY);
            mapI.put(33, zzqi.NET_CAPABILITY_MMTEL);
        }
        return mapI;
    }
}
