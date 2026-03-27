package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    private static Class[] VIEW_TYPES_REQUIRE_NON_TLHC = {SurfaceView.class};
    private static boolean enableImageRenderTarget = true;
    private static boolean enableSurfaceProducerRenderTarget = true;
    private AndroidTouchProcessor androidTouchProcessor;
    private Context context;
    private FlutterView flutterView;
    private PlatformViewsChannel platformViewsChannel;
    private TextInputPlugin textInputPlugin;
    TextureRegistry textureRegistry;
    private FlutterJNI flutterJNI = null;
    private int nextOverlayLayerId = 0;
    private boolean flutterViewConvertedToImageView = false;
    private boolean synchronizeToNativeViewHierarchy = true;
    private boolean usesSoftwareRendering = false;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new AnonymousClass1();
    private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    final HashMap<Context, View> contextToEmbeddedView = new HashMap<>();
    private final SparseArray<PlatformOverlayView> overlayLayerViews = new SparseArray<>();
    private final HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private final HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    private final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();
    private final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* JADX INFO: renamed from: io.flutter.plugin.platform.PlatformViewsController$1, reason: invalid class name */
    public class AnonymousClass1 implements PlatformViewsChannel.PlatformViewsHandler {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, VirtualDisplayController virtualDisplayController, float f4, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
            if (PlatformViewsController.this.context != null) {
                f4 = PlatformViewsController.this.getDisplayDensity();
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetWidth(), f4), PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetHeight(), f4)));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void clearFocus(int i4) {
            View view;
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i4)).getView();
            } else {
                PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i4);
                if (platformView == null) {
                    Log.e(PlatformViewsController.TAG, "Clearing focus on an unknown view with id: " + i4);
                    return;
                }
                view = platformView.getView();
            }
            if (view != null) {
                view.clearFocus();
                return;
            }
            Log.e(PlatformViewsController.TAG, "Clearing focus on a null view with id: " + i4);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void createForPlatformViewLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.enforceMinimumAndroidApiVersion(19);
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            PlatformViewsController.this.throwIfHCPPEnabled();
            PlatformViewsController.this.configureForHybridComposition(PlatformViewsController.this.createPlatformView(platformViewCreationRequest, false), platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public long createForTextureLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            int i4 = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i4) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i4);
            }
            PlatformViewsController platformViewsController = PlatformViewsController.this;
            if (platformViewsController.textureRegistry == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i4);
            }
            if (platformViewsController.flutterView == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i4);
            }
            PlatformView platformViewCreatePlatformView = PlatformViewsController.this.createPlatformView(platformViewCreationRequest, true);
            View view = platformViewCreatePlatformView.getView();
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            if (ViewUtils.hasChildViewOfType(view, PlatformViewsController.VIEW_TYPES_REQUIRE_NON_TLHC)) {
                if (platformViewCreationRequest.displayMode == PlatformViewsChannel.PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK) {
                    PlatformViewsController.this.configureForHybridComposition(platformViewCreatePlatformView, platformViewCreationRequest);
                    return -2L;
                }
                if (!PlatformViewsController.this.usesSoftwareRendering) {
                    return PlatformViewsController.this.configureForVirtualDisplay(platformViewCreatePlatformView, platformViewCreationRequest);
                }
            }
            return PlatformViewsController.this.configureForTextureLayerComposition(platformViewCreatePlatformView, platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void dispose(int i4) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i4);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Disposing unknown platform view with id: " + i4);
                return;
            }
            if (platformView.getView() != null) {
                View view = platformView.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            PlatformViewsController.this.platformViews.remove(i4);
            try {
                platformView.dispose();
            } catch (RuntimeException e4) {
                Log.e(PlatformViewsController.TAG, "Disposing platform view threw an exception", e4);
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i4));
                View view2 = virtualDisplayController.getView();
                if (view2 != null) {
                    PlatformViewsController.this.contextToEmbeddedView.remove(view2.getContext());
                }
                virtualDisplayController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i4));
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i4);
            if (platformViewWrapper != null) {
                platformViewWrapper.removeAllViews();
                platformViewWrapper.release();
                platformViewWrapper.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) platformViewWrapper.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(platformViewWrapper);
                }
                PlatformViewsController.this.viewWrappers.remove(i4);
                return;
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i4);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup3 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(flutterMutatorView);
                }
                PlatformViewsController.this.platformViewParent.remove(i4);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void offset(int i4, double d4, double d5) {
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i4);
            if (platformViewWrapper == null) {
                Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i4);
                return;
            }
            int physicalPixels = PlatformViewsController.this.toPhysicalPixels(d4);
            int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(d5);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
            layoutParams.topMargin = physicalPixels;
            layoutParams.leftMargin = physicalPixels2;
            platformViewWrapper.setLayoutParams(layoutParams);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void onTouch(PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i4 = platformViewTouch.viewId;
            float f4 = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(i4)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f4, platformViewTouch, true));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i4);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i4);
                return;
            }
            View view = platformView.getView();
            if (view != null) {
                view.dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f4, platformViewTouch, false));
                return;
            }
            Log.e(PlatformViewsController.TAG, "Sending touch to a null view with id: " + i4);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void resize(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, final PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            int physicalPixels = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
            int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
            int i4 = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                final float displayDensity = PlatformViewsController.this.getDisplayDensity();
                final VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i4));
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(physicalPixels, physicalPixels2, new Runnable() { // from class: io.flutter.plugin.platform.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlatformViewsController.AnonymousClass1.a(this.f12313a, virtualDisplayController, displayDensity, platformViewBufferResized);
                    }
                });
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i4);
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i4);
            if (platformView == null || platformViewWrapper == null) {
                Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i4);
                return;
            }
            if (physicalPixels > platformViewWrapper.getRenderTargetWidth() || physicalPixels2 > platformViewWrapper.getRenderTargetHeight()) {
                platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
            }
            ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
            layoutParams.width = physicalPixels;
            layoutParams.height = physicalPixels2;
            platformViewWrapper.setLayoutParams(layoutParams);
            View view = platformView.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = physicalPixels;
                layoutParams2.height = physicalPixels2;
                view.setLayoutParams(layoutParams2);
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetWidth()), PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetHeight())));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void setDirection(int i4, int i5) {
            View view;
            if (!PlatformViewsController.validateDirection(i5)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i5 + "(view id: " + i4 + ")");
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i4)) {
                view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i4)).getView();
            } else {
                PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i4);
                if (platformView == null) {
                    Log.e(PlatformViewsController.TAG, "Setting direction to an unknown view with id: " + i4);
                    return;
                }
                view = platformView.getView();
            }
            if (view != null) {
                view.setLayoutDirection(i5);
                return;
            }
            Log.e(PlatformViewsController.TAG, "Setting direction to a null view with id: " + i4);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void synchronizeToNativeViewHierarchy(boolean z4) {
            PlatformViewsController.this.synchronizeToNativeViewHierarchy = z4;
        }
    }

    public static /* synthetic */ void a(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z4) {
        if (z4) {
            platformViewsController.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
        } else {
            platformViewsController.getClass();
        }
    }

    public static /* synthetic */ void b(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z4) {
        if (z4) {
            platformViewsController.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            return;
        }
        TextInputPlugin textInputPlugin = platformViewsController.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(platformViewCreationRequest.viewId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureForHybridComposition(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(19);
        Log.i(TAG, "Using hybrid composition for platform view: " + platformViewCreationRequest.viewId);
        throwIfHCPPEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long configureForVirtualDisplay(PlatformView platformView, final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(20);
        Log.i(TAG, "Hosting view in a virtual display for platform view: " + platformViewCreationRequest.viewId);
        PlatformViewRenderTarget platformViewRenderTargetMakePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
        VirtualDisplayController virtualDisplayControllerCreate = VirtualDisplayController.create(this.context, this.accessibilityEventsDelegate, platformView, platformViewRenderTargetMakePlatformViewRenderTarget, toPhysicalPixels(platformViewCreationRequest.logicalWidth), toPhysicalPixels(platformViewCreationRequest.logicalHeight), platformViewCreationRequest.viewId, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.i
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z4) {
                PlatformViewsController.a(this.f12310a, platformViewCreationRequest, view, z4);
            }
        });
        if (virtualDisplayControllerCreate != null) {
            this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), virtualDisplayControllerCreate);
            View view = platformView.getView();
            this.contextToEmbeddedView.put(view.getContext(), view);
            return platformViewRenderTargetMakePlatformViewRenderTarget.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
    }

    public static /* synthetic */ void d(PlatformViewsController platformViewsController, int i4, View view, boolean z4) {
        if (z4) {
            platformViewsController.platformViewsChannel.invokeViewFocused(i4);
            return;
        }
        TextInputPlugin textInputPlugin = platformViewsController.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i4);
        }
    }

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enforceMinimumAndroidApiVersion(int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= i4) {
            return;
        }
        throw new IllegalStateException("Trying to use platform views with API " + i5 + ", required API level is: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureValidRequest(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        if (validateDirection(platformViewCreationRequest.direction)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishFrame(boolean z4) {
        for (int i4 = 0; i4 < this.overlayLayerViews.size(); i4++) {
            int iKeyAt = this.overlayLayerViews.keyAt(i4);
            PlatformOverlayView platformOverlayViewValueAt = this.overlayLayerViews.valueAt(i4);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(iKeyAt))) {
                this.flutterView.attachOverlaySurfaceToRender(platformOverlayViewValueAt);
                z4 &= platformOverlayViewValueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    platformOverlayViewValueAt.detachFromRenderer();
                }
                platformOverlayViewValueAt.setVisibility(8);
                this.flutterView.removeView(platformOverlayViewValueAt);
            }
        }
        for (int i5 = 0; i5 < this.platformViewParent.size(); i5++) {
            int iKeyAt2 = this.platformViewParent.keyAt(i5);
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(iKeyAt2);
            if (!this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(iKeyAt2)) || (!z4 && this.synchronizeToNativeViewHierarchy)) {
                flutterMutatorView.setVisibility(8);
            } else {
                flutterMutatorView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (!this.synchronizeToNativeViewHierarchy || this.flutterViewConvertedToImageView) {
            return;
        }
        this.flutterView.convertToImageView();
        this.flutterViewConvertedToImageView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    private static PlatformViewRenderTarget makePlatformViewRenderTarget(TextureRegistry textureRegistry) {
        int i4;
        if (enableSurfaceProducerRenderTarget && (i4 = Build.VERSION.SDK_INT) >= 29) {
            TextureRegistry.SurfaceProducer surfaceProducerCreateSurfaceProducer = textureRegistry.createSurfaceProducer(i4 <= 34 ? TextureRegistry.SurfaceLifecycle.resetInBackground : TextureRegistry.SurfaceLifecycle.manual);
            Log.i(TAG, "PlatformView is using SurfaceProducer backend");
            return new SurfaceProducerPlatformViewRenderTarget(surfaceProducerCreateSurfaceProducer);
        }
        if (!enableImageRenderTarget || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntryCreateSurfaceTexture = textureRegistry.createSurfaceTexture();
            Log.i(TAG, "PlatformView is using SurfaceTexture backend");
            return new SurfaceTexturePlatformViewRenderTarget(surfaceTextureEntryCreateSurfaceTexture);
        }
        TextureRegistry.ImageTextureEntry imageTextureEntryCreateImageTexture = textureRegistry.createImageTexture();
        Log.i(TAG, "PlatformView is using ImageReader backend");
        return new ImageReaderPlatformViewRenderTarget(imageTextureEntryCreateImageTexture);
    }

    private void maybeInvokeOnFlutterViewAttached(PlatformView platformView) {
        FlutterView flutterView = this.flutterView;
        if (flutterView == null) {
            Log.i(TAG, "null flutterView");
        } else {
            platformView.onFlutterViewAttached(flutterView);
        }
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f4) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d4 = f4;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d4);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d4);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d4);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d4);
        pointerCoords.x = (float) (((Double) list.get(7)).doubleValue() * d4);
        pointerCoords.y = (float) (((Double) list.get(8)).doubleValue() * d4);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f4) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerCoords(it.next(), f4));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerProperties(it.next()));
        }
        return arrayList;
    }

    private void removeOverlaySurfaces() {
        if (this.flutterView == null) {
            Log.e(TAG, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i4 = 0; i4 < this.overlayLayerViews.size(); i4++) {
            this.flutterView.removeView(this.overlayLayerViews.valueAt(i4));
        }
        this.overlayLayerViews.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void throwIfHCPPEnabled() {
        if (this.flutterJNI.IsSurfaceControlEnabled()) {
            throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toLogicalPixels(double d4, float f4) {
        return (int) Math.round(d4 / ((double) f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toPhysicalPixels(double d4) {
        return (int) Math.round(d4 * ((double) getDisplayDensity()));
    }

    private static void translateMotionEvent(MotionEvent motionEvent, MotionEvent.PointerCoords[] pointerCoordsArr) {
        if (pointerCoordsArr.length < 1) {
            return;
        }
        motionEvent.offsetLocation(pointerCoordsArr[0].x - motionEvent.getX(), pointerCoordsArr[0].y - motionEvent.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateDirection(int i4) {
        return i4 == 0 || i4 == 1;
    }

    public void attach(Context context, TextureRegistry textureRegistry, DartExecutor dartExecutor) {
        if (this.context != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.context = context;
        this.textureRegistry = textureRegistry;
        PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
        this.platformViewsChannel = platformViewsChannel;
        platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.textInputPlugin = textInputPlugin;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(FlutterView flutterView) {
        this.flutterView = flutterView;
        for (int i4 = 0; i4 < this.viewWrappers.size(); i4++) {
            this.flutterView.addView(this.viewWrappers.valueAt(i4));
        }
        for (int i5 = 0; i5 < this.platformViewParent.size(); i5++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i5));
        }
        for (int i6 = 0; i6 < this.platformViews.size(); i6++) {
            this.platformViews.valueAt(i6).onFlutterViewAttached(this.flutterView);
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.contextToEmbeddedView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToEmbeddedView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public long configureForTextureLayerComposition(PlatformView platformView, final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        PlatformViewWrapper platformViewWrapper;
        long j4;
        enforceMinimumAndroidApiVersion(23);
        Log.i(TAG, "Hosting view in view hierarchy for platform view: " + platformViewCreationRequest.viewId);
        int physicalPixels = toPhysicalPixels(platformViewCreationRequest.logicalWidth);
        int physicalPixels2 = toPhysicalPixels(platformViewCreationRequest.logicalHeight);
        if (this.usesSoftwareRendering) {
            platformViewWrapper = new PlatformViewWrapper(this.context);
            j4 = -1;
        } else {
            PlatformViewRenderTarget platformViewRenderTargetMakePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
            PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(this.context, platformViewRenderTargetMakePlatformViewRenderTarget);
            long id = platformViewRenderTargetMakePlatformViewRenderTarget.getId();
            platformViewWrapper = platformViewWrapper2;
            j4 = id;
        }
        platformViewWrapper.setTouchProcessor(this.androidTouchProcessor);
        platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(physicalPixels, physicalPixels2);
        int physicalPixels3 = toPhysicalPixels(platformViewCreationRequest.logicalTop);
        int physicalPixels4 = toPhysicalPixels(platformViewCreationRequest.logicalLeft);
        layoutParams.topMargin = physicalPixels3;
        layoutParams.leftMargin = physicalPixels4;
        platformViewWrapper.setLayoutParams(layoutParams);
        View view = platformView.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(physicalPixels, physicalPixels2));
        view.setImportantForAccessibility(4);
        platformViewWrapper.addView(view);
        platformViewWrapper.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.h
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z4) {
                PlatformViewsController.b(this.f12308a, platformViewCreationRequest, view2, z4);
            }
        });
        this.flutterView.addView(platformViewWrapper);
        this.viewWrappers.append(platformViewCreationRequest.viewId, platformViewWrapper);
        maybeInvokeOnFlutterViewAttached(platformView);
        return j4;
    }

    public FlutterOverlaySurface createOverlaySurface(PlatformOverlayView platformOverlayView) {
        int i4 = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i4 + 1;
        this.overlayLayerViews.put(i4, platformOverlayView);
        return new FlutterOverlaySurface(i4, platformOverlayView.getSurface());
    }

    public PlatformView createPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, boolean z4) {
        PlatformViewFactory factory = this.registry.getFactory(platformViewCreationRequest.viewType);
        if (factory == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
        }
        PlatformView platformViewCreate = factory.create(z4 ? new MutableContextWrapper(this.context) : this.context, platformViewCreationRequest.viewId, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null);
        View view = platformViewCreate.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        view.setLayoutDirection(platformViewCreationRequest.direction);
        this.platformViews.put(platformViewCreationRequest.viewId, platformViewCreate);
        maybeInvokeOnFlutterViewAttached(platformViewCreate);
        return platformViewCreate;
    }

    public void destroyOverlaySurfaces() {
        for (int i4 = 0; i4 < this.overlayLayerViews.size(); i4++) {
            PlatformOverlayView platformOverlayViewValueAt = this.overlayLayerViews.valueAt(i4);
            platformOverlayViewValueAt.detachFromRenderer();
            platformOverlayViewValueAt.closeImageReader();
        }
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.platformViewsChannel;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler(null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    }

    public void detachFromView() {
        for (int i4 = 0; i4 < this.viewWrappers.size(); i4++) {
            this.flutterView.removeView(this.viewWrappers.valueAt(i4));
        }
        for (int i5 = 0; i5 < this.platformViewParent.size(); i5++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i5));
        }
        destroyOverlaySurfaces();
        removeOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (int i6 = 0; i6 < this.platformViews.size(); i6++) {
            this.platformViews.valueAt(i6).onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public void disposePlatformView(int i4) {
        this.channelHandler.dispose(i4);
    }

    public SparseArray<PlatformOverlayView> getOverlayLayerViews() {
        return this.overlayLayerViews;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(int i4) {
        if (usesVirtualDisplay(i4)) {
            return this.vdControllers.get(Integer.valueOf(i4)).getView();
        }
        PlatformView platformView = this.platformViews.get(i4);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    public boolean initializePlatformViewIfNeeded(final int i4) {
        PlatformView platformView = this.platformViews.get(i4);
        if (platformView == null) {
            return false;
        }
        if (this.platformViewParent.get(i4) != null) {
            return true;
        }
        View view = platformView.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.context;
        FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
        flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z4) {
                PlatformViewsController.d(this.f12306a, i4, view2, z4);
            }
        });
        this.platformViewParent.put(i4, flutterMutatorView);
        view.setImportantForAccessibility(4);
        flutterMutatorView.addView(view);
        this.flutterView.addView(flutterMutatorView);
        return true;
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onDisplayOverlaySurface(int i4, int i5, int i6, int i7, int i8) {
        if (this.overlayLayerViews.get(i4) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i4 + ") doesn't exist");
        }
        initializeRootImageViewIfNeeded();
        PlatformOverlayView platformOverlayView = this.overlayLayerViews.get(i4);
        if (platformOverlayView.getParent() == null) {
            this.flutterView.addView(platformOverlayView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        platformOverlayView.setLayoutParams(layoutParams);
        platformOverlayView.setVisibility(0);
        platformOverlayView.bringToFront();
        this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i4));
    }

    public void onDisplayPlatformView(int i4, int i5, int i6, int i7, int i8, int i9, int i10, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        if (initializePlatformViewIfNeeded(i4)) {
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i4);
            flutterMutatorView.readyToDisplay(flutterMutatorsStack, i5, i6, i7, i8);
            flutterMutatorView.setVisibility(0);
            flutterMutatorView.bringToFront();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10);
            View view = this.platformViews.get(i4).getView();
            if (view != null) {
                view.setLayoutParams(layoutParams);
                view.bringToFront();
            }
            this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i4));
        }
    }

    public void onEndFrame() {
        boolean z4 = false;
        if (this.flutterViewConvertedToImageView && this.currentFrameUsedPlatformViewIds.isEmpty()) {
            this.flutterViewConvertedToImageView = false;
            this.flutterView.revertImageView(new Runnable() { // from class: io.flutter.plugin.platform.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12312a.finishFrame(false);
                }
            });
        } else {
            if (this.flutterViewConvertedToImageView && this.flutterView.acquireLatestImageViewFrame()) {
                z4 = true;
            }
            finishFrame(z4);
        }
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public void onResume() {
        Iterator<VirtualDisplayController> it = this.vdControllers.values().iterator();
        while (it.hasNext()) {
            it.next().resetSurface();
        }
    }

    public void onTrimMemory(int i4) {
        if (i4 < 40) {
            return;
        }
        Iterator<VirtualDisplayController> it = this.vdControllers.values().iterator();
        while (it.hasNext()) {
            it.next().clearSurface();
        }
    }

    public void setFlutterJNI(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public void setSoftwareRendering(boolean z4) {
        this.usesSoftwareRendering = z4;
    }

    public MotionEvent toMotionEvent(float f4, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z4) {
        MotionEvent motionEventPop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f4).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
        if (z4 || motionEventPop == null) {
            return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]), pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
        }
        translateMotionEvent(motionEventPop, pointerCoordsArr);
        return motionEventPop;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i4) {
        return this.vdControllers.containsKey(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toLogicalPixels(double d4) {
        return toLogicalPixels(d4, getDisplayDensity());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new PlatformOverlayView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), this.accessibilityEventsDelegate));
    }
}
