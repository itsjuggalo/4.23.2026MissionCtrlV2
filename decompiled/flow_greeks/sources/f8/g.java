package f8;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import fa.a;
import j8.b0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.a f9374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f9375b = new AtomicReference();

    public g(fa.a aVar) {
        this.f9374a = aVar;
        aVar.a(new a.InterfaceC0174a() { // from class: f8.a
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                this.f9365a.f9375b.set((j7.b) bVar.get());
            }
        });
    }

    @Override // j8.b0
    public void a(boolean z10, final b0.a aVar) {
        j7.b bVar = (j7.b) this.f9375b.get();
        if (bVar != null) {
            bVar.a(z10).addOnSuccessListener(new OnSuccessListener() { // from class: f8.d
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    aVar.a(((e7.d) obj).b());
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: f8.e
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    aVar.onError(exc.getMessage());
                }
            });
        } else {
            aVar.a(null);
        }
    }

    @Override // j8.b0
    public void b(final ExecutorService executorService, final b0.b bVar) {
        this.f9374a.a(new a.InterfaceC0174a() { // from class: f8.b
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar2) {
                ((j7.b) bVar2.get()).c(new j7.a() { // from class: f8.c
                    @Override // j7.a
                    public final void a(e7.d dVar) {
                        executorService.execute(new Runnable() { // from class: f8.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar.a(dVar.b());
                            }
                        });
                    }
                });
            }
        });
    }
}
