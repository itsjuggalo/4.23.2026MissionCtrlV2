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
    private static final com.amazon.a.a.o.c f13856a = new com.amazon.a.a.o.c("ActivityResultManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f13857b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13858c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f13859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f13860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f13861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicReference<a> f13862g = new AtomicReference<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BlockingQueue<com.amazon.a.a.l.a> f13863h = new LinkedBlockingQueue();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f13867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Activity f13869c;

        public a(Intent intent, int i8) {
            this.f13867a = intent;
            this.f13868b = i8;
        }

        public int a() {
            return this.f13868b;
        }

        public void b(Activity activity) {
            c.f13856a.b("Context changed while awaiting result!");
            if (this.f13869c != null) {
                c.f13856a.b("Finishing activity from old context: " + this.f13869c);
                this.f13869c.finishActivity(this.f13868b);
            }
            a(activity);
        }

        public void a(Activity activity) {
            c.f13856a.a("Calling startActivityForResult from: " + activity);
            activity.startActivityForResult(this.f13867a, this.f13868b);
            this.f13869c = activity;
        }
    }

    private int b() {
        return f13857b.nextInt(f13858c) + 1;
    }

    @Override // com.amazon.a.a.l.b
    public com.amazon.a.a.l.a a(Intent intent) {
        final a aVar = new a(intent, b());
        if (!d.a(this.f13862g, null, aVar)) {
            f13856a.b("StartActivityForResult called while ActivityResultManager is already awaiting a result");
            return null;
        }
        com.amazon.a.a.o.c cVar = f13856a;
        cVar.a("Starting activity for result: " + intent + ", " + intent.getFlags() + ", requestId: " + aVar.a());
        this.f13859d.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.l.c.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                Activity activityB = c.this.f13860e.b();
                if (activityB == null) {
                    c.f13856a.a("No activity to call startActivityForResult on. startActivityForResult when an activity becomes visible");
                } else {
                    aVar.a(activityB);
                }
            }
        });
        try {
            try {
                cVar.a("Blocking for request: " + aVar.a());
                com.amazon.a.a.l.a aVarTake = this.f13863h.take();
                cVar.a("Received Response: " + aVar.a());
                this.f13862g.set(null);
                return aVarTake;
            } catch (InterruptedException unused) {
                com.amazon.a.a.o.c cVar2 = f13856a;
                cVar2.a("Interrupted while awaiting for request, returning null");
                cVar2.a("Received Response: " + aVar.a());
                this.f13862g.set(null);
                return null;
            }
        } catch (Throwable th) {
            f13856a.a("Received Response: " + aVar.a());
            this.f13862g.set(null);
            throw th;
        }
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f13861f.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.l.c.1
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
                a aVar2 = (a) c.this.f13862g.get();
                if (aVar2 != null) {
                    aVar2.b(aVar.b());
                }
            }
        });
    }

    @Override // com.amazon.a.a.l.b
    public boolean a(com.amazon.a.a.l.a aVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13856a.a("Recieved ActivityResult: " + aVar);
        }
        a aVar2 = this.f13862g.get();
        if (aVar2 == null) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13856a.a("We don't have a current open request, returning");
            }
            return false;
        }
        if (aVar2.a() != aVar.b()) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13856a.a("We don't have a request with code: " + aVar.b() + ", returning");
            }
            return false;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f13856a.a("Signaling thread waiting for request: " + aVar.b());
        }
        this.f13863h.add(aVar);
        return true;
    }
}
