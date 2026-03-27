package okhttp3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: loaded from: classes.dex */
public final class CertificatePinner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CertificatePinner f8744c = new CertificatePinner(new LinkedHashSet(new Builder().f8747a), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f8745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f8746b;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f8747a = new ArrayList();
    }

    public static final class Pin {
        public final boolean equals(Object obj) {
            if (!(obj instanceof Pin)) {
                return false;
            }
            ((Pin) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public CertificatePinner(LinkedHashSet linkedHashSet, CertificateChainCleaner certificateChainCleaner) {
        this.f8745a = linkedHashSet;
        this.f8746b = certificateChainCleaner;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Util.c(this.f8746b, certificatePinner.f8746b) && this.f8745a.equals(certificatePinner.f8745a);
    }

    public final int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f8746b;
        return this.f8745a.hashCode() + ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31);
    }
}
