package A3;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: A3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0419t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f230b = Pattern.compile("[~*/\\[\\]]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0419t f231c = new C0419t(G3.q.f2455b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.q f232a;

    public C0419t(List list) {
        this.f232a = G3.q.u(list);
    }

    public static C0419t a() {
        return f231c;
    }

    public static C0419t b(String str) {
        K3.z.c(str, "Provided field path must not be null.");
        K3.z.a(!f230b.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        try {
            return d(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    public static C0419t d(String... strArr) {
        K3.z.a(strArr.length > 0, "Invalid field path. Provided path must not be empty.", new Object[0]);
        int i7 = 0;
        while (i7 < strArr.length) {
            String str = strArr[i7];
            boolean z7 = (str == null || str.isEmpty()) ? false : true;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid field name at argument ");
            i7++;
            sb.append(i7);
            sb.append(". Field names must not be null or empty.");
            K3.z.a(z7, sb.toString(), new Object[0]);
        }
        return new C0419t(Arrays.asList(strArr));
    }

    public G3.q c() {
        return this.f232a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0419t.class != obj.getClass()) {
            return false;
        }
        return this.f232a.equals(((C0419t) obj).f232a);
    }

    public int hashCode() {
        return this.f232a.hashCode();
    }

    public String toString() {
        return this.f232a.toString();
    }

    public C0419t(G3.q qVar) {
        this.f232a = qVar;
    }
}
