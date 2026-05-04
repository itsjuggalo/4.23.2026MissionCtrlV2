package qg;

import cd.h0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sg.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends rg.b implements o, d, rg.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19193e = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19194d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f19197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f19198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f19199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f19200f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19202h;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19200f = obj;
            this.f19202h |= Integer.MIN_VALUE;
            return t.this.collect(null, this);
        }
    }

    public t(Object obj) {
        this._state$volatile = obj;
    }

    @Override // rg.k
    public d a(gd.i iVar, int i10, pg.a aVar) {
        return u.d(this, iVar, i10, aVar);
    }

    @Override // qg.o
    public boolean b(Object obj, Object obj2) {
        if (obj == null) {
            obj = rg.m.f19904a;
        }
        if (obj2 == null) {
            obj2 = rg.m.f19904a;
        }
        return k(obj, obj2);
    }

    /* JADX WARN: Path cross not found for [B:29:0x008f, B:45:0x00c5], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:33:0x009e, B:35:0x00a4], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:35:0x00a4, B:33:0x009e], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:35:0x00a4, B:43:0x00bf], limit reached: 48 */
    /* JADX WARN: Path cross not found for [B:45:0x00c5, B:29:0x008f], limit reached: 48 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0099, B:33:0x009e, B:43:0x00bf, B:45:0x00c5, B:35:0x00a4, B:39:0x00ab, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0099, B:33:0x009e, B:43:0x00bf, B:45:0x00c5, B:35:0x00a4, B:39:0x00ab, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003e, B:29:0x008f, B:31:0x0099, B:33:0x009e, B:43:0x00bf, B:45:0x00c5, B:35:0x00a4, B:39:0x00ab, B:22:0x005f, B:25:0x0071, B:28:0x0080), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c3 -> B:29:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d5 -> B:29:0x008f). Please report as a decompilation issue!!! */
    @Override // qg.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(qg.e r11, gd.e r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.t.collect(qg.e, gd.e):java.lang.Object");
    }

    @Override // qg.e
    public Object emit(Object obj, gd.e eVar) {
        setValue(obj);
        return h0.f3852a;
    }

    @Override // qg.o
    public Object getValue() {
        d0 d0Var = rg.m.f19904a;
        Object obj = f19193e.get(this);
        if (obj == d0Var) {
            return null;
        }
        return obj;
    }

    @Override // rg.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public v d() {
        return new v();
    }

    @Override // rg.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public v[] e(int i10) {
        return new v[i10];
    }

    public final boolean k(Object obj, Object obj2) {
        int i10;
        rg.d[] dVarArrG;
        synchronized (this) {
            Object obj3 = f19193e.get(this);
            if (obj != null && !kotlin.jvm.internal.t.b(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.t.b(obj3, obj2)) {
                return true;
            }
            f19193e.set(this, obj2);
            int i11 = this.f19194d;
            if ((i11 & 1) != 0) {
                this.f19194d = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f19194d = i12;
            rg.d[] dVarArrG2 = g();
            h0 h0Var = h0.f3852a;
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
                    i10 = this.f19194d;
                    if (i10 == i12) {
                        this.f19194d = i12 + 1;
                        return true;
                    }
                    dVarArrG = g();
                    h0 h0Var2 = h0.f3852a;
                }
                dVarArrG2 = dVarArrG;
                i12 = i10;
            }
        }
    }

    @Override // qg.o
    public void setValue(Object obj) {
        if (obj == null) {
            obj = rg.m.f19904a;
        }
        k(null, obj);
    }
}
