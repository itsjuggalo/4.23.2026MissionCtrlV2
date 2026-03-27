package u5;

import java.io.Serializable;
import java.util.Arrays;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public class j implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f10527d = new j(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f10528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f10529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f10530c;

    public j(byte[] data) {
        kotlin.jvm.internal.j.e(data, "data");
        this.f10528a = data;
    }

    public static final j c(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i6 = i * 2;
            bArr[i] = (byte) (v5.b.a(str.charAt(i6 + 1)) + (v5.b.a(str.charAt(i6)) << 4));
        }
        return new j(bArr);
    }

    public static int g(j jVar, j other) {
        jVar.getClass();
        kotlin.jvm.internal.j.e(other, "other");
        return jVar.f(other.f10528a, 0);
    }

    public static int k(j jVar, j other) {
        jVar.getClass();
        kotlin.jvm.internal.j.e(other, "other");
        return jVar.j(other.f10528a);
    }

    public static final j l(byte... data) {
        kotlin.jvm.internal.j.e(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
        return new j(bArrCopyOf);
    }

    public static /* synthetic */ j p(j jVar, int i, int i6, int i7) {
        if ((i7 & 1) != 0) {
            i = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = -1234567890;
        }
        return jVar.o(i, i6);
    }

    public String a() {
        byte[] map = AbstractC1244a.f10511a;
        byte[] bArr = this.f10528a;
        kotlin.jvm.internal.j.e(bArr, "<this>");
        kotlin.jvm.internal.j.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i6 = 0;
        while (i < length) {
            byte b3 = bArr[i];
            int i7 = i + 2;
            byte b6 = bArr[i + 1];
            i += 3;
            byte b7 = bArr[i7];
            bArr2[i6] = map[(b3 & 255) >> 2];
            bArr2[i6 + 1] = map[((b3 & 3) << 4) | ((b6 & 255) >> 4)];
            int i8 = i6 + 3;
            bArr2[i6 + 2] = map[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i6 += 4;
            bArr2[i8] = map[b7 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b8 = bArr[i];
            bArr2[i6] = map[(b8 & 255) >> 2];
            bArr2[i6 + 1] = map[(b8 & 3) << 4];
            bArr2[i6 + 2] = 61;
            bArr2[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i9 = i + 1;
            byte b9 = bArr[i];
            byte b10 = bArr[i9];
            bArr2[i6] = map[(b9 & 255) >> 2];
            bArr2[i6 + 1] = map[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr2[i6 + 2] = map[(b10 & 15) << 2];
            bArr2[i6 + 3] = 61;
        }
        return new String(bArr2, Y4.a.f3689a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j other) {
        kotlin.jvm.internal.j.e(other, "other");
        int iD = d();
        int iD2 = other.d();
        int iMin = Math.min(iD, iD2);
        for (int i = 0; i < iMin; i++) {
            int i6 = i(i) & 255;
            int i7 = other.i(i) & 255;
            if (i6 != i7) {
                return i6 < i7 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public int d() {
        return this.f10528a.length;
    }

    public String e() {
        byte[] bArr = this.f10528a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b3 : bArr) {
            int i6 = i + 1;
            char[] cArr2 = v5.b.f10655a;
            cArr[i] = cArr2[(b3 >> 4) & 15];
            i += 2;
            cArr[i6] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            int iD = jVar.d();
            byte[] bArr = this.f10528a;
            if (iD == bArr.length && jVar.n(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int f(byte[] other, int i) {
        kotlin.jvm.internal.j.e(other, "other");
        byte[] bArr = this.f10528a;
        int length = bArr.length - other.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!AbstractC1245b.a(bArr, iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] h() {
        return this.f10528a;
    }

    public int hashCode() {
        int i = this.f10529b;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f10528a);
        this.f10529b = iHashCode;
        return iHashCode;
    }

    public byte i(int i) {
        return this.f10528a[i];
    }

    public int j(byte[] other) {
        kotlin.jvm.internal.j.e(other, "other");
        int iD = d();
        byte[] bArr = this.f10528a;
        for (int iMin = Math.min(iD, bArr.length - other.length); -1 < iMin; iMin--) {
            if (AbstractC1245b.a(bArr, iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean m(int i, j other, int i6) {
        kotlin.jvm.internal.j.e(other, "other");
        return other.n(0, this.f10528a, i, i6);
    }

    public boolean n(int i, byte[] other, int i6, int i7) {
        kotlin.jvm.internal.j.e(other, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr = this.f10528a;
        return i <= bArr.length - i7 && i6 >= 0 && i6 <= other.length - i7 && AbstractC1245b.a(bArr, i, other, i6, i7);
    }

    public j o(int i, int i6) {
        if (i6 == -1234567890) {
            i6 = d();
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f10528a;
        if (i6 > bArr.length) {
            throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
        }
        if (i6 - i < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i6 == bArr.length) {
            return this;
        }
        u0.i(i6, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i6);
        kotlin.jvm.internal.j.d(bArrCopyOfRange, "copyOfRange(...)");
        return new j(bArrCopyOfRange);
    }

    public j q() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f10528a;
            if (i >= bArr.length) {
                return this;
            }
            byte b3 = bArr[i];
            if (b3 >= 65 && b3 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b3 + 32);
                for (int i6 = i + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b6 = bArrCopyOf[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArrCopyOf[i6] = (byte) (b6 + 32);
                    }
                }
                return new j(bArrCopyOf);
            }
            i++;
        }
    }

    public byte[] r() {
        byte[] bArr = this.f10528a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final String s() {
        String str = this.f10530c;
        if (str != null) {
            return str;
        }
        byte[] bArrH = h();
        kotlin.jvm.internal.j.e(bArrH, "<this>");
        String str2 = new String(bArrH, Y4.a.f3689a);
        this.f10530c = str2;
        return str2;
    }

    public void t(C1250g buffer, int i) {
        kotlin.jvm.internal.j.e(buffer, "buffer");
        buffer.z(this.f10528a, 0, i);
    }

    public String toString() {
        j jVar;
        byte b3;
        int i;
        byte[] bArr = this.f10528a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        loop0: while (true) {
            if (i6 >= length) {
                break;
            }
            byte b6 = bArr[i6];
            if (b6 >= 0) {
                int i9 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if ((b6 != 10 && b6 != 13 && ((b6 >= 0 && b6 < 32) || (127 <= b6 && b6 < 160))) || b6 == 65533) {
                    break;
                }
                i7 += b6 < 65536 ? 1 : 2;
                i6++;
                while (true) {
                    i8 = i9;
                    if (i6 < length && (b3 = bArr[i6]) >= 0) {
                        i6++;
                        i9 = i8 + 1;
                        if (i8 == 64) {
                            break loop0;
                        }
                        if ((b3 != 10 && b3 != 13 && ((b3 >= 0 && b3 < 32) || (127 <= b3 && b3 < 160))) || b3 == 65533) {
                            break loop0;
                        }
                        i7 += b3 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b6 >> 5) == -2) {
                int i10 = i6 + 1;
                if (length > i10) {
                    byte b7 = bArr[i10];
                    if ((b7 & 192) == 128) {
                        int i11 = (b7 ^ 3968) ^ (b6 << 6);
                        if (i11 >= 128) {
                            i = i8 + 1;
                            if (i8 == 64) {
                                break;
                            }
                            if ((i11 != 10 && i11 != 13 && ((i11 >= 0 && i11 < 32) || (127 <= i11 && i11 < 160))) || i11 == 65533) {
                                break;
                            }
                            i7 += i11 < 65536 ? 1 : 2;
                            i6 += 2;
                            i8 = i;
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if ((b6 >> 4) == -2) {
                int i12 = i6 + 2;
                if (length > i12) {
                    byte b8 = bArr[i6 + 1];
                    if ((b8 & 192) == 128) {
                        byte b9 = bArr[i12];
                        if ((b9 & 192) == 128) {
                            int i13 = ((b9 ^ (-123008)) ^ (b8 << 6)) ^ (b6 << 12);
                            if (i13 < 2048) {
                                if (i8 != 64) {
                                    break;
                                }
                            } else if (55296 > i13 || i13 >= 57344) {
                                i = i8 + 1;
                                if (i8 == 64) {
                                    break;
                                }
                                if ((i13 != 10 && i13 != 13 && ((i13 >= 0 && i13 < 32) || (127 <= i13 && i13 < 160))) || i13 == 65533) {
                                    break;
                                }
                                i7 += i13 < 65536 ? 1 : 2;
                                i6 += 3;
                                i8 = i;
                            } else if (i8 != 64) {
                                break;
                            }
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if ((b6 >> 3) == -2) {
                int i14 = i6 + 3;
                if (length > i14) {
                    byte b10 = bArr[i6 + 1];
                    if ((b10 & 192) == 128) {
                        byte b11 = bArr[i6 + 2];
                        if ((b11 & 192) == 128) {
                            byte b12 = bArr[i14];
                            if ((b12 & 192) == 128) {
                                int i15 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b6 << 18);
                                if (i15 > 1114111) {
                                    if (i8 != 64) {
                                        break;
                                    }
                                } else if (55296 > i15 || i15 >= 57344) {
                                    if (i15 >= 65536) {
                                        i = i8 + 1;
                                        if (i8 == 64) {
                                            break;
                                        }
                                        if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                            break;
                                        }
                                        i7 += i15 < 65536 ? 1 : 2;
                                        i6 += 4;
                                        i8 = i;
                                    } else if (i8 != 64) {
                                        break;
                                    }
                                } else if (i8 != 64) {
                                    break;
                                }
                            } else if (i8 != 64) {
                                break;
                            }
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if (i8 != 64) {
                break;
            }
        }
        i7 = -1;
        if (i7 != -1) {
            String strS = s();
            String strSubstring = strS.substring(0, i7);
            kotlin.jvm.internal.j.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strS2 = Y4.l.S(Y4.l.S(Y4.l.S(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i7 >= strS.length()) {
                return "[text=" + strS2 + ']';
            }
            return "[size=" + bArr.length + " text=" + strS2 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + e() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
        }
        if (64 == bArr.length) {
            jVar = this;
        } else {
            u0.i(64, bArr.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 64);
            kotlin.jvm.internal.j.d(bArrCopyOfRange, "copyOfRange(...)");
            jVar = new j(bArrCopyOfRange);
        }
        sb.append(jVar.e());
        sb.append("…]");
        return sb.toString();
    }
}
