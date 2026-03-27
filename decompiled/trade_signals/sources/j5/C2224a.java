package j5;

/* JADX INFO: renamed from: j5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2224a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f20101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f20102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20103d;

    /* JADX INFO: renamed from: j5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0329a extends V4.g {
        @Override // V4.g
        boolean test(Object obj);
    }

    public C2224a(int i8) {
        this.f20100a = i8;
        Object[] objArr = new Object[i8 + 1];
        this.f20101b = objArr;
        this.f20102c = objArr;
    }

    public void a(Object obj) {
        int i8 = this.f20100a;
        int i9 = this.f20103d;
        if (i9 == i8) {
            Object[] objArr = new Object[i8 + 1];
            this.f20102c[i8] = objArr;
            this.f20102c = objArr;
            i9 = 0;
        }
        this.f20102c[i9] = obj;
        this.f20103d = i9 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(j5.C2224a.InterfaceC0329a r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f20101b
            int r1 = r4.f20100a
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L15
            return
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.C2224a.b(j5.a$a):void");
    }
}
