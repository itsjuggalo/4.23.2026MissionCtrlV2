package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1412v1 extends AbstractC1333f1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f15525b = Logger.getLogger(AbstractC1412v1.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f15526c = C2.C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1416w1 f15527a;

    public /* synthetic */ AbstractC1412v1(AbstractC1407u1 abstractC1407u1) {
    }

    public static int a(InterfaceC1334f2 interfaceC1334f2, InterfaceC1384p2 interfaceC1384p2) {
        int iC = ((AbstractC1308a1) interfaceC1334f2).c(interfaceC1384p2);
        return c(iC) + iC;
    }

    public static int b(String str) {
        int length;
        try {
            length = F2.c(str);
        } catch (E2 unused) {
            length = str.getBytes(P1.f15203a).length;
        }
        return c(length) + length;
    }

    public static int c(int i8) {
        return (352 - (Integer.numberOfLeadingZeros(i8) * 9)) >>> 6;
    }

    public static int d(long j8) {
        return (640 - (Long.numberOfLeadingZeros(j8) * 9)) >>> 6;
    }

    public static int z(int i8, InterfaceC1334f2 interfaceC1334f2, InterfaceC1384p2 interfaceC1384p2) {
        int iC = c(i8 << 3);
        return iC + iC + ((AbstractC1308a1) interfaceC1334f2).c(interfaceC1384p2);
    }

    public final void e() {
        if (h() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void f(String str, E2 e22) throws C1402t1 {
        f15525b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e22);
        byte[] bytes = str.getBytes(P1.f15203a);
        try {
            int length = bytes.length;
            w(length);
            r(bytes, 0, length);
        } catch (IndexOutOfBoundsException e8) {
            throw new C1402t1(e8);
        }
    }

    public abstract int h();

    public abstract void i(byte b8);

    public abstract void j(int i8, boolean z7);

    public abstract void k(int i8, AbstractC1378o1 abstractC1378o1);

    public abstract void l(int i8, int i9);

    public abstract void m(int i8);

    public abstract void n(int i8, long j8);

    public abstract void o(long j8);

    public abstract void p(int i8, int i9);

    public abstract void q(int i8);

    public abstract void r(byte[] bArr, int i8, int i9);

    public abstract void s(int i8, InterfaceC1334f2 interfaceC1334f2, InterfaceC1384p2 interfaceC1384p2);

    public abstract void t(int i8, String str);

    public abstract void u(int i8, int i9);

    public abstract void v(int i8, int i9);

    public abstract void w(int i8);

    public abstract void x(int i8, long j8);

    public abstract void y(long j8);
}
