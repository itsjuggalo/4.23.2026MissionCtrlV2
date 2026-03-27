package R2;

import K2.InterfaceC0374w;
import K2.Q;
import com.google.protobuf.AbstractC1065l;
import com.google.protobuf.W;
import com.google.protobuf.g0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends InputStream implements InterfaceC0374w, Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public W f3561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f3562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f3563c;

    public a(W w4, g0 g0Var) {
        this.f3561a = w4;
        this.f3562b = g0Var;
    }

    @Override // java.io.InputStream
    public int available() {
        W w4 = this.f3561a;
        if (w4 != null) {
            return w4.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f3563c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // K2.InterfaceC0374w
    public int e(OutputStream outputStream) {
        W w4 = this.f3561a;
        if (w4 != null) {
            int serializedSize = w4.getSerializedSize();
            this.f3561a.writeTo(outputStream);
            this.f3561a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3563c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.f3563c = null;
        return iA;
    }

    public W f() {
        W w4 = this.f3561a;
        if (w4 != null) {
            return w4;
        }
        throw new IllegalStateException("message not available");
    }

    public g0 g() {
        return this.f3562b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f3561a != null) {
            this.f3563c = new ByteArrayInputStream(this.f3561a.toByteArray());
            this.f3561a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3563c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        W w4 = this.f3561a;
        if (w4 != null) {
            int serializedSize = w4.getSerializedSize();
            if (serializedSize == 0) {
                this.f3561a = null;
                this.f3563c = null;
                return -1;
            }
            if (i5 >= serializedSize) {
                AbstractC1065l abstractC1065lE0 = AbstractC1065l.e0(bArr, i4, serializedSize);
                this.f3561a.writeTo(abstractC1065lE0);
                abstractC1065lE0.Z();
                abstractC1065lE0.d();
                this.f3561a = null;
                this.f3563c = null;
                return serializedSize;
            }
            this.f3563c = new ByteArrayInputStream(this.f3561a.toByteArray());
            this.f3561a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3563c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i4, i5);
        }
        return -1;
    }
}
