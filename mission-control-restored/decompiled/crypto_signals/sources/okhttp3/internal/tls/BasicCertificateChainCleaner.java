package okhttp3.internal.tls;

/* JADX INFO: loaded from: classes.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrustRootIndex f8952a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.f8952a = trustRootIndex;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && ((BasicCertificateChainCleaner) obj).f8952a.equals(this.f8952a);
    }

    public final int hashCode() {
        return this.f8952a.hashCode();
    }
}
