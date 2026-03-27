package L4;

import F4.InterfaceC0508w;
import F4.O;
import com.google.protobuf.AbstractC1470i;
import com.google.protobuf.J;
import com.google.protobuf.S;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream implements InterfaceC0508w, O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f5020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f5021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f5022c;

    public a(J j8, S s8) {
        this.f5020a = j8;
        this.f5021b = s8;
    }

    @Override // F4.InterfaceC0508w
    public int a(OutputStream outputStream) {
        J j8 = this.f5020a;
        if (j8 != null) {
            int iC = j8.c();
            this.f5020a.g(outputStream);
            this.f5020a = null;
            return iC;
        }
        ByteArrayInputStream byteArrayInputStream = this.f5022c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.f5022c = null;
        return iA;
    }

    @Override // java.io.InputStream
    public int available() {
        J j8 = this.f5020a;
        if (j8 != null) {
            return j8.c();
        }
        ByteArrayInputStream byteArrayInputStream = this.f5022c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    public J c() {
        J j8 = this.f5020a;
        if (j8 != null) {
            return j8;
        }
        throw new IllegalStateException("message not available");
    }

    public S e() {
        return this.f5021b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f5020a != null) {
            this.f5022c = new ByteArrayInputStream(this.f5020a.i());
            this.f5020a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f5022c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) {
        J j8 = this.f5020a;
        if (j8 != null) {
            int iC = j8.c();
            if (iC == 0) {
                this.f5020a = null;
                this.f5022c = null;
                return -1;
            }
            if (i9 >= iC) {
                AbstractC1470i abstractC1470iB0 = AbstractC1470i.b0(bArr, i8, iC);
                this.f5020a.h(abstractC1470iB0);
                abstractC1470iB0.W();
                abstractC1470iB0.c();
                this.f5020a = null;
                this.f5022c = null;
                return iC;
            }
            this.f5022c = new ByteArrayInputStream(this.f5020a.i());
            this.f5020a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f5022c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i8, i9);
        }
        return -1;
    }
}
