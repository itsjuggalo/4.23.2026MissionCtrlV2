package f8;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import fa.a;
import j8.b0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import m7.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.a f9385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f9386b = new AtomicReference();

    public n(fa.a aVar) {
        this.f9385a = aVar;
        aVar.a(new a.InterfaceC0174a() { // from class: f8.i
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                this.f9378a.f9386b.set((n7.b) bVar.get());
            }
        });
    }

    public static /* synthetic */ void h(b0.a aVar, Exception exc) {
        if (i(exc)) {
            aVar.a(null);
        } else {
            aVar.onError(exc.getMessage());
        }
    }

    public static boolean i(Exception exc) {
        return (exc instanceof a7.d) || (exc instanceof la.a);
    }

    @Override // j8.b0
    public void a(boolean z10, final b0.a aVar) {
        n7.b bVar = (n7.b) this.f9386b.get();
        if (bVar != null) {
            bVar.c(z10).addOnSuccessListener(new OnSuccessListener() { // from class: f8.j
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    aVar.a(((c0) obj).g());
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: f8.k
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    n.h(aVar, exc);
                }
            });
        } else {
            aVar.a(null);
        }
    }

    @Override // j8.b0
    public void b(final ExecutorService executorService, final b0.b bVar) {
        this.f9385a.a(new a.InterfaceC0174a() { // from class: f8.h
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar2) {
                ((n7.b) bVar2.get()).b(new n7.a() { // from class: f8.l
                    @Override // n7.a
                    public final void a(ka.b bVar3) {
                        executorService.execute(new Runnable() { // from class: f8.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar.a(bVar3.a());
                            }
                        });
                    }
                });
            }
        });
    }
}
