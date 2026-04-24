package M1;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import t0.AbstractC2648a;
import u0.AbstractC2743b;

/* JADX INFO: loaded from: classes.dex */
public final class A implements AbstractC2648a.InterfaceC0363a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f3803a;

    public /* synthetic */ A(SignInHubActivity signInHubActivity, z zVar) {
        this.f3803a = signInHubActivity;
    }

    @Override // t0.AbstractC2648a.InterfaceC0363a
    public final AbstractC2743b a(int i7, Bundle bundle) {
        return new g(this.f3803a, com.google.android.gms.common.api.f.c());
    }

    @Override // t0.AbstractC2648a.InterfaceC0363a
    public final /* bridge */ /* synthetic */ void b(AbstractC2743b abstractC2743b, Object obj) {
        SignInHubActivity signInHubActivity = this.f3803a;
        signInHubActivity.setResult(signInHubActivity.f10831E, signInHubActivity.f10832F);
        this.f3803a.finish();
    }

    @Override // t0.AbstractC2648a.InterfaceC0363a
    public final void c(AbstractC2743b abstractC2743b) {
    }
}
