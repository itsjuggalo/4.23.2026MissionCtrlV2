package io.flutter.plugins.firebase.core;

import androidx.annotation.Keep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l2.AbstractC2328l;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface FlutterFirebasePlugin {
    public static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    AbstractC2328l didReinitializeFirebaseCore();

    AbstractC2328l getPluginConstantsForFirebaseApp(G2.f fVar);
}
