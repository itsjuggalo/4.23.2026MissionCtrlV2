package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzkd extends zzkl {
    public zzkd(zzkf zzkfVar, String str, Double d4, boolean z4) {
        super(zzkfVar, "measurement.test.double_flag", d4, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String string = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 27 + string.length());
        sb.append("Invalid double value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(string);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
