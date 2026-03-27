package S3;

import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4698a;

    public b(String str) {
        this.f4698a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return AbstractC1206q.b(this.f4698a, ((b) obj).f4698a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f4698a);
    }

    public String toString() {
        return AbstractC1206q.d(this).a("token", this.f4698a).toString();
    }
}
