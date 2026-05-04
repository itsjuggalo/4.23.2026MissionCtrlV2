package g5;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import java.util.Objects;
import z1.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements a.InterfaceC0478a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f10072a;

    public /* synthetic */ x(SignInHubActivity signInHubActivity, byte[] bArr) {
        Objects.requireNonNull(signInHubActivity);
        this.f10072a = signInHubActivity;
    }

    @Override // z1.a.InterfaceC0478a
    public final a2.b a(int i10, Bundle bundle) {
        return new g(this.f10072a, com.google.android.gms.common.api.g.c());
    }

    @Override // z1.a.InterfaceC0478a
    public final /* bridge */ /* synthetic */ void c(a2.b bVar, Object obj) {
        SignInHubActivity signInHubActivity = this.f10072a;
        signInHubActivity.setResult(signInHubActivity.l(), signInHubActivity.m());
        signInHubActivity.finish();
    }

    @Override // z1.a.InterfaceC0478a
    public final void b(a2.b bVar) {
    }
}
