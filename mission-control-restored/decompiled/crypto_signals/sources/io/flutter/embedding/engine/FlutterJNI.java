package io.flutter.embedding.engine;

import A.c;
import N1.C0146y;
import N1.C0149z;
import N1.X;
import P3.h;
import Q3.b;
import Q3.k;
import Q3.l;
import R3.f;
import R3.j;
import S3.a;
import Z3.e;
import Z3.v;
import a4.C0289a;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import e3.w;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.d;
import io.flutter.plugin.platform.i;
import io.flutter.plugin.platform.m;
import io.flutter.plugin.platform.n;
import io.flutter.plugin.platform.o;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static l asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private k accessibilityDelegate;
    private a deferredComponentManager;
    private C0289a localizationPlugin;
    private Long nativeShellHolderId;
    private R3.k platformMessageHandler;
    private o platformViewsController;
    private n platformViewsController2;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<io.flutter.embedding.engine.renderer.l> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    private static void asyncWaitForVsync(long j4) {
        l lVar = asyncWaitForVsyncDelegate;
        if (lVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        io.flutter.view.a aVar = (io.flutter.view.a) lVar;
        aVar.getClass();
        Choreographer choreographer = Choreographer.getInstance();
        X x6 = (X) aVar.f7239a;
        r rVar = (r) x6.f1435d;
        if (rVar != null) {
            rVar.f7353a = j4;
            x6.f1435d = null;
        } else {
            rVar = new r(x6, j4);
        }
        choreographer.postFrameCallback(rVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [Q3.j] */
    public static Bitmap decodeImage(ByteBuffer byteBuffer, final long j4) {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: Q3.j
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    FlutterJNI.lambda$decodeImage$1(j4, imageDecoder, imageInfo, source);
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "Failed to decode image", e);
            return null;
        }
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i, ByteBuffer byteBuffer) {
        e eVar;
        R3.k kVar = this.platformMessageHandler;
        if (kVar == null || (eVar = (e) ((j) kVar).f2826f.remove(Integer.valueOf(i))) == null) {
            return;
        }
        try {
            eVar.a(byteBuffer);
            if (byteBuffer == null || !byteBuffer.isDirect()) {
                return;
            }
            byteBuffer.limit(0);
        } catch (Error e) {
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
                throw e;
            }
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e);
        } catch (Exception e2) {
            Log.e("DartMessenger", "Uncaught exception in binary message reply handler", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$1(long j4, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named unused = ColorSpace.Named.SRGB;
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j4, size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadLibrary$0(String str) {
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j4);

    private native void nativeDeferredComponentInstallFailure(int i, String str, boolean z6);

    private native void nativeDestroy(long j4);

    private native void nativeDispatchEmptyPlatformMessage(long j4, String str, int i);

    private native void nativeDispatchPlatformMessage(long j4, String str, ByteBuffer byteBuffer, int i, int i6);

    private native void nativeDispatchPointerDataPacket(long j4, ByteBuffer byteBuffer, int i);

    private native void nativeDispatchSemanticsAction(long j4, int i, int i6, ByteBuffer byteBuffer, int i7);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i);

    private native Bitmap nativeGetBitmap(long j4);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j4, int i, int i6);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j4, int i);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j4, int i);

    private native void nativeInvokePlatformMessageResponseCallback(long j4, int i, ByteBuffer byteBuffer, int i6);

    private native boolean nativeIsSurfaceControlEnabled(long j4);

    private native void nativeLoadDartDeferredLibrary(long j4, int i, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j4);

    private native void nativeMarkTextureFrameAvailable(long j4, long j6);

    private native void nativeNotifyLowMemoryWarning(long j4);

    private native void nativeOnVsync(long j4, long j6, long j7);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j4, long j6, WeakReference<TextureRegistry$ImageConsumer> weakReference, boolean z6);

    private native void nativeRegisterTexture(long j4, long j6, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j4, String str, String str2, String str3, AssetManager assetManager, List<String> list, long j6);

    private native void nativeScheduleFrame(long j4);

    private native void nativeSetAccessibilityFeatures(long j4, int i);

    private native void nativeSetSemanticsEnabled(long j4, boolean z6);

    private native void nativeSetViewportMetrics(long j4, float f6, int i, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j4, String str, String str2, String str3, List<String> list, long j6);

    private native void nativeSurfaceChanged(long j4, int i, int i6);

    private native void nativeSurfaceCreated(long j4, Surface surface);

    private native void nativeSurfaceDestroyed(long j4);

    private native void nativeSurfaceWindowChanged(long j4, Surface surface);

    private native void nativeUnregisterTexture(long j4, long j6);

    private native void nativeUpdateDisplayMetrics(long j4);

    private native void nativeUpdateJavaAssetManager(long j4, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f6);

    private void onPreEngineRestart() {
        Iterator<b> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        k kVar = this.accessibilityDelegate;
        if (kVar != null) {
            io.flutter.view.a aVar = (io.flutter.view.a) kVar;
            aVar.getClass();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            io.flutter.view.k kVar2 = (io.flutter.view.k) aVar.f7239a;
            kVar2.getClass();
            while (byteBuffer.hasRemaining()) {
                io.flutter.view.e eVarB = kVar2.b(byteBuffer.getInt());
                eVarB.f7267c = byteBuffer.getInt();
                int i = byteBuffer.getInt();
                String str = null;
                eVarB.f7268d = i == -1 ? null : strArr[i];
                int i6 = byteBuffer.getInt();
                if (i6 != -1) {
                    str = strArr[i6];
                }
                eVarB.e = str;
            }
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        k kVar = this.accessibilityDelegate;
        if (kVar != null) {
            ((io.flutter.view.a) kVar).a(byteBuffer, strArr, byteBufferArr);
        }
    }

    public boolean IsSurfaceControlEnabled() {
        return nativeIsSurfaceControlEnabled(this.nativeShellHolderId.longValue());
    }

    public void addEngineLifecycleListener(b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(bVar);
    }

    public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.l lVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(lVar);
    }

    public void applyTransactions() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction transactionF = A1.a.f();
        int i = 0;
        while (true) {
            ArrayList arrayList = nVar.f7173l;
            if (i >= arrayList.size()) {
                transactionF.apply();
                arrayList.clear();
                return;
            } else {
                transactionF = transactionF.merge(m.d(arrayList.get(i)));
                i++;
            }
        }
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j4) {
        nativeCleanupMessageData(j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0134, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013c, code lost:
    
        if (r4.hasNext() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013e, code lost:
    
        r5 = (java.util.Locale) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0150, code lost:
    
        if (r3.getLanguage().equals(r5.toLanguageTag()) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0153, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015b, code lost:
    
        if (r4.hasNext() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015d, code lost:
    
        r5 = (java.util.Locale) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016f, code lost:
    
        if (r3.getLanguage().equals(r5.getLanguage()) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0172, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] computePlatformResolvedLocale(java.lang.String[] r10) {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.computePlatformResolvedLocale(java.lang.String[]):java.lang.String[]");
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        d dVar = new d(oVar.f7182d.getContext(), oVar.f7182d.getWidth(), oVar.f7182d.getHeight(), 2);
        dVar.f7143k = oVar.i;
        int i = oVar.f7192p;
        oVar.f7192p = i + 1;
        oVar.f7190n.put(i, dVar);
        return new FlutterOverlaySurface(i, dVar.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface2() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        if (nVar.f7175n == null) {
            SurfaceControl.Builder builderE = A1.a.e();
            builderE.setBufferSize(nVar.f7167d.getWidth(), nVar.f7167d.getHeight());
            builderE.setFormat(1);
            builderE.setName("Flutter Overlay Surface");
            builderE.setOpaque(false);
            builderE.setHidden(false);
            SurfaceControl surfaceControlBuild = builderE.build();
            SurfaceControl.Transaction transactionBuildReparentTransaction = nVar.f7167d.getRootSurfaceControl().buildReparentTransaction(surfaceControlBuild);
            transactionBuildReparentTransaction.setLayer(surfaceControlBuild, 1000);
            transactionBuildReparentTransaction.apply();
            nVar.f7175n = m.c(surfaceControlBuild);
            nVar.f7176o = surfaceControlBuild;
        }
        return new FlutterOverlaySurface(0, nVar.f7175n);
    }

    public SurfaceControl.Transaction createTransaction() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction transactionF = A1.a.f();
        nVar.f7173l.add(transactionF);
        return transactionF;
    }

    public void deferredComponentInstallFailure(int i, String str, boolean z6) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i, str, z6);
    }

    public void destroyOverlaySurface2() {
        ensureRunningOnMainThread();
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        Surface surface = nVar.f7175n;
        if (surface != null) {
            surface.release();
            nVar.f7175n = null;
            nVar.f7176o = null;
        }
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        oVar.c();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i, int i6) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i, i6);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i6);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, io.flutter.view.d dVar) {
        dispatchSemanticsAction(i, dVar, null);
    }

    public void endFrame2() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction transactionF = A1.a.f();
        int i = 0;
        while (true) {
            ArrayList arrayList = nVar.f7174m;
            if (i >= arrayList.size()) {
                arrayList.clear();
                nVar.f7167d.invalidate();
                nVar.f7167d.getRootSurfaceControl().applyTransactionOnDraw(transactionF);
                return;
            }
            transactionF = transactionF.merge(m.d(arrayList.get(i)));
            i++;
        }
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float getScaledFontSize(float r7, int r8) {
        /*
            r6 = this;
            s1.k r0 = Y3.l.f3669b
            java.lang.Object r1 = r0.f9531c
            Y3.k r1 = (Y3.k) r1
            java.lang.Object r2 = r0.f9530b
            java.util.concurrent.ConcurrentLinkedQueue r2 = (java.util.concurrent.ConcurrentLinkedQueue) r2
            if (r1 != 0) goto L14
            java.lang.Object r1 = r2.poll()
            Y3.k r1 = (Y3.k) r1
            r0.f9531c = r1
        L14:
            java.lang.Object r1 = r0.f9531c
            Y3.k r1 = (Y3.k) r1
            if (r1 == 0) goto L27
            int r3 = r1.f3667a
            if (r3 >= r8) goto L27
            java.lang.Object r1 = r2.poll()
            Y3.k r1 = (Y3.k) r1
            r0.f9531c = r1
            goto L14
        L27:
            r2 = 0
            java.lang.String r3 = "Cannot find config with generation: "
            java.lang.String r4 = "SettingsChannel"
            if (r1 != 0) goto L48
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r1 = java.lang.String.valueOf(r8)
            r0.append(r1)
            java.lang.String r1 = ", after exhausting the queue."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
        L46:
            r1 = r2
            goto L72
        L48:
            int r5 = r1.f3667a
            if (r5 == r8) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r3 = java.lang.String.valueOf(r8)
            r1.append(r3)
            java.lang.String r3 = ", the oldest config is now: "
            r1.append(r3)
            java.lang.Object r0 = r0.f9531c
            Y3.k r0 = (Y3.k) r0
            int r0 = r0.f3667a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r4, r0)
            goto L46
        L72:
            if (r1 != 0) goto L75
            goto L77
        L75:
            android.util.DisplayMetrics r2 = r1.f3668b
        L77:
            if (r2 != 0) goto L98
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "getScaledFontSize called with configurationId "
            r7.<init>(r0)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.append(r8)
            java.lang.String r8 = ", which can't be found."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "FlutterJNI"
            android.util.Log.e(r8, r7)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            return r7
        L98:
            r8 = 2
            float r7 = android.util.TypedValue.applyDimension(r8, r7, r2)
            float r8 = r2.density
            float r7 = r7 / r8
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.getScaledFontSize(float, int):float");
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i, long j4) {
        f fVar;
        boolean z6;
        R3.k kVar = this.platformMessageHandler;
        if (kVar == null) {
            nativeCleanupMessageData(j4);
            return;
        }
        j jVar = (j) kVar;
        synchronized (jVar.f2825d) {
            try {
                fVar = (f) jVar.f2823b.get(str);
                z6 = jVar.e.get() && fVar == null;
                if (z6) {
                    if (!jVar.f2824c.containsKey(str)) {
                        jVar.f2824c.put(str, new LinkedList());
                    }
                    ((List) jVar.f2824c.get(str)).add(new R3.d(j4, byteBuffer, i));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z6) {
            return;
        }
        jVar.a(str, fVar, byteBuffer, i, j4);
    }

    public void hideOverlaySurface2() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (nVar.f7176o == null) {
            return;
        }
        SurfaceControl.Transaction transactionF = A1.a.f();
        transactionF.setVisibility(nVar.f7176o, false);
        transactionF.apply();
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j4, int i) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j4, i);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v9, types: [io.flutter.embedding.engine.FlutterJNI] */
    public void invokePlatformMessageResponseCallback(int i, ByteBuffer byteBuffer, int i6) throws Throwable {
        FlutterJNI flutterJNIIsAttached;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            flutterJNIIsAttached = isAttached();
            try {
                if (flutterJNIIsAttached != 0) {
                    FlutterJNI flutterJNI = this;
                    flutterJNI.nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i, byteBuffer, i6);
                    flutterJNIIsAttached = flutterJNI;
                } else {
                    flutterJNIIsAttached = this;
                    Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
                }
                flutterJNIIsAttached.shellHolderLock.readLock().unlock();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                flutterJNIIsAttached.shellHolderLock.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            flutterJNIIsAttached = this;
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i) {
        return nativeFlutterTextUtilsIsEmoji(i);
    }

    public boolean isCodePointEmojiModifier(int i) {
        return nativeFlutterTextUtilsIsEmojiModifier(i);
    }

    public boolean isCodePointEmojiModifierBase(int i) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i);
    }

    public boolean isCodePointRegionalIndicator(int i) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i);
    }

    public boolean isCodePointVariantSelector(int i) {
        return nativeFlutterTextUtilsIsVariationSelector(i);
    }

    public void loadDartDeferredLibrary(int i, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i, strArr);
    }

    public void loadLibrary(Context context) throws Throwable {
        c cVar;
        String[] strArrI;
        ZipFile zipFile;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        C2.c cVar2 = new C2.c(11);
        w wVar = new w(10);
        wVar.e = cVar2;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        wVar.y("Beginning load of %s...", "flutter");
        C0149z c0149z = (C0149z) wVar.f6192c;
        HashSet hashSet = (HashSet) wVar.f6191b;
        if (hashSet.contains("flutter")) {
            wVar.y("%s already loaded previously!", "flutter");
        } else {
            try {
                c0149z.getClass();
                System.loadLibrary("flutter");
                hashSet.add("flutter");
                wVar.y("%s (%s) was loaded normally!", "flutter", null);
            } catch (UnsatisfiedLinkError e) {
                wVar.y("Loading the library normally failed: %s", Log.getStackTraceString(e));
                wVar.y("%s (%s) was not loaded normally, re-linking...", "flutter", null);
                File fileU = wVar.u(context);
                if (!fileU.exists()) {
                    File dir = context.getDir("lib", 0);
                    File fileU2 = wVar.u(context);
                    c0149z.getClass();
                    File[] fileArrListFiles = dir.listFiles(new U0.a(System.mapLibraryName("flutter")));
                    if (fileArrListFiles != null) {
                        for (File file : fileArrListFiles) {
                            if (!file.getAbsolutePath().equals(fileU2.getAbsolutePath())) {
                                file.delete();
                            }
                        }
                    }
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (strArr.length <= 0) {
                        String str = Build.CPU_ABI2;
                        strArr = (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
                    }
                    String strMapLibraryName = System.mapLibraryName("flutter");
                    ((C0146y) wVar.f6193d).getClass();
                    try {
                        c cVarF = C0146y.f(context, strArr, strMapLibraryName, wVar);
                        try {
                            if (cVarF == null) {
                                try {
                                    strArrI = C0146y.i(context, strMapLibraryName);
                                } catch (Exception e2) {
                                    strArrI = new String[]{e2.toString()};
                                }
                                StringBuilder sbP = a3.d.p("Could not find '", strMapLibraryName, "'. Looked for: ");
                                sbP.append(Arrays.toString(strArr));
                                sbP.append(", but only found: ");
                                throw new G4.e(AbstractC1024h.d(sbP, Arrays.toString(strArrI), "."));
                            }
                            int i = 0;
                            while (true) {
                                int i6 = i + 1;
                                zipFile = (ZipFile) cVarF.f7b;
                                if (i < 5) {
                                    wVar.y("Found %s! Extracting...", strMapLibraryName);
                                    try {
                                        if (fileU.exists() || fileU.createNewFile()) {
                                            try {
                                                inputStream2 = zipFile.getInputStream((ZipEntry) cVarF.f8c);
                                                try {
                                                    fileOutputStream2 = new FileOutputStream(fileU);
                                                    try {
                                                        byte[] bArr = new byte[4096];
                                                        long j4 = 0;
                                                        while (true) {
                                                            int i7 = inputStream2.read(bArr);
                                                            if (i7 == -1) {
                                                                break;
                                                            }
                                                            fileOutputStream2.write(bArr, 0, i7);
                                                            j4 += (long) i7;
                                                        }
                                                        fileOutputStream2.flush();
                                                        fileOutputStream2.getFD().sync();
                                                        if (j4 == fileU.length()) {
                                                            C0146y.d(inputStream2);
                                                            C0146y.d(fileOutputStream2);
                                                            fileU.setReadable(true, false);
                                                            fileU.setExecutable(true, false);
                                                            fileU.setWritable(true);
                                                            break;
                                                        }
                                                        C0146y.d(inputStream2);
                                                        C0146y.d(fileOutputStream2);
                                                    } catch (FileNotFoundException unused) {
                                                        C0146y.d(inputStream2);
                                                        C0146y.d(fileOutputStream2);
                                                        i = i6;
                                                    } catch (IOException unused2) {
                                                        C0146y.d(inputStream2);
                                                        C0146y.d(fileOutputStream2);
                                                        i = i6;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream = inputStream2;
                                                        fileOutputStream = fileOutputStream2;
                                                        C0146y.d(inputStream);
                                                        C0146y.d(fileOutputStream);
                                                        throw th;
                                                    }
                                                } catch (FileNotFoundException unused3) {
                                                    fileOutputStream2 = null;
                                                    C0146y.d(inputStream2);
                                                    C0146y.d(fileOutputStream2);
                                                    i = i6;
                                                } catch (IOException unused4) {
                                                    fileOutputStream2 = null;
                                                    C0146y.d(inputStream2);
                                                    C0146y.d(fileOutputStream2);
                                                    i = i6;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream = inputStream2;
                                                    fileOutputStream = null;
                                                    C0146y.d(inputStream);
                                                    C0146y.d(fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException unused5) {
                                                inputStream2 = null;
                                            } catch (IOException unused6) {
                                                inputStream2 = null;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = null;
                                            }
                                        }
                                    } catch (IOException unused7) {
                                    }
                                    i = i6;
                                } else if (((C2.c) wVar.e) != null) {
                                    lambda$loadLibrary$0("FATAL! Couldn't extract the library from the APK!");
                                }
                            }
                            try {
                                zipFile.close();
                            } catch (IOException unused8) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cVar = cVarF;
                            if (cVar != null) {
                                try {
                                    ((ZipFile) cVar.f7b).close();
                                } catch (IOException unused9) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cVar = null;
                    }
                }
                String absolutePath = fileU.getAbsolutePath();
                c0149z.getClass();
                System.load(absolutePath);
                hashSet.add("flutter");
                wVar.y("%s (%s) was re-linked!", "flutter", null);
            }
        }
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j4);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        oVar.f7195s.clear();
        oVar.f7196t.clear();
    }

    public void onDisplayOverlaySurface(int i, int i6, int i7, int i8, int i9) {
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        SparseArray sparseArray = oVar.f7190n;
        if (sparseArray.get(i) == null) {
            throw new IllegalStateException(a3.d.i("The overlay surface (id:", i, ") doesn't exist"));
        }
        oVar.i();
        View view = (d) sparseArray.get(i);
        if (view.getParent() == null) {
            oVar.f7182d.addView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        view.setLayoutParams(layoutParams);
        view.setVisibility(0);
        view.bringToFront();
        oVar.f7195s.add(Integer.valueOf(i));
    }

    public void onDisplayPlatformView(int i, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        oVar.i();
        SparseArray sparseArray = oVar.f7188l;
        io.flutter.plugin.platform.f fVar = (io.flutter.plugin.platform.f) sparseArray.get(i);
        if (fVar == null) {
            return;
        }
        SparseArray sparseArray2 = oVar.f7189m;
        if (sparseArray2.get(i) == null) {
            View view = fVar.getView();
            if (view == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            Activity activity = oVar.f7181c;
            U3.b bVar = new U3.b(activity, activity.getResources().getDisplayMetrics().density, oVar.f7180b);
            bVar.setOnDescendantFocusChangeListener(new i(oVar, i, 0));
            sparseArray2.put(i, bVar);
            view.setImportantForAccessibility(4);
            bVar.addView(view);
            oVar.f7182d.addView(bVar);
        }
        U3.b bVar2 = (U3.b) sparseArray2.get(i);
        bVar2.f3173a = flutterMutatorsStack;
        bVar2.f3175c = i6;
        bVar2.f3176d = i7;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        bVar2.setLayoutParams(layoutParams);
        bVar2.setWillNotDraw(false);
        bVar2.setVisibility(0);
        bVar2.bringToFront();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i10, i11);
        View view2 = ((io.flutter.plugin.platform.f) sparseArray.get(i)).getView();
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
            view2.bringToFront();
        }
        oVar.f7196t.add(Integer.valueOf(i));
    }

    public void onDisplayPlatformView2(int i, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        SparseArray sparseArray = nVar.i;
        io.flutter.plugin.platform.f fVar = (io.flutter.plugin.platform.f) sparseArray.get(i);
        if (fVar == null) {
            return;
        }
        SparseArray sparseArray2 = nVar.f7171j;
        if (sparseArray2.get(i) == null) {
            View view = fVar.getView();
            if (view == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            Activity activity = nVar.f7166c;
            U3.b bVar = new U3.b(activity, activity.getResources().getDisplayMetrics().density, nVar.f7165b);
            bVar.setOnDescendantFocusChangeListener(new i(nVar, i, 1));
            sparseArray2.put(i, bVar);
            view.setImportantForAccessibility(4);
            bVar.addView(view);
            nVar.f7167d.addView(bVar);
        }
        U3.b bVar2 = (U3.b) sparseArray2.get(i);
        bVar2.f3173a = flutterMutatorsStack;
        bVar2.f3175c = i6;
        bVar2.f3176d = i7;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        bVar2.setLayoutParams(layoutParams);
        bVar2.setWillNotDraw(false);
        bVar2.setVisibility(0);
        bVar2.bringToFront();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i10, i11);
        View view2 = ((io.flutter.plugin.platform.f) sparseArray.get(i)).getView();
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
            view2.bringToFront();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, io.flutter.embedding.engine.renderer.m] */
    public void onEndFrame() {
        ?? r32;
        ensureRunningOnMainThread();
        o oVar = this.platformViewsController;
        if (oVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        boolean z6 = false;
        if (!oVar.f7193q || !oVar.f7196t.isEmpty()) {
            if (oVar.f7193q) {
                h hVar = oVar.f7182d.f2566c;
                if (hVar != null ? hVar.e() : false) {
                    z6 = true;
                }
            }
            oVar.f(z6);
            return;
        }
        oVar.f7193q = false;
        P3.n nVar = oVar.f7182d;
        E3.d dVar = new E3.d(oVar, 20);
        h hVar2 = nVar.f2566c;
        if (hVar2 == null || (r32 = nVar.e) == 0) {
            return;
        }
        nVar.f2567d = r32;
        nVar.e = null;
        io.flutter.embedding.engine.renderer.k kVar = nVar.f2570l.f2706b;
        if (kVar != null) {
            r32.b();
            kVar.a(new P3.m(nVar, kVar, dVar));
            return;
        }
        hVar2.a();
        h hVar3 = nVar.f2566c;
        if (hVar3 != null) {
            hVar3.f2544a.close();
            nVar.removeView(nVar.f2566c);
            nVar.f2566c = null;
        }
        dVar.run();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<io.flutter.embedding.engine.renderer.l> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<io.flutter.embedding.engine.renderer.l> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void onSurfaceChanged(int i, int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i, i6);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j4, long j6, long j7) {
        nativeOnVsync(j4, j6, j7);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j4, TextureRegistry$ImageConsumer textureRegistry$ImageConsumer, boolean z6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j4, new WeakReference<>(textureRegistry$ImageConsumer), z6);
    }

    public void registerTexture(long j4, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j4, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(bVar);
    }

    public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.l lVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(lVar);
    }

    public void requestDartDeferredLibrary(int i) {
        Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list, long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list, j4);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(k kVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = kVar;
    }

    public void setAccessibilityFeatures(int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setAccessibilityFeaturesInNative(i);
        }
    }

    public void setAccessibilityFeaturesInNative(int i) {
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i);
    }

    public void setAsyncWaitForVsyncDelegate(l lVar) {
        asyncWaitForVsyncDelegate = lVar;
    }

    public void setDeferredComponentManager(a aVar) {
        ensureRunningOnMainThread();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setLocalizationPlugin(C0289a c0289a) {
        ensureRunningOnMainThread();
        this.localizationPlugin = c0289a;
    }

    public void setPlatformMessageHandler(R3.k kVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = kVar;
    }

    public void setPlatformViewsController(o oVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = oVar;
    }

    public void setPlatformViewsController2(n nVar) {
        ensureRunningOnMainThread();
        this.platformViewsController2 = nVar;
    }

    public void setRefreshRateFPS(float f6) {
        refreshRateFPS = f6;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z6) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setSemanticsEnabledInNative(z6);
        }
    }

    public void setSemanticsEnabledInNative(boolean z6) {
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z6);
    }

    public void setViewportMetrics(float f6, int i, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f6, i, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, iArr, iArr2, iArr3);
    }

    public void showOverlaySurface2() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (nVar.f7176o == null) {
            return;
        }
        SurfaceControl.Transaction transactionF = A1.a.f();
        transactionF.setVisibility(nVar.f7176o, true);
        transactionF.apply();
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list, long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI flutterJNINativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list, j4);
        Long l6 = flutterJNINativeSpawn.nativeShellHolderId;
        if ((l6 == null || l6.longValue() == 0) ? false : true) {
            return flutterJNINativeSpawn;
        }
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    }

    public void swapTransactions() {
        n nVar = this.platformViewsController2;
        if (nVar == null) {
            throw new RuntimeException("");
        }
        synchronized (nVar) {
            try {
                nVar.f7174m.clear();
                for (int i = 0; i < nVar.f7173l.size(); i++) {
                    nVar.f7174m.add(m.d(nVar.f7173l.get(i)));
                }
                nVar.f7173l.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterTexture(long j4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j4);
    }

    public void updateDisplayMetrics(int i, float f6, float f7, float f8) {
        displayWidth = f6;
        displayHeight = f7;
        displayDensity = f8;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i, io.flutter.view.d dVar, Object obj) {
        ByteBuffer byteBufferA;
        int iPosition;
        ensureAttachedToNative();
        if (obj != null) {
            byteBufferA = v.f4019a.a(obj);
            iPosition = byteBufferA.position();
        } else {
            byteBufferA = null;
            iPosition = 0;
        }
        dispatchSemanticsAction(i, dVar.f7264a, byteBufferA, iPosition);
    }

    public void dispatchSemanticsAction(int i, int i6, ByteBuffer byteBuffer, int i7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i, i6, byteBuffer, i7);
    }
}
