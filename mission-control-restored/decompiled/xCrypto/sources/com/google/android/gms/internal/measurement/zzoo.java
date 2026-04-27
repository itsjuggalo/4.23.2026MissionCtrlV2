package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzoo {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzon zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzoo.<clinit>():void");
    }

    private zzoo() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i4 = zzku.zza;
        Field fieldZzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (fieldZzC != null) {
            return fieldZzC;
        }
        Field fieldZzC2 = zzC(Buffer.class, "address");
        if (fieldZzC2 == null || fieldZzC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j4, byte b4) {
        Unsafe unsafe = zzf.zza;
        long j5 = (-4) & j4;
        int i4 = unsafe.getInt(obj, j5);
        int i5 = ((~((int) j4)) & 3) << 3;
        unsafe.putInt(obj, j5, ((255 & b4) << i5) | (i4 & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j4, byte b4) {
        Unsafe unsafe = zzf.zza;
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        unsafe.putInt(obj, j5, ((255 & b4) << i4) | (unsafe.getInt(obj, j5) & (~(255 << i4))));
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int zzd(Object obj, long j4) {
        return zzf.zza.getInt(obj, j4);
    }

    public static void zze(Object obj, long j4, int i4) {
        zzf.zza.putInt(obj, j4, i4);
    }

    public static long zzf(Object obj, long j4) {
        return zzf.zza.getLong(obj, j4);
    }

    public static void zzg(Object obj, long j4, long j5) {
        zzf.zza.putLong(obj, j4, j5);
    }

    public static boolean zzh(Object obj, long j4) {
        return zzf.zzb(obj, j4);
    }

    public static void zzi(Object obj, long j4, boolean z4) {
        zzf.zzc(obj, j4, z4);
    }

    public static float zzj(Object obj, long j4) {
        return zzf.zzd(obj, j4);
    }

    public static void zzk(Object obj, long j4, float f4) {
        zzf.zze(obj, j4, f4);
    }

    public static double zzl(Object obj, long j4) {
        return zzf.zzf(obj, j4);
    }

    public static void zzm(Object obj, long j4, double d4) {
        zzf.zzg(obj, j4, d4);
    }

    public static Object zzn(Object obj, long j4) {
        return zzf.zza.getObject(obj, j4);
    }

    public static void zzo(Object obj, long j4, Object obj2) {
        zzf.zza.putObject(obj, j4, obj2);
    }

    public static void zzp(byte[] bArr, long j4, byte b4) {
        zzf.zza(bArr, zza + j4, b4);
    }

    public static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzok());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzr(Class cls) {
        int i4 = zzku.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean zzu(Object obj, long j4) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean zzv(Object obj, long j4) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ void zzy(Throwable th) {
        Logger.getLogger(zzoo.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
