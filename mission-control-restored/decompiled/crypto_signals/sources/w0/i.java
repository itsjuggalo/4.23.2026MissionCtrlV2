package w0;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v0.AbstractC1254a;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC1274c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pattern f10706d;

    public i() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.f10706d = Pattern.compile("\\A\\d+");
    }

    @Override // w0.AbstractC1274c
    public final boolean a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // w0.AbstractC1274c
    public final boolean b() {
        int i;
        PackageInfo packageInfoA;
        boolean zB = super.b();
        if (!zB || (i = Build.VERSION.SDK_INT) >= 29) {
            return zB;
        }
        int i6 = AbstractC1254a.f10601a;
        if (i >= 26) {
            packageInfoA = WebView.getCurrentWebViewPackage();
        } else {
            try {
                packageInfoA = AbstractC1254a.a();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                packageInfoA = null;
            }
        }
        if (packageInfoA == null) {
            return false;
        }
        Matcher matcher = this.f10706d.matcher(packageInfoA.versionName);
        return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
    }
}
