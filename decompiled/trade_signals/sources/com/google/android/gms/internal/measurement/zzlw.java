package com.google.android.gms.internal.measurement;

import D3.m;
import com.amazon.c.a.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzlw {
    private static final zzlw zzd = new zzlw(true);
    final zzoe zza = new zzoa();
    private boolean zzb;
    private boolean zzc;

    private zzlw() {
    }

    public static zzlw zza() {
        return zzd;
    }

    public static void zzf(zzlm zzlmVar, zzot zzotVar, int i8, Object obj) {
        if (zzotVar == zzot.zzj) {
            zznm zznmVar = (zznm) obj;
            zzmp.zzd(zznmVar);
            zzlmVar.zza(i8, 3);
            zznmVar.zzcB(zzlmVar);
            zzlmVar.zza(i8, 4);
            return;
        }
        zzlmVar.zza(i8, zzotVar.zzb());
        zzou zzouVar = zzou.INT;
        switch (zzotVar.ordinal()) {
            case 0:
                zzlmVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzlmVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzlmVar.zzt(((Long) obj).longValue());
                break;
            case 3:
                zzlmVar.zzt(((Long) obj).longValue());
                break;
            case 4:
                zzlmVar.zzq(((Integer) obj).intValue());
                break;
            case 5:
                zzlmVar.zzu(((Long) obj).longValue());
                break;
            case 6:
                zzlmVar.zzs(((Integer) obj).intValue());
                break;
            case 7:
                zzlmVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzlh)) {
                    zzlmVar.zzx((String) obj);
                } else {
                    zzlmVar.zzj((zzlh) obj);
                }
                break;
            case 9:
                ((zznm) obj).zzcB(zzlmVar);
                break;
            case 10:
                zzlmVar.zzo((zznm) obj);
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                if (!(obj instanceof zzlh)) {
                    byte[] bArr = (byte[]) obj;
                    zzlmVar.zzk(bArr, 0, bArr.length);
                } else {
                    zzlmVar.zzj((zzlh) obj);
                }
                break;
            case 12:
                zzlmVar.zzr(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zzmj)) {
                    zzlmVar.zzq(((Integer) obj).intValue());
                } else {
                    zzlmVar.zzq(((zzmj) obj).zza());
                }
                break;
            case 14:
                zzlmVar.zzs(((Integer) obj).intValue());
                break;
            case 15:
                zzlmVar.zzu(((Long) obj).longValue());
                break;
            case c.f14230g /* 16 */:
                int iIntValue = ((Integer) obj).intValue();
                zzlmVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzlmVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static int zzh(zzot zzotVar, int i8, Object obj) {
        int iZzz = zzlm.zzz(i8 << 3);
        if (zzotVar == zzot.zzj) {
            zzmp.zzd((zznm) obj);
            iZzz += iZzz;
        }
        return iZzz + zzi(zzotVar, obj);
    }

    public static int zzi(zzot zzotVar, Object obj) {
        int iZzb;
        zzot zzotVar2 = zzot.zza;
        zzou zzouVar = zzou.INT;
        switch (zzotVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i8 = zzlm.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i9 = zzlm.zzb;
                return 4;
            case 2:
                return zzlm.zzA(((Long) obj).longValue());
            case 3:
                return zzlm.zzA(((Long) obj).longValue());
            case 4:
                return zzlm.zzA(((Integer) obj).intValue());
            case 5:
            case 15:
                ((Long) obj).longValue();
                int i82 = zzlm.zzb;
                return 8;
            case 6:
            case 14:
                ((Integer) obj).intValue();
                int i92 = zzlm.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i10 = zzlm.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzlh)) {
                    return zzlm.zzB((String) obj);
                }
                int i11 = zzlm.zzb;
                iZzb = ((zzlh) obj).zzc();
                return zzlm.zzz(iZzb) + iZzb;
            case 9:
                return ((zznm) obj).zzcn();
            case 10:
                if (!(obj instanceof zzmv)) {
                    return zzlm.zzC((zznm) obj);
                }
                int i12 = zzlm.zzb;
                iZzb = ((zzmv) obj).zzb();
                return zzlm.zzz(iZzb) + iZzb;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                if (obj instanceof zzlh) {
                    int i112 = zzlm.zzb;
                    iZzb = ((zzlh) obj).zzc();
                } else {
                    int i13 = zzlm.zzb;
                    iZzb = ((byte[]) obj).length;
                }
                return zzlm.zzz(iZzb) + iZzb;
            case 12:
                return zzlm.zzz(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzmj ? zzlm.zzA(((zzmj) obj).zza()) : zzlm.zzA(((Integer) obj).intValue());
            case c.f14230g /* 16 */:
                int iIntValue = ((Integer) obj).intValue();
                return zzlm.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzlm.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzj(zzlv zzlvVar, Object obj) {
        zzot zzotVarZzb = zzlvVar.zzb();
        int iZza = zzlvVar.zza();
        if (!zzlvVar.zzd()) {
            return zzh(zzotVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i8 = 0;
        if (!zzlvVar.zze()) {
            int iZzh = 0;
            while (i8 < size) {
                iZzh += zzh(zzotVarZzb, iZza, list.get(i8));
                i8++;
            }
            return iZzh;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzi = 0;
        while (i8 < size) {
            iZzi += zzi(zzotVarZzb, list.get(i8));
            i8++;
        }
        return zzlm.zzz(iZza << 3) + iZzi + zzlm.zzz(iZzi);
    }

    private static boolean zzk(Map.Entry entry) {
        zzlv zzlvVar = (zzlv) entry.getKey();
        if (zzlvVar.zzc() != zzou.MESSAGE) {
            return true;
        }
        boolean zZzd = zzlvVar.zzd();
        Object value = entry.getValue();
        if (!zZzd) {
            return zzl(value);
        }
        List list = (List) value;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!zzl(list.get(i8))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zznn) {
            return ((zznn) obj).zzcD();
        }
        if (obj instanceof zzmv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i8;
        int iZzz;
        int iZzz2;
        zzlv zzlvVar = (zzlv) entry.getKey();
        Object value = entry.getValue();
        if (zzlvVar.zzc() != zzou.MESSAGE || zzlvVar.zzd() || zzlvVar.zze()) {
            return zzj(zzlvVar, value);
        }
        boolean z7 = value instanceof zzmv;
        int iZza = ((zzlv) entry.getKey()).zza();
        if (z7) {
            int iZzz3 = zzlm.zzz(8);
            i8 = iZzz3 + iZzz3;
            iZzz = zzlm.zzz(16) + zzlm.zzz(iZza);
            int iZzz4 = zzlm.zzz(24);
            int iZzb = ((zzmv) value).zzb();
            iZzz2 = iZzz4 + zzlm.zzz(iZzb) + iZzb;
        } else {
            int iZzz5 = zzlm.zzz(8);
            i8 = iZzz5 + iZzz5;
            iZzz = zzlm.zzz(16) + zzlm.zzz(iZza);
            iZzz2 = zzlm.zzz(24) + zzlm.zzC((zznm) value);
        }
        return i8 + iZzz + iZzz2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzn(com.google.android.gms.internal.measurement.zzlv r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzot r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.measurement.zzmp.zzb
            r3.getClass()
            com.google.android.gms.internal.measurement.zzot r1 = com.google.android.gms.internal.measurement.zzot.zza
            com.google.android.gms.internal.measurement.zzou r1 = com.google.android.gms.internal.measurement.zzou.INT
            com.google.android.gms.internal.measurement.zzou r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zznm
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzmv
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzmj
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzlh
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zzot r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzou r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlw.zzn(com.google.android.gms.internal.measurement.zzlv, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzlw zzlwVar = new zzlw();
        zzoe zzoeVar = this.zza;
        int iZzc = zzoeVar.zzc();
        for (int i8 = 0; i8 < iZzc; i8++) {
            Map.Entry entryZzd = zzoeVar.zzd(i8);
            zzlwVar.zzd((zzlv) ((zzob) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzoeVar.zze()) {
            zzlwVar.zzd((zzlv) entry.getKey(), entry.getValue());
        }
        zzlwVar.zzc = this.zzc;
        return zzlwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlw) {
            return this.zza.equals(((zzlw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzoe zzoeVar = this.zza;
        int iZzc = zzoeVar.zzc();
        for (int i8 = 0; i8 < iZzc; i8++) {
            Object value = zzoeVar.zzd(i8).getValue();
            if (value instanceof zzmf) {
                ((zzmf) value).zzcj();
            }
        }
        Iterator it = zzoeVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzmf) {
                ((zzmf) value2).zzcj();
            }
        }
        zzoeVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzoe zzoeVar = this.zza;
        return zzoeVar.isEmpty() ? Collections.emptyIterator() : this.zzc ? new zzmu(zzoeVar.entrySet().iterator()) : zzoeVar.entrySet().iterator();
    }

    public final void zzd(zzlv zzlvVar, Object obj) {
        if (!zzlvVar.zzd()) {
            zzn(zzlvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i8 = 0; i8 < size; i8++) {
                Object obj2 = list.get(i8);
                zzn(zzlvVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzmv) {
            this.zzc = true;
        }
        this.zza.put(zzlvVar, obj);
    }

    public final boolean zze() {
        zzoe zzoeVar = this.zza;
        int iZzc = zzoeVar.zzc();
        for (int i8 = 0; i8 < iZzc; i8++) {
            if (!zzk(zzoeVar.zzd(i8))) {
                return false;
            }
        }
        Iterator it = zzoeVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzoe zzoeVar = this.zza;
        int iZzc = zzoeVar.zzc();
        int iZzm = 0;
        for (int i8 = 0; i8 < iZzc; i8++) {
            iZzm += zzm(zzoeVar.zzd(i8));
        }
        Iterator it = zzoeVar.zze().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    private zzlw(boolean z7) {
        zzb();
        zzb();
    }
}
