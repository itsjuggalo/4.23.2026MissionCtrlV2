package com.google.android.gms.internal.fido;

import io.flutter.Build;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzhq {
    public static final zzhp zza(InputStream inputStream, zzhs zzhsVar) {
        try {
            return zzb(inputStream, zzhsVar);
        } finally {
            try {
                zzhsVar.close();
            } catch (IOException unused) {
            }
        }
    }

    private static final zzhp zzb(InputStream inputStream, zzhs zzhsVar) throws zzhj {
        try {
            zzhr zzhrVarZzd = zzhsVar.zzd();
            if (zzhrVarZzd == null) {
                throw new zzhj("Parser being asked to parse an empty input stream");
            }
            try {
                byte bZza = zzhrVarZzd.zza();
                byte bZzb = zzhrVarZzd.zzb();
                int i10 = 0;
                if (bZzb == -128) {
                    long jZza = zzhsVar.zza();
                    if (jZza > 1000) {
                        throw new zzhj("Parser being asked to read a large CBOR array");
                    }
                    zzc(bZza, jZza, inputStream, zzhsVar);
                    zzhp[] zzhpVarArr = new zzhp[(int) jZza];
                    while (i10 < jZza) {
                        zzhpVarArr[i10] = zzb(inputStream, zzhsVar);
                        i10++;
                    }
                    return new zzhg(zzcc.zzi(zzhpVarArr));
                }
                if (bZzb != -96) {
                    if (bZzb == -64) {
                        throw new zzhj("Tags are currently unsupported");
                    }
                    if (bZzb == -32) {
                        return new zzhh(zzhsVar.zzf());
                    }
                    if (bZzb == 0 || bZzb == 32) {
                        long jZzb = zzhsVar.zzb();
                        zzc(bZza, jZzb > 0 ? jZzb : ~jZzb, inputStream, zzhsVar);
                        return new zzhk(jZzb);
                    }
                    if (bZzb == 64) {
                        byte[] bArrZzg = zzhsVar.zzg();
                        int length = bArrZzg.length;
                        zzc(bZza, length, inputStream, zzhsVar);
                        return new zzhi(zzgx.zzl(bArrZzg, 0, length));
                    }
                    if (bZzb == 96) {
                        String strZze = zzhsVar.zze();
                        zzc(bZza, strZze.length(), inputStream, zzhsVar);
                        return new zzhn(strZze);
                    }
                    throw new zzhj("Unidentifiable major type: " + zzhrVarZzd.zzc());
                }
                long jZzc = zzhsVar.zzc();
                if (jZzc > 1000) {
                    throw new zzhj("Parser being asked to read a large CBOR map");
                }
                zzc(bZza, jZzc, inputStream, zzhsVar);
                int i11 = (int) jZzc;
                zzhl[] zzhlVarArr = new zzhl[i11];
                zzhp zzhpVar = null;
                int i12 = 0;
                while (i12 < jZzc) {
                    zzhp zzhpVarZzb = zzb(inputStream, zzhsVar);
                    if (zzhpVar != null && zzhpVarZzb.compareTo(zzhpVar) <= 0) {
                        throw new zzhf(String.format("Keys in CBOR Map not in strictly ascending natural order:\nPrevious key: %s\nCurrent key: %s", zzhpVar.toString(), zzhpVarZzb.toString()));
                    }
                    zzhlVarArr[i12] = new zzhl(zzhpVarZzb, zzb(inputStream, zzhsVar));
                    i12++;
                    zzhpVar = zzhpVarZzb;
                }
                TreeMap treeMap = new TreeMap();
                while (i10 < i11) {
                    zzhl zzhlVar = zzhlVarArr[i10];
                    if (treeMap.containsKey(zzhlVar.zza())) {
                        throw new zzhf("Attempted to add duplicate key to canonical CBOR Map.");
                    }
                    treeMap.put(zzhlVar.zza(), zzhlVar.zzb());
                    i10++;
                }
                return new zzhm(zzcj.zzf(treeMap));
            } catch (IOException e10) {
                e = e10;
                throw new zzhj("Error in decoding CborValue from bytes", e);
            } catch (RuntimeException e11) {
                e = e11;
                throw new zzhj("Error in decoding CborValue from bytes", e);
            }
        } catch (IOException e12) {
            throw new zzhj("Error in decoding CborValue from bytes", e12);
        }
    }

    private static final void zzc(byte b10, long j10, InputStream inputStream, zzhs zzhsVar) throws zzhf {
        switch (b10) {
            case 24:
                if (j10 >= 24) {
                    return;
                }
                throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0 additional bytes, but used 1");
            case Build.API_LEVELS.API_25 /* 25 */:
                if (j10 >= 256) {
                    return;
                }
                throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-1 additional bytes, but used 2");
            case Build.API_LEVELS.API_26 /* 26 */:
                if (j10 >= 65536) {
                    return;
                }
                throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-2 additional bytes, but used 4");
            case Build.API_LEVELS.API_27 /* 27 */:
                if (j10 >= 4294967296L) {
                    return;
                }
                throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-4 additional bytes, but used 8");
            default:
                return;
        }
    }
}
