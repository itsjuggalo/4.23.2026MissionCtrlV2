package Z;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[] f5672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final FloatBuffer f5673g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f5674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f5675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f5678e;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f5672f = fArr;
        f5673g = b(fArr);
    }

    public a(g gVar, int i4, int i5) {
        float[] fArr = new float[8];
        this.f5674a = fArr;
        this.f5675b = b(fArr);
        this.f5678e = gVar;
        this.f5676c = i4;
        this.f5677d = i5;
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public void a(int i4, float[] fArr, Rect rect) {
        f(rect);
        this.f5678e.e(g.f5759h, f5673g, 0, 4, 2, 8, fArr, this.f5675b, i4, 8);
    }

    public int c() {
        return this.f5678e.d();
    }

    public void d(int i4, Bitmap bitmap) {
        this.f5678e.g(i4, bitmap);
    }

    public void e(boolean z4) {
        g gVar = this.f5678e;
        if (gVar != null) {
            if (z4) {
                gVar.h();
            }
            this.f5678e = null;
        }
    }

    public void f(Rect rect) {
        float[] fArr = this.f5674a;
        int i4 = rect.left;
        int i5 = this.f5676c;
        fArr[0] = i4 / i5;
        int i6 = rect.bottom;
        int i7 = this.f5677d;
        fArr[1] = 1.0f - (i6 / i7);
        int i8 = rect.right;
        fArr[2] = i8 / i5;
        fArr[3] = 1.0f - (i6 / i7);
        fArr[4] = i4 / i5;
        int i9 = rect.top;
        fArr[5] = 1.0f - (i9 / i7);
        fArr[6] = i8 / i5;
        fArr[7] = 1.0f - (i9 / i7);
        this.f5675b.put(fArr);
        this.f5675b.position(0);
    }
}
