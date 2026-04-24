package q3;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import f3.C1746c;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import o3.C2460c;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicInteger f22550l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Charset f22551m = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ThreadFactory f22552n = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static InterfaceC2632b f22553o = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f22554a = d.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Socket f22555b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q3.d f22556c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URI f22557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f22559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f22560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f22561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2460c f22562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f22563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Thread f22564k;

    public class a implements InterfaceC2632b {
        @Override // q3.InterfaceC2632b
        public void a(Thread thread, String str) {
            thread.setName(str);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.n();
        }
    }

    /* JADX INFO: renamed from: q3.c$c, reason: collision with other inner class name */
    public static /* synthetic */ class C0384c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22566a;

        static {
            int[] iArr = new int[d.values().length];
            f22566a = iArr;
            try {
                iArr[d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22566a[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22566a[d.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22566a[d.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22566a[d.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum d {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public c(C1746c c1746c, URI uri, String str, Map map) {
        int iIncrementAndGet = f22550l.incrementAndGet();
        this.f22563j = iIncrementAndGet;
        this.f22564k = j().newThread(new b());
        this.f22557d = uri;
        this.f22558e = c1746c.g();
        this.f22562i = new C2460c(c1746c.f(), "WebSocket", "sk_" + iIncrementAndGet);
        this.f22561h = new f(uri, str, map);
        this.f22559f = new h(this);
        this.f22560g = new i(this, "TubeSock", iIncrementAndGet);
    }

    public static InterfaceC2632b i() {
        return f22553o;
    }

    public static ThreadFactory j() {
        return f22552n;
    }

    public void b() throws InterruptedException {
        if (this.f22560g.d().getState() != Thread.State.NEW) {
            this.f22560g.d().join();
        }
        h().join();
    }

    public synchronized void c() {
        int i8 = C0384c.f22566a[this.f22554a.ordinal()];
        if (i8 == 1) {
            this.f22554a = d.DISCONNECTED;
            return;
        }
        if (i8 == 2) {
            d();
        } else if (i8 == 3) {
            q();
        } else if (i8 != 4) {
        }
    }

    public final synchronized void d() {
        if (this.f22554a == d.DISCONNECTED) {
            return;
        }
        this.f22559f.h();
        this.f22560g.i();
        if (this.f22555b == null) {
            this.f22554a = d.DISCONNECTED;
            this.f22556c.f();
            return;
        }
        try {
            this.f22555b.close();
        } catch (Exception e8) {
            this.f22556c.b(new e("Failed to close", e8));
        }
        this.f22554a = d.DISCONNECTED;
        this.f22556c.f();
        return;
    }

    public synchronized void e() {
        if (this.f22554a != d.NONE) {
            this.f22556c.b(new e("connect() already called"));
            c();
            return;
        }
        i().a(h(), "TubeSockReader-" + this.f22563j);
        this.f22554a = d.CONNECTING;
        h().start();
    }

    public final Socket f() {
        String scheme = this.f22557d.getScheme();
        String host = this.f22557d.getHost();
        int port = this.f22557d.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e8) {
                throw new e("unknown host: " + host, e8);
            } catch (IOException e9) {
                throw new e("error while creating socket to " + this.f22557d, e9);
            }
        }
        if (scheme == null || !scheme.equals("wss")) {
            throw new e("unsupported protocol: " + scheme);
        }
        if (port == -1) {
            port = 443;
        }
        SSLSessionCache sSLSessionCache = null;
        try {
            if (this.f22558e != null) {
                sSLSessionCache = new SSLSessionCache(new File(this.f22558e));
            }
        } catch (IOException e10) {
            this.f22562i.a("Failed to initialize SSL session cache", e10, new Object[0]);
        }
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new e("Error while verifying secure socket to " + this.f22557d);
        } catch (UnknownHostException e11) {
            throw new e("unknown host: " + host, e11);
        } catch (IOException e12) {
            throw new e("error while creating secure socket to " + this.f22557d, e12);
        }
    }

    public q3.d g() {
        return this.f22556c;
    }

    public Thread h() {
        return this.f22564k;
    }

    public void k(e eVar) {
        this.f22556c.b(eVar);
        if (this.f22554a == d.CONNECTED) {
            c();
        }
        d();
    }

    public void l() {
        d();
    }

    public synchronized void m(byte[] bArr) {
        o((byte) 10, bArr);
    }

    public final void n() {
        Socket socketF;
        try {
            try {
                socketF = f();
            } finally {
                c();
            }
        } catch (e e8) {
            this.f22556c.b(e8);
        } catch (Throwable th) {
            this.f22556c.b(new e("error while connecting: " + th.getMessage(), th));
        }
        synchronized (this) {
            this.f22555b = socketF;
            if (this.f22554a == d.DISCONNECTED) {
                try {
                    this.f22555b.close();
                    this.f22555b = null;
                    c();
                    return;
                } catch (IOException e9) {
                    throw new RuntimeException(e9);
                }
            }
            DataInputStream dataInputStream = new DataInputStream(socketF.getInputStream());
            OutputStream outputStream = socketF.getOutputStream();
            outputStream.write(this.f22561h.c());
            byte[] bArr = new byte[1000];
            ArrayList arrayList = new ArrayList();
            boolean z7 = false;
            int i8 = 0;
            while (!z7) {
                int i9 = dataInputStream.read();
                if (i9 == -1) {
                    throw new e("Connection closed before handshake was complete");
                }
                bArr[i8] = (byte) i9;
                int i10 = i8 + 1;
                if (bArr[i8] == 10 && bArr[i8 - 1] == 13) {
                    String str = new String(bArr, f22551m);
                    if (str.trim().equals("")) {
                        z7 = true;
                    } else {
                        arrayList.add(str.trim());
                    }
                    bArr = new byte[1000];
                    i8 = 0;
                } else {
                    if (i10 == 1000) {
                        throw new e("Unexpected long line in handshake: " + new String(bArr, f22551m));
                    }
                    i8 = i10;
                }
            }
            this.f22561h.f((String) arrayList.get(0));
            arrayList.remove(0);
            HashMap map = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split(": ", 2);
                String str2 = strArrSplit[0];
                Locale locale = Locale.US;
                map.put(str2.toLowerCase(locale), strArrSplit[1].toLowerCase(locale));
            }
            this.f22561h.e(map);
            this.f22560g.h(outputStream);
            this.f22559f.g(dataInputStream);
            this.f22554a = d.CONNECTED;
            this.f22560g.d().start();
            this.f22556c.a();
            this.f22559f.f();
            c();
        }
    }

    public final synchronized void o(byte b8, byte[] bArr) {
        if (this.f22554a != d.CONNECTED) {
            this.f22556c.b(new e("error while sending data: not connected"));
        } else {
            try {
                this.f22560g.g(b8, true, bArr);
            } catch (IOException e8) {
                this.f22556c.b(new e("Failed to send frame", e8));
                c();
            }
        }
    }

    public synchronized void p(String str) {
        o((byte) 1, str.getBytes(f22551m));
    }

    public final void q() {
        try {
            this.f22554a = d.DISCONNECTING;
            this.f22560g.i();
            this.f22560g.g((byte) 8, true, new byte[0]);
        } catch (IOException e8) {
            this.f22556c.b(new e("Failed to send close frame", e8));
        }
    }

    public void r(q3.d dVar) {
        this.f22556c = dVar;
    }
}
