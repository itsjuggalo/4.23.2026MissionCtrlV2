package N1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Z0 implements Comparator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Z0 f1450b = new Z0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1451a;

    public /* synthetic */ Z0(int i) {
        this.f1451a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r0 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return 1;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            int r0 = r5.f1451a
            switch(r0) {
                case 0: goto L5e;
                case 1: goto L27;
                case 2: goto L1e;
                default: goto L5;
            }
        L5:
            v5.e r6 = (v5.e) r6
            u5.v r6 = r6.f10662a
            v5.e r7 = (v5.e) r7
            u5.v r7 = r7.f10662a
            if (r6 != r7) goto L11
            r6 = 0
            goto L1d
        L11:
            if (r6 != 0) goto L15
            r6 = -1
            goto L1d
        L15:
            if (r7 != 0) goto L19
            r6 = 1
            goto L1d
        L19:
            int r6 = r6.compareTo(r7)
        L1d:
            return r6
        L1e:
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            int r6 = r6.compareTo(r7)
            return r6
        L27:
            p0.g r6 = (p0.C0895g) r6
            p0.g r7 = (p0.C0895g) r7
            androidx.recyclerview.widget.RecyclerView r0 = r6.f9031d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L33
            r3 = r2
            goto L34
        L33:
            r3 = r1
        L34:
            androidx.recyclerview.widget.RecyclerView r4 = r7.f9031d
            if (r4 != 0) goto L3a
            r4 = r2
            goto L3b
        L3a:
            r4 = r1
        L3b:
            if (r3 == r4) goto L40
            if (r0 != 0) goto L48
            goto L4a
        L40:
            boolean r0 = r6.f9028a
            boolean r3 = r7.f9028a
            if (r0 == r3) goto L4c
            if (r0 == 0) goto L4a
        L48:
            r1 = -1
            goto L5d
        L4a:
            r1 = r2
            goto L5d
        L4c:
            int r0 = r7.f9029b
            int r2 = r6.f9029b
            int r0 = r0 - r2
            if (r0 == 0) goto L55
            r1 = r0
            goto L5d
        L55:
            int r6 = r6.f9030c
            int r7 = r7.f9030c
            int r6 = r6 - r7
            if (r6 == 0) goto L5d
            r1 = r6
        L5d:
            return r1
        L5e:
            java.lang.Long r7 = (java.lang.Long) r7
            java.lang.Long r6 = (java.lang.Long) r6
            long r0 = r6.longValue()
            long r6 = r7.longValue()
            int r6 = java.lang.Long.compare(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.Z0.compare(java.lang.Object, java.lang.Object):int");
    }
}
