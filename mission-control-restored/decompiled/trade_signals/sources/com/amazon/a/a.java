package com.amazon.a;

import android.app.Application;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.amazon.a.a.k.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f13619a = "ActivityName";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f13620b = "EventName";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final String f13621c = "Timestamp";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13622d = new com.amazon.a.a.o.c("AppstoreSDK");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.amazon.a.a.g.c f13623e = new com.amazon.a.a.g.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f13624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f13625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.l.b f13626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.c.f f13627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f13628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f13629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f13630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f13631m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b f13632n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.g.c f13633o;

    private a(Application application) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.amazon.a.a.o.c.f14105a) {
            f13622d.a("Starting initialization process for application: " + application.getPackageName());
        }
        b(application);
        if (com.amazon.a.a.o.c.f14105a) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            f13622d.a("AppstoreSDK.Constructor Time: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        }
    }

    public static com.amazon.a.a.a.a b() {
        if (d()) {
            return f13624f.f13625g;
        }
        f13622d.b("Appstore SDK is not initialized. Cannot get ContextManager returning null");
        return null;
    }

    public static com.amazon.a.a.g.c c() {
        if (d()) {
            return f13624f.f13633o;
        }
        f13622d.a("Appstore SDK is not initialized. Returning default log handler");
        return f13623e;
    }

    public static boolean d() {
        return f13624f != null;
    }

    private static boolean l() throws Throwable {
        String strA;
        try {
            strA = (String) Class.forName(com.amazon.a.a.o.b.at).getMethod(com.amazon.a.a.o.b.au, String.class).invoke(null, com.amazon.a.a.o.b.aq);
        } catch (Throwable unused) {
            f13622d.b("Unable to retrieve Sandbox property through reflection, using getProp");
            strA = a(com.amazon.a.a.o.b.aq);
        }
        return com.amazon.a.a.o.b.ar.equals(strA);
    }

    private com.amazon.a.a.n.a m() {
        return new e();
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        h();
        j();
        f();
        g();
    }

    public void f() {
        this.f13627i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.1
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.PAUSE;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap map = new HashMap();
                map.put(a.f13620b, com.amazon.a.a.a.a.b.PAUSE.name());
                map.put(a.f13619a, aVar.b().getClass().getName());
                map.put(a.f13621c, Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(map);
                if (com.amazon.a.a.o.c.f14105a) {
                    a.f13622d.a("Adding lifecycle PAUSE command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void g() {
        this.f13627i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.2
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap map = new HashMap();
                map.put(a.f13620b, com.amazon.a.a.a.a.b.RESUME.name());
                map.put(a.f13619a, aVar.b().getClass().getName());
                map.put(a.f13621c, Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(map);
                if (com.amazon.a.a.o.c.f14105a) {
                    a.f13622d.a("Adding lifecycle RESUME command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void h() {
        this.f13627i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.3
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.CREATE;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                a.this.i();
            }
        });
    }

    public void i() {
        if (com.amazon.a.a.o.c.f14105a) {
            f13622d.a("Enqueuing launch workflow");
        }
        if (a(this.f13631m)) {
            return;
        }
        this.f13628j.a(com.amazon.a.a.n.b.d.COMMAND, m());
    }

    public void j() {
        this.f13627i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.4
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                if (com.amazon.a.a.o.c.f14105a) {
                    a.f13622d.a("Beginning shutdown process for application: " + a.this.f13631m.getPackageName());
                }
                a unused = a.f13624f = null;
            }
        });
    }

    public static com.amazon.a.a.i.e a() {
        if (d()) {
            return f13624f.f13629k;
        }
        f13622d.b("Appstore SDK is not initialized. Cannot get PromptManager returning null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.amazon.a.a.n.a.a aVar) {
        if (d()) {
            f13624f.f13628j.a(com.amazon.a.a.n.b.d.COMMAND, aVar);
        } else {
            f13622d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        }
    }

    private static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{com.amazon.a.a.o.b.as, str}).getInputStream()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e8) {
            e = e8;
        }
        try {
            String line = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Exception unused) {
                f13622d.b("Unable to close BufferedReader instance");
            }
            return line;
        } catch (IOException e9) {
            e = e9;
            bufferedReader2 = bufferedReader;
            f13622d.a("Can't get system property", e);
            if (bufferedReader2 == null) {
                return "";
            }
            try {
                bufferedReader2.close();
                return "";
            } catch (Exception unused2) {
                f13622d.b("Unable to close BufferedReader instance");
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused3) {
                    f13622d.b("Unable to close BufferedReader instance");
                }
            }
            throw th;
        }
    }

    private void b(Application application) {
        com.amazon.a.a.k.c cVar = new com.amazon.a.a.k.c();
        cVar.a(application);
        cVar.a(new com.amazon.a.a.n.d());
        cVar.a(new com.amazon.a.a.m.c());
        cVar.a(new com.amazon.a.a.l.c());
        cVar.a(new com.amazon.a.a.a.c());
        cVar.a(new com.amazon.a.a.i.f());
        cVar.a(new com.amazon.a.a.c.g());
        cVar.a(new com.amazon.a.a.b.b());
        cVar.a(new com.amazon.a.a.h.d());
        cVar.a(new com.amazon.a.a.n.a.d());
        cVar.a(new com.amazon.a.a.o.b.d());
        cVar.a(new com.amazon.a.a.n.a.b());
        cVar.a(a(application) ? new com.amazon.a.a.g.d() : new com.amazon.a.a.g.b());
        cVar.a();
        cVar.b(this);
    }

    public static void a(Context context) {
        if (d()) {
            return;
        }
        synchronized (a.class) {
            try {
                if (!d()) {
                    Application application = (Application) context.getApplicationContext();
                    f13624f = new a(application);
                    application.registerActivityLifecycleCallbacks(com.amazon.a.a.f.a.a());
                }
            } finally {
            }
        }
    }

    @Deprecated
    public static void a(com.amazon.a.a.n.a.a aVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13622d.a("WARNING: Use of deprecated method detected.");
        }
        if (d()) {
            c(aVar);
        } else {
            f13622d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        }
    }

    private static void b(String str, Context context) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13622d.a(str + " called on context: " + context + " when AppstoreSDK is dead, ignoring...");
        }
    }

    public static void a(com.amazon.a.a.n.a.a aVar, Context context) {
        if (!d()) {
            if (context == null || context.getApplicationContext() == null) {
                f13622d.b("AppstoreSDK subsystem cannot be initialized because of null context. Unable to enqueue task.");
                return;
            }
            f13624f = new a((Application) context.getApplicationContext());
        }
        c(aVar);
    }

    public static boolean a(Application application) throws Throwable {
        boolean z7 = (application.getApplicationInfo().flags & 2) != 0;
        boolean zL = l();
        if (z7 && zL) {
            f13622d.a("Sandbox Mode: Debug build and debug.amazon.sandboxmode property is set on device");
            return true;
        }
        f13622d.a("Production Mode: Release build or debug.amazon.sandboxmode property is not set on device");
        return false;
    }

    public static boolean a(String str, Context context) {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.f14105a) {
            f13622d.a(str + ": " + context);
        }
        if (d()) {
            return true;
        }
        b(str, context);
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!d()) {
            f13622d.a("AppstoreSDK was not yet initialized - cannot do the IAP call");
            return false;
        }
        try {
            return com.amazon.a.a.o.b.e.a(str, str2, f13624f.f13632n.a());
        } catch (com.amazon.a.a.o.b.a.a e8) {
            f13622d.a("Unable to validate signature: " + e8.getMessage());
            return false;
        }
    }
}
