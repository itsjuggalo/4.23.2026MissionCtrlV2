package com.amazon.a.a.l;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.c.f;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.amazon.a.a.k.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4372a = new com.amazon.a.a.o.c("ActivityResultManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f4373b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4374c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f4375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f4376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f4377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicReference<a> f4378g = new AtomicReference<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BlockingQueue<com.amazon.a.a.l.a> f4379h = new LinkedBlockingQueue();

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f4377f.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.l.c.1
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
                a aVar2 = (a) c.this.f4378g.get();
                if (aVar2 != null) {
                    aVar2.b(aVar.b());
                }
            }
        });
    }

    private int b() {
        return f4373b.nextInt(f4374c) + 1;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f4383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Activity f4385c;

        public a(Intent intent, int i10) {
            this.f4383a = intent;
            this.f4384b = i10;
        }

        public void a(Activity activity) {
            c.f4372a.a("Calling startActivityForResult from: " + activity);
            activity.startActivityForResult(this.f4383a, this.f4384b);
            this.f4385c = activity;
        }

        public void b(Activity activity) {
            c.f4372a.b("Context changed while awaiting result!");
            if (this.f4385c != null) {
                c.f4372a.b("Finishing activity from old context: " + this.f4385c);
                this.f4385c.finishActivity(this.f4384b);
            }
            a(activity);
        }

        public int a() {
            return this.f4384b;
        }
    }

    @Override // com.amazon.a.a.l.b
    public com.amazon.a.a.l.a a(Intent intent) {
        final a aVar = new a(intent, b());
        if (!d.a(this.f4378g, null, aVar)) {
            f4372a.b("StartActivityForResult called while ActivityResultManager is already awaiting a result");
            return null;
        }
        com.amazon.a.a.o.c cVar = f4372a;
        cVar.a("Starting activity for result: " + intent + ", " + intent.getFlags() + ", requestId: " + aVar.a());
        this.f4375d.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.l.c.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                Activity activityB = c.this.f4376e.b();
                if (activityB == null) {
                    c.f4372a.a("No activity to call startActivityForResult on. startActivityForResult when an activity becomes visible");
                } else {
                    aVar.a(activityB);
                }
            }
        });
        try {
            try {
                cVar.a("Blocking for request: " + aVar.a());
                com.amazon.a.a.l.a aVarTake = this.f4379h.take();
                cVar.a("Received Response: " + aVar.a());
                this.f4378g.set(null);
                return aVarTake;
            } catch (InterruptedException unused) {
                com.amazon.a.a.o.c cVar2 = f4372a;
                cVar2.a("Interrupted while awaiting for request, returning null");
                cVar2.a("Received Response: " + aVar.a());
                this.f4378g.set(null);
                return null;
            }
        } catch (Throwable th) {
            f4372a.a("Received Response: " + aVar.a());
            this.f4378g.set(null);
            throw th;
        }
    }

    @Override // com.amazon.a.a.l.b
    public boolean a(com.amazon.a.a.l.a aVar) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4372a.a("Recieved ActivityResult: " + aVar);
        }
        a aVar2 = this.f4378g.get();
        if (aVar2 == null) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4372a.a("We don't have a current open request, returning");
            }
            return false;
        }
        if (aVar2.a() != aVar.b()) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4372a.a("We don't have a request with code: " + aVar.b() + ", returning");
            }
            return false;
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4372a.a("Signaling thread waiting for request: " + aVar.b());
        }
        this.f4379h.add(aVar);
        return true;
    }
}
