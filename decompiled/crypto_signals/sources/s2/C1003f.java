package s2;

import java.io.IOException;
import p0.C0899k;

/* JADX INFO: renamed from: s2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1003f implements InterfaceC1008k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0899k f9549c = new C0899k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9551b;

    public C1003f(w2.c cVar) {
        this.f9550a = cVar;
        this.f9551b = f9549c;
    }

    @Override // s2.InterfaceC1008k
    public void a(C1007j c1007j, int i) throws IOException {
        int[] iArr = (int[]) this.f9551b;
        try {
            c1007j.read((byte[]) this.f9550a, iArr[0], i);
            iArr[0] = iArr[0] + i;
        } finally {
            c1007j.close();
        }
    }

    public C1003f(byte[] bArr, int[] iArr) {
        this.f9550a = bArr;
        this.f9551b = iArr;
    }
}
