package z;

/* JADX INFO: loaded from: classes.dex */
public class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f24569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24570b;

    public g(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f24569a = new Object[i8];
    }

    @Override // z.f
    public boolean a(Object obj) {
        int i8 = this.f24570b;
        Object[] objArr = this.f24569a;
        if (i8 >= objArr.length) {
            return false;
        }
        objArr[i8] = obj;
        this.f24570b = i8 + 1;
        return true;
    }

    @Override // z.f
    public Object b() {
        int i8 = this.f24570b;
        if (i8 <= 0) {
            return null;
        }
        int i9 = i8 - 1;
        Object[] objArr = this.f24569a;
        Object obj = objArr[i9];
        objArr[i9] = null;
        this.f24570b = i8 - 1;
        return obj;
    }

    @Override // z.f
    public void c(Object[] objArr, int i8) {
        if (i8 > objArr.length) {
            i8 = objArr.length;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = objArr[i9];
            int i10 = this.f24570b;
            Object[] objArr2 = this.f24569a;
            if (i10 < objArr2.length) {
                objArr2[i10] = obj;
                this.f24570b = i10 + 1;
            }
        }
    }
}
