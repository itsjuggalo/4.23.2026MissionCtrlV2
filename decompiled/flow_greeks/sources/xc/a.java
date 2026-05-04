package xc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f24793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f24794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24795d;

    /* JADX INFO: renamed from: xc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0452a extends ic.g {
        @Override // ic.g
        boolean test(Object obj);
    }

    public a(int i10) {
        this.f24792a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f24793b = objArr;
        this.f24794c = objArr;
    }

    public void a(Object obj) {
        int i10 = this.f24792a;
        int i11 = this.f24795d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f24794c[i10] = objArr;
            this.f24794c = objArr;
            i11 = 0;
        }
        this.f24794c[i11] = obj;
        this.f24795d = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(xc.a.InterfaceC0452a r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f24793b
            int r1 = r4.f24792a
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
            goto L1d
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
        throw new UnsupportedOperationException("Method not decompiled: xc.a.b(xc.a$a):void");
    }
}
