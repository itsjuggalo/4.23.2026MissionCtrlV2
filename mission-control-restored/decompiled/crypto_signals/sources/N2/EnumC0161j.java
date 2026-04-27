package N2;

/* JADX INFO: renamed from: N2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0161j {
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    EQUAL("=="),
    NOT_EQUAL("!="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    ARRAY_CONTAINS("array_contains"),
    ARRAY_CONTAINS_ANY("array_contains_any"),
    IN("in"),
    NOT_IN("not_in");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2017a;

    EnumC0161j(String str) {
        this.f2017a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2017a;
    }
}
