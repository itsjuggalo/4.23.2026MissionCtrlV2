package v0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebSettingsBoundaryInterface f15208a;

    public i(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.f15208a = webSettingsBoundaryInterface;
    }

    public void a(boolean z4) {
        this.f15208a.setPaymentRequestEnabled(z4);
    }
}
