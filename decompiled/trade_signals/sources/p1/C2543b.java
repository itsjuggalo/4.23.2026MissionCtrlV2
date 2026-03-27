package p1;

import U0.f;
import java.security.MessageDigest;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: p1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2543b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22254b;

    public C2543b(Object obj) {
        this.f22254b = AbstractC2628k.d(obj);
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f22254b.toString().getBytes(f.f8077a));
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (obj instanceof C2543b) {
            return this.f22254b.equals(((C2543b) obj).f22254b);
        }
        return false;
    }

    @Override // U0.f
    public int hashCode() {
        return this.f22254b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f22254b + '}';
    }
}
