package com.google.android.gms.internal.play_billing;

import bb.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzez {
    private static final zzez zzb = new zzez(true);
    final zzhd zza = new zzgy();
    private boolean zzc;
    private boolean zzd;

    private zzez() {
    }

    public static int zza(zzhs zzhsVar, int i10, Object obj) {
        int iZzC = zzep.zzC(i10 << 3);
        if (zzhsVar == zzhs.zzj) {
            zzfo.zzd((zzgl) obj);
            iZzC += iZzC;
        }
        return iZzC + zzb(zzhsVar, obj);
    }

    public static int zzb(zzhs zzhsVar, Object obj) {
        int iZzd;
        int iZzC;
        zzhs zzhsVar2 = zzhs.zza;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i10 = zzep.zzb;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i11 = zzep.zzb;
                return 4;
            case 2:
                return zzep.zzD(((Long) obj).longValue());
            case 3:
                return zzep.zzD(((Long) obj).longValue());
            case 4:
                return zzep.zzD(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i12 = zzep.zzb;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i13 = zzep.zzb;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i14 = zzep.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzei)) {
                    return zzep.zzB((String) obj);
                }
                int i15 = zzep.zzb;
                iZzd = ((zzei) obj).zzd();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 9:
                return ((zzgl) obj).zzj();
            case 10:
                if (!(obj instanceof zzfv)) {
                    return zzep.zzz((zzgl) obj);
                }
                int i16 = zzep.zzb;
                iZzd = ((zzfv) obj).zza();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzei)) {
                    int i17 = zzep.zzb;
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzep.zzC(iZzd);
                } else {
                    int i18 = zzep.zzb;
                    iZzd = ((zzei) obj).zzd();
                    iZzC = zzep.zzC(iZzd);
                }
                break;
            case 12:
                return zzep.zzC(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzfk ? zzep.zzD(((zzfk) obj).zza()) : zzep.zzD(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i19 = zzep.zzb;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i20 = zzep.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                long jLongValue = ((Long) obj).longValue();
                return zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzC + iZzd;
    }

    public static int zzc(zzey zzeyVar, Object obj) {
        zzhs zzhsVarZzb = zzeyVar.zzb();
        int iZza = zzeyVar.zza();
        if (!zzeyVar.zze()) {
            return zza(zzhsVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i10 = 0;
        if (!zzeyVar.zzd()) {
            int iZza2 = 0;
            while (i10 < size) {
                iZza2 += zza(zzhsVarZzb, iZza, list.get(i10));
                i10++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i10 < size) {
            iZzb += zzb(zzhsVarZzb, list.get(i10));
            i10++;
        }
        return zzep.zzC(iZza << 3) + iZzb + zzep.zzC(iZzb);
    }

    public static zzez zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() != zzht.MESSAGE) {
            return true;
        }
        if (!zzeyVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!zzk(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i10;
        int iZzC;
        int iZzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return zzc(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int iZza = ((zzey) entry.getKey()).zza();
            int iZzC3 = zzep.zzC(8);
            i10 = iZzC3 + iZzC3;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza);
            int iZzC4 = zzep.zzC(24);
            int iZza2 = ((zzfv) value).zza();
            iZzC2 = iZzC4 + zzep.zzC(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzey) entry.getKey()).zza();
            int iZzC5 = zzep.zzC(8);
            i10 = iZzC5 + iZzC5;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza3);
            iZzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i10 + iZzC + iZzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzm(com.google.android.gms.internal.play_billing.zzey r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.play_billing.zzhs r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.play_billing.zzfo.zzb
            r3.getClass()
            com.google.android.gms.internal.play_billing.zzhs r1 = com.google.android.gms.internal.play_billing.zzhs.zza
            com.google.android.gms.internal.play_billing.zzht r1 = com.google.android.gms.internal.play_billing.zzht.INT
            com.google.android.gms.internal.play_billing.zzht r0 = r0.zza()
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
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzgl
            if (r0 != 0) goto L21
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzfv
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzfk
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzei
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
            com.google.android.gms.internal.play_billing.zzhs r2 = r2.zzb()
            com.google.android.gms.internal.play_billing.zzht r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzez.zzm(com.google.android.gms.internal.play_billing.zzey, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzez zzezVar = new zzez();
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i10 = 0; i10 < iZzc; i10++) {
            Map.Entry entryZzg = zzhdVar.zzg(i10);
            zzezVar.zzh((zzey) ((zzgz) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            zzezVar.zzh((zzey) entry.getKey(), entry.getValue());
        }
        zzezVar.zzd = this.zzd;
        return zzezVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            return this.zza.equals(((zzez) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        int iZzl = 0;
        for (int i10 = 0; i10 < iZzc; i10++) {
            iZzl += zzl(zzhdVar.zzg(i10));
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        zzhd zzhdVar = this.zza;
        return zzhdVar.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzft(zzhdVar.entrySet().iterator()) : zzhdVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i10 = 0; i10 < iZzc; i10++) {
            Object value = zzhdVar.zzg(i10).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        zzhdVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzey zzeyVar, Object obj) {
        if (!zzeyVar.zze()) {
            zzm(zzeyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                Object obj2 = list.get(i10);
                zzm(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfv) {
            this.zzd = true;
        }
        this.zza.put(zzeyVar, obj);
    }

    public final boolean zzi() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i10 = 0; i10 < iZzc; i10++) {
            if (!zzj(zzhdVar.zzg(i10))) {
                return false;
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzez(boolean z10) {
        zzg();
        zzg();
    }
}
