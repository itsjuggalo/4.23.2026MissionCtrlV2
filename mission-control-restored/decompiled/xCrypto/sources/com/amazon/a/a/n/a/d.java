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
    private static final com.amazon.a.a.o.c f8621a = new com.amazon.a.a.o.c("CommandServiceClient");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8622b = "com.amazon.venezia.service.command.CommandServiceImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8623c = "com.amazon.venezia.CommandService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.d f8624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8625e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f8628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private b f8629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f8630j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<c> f8626f = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<com.amazon.d.a.d> f8627g = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ServiceConnection f8631k = new ServiceConnection() { // from class: com.amazon.a.a.n.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.f8621a.a("onServiceConnected");
            d.this.f8627g.add(d.a.a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.f8621a.a("onServiceDisconnected!!!");
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.amazon.d.a.i f8632l = new i.a() { // from class: com.amazon.a.a.n.a.d.2
        @Override // com.amazon.d.a.i
        public void a(j jVar) {
            d.this.f8626f.add(new c(jVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.h hVar) {
            d.this.f8626f.add(new c(hVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.f fVar) {
            d.this.f8626f.add(new c(fVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.g gVar) {
            d.this.f8626f.add(new c(gVar));
        }
    };

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f8638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8639c;
    }

    private boolean d() {
        return this.f8624d != null;
    }

    private void e() throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.amazon.a.a.o.c cVar = f8621a;
        cVar.a("Binding Service!!!");
        Intent intentF = f();
        if (!a(this.f8628h, intentF)) {
            throw new com.amazon.a.a.n.a.a.c();
        }
        cVar.a("Found service on one or more packages");
        Intent intentA = a(intentF);
        String packageName = intentA.getComponent().getPackageName();
        cVar.a("Attempting to bind to service on " + packageName);
        if (!this.f8628h.bindService(intentA, this.f8631k, 1)) {
            throw new com.amazon.a.a.n.a.a.b();
        }
        try {
            cVar.a("Blocking while service is being bound!!");
            this.f8624d = this.f8627g.take();
            cVar.a("service bound, returning!!");
            if (com.amazon.a.a.o.c.f8809a) {
                cVar.a("Kiwi.BindService Time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.f8630j.a(com.amazon.a.a.m.c.f8585f, packageName);
            this.f8625e = packageName;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new com.amazon.a.a.n.a.a.b();
        }
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(f8623c);
        f8621a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private c g() {
        try {
            com.amazon.a.a.o.c cVar = f8621a;
            cVar.a("Blocking for result from service");
            c cVarTake = this.f8626f.take();
            cVar.a("Received result from service");
            return cVarTake;
        } catch (InterruptedException unused) {
            f8621a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    private c b(com.amazon.d.a.c cVar) {
        this.f8630j.a(com.amazon.a.a.m.c.f8586g, cVar.b());
        this.f8624d.a(cVar, this.f8632l);
        return g();
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        a aVar = new a();
        aVar.f8637a = 6;
        aVar.f8639c = 100L;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (com.amazon.a.a.n.a.a.b e4) {
                a(e4, aVar);
                if (!aVar.f8638b) {
                    throw e4;
                }
            } catch (com.amazon.a.a.n.a.a.c e5) {
                a(e5, aVar);
                if (!aVar.f8638b) {
                    throw e5;
                }
            }
        }
    }

    public void b() {
        com.amazon.a.a.o.c cVar = f8621a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.f8624d != null);
        cVar.a(sb.toString());
        if (this.f8624d != null) {
            this.f8628h.unbindService(this.f8631k);
            this.f8624d = null;
        }
    }

    private boolean b(String str) {
        f8621a.a("isPackageSignatureTrusted " + str);
        return this.f8629i.a(str, i.f8688a);
    }

    public static void a(com.amazon.a.a.d.b bVar, a aVar) {
        com.amazon.a.a.o.c cVar = f8621a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.f8637a, bVar);
        int i4 = aVar.f8637a;
        if (i4 == 0) {
            aVar.f8638b = false;
            return;
        }
        aVar.f8637a = i4 - 1;
        aVar.f8638b = true;
        try {
            cVar.a("Sleeping for " + aVar.f8639c + " ms");
            Thread.sleep(aVar.f8639c);
        } catch (InterruptedException unused) {
            aVar.f8638b = false;
        }
        aVar.f8639c *= 2;
    }

    public String a() {
        return this.f8625e;
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(f8623c);
        intent.setClassName(str, f8622b);
        return intent;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.f8625e != null) {
            f8621a.a("Using previously determined package " + this.f8625e);
            return a(this.f8625e);
        }
        com.amazon.a.a.o.c cVar = f8621a;
        cVar.a("No previously determined package found, checking for suitable package.");
        Intent intentA = a(this.f8628h.getPackageManager().queryIntentServices(intent, 64));
        if (intentA != null) {
            return intentA;
        }
        cVar.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    private Intent a(List<ResolveInfo> list) {
        int i4 = 0;
        String str = null;
        while (true) {
            try {
                if (i4 >= list.size()) {
                    i4 = -1;
                    break;
                }
                ResolveInfo resolveInfo = list.get(i4);
                String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
                com.amazon.a.a.o.c cVar = f8621a;
                cVar.a("Examining package " + str2);
                cVar.a("Priority is " + resolveInfo.filter.getPriority());
                cVar.a("Checking signature of package " + str2);
                if (b(str2)) {
                    cVar.a("Signature of package " + str2 + " is okay");
                    str = str2;
                    break;
                }
                cVar.a("Signature of package " + str2 + " is bad");
                i4++;
                str = str2;
            } catch (Exception e4) {
                f8621a.a("Caught exception " + e4);
            }
        }
        if (i4 > -1) {
            return a(str);
        }
        return null;
    }

    public c a(com.amazon.d.a.a aVar) {
        aVar.a(null);
        return g();
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
}
