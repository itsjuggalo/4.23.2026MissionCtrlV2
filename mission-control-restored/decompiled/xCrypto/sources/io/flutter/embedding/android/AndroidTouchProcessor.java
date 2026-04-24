package io.flutter.embedding.android;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidTouchProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private static final int TOOL_TYPE_BITS = 3;
    private static final int TOOL_TYPE_MASK = 7;
    private int cachedVerticalScrollFactor;
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z4) {
        this.renderer = flutterRenderer;
        this.trackMotionEvents = z4;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i4, int i5, int i6, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i4, i5, i6, matrix, byteBuffer, null);
    }

    private float getHorizontalScrollFactor(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : getVerticalScrollFactorPre26(context);
    }

    @PointerChange
    private int getPointerChangeForAction(int i4) {
        if (i4 == 0) {
            return 4;
        }
        if (i4 == 1) {
            return 6;
        }
        if (i4 == 5) {
            return 4;
        }
        if (i4 == 6) {
            return 6;
        }
        if (i4 == 2) {
            return 5;
        }
        if (i4 == 7) {
            return 3;
        }
        if (i4 == 3) {
            return 0;
        }
        return i4 == 8 ? 3 : -1;
    }

    @PointerChange
    private int getPointerChangeForPanZoom(int i4) {
        if (i4 == 4) {
            return 7;
        }
        if (i4 == 5) {
            return 8;
        }
        return (i4 == 6 || i4 == 0) ? 9 : -1;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i4) {
        if (i4 == 1) {
            return 0;
        }
        if (i4 == 2) {
            return 2;
        }
        if (i4 != 3) {
            return i4 != 4 ? 5 : 3;
        }
        return 1;
    }

    private float getVerticalScrollFactor(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? getVerticalScrollFactorAbove26(context) : getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactorAbove26(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    private int uniquePointerIdByType(MotionEvent motionEvent, int i4) {
        return (motionEvent.getToolType(i4) & 7) | (motionEvent.getPointerId(i4) << 3);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent, Context context) {
        boolean zIsFromSource = motionEvent.isFromSource(2);
        boolean z4 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!zIsFromSource || !z4) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, byteBufferAllocateDirect, context);
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.renderer.dispatchPointerDataPacket(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i4, int i5, int i6, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        int i7;
        int i8;
        long buttonState;
        int pointerChangeForPanZoom;
        int i9;
        double min;
        double max;
        double d4;
        double d5;
        double horizontalScrollFactor;
        double verticalScrollFactor;
        InputDevice.MotionRange motionRange;
        if (i5 == -1) {
            return;
        }
        int iUniquePointerIdByType = uniquePointerIdByType(motionEvent, i4);
        int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i4));
        float[] fArr = {motionEvent.getX(i4), motionEvent.getY(i4)};
        matrix.mapPoints(fArr);
        if (pointerDeviceTypeForToolType == 1) {
            i8 = 0;
            i7 = 1;
            buttonState = motionEvent.getButtonState() & 31;
            if (buttonState == 0 && motionEvent.getSource() == 8194 && i5 == 4) {
                this.ongoingPans.put(Integer.valueOf(iUniquePointerIdByType), fArr);
            }
        } else {
            i7 = 1;
            i8 = 0;
            buttonState = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean zContainsKey = this.ongoingPans.containsKey(Integer.valueOf(iUniquePointerIdByType));
        if (zContainsKey) {
            pointerChangeForPanZoom = getPointerChangeForPanZoom(i5);
            if (pointerChangeForPanZoom == -1) {
                return;
            }
        } else {
            pointerChangeForPanZoom = -1;
        }
        long id = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent).getId() : 0L;
        int i10 = motionEvent.getActionMasked() == 8 ? i7 : i8;
        int i11 = pointerChangeForPanZoom;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(id);
        byteBuffer.putLong(eventTime);
        if (zContainsKey) {
            i9 = i11;
            byteBuffer.putLong(i9);
            byteBuffer.putLong(4L);
        } else {
            i9 = i11;
            byteBuffer.putLong(i5);
            byteBuffer.putLong(pointerDeviceTypeForToolType);
        }
        byteBuffer.putLong(i10);
        byteBuffer.putLong(iUniquePointerIdByType);
        byteBuffer.putLong(0L);
        if (zContainsKey) {
            float[] fArr2 = this.ongoingPans.get(Integer.valueOf(iUniquePointerIdByType));
            byteBuffer.putDouble(fArr2[i8]);
            byteBuffer.putDouble(fArr2[i7]);
        } else {
            byteBuffer.putDouble(fArr[i8]);
            byteBuffer.putDouble(fArr[i7]);
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(buttonState);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i4));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            min = 0.0d;
            max = 1.0d;
        } else {
            min = motionRange.getMin();
            max = motionRange.getMax();
        }
        byteBuffer.putDouble(min);
        byteBuffer.putDouble(max);
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i4));
            d4 = 0.0d;
            byteBuffer.putDouble(0.0d);
        } else {
            d4 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(motionEvent.getSize(i4));
        byteBuffer.putDouble(motionEvent.getToolMajor(i4));
        byteBuffer.putDouble(motionEvent.getToolMinor(i4));
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i4));
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i4));
        } else {
            byteBuffer.putDouble(d4);
        }
        byteBuffer.putLong(i6);
        if (i10 == i7) {
            if (context != null) {
                horizontalScrollFactor = getHorizontalScrollFactor(context);
                verticalScrollFactor = getVerticalScrollFactor(context);
            } else {
                horizontalScrollFactor = 48.0d;
                verticalScrollFactor = 48.0d;
            }
            double d6 = horizontalScrollFactor * ((double) (-motionEvent.getAxisValue(10, i4)));
            double d7 = verticalScrollFactor * ((double) (-motionEvent.getAxisValue(9, i4)));
            byteBuffer.putDouble(d6);
            byteBuffer.putDouble(d7);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (zContainsKey) {
            float[] fArr3 = this.ongoingPans.get(Integer.valueOf(iUniquePointerIdByType));
            byteBuffer.putDouble(fArr[i8] - fArr3[i8]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d5 = 0.0d;
        } else {
            d5 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d5);
        byteBuffer.putLong(0L);
        if (zContainsKey && i9 == 9) {
            this.ongoingPans.remove(Integer.valueOf(iUniquePointerIdByType));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z4 = actionMasked == 0 || actionMasked == 5;
        boolean z5 = !z4 && (actionMasked == 1 || actionMasked == 6);
        int i4 = (z5 && getPointerDeviceTypeForToolType(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((pointerCount + i4) * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z4) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, byteBufferAllocateDirect);
        } else if (z5) {
            for (int i5 = 0; i5 < pointerCount; i5++) {
                if (i5 != motionEvent.getActionIndex() && motionEvent.getToolType(i5) == 1) {
                    addPointerForIndex(motionEvent, i5, 5, 1, matrix, byteBufferAllocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, byteBufferAllocateDirect);
            if (i4 != 0) {
                addPointerForIndex(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, byteBufferAllocateDirect);
            }
        } else {
            for (int i6 = 0; i6 < pointerCount; i6++) {
                addPointerForIndex(motionEvent, i6, pointerChangeForAction, 0, matrix, byteBufferAllocateDirect);
            }
        }
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.renderer.dispatchPointerDataPacket(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }
}
