package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1377o0 extends AbstractC1362l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f15469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f15470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f15471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f15472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f15473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f15474f;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e8) {
                throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.android.gms.internal.play_billing.u0
                @Override // java.security.PrivilegedExceptionAction
                public final Object run() throws IllegalAccessException {
                    Unsafe unsafe2 = C1377o0.f15469a;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
        try {
            f15471c = unsafe.objectFieldOffset(AbstractC1387q0.class.getDeclaredField("c"));
            f15470b = unsafe.objectFieldOffset(AbstractC1387q0.class.getDeclaredField("b"));
            f15472d = unsafe.objectFieldOffset(AbstractC1387q0.class.getDeclaredField("a"));
            f15473e = unsafe.objectFieldOffset(C1382p0.class.getDeclaredField("a"));
            f15474f = unsafe.objectFieldOffset(C1382p0.class.getDeclaredField("b"));
            f15469a = unsafe;
        } catch (NoSuchFieldException e9) {
            throw new RuntimeException(e9);
        }
    }

    public /* synthetic */ C1377o0(AbstractC1411v0 abstractC1411v0) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1347i0 a(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0) {
        C1347i0 c1347i02;
        do {
            c1347i02 = abstractC1387q0.f15492b;
            if (c1347i0 == c1347i02) {
                break;
            }
        } while (!e(abstractC1387q0, c1347i02, c1347i0));
        return c1347i02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1382p0 b(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0) {
        C1382p0 c1382p02;
        do {
            c1382p02 = abstractC1387q0.f15493c;
            if (c1382p0 == c1382p02) {
                break;
            }
        } while (!g(abstractC1387q0, c1382p02, c1382p0));
        return c1382p02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void c(C1382p0 c1382p0, C1382p0 c1382p02) {
        f15469a.putObject(c1382p0, f15474f, c1382p02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void d(C1382p0 c1382p0, Thread thread) {
        f15469a.putObject(c1382p0, f15473e, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean e(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0, C1347i0 c1347i02) {
        return AbstractC1401t0.a(f15469a, abstractC1387q0, f15470b, c1347i0, c1347i02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean f(AbstractC1387q0 abstractC1387q0, Object obj, Object obj2) {
        return AbstractC1401t0.a(f15469a, abstractC1387q0, f15472d, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean g(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0, C1382p0 c1382p02) {
        return AbstractC1401t0.a(f15469a, abstractC1387q0, f15471c, c1382p0, c1382p02);
    }
}
