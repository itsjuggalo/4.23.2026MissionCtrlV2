package q2;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: renamed from: q2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1722a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f14200a;

    public C1722a(Field field) {
        Objects.requireNonNull(field);
        this.f14200a = field;
    }

    public String toString() {
        return this.f14200a.toString();
    }
}
