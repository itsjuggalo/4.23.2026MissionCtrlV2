package s2;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: s2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1007j extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f9559c;

    public C1007j(l lVar, C1006i c1006i) {
        this.f9559c = lVar;
        this.f9557a = lVar.o(c1006i.f9555a + 4);
        this.f9558b = c1006i.f9556b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        if ((i | i6) < 0 || i6 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.f9558b;
        if (i7 <= 0) {
            return -1;
        }
        if (i6 > i7) {
            i6 = i7;
        }
        int i8 = this.f9557a;
        l lVar = this.f9559c;
        lVar.l(i8, bArr, i, i6);
        this.f9557a = lVar.o(this.f9557a + i6);
        this.f9558b -= i6;
        return i6;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f9558b == 0) {
            return -1;
        }
        l lVar = this.f9559c;
        lVar.f9561a.seek(this.f9557a);
        int i = lVar.f9561a.read();
        this.f9557a = lVar.o(this.f9557a + 1);
        this.f9558b--;
        return i;
    }
}
