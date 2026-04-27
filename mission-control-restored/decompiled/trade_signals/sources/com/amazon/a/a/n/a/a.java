package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.d.a.c;
import com.amazon.d.a.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13885b = new com.amazon.a.a.o.c("AbstractCommandTask");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.l.b f13886a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f13887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private d f13888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f13889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f13890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private b f13891g;

    private com.amazon.a.a.d.b b(Throwable th) {
        return th instanceof com.amazon.a.a.d.b ? (com.amazon.a.a.d.b) th : th instanceof RemoteException ? new com.amazon.a.a.n.a.a.d((RemoteException) th) : new com.amazon.a.a.n.a.a.h(th);
    }

    private com.amazon.d.a.c i() {
        return new c.a() { // from class: com.amazon.a.a.n.a.a.1
            @Override // com.amazon.d.a.c
            public String a() {
                return a.this.c();
            }

            @Override // com.amazon.d.a.c
            public String b() {
                return a.this.a_();
            }

            @Override // com.amazon.d.a.c
            public Map c() {
                return a.this.b();
            }

            @Override // com.amazon.d.a.c
            public String d() {
                return a.this.f13887c.getPackageName();
            }
        };
    }

    private void j() {
        if (m()) {
            return;
        }
        this.f13888d.b();
    }

    public abstract void a(com.amazon.d.a.h hVar);

    public abstract void a(j jVar);

    public abstract String a_();

    public abstract Map<String, Object> b();

    public abstract String c();

    public abstract boolean d();

    public void e() {
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return a_() + "_failure";
    }

    public String h() {
        return a_() + "_success";
    }

    public com.amazon.a.a.h.a a(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.h.a aVar = new com.amazon.a.a.h.a(g());
        aVar.a("subType", bVar.a()).a("reason", bVar.b()).a("context", bVar.c());
        return aVar;
    }

    public void b(com.amazon.a.a.d.b bVar) {
        f13885b.b("On Exception!!!!: " + bVar);
    }

    private void b(com.amazon.d.a.h hVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Command failed execution: " + hVar.b());
        }
        a(hVar);
    }

    @Override // com.amazon.a.a.n.a
    public final void a() {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                com.amazon.a.a.o.c cVar = f13885b;
                cVar.a("----------------------------------------------");
                cVar.a("Executing: " + a_());
                cVar.a("----------------------------------------------");
            }
            e();
        } catch (Throwable th) {
            try {
                a(th);
                if (com.amazon.a.a.o.c.f14105a) {
                }
            } finally {
                if (com.amazon.a.a.o.c.f14105a) {
                    f13885b.a("Task finished");
                }
                j();
            }
        }
        if (!d()) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13885b.a("Execution not needed, quitting");
            }
            return;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Executing Command: " + a_());
        }
        a(this.f13888d.a(i()));
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Task finished");
        }
        j();
    }

    private void a(c cVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Received result from CommandService: " + cVar);
        }
        if (cVar == null) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13885b.a("Received null result from command service, exiting task");
            }
        } else {
            if (cVar.e() != null) {
                a(cVar.e());
                return;
            }
            this.f13891g.a(cVar.a(), this.f13888d.a());
            if (cVar.b() != null) {
                b(cVar.b());
            } else if (cVar.c() != null) {
                b(cVar.c());
            } else if (f()) {
                a(cVar.d());
            }
        }
    }

    private void b(j jVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Command executed successfully");
        }
        a(jVar);
    }

    private void a(com.amazon.d.a.f fVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Handling Decision");
        }
        try {
            f fVar2 = new f(fVar);
            this.f13889e.a((com.amazon.a.a.i.b) fVar2);
            com.amazon.d.a.a aVarI = fVar2.i();
            if (aVarI != null) {
                a(fVar, aVarI);
                return;
            }
            if (com.amazon.a.a.o.c.f14105a) {
                f13885b.a("DecisionChooser returned null!!, expiring");
            }
            a(fVar, e.EXPIRATION_DURATION_ELAPSED);
        } catch (com.amazon.a.a.n.a.a.e e8) {
            a(fVar, e8.a());
        }
    }

    private void a(com.amazon.d.a.f fVar, e eVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Expiring Decision: " + fVar + ", reason: " + eVar);
        }
        a(this.f13888d.a(fVar, eVar));
    }

    private void a(com.amazon.d.a.f fVar, com.amazon.d.a.a aVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        com.amazon.a.a.o.c cVar;
        String str;
        e eVar;
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Handling customer choice: " + aVar);
        }
        Intent intentB = aVar.b();
        if (intentB != null) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13885b.a("Choice has intent, scheduling it to be fired!!");
            }
            com.amazon.a.a.l.a aVarA = this.f13886a.a(intentB);
            if (aVarA == null) {
                if (com.amazon.a.a.o.c.f14105a) {
                    f13885b.a("No result recived, expiring decision");
                }
                eVar = e.EXPIRATION_DURATION_ELAPSED;
            } else if (aVarA.d() == 0) {
                if (com.amazon.a.a.o.c.f14105a) {
                    f13885b.a("Result canceled, expiring decision");
                }
                eVar = e.ACTION_CANCELED;
            } else if (com.amazon.a.a.o.c.f14105a) {
                cVar = f13885b;
                str = "Result received!!!, notifying service";
                cVar.a(str);
            }
            a(fVar, eVar);
            return;
        }
        if (com.amazon.a.a.o.c.f14105a) {
            cVar = f13885b;
            str = "No intent given, choosing now";
            cVar.a(str);
        }
        a(this.f13888d.a(aVar));
    }

    private void a(com.amazon.d.a.g gVar) throws com.amazon.a.a.n.a.a.f {
        throw new com.amazon.a.a.n.a.a.f(gVar);
    }

    private void a(Throwable th) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13885b.a("Exception occurred while processing task: " + th, th);
        }
        com.amazon.a.a.d.b bVarB = b(th);
        b(bVarB);
        this.f13890f.a(a(bVarB));
    }
}
