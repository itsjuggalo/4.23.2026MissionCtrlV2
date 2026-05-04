package lg;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends e {
    public static final d d(char c10, boolean z10) {
        if (!z10) {
            if (c10 == 'D') {
                return d.f15692h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c10);
        }
        if (c10 == 'H') {
            return d.f15691g;
        }
        if (c10 == 'M') {
            return d.f15690f;
        }
        if (c10 == 'S') {
            return d.f15689e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c10);
    }

    public static final d e(String shortName) {
        t.f(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return d.f15687c;
                                }
                            } else if (shortName.equals("ns")) {
                                return d.f15686b;
                            }
                        } else if (shortName.equals("ms")) {
                            return d.f15688d;
                        }
                    } else if (shortName.equals("s")) {
                        return d.f15689e;
                    }
                } else if (shortName.equals("m")) {
                    return d.f15690f;
                }
            } else if (shortName.equals("h")) {
                return d.f15691g;
            }
        } else if (shortName.equals("d")) {
            return d.f15692h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
}
