package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.c.f;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.amazon.a.a.k.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9745a = new com.amazon.a.a.o.c("ActivityResultManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f9746b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9747c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f9748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f9749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f9750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicReference<a> f9751g = new AtomicReference<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BlockingQueue<com.amazon.a.a.l.a> f9752h = new LinkedBlockingQueue();

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f9750f.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.l.c.1
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                a aVar2 = (a) c.this.f9751g.get();
                if (aVar2 != null) {
                    aVar2.b(aVar.b());
                }
            }
        });
    }

    private int b() {
        return f9746b.nextInt(f9747c) + 1;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f9756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Activity f9758c;

        public a(Intent intent, int i7) {
            this.f9756a = intent;
            this.f9757b = i7;
        }

        public void a(Activity activity) {
            c.f9745a.a("Calling startActivityForResult from: " + activity);
            activity.startActivityForResult(this.f9756a, this.f9757b);
            this.f9758c = activity;
        }

        public void b(Activity activity) {
            c.f9745a.b("Context changed while awaiting result!");
            if (this.f9758c != null) {
                c.f9745a.b("Finishing activity from old context: " + this.f9758c);
                this.f9758c.finishActivity(this.f9757b);
            }
            a(activity);
        }

        public int a() {
            return this.f9757b;
        }
    }

    @Override // com.amazon.a.a.l.b
    public com.amazon.a.a.l.a a(Intent intent) {
        final a aVar = new a(intent, b());
        if (!d.a(this.f9751g, null, aVar)) {
            f9745a.b("StartActivityForResult called while ActivityResultManager is already awaiting a result");
            return null;
        }
        com.amazon.a.a.o.c cVar = f9745a;
        cVar.a("Starting activity for result: " + intent + ", " + intent.getFlags() + ", requestId: " + aVar.a());
        this.f9748d.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.l.c.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                Activity activityB = c.this.f9749e.b();
                if (activityB == null) {
                    c.f9745a.a("No activity to call startActivityForResult on. startActivityForResult when an activity becomes visible");
                } else {
                    aVar.a(activityB);
                }
            }
        });
        try {
            try {
                cVar.a("Blocking for request: " + aVar.a());
                com.amazon.a.a.l.a aVarTake = this.f9752h.take();
                cVar.a("Received Response: " + aVar.a());
                this.f9751g.set(null);
                return aVarTake;
            } catch (InterruptedException unused) {
                com.amazon.a.a.o.c cVar2 = f9745a;
                cVar2.a("Interrupted while awaiting for request, returning null");
                cVar2.a("Received Response: " + aVar.a());
                this.f9751g.set(null);
                return null;
            }
        } catch (Throwable th) {
            f9745a.a("Received Response: " + aVar.a());
            this.f9751g.set(null);
            throw th;
        }
    }

    @Override // com.amazon.a.a.l.b
    public boolean a(com.amazon.a.a.l.a aVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9745a.a("Recieved ActivityResult: " + aVar);
        }
        a aVar2 = this.f9751g.get();
        if (aVar2 == null) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9745a.a("We don't have a current open request, returning");
            }
            return false;
        }
        if (aVar2.a() != aVar.b()) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9745a.a("We don't have a request with code: " + aVar.b() + ", returning");
            }
            return false;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f9745a.a("Signaling thread waiting for request: " + aVar.b());
        }
        this.f9752h.add(aVar);
        return true;
    }
}
