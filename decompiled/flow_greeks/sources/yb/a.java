package yb;

import com.google.protobuf.e1;
import com.google.protobuf.l;
import com.google.protobuf.u0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import rb.q0;
import rb.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends InputStream implements w, q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u0 f25332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f25333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f25334c;

    public a(u0 u0Var, e1 e1Var) {
        this.f25332a = u0Var;
        this.f25333b = e1Var;
    }

    @Override // java.io.InputStream
    public int available() {
        u0 u0Var = this.f25332a;
        if (u0Var != null) {
            return u0Var.b();
        }
        ByteArrayInputStream byteArrayInputStream = this.f25334c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // rb.w
    public int b(OutputStream outputStream) {
        u0 u0Var = this.f25332a;
        if (u0Var != null) {
            int iB = u0Var.b();
            this.f25332a.f(outputStream);
            this.f25332a = null;
            return iB;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25334c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.f25334c = null;
        return iA;
    }

    public u0 c() {
        u0 u0Var = this.f25332a;
        if (u0Var != null) {
            return u0Var;
        }
        throw new IllegalStateException("message not available");
    }

    public e1 e() {
        return this.f25333b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f25332a != null) {
            this.f25334c = new ByteArrayInputStream(this.f25332a.i());
            this.f25332a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25334c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        u0 u0Var = this.f25332a;
        if (u0Var != null) {
            int iB = u0Var.b();
            if (iB == 0) {
                this.f25332a = null;
                this.f25334c = null;
                return -1;
            }
            if (i11 >= iB) {
                l lVarC0 = l.c0(bArr, i10, iB);
                this.f25332a.g(lVarC0);
                lVarC0.X();
                lVarC0.d();
                this.f25332a = null;
                this.f25334c = null;
                return iB;
            }
            this.f25334c = new ByteArrayInputStream(this.f25332a.i());
            this.f25332a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f25334c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
