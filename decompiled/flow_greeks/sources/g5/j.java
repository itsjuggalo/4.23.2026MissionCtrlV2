package g5;

import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f10064a;

    public j(k kVar) {
        Objects.requireNonNull(kVar);
        this.f10064a = kVar;
    }

    @Override // g5.e, g5.t
    public final void u(Status status) {
        this.f10064a.setResult(status);
    }
}
