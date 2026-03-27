package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import io.flutter.plugins.webviewflutter.WebViewProxyApi;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidWebkitLibraryPigeonInstanceManager {
    public static final Companion Companion = new Companion(null);
    private static final long minHostCreatedIdentifier = 65536;
    private static final String tag = "PigeonInstanceManager";
    private long clearFinalizedWeakReferencesInterval;
    private final PigeonFinalizationListener finalizationListener;
    private final Handler handler;
    private boolean hasFinalizationListenerStopped;
    private final WeakHashMap<Object, Long> identifiers;
    private long nextIdentifier;
    private final ReferenceQueue<Object> referenceQueue;
    private final Runnable releaseAllFinalizedInstancesRunnable;
    private final HashMap<Long, Object> strongInstances;
    private final HashMap<Long, WeakReference<Object>> weakInstances;
    private final HashMap<WeakReference<Object>, Long> weakReferencesToIdentifiers;

    public static final class Companion {
        private Companion() {
        }

        public final AndroidWebkitLibraryPigeonInstanceManager create(PigeonFinalizationListener finalizationListener) {
            AbstractC2304t.f(finalizationListener, "finalizationListener");
            return new AndroidWebkitLibraryPigeonInstanceManager(finalizationListener);
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public interface PigeonFinalizationListener {
        void onFinalize(long j8);
    }

    public AndroidWebkitLibraryPigeonInstanceManager(PigeonFinalizationListener finalizationListener) {
        AbstractC2304t.f(finalizationListener, "finalizationListener");
        this.finalizationListener = finalizationListener;
        this.identifiers = new WeakHashMap<>();
        this.weakInstances = new HashMap<>();
        this.strongInstances = new HashMap<>();
        this.referenceQueue = new ReferenceQueue<>();
        this.weakReferencesToIdentifiers = new HashMap<>();
        Handler handler = new Handler(Looper.getMainLooper());
        this.handler = handler;
        Runnable runnable = new Runnable() { // from class: io.flutter.plugins.webviewflutter.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f19452a.releaseAllFinalizedInstances();
            }
        };
        this.releaseAllFinalizedInstancesRunnable = runnable;
        this.nextIdentifier = minHostCreatedIdentifier;
        this.clearFinalizedWeakReferencesInterval = 3000L;
        handler.postDelayed(runnable, 3000L);
    }

    private final void addInstance(Object obj, long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException(("Identifier must be >= 0: " + j8).toString());
        }
        if (!(!this.weakInstances.containsKey(Long.valueOf(j8)))) {
            throw new IllegalArgumentException(("Identifier has already been added: " + j8).toString());
        }
        WeakReference<Object> weakReference = new WeakReference<>(obj, this.referenceQueue);
        this.identifiers.put(obj, Long.valueOf(j8));
        this.weakInstances.put(Long.valueOf(j8), weakReference);
        this.weakReferencesToIdentifiers.put(weakReference, Long.valueOf(j8));
        this.strongInstances.put(Long.valueOf(j8), obj);
    }

    private final void logWarningIfFinalizationListenerHasStopped() {
        if (hasFinalizationListenerStopped()) {
            Log.w(tag, "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseAllFinalizedInstances() {
        if (hasFinalizationListenerStopped()) {
            return;
        }
        while (true) {
            WeakReference weakReference = (WeakReference) this.referenceQueue.poll();
            if (weakReference == null) {
                this.handler.postDelayed(this.releaseAllFinalizedInstancesRunnable, this.clearFinalizedWeakReferencesInterval);
                return;
            }
            Long l8 = (Long) kotlin.jvm.internal.V.a(this.weakReferencesToIdentifiers).remove(weakReference);
            if (l8 != null) {
                this.weakInstances.remove(l8);
                this.strongInstances.remove(l8);
                this.finalizationListener.onFinalize(l8.longValue());
            }
        }
    }

    public final void addDartCreatedInstance(Object instance, long j8) {
        AbstractC2304t.f(instance, "instance");
        logWarningIfFinalizationListenerHasStopped();
        addInstance(instance, j8);
    }

    public final long addHostCreatedInstance(Object instance) {
        AbstractC2304t.f(instance, "instance");
        logWarningIfFinalizationListenerHasStopped();
        if (!containsInstance(instance)) {
            long j8 = this.nextIdentifier;
            this.nextIdentifier = 1 + j8;
            addInstance(instance, j8);
            return j8;
        }
        throw new IllegalArgumentException(("Instance of " + instance.getClass() + " has already been added.").toString());
    }

    public final void clear() {
        this.identifiers.clear();
        this.weakInstances.clear();
        this.strongInstances.clear();
        this.weakReferencesToIdentifiers.clear();
    }

    public final boolean containsInstance(Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        return this.identifiers.containsKey(obj);
    }

    public final long getClearFinalizedWeakReferencesInterval() {
        return this.clearFinalizedWeakReferencesInterval;
    }

    public final Long getIdentifierForStrongReference(Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        Long l8 = this.identifiers.get(obj);
        if (l8 != null) {
            HashMap<Long, Object> map = this.strongInstances;
            AbstractC2304t.c(obj);
            map.put(l8, obj);
        }
        return l8;
    }

    public final <T> T getInstance(long j8) {
        logWarningIfFinalizationListenerHasStopped();
        WeakReference<Object> weakReference = this.weakInstances.get(Long.valueOf(j8));
        if (weakReference != null) {
            return (T) weakReference.get();
        }
        return null;
    }

    public final boolean hasFinalizationListenerStopped() {
        return this.hasFinalizationListenerStopped;
    }

    public final <T> T remove(long j8) {
        logWarningIfFinalizationListenerHasStopped();
        Object androidWebkitLibraryPigeonInstanceManager = getInstance(j8);
        if (androidWebkitLibraryPigeonInstanceManager instanceof WebViewProxyApi.WebViewPlatformView) {
            ((WebViewProxyApi.WebViewPlatformView) androidWebkitLibraryPigeonInstanceManager).destroy();
        }
        return (T) this.strongInstances.remove(Long.valueOf(j8));
    }

    public final void setClearFinalizedWeakReferencesInterval(long j8) {
        this.handler.removeCallbacks(this.releaseAllFinalizedInstancesRunnable);
        this.clearFinalizedWeakReferencesInterval = j8;
        releaseAllFinalizedInstances();
    }

    public final void stopFinalizationListener() {
        this.handler.removeCallbacks(this.releaseAllFinalizedInstancesRunnable);
        this.hasFinalizationListenerStopped = true;
    }
}
