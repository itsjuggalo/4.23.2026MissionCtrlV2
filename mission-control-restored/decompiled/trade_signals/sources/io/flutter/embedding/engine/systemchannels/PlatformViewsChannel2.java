package io.flutter.embedding.engine.systemchannels;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        public PlatformViewCreationRequest(int i8, String str, double d8, double d9, int i9, ByteBuffer byteBuffer) {
            this.viewId = i8;
            this.viewType = str;
            this.logicalWidth = d8;
            this.logicalHeight = d9;
            this.direction = i9;
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

        public PlatformViewTouch(int i8, Number number, Number number2, int i9, int i10, Object obj, Object obj2, int i11, int i12, float f8, float f9, int i13, int i14, int i15, int i16, long j8) {
            this.viewId = i8;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i9;
            this.pointerCount = i10;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i11;
            this.buttonState = i12;
            this.xPrecision = f8;
            this.yPrecision = f9;
            this.deviceId = i13;
            this.edgeFlags = i14;
            this.source = i15;
            this.flags = i16;
            this.motionEventId = j8;
        }
    }

    public interface PlatformViewsHandler {
        void clearFocus(int i8);

        void createPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i8);

        boolean isSurfaceControlEnabled();

        void onTouch(PlatformViewTouch platformViewTouch);

        void setDirection(int i8, int i9);
    }

    public PlatformViewsChannel2(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel2.1
            private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                    result.success(null);
                } catch (IllegalStateException e8) {
                    result.error("error", PlatformViewsChannel2.detailedExceptionString(e8), null);
                }
            }

            private void create(MethodCall methodCall, MethodChannel.Result result) {
                Map map = (Map) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.createPlatformView(new PlatformViewCreationRequest(((Integer) map.get(DiagnosticsEntry.ID_KEY)).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null));
                    result.success(null);
                } catch (IllegalStateException e8) {
                    result.error("error", PlatformViewsChannel2.detailedExceptionString(e8), null);
                }
            }

            private void dispose(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    PlatformViewsChannel2.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get(DiagnosticsEntry.ID_KEY)).intValue());
                    result.success(null);
                } catch (IllegalStateException e8) {
                    result.error("error", PlatformViewsChannel2.detailedExceptionString(e8), null);
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
                } catch (IllegalStateException e8) {
                    result.error("error", PlatformViewsChannel2.detailedExceptionString(e8), null);
                }
            }

            private void touch(MethodCall methodCall, MethodChannel.Result result) {
                MethodChannel.Result result2;
                List list = (List) methodCall.arguments();
                try {
                    PlatformViewsChannel2.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    result2 = result;
                } catch (IllegalStateException e8) {
                    e = e8;
                    result2 = result;
                }
                try {
                    result2.success(null);
                } catch (IllegalStateException e9) {
                    e = e9;
                    result2.error("error", PlatformViewsChannel2.detailedExceptionString(e), null);
                }
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (PlatformViewsChannel2.this.handler == null) {
                }
                Log.v(PlatformViewsChannel2.TAG, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                str.hashCode();
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

    public void invokeViewFocused(int i8) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i8));
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
