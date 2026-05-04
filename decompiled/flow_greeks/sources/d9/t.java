package d9;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f7937b = Pattern.compile("[~*/\\[\\]]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f7938c = new t(j9.q.f14256b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.q f7939a;

    public t(List list) {
        this.f7939a = j9.q.A(list);
    }

    public static t a() {
        return f7938c;
    }

    public static t b(String str) {
        n9.x.c(str, "Provided field path must not be null.");
        n9.x.a(!f7937b.matcher(str).find(), "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        try {
            return d(str.split("\\.", -1));
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
        }
    }

    public static t d(String... strArr) {
        n9.x.a(strArr.length > 0, "Invalid field path. Provided path must not be empty.", new Object[0]);
        int i10 = 0;
        while (i10 < strArr.length) {
            String str = strArr[i10];
            boolean z10 = (str == null || str.isEmpty()) ? false : true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid field name at argument ");
            i10++;
            sb2.append(i10);
            sb2.append(". Field names must not be null or empty.");
            n9.x.a(z10, sb2.toString(), new Object[0]);
        }
        return new t(Arrays.asList(strArr));
    }

    public j9.q c() {
        return this.f7939a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        return this.f7939a.equals(((t) obj).f7939a);
    }

    public int hashCode() {
        return this.f7939a.hashCode();
    }

    public String toString() {
        return this.f7939a.toString();
    }

    public t(j9.q qVar) {
        this.f7939a = qVar;
    }
}
