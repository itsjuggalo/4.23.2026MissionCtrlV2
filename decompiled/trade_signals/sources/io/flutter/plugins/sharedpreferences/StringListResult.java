package io.flutter.plugins.sharedpreferences;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class StringListResult {
    public static final Companion Companion = new Companion(null);
    private final String jsonEncodedValue;
    private final StringListLookupResultType type;

    public static final class Companion {
        private Companion() {
        }

        public final StringListResult fromList(List<? extends Object> pigeonVar_list) {
            AbstractC2304t.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            AbstractC2304t.d(obj, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
            return new StringListResult(str, (StringListLookupResultType) obj);
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public StringListResult(String str, StringListLookupResultType type) {
        AbstractC2304t.f(type, "type");
        this.jsonEncodedValue = str;
        this.type = type;
    }

    public static /* synthetic */ StringListResult copy$default(StringListResult stringListResult, String str, StringListLookupResultType stringListLookupResultType, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = stringListResult.jsonEncodedValue;
        }
        if ((i8 & 2) != 0) {
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
        AbstractC2304t.f(type, "type");
        return new StringListResult(str, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringListResult)) {
            return false;
        }
        StringListResult stringListResult = (StringListResult) obj;
        return AbstractC2304t.b(this.jsonEncodedValue, stringListResult.jsonEncodedValue) && this.type == stringListResult.type;
    }

    public final String getJsonEncodedValue() {
        return this.jsonEncodedValue;
    }

    public final StringListLookupResultType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.jsonEncodedValue;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode();
    }

    public final List<Object> toList() {
        return AbstractC2595q.l(this.jsonEncodedValue, this.type);
    }

    public String toString() {
        return "StringListResult(jsonEncodedValue=" + this.jsonEncodedValue + ", type=" + this.type + ")";
    }

    public /* synthetic */ StringListResult(String str, StringListLookupResultType stringListLookupResultType, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? null : str, stringListLookupResultType);
    }
}
