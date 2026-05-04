package wb;

import com.google.android.gms.common.api.a;
import hh.t;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import wb.b;
import wb.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23853a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final hh.g f23854b = hh.g.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f23861a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f23862b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f23863c = new String[256];

        static {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = f23863c;
                if (i11 >= strArr.length) {
                    break;
                }
                strArr[i11] = String.format("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
                i11++;
            }
            String[] strArr2 = f23862b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i12 = iArr[0];
            strArr2[i12 | 8] = strArr2[i12] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i13 = 0; i13 < 3; i13++) {
                int i14 = iArr2[i13];
                int i15 = iArr[0];
                String[] strArr3 = f23862b;
                int i16 = i15 | i14;
                strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
                strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f23862b;
                if (i10 >= strArr4.length) {
                    return;
                }
                if (strArr4[i10] == null) {
                    strArr4[i10] = f23863c[i10];
                }
                i10++;
            }
        }

        public static String a(byte b10, byte b11) {
            if (b11 == 0) {
                return "";
            }
            if (b10 != 2 && b10 != 3) {
                if (b10 == 4 || b10 == 6) {
                    return b11 == 1 ? "ACK" : f23863c[b11];
                }
                if (b10 != 7 && b10 != 8) {
                    String[] strArr = f23862b;
                    String str = b11 < strArr.length ? strArr[b11] : f23863c[b11];
                    return (b10 != 5 || (b11 & 4) == 0) ? (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f23863c[b11];
        }

        public static String b(boolean z10, int i10, int i11, byte b10, byte b11) {
            String[] strArr = f23861a;
            return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), b10 < strArr.length ? strArr[b10] : String.format("0x%02x", Byte.valueOf(b10)), a(b10, b11));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements wb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hh.f f23864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f23865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f23866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.a f23867d;

        public c(hh.f fVar, int i10, boolean z10) {
            this.f23864a = fVar;
            this.f23866c = z10;
            a aVar = new a(fVar);
            this.f23865b = aVar;
            this.f23867d = new f.a(i10, aVar);
        }

        public final void C(b.a aVar, int i10) {
            int i11 = this.f23864a.readInt();
            aVar.m(i10, i11 & a.e.API_PRIORITY_OTHER, (this.f23864a.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
        }

        public final void E(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            C(aVar, i11);
        }

        public final void G(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s10 = (b10 & 8) != 0 ? (short) (this.f23864a.readByte() & 255) : (short) 0;
            aVar.n(i11, this.f23864a.readInt() & a.e.API_PRIORITY_OTHER, e(g.l(i10 - 4, b10, s10), s10, b10, i11));
        }

        public final void H(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i12 = this.f23864a.readInt();
            wb.a aVarA = wb.a.a(i12);
            if (aVarA == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
            }
            aVar.g(i11, aVarA);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void K(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b10 & 1) != 0) {
                if (i10 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.h();
                return;
            }
            if (i10 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            }
            i iVar = new i();
            for (int i12 = 0; i12 < i10; i12 += 6) {
                short s10 = this.f23864a.readShort();
                int i13 = this.f23864a.readInt();
                switch (s10) {
                    case 1:
                    case 6:
                        iVar.e(s10, 0, i13);
                        break;
                    case 2:
                        if (i13 != 0 && i13 != 1) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        iVar.e(s10, 0, i13);
                        break;
                    case 3:
                        s10 = 4;
                        iVar.e(s10, 0, i13);
                        break;
                    case 4:
                        if (i13 < 0) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s10 = 7;
                        iVar.e(s10, 0, i13);
                        break;
                        break;
                    case 5:
                        if (i13 < 16384 || i13 > 16777215) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i13));
                        }
                        iVar.e(s10, 0, i13);
                        break;
                    default:
                        break;
                }
            }
            aVar.k(false, iVar);
            if (iVar.b() >= 0) {
                this.f23867d.g(iVar.b());
            }
        }

        public final void N(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
            }
            long j10 = ((long) this.f23864a.readInt()) & 2147483647L;
            if (j10 == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.a(i11, j10);
        }

        public final void b(b.a aVar, int i10, byte b10, int i11) throws IOException {
            boolean z10 = (b10 & 1) != 0;
            if ((b10 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s10 = (b10 & 8) != 0 ? (short) (this.f23864a.readByte() & 255) : (short) 0;
            aVar.j(z10, i11, this.f23864a, g.l(i10, b10, s10), i10);
            this.f23864a.skip(s10);
        }

        public final void c(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i12 = this.f23864a.readInt();
            int i13 = this.f23864a.readInt();
            int i14 = i10 - 8;
            wb.a aVarA = wb.a.a(i13);
            if (aVarA == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
            }
            hh.g gVarK = hh.g.f11479e;
            if (i14 > 0) {
                gVarK = this.f23864a.k(i14);
            }
            aVar.l(i12, aVarA, gVarK);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f23864a.close();
        }

        public final List e(int i10, short s10, byte b10, int i11) throws IOException {
            a aVar = this.f23865b;
            aVar.f23859e = i10;
            aVar.f23856b = i10;
            aVar.f23860f = s10;
            aVar.f23857c = b10;
            aVar.f23858d = i11;
            this.f23867d.l();
            return this.f23867d.e();
        }

        @Override // wb.b
        public boolean l(b.a aVar) throws IOException {
            try {
                this.f23864a.V(9L);
                int iM = g.m(this.f23864a);
                if (iM < 0 || iM > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM));
                }
                byte b10 = (byte) (this.f23864a.readByte() & 255);
                byte b11 = (byte) (this.f23864a.readByte() & 255);
                int i10 = this.f23864a.readInt() & a.e.API_PRIORITY_OTHER;
                if (g.f23853a.isLoggable(Level.FINE)) {
                    g.f23853a.fine(b.b(true, i10, iM, b10, b11));
                }
                switch (b10) {
                    case 0:
                        b(aVar, iM, b11, i10);
                        return true;
                    case 1:
                        o(aVar, iM, b11, i10);
                        return true;
                    case 2:
                        E(aVar, iM, b11, i10);
                        return true;
                    case 3:
                        H(aVar, iM, b11, i10);
                        return true;
                    case 4:
                        K(aVar, iM, b11, i10);
                        return true;
                    case 5:
                        G(aVar, iM, b11, i10);
                        return true;
                    case 6:
                        u(aVar, iM, b11, i10);
                        return true;
                    case 7:
                        c(aVar, iM, b11, i10);
                        return true;
                    case 8:
                        N(aVar, iM, b11, i10);
                        return true;
                    default:
                        this.f23864a.skip(iM);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        public final void o(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z10 = (b10 & 1) != 0;
            short s10 = (b10 & 8) != 0 ? (short) (this.f23864a.readByte() & 255) : (short) 0;
            if ((b10 & 32) != 0) {
                C(aVar, i11);
                i10 -= 5;
            }
            aVar.i(false, z10, i11, -1, e(g.l(i10, b10, s10), s10, b10, i11), e.HTTP_20_HEADERS);
        }

        public final void u(b.a aVar, int i10, byte b10, int i11) throws IOException {
            if (i10 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.f((b10 & 1) != 0, this.f23864a.readInt(), this.f23864a.readInt());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements wb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hh.e f23868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f23869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final hh.d f23870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f.b f23871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23872e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f23873f;

        public d(hh.e eVar, boolean z10) {
            this.f23868a = eVar;
            this.f23869b = z10;
            hh.d dVar = new hh.d();
            this.f23870c = dVar;
            this.f23871d = new f.b(dVar);
            this.f23872e = 16384;
        }

        @Override // wb.c
        public int T() {
            return this.f23872e;
        }

        @Override // wb.c
        public synchronized void U(boolean z10, boolean z11, int i10, int i11, List list) {
            if (z11) {
                throw new UnsupportedOperationException();
            }
            if (this.f23873f) {
                throw new IOException("closed");
            }
            e(z10, i10, list);
        }

        @Override // wb.c
        public synchronized void X(i iVar) {
            try {
                if (this.f23873f) {
                    throw new IOException("closed");
                }
                int i10 = 0;
                c(0, iVar.f() * 6, (byte) 4, (byte) 0);
                while (i10 < 10) {
                    if (iVar.d(i10)) {
                        this.f23868a.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                        this.f23868a.writeInt(iVar.a(i10));
                    }
                    i10++;
                }
                this.f23868a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // wb.c
        public synchronized void a(int i10, long j10) {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            if (j10 == 0 || j10 > 2147483647L) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
            }
            c(i10, 4, (byte) 8, (byte) 0);
            this.f23868a.writeInt((int) j10);
            this.f23868a.flush();
        }

        public void b(int i10, byte b10, hh.d dVar, int i11) {
            c(i10, i11, (byte) 0, b10);
            if (i11 > 0) {
                this.f23868a.L(dVar, i11);
            }
        }

        public void c(int i10, int i11, byte b10, byte b11) {
            if (g.f23853a.isLoggable(Level.FINE)) {
                g.f23853a.fine(b.b(false, i10, i11, b10, b11));
            }
            int i12 = this.f23872e;
            if (i11 > i12) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            if ((Integer.MIN_VALUE & i10) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i10));
            }
            g.n(this.f23868a, i11);
            this.f23868a.writeByte(b10 & 255);
            this.f23868a.writeByte(b11 & 255);
            this.f23868a.writeInt(i10 & a.e.API_PRIORITY_OTHER);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f23873f = true;
            this.f23868a.close();
        }

        public void e(boolean z10, int i10, List list) throws IOException {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            this.f23871d.e(list);
            long size = this.f23870c.size();
            int iMin = (int) Math.min(this.f23872e, size);
            long j10 = iMin;
            byte b10 = size == j10 ? (byte) 4 : (byte) 0;
            if (z10) {
                b10 = (byte) (b10 | 1);
            }
            c(i10, iMin, (byte) 1, b10);
            this.f23868a.L(this.f23870c, j10);
            if (size > j10) {
                o(i10, size - j10);
            }
        }

        @Override // wb.c
        public synchronized void f(boolean z10, int i10, int i11) {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            c(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.f23868a.writeInt(i10);
            this.f23868a.writeInt(i11);
            this.f23868a.flush();
        }

        @Override // wb.c
        public synchronized void flush() {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            this.f23868a.flush();
        }

        @Override // wb.c
        public synchronized void g(int i10, wb.a aVar) {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            if (aVar.f23814a == -1) {
                throw new IllegalArgumentException();
            }
            c(i10, 4, (byte) 3, (byte) 0);
            this.f23868a.writeInt(aVar.f23814a);
            this.f23868a.flush();
        }

        @Override // wb.c
        public synchronized void j(boolean z10, int i10, hh.d dVar, int i11) {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            b(i10, z10 ? (byte) 1 : (byte) 0, dVar, i11);
        }

        @Override // wb.c
        public synchronized void m(int i10, wb.a aVar, byte[] bArr) {
            try {
                if (this.f23873f) {
                    throw new IOException("closed");
                }
                if (aVar.f23814a == -1) {
                    throw g.j("errorCode.httpCode == -1", new Object[0]);
                }
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f23868a.writeInt(i10);
                this.f23868a.writeInt(aVar.f23814a);
                if (bArr.length > 0) {
                    this.f23868a.write(bArr);
                }
                this.f23868a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final void o(int i10, long j10) {
            while (j10 > 0) {
                int iMin = (int) Math.min(this.f23872e, j10);
                long j11 = iMin;
                j10 -= j11;
                c(i10, iMin, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
                this.f23868a.L(this.f23870c, j11);
            }
        }

        @Override // wb.c
        public synchronized void r() {
            try {
                if (this.f23873f) {
                    throw new IOException("closed");
                }
                if (this.f23869b) {
                    if (g.f23853a.isLoggable(Level.FINE)) {
                        g.f23853a.fine(String.format(">> CONNECTION %s", g.f23854b.o()));
                    }
                    this.f23868a.write(g.f23854b.H());
                    this.f23868a.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // wb.c
        public synchronized void v(i iVar) {
            if (this.f23873f) {
                throw new IOException("closed");
            }
            this.f23872e = iVar.c(this.f23872e);
            c(0, 0, (byte) 4, (byte) 1);
            this.f23868a.flush();
        }
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException k(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    public static int l(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    public static int m(hh.f fVar) {
        return (fVar.readByte() & 255) | ((fVar.readByte() & 255) << 16) | ((fVar.readByte() & 255) << 8);
    }

    public static void n(hh.e eVar, int i10) {
        eVar.writeByte((i10 >>> 16) & 255);
        eVar.writeByte((i10 >>> 8) & 255);
        eVar.writeByte(i10 & 255);
    }

    @Override // wb.j
    public wb.c a(hh.e eVar, boolean z10) {
        return new d(eVar, z10);
    }

    @Override // wb.j
    public wb.b b(hh.f fVar, boolean z10) {
        return new c(fVar, 4096, z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hh.f f23855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f23857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f23858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public short f23860f;

        public a(hh.f fVar) {
            this.f23855a = fVar;
        }

        @Override // hh.t
        public long B(hh.d dVar, long j10) throws IOException {
            while (true) {
                int i10 = this.f23859e;
                if (i10 != 0) {
                    long jB = this.f23855a.B(dVar, Math.min(j10, i10));
                    if (jB == -1) {
                        return -1L;
                    }
                    this.f23859e -= (int) jB;
                    return jB;
                }
                this.f23855a.skip(this.f23860f);
                this.f23860f = (short) 0;
                if ((this.f23857c & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        public final void b() throws IOException {
            int i10 = this.f23858d;
            int iM = g.m(this.f23855a);
            this.f23859e = iM;
            this.f23856b = iM;
            byte b10 = (byte) (this.f23855a.readByte() & 255);
            this.f23857c = (byte) (this.f23855a.readByte() & 255);
            if (g.f23853a.isLoggable(Level.FINE)) {
                g.f23853a.fine(b.b(true, this.f23858d, this.f23856b, b10, this.f23857c));
            }
            int i11 = this.f23855a.readInt() & a.e.API_PRIORITY_OTHER;
            this.f23858d = i11;
            if (b10 != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
