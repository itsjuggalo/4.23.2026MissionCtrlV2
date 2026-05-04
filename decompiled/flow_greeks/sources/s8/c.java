package s8;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicInteger f20067l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Charset f20068m = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ThreadFactory f20069n = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static s8.b f20070o = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f20071a = d.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Socket f20072b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s8.d f20073c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URI f20074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f20076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f20077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f20078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q8.c f20079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f20080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Thread f20081k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements s8.b {
        @Override // s8.b
        public void a(Thread thread, String str) {
            thread.setName(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.n();
        }
    }

    /* JADX INFO: renamed from: s8.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class C0352c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20083a;

        static {
            int[] iArr = new int[d.values().length];
            f20083a = iArr;
            try {
                iArr[d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20083a[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20083a[d.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20083a[d.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20083a[d.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public c(h8.c cVar, URI uri, String str, Map map) {
        int iIncrementAndGet = f20067l.incrementAndGet();
        this.f20080j = iIncrementAndGet;
        this.f20081k = j().newThread(new b());
        this.f20074d = uri;
        this.f20075e = cVar.g();
        this.f20079i = new q8.c(cVar.f(), "WebSocket", "sk_" + iIncrementAndGet);
        this.f20078h = new f(uri, str, map);
        this.f20076f = new h(this);
        this.f20077g = new i(this, "TubeSock", iIncrementAndGet);
    }

    public static s8.b i() {
        return f20070o;
    }

    public static ThreadFactory j() {
        return f20069n;
    }

    public void b() throws InterruptedException {
        if (this.f20077g.d().getState() != Thread.State.NEW) {
            this.f20077g.d().join();
        }
        h().join();
    }

    public synchronized void c() {
        int i10 = C0352c.f20083a[this.f20071a.ordinal()];
        if (i10 == 1) {
            this.f20071a = d.DISCONNECTED;
            return;
        }
        if (i10 == 2) {
            d();
            return;
        }
        if (i10 == 3) {
            q();
        } else if (i10 != 4) {
            if (i10 != 5) {
            }
        }
    }

    public final synchronized void d() {
        if (this.f20071a == d.DISCONNECTED) {
            return;
        }
        this.f20076f.h();
        this.f20077g.i();
        if (this.f20072b == null) {
            this.f20071a = d.DISCONNECTED;
            this.f20073c.e();
            return;
        }
        try {
            this.f20072b.close();
        } catch (Exception e10) {
            this.f20073c.c(new e("Failed to close", e10));
        }
        this.f20071a = d.DISCONNECTED;
        this.f20073c.e();
        return;
    }

    public synchronized void e() {
        if (this.f20071a != d.NONE) {
            this.f20073c.c(new e("connect() already called"));
            c();
            return;
        }
        i().a(h(), "TubeSockReader-" + this.f20080j);
        this.f20071a = d.CONNECTING;
        h().start();
    }

    public final Socket f() {
        String scheme = this.f20074d.getScheme();
        String host = this.f20074d.getHost();
        int port = this.f20074d.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e10) {
                throw new e("unknown host: " + host, e10);
            } catch (IOException e11) {
                throw new e("error while creating socket to " + this.f20074d, e11);
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
            if (this.f20075e != null) {
                sSLSessionCache = new SSLSessionCache(new File(this.f20075e));
            }
        } catch (IOException e12) {
            this.f20079i.a("Failed to initialize SSL session cache", e12, new Object[0]);
        }
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
            if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new e("Error while verifying secure socket to " + this.f20074d);
        } catch (UnknownHostException e13) {
            throw new e("unknown host: " + host, e13);
        } catch (IOException e14) {
            throw new e("error while creating secure socket to " + this.f20074d, e14);
        }
    }

    public s8.d g() {
        return this.f20073c;
    }

    public Thread h() {
        return this.f20081k;
    }

    public void k(e eVar) {
        this.f20073c.c(eVar);
        if (this.f20071a == d.CONNECTED) {
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
        try {
            try {
                Socket socketF = f();
                synchronized (this) {
                    this.f20072b = socketF;
                    if (this.f20071a == d.DISCONNECTED) {
                        try {
                            this.f20072b.close();
                            this.f20072b = null;
                            return;
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        }
                    }
                    DataInputStream dataInputStream = new DataInputStream(socketF.getInputStream());
                    OutputStream outputStream = socketF.getOutputStream();
                    outputStream.write(this.f20078h.c());
                    byte[] bArr = new byte[1000];
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    int i10 = 0;
                    while (!z10) {
                        int i11 = dataInputStream.read();
                        if (i11 == -1) {
                            throw new e("Connection closed before handshake was complete");
                        }
                        bArr[i10] = (byte) i11;
                        int i12 = i10 + 1;
                        if (bArr[i10] == 10 && bArr[i10 - 1] == 13) {
                            String str = new String(bArr, f20068m);
                            if (str.trim().equals("")) {
                                z10 = true;
                            } else {
                                arrayList.add(str.trim());
                            }
                            bArr = new byte[1000];
                            i10 = 0;
                        } else {
                            if (i12 == 1000) {
                                throw new e("Unexpected long line in handshake: " + new String(bArr, f20068m));
                            }
                            i10 = i12;
                        }
                    }
                    this.f20078h.f((String) arrayList.get(0));
                    arrayList.remove(0);
                    HashMap map = new HashMap();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String[] strArrSplit = ((String) it.next()).split(": ", 2);
                        String str2 = strArrSplit[0];
                        Locale locale = Locale.US;
                        map.put(str2.toLowerCase(locale), strArrSplit[1].toLowerCase(locale));
                    }
                    this.f20078h.e(map);
                    this.f20077g.h(outputStream);
                    this.f20076f.g(dataInputStream);
                    this.f20071a = d.CONNECTED;
                    this.f20077g.d().start();
                    this.f20073c.a();
                    this.f20076f.f();
                }
            } finally {
                c();
            }
        } catch (e e11) {
            this.f20073c.c(e11);
        } catch (Throwable th) {
            this.f20073c.c(new e("error while connecting: " + th.getMessage(), th));
        }
    }

    public final synchronized void o(byte b10, byte[] bArr) {
        if (this.f20071a != d.CONNECTED) {
            this.f20073c.c(new e("error while sending data: not connected"));
        } else {
            try {
                this.f20077g.g(b10, true, bArr);
            } catch (IOException e10) {
                this.f20073c.c(new e("Failed to send frame", e10));
                c();
            }
        }
    }

    public synchronized void p(String str) {
        o((byte) 1, str.getBytes(f20068m));
    }

    public final void q() {
        try {
            this.f20071a = d.DISCONNECTING;
            this.f20077g.i();
            this.f20077g.g((byte) 8, true, new byte[0]);
        } catch (IOException e10) {
            this.f20073c.c(new e("Failed to send close frame", e10));
        }
    }

    public void r(s8.d dVar) {
        this.f20073c = dVar;
    }
}
