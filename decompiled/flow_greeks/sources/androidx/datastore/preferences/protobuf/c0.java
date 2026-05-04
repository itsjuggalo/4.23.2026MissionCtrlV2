package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1669c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j1.b f1670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j1.b f1672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f1673d;

        public a(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
            this.f1670a = bVar;
            this.f1671b = obj;
            this.f1672c = bVar2;
            this.f1673d = obj2;
        }
    }

    public c0(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
        this.f1667a = new a(bVar, obj, bVar2, obj2);
        this.f1668b = obj;
        this.f1669c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return q.b(aVar.f1670a, 1, obj) + q.b(aVar.f1672c, 2, obj2);
    }

    public static c0 d(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
        return new c0(bVar, obj, bVar2, obj2);
    }

    public static void e(i iVar, a aVar, Object obj, Object obj2) {
        q.u(iVar, aVar.f1670a, 1, obj);
        q.u(iVar, aVar.f1672c, 2, obj2);
    }

    public int a(int i10, Object obj, Object obj2) {
        return i.O(i10) + i.y(b(this.f1667a, obj, obj2));
    }

    public a c() {
        return this.f1667a;
    }
}
