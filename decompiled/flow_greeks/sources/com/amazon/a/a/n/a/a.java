package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.d.a.c;
import com.amazon.d.a.j;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.amazon.a.a.n.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4401b = new com.amazon.a.a.o.c("AbstractCommandTask");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.l.b f4402a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f4403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private d f4404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e f4405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c f4406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private b f4407g;

    private void b(j jVar) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Command executed successfully");
        }
        a(jVar);
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
                return a.this.f4403c.getPackageName();
            }
        };
    }

    private void j() {
        if (m()) {
            return;
        }
        this.f4404d.b();
    }

    public abstract void a(com.amazon.d.a.h hVar);

    public abstract void a(j jVar);

    public abstract String a_();

    public abstract Map<String, Object> b();

    public abstract String c();

    public abstract boolean d();

    public boolean f() {
        return true;
    }

    public String g() {
        return a_() + "_failure";
    }

    public String h() {
        return a_() + "_success";
    }

    @Override // com.amazon.a.a.n.a
    public final void a() {
        try {
            if (com.amazon.a.a.o.c.f4603a) {
                com.amazon.a.a.o.c cVar = f4401b;
                cVar.a("----------------------------------------------");
                cVar.a("Executing: " + a_());
                cVar.a("----------------------------------------------");
            }
            e();
            if (!d()) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("Execution not needed, quitting");
                }
                return;
            }
            if (com.amazon.a.a.o.c.f4603a) {
                f4401b.a("Executing Command: " + a_());
            }
            a(this.f4404d.a(i()));
            if (com.amazon.a.a.o.c.f4603a) {
                f4401b.a("Task finished");
            }
            j();
        } catch (Throwable th) {
            try {
                a(th);
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("Task finished");
                }
                j();
            } finally {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("Task finished");
                }
                j();
            }
        }
    }

    private void b(com.amazon.d.a.h hVar) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Command failed execution: " + hVar.b());
        }
        a(hVar);
    }

    private com.amazon.a.a.d.b b(Throwable th) {
        if (th instanceof com.amazon.a.a.d.b) {
            return (com.amazon.a.a.d.b) th;
        }
        if (th instanceof RemoteException) {
            return new com.amazon.a.a.n.a.a.d((RemoteException) th);
        }
        return new com.amazon.a.a.n.a.a.h(th);
    }

    public void b(com.amazon.a.a.d.b bVar) {
        f4401b.b("On Exception!!!!: " + bVar);
    }

    public void e() {
    }

    private void a(c cVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Received result from CommandService: " + cVar);
        }
        if (cVar == null) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4401b.a("Received null result from command service, exiting task");
            }
        } else {
            if (cVar.e() != null) {
                a(cVar.e());
                return;
            }
            this.f4407g.a(cVar.a(), this.f4404d.a());
            if (cVar.b() != null) {
                b(cVar.b());
            } else if (cVar.c() != null) {
                b(cVar.c());
            } else if (f()) {
                a(cVar.d());
            }
        }
    }

    private void a(com.amazon.d.a.g gVar) throws com.amazon.a.a.n.a.a.f {
        throw new com.amazon.a.a.n.a.a.f(gVar);
    }

    private void a(com.amazon.d.a.f fVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Handling Decision");
        }
        try {
            f fVar2 = new f(fVar);
            this.f4405e.a((com.amazon.a.a.i.b) fVar2);
            com.amazon.d.a.a aVarI = fVar2.i();
            if (aVarI == null) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("DecisionChooser returned null!!, expiring");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
                return;
            }
            a(fVar, aVarI);
        } catch (com.amazon.a.a.n.a.a.e e10) {
            a(fVar, e10.a());
        }
    }

    private void a(com.amazon.d.a.f fVar, com.amazon.d.a.a aVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Handling customer choice: " + aVar);
        }
        Intent intentB = aVar.b();
        if (intentB != null) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4401b.a("Choice has intent, scheduling it to be fired!!");
            }
            com.amazon.a.a.l.a aVarA = this.f4402a.a(intentB);
            if (aVarA == null) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("No result recived, expiring decision");
                }
                a(fVar, e.EXPIRATION_DURATION_ELAPSED);
                return;
            } else if (aVarA.d() == 0) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("Result canceled, expiring decision");
                }
                a(fVar, e.ACTION_CANCELED);
                return;
            } else {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4401b.a("Result received!!!, notifying service");
                }
                a(this.f4404d.a(aVar));
                return;
            }
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("No intent given, choosing now");
        }
        a(this.f4404d.a(aVar));
    }

    private void a(com.amazon.d.a.f fVar, e eVar) throws RemoteException, com.amazon.a.a.n.a.a.a, com.amazon.a.a.n.a.a.f {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Expiring Decision: " + fVar + ", reason: " + eVar);
        }
        a(this.f4404d.a(fVar, eVar));
    }

    private void a(Throwable th) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4401b.a("Exception occurred while processing task: " + th, th);
        }
        com.amazon.a.a.d.b bVarB = b(th);
        b(bVarB);
        this.f4406f.a(a(bVarB));
    }

    public com.amazon.a.a.h.a a(com.amazon.a.a.d.b bVar) {
        com.amazon.a.a.h.a aVar = new com.amazon.a.a.h.a(g());
        aVar.a("subType", bVar.a()).a("reason", bVar.b()).a("context", bVar.c());
        return aVar;
    }
}
