package e1;

import W0.v;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: e1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1662b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f17139a;

    public C1662b(byte[] bArr) {
        this.f17139a = (byte[]) AbstractC2628k.d(bArr);
    }

    @Override // W0.v
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f17139a;
    }

    @Override // W0.v
    public int c() {
        return this.f17139a.length;
    }

    @Override // W0.v
    public Class d() {
        return byte[].class;
    }

    @Override // W0.v
    public void b() {
    }
}
