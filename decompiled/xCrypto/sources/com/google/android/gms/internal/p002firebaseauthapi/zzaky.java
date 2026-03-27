package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.firebase-auth-api.zzaky.zza;
import com.google.android.gms.internal.p002firebaseauthapi.zzaky;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaky<MessageType extends zzaky<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzajf<MessageType, BuilderType> {
    private static Map<Class<?>, zzaky<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzann zzb = zzann.zzc();

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzaky<MessageType, BuilderType> implements zzame {
        protected zzakr<zze> zzc = zzakr.zzb();

        public final zzakr<zze> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzakr) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public static class zzc<T extends zzaky<T, ?>> extends zzajg<T> {
        public zzc(T t4) {
        }
    }

    public static class zzd<ContainingType extends zzamc, Type> extends zzakl<ContainingType, Type> {
    }

    public static final class zze implements zzakt<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzanw zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzaod zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzamf zza(zzamf zzamfVar, zzamc zzamcVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakt
        public final zzaml zza(zzaml zzamlVar, zzaml zzamlVar2) {
            throw new NoSuchMethodError();
        }
    }

    public enum zzf {
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

    public static /* synthetic */ boolean zza(zzaky zzakyVar, boolean z4) {
        return zzb(zzakyVar, false);
    }

    private final int zzb(zzamv<?> zzamvVar) {
        return zzamvVar == null ? zzamr.zza().zza(this).zza(this) : zzamvVar.zza(this);
    }

    public static <E> zzalc<E> zzp() {
        return zzamq.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzamr.zza().zza(this).zzb(this, (zzaky) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzu()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzamh.zza(this, super.toString());
    }

    public abstract Object zza(int i4, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
    public final /* synthetic */ zzamc zzg() {
        return (zzaky) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final int zzi() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
    public final boolean zzj() {
        return zzb(this, true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zzl() {
        return zza((zzamv) null);
    }

    public final <MessageType2 extends zzaky<MessageType2, BuilderType2>, BuilderType2 extends zza<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (BuilderType2) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final MessageType zzo() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final /* synthetic */ zzamf zzq() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final /* synthetic */ zzamf zzr() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    public final void zzs() {
        zzamr.zza().zza(this).zzd(this);
        zzt();
    }

    public final void zzt() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean zzu() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    private final int zza() {
        return zzamr.zza().zza(this).zzb(this);
    }

    private static <T extends zzaky<T, ?>> T zzb(T t4, zzajp zzajpVar, zzakk zzakkVar) {
        zzakb zzakbVarZzc = zzajpVar.zzc();
        T t5 = (T) zza(t4, zzakbVarZzc, zzakkVar);
        zzakbVarZzc.zzb(0);
        return t5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final int zza(zzamv zzamvVar) {
        if (zzu()) {
            int iZzb = zzb((zzamv<?>) zzamvVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int iZzb2 = zzb((zzamv<?>) zzamvVar);
        zzb(iZzb2);
        return iZzb2;
    }

    public static abstract class zza<MessageType extends zzaky<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzaje<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzu()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzo();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
        public /* synthetic */ Object clone() {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzf();
            return zzaVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzu()) {
                zzi();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
        /* JADX INFO: renamed from: zzb */
        public final /* synthetic */ zzaje clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzj()) {
                return messagetype;
            }
            throw new zzanl(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (!this.zza.zzu()) {
                return this.zza;
            }
            this.zza.zzs();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
        public final /* synthetic */ zzamc zzg() {
            return this.zzb;
        }

        public final void zzh() {
            if (this.zza.zzu()) {
                return;
            }
            zzi();
        }

        public void zzi() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzame
        public final boolean zzj() {
            return zzaky.zza((zzaky) this.zza, false);
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamr.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajf
    public final void zzb(int i4) {
        if (i4 >= 0) {
            this.zzd = (i4 & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i4);
        }
    }

    private static final <T extends zzaky<T, ?>> boolean zzb(T t4, boolean z4) {
        byte bByteValue = ((Byte) t4.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzamr.zza().zza(t4).zze(t4);
        if (z4) {
            t4.zza(zzf.zzb, zZze ? t4 : null, null);
        }
        return zZze;
    }

    private static <T extends zzaky<T, ?>> T zza(T t4) throws zzalf {
        if (t4 == null || zzb(t4, true)) {
            return t4;
        }
        zzalf zzalfVarZza = new zzanl(t4).zza();
        zzalfVarZza.getClass();
        throw zzalfVarZza;
    }

    public static <T extends zzaky<?, ?>> T zza(Class<T> cls) {
        T t4 = (T) zzc.get(cls);
        if (t4 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t4 = (T) zzc.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (t4 != null) {
            return t4;
        }
        T t5 = (T) ((zzaky) zzanp.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
        if (t5 != null) {
            zzc.put((Class<?>) cls, t5);
            return t5;
        }
        throw new IllegalStateException();
    }

    public static <T extends zzaky<T, ?>> T zza(T t4, zzajp zzajpVar, zzakk zzakkVar) {
        return (T) zza(zzb(t4, zzajpVar, zzakkVar));
    }

    public static <T extends zzaky<T, ?>> T zza(T t4, InputStream inputStream, zzakk zzakkVar) {
        zzakb zzakdVar;
        if (inputStream == null) {
            byte[] bArr = zzalb.zzb;
            zzakdVar = zzakb.zza(bArr, 0, bArr.length, false);
        } else {
            zzakdVar = new zzakd(inputStream);
        }
        return (T) zza(zza(t4, zzakdVar, zzakkVar));
    }

    public static <T extends zzaky<T, ?>> T zza(T t4, byte[] bArr, zzakk zzakkVar) {
        return (T) zza(zza(t4, bArr, 0, bArr.length, zzakkVar));
    }

    private static <T extends zzaky<T, ?>> T zza(T t4, zzakb zzakbVar, zzakk zzakkVar) throws zzalf {
        T t5 = (T) t4.zzo();
        try {
            zzamv zzamvVarZza = zzamr.zza().zza(t5);
            zzamvVarZza.zza(t5, zzakf.zza(zzakbVar), zzakkVar);
            zzamvVarZza.zzd(t5);
            return t5;
        } catch (zzalf e4) {
            if (e4.zzl()) {
                throw new zzalf(e4);
            }
            throw e4;
        } catch (zzanl e5) {
            zzalf zzalfVarZza = e5.zza();
            zzalfVarZza.getClass();
            throw zzalfVarZza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzalf) {
                throw ((zzalf) e6.getCause());
            }
            throw new zzalf(e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof zzalf) {
                throw ((zzalf) e7.getCause());
            }
            throw e7;
        }
    }

    private static <T extends zzaky<T, ?>> T zza(T t4, byte[] bArr, int i4, int i5, zzakk zzakkVar) throws zzalf {
        if (i5 == 0) {
            return t4;
        }
        T t5 = (T) t4.zzo();
        try {
            zzamv zzamvVarZza = zzamr.zza().zza(t5);
            zzamvVarZza.zza(t5, bArr, 0, i5, new zzajk(zzakkVar));
            zzamvVarZza.zzd(t5);
            return t5;
        } catch (zzalf e4) {
            if (e4.zzl()) {
                throw new zzalf(e4);
            }
            throw e4;
        } catch (zzanl e5) {
            zzalf zzalfVarZza = e5.zza();
            zzalfVarZza.getClass();
            throw zzalfVarZza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzalf) {
                throw ((zzalf) e6.getCause());
            }
            throw new zzalf(e6);
        } catch (IndexOutOfBoundsException unused) {
            zzalf zzalfVarZzj = zzalf.zzj();
            zzalfVarZzj.getClass();
            throw zzalfVarZzj;
        }
    }

    public static <E> zzalc<E> zza(zzalc<E> zzalcVar) {
        return zzalcVar.zza(zzalcVar.size() << 1);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static Object zza(zzamc zzamcVar, String str, Object[] objArr) {
        return new zzamt(zzamcVar, str, objArr);
    }

    public static <T extends zzaky<?, ?>> void zza(Class<T> cls, T t4) {
        t4.zzt();
        zzc.put(cls, t4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(zzakg zzakgVar) {
        zzamr.zza().zza(this).zza(this, zzakj.zza(zzakgVar));
    }
}
