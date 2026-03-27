package B4;

import com.google.protobuf.AbstractC0450a;
import com.google.protobuf.AbstractC0485s;
import com.google.protobuf.C0482q;
import com.google.protobuf.E;
import com.google.protobuf.InterfaceC0475m0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;
import u4.G;

/* JADX INFO: loaded from: classes.dex */
public final class a extends InputStream implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0450a f174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0475m0 f175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f176c;

    public a(AbstractC0450a abstractC0450a, InterfaceC0475m0 interfaceC0475m0) {
        this.f174a = abstractC0450a;
        this.f175b = interfaceC0475m0;
    }

    @Override // java.io.InputStream
    public final int available() {
        AbstractC0450a abstractC0450a = this.f174a;
        if (abstractC0450a != null) {
            return ((E) abstractC0450a).c(null);
        }
        ByteArrayInputStream byteArrayInputStream = this.f176c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f174a != null) {
            this.f176c = new ByteArrayInputStream(this.f174a.d());
            this.f174a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f176c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        AbstractC0450a abstractC0450a = this.f174a;
        if (abstractC0450a != null) {
            int iC = ((E) abstractC0450a).c(null);
            if (iC == 0) {
                this.f174a = null;
                this.f176c = null;
                return -1;
            }
            if (i6 >= iC) {
                Logger logger = AbstractC0485s.f5794d;
                C0482q c0482q = new C0482q(bArr, i, iC);
                this.f174a.e(c0482q);
                if (c0482q.a0() == 0) {
                    this.f174a = null;
                    this.f176c = null;
                    return iC;
                }
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            this.f176c = new ByteArrayInputStream(this.f174a.d());
            this.f174a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f176c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i6);
        }
        return -1;
    }
}
