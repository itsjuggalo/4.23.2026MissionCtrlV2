package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzhg;
import com.google.android.gms.internal.play_billing.zzhk;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhk<MessageType extends zzhk<MessageType, BuilderType>, BuilderType extends zzhg<MessageType, BuilderType>> extends zzfv<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzjk zzc = zzjk.zzc();

    private static zzhk zzB(zzhk zzhkVar, byte[] bArr, int i4, int i5, zzgw zzgwVar) throws zzhr {
        if (i5 == 0) {
            return zzhkVar;
        }
        zzhk zzhkVarZzp = zzhkVar.zzp();
        try {
            zzix zzixVarZzb = zziu.zza().zzb(zzhkVarZzp.getClass());
            zzixVarZzb.zzh(zzhkVarZzp, bArr, 0, i5, new zzfz(zzgwVar));
            zzixVarZzb.zzf(zzhkVarZzp);
            return zzhkVarZzp;
        } catch (zzhr e4) {
            throw e4;
        } catch (zzji e5) {
            throw e5.zza();
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzhr) {
                throw ((zzhr) e6.getCause());
            }
            throw new zzhr(e6);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final int zzc(zzix zzixVar) {
        return zziu.zza().zzb(getClass()).zza(this);
    }

    public static zzhk zzo(Class cls) {
        Map map = zzb;
        zzhk zzhkVar = (zzhk) map.get(cls);
        if (zzhkVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhkVar = (zzhk) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzhkVar != null) {
            return zzhkVar;
        }
        zzhk zzhkVar2 = (zzhk) ((zzhk) zzjq.zze(cls)).zzd(6, null, null);
        if (zzhkVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzhkVar2);
        return zzhkVar2;
    }

    public static zzhk zzq(zzhk zzhkVar, byte[] bArr, zzgw zzgwVar) throws zzhr {
        zzhk zzhkVarZzB = zzB(zzhkVar, bArr, 0, bArr.length, zzgwVar);
        if (zzhkVarZzB == null || zzz(zzhkVarZzB, true)) {
            return zzhkVarZzB;
        }
        throw new zzji(zzhkVarZzB).zza();
    }

    public static zzhn zzr() {
        return zzhl.zzf();
    }

    public static zzho zzs() {
        return zziv.zze();
    }

    public static Object zzt(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzu(zzim zzimVar, String str, Object[] objArr) {
        return new zziw(zzimVar, str, objArr);
    }

    public static void zzx(Class cls, zzhk zzhkVar) {
        zzhkVar.zzw();
        zzb.put(cls, zzhkVar);
    }

    public static final boolean zzz(zzhk zzhkVar, boolean z4) {
        byte bByteValue = ((Byte) zzhkVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zziu.zza().zzb(zzhkVar.getClass()).zzk(zzhkVar);
        if (z4) {
            zzhkVar.zzd(2, true != zZzk ? null : zzhkVar, null);
        }
        return zZzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zziu.zza().zzb(getClass()).zzj(this, (zzhk) obj);
    }

    public final int hashCode() {
        if (zzA()) {
            return zzj();
        }
        int i4 = this.zza;
        if (i4 != 0) {
            return i4;
        }
        int iZzj = zzj();
        this.zza = iZzj;
        return iZzj;
    }

    public final String toString() {
        return zzio.zza(this, super.toString());
    }

    public final boolean zzA() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final /* synthetic */ zzil zzI() {
        return (zzhg) zzd(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final void zzJ(zzgr zzgrVar) {
        zziu.zza().zzb(getClass()).zzi(this, zzgs.zza(zzgrVar));
    }

    public abstract Object zzd(int i4, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzfv
    public final int zze(zzix zzixVar) {
        if (zzA()) {
            int iZza = zzixVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i4 = this.zzd & Integer.MAX_VALUE;
        if (i4 != Integer.MAX_VALUE) {
            return i4;
        }
        int iZza2 = zzixVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final /* synthetic */ zzim zzi() {
        return (zzhk) zzd(6, null, null);
    }

    public final int zzj() {
        return zziu.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final int zzk() {
        if (zzA()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
        }
        int i4 = this.zzd & Integer.MAX_VALUE;
        if (i4 != Integer.MAX_VALUE) {
            return i4;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzin
    public final boolean zzl() {
        return zzz(this, true);
    }

    public final zzhg zzm() {
        return (zzhg) zzd(5, null, null);
    }

    public final zzhg zzn() {
        zzhg zzhgVar = (zzhg) zzd(5, null, null);
        zzhgVar.zze(this);
        return zzhgVar;
    }

    public final zzhk zzp() {
        return (zzhk) zzd(4, null, null);
    }

    public final void zzv() {
        zziu.zza().zzb(getClass()).zzf(this);
        zzw();
    }

    public final void zzw() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzy(int i4) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }
}
