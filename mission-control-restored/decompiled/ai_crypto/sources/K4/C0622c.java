package K4;

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

/* JADX INFO: renamed from: K4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0622c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Matrix f3588f = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterRenderer f3589a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3591c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3593e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f3592d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N f3590b = N.a();

    public C0622c(FlutterRenderer flutterRenderer, boolean z7) {
        this.f3589a = flutterRenderer;
        this.f3591c = z7;
    }

    public final void a(MotionEvent motionEvent, int i7, int i8, int i9, Matrix matrix, ByteBuffer byteBuffer) {
        b(motionEvent, i7, i8, i9, matrix, byteBuffer, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.MotionEvent r26, int r27, int r28, int r29, android.graphics.Matrix r30, java.nio.ByteBuffer r31, android.content.Context r32) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.C0622c.b(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    public final float c(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : i(context);
    }

    public final int d(int i7) {
        if (i7 == 0) {
            return 4;
        }
        if (i7 == 1) {
            return 6;
        }
        if (i7 == 5) {
            return 4;
        }
        if (i7 == 6) {
            return 6;
        }
        if (i7 == 2) {
            return 5;
        }
        if (i7 == 7) {
            return 3;
        }
        if (i7 == 3) {
            return 0;
        }
        return i7 == 8 ? 3 : -1;
    }

    public final int e(int i7) {
        if (i7 == 4) {
            return 7;
        }
        if (i7 == 5) {
            return 8;
        }
        return (i7 == 6 || i7 == 0) ? 9 : -1;
    }

    public final int f(int i7) {
        if (i7 == 1) {
            return 0;
        }
        if (i7 == 2) {
            return 2;
        }
        if (i7 != 3) {
            return i7 != 4 ? 5 : 3;
        }
        return 1;
    }

    public final float g(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? h(context) : i(context);
    }

    public final float h(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    public final int i(Context context) {
        if (this.f3593e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.f3593e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3593e;
    }

    public boolean j(MotionEvent motionEvent, Context context) {
        boolean zIsFromSource = motionEvent.isFromSource(2);
        boolean z7 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!zIsFromSource || !z7) {
            return false;
        }
        int iD = d(motionEvent.getActionMasked());
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        b(motionEvent, motionEvent.getActionIndex(), iD, 0, f3588f, byteBufferAllocateDirect, context);
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f3589a.l(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public boolean k(MotionEvent motionEvent) {
        return l(motionEvent, f3588f);
    }

    public boolean l(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int iD = d(motionEvent.getActionMasked());
        boolean z7 = actionMasked == 0 || actionMasked == 5;
        boolean z8 = !z7 && (actionMasked == 1 || actionMasked == 6);
        int i7 = (z8 && f(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((pointerCount + i7) * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z7) {
            a(motionEvent, motionEvent.getActionIndex(), iD, 0, matrix, byteBufferAllocateDirect);
        } else if (z8) {
            for (int i8 = 0; i8 < pointerCount; i8++) {
                if (i8 != motionEvent.getActionIndex() && motionEvent.getToolType(i8) == 1) {
                    a(motionEvent, i8, 5, 1, matrix, byteBufferAllocateDirect);
                }
            }
            a(motionEvent, motionEvent.getActionIndex(), iD, 0, matrix, byteBufferAllocateDirect);
            if (i7 != 0) {
                a(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, byteBufferAllocateDirect);
            }
        } else {
            for (int i9 = 0; i9 < pointerCount; i9++) {
                a(motionEvent, i9, iD, 0, matrix, byteBufferAllocateDirect);
            }
        }
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.f3589a.l(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public final int m(MotionEvent motionEvent, int i7) {
        return (motionEvent.getToolType(i7) & 7) | (motionEvent.getPointerId(i7) << 3);
    }
}
