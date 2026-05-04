package io.flutter.plugins.firebase.appcheck;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FlutterFirebaseAppRegistrar implements ComponentRegistrar, f7.c {
    private static final String DEBUG_SECRET_NAME = "fire-app-check-debug-secret";
    public static String debugToken;

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<o7.c> getComponents() {
        return Arrays.asList(oa.h.b(BuildConfig.LIBRARY_NAME, BuildConfig.LIBRARY_VERSION), o7.c.c(f7.c.class).h(DEBUG_SECRET_NAME).f(new o7.g() { // from class: io.flutter.plugins.firebase.appcheck.i
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return this.f12678a.lambda$getComponents$0(dVar);
            }
        }).d());
    }

    @Override // f7.c
    public String getDebugSecret() {
        return debugToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f7.c lambda$getComponents$0(o7.d dVar) {
        return this;
    }
}
