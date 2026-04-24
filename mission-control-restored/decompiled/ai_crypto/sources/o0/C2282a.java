package o0;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: o0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2282a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[] f19913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final FloatBuffer f19914g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f19915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f19916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C2288g f19919e;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f19913f = fArr;
        f19914g = b(fArr);
    }

    public C2282a(C2288g c2288g, int i7, int i8) {
        float[] fArr = new float[8];
        this.f19915a = fArr;
        this.f19916b = b(fArr);
        this.f19919e = c2288g;
        this.f19917c = i7;
        this.f19918d = i8;
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public void a(int i7, float[] fArr, Rect rect) {
        f(rect);
        this.f19919e.e(C2288g.f20000h, f19914g, 0, 4, 2, 8, fArr, this.f19916b, i7, 8);
    }

    public int c() {
        return this.f19919e.d();
    }

    public void d(int i7, Bitmap bitmap) {
        this.f19919e.g(i7, bitmap);
    }

    public void e(boolean z7) {
        C2288g c2288g = this.f19919e;
        if (c2288g != null) {
            if (z7) {
                c2288g.h();
            }
            this.f19919e = null;
        }
    }

    public void f(Rect rect) {
        float[] fArr = this.f19915a;
        int i7 = rect.left;
        int i8 = this.f19917c;
        fArr[0] = i7 / i8;
        int i9 = rect.bottom;
        int i10 = this.f19918d;
        fArr[1] = 1.0f - (i9 / i10);
        int i11 = rect.right;
        fArr[2] = i11 / i8;
        fArr[3] = 1.0f - (i9 / i10);
        fArr[4] = i7 / i8;
        int i12 = rect.top;
        fArr[5] = 1.0f - (i12 / i10);
        fArr[6] = i11 / i8;
        fArr[7] = 1.0f - (i12 / i10);
        this.f19916b.put(fArr);
        this.f19916b.position(0);
    }
}
