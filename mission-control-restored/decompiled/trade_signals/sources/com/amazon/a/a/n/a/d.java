package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import com.amazon.d.a.d;
import com.amazon.d.a.e;
import com.amazon.d.a.i;
import com.amazon.d.a.j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13917a = new com.amazon.a.a.o.c("CommandServiceClient");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13918b = "com.amazon.venezia.service.command.CommandServiceImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13919c = "com.amazon.venezia.CommandService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.d f13920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13921e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f13924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private b f13925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f13926j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<c> f13922f = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<com.amazon.d.a.d> f13923g = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ServiceConnection f13927k = new ServiceConnection() { // from class: com.amazon.a.a.n.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.f13917a.a("onServiceConnected");
            d.this.f13923g.add(d.a.a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.f13917a.a("onServiceDisconnected!!!");
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.amazon.d.a.i f13928l = new i.a() { // from class: com.amazon.a.a.n.a.d.2
        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.f fVar) {
            d.this.f13922f.add(new c(fVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.g gVar) {
            d.this.f13922f.add(new c(gVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.h hVar) {
            d.this.f13922f.add(new c(hVar));
        }

        @Override // com.amazon.d.a.i
        public void a(j jVar) {
            d.this.f13922f.add(new c(jVar));
        }
    };

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f13934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f13935c;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.f13921e != null) {
            f13917a.a("Using previously determined package " + this.f13921e);
            return a(this.f13921e);
        }
        com.amazon.a.a.o.c cVar = f13917a;
        cVar.a("No previously determined package found, checking for suitable package.");
        Intent intentA = a(this.f13924h.getPackageManager().queryIntentServices(intent, 64));
        if (intentA != null) {
            return intentA;
        }
        cVar.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    private c b(com.amazon.d.a.c cVar) {
        this.f13926j.a(com.amazon.a.a.m.c.f13882g, cVar.b());
        this.f13920d.a(cVar, this.f13928l);
        return g();
    }

    private boolean d() {
        return this.f13920d != null;
    }

    private void e() throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.amazon.a.a.o.c cVar = f13917a;
        cVar.a("Binding Service!!!");
        Intent intentF = f();
        if (!a(this.f13924h, intentF)) {
            throw new com.amazon.a.a.n.a.a.c();
        }
        cVar.a("Found service on one or more packages");
        Intent intentA = a(intentF);
        String packageName = intentA.getComponent().getPackageName();
        cVar.a("Attempting to bind to service on " + packageName);
        if (!this.f13924h.bindService(intentA, this.f13927k, 1)) {
            throw new com.amazon.a.a.n.a.a.b();
        }
        try {
            cVar.a("Blocking while service is being bound!!");
            this.f13920d = this.f13923g.take();
            cVar.a("service bound, returning!!");
            if (com.amazon.a.a.o.c.f14105a) {
                cVar.a("Kiwi.BindService Time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.f13926j.a(com.amazon.a.a.m.c.f13881f, packageName);
            this.f13921e = packageName;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new com.amazon.a.a.n.a.a.b();
        }
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(f13919c);
        f13917a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private c g() {
        try {
            com.amazon.a.a.o.c cVar = f13917a;
            cVar.a("Blocking for result from service");
            c cVarTake = this.f13922f.take();
            cVar.a("Received result from service");
            return cVarTake;
        } catch (InterruptedException unused) {
            f13917a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(f13919c);
        intent.setClassName(str, f13918b);
        return intent;
    }

    private Intent a(List<ResolveInfo> list) {
        int i8 = 0;
        String str = null;
        while (true) {
            try {
                if (i8 >= list.size()) {
                    i8 = -1;
                    break;
                }
                ResolveInfo resolveInfo = list.get(i8);
                String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
                com.amazon.a.a.o.c cVar = f13917a;
                cVar.a("Examining package " + str2);
                cVar.a("Priority is " + resolveInfo.filter.getPriority());
                cVar.a("Checking signature of package " + str2);
                if (b(str2)) {
                    cVar.a("Signature of package " + str2 + " is okay");
                    str = str2;
                    break;
                }
                cVar.a("Signature of package " + str2 + " is bad");
                i8++;
                str = str2;
            } catch (Exception e8) {
                f13917a.a("Caught exception " + e8);
            }
        }
        if (i8 > -1) {
            return a(str);
        }
        return null;
    }

    public void b() {
        com.amazon.a.a.o.c cVar = f13917a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.f13920d != null);
        cVar.a(sb.toString());
        if (this.f13920d != null) {
            this.f13924h.unbindService(this.f13927k);
            this.f13920d = null;
        }
    }

    private boolean b(String str) {
        f13917a.a("isPackageSignatureTrusted " + str);
        return this.f13925i.a(str, i.f13984a);
    }

    public c a(com.amazon.d.a.a aVar) {
        aVar.a(null);
        return g();
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        a aVar = new a();
        aVar.f13933a = 6;
        aVar.f13935c = 100L;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (com.amazon.a.a.n.a.a.b e8) {
                a(e8, aVar);
                if (!aVar.f13934b) {
                    throw e8;
                }
            } catch (com.amazon.a.a.n.a.a.c e9) {
                a(e9, aVar);
                if (!aVar.f13934b) {
                    throw e9;
                }
            }
        }
    }

    public c a(com.amazon.d.a.f fVar, final e eVar) {
        fVar.a(new e.a() { // from class: com.amazon.a.a.n.a.d.3
            @Override // com.amazon.d.a.e
            public String a() {
                return eVar.name();
            }

            @Override // com.amazon.d.a.e
            public Map b() {
                return null;
            }
        });
        return g();
    }

    public String a() {
        return this.f13921e;
    }

    public static void a(com.amazon.a.a.d.b bVar, a aVar) {
        com.amazon.a.a.o.c cVar = f13917a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.f13933a, bVar);
        int i8 = aVar.f13933a;
        if (i8 == 0) {
            aVar.f13934b = false;
            return;
        }
        aVar.f13933a = i8 - 1;
        aVar.f13934b = true;
        try {
            cVar.a("Sleeping for " + aVar.f13935c + " ms");
            Thread.sleep(aVar.f13935c);
        } catch (InterruptedException unused) {
            aVar.f13934b = false;
        }
        aVar.f13935c *= 2;
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }
}
