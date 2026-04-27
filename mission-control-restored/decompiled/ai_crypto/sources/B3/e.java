package B3;

import K3.p;
import K3.w;
import K3.x;
import N3.a;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Y2.b f733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y2.a f735d = new Y2.a() { // from class: B3.b
        @Override // Y2.a
        public final void a(V2.b bVar) {
            this.f730a.i(bVar);
        }
    };

    public e(N3.a aVar) {
        aVar.a(new a.InterfaceC0058a() { // from class: B3.c
            @Override // N3.a.InterfaceC0058a
            public final void a(N3.b bVar) {
                this.f731a.j(bVar);
            }
        });
    }

    public static /* synthetic */ Task h(Task task) {
        return task.isSuccessful() ? Tasks.forResult(((V2.b) task.getResult()).b()) : Tasks.forException(task.getException());
    }

    @Override // B3.a
    public synchronized Task a() {
        Y2.b bVar = this.f733b;
        if (bVar == null) {
            return Tasks.forException(new Q2.d("AppCheck is not available"));
        }
        Task taskA = bVar.a(this.f734c);
        this.f734c = false;
        return taskA.continueWithTask(p.f3451b, new Continuation() { // from class: B3.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return e.h(task);
            }
        });
    }

    @Override // B3.a
    public synchronized void b() {
        this.f734c = true;
    }

    @Override // B3.a
    public synchronized void c() {
        this.f732a = null;
        Y2.b bVar = this.f733b;
        if (bVar != null) {
            bVar.b(this.f735d);
        }
    }

    @Override // B3.a
    public synchronized void d(w wVar) {
        this.f732a = wVar;
    }

    public final /* synthetic */ void j(N3.b bVar) {
        synchronized (this) {
            try {
                Y2.b bVar2 = (Y2.b) bVar.get();
                this.f733b = bVar2;
                if (bVar2 != null) {
                    bVar2.c(this.f735d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final synchronized void i(V2.b bVar) {
        try {
            if (bVar.a() != null) {
                x.e("FirebaseAppCheckTokenProvider", "Error getting App Check token; using placeholder token instead. Error: " + bVar.a(), new Object[0]);
            }
            w wVar = this.f732a;
            if (wVar != null) {
                wVar.a(bVar.b());
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
