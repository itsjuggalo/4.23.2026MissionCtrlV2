package k7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20452a;

    public c(List missingFields, String serialName) {
        StringBuilder sb;
        String str;
        AbstractC2304t.f(missingFields, "missingFields");
        AbstractC2304t.f(serialName, "serialName");
        if (missingFields.size() == 1) {
            sb = new StringBuilder();
            sb.append("Field '");
            sb.append((String) missingFields.get(0));
            sb.append("' is required for type with serial name '");
            sb.append(serialName);
            str = "', but it was missing";
        } else {
            sb = new StringBuilder();
            sb.append("Fields ");
            sb.append(missingFields);
            sb.append(" are required for type with serial name '");
            sb.append(serialName);
            str = "', but they were missing";
        }
        sb.append(str);
        this(missingFields, sb.toString(), null);
    }

    public final List a() {
        return this.f20452a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List missingFields, String str, Throwable th) {
        super(str, th);
        AbstractC2304t.f(missingFields, "missingFields");
        this.f20452a = missingFields;
    }
}
