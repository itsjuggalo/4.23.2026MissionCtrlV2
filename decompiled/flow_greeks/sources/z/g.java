package z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f25489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25490b;

    public g(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f25489a = new Object[i10];
    }

    @Override // z.f
    public boolean a(Object obj) {
        int i10 = this.f25490b;
        Object[] objArr = this.f25489a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f25490b = i10 + 1;
        return true;
    }

    @Override // z.f
    public Object b() {
        int i10 = this.f25490b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f25489a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f25490b = i10 - 1;
        return obj;
    }

    @Override // z.f
    public void c(Object[] objArr, int i10) {
        if (i10 > objArr.length) {
            i10 = objArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            int i12 = this.f25490b;
            Object[] objArr2 = this.f25489a;
            if (i12 < objArr2.length) {
                objArr2[i12] = obj;
                this.f25490b = i12 + 1;
            }
        }
    }
}
