package f3;

import g3.C1785b;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import o3.C2460c;
import r3.AbstractC2675b;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f17507l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f17508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17509b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17510c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f17511d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C1785b f17512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f17513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f17514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScheduledFuture f17515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1746c f17516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScheduledExecutorService f17517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C2460c f17518k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.l();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f17508a != null) {
                q.this.f17508a.c("0");
                q.this.u();
            }
        }
    }

    public interface c {
        void a(Map map);

        void b(boolean z7);
    }

    public interface d {
        void c(String str);

        void close();

        void e();
    }

    public class e implements d, q3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q3.c f17521a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.f17515h.cancel(false);
                q.this.f17509b = true;
                if (q.this.f17518k.f()) {
                    q.this.f17518k.b("websocket opened", new Object[0]);
                }
                q.this.u();
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f17524a;

            public b(String str) {
                this.f17524a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                q.this.o(this.f17524a);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q.this.f17518k.f()) {
                    q.this.f17518k.b("closed", new Object[0]);
                }
                q.this.s();
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q3.e f17527a;

            public d(q3.e eVar) {
                this.f17527a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f17527a.getCause() == null || !(this.f17527a.getCause() instanceof EOFException)) {
                    q.this.f17518k.a("WebSocket error.", this.f17527a, new Object[0]);
                } else {
                    q.this.f17518k.b("WebSocket reached EOF.", new Object[0]);
                }
                q.this.s();
            }
        }

        public e(q3.c cVar) {
            this.f17521a = cVar;
            cVar.r(this);
        }

        @Override // q3.d
        public void a() {
            q.this.f17517j.execute(new a());
        }

        @Override // q3.d
        public void b(q3.e eVar) {
            q.this.f17517j.execute(new d(eVar));
        }

        @Override // f3.q.d
        public void c(String str) {
            this.f17521a.p(str);
        }

        @Override // f3.q.d
        public void close() {
            this.f17521a.c();
        }

        @Override // q3.d
        public void d(q3.g gVar) {
            String strA = gVar.a();
            if (q.this.f17518k.f()) {
                q.this.f17518k.b("ws message: " + strA, new Object[0]);
            }
            q.this.f17517j.execute(new b(strA));
        }

        @Override // f3.q.d
        public void e() {
            try {
                this.f17521a.e();
            } catch (q3.e e8) {
                if (q.this.f17518k.f()) {
                    q.this.f17518k.a("Error connecting", e8, new Object[0]);
                }
                g();
            }
        }

        @Override // q3.d
        public void f() {
            q.this.f17517j.execute(new c());
        }

        public final void g() {
            this.f17521a.c();
            try {
                this.f17521a.b();
            } catch (InterruptedException e8) {
                q.this.f17518k.c("Interrupted while shutting down websocket threads", e8);
            }
        }

        public /* synthetic */ e(q qVar, q3.c cVar, a aVar) {
            this(cVar);
        }
    }

    public q(C1746c c1746c, C1749f c1749f, String str, String str2, c cVar, String str3) {
        this.f17516i = c1746c;
        this.f17517j = c1746c.e();
        this.f17513f = cVar;
        long j8 = f17507l;
        f17507l = 1 + j8;
        this.f17518k = new C2460c(c1746c.f(), "WebSocket", "ws_" + j8);
        this.f17508a = m(c1749f, str, str2, str3);
    }

    public static String[] x(String str, int i8) {
        if (str.length() <= i8) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        while (i9 < str.length()) {
            int i10 = i9 + i8;
            arrayList.add(str.substring(i9, Math.min(i10, str.length())));
            i9 = i10;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void j(String str) {
        C2460c c2460c;
        StringBuilder sb;
        String str2;
        this.f17512e.a(str);
        long j8 = this.f17511d - 1;
        this.f17511d = j8;
        if (j8 == 0) {
            try {
                this.f17512e.r();
                Map mapA = AbstractC2675b.a(this.f17512e.toString());
                this.f17512e = null;
                if (this.f17518k.f()) {
                    this.f17518k.b("handleIncomingFrame complete frame: " + mapA, new Object[0]);
                }
                this.f17513f.a(mapA);
            } catch (IOException e8) {
                e = e8;
                c2460c = this.f17518k;
                sb = new StringBuilder();
                str2 = "Error parsing frame: ";
                sb.append(str2);
                sb.append(this.f17512e.toString());
                c2460c.c(sb.toString(), e);
                k();
                w();
            } catch (ClassCastException e9) {
                e = e9;
                c2460c = this.f17518k;
                sb = new StringBuilder();
                str2 = "Error parsing frame (cast error): ";
                sb.append(str2);
                sb.append(this.f17512e.toString());
                c2460c.c(sb.toString(), e);
                k();
                w();
            }
        }
    }

    public void k() {
        if (this.f17518k.f()) {
            this.f17518k.b("websocket is being closed", new Object[0]);
        }
        this.f17510c = true;
        this.f17508a.close();
        ScheduledFuture scheduledFuture = this.f17515h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = this.f17514g;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public final void l() {
        if (this.f17509b || this.f17510c) {
            return;
        }
        if (this.f17518k.f()) {
            this.f17518k.b("timed out on connect", new Object[0]);
        }
        this.f17508a.close();
    }

    public final d m(C1749f c1749f, String str, String str2, String str3) {
        if (str == null) {
            str = c1749f.b();
        }
        URI uriA = C1749f.a(str, c1749f.d(), c1749f.c(), str3);
        HashMap map = new HashMap();
        map.put("User-Agent", this.f17516i.h());
        map.put("X-Firebase-GMPID", this.f17516i.b());
        map.put("X-Firebase-AppCheck", str2);
        return new e(this, new q3.c(this.f17516i, uriA, null, map), null);
    }

    public final String n(String str) {
        if (str.length() <= 6) {
            try {
                int i8 = Integer.parseInt(str);
                if (i8 <= 0) {
                    return null;
                }
                p(i8);
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        p(1);
        return str;
    }

    public final void o(String str) {
        if (this.f17510c) {
            return;
        }
        u();
        if (!q() && (str = n(str)) == null) {
            return;
        }
        j(str);
    }

    public final void p(int i8) {
        this.f17511d = i8;
        this.f17512e = new C1785b();
        if (this.f17518k.f()) {
            this.f17518k.b("HandleNewFrameCount: " + this.f17511d, new Object[0]);
        }
    }

    public final boolean q() {
        return this.f17512e != null;
    }

    public final Runnable r() {
        return new b();
    }

    public final void s() {
        if (!this.f17510c) {
            if (this.f17518k.f()) {
                this.f17518k.b("closing itself", new Object[0]);
            }
            w();
        }
        this.f17508a = null;
        ScheduledFuture scheduledFuture = this.f17514g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void t() {
        this.f17508a.e();
        this.f17515h = this.f17517j.schedule(new a(), 30000L, TimeUnit.MILLISECONDS);
    }

    public final void u() {
        if (this.f17510c) {
            return;
        }
        ScheduledFuture scheduledFuture = this.f17514g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            if (this.f17518k.f()) {
                this.f17518k.b("Reset keepAlive. Remaining: " + this.f17514g.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
            }
        } else if (this.f17518k.f()) {
            this.f17518k.b("Reset keepAlive", new Object[0]);
        }
        this.f17514g = this.f17517j.schedule(r(), 45000L, TimeUnit.MILLISECONDS);
    }

    public void v(Map map) {
        u();
        try {
            String[] strArrX = x(AbstractC2675b.c(map), 16384);
            if (strArrX.length > 1) {
                this.f17508a.c("" + strArrX.length);
            }
            for (String str : strArrX) {
                this.f17508a.c(str);
            }
        } catch (IOException e8) {
            this.f17518k.c("Failed to serialize message: " + map.toString(), e8);
            w();
        }
    }

    public final void w() {
        this.f17510c = true;
        this.f17513f.b(this.f17509b);
    }

    public void y() {
    }
}
