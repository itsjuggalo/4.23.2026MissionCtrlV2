package Z3;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class w implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f4022b = new w(v.f4019a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f4023a;

    public w(v vVar) {
        this.f4023a = vVar;
    }

    @Override // Z3.r
    public final ByteBuffer a(Object obj) throws IOException {
        P4.a aVar = new P4.a();
        aVar.write(0);
        this.f4023a.k(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // Z3.r
    public final ByteBuffer b(String str, String str2) throws IOException {
        P4.a aVar = new P4.a();
        aVar.write(1);
        v vVar = this.f4023a;
        vVar.k(aVar, "error");
        vVar.k(aVar, str);
        vVar.k(aVar, null);
        vVar.k(aVar, str2);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // Z3.r
    public final ByteBuffer c(Object obj, String str, String str2) throws IOException {
        P4.a aVar = new P4.a();
        aVar.write(1);
        v vVar = this.f4023a;
        vVar.k(aVar, str);
        vVar.k(aVar, str2);
        if (obj instanceof Throwable) {
            vVar.k(aVar, Log.getStackTraceString((Throwable) obj));
        } else {
            vVar.k(aVar, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // Z3.r
    public final ByteBuffer d(n nVar) {
        P4.a aVar = new P4.a();
        v vVar = this.f4023a;
        vVar.k(aVar, nVar.f4013a);
        vVar.k(aVar, nVar.f4014b);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // Z3.r
    public final n e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        v vVar = this.f4023a;
        Object objE = vVar.e(byteBuffer);
        Object objE2 = vVar.e(byteBuffer);
        if (!(objE instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new n(objE2, (String) objE);
    }

    @Override // Z3.r
    public final Object f(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b3 = byteBuffer.get();
        v vVar = this.f4023a;
        if (b3 != 0) {
            if (b3 == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objE = vVar.e(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objE;
        }
        Object objE2 = vVar.e(byteBuffer);
        Object objE3 = vVar.e(byteBuffer);
        Object objE4 = vVar.e(byteBuffer);
        if ((objE2 instanceof String) && ((objE3 == null || (objE3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new j(objE4, (String) objE2, (String) objE3);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}
