package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11136c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0.b f11137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f11138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0.b f11139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f11140d;

        public a(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
            this.f11137a = bVar;
            this.f11138b = obj;
            this.f11139c = bVar2;
            this.f11140d = obj2;
        }
    }

    public C(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        this.f11134a = new a(bVar, obj, bVar2, obj2);
        this.f11135b = obj;
        this.f11136c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C1115q.b(aVar.f11137a, 1, obj) + C1115q.b(aVar.f11139c, 2, obj2);
    }

    public static C d(k0.b bVar, Object obj, k0.b bVar2, Object obj2) {
        return new C(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC1107i abstractC1107i, a aVar, Object obj, Object obj2) {
        C1115q.u(abstractC1107i, aVar.f11137a, 1, obj);
        C1115q.u(abstractC1107i, aVar.f11139c, 2, obj2);
    }

    public int a(int i8, Object obj, Object obj2) {
        return AbstractC1107i.O(i8) + AbstractC1107i.y(b(this.f11134a, obj, obj2));
    }

    public a c() {
        return this.f11134a;
    }
}
