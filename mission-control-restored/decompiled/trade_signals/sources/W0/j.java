package W0;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9126a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f9127b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f9128c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f9129d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f9130e = new e();

    public class a extends j {
        @Override // W0.j
        public boolean a() {
            return true;
        }

        @Override // W0.j
        public boolean b() {
            return true;
        }

        @Override // W0.j
        public boolean c(U0.a aVar) {
            return aVar == U0.a.REMOTE;
        }

        @Override // W0.j
        public boolean d(boolean z7, U0.a aVar, U0.c cVar) {
            return (aVar == U0.a.RESOURCE_DISK_CACHE || aVar == U0.a.MEMORY_CACHE) ? false : true;
        }
    }

    public class b extends j {
        @Override // W0.j
        public boolean a() {
            return false;
        }

        @Override // W0.j
        public boolean b() {
            return false;
        }

        @Override // W0.j
        public boolean c(U0.a aVar) {
            return false;
        }

        @Override // W0.j
        public boolean d(boolean z7, U0.a aVar, U0.c cVar) {
            return false;
        }
    }

    public class c extends j {
        @Override // W0.j
        public boolean a() {
            return true;
        }

        @Override // W0.j
        public boolean b() {
            return false;
        }

        @Override // W0.j
        public boolean c(U0.a aVar) {
            return (aVar == U0.a.DATA_DISK_CACHE || aVar == U0.a.MEMORY_CACHE) ? false : true;
        }

        @Override // W0.j
        public boolean d(boolean z7, U0.a aVar, U0.c cVar) {
            return false;
        }
    }

    public class d extends j {
        @Override // W0.j
        public boolean a() {
            return false;
        }

        @Override // W0.j
        public boolean b() {
            return true;
        }

        @Override // W0.j
        public boolean c(U0.a aVar) {
            return false;
        }

        @Override // W0.j
        public boolean d(boolean z7, U0.a aVar, U0.c cVar) {
            return (aVar == U0.a.RESOURCE_DISK_CACHE || aVar == U0.a.MEMORY_CACHE) ? false : true;
        }
    }

    public class e extends j {
        @Override // W0.j
        public boolean a() {
            return true;
        }

        @Override // W0.j
        public boolean b() {
            return true;
        }

        @Override // W0.j
        public boolean c(U0.a aVar) {
            return aVar == U0.a.REMOTE;
        }

        @Override // W0.j
        public boolean d(boolean z7, U0.a aVar, U0.c cVar) {
            return ((z7 && aVar == U0.a.DATA_DISK_CACHE) || aVar == U0.a.LOCAL) && cVar == U0.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(U0.a aVar);

    public abstract boolean d(boolean z7, U0.a aVar, U0.c cVar);
}
