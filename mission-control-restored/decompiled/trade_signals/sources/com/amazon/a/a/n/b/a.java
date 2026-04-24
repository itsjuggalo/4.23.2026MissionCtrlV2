package com.amazon.a.a.n.b;

import com.amazon.a.a.c.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.amazon.a.a.k.d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13985a = new com.amazon.a.a.o.c("ForegroundTaskPipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f13986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private f f13987c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f13989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.amazon.a.a.n.a> f13990f = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f13988d = b.b("KIWI_UI");

    public a(c cVar) {
        this.f13989e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (com.amazon.a.a.o.c.f14105a) {
            f13985a.a("Activity resumed, scheduling tasks on UI thread");
        }
        Iterator<com.amazon.a.a.n.a> it = this.f13990f.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.f13990f.clear();
    }

    private com.amazon.a.a.n.a c(final com.amazon.a.a.n.a aVar) {
        return new com.amazon.a.a.n.a() { // from class: com.amazon.a.a.n.b.a.2
            @Override // com.amazon.a.a.n.a
            public void a() {
                a.this.a(aVar, true);
            }

            public String toString() {
                return "Future:PostToUITask: " + aVar.toString();
            }
        };
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        this.f13988d.a();
        this.f13989e.a();
        this.f13990f.clear();
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        this.f13987c.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.n.b.a.1
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            public String toString() {
                return "ForegroundTaskPipeline:onResume listener";
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                a.this.b();
            }
        });
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar) {
        a(aVar, false);
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        a(aVar, true);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j8) {
        this.f13989e.a(c(aVar), j8);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        this.f13989e.a(c(aVar), date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.amazon.a.a.n.a aVar, boolean z7) {
        if (this.f13986b.c()) {
            if (z7) {
                this.f13988d.b(aVar);
                return;
            } else {
                this.f13988d.a(aVar);
                return;
            }
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f13985a.a("No UI visible to execute task: " + aVar + ", placing into pending queue until task is visible");
        }
        this.f13990f.add(aVar);
    }
}
