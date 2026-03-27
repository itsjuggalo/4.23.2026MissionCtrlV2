package y;

/* JADX INFO: loaded from: classes.dex */
public class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f25406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25407b;

    public g(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f25406a = new Object[i7];
    }

    @Override // y.f
    public boolean a(Object obj) {
        int i7 = this.f25407b;
        Object[] objArr = this.f25406a;
        if (i7 >= objArr.length) {
            return false;
        }
        objArr[i7] = obj;
        this.f25407b = i7 + 1;
        return true;
    }

    @Override // y.f
    public Object b() {
        int i7 = this.f25407b;
        if (i7 <= 0) {
            return null;
        }
        int i8 = i7 - 1;
        Object[] objArr = this.f25406a;
        Object obj = objArr[i8];
        objArr[i8] = null;
        this.f25407b = i7 - 1;
        return obj;
    }

    @Override // y.f
    public void c(Object[] objArr, int i7) {
        if (i7 > objArr.length) {
            i7 = objArr.length;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            Object obj = objArr[i8];
            int i9 = this.f25407b;
            Object[] objArr2 = this.f25406a;
            if (i9 < objArr2.length) {
                objArr2[i9] = obj;
                this.f25407b = i9 + 1;
            }
        }
    }
}
