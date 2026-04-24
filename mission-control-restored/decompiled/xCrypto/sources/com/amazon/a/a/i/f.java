package com.amazon.a.a.i;

import android.app.Activity;
import android.app.Dialog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class f implements e, com.amazon.a.a.k.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.amazon.a.a.o.c f8505a = new com.amazon.a.a.o.c("PromptManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f8506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.c.f f8507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f8508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f8509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f8510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<b> f8511g = new LinkedHashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f8512h = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (this.f8512h.get()) {
            if (com.amazon.a.a.o.c.f8810b) {
                f8505a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        if (com.amazon.a.a.o.c.f8809a) {
            f8505a.a("Presening Prompt: " + bVar);
        }
        bVar.a(this);
        this.f8511g.add(bVar);
        if (this.f8510f != null) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8505a.a("Dialog currently showing, not presenting given dialog");
            }
        } else {
            Activity activityB = this.f8506b.b();
            if (activityB != null) {
                a(activityB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        this.f8511g.remove(bVar);
        if (this.f8510f == bVar) {
            this.f8510f = null;
            Activity activityB = this.f8506b.b();
            if (activityB != null) {
                a(activityB);
            }
        }
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        b bVar = this.f8510f;
        if (bVar != null) {
            a(bVar, activity);
        } else {
            a(activity);
        }
    }

    @Override // com.amazon.a.a.i.e
    public void a(final b bVar) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8505a.a("Scheduling presentation: " + bVar);
        }
        this.f8509e.b(bVar);
        if (this.f8512h.get()) {
            if (com.amazon.a.a.o.c.f8810b) {
                f8505a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        this.f8508d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                f.this.c(bVar);
            }

            public String toString() {
                return "Prompt Presentation on Main Thread: " + bVar + ", " + bVar.a();
            }
        });
    }

    @Override // com.amazon.a.a.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(final b bVar) {
        this.f8508d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                f.this.d(bVar);
            }

            public String toString() {
                return "PromptManager:removeExpiredPrompt: " + bVar;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f8512h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8505a.a("PromptManager finishing....");
            }
            Iterator<b> it = this.f8511g.iterator();
            while (it.hasNext()) {
                b next = it.next();
                it.remove();
                next.c();
            }
            b bVar = this.f8510f;
            if (bVar != null) {
                bVar.k();
            }
        }
    }

    private void b() {
        this.f8507c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.i.f.3
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
                f.this.b(aVar.b());
            }
        });
    }

    private void a(Activity activity) {
        b bVarA = a();
        if (bVarA == null) {
            return;
        }
        a(bVarA, activity);
    }

    private void c() {
        this.f8507c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.i.f.4
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.FIRST;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                f.this.d();
            }
        });
    }

    private b a() {
        if (this.f8511g.isEmpty()) {
            return null;
        }
        return this.f8511g.iterator().next();
    }

    private void a(b bVar, Activity activity) {
        this.f8510f = bVar;
        bVar.a(activity);
    }

    @Override // com.amazon.a.a.i.e
    public Dialog a(Activity activity, int i4) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8505a.a("onCreateDialog, id: " + i4 + ", activity: " + activity);
        }
        b bVar = this.f8510f;
        if (bVar == null) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8505a.a("Showing dialog is null, returning");
            }
            return null;
        }
        if (bVar.j() != i4) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8505a.a("Showing dialog id does not match given id: " + i4 + ", returning");
            }
            return null;
        }
        if (com.amazon.a.a.o.c.f8809a) {
            f8505a.a("Creating dialog prompt: " + this.f8510f);
        }
        return this.f8510f.c(activity);
    }

    @Override // com.amazon.a.a.i.e
    public void a(Activity activity, boolean z4) {
        b bVar = this.f8510f;
        if (bVar != null) {
            bVar.a(activity, z4);
        }
    }
}
