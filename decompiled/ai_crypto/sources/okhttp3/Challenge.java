package okhttp3;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Challenge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20308b;

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.f20307a.equals(this.f20307a) && challenge.f20308b.equals(this.f20308b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f20307a.hashCode()) * 31) + this.f20308b.hashCode();
    }

    public String toString() {
        return this.f20307a + " authParams=" + this.f20308b;
    }
}
