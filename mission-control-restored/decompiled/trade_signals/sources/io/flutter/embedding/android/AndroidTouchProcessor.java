package io.flutter.embedding.android;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AndroidTouchProcessor {
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
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

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z7) {
        this.renderer = flutterRenderer;
        this.trackMotionEvents = z7;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i8, int i9, int i10, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i8, i9, i10, matrix, byteBuffer, null);
    }

    private float getHorizontalScrollFactor(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : getVerticalScrollFactorPre26(context);
    }

    @PointerChange
    private int getPointerChangeForAction(int i8) {
        if (i8 == 0) {
            return 4;
        }
        if (i8 == 1) {
            return 6;
        }
        if (i8 == 5) {
            return 4;
        }
        if (i8 == 6) {
            return 6;
        }
        if (i8 == 2) {
            return 5;
        }
        if (i8 == 7) {
            return 3;
        }
        if (i8 == 3) {
            return 0;
        }
        return i8 == 8 ? 3 : -1;
    }

    @PointerChange
    private int getPointerChangeForPanZoom(int i8) {
        if (i8 == 4) {
            return 7;
        }
        if (i8 == 5) {
            return 8;
        }
        return (i8 == 6 || i8 == 0) ? 9 : -1;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i8) {
        if (i8 == 1) {
            return 0;
        }
        if (i8 == 2) {
            return 2;
        }
        if (i8 != 3) {
            return i8 != 4 ? 5 : 3;
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

    public boolean onGenericMotionEvent(MotionEvent motionEvent, Context context) {
        boolean zIsFromSource = motionEvent.isFromSource(2);
        boolean z7 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!zIsFromSource || !z7) {
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

    /* JADX WARN: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addPointerForIndex(android.view.MotionEvent r26, int r27, int r28, int r29, android.graphics.Matrix r30, java.nio.ByteBuffer r31, android.content.Context r32) {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.AndroidTouchProcessor.addPointerForIndex(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r16, android.graphics.Matrix r17) {
        /*
            r15 = this;
            r7 = r15
            r8 = r16
            int r0 = r16.getActionMasked()
            int r1 = r16.getActionMasked()
            int r9 = r15.getPointerChangeForAction(r1)
            r1 = 0
            r10 = 1
            if (r0 == 0) goto L19
            r2 = 5
            if (r0 != r2) goto L17
            goto L19
        L17:
            r2 = r1
            goto L1a
        L19:
            r2 = r10
        L1a:
            if (r2 != 0) goto L23
            if (r0 == r10) goto L21
            r3 = 6
            if (r0 != r3) goto L23
        L21:
            r0 = r10
            goto L24
        L23:
            r0 = r1
        L24:
            int r3 = r16.getActionIndex()
            int r3 = r8.getToolType(r3)
            int r3 = r15.getPointerDeviceTypeForToolType(r3)
            if (r0 == 0) goto L36
            if (r3 != 0) goto L36
            r11 = r10
            goto L37
        L36:
            r11 = r1
        L37:
            int r12 = r16.getPointerCount()
            int r3 = r12 + r11
            int r3 = r3 * 288
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocateDirect(r3)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            r13.order(r3)
            if (r2 == 0) goto L5a
            int r2 = r16.getActionIndex()
            r4 = 0
            r0 = r15
            r1 = r16
            r3 = r9
        L53:
            r5 = r17
            r6 = r13
            r0.addPointerForIndex(r1, r2, r3, r4, r5, r6)
            goto La7
        L5a:
            if (r0 == 0) goto L95
            r14 = r1
        L5d:
            if (r14 >= r12) goto L7a
            int r0 = r16.getActionIndex()
            if (r14 == r0) goto L77
            int r0 = r8.getToolType(r14)
            if (r0 != r10) goto L77
            r3 = 5
            r4 = 1
            r0 = r15
            r1 = r16
            r2 = r14
            r5 = r17
            r6 = r13
            r0.addPointerForIndex(r1, r2, r3, r4, r5, r6)
        L77:
            int r14 = r14 + 1
            goto L5d
        L7a:
            int r2 = r16.getActionIndex()
            r4 = 0
            r0 = r15
            r1 = r16
            r3 = r9
            r5 = r17
            r6 = r13
            r0.addPointerForIndex(r1, r2, r3, r4, r5, r6)
            if (r11 == 0) goto La7
            int r2 = r16.getActionIndex()
            r3 = 2
            r4 = 0
            r0 = r15
            r1 = r16
            goto L53
        L95:
            r11 = r1
        L96:
            if (r11 >= r12) goto La7
            r4 = 0
            r0 = r15
            r1 = r16
            r2 = r11
            r3 = r9
            r5 = r17
            r6 = r13
            r0.addPointerForIndex(r1, r2, r3, r4, r5, r6)
            int r11 = r11 + 1
            goto L96
        La7:
            int r0 = r13.position()
            int r0 = r0 % 288
            if (r0 != 0) goto Lb9
            io.flutter.embedding.engine.renderer.FlutterRenderer r0 = r7.renderer
            int r1 = r13.position()
            r0.dispatchPointerDataPacket(r13, r1)
            return r10
        Lb9:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Packet position is not on field boundary"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.AndroidTouchProcessor.onTouchEvent(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
