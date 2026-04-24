package f3;

import f3.q;
import java.util.HashMap;
import java.util.Map;
import o3.C2460c;

/* JADX INFO: renamed from: f3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1745b implements q.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f17390f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1749f f17391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f17392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f17393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f17394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2460c f17395e;

    /* JADX INFO: renamed from: f3.b$a */
    public interface a {
        void l(String str);

        void n(String str);

        void o(EnumC0300b enumC0300b);

        void p(long j8, String str);

        void q(Map map);
    }

    /* JADX INFO: renamed from: f3.b$b, reason: collision with other inner class name */
    public enum EnumC0300b {
        SERVER_RESET,
        OTHER
    }

    /* JADX INFO: renamed from: f3.b$c */
    public enum c {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public C1745b(C1746c c1746c, C1749f c1749f, String str, a aVar, String str2, String str3) {
        long j8 = f17390f;
        f17390f = 1 + j8;
        this.f17391a = c1749f;
        this.f17393c = aVar;
        this.f17395e = new C2460c(c1746c.f(), "Connection", "conn_" + j8);
        this.f17394d = c.REALTIME_CONNECTING;
        this.f17392b = new q(c1746c, c1749f, str, str3, this, str2);
    }

    @Override // f3.q.c
    public void a(Map map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.f17395e.f()) {
                    this.f17395e.b("Failed to parse server message: missing message type:" + map.toString(), new Object[0]);
                }
                c();
                return;
            }
            if (str.equals("d")) {
                h((Map) map.get("d"));
                return;
            }
            if (str.equals("c")) {
                g((Map) map.get("d"));
                return;
            }
            if (this.f17395e.f()) {
                this.f17395e.b("Ignoring unknown server message type: " + str, new Object[0]);
            }
        } catch (ClassCastException e8) {
            if (this.f17395e.f()) {
                this.f17395e.b("Failed to parse server message: " + e8.toString(), new Object[0]);
            }
            c();
        }
    }

    @Override // f3.q.c
    public void b(boolean z7) {
        this.f17392b = null;
        if (z7 || this.f17394d != c.REALTIME_CONNECTING) {
            if (this.f17395e.f()) {
                this.f17395e.b("Realtime connection lost", new Object[0]);
            }
        } else if (this.f17395e.f()) {
            this.f17395e.b("Realtime connection failed", new Object[0]);
        }
        c();
    }

    public void c() {
        d(EnumC0300b.OTHER);
    }

    public void d(EnumC0300b enumC0300b) {
        c cVar = this.f17394d;
        c cVar2 = c.REALTIME_DISCONNECTED;
        if (cVar != cVar2) {
            if (this.f17395e.f()) {
                this.f17395e.b("closing realtime connection", new Object[0]);
            }
            this.f17394d = cVar2;
            q qVar = this.f17392b;
            if (qVar != null) {
                qVar.k();
                this.f17392b = null;
            }
            this.f17393c.o(enumC0300b);
        }
    }

    public final void e(long j8, String str) {
        if (this.f17395e.f()) {
            this.f17395e.b("realtime connection established", new Object[0]);
        }
        this.f17394d = c.REALTIME_CONNECTED;
        this.f17393c.p(j8, str);
    }

    public final void f(String str) {
        if (this.f17395e.f()) {
            this.f17395e.b("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f17393c.n(str);
        c();
    }

    public final void g(Map map) {
        if (this.f17395e.f()) {
            this.f17395e.b("Got control message: " + map.toString(), new Object[0]);
        }
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.f17395e.f()) {
                    this.f17395e.b("Got invalid control message: " + map.toString(), new Object[0]);
                }
                c();
                return;
            }
            if (str.equals("s")) {
                f((String) map.get("d"));
                return;
            }
            if (str.equals("r")) {
                j((String) map.get("d"));
                return;
            }
            if (str.equals("h")) {
                i((Map) map.get("d"));
                return;
            }
            if (this.f17395e.f()) {
                this.f17395e.b("Ignoring unknown control message: " + str, new Object[0]);
            }
        } catch (ClassCastException e8) {
            if (this.f17395e.f()) {
                this.f17395e.b("Failed to parse control message: " + e8.toString(), new Object[0]);
            }
            c();
        }
    }

    public final void h(Map map) {
        if (this.f17395e.f()) {
            this.f17395e.b("received data message: " + map.toString(), new Object[0]);
        }
        this.f17393c.q(map);
    }

    public final void i(Map map) {
        long jLongValue = ((Long) map.get("ts")).longValue();
        this.f17393c.l((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.f17394d == c.REALTIME_CONNECTING) {
            this.f17392b.y();
            e(jLongValue, str);
        }
    }

    public final void j(String str) {
        if (this.f17395e.f()) {
            this.f17395e.b("Got a reset; killing connection to " + this.f17391a.b() + "; Updating internalHost to " + str, new Object[0]);
        }
        this.f17393c.l(str);
        d(EnumC0300b.SERVER_RESET);
    }

    public void k() {
        if (this.f17395e.f()) {
            this.f17395e.b("Opening a connection", new Object[0]);
        }
        this.f17392b.t();
    }

    public final void l(Map map, boolean z7) {
        if (this.f17394d != c.REALTIME_CONNECTED) {
            this.f17395e.b("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z7) {
            this.f17395e.b("Sending data (contents hidden)", new Object[0]);
        } else {
            this.f17395e.b("Sending data: %s", map);
        }
        this.f17392b.v(map);
    }

    public void m(Map map, boolean z7) {
        HashMap map2 = new HashMap();
        map2.put("t", "d");
        map2.put("d", map);
        l(map2, z7);
    }
}
