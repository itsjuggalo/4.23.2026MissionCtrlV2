package io.flutter.plugins.firebase.analytics;

import F5.AbstractC0555m;
import X3.h;
import androidx.annotation.Keep;
import b3.C0986c;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class FlutterFirebaseAppRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0986c> getComponents() {
        return AbstractC0555m.b(h.b("flutter-fire-analytics", "11.5.1"));
    }
}
