package P2;

import O3.t;
import P2.b;
import P2.f;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3504a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O3.g f3505b = O3.g.g("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f3512a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f3513b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f3514c = new String[256];

        static {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr = f3514c;
                if (i5 >= strArr.length) {
                    break;
                }
                strArr[i5] = String.format("%8s", Integer.toBinaryString(i5)).replace(' ', '0');
                i5++;
            }
            String[] strArr2 = f3513b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i6 = iArr[0];
            strArr2[i6 | 8] = strArr2[i6] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = iArr2[i7];
                int i9 = iArr[0];
                String[] strArr3 = f3513b;
                int i10 = i9 | i8;
                strArr3[i10] = strArr3[i9] + '|' + strArr3[i8];
                strArr3[i10 | 8] = strArr3[i9] + '|' + strArr3[i8] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f3513b;
                if (i4 >= strArr4.length) {
                    return;
                }
                if (strArr4[i4] == null) {
                    strArr4[i4] = f3514c[i4];
                }
                i4++;
            }
        }

        public static String a(byte b4, byte b5) {
            if (b5 == 0) {
                return "";
            }
            if (b4 != 2 && b4 != 3) {
                if (b4 == 4 || b4 == 6) {
                    return b5 == 1 ? "ACK" : f3514c[b5];
                }
                if (b4 != 7 && b4 != 8) {
                    String[] strArr = f3513b;
                    String str = b5 < strArr.length ? strArr[b5] : f3514c[b5];
                    return (b4 != 5 || (b5 & 4) == 0) ? (b4 != 0 || (b5 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f3514c[b5];
        }

        public static String b(boolean z4, int i4, int i5, byte b4, byte b5) {
            String[] strArr = f3512a;
            return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", z4 ? "<<" : ">>", Integer.valueOf(i4), Integer.valueOf(i5), b4 < strArr.length ? strArr[b4] : String.format("0x%02x", Byte.valueOf(b4)), a(b4, b5));
        }
    }

    public static final class c implements P2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O3.f f3515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f3516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.a f3518d;

        public c(O3.f fVar, int i4, boolean z4) {
            this.f3515a = fVar;
            this.f3517c = z4;
            a aVar = new a(fVar);
            this.f3516b = aVar;
            this.f3518d = new f.a(i4, aVar);
        }

        public final void A(b.a aVar, int i4) {
            int i5 = this.f3515a.readInt();
            aVar.h(i4, i5 & Integer.MAX_VALUE, (this.f3515a.readByte() & 255) + 1, (Integer.MIN_VALUE & i5) != 0);
        }

        public final void E(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i4 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i4));
            }
            if (i5 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            A(aVar, i5);
        }

        public final void G(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i5 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s4 = (b4 & 8) != 0 ? (short) (this.f3515a.readByte() & 255) : (short) 0;
            aVar.j(i5, this.f3515a.readInt() & Integer.MAX_VALUE, g(g.l(i4 - 4, b4, s4), s4, b4, i5));
        }

        public final void J(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i4 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i4));
            }
            if (i5 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i6 = this.f3515a.readInt();
            P2.a aVarA = P2.a.a(i6);
            if (aVarA == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i6));
            }
            aVar.a(i5, aVarA);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void K(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i5 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b4 & 1) != 0) {
                if (i4 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.e();
                return;
            }
            if (i4 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i4));
            }
            i iVar = new i();
            for (int i6 = 0; i6 < i4; i6 += 6) {
                short s4 = this.f3515a.readShort();
                int i7 = this.f3515a.readInt();
                switch (s4) {
                    case 1:
                    case 6:
                        iVar.e(s4, 0, i7);
                        break;
                    case 2:
                        if (i7 != 0 && i7 != 1) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        iVar.e(s4, 0, i7);
                        break;
                    case 3:
                        s4 = 4;
                        iVar.e(s4, 0, i7);
                        break;
                    case 4:
                        if (i7 < 0) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s4 = 7;
                        iVar.e(s4, 0, i7);
                        break;
                        break;
                    case 5:
                        if (i7 < 16384 || i7 > 16777215) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i7));
                        }
                        iVar.e(s4, 0, i7);
                        break;
                    default:
                        break;
                }
            }
            aVar.d(false, iVar);
            if (iVar.b() >= 0) {
                this.f3518d.g(iVar.b());
            }
        }

        public final void P(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i4 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i4));
            }
            long j4 = ((long) this.f3515a.readInt()) & 2147483647L;
            if (j4 == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.b(i5, j4);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f3515a.close();
        }

        public final void e(b.a aVar, int i4, byte b4, int i5) throws IOException {
            boolean z4 = (b4 & 1) != 0;
            if ((b4 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s4 = (b4 & 8) != 0 ? (short) (this.f3515a.readByte() & 255) : (short) 0;
            aVar.i(z4, i5, this.f3515a, g.l(i4, b4, s4), i4);
            this.f3515a.skip(s4);
        }

        public final void f(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i4 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i4));
            }
            if (i5 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i6 = this.f3515a.readInt();
            int i7 = this.f3515a.readInt();
            int i8 = i4 - 8;
            P2.a aVarA = P2.a.a(i7);
            if (aVarA == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i7));
            }
            O3.g gVarJ = O3.g.f3331e;
            if (i8 > 0) {
                gVarJ = this.f3515a.j(i8);
            }
            aVar.g(i6, aVarA, gVarJ);
        }

        public final List g(int i4, short s4, byte b4, int i5) throws IOException {
            a aVar = this.f3516b;
            aVar.f3510e = i4;
            aVar.f3507b = i4;
            aVar.f3511f = s4;
            aVar.f3508c = b4;
            aVar.f3509d = i5;
            this.f3518d.l();
            return this.f3518d.e();
        }

        public final void p(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i5 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z4 = (b4 & 1) != 0;
            short s4 = (b4 & 8) != 0 ? (short) (this.f3515a.readByte() & 255) : (short) 0;
            if ((b4 & 32) != 0) {
                A(aVar, i5);
                i4 -= 5;
            }
            aVar.f(false, z4, i5, -1, g(g.l(i4, b4, s4), s4, b4, i5), e.HTTP_20_HEADERS);
        }

        @Override // P2.b
        public boolean w(b.a aVar) throws IOException {
            try {
                this.f3515a.Y(9L);
                int iM = g.m(this.f3515a);
                if (iM < 0 || iM > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM));
                }
                byte b4 = (byte) (this.f3515a.readByte() & 255);
                byte b5 = (byte) (this.f3515a.readByte() & 255);
                int i4 = this.f3515a.readInt() & Integer.MAX_VALUE;
                if (g.f3504a.isLoggable(Level.FINE)) {
                    g.f3504a.fine(b.b(true, i4, iM, b4, b5));
                }
                switch (b4) {
                    case 0:
                        e(aVar, iM, b5, i4);
                        return true;
                    case 1:
                        p(aVar, iM, b5, i4);
                        return true;
                    case 2:
                        E(aVar, iM, b5, i4);
                        return true;
                    case 3:
                        J(aVar, iM, b5, i4);
                        return true;
                    case 4:
                        K(aVar, iM, b5, i4);
                        return true;
                    case 5:
                        G(aVar, iM, b5, i4);
                        return true;
                    case 6:
                        x(aVar, iM, b5, i4);
                        return true;
                    case 7:
                        f(aVar, iM, b5, i4);
                        return true;
                    case 8:
                        P(aVar, iM, b5, i4);
                        return true;
                    default:
                        this.f3515a.skip(iM);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        public final void x(b.a aVar, int i4, byte b4, int i5) throws IOException {
            if (i4 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i4));
            }
            if (i5 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.c((b4 & 1) != 0, this.f3515a.readInt(), this.f3515a.readInt());
        }
    }

    public static final class d implements P2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O3.e f3519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final O3.d f3521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.b f3522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3523e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3524f;

        public d(O3.e eVar, boolean z4) {
            this.f3519a = eVar;
            this.f3520b = z4;
            O3.d dVar = new O3.d();
            this.f3521c = dVar;
            this.f3522d = new f.b(dVar);
            this.f3523e = 16384;
        }

        @Override // P2.c
        public synchronized void F(i iVar) {
            try {
                if (this.f3524f) {
                    throw new IOException("closed");
                }
                int i4 = 0;
                f(0, iVar.f() * 6, (byte) 4, (byte) 0);
                while (i4 < 10) {
                    if (iVar.d(i4)) {
                        this.f3519a.l(i4 == 4 ? 3 : i4 == 7 ? 4 : i4);
                        this.f3519a.m(iVar.a(i4));
                    }
                    i4++;
                }
                this.f3519a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // P2.c
        public synchronized void H(i iVar) {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            this.f3523e = iVar.c(this.f3523e);
            f(0, 0, (byte) 4, (byte) 1);
            this.f3519a.flush();
        }

        @Override // P2.c
        public synchronized void N(int i4, P2.a aVar, byte[] bArr) {
            try {
                if (this.f3524f) {
                    throw new IOException("closed");
                }
                if (aVar.f3465a == -1) {
                    throw g.j("errorCode.httpCode == -1", new Object[0]);
                }
                f(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f3519a.m(i4);
                this.f3519a.m(aVar.f3465a);
                if (bArr.length > 0) {
                    this.f3519a.M(bArr);
                }
                this.f3519a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // P2.c
        public int V() {
            return this.f3523e;
        }

        @Override // P2.c
        public synchronized void W(boolean z4, boolean z5, int i4, int i5, List list) {
            if (z5) {
                throw new UnsupportedOperationException();
            }
            if (this.f3524f) {
                throw new IOException("closed");
            }
            g(z4, i4, list);
        }

        @Override // P2.c
        public synchronized void X(boolean z4, int i4, O3.d dVar, int i5) {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            e(i4, z4 ? (byte) 1 : (byte) 0, dVar, i5);
        }

        @Override // P2.c
        public synchronized void a(int i4, P2.a aVar) {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            if (aVar.f3465a == -1) {
                throw new IllegalArgumentException();
            }
            f(i4, 4, (byte) 3, (byte) 0);
            this.f3519a.m(aVar.f3465a);
            this.f3519a.flush();
        }

        @Override // P2.c
        public synchronized void b(int i4, long j4) {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            if (j4 == 0 || j4 > 2147483647L) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
            }
            f(i4, 4, (byte) 8, (byte) 0);
            this.f3519a.m((int) j4);
            this.f3519a.flush();
        }

        @Override // P2.c
        public synchronized void c(boolean z4, int i4, int i5) {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            f(0, 8, (byte) 6, z4 ? (byte) 1 : (byte) 0);
            this.f3519a.m(i4);
            this.f3519a.m(i5);
            this.f3519a.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f3524f = true;
            this.f3519a.close();
        }

        public void e(int i4, byte b4, O3.d dVar, int i5) {
            f(i4, i5, (byte) 0, b4);
            if (i5 > 0) {
                this.f3519a.c0(dVar, i5);
            }
        }

        public void f(int i4, int i5, byte b4, byte b5) {
            if (g.f3504a.isLoggable(Level.FINE)) {
                g.f3504a.fine(b.b(false, i4, i5, b4, b5));
            }
            int i6 = this.f3523e;
            if (i5 > i6) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
            }
            if ((Integer.MIN_VALUE & i4) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i4));
            }
            g.n(this.f3519a, i5);
            this.f3519a.s(b4 & 255);
            this.f3519a.s(b5 & 255);
            this.f3519a.m(i4 & Integer.MAX_VALUE);
        }

        @Override // P2.c
        public synchronized void flush() {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            this.f3519a.flush();
        }

        public void g(boolean z4, int i4, List list) throws IOException {
            if (this.f3524f) {
                throw new IOException("closed");
            }
            this.f3522d.e(list);
            long jI0 = this.f3521c.i0();
            int iMin = (int) Math.min(this.f3523e, jI0);
            long j4 = iMin;
            byte b4 = jI0 == j4 ? (byte) 4 : (byte) 0;
            if (z4) {
                b4 = (byte) (b4 | 1);
            }
            f(i4, iMin, (byte) 1, b4);
            this.f3519a.c0(this.f3521c, j4);
            if (jI0 > j4) {
                p(i4, jI0 - j4);
            }
        }

        public final void p(int i4, long j4) {
            while (j4 > 0) {
                int iMin = (int) Math.min(this.f3523e, j4);
                long j5 = iMin;
                j4 -= j5;
                f(i4, iMin, (byte) 9, j4 == 0 ? (byte) 4 : (byte) 0);
                this.f3519a.c0(this.f3521c, j5);
            }
        }

        @Override // P2.c
        public synchronized void t() {
            try {
                if (this.f3524f) {
                    throw new IOException("closed");
                }
                if (this.f3520b) {
                    if (g.f3504a.isLoggable(Level.FINE)) {
                        g.f3504a.fine(String.format(">> CONNECTION %s", g.f3505b.n()));
                    }
                    this.f3519a.M(g.f3505b.y());
                    this.f3519a.flush();
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

    public static int l(int i4, byte b4, short s4) throws IOException {
        if ((b4 & 8) != 0) {
            i4--;
        }
        if (s4 <= i4) {
            return (short) (i4 - s4);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s4), Integer.valueOf(i4));
    }

    public static int m(O3.f fVar) {
        return (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
    }

    public static void n(O3.e eVar, int i4) {
        eVar.s((i4 >>> 16) & 255);
        eVar.s((i4 >>> 8) & 255);
        eVar.s(i4 & 255);
    }

    @Override // P2.j
    public P2.b a(O3.f fVar, boolean z4) {
        return new c(fVar, 4096, z4);
    }

    @Override // P2.j
    public P2.c b(O3.e eVar, boolean z4) {
        return new d(eVar, z4);
    }

    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O3.f f3506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f3508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3509d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3510e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public short f3511f;

        public a(O3.f fVar) {
            this.f3506a = fVar;
        }

        public final void e() throws IOException {
            int i4 = this.f3509d;
            int iM = g.m(this.f3506a);
            this.f3510e = iM;
            this.f3507b = iM;
            byte b4 = (byte) (this.f3506a.readByte() & 255);
            this.f3508c = (byte) (this.f3506a.readByte() & 255);
            if (g.f3504a.isLoggable(Level.FINE)) {
                g.f3504a.fine(b.b(true, this.f3509d, this.f3507b, b4, this.f3508c));
            }
            int i5 = this.f3506a.readInt() & Integer.MAX_VALUE;
            this.f3509d = i5;
            if (b4 != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(b4));
            }
            if (i5 != i4) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // O3.t
        public long v(O3.d dVar, long j4) throws IOException {
            while (true) {
                int i4 = this.f3510e;
                if (i4 != 0) {
                    long jV = this.f3506a.v(dVar, Math.min(j4, i4));
                    if (jV == -1) {
                        return -1L;
                    }
                    this.f3510e -= (int) jV;
                    return jV;
                }
                this.f3506a.skip(this.f3511f);
                this.f3511f = (short) 0;
                if ((this.f3508c & 4) != 0) {
                    return -1L;
                }
                e();
            }
        }

        @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
