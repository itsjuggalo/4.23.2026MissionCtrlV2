package J4;

import J4.b;
import J4.f;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import u7.C2811d;
import u7.C2814g;
import u7.InterfaceC2812e;
import u7.InterfaceC2813f;
import u7.V;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f4608a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2814g f4609b = C2814g.g("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f4616a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f4617b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f4618c = new String[256];

        static {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr = f4618c;
                if (i9 >= strArr.length) {
                    break;
                }
                strArr[i9] = String.format("%8s", Integer.toBinaryString(i9)).replace(' ', '0');
                i9++;
            }
            String[] strArr2 = f4617b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i10 = iArr[0];
            strArr2[i10 | 8] = strArr2[i10] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr2[i11];
                int i13 = iArr[0];
                String[] strArr3 = f4617b;
                int i14 = i13 | i12;
                strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
                strArr3[i14 | 8] = strArr3[i13] + '|' + strArr3[i12] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f4617b;
                if (i8 >= strArr4.length) {
                    return;
                }
                if (strArr4[i8] == null) {
                    strArr4[i8] = f4618c[i8];
                }
                i8++;
            }
        }

        public static String a(byte b8, byte b9) {
            if (b9 == 0) {
                return "";
            }
            if (b8 != 2 && b8 != 3) {
                if (b8 == 4 || b8 == 6) {
                    return b9 == 1 ? "ACK" : f4618c[b9];
                }
                if (b8 != 7 && b8 != 8) {
                    String[] strArr = f4617b;
                    String str = b9 < strArr.length ? strArr[b9] : f4618c[b9];
                    return (b8 != 5 || (b9 & 4) == 0) ? (b8 != 0 || (b9 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f4618c[b9];
        }

        public static String b(boolean z7, int i8, int i9, byte b8, byte b9) {
            String[] strArr = f4616a;
            return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", z7 ? "<<" : ">>", Integer.valueOf(i8), Integer.valueOf(i9), b8 < strArr.length ? strArr[b8] : String.format("0x%02x", Byte.valueOf(b8)), a(b8, b9));
        }
    }

    public static final class c implements J4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2813f f4619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f4620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.a f4622d;

        public c(InterfaceC2813f interfaceC2813f, int i8, boolean z7) {
            this.f4619a = interfaceC2813f;
            this.f4621c = z7;
            a aVar = new a(interfaceC2813f);
            this.f4620b = aVar;
            this.f4622d = new f.a(i8, aVar);
        }

        public final void B(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i8 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i8));
            }
            if (i9 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            r(aVar, i9);
        }

        @Override // J4.b
        public boolean C(b.a aVar) throws IOException {
            try {
                this.f4619a.n0(9L);
                int iM = g.m(this.f4619a);
                if (iM < 0 || iM > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM));
                }
                byte b8 = (byte) (this.f4619a.readByte() & 255);
                byte b9 = (byte) (this.f4619a.readByte() & 255);
                int i8 = this.f4619a.readInt() & Integer.MAX_VALUE;
                if (g.f4608a.isLoggable(Level.FINE)) {
                    g.f4608a.fine(b.b(true, i8, iM, b8, b9));
                }
                switch (b8) {
                    case 0:
                        a(aVar, iM, b9, i8);
                        return true;
                    case 1:
                        f(aVar, iM, b9, i8);
                        return true;
                    case 2:
                        B(aVar, iM, b9, i8);
                        return true;
                    case 3:
                        E(aVar, iM, b9, i8);
                        return true;
                    case 4:
                        K(aVar, iM, b9, i8);
                        return true;
                    case 5:
                        D(aVar, iM, b9, i8);
                        return true;
                    case 6:
                        n(aVar, iM, b9, i8);
                        return true;
                    case 7:
                        c(aVar, iM, b9, i8);
                        return true;
                    case 8:
                        M(aVar, iM, b9, i8);
                        return true;
                    default:
                        this.f4619a.skip(iM);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        public final void D(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i9 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s8 = (b8 & 8) != 0 ? (short) (this.f4619a.readByte() & 255) : (short) 0;
            aVar.n(i9, this.f4619a.readInt() & Integer.MAX_VALUE, e(g.l(i8 - 4, b8, s8), s8, b8, i9));
        }

        public final void E(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i8 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i8));
            }
            if (i9 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i10 = this.f4619a.readInt();
            J4.a aVarA = J4.a.a(i10);
            if (aVarA == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i10));
            }
            aVar.h(i9, aVarA);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void K(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i9 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b8 & 1) != 0) {
                if (i8 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.i();
                return;
            }
            if (i8 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i8));
            }
            i iVar = new i();
            for (int i10 = 0; i10 < i8; i10 += 6) {
                short s8 = this.f4619a.readShort();
                int i11 = this.f4619a.readInt();
                switch (s8) {
                    case 1:
                    case 6:
                        iVar.e(s8, 0, i11);
                        break;
                    case 2:
                        if (i11 != 0 && i11 != 1) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        iVar.e(s8, 0, i11);
                        break;
                    case 3:
                        s8 = 4;
                        iVar.e(s8, 0, i11);
                        break;
                    case 4:
                        if (i11 < 0) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s8 = 7;
                        iVar.e(s8, 0, i11);
                        break;
                        break;
                    case 5:
                        if (i11 < 16384 || i11 > 16777215) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i11));
                        }
                        iVar.e(s8, 0, i11);
                        break;
                    default:
                        break;
                }
            }
            aVar.o(false, iVar);
            if (iVar.b() >= 0) {
                this.f4622d.g(iVar.b());
            }
        }

        public final void M(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i8 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i8));
            }
            long j8 = ((long) this.f4619a.readInt()) & 2147483647L;
            if (j8 == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.b(i9, j8);
        }

        public final void a(b.a aVar, int i8, byte b8, int i9) throws IOException {
            boolean z7 = (b8 & 1) != 0;
            if ((b8 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s8 = (b8 & 8) != 0 ? (short) (this.f4619a.readByte() & 255) : (short) 0;
            aVar.m(z7, i9, this.f4619a, g.l(i8, b8, s8), i8);
            this.f4619a.skip(s8);
        }

        public final void c(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i8 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i8));
            }
            if (i9 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i10 = this.f4619a.readInt();
            int i11 = this.f4619a.readInt();
            int i12 = i8 - 8;
            J4.a aVarA = J4.a.a(i11);
            if (aVarA == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i11));
            }
            C2814g c2814gP = C2814g.f23649e;
            if (i12 > 0) {
                c2814gP = this.f4619a.p(i12);
            }
            aVar.j(i10, aVarA, c2814gP);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4619a.close();
        }

        public final List e(int i8, short s8, byte b8, int i9) throws IOException {
            a aVar = this.f4620b;
            aVar.f4614e = i8;
            aVar.f4611b = i8;
            aVar.f4615f = s8;
            aVar.f4612c = b8;
            aVar.f4613d = i9;
            this.f4622d.l();
            return this.f4622d.e();
        }

        public final void f(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i9 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z7 = (b8 & 1) != 0;
            short s8 = (b8 & 8) != 0 ? (short) (this.f4619a.readByte() & 255) : (short) 0;
            if ((b8 & 32) != 0) {
                r(aVar, i9);
                i8 -= 5;
            }
            aVar.l(false, z7, i9, -1, e(g.l(i8, b8, s8), s8, b8, i9), e.HTTP_20_HEADERS);
        }

        public final void n(b.a aVar, int i8, byte b8, int i9) throws IOException {
            if (i8 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i8));
            }
            if (i9 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.g((b8 & 1) != 0, this.f4619a.readInt(), this.f4619a.readInt());
        }

        public final void r(b.a aVar, int i8) {
            int i9 = this.f4619a.readInt();
            aVar.k(i8, i9 & Integer.MAX_VALUE, (this.f4619a.readByte() & 255) + 1, (Integer.MIN_VALUE & i9) != 0);
        }
    }

    public static final class d implements J4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2812e f4623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C2811d f4625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.b f4626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f4628f;

        public d(InterfaceC2812e interfaceC2812e, boolean z7) {
            this.f4623a = interfaceC2812e;
            this.f4624b = z7;
            C2811d c2811d = new C2811d();
            this.f4625c = c2811d;
            this.f4626d = new f.b(c2811d);
            this.f4627e = 16384;
        }

        @Override // J4.c
        public synchronized void F(boolean z7, int i8, C2811d c2811d, int i9) {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            a(i8, z7 ? (byte) 1 : (byte) 0, c2811d, i9);
        }

        public void a(int i8, byte b8, C2811d c2811d, int i9) {
            c(i8, i9, (byte) 0, b8);
            if (i9 > 0) {
                this.f4623a.H(c2811d, i9);
            }
        }

        @Override // J4.c
        public synchronized void b(int i8, long j8) {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            if (j8 == 0 || j8 > 2147483647L) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j8));
            }
            c(i8, 4, (byte) 8, (byte) 0);
            this.f4623a.s((int) j8);
            this.f4623a.flush();
        }

        public void c(int i8, int i9, byte b8, byte b9) {
            if (g.f4608a.isLoggable(Level.FINE)) {
                g.f4608a.fine(b.b(false, i8, i9, b8, b9));
            }
            int i10 = this.f4627e;
            if (i9 > i10) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i10), Integer.valueOf(i9));
            }
            if ((Integer.MIN_VALUE & i8) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i8));
            }
            g.n(this.f4623a, i9);
            this.f4623a.x(b8 & 255);
            this.f4623a.x(b9 & 255);
            this.f4623a.s(i8 & Integer.MAX_VALUE);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f4628f = true;
            this.f4623a.close();
        }

        public void e(boolean z7, int i8, List list) throws IOException {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            this.f4626d.e(list);
            long jS0 = this.f4625c.s0();
            int iMin = (int) Math.min(this.f4627e, jS0);
            long j8 = iMin;
            byte b8 = jS0 == j8 ? (byte) 4 : (byte) 0;
            if (z7) {
                b8 = (byte) (b8 | 1);
            }
            c(i8, iMin, (byte) 1, b8);
            this.f4623a.H(this.f4625c, j8);
            if (jS0 > j8) {
                f(i8, jS0 - j8);
            }
        }

        public final void f(int i8, long j8) {
            while (j8 > 0) {
                int iMin = (int) Math.min(this.f4627e, j8);
                long j9 = iMin;
                j8 -= j9;
                c(i8, iMin, (byte) 9, j8 == 0 ? (byte) 4 : (byte) 0);
                this.f4623a.H(this.f4625c, j9);
            }
        }

        @Override // J4.c
        public synchronized void flush() {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            this.f4623a.flush();
        }

        @Override // J4.c
        public synchronized void g(boolean z7, int i8, int i9) {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            c(0, 8, (byte) 6, z7 ? (byte) 1 : (byte) 0);
            this.f4623a.s(i8);
            this.f4623a.s(i9);
            this.f4623a.flush();
        }

        @Override // J4.c
        public synchronized void h(int i8, J4.a aVar) {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            if (aVar.f4569a == -1) {
                throw new IllegalArgumentException();
            }
            c(i8, 4, (byte) 3, (byte) 0);
            this.f4623a.s(aVar.f4569a);
            this.f4623a.flush();
        }

        @Override // J4.c
        public synchronized void h0(int i8, J4.a aVar, byte[] bArr) {
            try {
                if (this.f4628f) {
                    throw new IOException("closed");
                }
                if (aVar.f4569a == -1) {
                    throw g.j("errorCode.httpCode == -1", new Object[0]);
                }
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f4623a.s(i8);
                this.f4623a.s(aVar.f4569a);
                if (bArr.length > 0) {
                    this.f4623a.Z(bArr);
                }
                this.f4623a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // J4.c
        public int k0() {
            return this.f4627e;
        }

        @Override // J4.c
        public synchronized void l(i iVar) {
            try {
                if (this.f4628f) {
                    throw new IOException("closed");
                }
                int i8 = 0;
                c(0, iVar.f() * 6, (byte) 4, (byte) 0);
                while (i8 < 10) {
                    if (iVar.d(i8)) {
                        this.f4623a.q(i8 == 4 ? 3 : i8 == 7 ? 4 : i8);
                        this.f4623a.s(iVar.a(i8));
                    }
                    i8++;
                }
                this.f4623a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // J4.c
        public synchronized void l0(boolean z7, boolean z8, int i8, int i9, List list) {
            if (z8) {
                throw new UnsupportedOperationException();
            }
            if (this.f4628f) {
                throw new IOException("closed");
            }
            e(z7, i8, list);
        }

        @Override // J4.c
        public synchronized void m(i iVar) {
            if (this.f4628f) {
                throw new IOException("closed");
            }
            this.f4627e = iVar.c(this.f4627e);
            c(0, 0, (byte) 4, (byte) 1);
            this.f4623a.flush();
        }

        @Override // J4.c
        public synchronized void y() {
            try {
                if (this.f4628f) {
                    throw new IOException("closed");
                }
                if (this.f4624b) {
                    if (g.f4608a.isLoggable(Level.FINE)) {
                        g.f4608a.fine(String.format(">> CONNECTION %s", g.f4609b.r()));
                    }
                    this.f4623a.Z(g.f4609b.W());
                    this.f4623a.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException k(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    public static int l(int i8, byte b8, short s8) throws IOException {
        if ((b8 & 8) != 0) {
            i8--;
        }
        if (s8 <= i8) {
            return (short) (i8 - s8);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s8), Integer.valueOf(i8));
    }

    public static int m(InterfaceC2813f interfaceC2813f) {
        return (interfaceC2813f.readByte() & 255) | ((interfaceC2813f.readByte() & 255) << 16) | ((interfaceC2813f.readByte() & 255) << 8);
    }

    public static void n(InterfaceC2812e interfaceC2812e, int i8) {
        interfaceC2812e.x((i8 >>> 16) & 255);
        interfaceC2812e.x((i8 >>> 8) & 255);
        interfaceC2812e.x(i8 & 255);
    }

    @Override // J4.j
    public J4.b a(InterfaceC2813f interfaceC2813f, boolean z7) {
        return new c(interfaceC2813f, 4096, z7);
    }

    @Override // J4.j
    public J4.c b(InterfaceC2812e interfaceC2812e, boolean z7) {
        return new d(interfaceC2812e, z7);
    }

    public static final class a implements V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2813f f4610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f4612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public short f4615f;

        public a(InterfaceC2813f interfaceC2813f) {
            this.f4610a = interfaceC2813f;
        }

        public final void a() throws IOException {
            int i8 = this.f4613d;
            int iM = g.m(this.f4610a);
            this.f4614e = iM;
            this.f4611b = iM;
            byte b8 = (byte) (this.f4610a.readByte() & 255);
            this.f4612c = (byte) (this.f4610a.readByte() & 255);
            if (g.f4608a.isLoggable(Level.FINE)) {
                g.f4608a.fine(b.b(true, this.f4613d, this.f4611b, b8, this.f4612c));
            }
            int i9 = this.f4610a.readInt() & Integer.MAX_VALUE;
            this.f4613d = i9;
            if (b8 != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(b8));
            }
            if (i9 != i8) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // u7.V
        public long o0(C2811d c2811d, long j8) throws IOException {
            while (true) {
                int i8 = this.f4614e;
                if (i8 != 0) {
                    long jO0 = this.f4610a.o0(c2811d, Math.min(j8, i8));
                    if (jO0 == -1) {
                        return -1L;
                    }
                    this.f4614e -= (int) jO0;
                    return jO0;
                }
                this.f4610a.skip(this.f4615f);
                this.f4615f = (short) 0;
                if ((this.f4612c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
