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
    public static final com.amazon.a.a.o.c f9690a = new com.amazon.a.a.o.c("PromptManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f9691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.c.f f9692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b f9693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.k.b f9694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f9695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<b> f9696g = new LinkedHashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f9697h = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (this.f9697h.get()) {
            if (com.amazon.a.a.o.c.f9995b) {
                f9690a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f9690a.a("Presening Prompt: " + bVar);
        }
        bVar.a(this);
        this.f9696g.add(bVar);
        if (this.f9695f != null) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9690a.a("Dialog currently showing, not presenting given dialog");
            }
        } else {
            Activity activityB = this.f9691b.b();
            if (activityB != null) {
                a(activityB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        this.f9696g.remove(bVar);
        if (this.f9695f == bVar) {
            this.f9695f = null;
            Activity activityB = this.f9691b.b();
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
        b bVar = this.f9695f;
        if (bVar != null) {
            a(bVar, activity);
        } else {
            a(activity);
        }
    }

    @Override // com.amazon.a.a.i.e
    public void a(final b bVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9690a.a("Scheduling presentation: " + bVar);
        }
        this.f9694e.b(bVar);
        if (this.f9697h.get()) {
            if (com.amazon.a.a.o.c.f9995b) {
                f9690a.b("Prompt: " + bVar + " presented after app destruction expiring it now!");
            }
            bVar.c();
            return;
        }
        this.f9693d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.1
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
        this.f9693d.a(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.i.f.2
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
        if (this.f9697h.compareAndSet(false, true)) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9690a.a("PromptManager finishing....");
            }
            Iterator<b> it = this.f9696g.iterator();
            while (it.hasNext()) {
                b next = it.next();
                it.remove();
                next.c();
            }
            b bVar = this.f9695f;
            if (bVar != null) {
                bVar.k();
            }
        }
    }

    private void b() {
        this.f9692c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.i.f.3
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
        this.f9692c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.i.f.4
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
        if (this.f9696g.isEmpty()) {
            return null;
        }
        return this.f9696g.iterator().next();
    }

    private void a(b bVar, Activity activity) {
        this.f9695f = bVar;
        bVar.a(activity);
    }

    @Override // com.amazon.a.a.i.e
    public Dialog a(Activity activity, int i7) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9690a.a("onCreateDialog, id: " + i7 + ", activity: " + activity);
        }
        b bVar = this.f9695f;
        if (bVar == null) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9690a.a("Showing dialog is null, returning");
            }
            return null;
        }
        if (bVar.j() != i7) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9690a.a("Showing dialog id does not match given id: " + i7 + ", returning");
            }
            return null;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f9690a.a("Creating dialog prompt: " + this.f9695f);
        }
        return this.f9695f.c(activity);
    }

    @Override // com.amazon.a.a.i.e
    public void a(Activity activity, boolean z7) {
        b bVar = this.f9695f;
        if (bVar != null) {
            bVar.a(activity, z7);
        }
    }
}
