package com.google.android.gms.internal.measurement;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
final class zzlv {
    private static final zzlv zzd = new zzlv(true);
    final zzod zza = new zznz();
    private boolean zzb;
    private boolean zzc;

    private zzlv() {
    }

    public static zzlv zza() {
        return zzd;
    }

    public static void zzf(zzll zzllVar, zzos zzosVar, int i4, Object obj) {
        if (zzosVar == zzos.zzj) {
            zznl zznlVar = (zznl) obj;
            zzmo.zzd(zznlVar);
            zzllVar.zza(i4, 3);
            zznlVar.zzcB(zzllVar);
            zzllVar.zza(i4, 4);
            return;
        }
        zzllVar.zza(i4, zzosVar.zzb());
        zzot zzotVar = zzot.INT;
        switch (zzosVar.ordinal()) {
            case 0:
                zzllVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzllVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzllVar.zzt(((Long) obj).longValue());
                break;
            case 3:
                zzllVar.zzt(((Long) obj).longValue());
                break;
            case 4:
                zzllVar.zzq(((Integer) obj).intValue());
                break;
            case 5:
                zzllVar.zzu(((Long) obj).longValue());
                break;
            case 6:
                zzllVar.zzs(((Integer) obj).intValue());
                break;
            case 7:
                zzllVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzlg)) {
                    zzllVar.zzx((String) obj);
                } else {
                    zzllVar.zzj((zzlg) obj);
                }
                break;
            case 9:
                ((zznl) obj).zzcB(zzllVar);
                break;
            case 10:
                zzllVar.zzo((zznl) obj);
                break;
            case 11:
                if (!(obj instanceof zzlg)) {
                    byte[] bArr = (byte[]) obj;
                    zzllVar.zzk(bArr, 0, bArr.length);
                } else {
                    zzllVar.zzj((zzlg) obj);
                }
                break;
            case 12:
                zzllVar.zzr(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zzmi)) {
                    zzllVar.zzq(((Integer) obj).intValue());
                } else {
                    zzllVar.zzq(((zzmi) obj).zza());
                }
                break;
            case 14:
                zzllVar.zzs(((Integer) obj).intValue());
                break;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                zzllVar.zzu(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzllVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                long jLongValue = ((Long) obj).longValue();
                zzllVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static int zzh(zzos zzosVar, int i4, Object obj) {
        int iZzz = zzll.zzz(i4 << 3);
        if (zzosVar == zzos.zzj) {
            zzmo.zzd((zznl) obj);
            iZzz += iZzz;
        }
        return iZzz + zzi(zzosVar, obj);
    }

    public static int zzi(zzos zzosVar, Object obj) {
        int iZzc;
        int iZzz;
        zzos zzosVar2 = zzos.zza;
        zzot zzotVar = zzot.INT;
        switch (zzosVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i4 = zzll.zzb;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i5 = zzll.zzb;
                return 4;
            case 2:
                return zzll.zzA(((Long) obj).longValue());
            case 3:
                return zzll.zzA(((Long) obj).longValue());
            case 4:
                return zzll.zzA(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i6 = zzll.zzb;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i7 = zzll.zzb;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i8 = zzll.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzlg)) {
                    return zzll.zzB((String) obj);
                }
                int i9 = zzll.zzb;
                iZzc = ((zzlg) obj).zzc();
                iZzz = zzll.zzz(iZzc);
                break;
                break;
            case 9:
                return ((zznl) obj).zzcn();
            case 10:
                if (!(obj instanceof zzmu)) {
                    return zzll.zzC((zznl) obj);
                }
                int i10 = zzll.zzb;
                iZzc = ((zzmu) obj).zzb();
                iZzz = zzll.zzz(iZzc);
                break;
                break;
            case 11:
                if (!(obj instanceof zzlg)) {
                    int i11 = zzll.zzb;
                    iZzc = ((byte[]) obj).length;
                    iZzz = zzll.zzz(iZzc);
                } else {
                    int i12 = zzll.zzb;
                    iZzc = ((zzlg) obj).zzc();
                    iZzz = zzll.zzz(iZzc);
                }
                break;
            case 12:
                return zzll.zzz(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzmi ? zzll.zzA(((zzmi) obj).zza()) : zzll.zzA(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i13 = zzll.zzb;
                return 4;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                ((Long) obj).getClass();
                int i14 = zzll.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzll.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                long jLongValue = ((Long) obj).longValue();
                return zzll.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzz + iZzc;
    }

    public static int zzj(zzlu zzluVar, Object obj) {
        zzos zzosVarZzb = zzluVar.zzb();
        int iZza = zzluVar.zza();
        if (!zzluVar.zzd()) {
            return zzh(zzosVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i4 = 0;
        if (!zzluVar.zze()) {
            int iZzh = 0;
            while (i4 < size) {
                iZzh += zzh(zzosVarZzb, iZza, list.get(i4));
                i4++;
            }
            return iZzh;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzi = 0;
        while (i4 < size) {
            iZzi += zzi(zzosVarZzb, list.get(i4));
            i4++;
        }
        return zzll.zzz(iZza << 3) + iZzi + zzll.zzz(iZzi);
    }

    private static boolean zzk(Map.Entry entry) {
        zzlu zzluVar = (zzlu) entry.getKey();
        if (zzluVar.zzc() != zzot.MESSAGE) {
            return true;
        }
        if (!zzluVar.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!zzl(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zznm) {
            return ((zznm) obj).zzcD();
        }
        if (obj instanceof zzmu) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i4;
        int iZzz;
        int iZzz2;
        zzlu zzluVar = (zzlu) entry.getKey();
        Object value = entry.getValue();
        if (zzluVar.zzc() != zzot.MESSAGE || zzluVar.zzd() || zzluVar.zze()) {
            return zzj(zzluVar, value);
        }
        if (value instanceof zzmu) {
            int iZza = ((zzlu) entry.getKey()).zza();
            int iZzz3 = zzll.zzz(8);
            i4 = iZzz3 + iZzz3;
            iZzz = zzll.zzz(16) + zzll.zzz(iZza);
            int iZzz4 = zzll.zzz(24);
            int iZzb = ((zzmu) value).zzb();
            iZzz2 = iZzz4 + zzll.zzz(iZzb) + iZzb;
        } else {
            int iZza2 = ((zzlu) entry.getKey()).zza();
            int iZzz5 = zzll.zzz(8);
            i4 = iZzz5 + iZzz5;
            iZzz = zzll.zzz(16) + zzll.zzz(iZza2);
            iZzz2 = zzll.zzz(24) + zzll.zzC((zznl) value);
        }
        return i4 + iZzz + iZzz2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzn(com.google.android.gms.internal.measurement.zzlu r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzos r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.measurement.zzmo.zzb
            r3.getClass()
            com.google.android.gms.internal.measurement.zzos r1 = com.google.android.gms.internal.measurement.zzos.zza
            com.google.android.gms.internal.measurement.zzot r1 = com.google.android.gms.internal.measurement.zzot.INT
            com.google.android.gms.internal.measurement.zzot r0 = r0.zza()
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
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zznl
            if (r0 != 0) goto L21
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzmu
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzmi
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzlg
            if (r0 != 0) goto L33
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
        L33:
            return
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
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zzos r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzot r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlv.zzn(com.google.android.gms.internal.measurement.zzlu, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzlv zzlvVar = new zzlv();
        zzod zzodVar = this.zza;
        int iZzc = zzodVar.zzc();
        for (int i4 = 0; i4 < iZzc; i4++) {
            Map.Entry entryZzd = zzodVar.zzd(i4);
            zzlvVar.zzd((zzlu) ((zzoa) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzodVar.zze()) {
            zzlvVar.zzd((zzlu) entry.getKey(), entry.getValue());
        }
        zzlvVar.zzc = this.zzc;
        return zzlvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlv) {
            return this.zza.equals(((zzlv) obj).zza);
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
        zzod zzodVar = this.zza;
        int iZzc = zzodVar.zzc();
        for (int i4 = 0; i4 < iZzc; i4++) {
            Object value = zzodVar.zzd(i4).getValue();
            if (value instanceof zzme) {
                ((zzme) value).zzcj();
            }
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzme) {
                ((zzme) value2).zzcj();
            }
        }
        zzodVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzod zzodVar = this.zza;
        return zzodVar.isEmpty() ? Collections.emptyIterator() : this.zzc ? new zzmt(zzodVar.entrySet().iterator()) : zzodVar.entrySet().iterator();
    }

    public final void zzd(zzlu zzluVar, Object obj) {
        if (!zzluVar.zzd()) {
            zzn(zzluVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                Object obj2 = list.get(i4);
                zzn(zzluVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzmu) {
            this.zzc = true;
        }
        this.zza.put(zzluVar, obj);
    }

    public final boolean zze() {
        zzod zzodVar = this.zza;
        int iZzc = zzodVar.zzc();
        for (int i4 = 0; i4 < iZzc; i4++) {
            if (!zzk(zzodVar.zzd(i4))) {
                return false;
            }
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzod zzodVar = this.zza;
        int iZzc = zzodVar.zzc();
        int iZzm = 0;
        for (int i4 = 0; i4 < iZzc; i4++) {
            iZzm += zzm(zzodVar.zzd(i4));
        }
        Iterator it = zzodVar.zze().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    private zzlv(boolean z4) {
        zzb();
        zzb();
    }
}
