package v3;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10620a;

    public i(String str) {
        this.f10620a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f10620a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            return this.f10620a.equals(((i) obj).f10620a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f10620a);
    }

    public final int hashCode() {
        return this.f10620a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f10620a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return d.j(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f10620a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return d.j(str).longValue();
        }
    }

    public final String toString() {
        return this.f10620a;
    }
}
