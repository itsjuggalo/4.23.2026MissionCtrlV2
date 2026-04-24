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
    private static final com.amazon.a.a.o.c f9806a = new com.amazon.a.a.o.c("CommandServiceClient");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9807b = "com.amazon.venezia.service.command.CommandServiceImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9808c = "com.amazon.venezia.CommandService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amazon.d.a.d f9809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9810e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f9813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private b f9814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f9815j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<c> f9811f = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<com.amazon.d.a.d> f9812g = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ServiceConnection f9816k = new ServiceConnection() { // from class: com.amazon.a.a.n.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.f9806a.a("onServiceConnected");
            d.this.f9812g.add(d.a.a(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.f9806a.a("onServiceDisconnected!!!");
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.amazon.d.a.i f9817l = new i.a() { // from class: com.amazon.a.a.n.a.d.2
        @Override // com.amazon.d.a.i
        public void a(j jVar) {
            d.this.f9811f.add(new c(jVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.h hVar) {
            d.this.f9811f.add(new c(hVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.f fVar) {
            d.this.f9811f.add(new c(fVar));
        }

        @Override // com.amazon.d.a.i
        public void a(com.amazon.d.a.g gVar) {
            d.this.f9811f.add(new c(gVar));
        }
    };

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f9823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9824c;
    }

    private boolean d() {
        return this.f9809d != null;
    }

    private void e() throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.amazon.a.a.o.c cVar = f9806a;
        cVar.a("Binding Service!!!");
        Intent intentF = f();
        if (!a(this.f9813h, intentF)) {
            throw new com.amazon.a.a.n.a.a.c();
        }
        cVar.a("Found service on one or more packages");
        Intent intentA = a(intentF);
        String packageName = intentA.getComponent().getPackageName();
        cVar.a("Attempting to bind to service on " + packageName);
        if (!this.f9813h.bindService(intentA, this.f9816k, 1)) {
            throw new com.amazon.a.a.n.a.a.b();
        }
        try {
            cVar.a("Blocking while service is being bound!!");
            this.f9809d = this.f9812g.take();
            cVar.a("service bound, returning!!");
            if (com.amazon.a.a.o.c.f9994a) {
                cVar.a("Kiwi.BindService Time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            this.f9815j.a(com.amazon.a.a.m.c.f9770f, packageName);
            this.f9810e = packageName;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new com.amazon.a.a.n.a.a.b();
        }
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.setAction(f9808c);
        f9806a.a("Created intent with  action  com.amazon.venezia.CommandService");
        return intent;
    }

    private c g() {
        try {
            com.amazon.a.a.o.c cVar = f9806a;
            cVar.a("Blocking for result from service");
            c cVarTake = this.f9811f.take();
            cVar.a("Received result from service");
            return cVarTake;
        } catch (InterruptedException unused) {
            f9806a.a("TaskThread interrupted, returning null result");
            return null;
        }
    }

    private c b(com.amazon.d.a.c cVar) {
        this.f9815j.a(com.amazon.a.a.m.c.f9771g, cVar.b());
        this.f9809d.a(cVar, this.f9817l);
        return g();
    }

    public c a(com.amazon.d.a.c cVar) throws com.amazon.a.a.n.a.a.c, com.amazon.a.a.n.a.a.b {
        a aVar = new a();
        aVar.f9822a = 6;
        aVar.f9824c = 100L;
        while (true) {
            try {
                if (!d()) {
                    e();
                }
                return b(cVar);
            } catch (com.amazon.a.a.n.a.a.b e7) {
                a(e7, aVar);
                if (!aVar.f9823b) {
                    throw e7;
                }
            } catch (com.amazon.a.a.n.a.a.c e8) {
                a(e8, aVar);
                if (!aVar.f9823b) {
                    throw e8;
                }
            }
        }
    }

    public void b() {
        com.amazon.a.a.o.c cVar = f9806a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finishing CommandServiceClient, unbinding service: ");
        sb.append(this.f9809d != null);
        cVar.a(sb.toString());
        if (this.f9809d != null) {
            this.f9813h.unbindService(this.f9816k);
            this.f9809d = null;
        }
    }

    private boolean b(String str) {
        f9806a.a("isPackageSignatureTrusted " + str);
        return this.f9814i.a(str, i.f9873a);
    }

    public static void a(com.amazon.a.a.d.b bVar, a aVar) {
        com.amazon.a.a.o.c cVar = f9806a;
        cVar.b("CommandServiceException happened, retriesLeft=" + aVar.f9822a, bVar);
        int i7 = aVar.f9822a;
        if (i7 == 0) {
            aVar.f9823b = false;
            return;
        }
        aVar.f9822a = i7 - 1;
        aVar.f9823b = true;
        try {
            cVar.a("Sleeping for " + aVar.f9824c + " ms");
            Thread.sleep(aVar.f9824c);
        } catch (InterruptedException unused) {
            aVar.f9823b = false;
        }
        aVar.f9824c *= 2;
    }

    public String a() {
        return this.f9810e;
    }

    private boolean a(Context context, Intent intent) {
        return context.getPackageManager().resolveService(intent, 64) != null;
    }

    private Intent a(String str) {
        Intent intent = new Intent();
        intent.setAction(f9808c);
        intent.setClassName(str, f9807b);
        return intent;
    }

    private Intent a(Intent intent) throws com.amazon.a.a.n.a.a.c {
        if (this.f9810e != null) {
            f9806a.a("Using previously determined package " + this.f9810e);
            return a(this.f9810e);
        }
        com.amazon.a.a.o.c cVar = f9806a;
        cVar.a("No previously determined package found, checking for suitable package.");
        Intent intentA = a(this.f9813h.getPackageManager().queryIntentServices(intent, 64));
        if (intentA != null) {
            return intentA;
        }
        cVar.a("No app with valid signature was providing our service.");
        throw new com.amazon.a.a.n.a.a.c();
    }

    private Intent a(List<ResolveInfo> list) {
        int i7 = 0;
        String str = null;
        while (true) {
            try {
                if (i7 >= list.size()) {
                    i7 = -1;
                    break;
                }
                ResolveInfo resolveInfo = list.get(i7);
                String str2 = resolveInfo.serviceInfo.applicationInfo.packageName;
                com.amazon.a.a.o.c cVar = f9806a;
                cVar.a("Examining package " + str2);
                cVar.a("Priority is " + resolveInfo.filter.getPriority());
                cVar.a("Checking signature of package " + str2);
                if (b(str2)) {
                    cVar.a("Signature of package " + str2 + " is okay");
                    str = str2;
                    break;
                }
                cVar.a("Signature of package " + str2 + " is bad");
                i7++;
                str = str2;
            } catch (Exception e7) {
                f9806a.a("Caught exception " + e7);
            }
        }
        if (i7 > -1) {
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
