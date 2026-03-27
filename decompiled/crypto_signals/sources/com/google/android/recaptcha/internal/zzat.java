package com.google.android.recaptcha.internal;

import H4.t;
import R4.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
final class zzat extends k implements a {
    public static final zzat zza = new zzat();

    public zzat() {
        super(0);
    }

    public static final Map zza() {
        Map map = zzav.zzc;
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.P(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((zzaw) entry.getValue()).zzb());
        }
        return linkedHashMap;
    }

    @Override // R4.a
    public final /* bridge */ /* synthetic */ Object invoke() {
        return zza();
    }
}
