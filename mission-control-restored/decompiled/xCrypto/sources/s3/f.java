package s3;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends e {
    public static final d d(char c4, boolean z4) {
        if (!z4) {
            if (c4 == 'D') {
                return d.f14692h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c4);
        }
        if (c4 == 'H') {
            return d.f14691g;
        }
        if (c4 == 'M') {
            return d.f14690f;
        }
        if (c4 == 'S') {
            return d.f14689e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c4);
    }

    public static final d e(String shortName) {
        r.f(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return d.f14687c;
                                }
                            } else if (shortName.equals("ns")) {
                                return d.f14686b;
                            }
                        } else if (shortName.equals("ms")) {
                            return d.f14688d;
                        }
                    } else if (shortName.equals("s")) {
                        return d.f14689e;
                    }
                } else if (shortName.equals("m")) {
                    return d.f14690f;
                }
            } else if (shortName.equals("h")) {
                return d.f14691g;
            }
        } else if (shortName.equals("d")) {
            return d.f14692h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
}
