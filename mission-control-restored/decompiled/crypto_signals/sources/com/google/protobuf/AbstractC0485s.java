package com.google.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0485s extends y0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f5794d = Logger.getLogger(AbstractC0485s.class.getName());
    public static final boolean e = M0.e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Z f5795c;

    public static int A(int i) {
        if (i >= 0) {
            return D(i);
        }
        return 10;
    }

    public static int B(String str) {
        int length;
        try {
            length = P0.c(str);
        } catch (O0 unused) {
            length = str.getBytes(M.f5651a).length;
        }
        return D(length) + length;
    }

    public static int C(int i) {
        return D(i << 3);
    }

    public static int D(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int E(long j4) {
        int i;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j4) != 0) {
            i += 2;
            j4 >>>= 14;
        }
        return (j4 & (-16384)) != 0 ? i + 1 : i;
    }

    public static int y(int i, AbstractC0472l abstractC0472l) {
        return z(abstractC0472l) + C(i);
    }

    public static int z(AbstractC0472l abstractC0472l) {
        int size = abstractC0472l.size();
        return D(size) + size;
    }

    public final void F(String str, O0 o02) {
        f5794d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) o02);
        byte[] bytes = str.getBytes(M.f5651a);
        try {
            X(bytes.length);
            x(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new P4.c(e2);
        }
    }

    public abstract void G(byte b3);

    public abstract void H(int i, boolean z6);

    public abstract void I(byte[] bArr, int i);

    public abstract void J(int i, AbstractC0472l abstractC0472l);

    public abstract void K(AbstractC0472l abstractC0472l);

    public abstract void L(int i, int i6);

    public abstract void M(int i);

    public abstract void N(int i, long j4);

    public abstract void O(long j4);

    public abstract void P(int i, int i6);

    public abstract void Q(int i);

    public abstract void R(int i, AbstractC0450a abstractC0450a, InterfaceC0488t0 interfaceC0488t0);

    public abstract void S(AbstractC0450a abstractC0450a);

    public abstract void T(int i, String str);

    public abstract void U(String str);

    public abstract void V(int i, int i6);

    public abstract void W(int i, int i6);

    public abstract void X(int i);

    public abstract void Y(int i, long j4);

    public abstract void Z(long j4);
}
