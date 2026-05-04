package e9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import fa.a;
import n9.p;
import n9.u;
import n9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f8531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j7.b f8532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j7.a f8534d = new j7.a() { // from class: e9.b
        @Override // j7.a
        public final void a(e7.d dVar) {
            this.f8529a.h(dVar);
        }
    };

    public e(fa.a aVar) {
        aVar.a(new a.InterfaceC0174a() { // from class: e9.c
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                e.e(this.f8530a, bVar);
            }
        });
    }

    public static /* synthetic */ void e(e eVar, fa.b bVar) {
        synchronized (eVar) {
            try {
                j7.b bVar2 = (j7.b) bVar.get();
                eVar.f8532b = bVar2;
                if (bVar2 != null) {
                    bVar2.c(eVar.f8534d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ Task g(Task task) {
        return task.isSuccessful() ? Tasks.forResult(((e7.d) task.getResult()).b()) : Tasks.forException(task.getException());
    }

    @Override // e9.a
    public synchronized Task a() {
        j7.b bVar = this.f8532b;
        if (bVar == null) {
            return Tasks.forException(new a7.d("AppCheck is not available"));
        }
        Task taskA = bVar.a(this.f8533c);
        this.f8533c = false;
        return taskA.continueWithTask(p.f16963b, new Continuation() { // from class: e9.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return e.g(task);
            }
        });
    }

    @Override // e9.a
    public synchronized void b() {
        this.f8533c = true;
    }

    @Override // e9.a
    public synchronized void c() {
        this.f8531a = null;
        j7.b bVar = this.f8532b;
        if (bVar != null) {
            bVar.b(this.f8534d);
        }
    }

    @Override // e9.a
    public synchronized void d(u uVar) {
        this.f8531a = uVar;
    }

    public final synchronized void h(e7.d dVar) {
        try {
            if (dVar.a() != null) {
                v.e("FirebaseAppCheckTokenProvider", "Error getting App Check token; using placeholder token instead. Error: " + dVar.a(), new Object[0]);
            }
            u uVar = this.f8531a;
            if (uVar != null) {
                uVar.a(dVar.b());
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
