package B3;

import K3.p;
import K3.w;
import K3.x;
import N3.a;
import Z2.C;
import a3.InterfaceC0839a;
import a3.InterfaceC0841b;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0839a f740a = new InterfaceC0839a() { // from class: B3.f
        @Override // a3.InterfaceC0839a
        public final void a(S3.b bVar) {
            this.f736a.j(bVar);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0841b f741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f744e;

    public i(N3.a aVar) {
        aVar.a(new a.InterfaceC0058a() { // from class: B3.g
            @Override // N3.a.InterfaceC0058a
            public final void a(N3.b bVar) {
                this.f737a.k(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(N3.b bVar) {
        synchronized (this) {
            this.f741b = (InterfaceC0841b) bVar.get();
            l();
            this.f741b.b(this.f740a);
        }
    }

    @Override // B3.a
    public synchronized Task a() {
        InterfaceC0841b interfaceC0841b = this.f741b;
        if (interfaceC0841b == null) {
            return Tasks.forException(new Q2.d("auth is not available"));
        }
        Task taskD = interfaceC0841b.d(this.f744e);
        this.f744e = false;
        final int i7 = this.f743d;
        return taskD.continueWithTask(p.f3451b, new Continuation() { // from class: B3.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f738a.i(i7, task);
            }
        });
    }

    @Override // B3.a
    public synchronized void b() {
        this.f744e = true;
    }

    @Override // B3.a
    public synchronized void c() {
        this.f742c = null;
        InterfaceC0841b interfaceC0841b = this.f741b;
        if (interfaceC0841b != null) {
            interfaceC0841b.c(this.f740a);
        }
    }

    @Override // B3.a
    public synchronized void d(w wVar) {
        this.f742c = wVar;
        wVar.a(h());
    }

    public final synchronized j h() {
        String strA;
        try {
            InterfaceC0841b interfaceC0841b = this.f741b;
            strA = interfaceC0841b == null ? null : interfaceC0841b.a();
        } catch (Throwable th) {
            throw th;
        }
        return strA != null ? new j(strA) : j.f745b;
    }

    public final /* synthetic */ Task i(int i7, Task task) {
        synchronized (this) {
            try {
                if (i7 != this.f743d) {
                    x.a("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                    return a();
                }
                if (task.isSuccessful()) {
                    return Tasks.forResult(((C) task.getResult()).g());
                }
                return Tasks.forException(task.getException());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void j(S3.b bVar) {
        l();
    }

    public final synchronized void l() {
        this.f743d++;
        w wVar = this.f742c;
        if (wVar != null) {
            wVar.a(h());
        }
    }
}
