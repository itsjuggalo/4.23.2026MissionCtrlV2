package K2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: K2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0069u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f970b = Pattern.compile("[~*/\\[\\]]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0069u f971c = new C0069u(Q2.j.f2677b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.j f972a;

    public C0069u(List list) {
        this.f972a = list.isEmpty() ? Q2.j.f2678c : new Q2.j(list);
    }

    public static C0069u a(String str) {
        s3.D.k(str, "Provided field path must not be null.");
        s3.D.g("Use FieldPath.of() for field names containing '~*/[]'.", !f970b.matcher(str).find(), new Object[0]);
        try {
            return b(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(AbstractC1024h.c("Invalid field path (", str, "). Paths must not be empty, begin with '.', end with '.', or contain '..'"));
        }
    }

    public static C0069u b(String... strArr) {
        s3.D.g("Invalid field path. Provided path must not be empty.", strArr.length > 0, new Object[0]);
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            boolean z6 = (str == null || str.isEmpty()) ? false : true;
            StringBuilder sb = new StringBuilder("Invalid field name at argument ");
            i++;
            sb.append(i);
            sb.append(". Field names must not be null or empty.");
            s3.D.g(sb.toString(), z6, new Object[0]);
        }
        return new C0069u(Arrays.asList(strArr));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0069u.class != obj.getClass()) {
            return false;
        }
        return this.f972a.equals(((C0069u) obj).f972a);
    }

    public final int hashCode() {
        return this.f972a.hashCode();
    }

    public final String toString() {
        return this.f972a.c();
    }

    public C0069u(Q2.j jVar) {
        this.f972a = jVar;
    }
}
