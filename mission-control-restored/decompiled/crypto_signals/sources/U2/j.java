package U2;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f3152d = new j(null, null, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3155c;

    public j(j jVar, String str, int i) {
        this.f3154b = jVar;
        this.f3155c = str;
        this.f3153a = i;
    }

    public final String toString() {
        int i = this.f3153a;
        if (i == 0) {
            return "";
        }
        String str = this.f3155c;
        if (i == 1) {
            return str;
        }
        return this.f3154b.toString() + "." + str;
    }
}
