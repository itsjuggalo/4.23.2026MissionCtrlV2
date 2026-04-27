package v1;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import d0.AbstractC1208a;
import e0.AbstractC1226b;

/* JADX INFO: renamed from: v1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1882A implements AbstractC1208a.InterfaceC0181a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f15287a;

    public /* synthetic */ C1882A(SignInHubActivity signInHubActivity, z zVar) {
        this.f15287a = signInHubActivity;
    }

    @Override // d0.AbstractC1208a.InterfaceC0181a
    public final AbstractC1226b a(int i4, Bundle bundle) {
        return new C1889g(this.f15287a, com.google.android.gms.common.api.f.c());
    }

    @Override // d0.AbstractC1208a.InterfaceC0181a
    public final /* bridge */ /* synthetic */ void b(AbstractC1226b abstractC1226b, Object obj) {
        SignInHubActivity signInHubActivity = this.f15287a;
        signInHubActivity.setResult(signInHubActivity.f9646e, signInHubActivity.f9647f);
        this.f15287a.finish();
    }

    @Override // d0.AbstractC1208a.InterfaceC0181a
    public final void c(AbstractC1226b abstractC1226b) {
    }
}
