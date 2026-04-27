package N3;

import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: N3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0708b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H2.c f5653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f5654b;

    public C0708b(H2.c cVar, Executor executor) {
        this.f5653a = cVar;
        this.f5654b = executor;
    }

    public final /* synthetic */ void b(D3.m mVar) {
        try {
            I0.a("Updating active experiment: " + mVar.toString());
            this.f5653a.o(new H2.b(mVar.T(), mVar.Y(), mVar.W(), new Date(mVar.U()), mVar.X(), mVar.V()));
        } catch (H2.a e8) {
            I0.b("Unable to set experiment as active with ABT, missing analytics?\n" + e8.getMessage());
        }
    }

    public void c(final D3.m mVar) {
        this.f5654b.execute(new Runnable() { // from class: N3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f5648a.b(mVar);
            }
        });
    }
}
