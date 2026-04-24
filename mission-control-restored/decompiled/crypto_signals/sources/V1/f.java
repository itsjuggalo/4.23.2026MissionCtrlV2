package V1;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3203c;

    public f(Object obj, Object obj2, Object obj3) {
        this.f3201a = obj;
        this.f3202b = obj2;
        this.f3203c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f3201a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.f3202b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.f3203c);
        return new IllegalArgumentException(sb.toString());
    }
}
