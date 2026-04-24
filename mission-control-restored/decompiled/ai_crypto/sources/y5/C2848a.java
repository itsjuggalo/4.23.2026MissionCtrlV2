package y5;

import com.google.protobuf.AbstractC1243l;
import com.google.protobuf.V;
import com.google.protobuf.f0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import r5.InterfaceC2606w;
import r5.Q;

/* JADX INFO: renamed from: y5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2848a extends InputStream implements InterfaceC2606w, Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f25777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f25778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f25779c;

    public C2848a(V v7, f0 f0Var) {
        this.f25777a = v7;
        this.f25778b = f0Var;
    }

    public f0 A() {
        return this.f25778b;
    }

    @Override // java.io.InputStream
    public int available() {
        V v7 = this.f25777a;
        if (v7 != null) {
            return v7.b();
        }
        ByteArrayInputStream byteArrayInputStream = this.f25779c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // r5.InterfaceC2606w
    public int h(OutputStream outputStream) {
        V v7 = this.f25777a;
        if (v7 != null) {
            int iB = v7.b();
            this.f25777a.e(outputStream);
            this.f25777a = null;
            return iB;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25779c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) AbstractC2849b.a(byteArrayInputStream, outputStream);
        this.f25779c = null;
        return iA;
    }

    public V i() {
        V v7 = this.f25777a;
        if (v7 != null) {
            return v7;
        }
        throw new IllegalStateException("message not available");
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f25777a != null) {
            this.f25779c = new ByteArrayInputStream(this.f25777a.i());
            this.f25777a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25779c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) {
        V v7 = this.f25777a;
        if (v7 != null) {
            int iB = v7.b();
            if (iB == 0) {
                this.f25777a = null;
                this.f25779c = null;
                return -1;
            }
            if (i8 >= iB) {
                AbstractC1243l abstractC1243lC0 = AbstractC1243l.c0(bArr, i7, iB);
                this.f25777a.f(abstractC1243lC0);
                abstractC1243lC0.X();
                abstractC1243lC0.d();
                this.f25777a = null;
                this.f25779c = null;
                return iB;
            }
            this.f25779c = new ByteArrayInputStream(this.f25777a.i());
            this.f25777a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25779c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i7, i8);
        }
        return -1;
    }
}
