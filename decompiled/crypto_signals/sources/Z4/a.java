package Z4;

import F1.h;
import a3.d;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f4027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f4028d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4029a;

    static {
        int i = b.f4030a;
        f4026b = h.s(4611686018427387903L);
        f4027c = h.s(-4611686018427387903L);
    }

    public static final void a(StringBuilder sb, int i, int i6, int i7, String str, boolean z6) {
        CharSequence charSequenceSubSequence;
        sb.append(i);
        if (i6 != 0) {
            sb.append('.');
            String strValueOf = String.valueOf(i6);
            j.e(strValueOf, "<this>");
            if (i7 < 0) {
                throw new IllegalArgumentException(d.i("Desired length ", i7, " is less than zero."));
            }
            if (i7 <= strValueOf.length()) {
                charSequenceSubSequence = strValueOf.subSequence(0, strValueOf.length());
            } else {
                StringBuilder sb2 = new StringBuilder(i7);
                int length = i7 - strValueOf.length();
                int i8 = 1;
                if (1 <= length) {
                    while (true) {
                        sb2.append('0');
                        if (i8 == length) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                }
                sb2.append((CharSequence) strValueOf);
                charSequenceSubSequence = sb2;
            }
            String string = charSequenceSubSequence.toString();
            int i9 = -1;
            int length2 = string.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i10 = length2 - 1;
                    if (string.charAt(length2) != '0') {
                        i9 = length2;
                        break;
                    } else if (i10 < 0) {
                        break;
                    } else {
                        length2 = i10;
                    }
                }
            }
            int i11 = i9 + 1;
            if (z6 || i11 >= 3) {
                sb.append((CharSequence) string, 0, ((i9 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) string, 0, i11);
            }
        }
        sb.append(str);
    }

    public static int b(long j4, long j6) {
        long j7 = j4 ^ j6;
        if (j7 >= 0 && (((int) j7) & 1) != 0) {
            int i = (((int) j4) & 1) - (((int) j6) & 1);
            return j4 < 0 ? -i : i;
        }
        if (j4 < j6) {
            return -1;
        }
        return j4 == j6 ? 0 : 1;
    }

    public static final boolean c(long j4) {
        return j4 == f4026b || j4 == f4027c;
    }

    public static final long d(long j4, c unit) {
        j.e(unit, "unit");
        if (j4 == f4026b) {
            return Long.MAX_VALUE;
        }
        if (j4 == f4027c) {
            return Long.MIN_VALUE;
        }
        long j6 = j4 >> 1;
        c sourceUnit = (((int) j4) & 1) == 0 ? c.f4031b : c.f4032c;
        j.e(sourceUnit, "sourceUnit");
        return unit.f4037a.convert(j6, sourceUnit.f4037a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return b(this.f4029a, ((a) obj).f4029a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f4029a == ((a) obj).f4029a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4029a);
    }

    public final String toString() {
        long j4;
        int iD;
        int i;
        int i6;
        int i7;
        long j6 = this.f4029a;
        if (j6 == 0) {
            return "0s";
        }
        if (j6 == f4026b) {
            return "Infinity";
        }
        if (j6 == f4027c) {
            return "-Infinity";
        }
        boolean z6 = j6 < 0;
        StringBuilder sb = new StringBuilder();
        if (z6) {
            sb.append('-');
        }
        if (j6 < 0) {
            j6 = ((long) (((int) j6) & 1)) + ((-(j6 >> 1)) << 1);
            int i8 = b.f4030a;
        }
        long jD = d(j6, c.f4035k);
        if (c(j6)) {
            j4 = 0;
            iD = 0;
        } else {
            j4 = 0;
            iD = (int) (d(j6, c.f4034f) % ((long) 24));
        }
        int iD2 = c(j6) ? 0 : (int) (d(j6, c.e) % ((long) 60));
        int iD3 = c(j6) ? 0 : (int) (d(j6, c.f4033d) % ((long) 60));
        if (c(j6)) {
            i = 0;
        } else {
            i = (int) ((((int) j6) & 1) == 1 ? ((j6 >> 1) % ((long) 1000)) * ((long) 1000000) : (j6 >> 1) % ((long) 1000000000));
        }
        boolean z7 = jD != j4;
        boolean z8 = iD != 0;
        boolean z9 = iD2 != 0;
        boolean z10 = (iD3 == 0 && i == 0) ? false : true;
        if (z7) {
            sb.append(jD);
            sb.append('d');
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i9 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            sb.append(iD);
            sb.append('h');
            i6 = i9;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i10 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            sb.append(iD2);
            sb.append('m');
            i6 = i10;
        }
        if (z10) {
            i7 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            if (iD3 != 0 || z7 || z8 || z9) {
                a(sb, iD3, i, 9, "s", false);
            } else if (i >= 1000000) {
                a(sb, i / 1000000, i % 1000000, 6, "ms", false);
            } else if (i >= 1000) {
                a(sb, i / 1000, i % 1000, 3, "us", false);
            } else {
                sb.append(i);
                sb.append("ns");
            }
        } else {
            i7 = i6;
        }
        if (z6 && i7 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
