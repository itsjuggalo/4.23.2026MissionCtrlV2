package g5;

import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f10065a;

    public l(m mVar) {
        Objects.requireNonNull(mVar);
        this.f10065a = mVar;
    }

    @Override // g5.e, g5.t
    public final void x(Status status) {
        this.f10065a.setResult(status);
    }
}
