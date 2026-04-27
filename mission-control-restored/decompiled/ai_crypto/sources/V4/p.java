package V4;

import V4.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f5347b = new p(o.f5344a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5348a;

    public p(o oVar) {
        this.f5348a = oVar;
    }

    @Override // V4.k
    public ByteBuffer a(i iVar) {
        o.a aVar = new o.a();
        this.f5348a.p(aVar, iVar.f5332a);
        this.f5348a.p(aVar, iVar.f5333b);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.h(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // V4.k
    public i b(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objF = this.f5348a.f(byteBuffer);
        Object objF2 = this.f5348a.f(byteBuffer);
        if (!(objF instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new i((String) objF, objF2);
    }

    @Override // V4.k
    public ByteBuffer c(Object obj) throws IOException {
        o.a aVar = new o.a();
        aVar.write(0);
        this.f5348a.p(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.h(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // V4.k
    public ByteBuffer d(String str, String str2, Object obj, String str3) throws IOException {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f5348a.p(aVar, str);
        this.f5348a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f5348a.p(aVar, J4.b.d((Throwable) obj));
        } else {
            this.f5348a.p(aVar, obj);
        }
        this.f5348a.p(aVar, str3);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.h(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // V4.k
    public ByteBuffer e(String str, String str2, Object obj) throws IOException {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f5348a.p(aVar, str);
        this.f5348a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f5348a.p(aVar, J4.b.d((Throwable) obj));
        } else {
            this.f5348a.p(aVar, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.h(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // V4.k
    public Object f(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b7 = byteBuffer.get();
        if (b7 != 0) {
            if (b7 == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objF = this.f5348a.f(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objF;
        }
        Object objF2 = this.f5348a.f(byteBuffer);
        Object objF3 = this.f5348a.f(byteBuffer);
        Object objF4 = this.f5348a.f(byteBuffer);
        if ((objF2 instanceof String) && ((objF3 == null || (objF3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new d((String) objF2, (String) objF3, objF4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}
