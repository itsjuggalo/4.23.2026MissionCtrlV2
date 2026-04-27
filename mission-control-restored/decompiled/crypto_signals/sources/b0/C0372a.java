package b0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: b0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0372a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FloatBuffer f4809f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f4810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f4811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4813d;
    public C0378g e;

    static {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        f4809f = floatBufferAsFloatBuffer;
    }

    public C0372a(C0378g c0378g, int i, int i6) {
        float[] fArr = new float[8];
        this.f4810a = fArr;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        this.f4811b = floatBufferAsFloatBuffer;
        this.e = c0378g;
        this.f4812c = i;
        this.f4813d = i6;
    }
}
