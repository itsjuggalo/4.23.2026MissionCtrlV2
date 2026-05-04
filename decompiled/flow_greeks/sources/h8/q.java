package h8;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f11218l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f11219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11220b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11221c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11222d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i8.b f11223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f11224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f11225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledFuture f11226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h8.c f11227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScheduledExecutorService f11228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q8.c f11229k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f11219a != null) {
                q.this.f11219a.b("0");
                q.this.u();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        void a(Map map);

        void b(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void b(String str);

        void close();

        void d();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements d, s8.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s8.c f11232a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.f11226h.cancel(false);
                q.this.f11220b = true;
                if (q.this.f11229k.f()) {
                    q.this.f11229k.b("websocket opened", new Object[0]);
                }
                q.this.u();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f11235a;

            public b(String str) {
                this.f11235a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.o(this.f11235a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q.this.f11229k.f()) {
                    q.this.f11229k.b("closed", new Object[0]);
                }
                q.this.s();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s8.e f11238a;

            public d(s8.e eVar) {
                this.f11238a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f11238a.getCause() == null || !(this.f11238a.getCause() instanceof EOFException)) {
                    q.this.f11229k.a("WebSocket error.", this.f11238a, new Object[0]);
                } else {
                    q.this.f11229k.b("WebSocket reached EOF.", new Object[0]);
                }
                q.this.s();
            }
        }

        public /* synthetic */ e(q qVar, s8.c cVar, a aVar) {
            this(cVar);
        }

        @Override // s8.d
        public void a() {
            q.this.f11228j.execute(new a());
        }

        @Override // h8.q.d
        public void b(String str) {
            this.f11232a.p(str);
        }

        @Override // s8.d
        public void c(s8.e eVar) {
            q.this.f11228j.execute(new d(eVar));
        }

        @Override // h8.q.d
        public void close() {
            this.f11232a.c();
        }

        @Override // h8.q.d
        public void d() {
            try {
                this.f11232a.e();
            } catch (s8.e e10) {
                if (q.this.f11229k.f()) {
                    q.this.f11229k.a("Error connecting", e10, new Object[0]);
                }
                g();
            }
        }

        @Override // s8.d
        public void e() {
            q.this.f11228j.execute(new c());
        }

        @Override // s8.d
        public void f(s8.g gVar) {
            String strA = gVar.a();
            if (q.this.f11229k.f()) {
                q.this.f11229k.b("ws message: " + strA, new Object[0]);
            }
            q.this.f11228j.execute(new b(strA));
        }

        public final void g() {
            this.f11232a.c();
            try {
                this.f11232a.b();
            } catch (InterruptedException e10) {
                q.this.f11229k.c("Interrupted while shutting down websocket threads", e10);
            }
        }

        public e(s8.c cVar) {
            this.f11232a = cVar;
            cVar.r(this);
        }
    }

    public q(h8.c cVar, f fVar, String str, String str2, c cVar2, String str3) {
        this.f11227i = cVar;
        this.f11228j = cVar.e();
        this.f11224f = cVar2;
        long j10 = f11218l;
        f11218l = 1 + j10;
        this.f11229k = new q8.c(cVar.f(), "WebSocket", "ws_" + j10);
        this.f11219a = m(fVar, str, str2, str3);
    }

    public static String[] x(String str, int i10) {
        if (str.length() <= i10) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < str.length()) {
            int i12 = i11 + i10;
            arrayList.add(str.substring(i11, Math.min(i12, str.length())));
            i11 = i12;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void j(String str) {
        this.f11223e.b(str);
        long j10 = this.f11222d - 1;
        this.f11222d = j10;
        if (j10 == 0) {
            try {
                this.f11223e.C();
                Map mapA = t8.b.a(this.f11223e.toString());
                this.f11223e = null;
                if (this.f11229k.f()) {
                    this.f11229k.b("handleIncomingFrame complete frame: " + mapA, new Object[0]);
                }
                this.f11224f.a(mapA);
            } catch (IOException e10) {
                this.f11229k.c("Error parsing frame: " + this.f11223e.toString(), e10);
                k();
                w();
            } catch (ClassCastException e11) {
                this.f11229k.c("Error parsing frame (cast error): " + this.f11223e.toString(), e11);
                k();
                w();
            }
        }
    }

    public void k() {
        if (this.f11229k.f()) {
            this.f11229k.b("websocket is being closed", new Object[0]);
        }
        this.f11221c = true;
        this.f11219a.close();
        ScheduledFuture scheduledFuture = this.f11226h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = this.f11225g;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public final void l() {
        if (this.f11220b || this.f11221c) {
            return;
        }
        if (this.f11229k.f()) {
            this.f11229k.b("timed out on connect", new Object[0]);
        }
        this.f11219a.close();
    }

    public final d m(f fVar, String str, String str2, String str3) {
        if (str == null) {
            str = fVar.b();
        }
        URI uriA = f.a(str, fVar.d(), fVar.c(), str3);
        HashMap map = new HashMap();
        map.put("User-Agent", this.f11227i.h());
        map.put("X-Firebase-GMPID", this.f11227i.b());
        map.put("X-Firebase-AppCheck", str2);
        return new e(this, new s8.c(this.f11227i, uriA, null, map), null);
    }

    public final String n(String str) {
        if (str.length() <= 6) {
            try {
                int i10 = Integer.parseInt(str);
                if (i10 <= 0) {
                    return null;
                }
                p(i10);
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        p(1);
        return str;
    }

    public final void o(String str) {
        if (this.f11221c) {
            return;
        }
        u();
        if (q()) {
            j(str);
            return;
        }
        String strN = n(str);
        if (strN != null) {
            j(strN);
        }
    }

    public final void p(int i10) {
        this.f11222d = i10;
        this.f11223e = new i8.b();
        if (this.f11229k.f()) {
            this.f11229k.b("HandleNewFrameCount: " + this.f11222d, new Object[0]);
        }
    }

    public final boolean q() {
        return this.f11223e != null;
    }

    public final Runnable r() {
        return new b();
    }

    public final void s() {
        if (!this.f11221c) {
            if (this.f11229k.f()) {
                this.f11229k.b("closing itself", new Object[0]);
            }
            w();
        }
        this.f11219a = null;
        ScheduledFuture scheduledFuture = this.f11225g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void t() {
        this.f11219a.d();
        this.f11226h = this.f11228j.schedule(new a(), HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    public final void u() {
        if (this.f11221c) {
            return;
        }
        ScheduledFuture scheduledFuture = this.f11225g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            if (this.f11229k.f()) {
                this.f11229k.b("Reset keepAlive. Remaining: " + this.f11225g.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
            }
        } else if (this.f11229k.f()) {
            this.f11229k.b("Reset keepAlive", new Object[0]);
        }
        this.f11225g = this.f11228j.schedule(r(), 45000L, TimeUnit.MILLISECONDS);
    }

    public void v(Map map) {
        u();
        try {
            String[] strArrX = x(t8.b.c(map), 16384);
            if (strArrX.length > 1) {
                this.f11219a.b("" + strArrX.length);
            }
            for (String str : strArrX) {
                this.f11219a.b(str);
            }
        } catch (IOException e10) {
            this.f11229k.c("Failed to serialize message: " + map.toString(), e10);
            w();
        }
    }

    public final void w() {
        this.f11221c = true;
        this.f11224f.b(this.f11220b);
    }

    public void y() {
    }
}
