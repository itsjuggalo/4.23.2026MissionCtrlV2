package R3;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Z3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f2814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f2816c = new AtomicBoolean(false);

    public g(FlutterJNI flutterJNI, int i) {
        this.f2814a = flutterJNI;
        this.f2815b = i;
    }

    @Override // Z3.e
    public final void a(ByteBuffer byteBuffer) {
        if (this.f2816c.getAndSet(true)) {
            throw new IllegalStateException("Reply already submitted");
        }
        int i = this.f2815b;
        FlutterJNI flutterJNI = this.f2814a;
        if (byteBuffer == null) {
            flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
        } else {
            flutterJNI.invokePlatformMessageResponseCallback(i, byteBuffer, byteBuffer.position());
        }
    }
}
