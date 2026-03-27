package io.flutter.plugins.firebase.firestore;

import X3.h;
import androidx.annotation.Keep;
import b3.C0986c;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FlutterFirebaseFirestoreRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0986c> getComponents() {
        return Collections.singletonList(h.b("flutter-fire-fst", "5.6.10"));
    }
}
