package q6;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22672b;

    public f(String str, boolean z7) {
        if (str == null) {
            a(0);
        }
        this.f22671a = str;
        this.f22672b = z7;
    }

    public static /* synthetic */ void a(int i8) {
        String str = (i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4) ? 2 : 3];
        if (i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i8 == 1) {
            objArr[1] = "asString";
        } else if (i8 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i8 == 3 || i8 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i8) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = "special";
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 1 && i8 != 2 && i8 != 3 && i8 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static f k(String str) {
        if (str == null) {
            a(9);
        }
        return str.startsWith("<") ? q(str) : l(str);
    }

    public static f l(String str) {
        if (str == null) {
            a(5);
        }
        return new f(str, false);
    }

    public static boolean n(String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static f q(String str) {
        if (str == null) {
            a(8);
        }
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public String b() {
        String str = this.f22671a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f22672b == fVar.f22672b && this.f22671a.equals(fVar.f22671a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return this.f22671a.compareTo(fVar.f22671a);
    }

    public int hashCode() {
        return (this.f22671a.hashCode() * 31) + (this.f22672b ? 1 : 0);
    }

    public String i() {
        if (this.f22672b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strB = b();
        if (strB == null) {
            a(2);
        }
        return strB;
    }

    public boolean m() {
        return this.f22672b;
    }

    public String toString() {
        return this.f22671a;
    }
}
