package e9;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import fa.a;
import m7.c0;
import n9.p;
import n9.u;
import n9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n7.a f8539a = new n7.a() { // from class: e9.f
        @Override // n7.a
        public final void a(ka.b bVar) {
            this.f8535a.i();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n7.b f8540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f8541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8543e;

    public i(fa.a aVar) {
        aVar.a(new a.InterfaceC0174a() { // from class: e9.g
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                i.f(this.f8536a, bVar);
            }
        });
    }

    public static /* synthetic */ Task e(i iVar, int i10, Task task) {
        synchronized (iVar) {
            try {
                if (i10 != iVar.f8542d) {
                    v.a("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                    return iVar.a();
                }
                if (task.isSuccessful()) {
                    return Tasks.forResult(((c0) task.getResult()).g());
                }
                return Tasks.forException(task.getException());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void f(i iVar, fa.b bVar) {
        synchronized (iVar) {
            iVar.f8540b = (n7.b) bVar.get();
            iVar.i();
            iVar.f8540b.b(iVar.f8539a);
        }
    }

    @Override // e9.a
    public synchronized Task a() {
        n7.b bVar = this.f8540b;
        if (bVar == null) {
            return Tasks.forException(new a7.d("auth is not available"));
        }
        Task taskC = bVar.c(this.f8543e);
        this.f8543e = false;
        final int i10 = this.f8542d;
        return taskC.continueWithTask(p.f16963b, new Continuation() { // from class: e9.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return i.e(this.f8537a, i10, task);
            }
        });
    }

    @Override // e9.a
    public synchronized void b() {
        this.f8543e = true;
    }

    @Override // e9.a
    public synchronized void c() {
        this.f8541c = null;
        n7.b bVar = this.f8540b;
        if (bVar != null) {
            bVar.d(this.f8539a);
        }
    }

    @Override // e9.a
    public synchronized void d(u uVar) {
        this.f8541c = uVar;
        uVar.a(h());
    }

    public final synchronized j h() {
        String strA;
        try {
            n7.b bVar = this.f8540b;
            strA = bVar == null ? null : bVar.a();
        } catch (Throwable th) {
            throw th;
        }
        return strA != null ? new j(strA) : j.f8544b;
    }

    public final synchronized void i() {
        this.f8542d++;
        u uVar = this.f8541c;
        if (uVar != null) {
            uVar.a(h());
        }
    }
}
