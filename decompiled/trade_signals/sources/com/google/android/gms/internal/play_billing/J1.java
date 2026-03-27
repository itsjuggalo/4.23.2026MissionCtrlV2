package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class J1 extends AbstractC1308a1 {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected C1417w2 zzc = C1417w2.c();

    public static final boolean e(J1 j12, boolean z7) {
        byte bByteValue = ((Byte) j12.f(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = C1369m2.a().b(j12.getClass()).zzk(j12);
        if (z7) {
            j12.f(2, true != zZzk ? null : j12, null);
        }
        return zZzk;
    }

    public static J1 h(J1 j12, byte[] bArr, int i8, int i9, C1428z1 c1428z1) throws R1 {
        if (i9 == 0) {
            return j12;
        }
        J1 j1N = j12.n();
        try {
            InterfaceC1384p2 interfaceC1384p2B = C1369m2.a().b(j1N.getClass());
            interfaceC1384p2B.g(j1N, bArr, 0, i9, new C1323d1(c1428z1));
            interfaceC1384p2B.c(j1N);
            return j1N;
        } catch (R1 e8) {
            throw e8;
        } catch (C1408u2 e9) {
            throw e9.a();
        } catch (IOException e10) {
            if (e10.getCause() instanceof R1) {
                throw ((R1) e10.getCause());
            }
            throw new R1(e10);
        } catch (IndexOutOfBoundsException unused) {
            throw new R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static J1 m(Class cls) {
        Map map = zzb;
        J1 j12 = (J1) map.get(cls);
        if (j12 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                j12 = (J1) map.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (j12 == null) {
            j12 = (J1) ((J1) C2.j(cls)).f(6, null, null);
            if (j12 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, j12);
        }
        return j12;
    }

    public static J1 o(J1 j12, byte[] bArr, C1428z1 c1428z1) throws R1 {
        J1 j1H = h(j12, bArr, 0, bArr.length, c1428z1);
        if (j1H == null || e(j1H, true)) {
            return j1H;
        }
        throw new C1408u2(j1H).a();
    }

    public static N1 p() {
        return K1.e();
    }

    public static O1 q() {
        return C1374n2.d();
    }

    public static Object r(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e8);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object s(InterfaceC1334f2 interfaceC1334f2, String str, Object[] objArr) {
        return new C1379o2(interfaceC1334f2, str, objArr);
    }

    public static void v(Class cls, J1 j12) {
        j12.u();
        zzb.put(cls, j12);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1334f2
    public final void b(AbstractC1412v1 abstractC1412v1) {
        C1369m2.a().b(getClass()).b(this, C1416w1.B(abstractC1412v1));
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1308a1
    public final int c(InterfaceC1384p2 interfaceC1384p2) {
        if (x()) {
            int iD = interfaceC1384p2.d(this);
            if (iD >= 0) {
                return iD;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iD);
        }
        int i8 = this.zzd & Integer.MAX_VALUE;
        if (i8 != Integer.MAX_VALUE) {
            return i8;
        }
        int iD2 = interfaceC1384p2.d(this);
        if (iD2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iD2;
            return iD2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iD2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C1369m2.a().b(getClass()).f(this, (J1) obj);
    }

    public abstract Object f(int i8, Object obj, Object obj2);

    public final int g(InterfaceC1384p2 interfaceC1384p2) {
        return C1369m2.a().b(getClass()).d(this);
    }

    public final int hashCode() {
        if (x()) {
            return i();
        }
        int i8 = this.zza;
        if (i8 != 0) {
            return i8;
        }
        int i9 = i();
        this.zza = i9;
        return i9;
    }

    public final int i() {
        return C1369m2.a().b(getClass()).a(this);
    }

    public final boolean j() {
        return e(this, true);
    }

    public final H1 k() {
        return (H1) f(5, null, null);
    }

    public final H1 l() {
        H1 h12 = (H1) f(5, null, null);
        h12.e(this);
        return h12;
    }

    public final J1 n() {
        return (J1) f(4, null, null);
    }

    public final void t() {
        C1369m2.a().b(getClass()).c(this);
        u();
    }

    public final String toString() {
        return AbstractC1344h2.a(this, super.toString());
    }

    public final void u() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void w(int i8) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean x() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1334f2
    public final /* synthetic */ InterfaceC1329e2 zzK() {
        return (H1) f(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1339g2
    public final /* synthetic */ InterfaceC1334f2 zzh() {
        return (J1) f(6, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1334f2
    public final int zzj() {
        int iG;
        if (x()) {
            iG = g(null);
            if (iG < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iG);
            }
        } else {
            iG = this.zzd & Integer.MAX_VALUE;
            if (iG == Integer.MAX_VALUE) {
                iG = g(null);
                if (iG < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iG);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iG;
            }
        }
        return iG;
    }
}
