package h8;

import h8.q;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements q.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f11109f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f11110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f11111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f11112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f11113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q8.c f11114e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void d(EnumC0203b enumC0203b);

        void g(String str);

        void j(String str);

        void m(long j10, String str);

        void s(Map map);
    }

    /* JADX INFO: renamed from: h8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0203b {
        SERVER_RESET,
        OTHER
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public b(h8.c cVar, f fVar, String str, a aVar, String str2, String str3) {
        long j10 = f11109f;
        f11109f = 1 + j10;
        this.f11110a = fVar;
        this.f11112c = aVar;
        this.f11114e = new q8.c(cVar.f(), "Connection", "conn_" + j10);
        this.f11113d = c.REALTIME_CONNECTING;
        this.f11111b = new q(cVar, fVar, str, str3, this, str2);
    }

    @Override // h8.q.c
    public void a(Map map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.f11114e.f()) {
                    this.f11114e.b("Failed to parse server message: missing message type:" + map.toString(), new Object[0]);
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
            if (this.f11114e.f()) {
                this.f11114e.b("Ignoring unknown server message type: " + str, new Object[0]);
            }
        } catch (ClassCastException e10) {
            if (this.f11114e.f()) {
                this.f11114e.b("Failed to parse server message: " + e10.toString(), new Object[0]);
            }
            c();
        }
    }

    @Override // h8.q.c
    public void b(boolean z10) {
        this.f11111b = null;
        if (z10 || this.f11113d != c.REALTIME_CONNECTING) {
            if (this.f11114e.f()) {
                this.f11114e.b("Realtime connection lost", new Object[0]);
            }
        } else if (this.f11114e.f()) {
            this.f11114e.b("Realtime connection failed", new Object[0]);
        }
        c();
    }

    public void c() {
        d(EnumC0203b.OTHER);
    }

    public void d(EnumC0203b enumC0203b) {
        c cVar = this.f11113d;
        c cVar2 = c.REALTIME_DISCONNECTED;
        if (cVar != cVar2) {
            if (this.f11114e.f()) {
                this.f11114e.b("closing realtime connection", new Object[0]);
            }
            this.f11113d = cVar2;
            q qVar = this.f11111b;
            if (qVar != null) {
                qVar.k();
                this.f11111b = null;
            }
            this.f11112c.d(enumC0203b);
        }
    }

    public final void e(long j10, String str) {
        if (this.f11114e.f()) {
            this.f11114e.b("realtime connection established", new Object[0]);
        }
        this.f11113d = c.REALTIME_CONNECTED;
        this.f11112c.m(j10, str);
    }

    public final void f(String str) {
        if (this.f11114e.f()) {
            this.f11114e.b("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f11112c.j(str);
        c();
    }

    public final void g(Map map) {
        if (this.f11114e.f()) {
            this.f11114e.b("Got control message: " + map.toString(), new Object[0]);
        }
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.f11114e.f()) {
                    this.f11114e.b("Got invalid control message: " + map.toString(), new Object[0]);
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
            if (this.f11114e.f()) {
                this.f11114e.b("Ignoring unknown control message: " + str, new Object[0]);
            }
        } catch (ClassCastException e10) {
            if (this.f11114e.f()) {
                this.f11114e.b("Failed to parse control message: " + e10.toString(), new Object[0]);
            }
            c();
        }
    }

    public final void h(Map map) {
        if (this.f11114e.f()) {
            this.f11114e.b("received data message: " + map.toString(), new Object[0]);
        }
        this.f11112c.s(map);
    }

    public final void i(Map map) {
        long jLongValue = ((Long) map.get("ts")).longValue();
        this.f11112c.g((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.f11113d == c.REALTIME_CONNECTING) {
            this.f11111b.y();
            e(jLongValue, str);
        }
    }

    public final void j(String str) {
        if (this.f11114e.f()) {
            this.f11114e.b("Got a reset; killing connection to " + this.f11110a.b() + "; Updating internalHost to " + str, new Object[0]);
        }
        this.f11112c.g(str);
        d(EnumC0203b.SERVER_RESET);
    }

    public void k() {
        if (this.f11114e.f()) {
            this.f11114e.b("Opening a connection", new Object[0]);
        }
        this.f11111b.t();
    }

    public final void l(Map map, boolean z10) {
        if (this.f11113d != c.REALTIME_CONNECTED) {
            this.f11114e.b("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z10) {
            this.f11114e.b("Sending data (contents hidden)", new Object[0]);
        } else {
            this.f11114e.b("Sending data: %s", map);
        }
        this.f11111b.v(map);
    }

    public void m(Map map, boolean z10) {
        HashMap map2 = new HashMap();
        map2.put("t", "d");
        map2.put("d", map);
        l(map2, z10);
    }
}
