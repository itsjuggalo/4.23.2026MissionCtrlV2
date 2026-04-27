package okhttp3.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k4.C2105D;
import w6.C2792e;
import w6.C2795h;
import w6.InterfaceC2794g;

/* JADX INFO: loaded from: classes2.dex */
final class WebSocketReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2794g f21133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameCallback f21134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2792e f21140i = new C2792e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C2792e f21141j = new C2792e();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f21142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C2792e.a f21143l;

    public interface FrameCallback {
        void a(C2795h c2795h);

        void b(String str);

        void c(C2795h c2795h);

        void d(C2795h c2795h);

        void e(int i7, String str);
    }

    public WebSocketReader(boolean z7, InterfaceC2794g interfaceC2794g, FrameCallback frameCallback) {
        if (interfaceC2794g == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.f21132a = z7;
        this.f21133b = interfaceC2794g;
        this.f21134c = frameCallback;
        this.f21142k = z7 ? null : new byte[4];
        this.f21143l = z7 ? null : new C2792e.a();
    }

    public void a() throws IOException {
        c();
        if (this.f21139h) {
            b();
        } else {
            e();
        }
    }

    public final void b() throws ProtocolException, EOFException {
        short s7;
        String strC0;
        long j7 = this.f21137f;
        if (j7 > 0) {
            this.f21133b.e0(this.f21140i, j7);
            if (!this.f21132a) {
                this.f21140i.y0(this.f21143l);
                this.f21143l.A(0L);
                WebSocketProtocol.b(this.f21143l, this.f21142k);
                this.f21143l.close();
            }
        }
        switch (this.f21136e) {
            case 8:
                long jE0 = this.f21140i.E0();
                if (jE0 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jE0 != 0) {
                    s7 = this.f21140i.readShort();
                    strC0 = this.f21140i.C0();
                    String strA = WebSocketProtocol.a(s7);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s7 = 1005;
                    strC0 = "";
                }
                this.f21134c.e(s7, strC0);
                this.f21135d = true;
                return;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                this.f21134c.a(this.f21140i.A0());
                return;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                this.f21134c.d(this.f21140i.A0());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f21136e));
        }
    }

    public final void c() throws IOException {
        if (this.f21135d) {
            throw new IOException("closed");
        }
        long jH = this.f21133b.f().h();
        this.f21133b.f().b();
        try {
            byte b7 = this.f21133b.readByte();
            this.f21133b.f().g(jH, TimeUnit.NANOSECONDS);
            this.f21136e = b7 & 15;
            boolean z7 = (b7 & 128) != 0;
            this.f21138g = z7;
            boolean z8 = (b7 & 8) != 0;
            this.f21139h = z8;
            if (z8 && !z7) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z9 = (b7 & 64) != 0;
            boolean z10 = (b7 & 32) != 0;
            boolean z11 = (b7 & 16) != 0;
            if (z9 || z10 || z11) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            byte b8 = this.f21133b.readByte();
            boolean z12 = (b8 & 128) != 0;
            if (z12 == this.f21132a) {
                throw new ProtocolException(this.f21132a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j7 = b8 & 127;
            this.f21137f = j7;
            if (j7 == 126) {
                this.f21137f = ((long) this.f21133b.readShort()) & 65535;
            } else if (j7 == 127) {
                long j8 = this.f21133b.readLong();
                this.f21137f = j8;
                if (j8 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f21137f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f21139h && this.f21137f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z12) {
                this.f21133b.readFully(this.f21142k);
            }
        } catch (Throwable th) {
            this.f21133b.f().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    public final void d() throws IOException {
        while (!this.f21135d) {
            long j7 = this.f21137f;
            if (j7 > 0) {
                this.f21133b.e0(this.f21141j, j7);
                if (!this.f21132a) {
                    this.f21141j.y0(this.f21143l);
                    this.f21143l.A(this.f21141j.E0() - this.f21137f);
                    WebSocketProtocol.b(this.f21143l, this.f21142k);
                    this.f21143l.close();
                }
            }
            if (this.f21138g) {
                return;
            }
            f();
            if (this.f21136e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f21136e));
            }
        }
        throw new IOException("closed");
    }

    public final void e() throws IOException {
        int i7 = this.f21136e;
        if (i7 != 1 && i7 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i7));
        }
        d();
        if (i7 == 1) {
            this.f21134c.b(this.f21141j.C0());
        } else {
            this.f21134c.c(this.f21141j.A0());
        }
    }

    public final void f() throws IOException {
        while (!this.f21135d) {
            c();
            if (!this.f21139h) {
                return;
            } else {
                b();
            }
        }
    }
}
