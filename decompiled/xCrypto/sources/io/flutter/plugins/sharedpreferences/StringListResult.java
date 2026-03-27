package io.flutter.plugins.sharedpreferences;

import X2.AbstractC0769p;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class StringListResult {
    public static final Companion Companion = new Companion(null);
    private final String jsonEncodedValue;
    private final StringListLookupResultType type;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final StringListResult fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
            return new StringListResult(str, (StringListLookupResultType) obj);
        }

        private Companion() {
        }
    }

    public StringListResult(String str, StringListLookupResultType type) {
        kotlin.jvm.internal.r.f(type, "type");
        this.jsonEncodedValue = str;
        this.type = type;
    }

    public static /* synthetic */ StringListResult copy$default(StringListResult stringListResult, String str, StringListLookupResultType stringListLookupResultType, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = stringListResult.jsonEncodedValue;
        }
        if ((i4 & 2) != 0) {
            stringListLookupResultType = stringListResult.type;
        }
        return stringListResult.copy(str, stringListLookupResultType);
    }

    public final String component1() {
        return this.jsonEncodedValue;
    }

    public final StringListLookupResultType component2() {
        return this.type;
    }

    public final StringListResult copy(String str, StringListLookupResultType type) {
        kotlin.jvm.internal.r.f(type, "type");
        return new StringListResult(str, type);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StringListResult)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return MessagesAsyncPigeonUtils.INSTANCE.deepEquals(toList(), ((StringListResult) obj).toList());
    }

    public final String getJsonEncodedValue() {
        return this.jsonEncodedValue;
    }

    public final StringListLookupResultType getType() {
        return this.type;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return AbstractC0769p.j(this.jsonEncodedValue, this.type);
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.jsonEncodedValue + ", type=" + this.type + ")";
    }

    public /* synthetic */ StringListResult(String str, StringListLookupResultType stringListLookupResultType, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : str, stringListLookupResultType);
    }
}
