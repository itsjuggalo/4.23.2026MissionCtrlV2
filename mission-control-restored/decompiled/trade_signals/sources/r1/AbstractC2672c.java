package r1;

/* JADX INFO: renamed from: r1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2672c {

    /* JADX INFO: renamed from: r1.c$b */
    public static class b extends AbstractC2672c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f22911a;

        public b() {
            super();
        }

        @Override // r1.AbstractC2672c
        public void b(boolean z7) {
            this.f22911a = z7;
        }

        @Override // r1.AbstractC2672c
        public void c() {
            if (this.f22911a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public AbstractC2672c() {
    }

    public static AbstractC2672c a() {
        return new b();
    }

    public abstract void b(boolean z7);

    public abstract void c();
}
