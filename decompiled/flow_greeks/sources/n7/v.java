package n7;

import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f16860a;

    public v(w wVar) {
        Objects.requireNonNull(wVar);
        this.f16860a = wVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (exc instanceof a7.o) {
            t.f16849h.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f16860a.f16869b.d();
        }
    }
}
