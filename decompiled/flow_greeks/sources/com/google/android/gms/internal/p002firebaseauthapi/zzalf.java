package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.firebase-auth-api.zzalf.zzb;
import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzalf<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajm<MessageType, BuilderType> {
    private static Map<Class<?>, zzalf<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzanx zzb = zzanx.zzc();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class zza<T extends zzalf<T, ?>> extends zzajq<T> {
        public zza(T t10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class zzc implements zzakz<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaog zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaoj zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaml zza(zzaml zzamlVar, zzamm zzammVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzamr zza(zzamr zzamrVar, zzamr zzamrVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzalf<MessageType, BuilderType> implements zzamo {
        protected zzakx<zzc> zzc = zzakx.zzb();

        public final zzakx<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzakx) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class zzf<ContainingType extends zzamm, Type> extends zzakr<ContainingType, Type> {
    }

    public static /* synthetic */ boolean zza(zzalf zzalfVar, boolean z10) {
        return zzb(zzalfVar, false);
    }

    private final int zzb(zzanb<?> zzanbVar) {
        return zzanbVar == null ? zzamx.zza().zza(this).zza(this) : zzanbVar.zza(this);
    }

    public static <E> zzalm<E> zzp() {
        return zzana.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzamx.zza().zza(this).zzb(this, (zzalf) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzw()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzamn.zza(this, super.toString());
    }

    public abstract Object zza(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    public final int zzi() {
        return this.zzd & a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final int zzl() {
        return zza((zzanb) null);
    }

    public final <MessageType2 extends zzalf<MessageType2, BuilderType2>, BuilderType2 extends zzb<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (BuilderType2) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final MessageType zzo() {
        return (MessageType) zza(zze.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final /* synthetic */ zzaml zzq() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final /* synthetic */ zzaml zzr() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
    public final /* synthetic */ zzamm zzs() {
        return (zzalf) zza(zze.zzf, (Object) null, (Object) null);
    }

    public final void zzt() {
        zzamx.zza().zza(this).zzd(this);
        zzu();
    }

    public final void zzu() {
        this.zzd &= a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
    public final boolean zzv() {
        return zzb(this, true);
    }

    public final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    private final int zza() {
        return zzamx.zza().zza(this).zzb(this);
    }

    private static <T extends zzalf<T, ?>> T zzb(T t10, zzajv zzajvVar, zzaku zzakuVar) {
        zzakh zzakhVarZzc = zzajvVar.zzc();
        T t11 = (T) zza(t10, zzakhVarZzc, zzakuVar);
        zzakhVarZzc.zzc(0);
        return t11;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    public final int zza(zzanb zzanbVar) {
        if (zzw()) {
            int iZzb = zzb((zzanb<?>) zzanbVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int iZzb2 = zzb((zzanb<?>) zzanbVar);
        zzb(iZzb2);
        return iZzb2;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class zzb<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajo<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzw()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzo();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public /* synthetic */ Object clone() {
            zzb zzbVar = (zzb) this.zzb.zza(zze.zze, null, null);
            zzbVar.zza = (MessageType) zzf();
            return zzbVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzw()) {
                zzh();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        /* JADX INFO: renamed from: zzb */
        public final /* synthetic */ zzajo clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaml
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzv()) {
                return messagetype;
            }
            throw new zzanv(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaml
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (!this.zza.zzw()) {
                return this.zza;
            }
            this.zza.zzt();
            return this.zza;
        }

        public final void zzg() {
            if (this.zza.zzw()) {
                return;
            }
            zzh();
        }

        public void zzh() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
        public final /* synthetic */ zzamm zzs() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
        public final boolean zzv() {
            return zzalf.zza((zzalf) this.zza, false);
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamx.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    public final void zzb(int i10) {
        if (i10 >= 0) {
            this.zzd = (i10 & a.e.API_PRIORITY_OTHER) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    private static final <T extends zzalf<T, ?>> boolean zzb(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzamx.zza().zza(t10).zze(t10);
        if (z10) {
            t10.zza(zze.zzb, zZze ? t10 : null, null);
        }
        return zZze;
    }

    private static <T extends zzalf<T, ?>> T zza(T t10) throws zzall {
        if (t10 == null || zzb(t10, true)) {
            return t10;
        }
        zzall zzallVarZza = new zzanv(t10).zza();
        zzallVarZza.getClass();
        throw zzallVarZza;
    }

    public static <T extends zzalf<?, ?>> T zza(Class<T> cls) {
        T t10 = (T) zzc.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (T) zzc.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) ((zzalf) zzanz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t11 != null) {
            zzc.put((Class<?>) cls, t11);
            return t11;
        }
        throw new IllegalStateException();
    }

    public static <T extends zzalf<T, ?>> T zza(T t10, zzajv zzajvVar, zzaku zzakuVar) {
        return (T) zza(zzb(t10, zzajvVar, zzakuVar));
    }

    public static <T extends zzalf<T, ?>> T zza(T t10, InputStream inputStream, zzaku zzakuVar) {
        zzakh zzakjVar;
        if (inputStream == null) {
            byte[] bArr = zzalh.zzb;
            zzakjVar = zzakh.zza(bArr, 0, bArr.length, false);
        } else {
            zzakjVar = new zzakj(inputStream);
        }
        return (T) zza(zza(t10, zzakjVar, zzakuVar));
    }

    public static <T extends zzalf<T, ?>> T zza(T t10, byte[] bArr, zzaku zzakuVar) {
        return (T) zza(zza(t10, bArr, 0, bArr.length, zzakuVar));
    }

    private static <T extends zzalf<T, ?>> T zza(T t10, zzakh zzakhVar, zzaku zzakuVar) throws zzall {
        T t11 = (T) t10.zzo();
        try {
            zzanb zzanbVarZza = zzamx.zza().zza(t11);
            zzanbVarZza.zza(t11, zzakl.zza(zzakhVar), zzakuVar);
            zzanbVarZza.zzd(t11);
            return t11;
        } catch (zzall e10) {
            if (e10.zzl()) {
                throw new zzall(e10);
            }
            throw e10;
        } catch (zzanv e11) {
            zzall zzallVarZza = e11.zza();
            zzallVarZza.getClass();
            throw zzallVarZza;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzall) {
                throw ((zzall) e12.getCause());
            }
            throw new zzall(e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof zzall) {
                throw ((zzall) e13.getCause());
            }
            throw e13;
        }
    }

    private static <T extends zzalf<T, ?>> T zza(T t10, byte[] bArr, int i10, int i11, zzaku zzakuVar) throws zzall {
        if (i11 == 0) {
            return t10;
        }
        T t11 = (T) t10.zzo();
        try {
            zzanb zzanbVarZza = zzamx.zza().zza(t11);
            zzanbVarZza.zza(t11, bArr, 0, i11, new zzaju(zzakuVar));
            zzanbVarZza.zzd(t11);
            return t11;
        } catch (zzall e10) {
            if (e10.zzl()) {
                throw new zzall(e10);
            }
            throw e10;
        } catch (zzanv e11) {
            zzall zzallVarZza = e11.zza();
            zzallVarZza.getClass();
            throw zzallVarZza;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzall) {
                throw ((zzall) e12.getCause());
            }
            throw new zzall(e12);
        } catch (IndexOutOfBoundsException unused) {
            zzall zzallVarZzj = zzall.zzj();
            zzallVarZzj.getClass();
            throw zzallVarZzj;
        }
    }

    public static <E> zzalm<E> zza(zzalm<E> zzalmVar) {
        return zzalmVar.zza(zzalmVar.size() << 1);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static Object zza(zzamm zzammVar, String str, Object[] objArr) {
        return new zzamz(zzammVar, str, objArr);
    }

    public static <T extends zzalf<?, ?>> void zza(Class<T> cls, T t10) {
        t10.zzu();
        zzc.put(cls, t10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final void zza(zzakn zzaknVar) {
        zzamx.zza().zza(this).zza(this, zzakp.zza(zzaknVar));
    }
}
