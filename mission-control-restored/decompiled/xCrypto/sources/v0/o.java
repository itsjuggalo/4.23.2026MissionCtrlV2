package v0;

import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f15286a;

    public o(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f15286a = webkitToCompatConverterBoundaryInterface;
    }

    public i a(WebSettings webSettings) {
        return new i((WebSettingsBoundaryInterface) S3.a.a(WebSettingsBoundaryInterface.class, this.f15286a.convertSettings(webSettings)));
    }
}
