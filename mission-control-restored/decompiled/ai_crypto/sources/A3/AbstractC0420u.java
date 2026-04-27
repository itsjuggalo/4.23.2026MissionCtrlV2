package A3;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: A3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0420u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f235a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f236b = new e();

    /* JADX INFO: renamed from: A3.u$a */
    public static class a extends AbstractC0420u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f237c;

        public a(List list) {
            this.f237c = list;
        }

        @Override // A3.AbstractC0420u
        public String d() {
            return "FieldValue.arrayRemove";
        }

        public List i() {
            return this.f237c;
        }
    }

    /* JADX INFO: renamed from: A3.u$b */
    public static class b extends AbstractC0420u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f238c;

        public b(List list) {
            this.f238c = list;
        }

        @Override // A3.AbstractC0420u
        public String d() {
            return "FieldValue.arrayUnion";
        }

        public List i() {
            return this.f238c;
        }
    }

    /* JADX INFO: renamed from: A3.u$c */
    public static class c extends AbstractC0420u {
        @Override // A3.AbstractC0420u
        public String d() {
            return "FieldValue.delete";
        }
    }

    /* JADX INFO: renamed from: A3.u$d */
    public static class d extends AbstractC0420u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f239c;

        public d(Number number) {
            this.f239c = number;
        }

        @Override // A3.AbstractC0420u
        public String d() {
            return "FieldValue.increment";
        }

        public Number i() {
            return this.f239c;
        }
    }

    /* JADX INFO: renamed from: A3.u$e */
    public static class e extends AbstractC0420u {
        @Override // A3.AbstractC0420u
        public String d() {
            return "FieldValue.serverTimestamp";
        }
    }

    public static AbstractC0420u a(Object... objArr) {
        return new a(Arrays.asList(objArr));
    }

    public static AbstractC0420u b(Object... objArr) {
        return new b(Arrays.asList(objArr));
    }

    public static AbstractC0420u c() {
        return f235a;
    }

    public static AbstractC0420u e(double d7) {
        return new d(Double.valueOf(d7));
    }

    public static AbstractC0420u f(long j7) {
        return new d(Long.valueOf(j7));
    }

    public static AbstractC0420u g() {
        return f236b;
    }

    public static z0 h(double[] dArr) {
        return new z0(dArr);
    }

    public abstract String d();
}
