package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    /* JADX INFO: renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$1, reason: invalid class name */
    public class AnonymousClass1 implements MethodChannel.MethodCallHandler {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a(MethodChannel.Result result, PlatformViewBufferSize platformViewBufferSize) {
            if (platformViewBufferSize == null) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Failed to resize the platform view", null);
                return;
            }
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(platformViewBufferSize.width));
            map.put("height", Double.valueOf(platformViewBufferSize.height));
            result.success(map);
        }

        private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void create(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            boolean z4 = false;
            boolean z5 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z5) {
                    PlatformViewsChannel.this.handler.createForPlatformViewLayer(new PlatformViewCreationRequest(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), PlatformViewCreationRequest.RequestedDisplayMode.HYBRID_ONLY, byteBufferWrap));
                    result.success(null);
                    return;
                }
                if (map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue()) {
                    z4 = true;
                }
                long jCreateForTextureLayer = PlatformViewsChannel.this.handler.createForTextureLayer(new PlatformViewCreationRequest(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z4 ? PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK : PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBufferWrap));
                if (jCreateForTextureLayer != -2) {
                    result.success(Long.valueOf(jCreateForTextureLayer));
                } else {
                    if (!z4) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                    result.success(null);
                }
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void dispose(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get(DiagnosticsEntry.ID_KEY)).intValue());
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void offset(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.offset(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void resize(MethodCall methodCall, final MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new PlatformViewBufferResized() { // from class: io.flutter.embedding.engine.systemchannels.f
                    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewBufferResized
                    public final void run(PlatformViewsChannel.PlatformViewBufferSize platformViewBufferSize) {
                        PlatformViewsChannel.AnonymousClass1.a(result, platformViewBufferSize);
                    }
                });
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Integer) map.get("direction")).intValue());
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void synchronizeToNativeViewHierarchy(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        private void touch(MethodCall methodCall, MethodChannel.Result result) {
            List list = (List) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                result.success(null);
            } catch (IllegalStateException e4) {
                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel.detailedExceptionString(e4), null);
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler == null) {
            }
            Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
            String str = methodCall.method;
            str.getClass();
            switch (str) {
                case "create":
                    create(methodCall, result);
                    break;
                case "offset":
                    offset(methodCall, result);
                    break;
                case "resize":
                    resize(methodCall, result);
                    break;
                case "clearFocus":
                    clearFocus(methodCall, result);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    synchronizeToNativeViewHierarchy(methodCall, result);
                    break;
                case "touch":
                    touch(methodCall, result);
                    break;
                case "setDirection":
                    setDirection(methodCall, result);
                    break;
                case "dispose":
                    dispose(methodCall, result);
                    break;
                default:
                    result.notImplemented();
                    break;
            }
        }
    }

    public interface PlatformViewBufferResized {
        void run(PlatformViewBufferSize platformViewBufferSize);
    }

    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i4, int i5) {
            this.width = i4;
            this.height = i5;
        }
    }

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final RequestedDisplayMode displayMode;
        public final double logicalHeight;
        public final double logicalLeft;
        public final double logicalTop;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public enum RequestedDisplayMode {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public PlatformViewCreationRequest(int i4, String str, double d4, double d5, double d6, double d7, int i5, ByteBuffer byteBuffer) {
            this(i4, str, d4, d5, d6, d7, i5, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
        }

        public PlatformViewCreationRequest(int i4, String str, double d4, double d5, double d6, double d7, int i5, RequestedDisplayMode requestedDisplayMode, ByteBuffer byteBuffer) {
            this.viewId = i4;
            this.viewType = str;
            this.logicalTop = d4;
            this.logicalLeft = d5;
            this.logicalWidth = d6;
            this.logicalHeight = d7;
            this.direction = i5;
            this.displayMode = requestedDisplayMode;
            this.params = byteBuffer;
        }
    }

    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i4, double d4, double d5) {
            this.viewId = i4;
            this.newLogicalWidth = d4;
            this.newLogicalHeight = d5;
        }
    }

    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        public final Number downTime;
        public final int edgeFlags;
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        public final Object rawPointerCoords;
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i4, Number number, Number number2, int i5, int i6, Object obj, Object obj2, int i7, int i8, float f4, float f5, int i9, int i10, int i11, int i12, long j4) {
            this.viewId = i4;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i5;
            this.pointerCount = i6;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i7;
            this.buttonState = i8;
            this.xPrecision = f4;
            this.yPrecision = f5;
            this.deviceId = i9;
            this.edgeFlags = i10;
            this.source = i11;
            this.flags = i12;
            this.motionEventId = j4;
        }
    }

    public interface PlatformViewsHandler {
        public static final long NON_TEXTURE_FALLBACK = -2;

        void clearFocus(int i4);

        void createForPlatformViewLayer(PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i4);

        void offset(int i4, double d4, double d5);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resize(PlatformViewResizeRequest platformViewResizeRequest, PlatformViewBufferResized platformViewBufferResized);

        void setDirection(int i4, int i5);

        void synchronizeToNativeViewHierarchy(boolean z4);
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.parsingHandler = anonymousClass1;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        return Log.getStackTraceString(exc);
    }

    public void invokeViewFocused(int i4) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i4));
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
