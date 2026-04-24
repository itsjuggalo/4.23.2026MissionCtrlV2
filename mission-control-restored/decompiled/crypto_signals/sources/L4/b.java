package L4;

import H4.d;
import java.io.Serializable;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d implements a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f1049a;

    public b(Enum[] entries) {
        j.e(entries, "entries");
        this.f1049a = entries;
    }

    @Override // H4.d
    public final int a() {
        return this.f1049a.length;
    }

    @Override // H4.d, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        j.e(element, "element");
        int iOrdinal = element.ordinal();
        Enum[] enumArr = this.f1049a;
        j.e(enumArr, "<this>");
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == element;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.f1049a;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, length, ", size: "));
        }
        return enumArr[i];
    }

    @Override // H4.d, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        j.e(element, "element");
        int iOrdinal = element.ordinal();
        Enum[] enumArr = this.f1049a;
        j.e(enumArr, "<this>");
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // H4.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        j.e(element, "element");
        return indexOf(element);
    }
}
