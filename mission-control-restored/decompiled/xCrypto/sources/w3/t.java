package w3;

import W2.E;
import b3.AbstractC0866d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import y3.F;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends x3.b implements o, d, x3.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15668e = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_state");
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15669d;

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f15673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f15674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f15675f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15677h;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15675f = obj;
            this.f15677h |= Integer.MIN_VALUE;
            return t.this.collect(null, this);
        }
    }

    public t(Object obj) {
        this._state = obj;
    }

    @Override // w3.o
    public boolean a(Object obj, Object obj2) {
        if (obj == null) {
            obj = x3.m.f15775a;
        }
        if (obj2 == null) {
            obj2 = x3.m.f15775a;
        }
        return j(obj, obj2);
    }

    @Override // x3.k
    public d b(Z2.i iVar, int i4, v3.a aVar) {
        return u.d(this, iVar, i4, aVar);
    }

    /* JADX WARN: Path cross not found for [B:29:0x008f, B:45:0x00c3], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:33:0x009c, B:35:0x00a2], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:35:0x00a2, B:33:0x009c], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:35:0x00a2, B:43:0x00bd], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:45:0x00c3, B:29:0x008f], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0097, B:33:0x009c, B:43:0x00bd, B:45:0x00c3, B:35:0x00a2, B:39:0x00a9, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0097, B:33:0x009c, B:43:0x00bd, B:45:0x00c3, B:35:0x00a2, B:39:0x00a9, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0097, B:33:0x009c, B:43:0x00bd, B:45:0x00c3, B:35:0x00a2, B:39:0x00a9, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c1 -> B:29:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d3 -> B:29:0x008f). Please report as a decompilation issue!!! */
    @Override // w3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(w3.e r11, Z2.e r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.t.collect(w3.e, Z2.e):java.lang.Object");
    }

    @Override // w3.e
    public Object emit(Object obj, Z2.e eVar) {
        setValue(obj);
        return E.f5463a;
    }

    @Override // w3.o
    public Object getValue() {
        F f4 = x3.m.f15775a;
        Object obj = f15668e.get(this);
        if (obj == f4) {
            return null;
        }
        return obj;
    }

    @Override // x3.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public v d() {
        return new v();
    }

    @Override // x3.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public v[] e(int i4) {
        return new v[i4];
    }

    public final boolean j(Object obj, Object obj2) {
        int i4;
        x3.d[] dVarArrG;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15668e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.r.b(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.r.b(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i5 = this.f15669d;
            if ((i5 & 1) != 0) {
                this.f15669d = i5 + 2;
                return true;
            }
            int i6 = i5 + 1;
            this.f15669d = i6;
            x3.d[] dVarArrG2 = g();
            E e4 = E.f5463a;
            while (true) {
                v[] vVarArr = (v[]) dVarArrG2;
                if (vVarArr != null) {
                    for (v vVar : vVarArr) {
                        if (vVar != null) {
                            vVar.g();
                        }
                    }
                }
                synchronized (this) {
                    i4 = this.f15669d;
                    if (i4 == i6) {
                        this.f15669d = i6 + 1;
                        return true;
                    }
                    dVarArrG = g();
                    E e5 = E.f5463a;
                }
                dVarArrG2 = dVarArrG;
                i6 = i4;
            }
        }
    }

    @Override // w3.o
    public void setValue(Object obj) {
        if (obj == null) {
            obj = x3.m.f15775a;
        }
        j(null, obj);
    }
}
