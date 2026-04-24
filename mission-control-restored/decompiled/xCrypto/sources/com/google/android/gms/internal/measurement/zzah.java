package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzah implements zzao {
    private final Double zza;

    public zzah(Double d4) {
        if (d4 == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d4;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzah) {
            return this.zza.equals(((zzah) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        Double d4 = this.zza;
        if (Double.isNaN(d4.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d4.doubleValue())) {
            return d4.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalA = a.a(BigDecimal.valueOf(d4.doubleValue()));
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimalA.scale() > 0 ? bigDecimalA.precision() : bigDecimalA.scale()) - 1);
        String str = decimalFormat.format(bigDecimalA);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i4 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i4 >= 0 || i4 <= -7) && (i4 < 0 || i4 >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimalA.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        if ("toString".equals(str)) {
            return new zzas(zzc());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", zzc(), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        Double d4 = this.zza;
        boolean z4 = false;
        if (!Double.isNaN(d4.doubleValue()) && d4.doubleValue() != 0.0d) {
            z4 = true;
        }
        return Boolean.valueOf(z4);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzah(this.zza);
    }
}
