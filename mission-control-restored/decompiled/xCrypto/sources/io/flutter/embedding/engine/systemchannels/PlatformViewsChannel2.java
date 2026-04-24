package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewsChannel2 {
    private static final String TAG = "PlatformViewsChannel2";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public PlatformViewCreationRequest(int i4, String str, double d4, double d5, int i5, ByteBuffer byteBuffer) {
            this.viewId = i4;
            this.viewType = str;
            this.logicalWidth = d4;
            this.logicalHeight = d5;
            this.direction = i5;
            this.params = byteBuffer;
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
        void clearFocus(int i4);

        void createPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i4);

        boolean isSurfaceControlEnabled();

        void onTouch(PlatformViewTouch platformViewTouch);

        void setDirection(int i4, int i5);
    }

    public PlatformViewsChannel2(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.1
            private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success(null);
                } catch (IllegalStateException e4) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e4), null);
                }
            }

            private void create(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.createPlatformView(new PlatformViewCreationRequest(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null));
                    result.success(null);
                } catch (IllegalStateException e4) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e4), null);
                }
            }

            private void dispose(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get(DiagnosticsEntry.ID_KEY)).intValue());
                    result.success(null);
                } catch (IllegalStateException e4) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e4), null);
                }
            }

            private void isSurfaceControlEnabled(MethodCall methodCall, MethodChannel.Result result) {
                result.success(Boolean.valueOf(PlatformViewsChannel2.this.handler.isSurfaceControlEnabled()));
            }

            private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.setDirection(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), ((Integer) map.get("direction")).intValue());
                    result.success(null);
                } catch (IllegalStateException e4) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e4), null);
                }
            }

            private void touch(MethodCall methodCall, MethodChannel.Result result) {
                List list = (List) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    result.success(null);
                } catch (IllegalStateException e4) {
                    result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, PlatformViewsChannel2.detailedExceptionString(e4), null);
                }
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (PlatformViewsChannel2.this.handler == null) {
                }
                Log.v(PlatformViewsChannel2.TAG, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                str.getClass();
                switch (str) {
                    case "create":
                        create(methodCall, result);
                        break;
                    case "clearFocus":
                        clearFocus(methodCall, result);
                        break;
                    case "touch":
                        touch(methodCall, result);
                        break;
                    case "setDirection":
                        setDirection(methodCall, result);
                        break;
                    case "isSurfaceControlEnabled":
                        isSurfaceControlEnabled(methodCall, result);
                        break;
                    case "dispose":
                        dispose(methodCall, result);
                        break;
                    default:
                        result.notImplemented();
                        break;
                }
            }
        };
        this.parsingHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views_2", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
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
