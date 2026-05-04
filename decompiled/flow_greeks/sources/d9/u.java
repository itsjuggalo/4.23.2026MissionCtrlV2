package d9;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7944a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f7945b = new e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f7946c;

        public a(List list) {
            this.f7946c = list;
        }

        @Override // d9.u
        public String d() {
            return "FieldValue.arrayRemove";
        }

        public List i() {
            return this.f7946c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f7947c;

        public b(List list) {
            this.f7947c = list;
        }

        @Override // d9.u
        public String d() {
            return "FieldValue.arrayUnion";
        }

        public List i() {
            return this.f7947c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends u {
        @Override // d9.u
        public String d() {
            return "FieldValue.delete";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f7948c;

        public d(Number number) {
            this.f7948c = number;
        }

        @Override // d9.u
        public String d() {
            return "FieldValue.increment";
        }

        public Number i() {
            return this.f7948c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends u {
        @Override // d9.u
        public String d() {
            return "FieldValue.serverTimestamp";
        }
    }

    public static u a(Object... objArr) {
        return new a(Arrays.asList(objArr));
    }

    public static u b(Object... objArr) {
        return new b(Arrays.asList(objArr));
    }

    public static u c() {
        return f7944a;
    }

    public static u e(double d10) {
        return new d(Double.valueOf(d10));
    }

    public static u f(long j10) {
        return new d(Long.valueOf(j10));
    }

    public static u g() {
        return f7945b;
    }

    public static y1 h(double[] dArr) {
        return new y1(dArr);
    }

    public abstract String d();
}
