package i3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11665a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f11666b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f11667c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f11668d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f11669e = new e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends j {
        @Override // i3.j
        public boolean a() {
            return true;
        }

        @Override // i3.j
        public boolean b() {
            return true;
        }

        @Override // i3.j
        public boolean c(g3.a aVar) {
            return aVar == g3.a.REMOTE;
        }

        @Override // i3.j
        public boolean d(boolean z10, g3.a aVar, g3.c cVar) {
            return (aVar == g3.a.RESOURCE_DISK_CACHE || aVar == g3.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends j {
        @Override // i3.j
        public boolean a() {
            return false;
        }

        @Override // i3.j
        public boolean b() {
            return false;
        }

        @Override // i3.j
        public boolean c(g3.a aVar) {
            return false;
        }

        @Override // i3.j
        public boolean d(boolean z10, g3.a aVar, g3.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends j {
        @Override // i3.j
        public boolean a() {
            return true;
        }

        @Override // i3.j
        public boolean b() {
            return false;
        }

        @Override // i3.j
        public boolean c(g3.a aVar) {
            return (aVar == g3.a.DATA_DISK_CACHE || aVar == g3.a.MEMORY_CACHE) ? false : true;
        }

        @Override // i3.j
        public boolean d(boolean z10, g3.a aVar, g3.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends j {
        @Override // i3.j
        public boolean a() {
            return false;
        }

        @Override // i3.j
        public boolean b() {
            return true;
        }

        @Override // i3.j
        public boolean c(g3.a aVar) {
            return false;
        }

        @Override // i3.j
        public boolean d(boolean z10, g3.a aVar, g3.c cVar) {
            return (aVar == g3.a.RESOURCE_DISK_CACHE || aVar == g3.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e extends j {
        @Override // i3.j
        public boolean a() {
            return true;
        }

        @Override // i3.j
        public boolean b() {
            return true;
        }

        @Override // i3.j
        public boolean c(g3.a aVar) {
            return aVar == g3.a.REMOTE;
        }

        @Override // i3.j
        public boolean d(boolean z10, g3.a aVar, g3.c cVar) {
            return ((z10 && aVar == g3.a.DATA_DISK_CACHE) || aVar == g3.a.LOCAL) && cVar == g3.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(g3.a aVar);

    public abstract boolean d(boolean z10, g3.a aVar, g3.c cVar);
}
