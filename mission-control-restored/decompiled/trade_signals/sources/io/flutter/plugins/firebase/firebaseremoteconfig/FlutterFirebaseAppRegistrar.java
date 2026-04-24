package io.flutter.plugins.firebase.firebaseremoteconfig;

import M2.C0700c;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FlutterFirebaseAppRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0700c> getComponents() {
        return AbstractC2594p.e(a4.h.b(BuildConfig.LIBRARY_NAME, BuildConfig.LIBRARY_VERSION));
    }
}
