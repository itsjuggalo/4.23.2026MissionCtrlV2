package com.google.android.gms.measurement.internal;

import Q1.AbstractC0801m;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class zzhu {
    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(AbstractC0801m.f6706a);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static final String zzb(String str, Resources resources, String str2) {
        int identifier = resources.getIdentifier("google_app_id", "string", str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final Boolean zzc(String str, Resources resources, String str2) {
        int identifier = resources.getIdentifier("google_analytics_force_disable_updates", "bool", str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return Boolean.valueOf(resources.getBoolean(identifier));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
