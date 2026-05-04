package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import com.google.android.recaptcha.internal.zzmx;
import com.google.android.recaptcha.internal.zznd;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zznd<MessageType extends zznd<MessageType, BuilderType>, BuilderType extends zzmx<MessageType, BuilderType>> extends zzko<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzpm zzc = zzpm.zzc();

    public static zznj zzA() {
        return zznx.zzf();
    }

    public static zznk zzB() {
        return zzot.zze();
    }

    public static zznk zzC(zznk zznkVar) {
        int size = zznkVar.size();
        return zznkVar.zzd(size + size);
    }

    public static Object zzE(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzF(zzoi zzoiVar, String str, Object[] objArr) {
        return new zzou(zzoiVar, str, objArr);
    }

    public static void zzI(Class cls, zznd zzndVar) {
        zzndVar.zzH();
        zzb.put(cls, zzndVar);
    }

    public static final boolean zzK(zznd zzndVar, boolean z10) {
        byte bByteValue = ((Byte) zzndVar.zzh(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzos.zza().zzb(zzndVar.getClass()).zzl(zzndVar);
        if (z10) {
            zzndVar.zzh(2, true != zZzl ? null : zzndVar, null);
        }
        return zZzl;
    }

    private final int zzf(zzow zzowVar) {
        return zzos.zza().zzb(getClass()).zza(this);
    }

    private static zznd zzg(zznd zzndVar) throws zznn {
        if (zzndVar == null || zzK(zzndVar, true)) {
            return zzndVar;
        }
        throw new zzpk(zzndVar).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zznd zzi(zznd zzndVar, byte[] bArr, int i10, int i11, zzmo zzmoVar) throws zznn {
        if (i11 == 0) {
            return zzndVar;
        }
        zznd zzndVarZzv = zzndVar.zzv();
        try {
            zzow zzowVarZzb = zzos.zza().zzb(zzndVarZzv.getClass());
            zzowVarZzb.zzi(zzndVarZzv, bArr, 0, i11, new zzkt(zzmoVar));
            zzowVarZzb.zzf(zzndVarZzv);
            return zzndVarZzv;
        } catch (zznn e10) {
            if (e10.zzb()) {
                throw new zznn(e10);
            }
            throw e10;
        } catch (zzpk e11) {
            throw e11.zza();
        } catch (IOException e12) {
            if (e12.getCause() instanceof zznn) {
                throw ((zznn) e12.getCause());
            }
            throw new zznn(e12);
        } catch (IndexOutOfBoundsException unused) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zznc zzs(zzoi zzoiVar, Object obj, zzoi zzoiVar2, zzng zzngVar, int i10, zzpw zzpwVar, Class cls) {
        return new zznc(zzoiVar, "", null, new zznb(null, i10, zzpwVar, false, false), cls);
    }

    public static zznd zzu(Class cls) {
        Map map = zzb;
        zznd zzndVar = (zznd) map.get(cls);
        if (zzndVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzndVar = (zznd) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzndVar != null) {
            return zzndVar;
        }
        zznd zzndVar2 = (zznd) ((zznd) zzps.zze(cls)).zzh(6, null, null);
        if (zzndVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzndVar2);
        return zzndVar2;
    }

    public static zznd zzw(zznd zzndVar, InputStream inputStream) throws zznn {
        zzli zzlgVar;
        int i10 = zzli.zzd;
        if (inputStream == null) {
            byte[] bArr = zznl.zzb;
            int length = bArr.length;
            zzlgVar = zzli.zzH(bArr, 0, 0, false);
        } else {
            zzlgVar = new zzlg(inputStream, 4096, null);
        }
        int i11 = zzmo.zzb;
        int i12 = zzos.zza;
        zzmo zzmoVar = zzmo.zza;
        zznd zzndVarZzv = zzndVar.zzv();
        try {
            zzow zzowVarZzb = zzos.zza().zzb(zzndVarZzv.getClass());
            zzowVarZzb.zzh(zzndVarZzv, zzlj.zzq(zzlgVar), zzmoVar);
            zzowVarZzb.zzf(zzndVarZzv);
            zzg(zzndVarZzv);
            return zzndVarZzv;
        } catch (zznn e10) {
            if (e10.zzb()) {
                throw new zznn(e10);
            }
            throw e10;
        } catch (zzpk e11) {
            throw e11.zza();
        } catch (IOException e12) {
            if (e12.getCause() instanceof zznn) {
                throw ((zznn) e12.getCause());
            }
            throw new zznn(e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof zznn) {
                throw ((zznn) e13.getCause());
            }
            throw e13;
        }
    }

    public static zznd zzx(zznd zzndVar, byte[] bArr) throws zznn {
        int i10 = zzmo.zzb;
        int i11 = zzos.zza;
        zznd zzndVarZzi = zzi(zzndVar, bArr, 0, bArr.length, zzmo.zza);
        zzg(zzndVarZzi);
        return zzndVarZzi;
    }

    public static zzni zzy() {
        return zzne.zzf();
    }

    public static zzni zzz(zzni zzniVar) {
        int size = zzniVar.size();
        return zzniVar.zzd(size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzos.zza().zzb(getClass()).zzk(this, (zznd) obj);
    }

    public final int hashCode() {
        if (zzL()) {
            return zzn();
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int iZzn = zzn();
        this.zza = iZzn;
        return iZzn;
    }

    public final String toString() {
        return zzok.zza(this, super.toString());
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final zzoq zzD() {
        return (zzoq) zzh(7, null, null);
    }

    public final void zzG() {
        zzos.zza().zzb(getClass()).zzf(this);
        zzH();
    }

    public final void zzH() {
        this.zzd &= a.e.API_PRIORITY_OTHER;
    }

    public final void zzJ(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | a.e.API_PRIORITY_OTHER;
    }

    public final boolean zzL() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.recaptcha.internal.zzko
    public final int zza(zzow zzowVar) {
        if (zzL()) {
            int iZza = zzowVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i10 = this.zzd & a.e.API_PRIORITY_OTHER;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iZza2 = zzowVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final /* synthetic */ zzoh zzad() {
        return (zzmx) zzh(5, null, null);
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final /* synthetic */ zzoh zzae() {
        zzmx zzmxVar = (zzmx) zzh(5, null, null);
        zzmxVar.zzh(this);
        return zzmxVar;
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final void zze(zzln zzlnVar) {
        zzos.zza().zzb(getClass()).zzj(this, zzlo.zza(zzlnVar));
    }

    public abstract Object zzh(int i10, Object obj, Object obj2);

    @Override // com.google.android.recaptcha.internal.zzoj
    public final /* synthetic */ zzoi zzm() {
        return (zznd) zzh(6, null, null);
    }

    public final int zzn() {
        return zzos.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.recaptcha.internal.zzoi
    public final int zzo() {
        if (zzL()) {
            int iZzf = zzf(null);
            if (iZzf >= 0) {
                return iZzf;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzf);
        }
        int i10 = this.zzd & a.e.API_PRIORITY_OTHER;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iZzf2 = zzf(null);
        if (iZzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzf2;
            return iZzf2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzf2);
    }

    @Override // com.google.android.recaptcha.internal.zzoj
    public final boolean zzp() {
        return zzK(this, true);
    }

    public final zzmx zzq() {
        return (zzmx) zzh(5, null, null);
    }

    public final zzmx zzr() {
        zzmx zzmxVar = (zzmx) zzh(5, null, null);
        zzmxVar.zzh(this);
        return zzmxVar;
    }

    public final zznd zzv() {
        return (zznd) zzh(4, null, null);
    }
}
