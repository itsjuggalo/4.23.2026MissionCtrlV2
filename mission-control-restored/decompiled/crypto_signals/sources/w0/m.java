package w0;

import a.AbstractC0284a;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f10712a;

    static {
        n eVar;
        try {
            eVar = new Y3.j((WebViewProviderFactoryBoundaryInterface) y5.a.i(WebViewProviderFactoryBoundaryInterface.class, AbstractC0284a.i()), 28);
        } catch (ClassNotFoundException unused) {
            eVar = new e();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        f10712a = eVar;
    }
}
